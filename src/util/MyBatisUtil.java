/**
 * 
 */
package util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatis������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��2��9��
 */
public class MyBatisUtil {

	private static class SqlSessionFactoryHolder {
		
		// ȫ��Ψһ�� SqlSessionFactory
		private static SqlSessionFactory sqlSessionFactory;
		
		static {
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream("util/mybatis-config.xml");
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	/**
	 * ���� SqlSessionFactory ʵ��
	 */
	public static SqlSessionFactory getSqlSessionFactory() {
		return SqlSessionFactoryHolder.sqlSessionFactory;
	}

	/**
	 * ��ȡһ�����ݿ�����
	 */
	public static SqlSession openSession() {
		return getSqlSessionFactory().openSession();
	}
}