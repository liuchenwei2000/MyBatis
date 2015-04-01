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
 * 创建 SqlSessionFactory 的方式
 * <p>
 * MyBatis 最关键的组成部分是 SqlSessionFactory，可以从中获取 SqlSession，并执行映射的 SQL 语句。
 * SqlSessionFactory 对象可以通过基于 XML 的配置信息或者 Java API 创建。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年2月9日
 */
public class CreateSqlSessionFactory {
	
	/**
	 * 基于XML配置文件创建 SqlSessionFactory
	 */
	@SuppressWarnings("unused")
	public static void createByXML() {
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
			// 需要为每一个数据库创建一个 SqlSessionFactory
			// 创建 SqlSessionFactory 时，如果没有明确指定 environment id，则会使用默认的  environment
			SqlSessionFactory devSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSessionFactory proSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "production");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 基于 Java API 创建 SqlSessionFactory
	 */
	@SuppressWarnings("unused")
	public static void createByJavaAPI() {
		SqlSessionFactory sqlSessionFactory = null;
		try {
			DataSource dataSource = createDataSourceFactory(0).getDataSource();// 数据源
			TransactionFactory transactionFactory = new JdbcTransactionFactory();// 事务管理器
			Environment environment = new Environment("development", transactionFactory, dataSource);// 数据库环境
			
			Configuration configuration = new Configuration(environment);// 配置对象
			configuration.getTypeAliasRegistry().registerAlias("contact", Contact.class);// 注册类别名
			configuration.getTypeHandlerRegistry().register(PhoneNumber.class, PhoneTypeHandler.class);// 注册自定义类型处理器
			configuration.setCacheEnabled(true);// 全局参数设置
			configuration.addMapper(ContactMapper.class);// 注册 Mapper
			
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