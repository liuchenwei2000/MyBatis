/**
 * 
 */
package config;

import java.io.IOException;
import java.io.InputStream;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/**
 * ���� SqlSessionFactory �ķ�ʽ
 * <p>
 * MyBatis ��ؼ�����ɲ����� SqlSessionFactory�����Դ��л�ȡ SqlSession����ִ��ӳ��� SQL ��䡣
 * SqlSessionFactory �������ͨ������ XML ��������Ϣ���� Java API ������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��2��9��
 */
public class CreateSqlSessionFactory {
	
	/**
	 * ����XML�����ļ����� SqlSessionFactory
	 */
	@SuppressWarnings("unused")
	public static void createByXML() {
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
			// ��ҪΪÿһ�����ݿⴴ��һ�� SqlSessionFactory
			// ���� SqlSessionFactory ʱ�����û����ȷָ�� environment id�����ʹ��Ĭ�ϵ�  environment
			SqlSessionFactory devSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSessionFactory proSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "production");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * ���� Java API ���� SqlSessionFactory
	 */
	@SuppressWarnings("unused")
	public static void createByJavaAPI() {
		SqlSessionFactory sqlSessionFactory = null;
		try {
			DataSource dataSource = createDataSourceFactory(0).getDataSource();// ����Դ
			TransactionFactory transactionFactory = new JdbcTransactionFactory();// ���������
			Environment environment = new Environment("development", transactionFactory, dataSource);// ���ݿ⻷��
			
			Configuration configuration = new Configuration(environment);// ���ö���
			configuration.getTypeAliasRegistry().registerAlias("contact", Contact.class);// ע�������
			configuration.getTypeHandlerRegistry().register(PhoneNumber.class, PhoneTypeHandler.class);// ע���Զ������ʹ�����
			configuration.setCacheEnabled(true);// ȫ�ֲ�������
			configuration.addMapper(ContactMapper.class);// ע�� Mapper
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private static DataSourceFactory createDataSourceFactory(int type) {
		return type == 0 ? new PooledDataSourceFactory()
				: new JNDIDataSourceFactory();
	}

	private static interface DataSourceFactory {
		
		public DataSource getDataSource();
	}
	
	private static class PooledDataSourceFactory implements DataSourceFactory {

		public DataSource getDataSource() {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/test";
			String username = "test";
			String password = "test";
			return new PooledDataSource(driver, url, username, password);
		}
	}
	
	private static class JNDIDataSourceFactory implements DataSourceFactory {

		public DataSource getDataSource() {
			String jndiName = "java:comp/env/jdbc/MyBatisDemoDS";
			try {
				InitialContext ctx = new InitialContext();
				return (DataSource) ctx.lookup(jndiName);
			} catch (NamingException e) {
				throw new RuntimeException(e);
			}
		}
	}
}