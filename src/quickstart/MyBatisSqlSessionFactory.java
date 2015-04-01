/**
 * 
 */
package quickstart;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * SqlSessionFactory����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��2��9��
 */
public class MyBatisSqlSessionFactory {
	
	// ÿ�����ݿ⻷��Ӧ������ֻ��һ�� SqlSessionFactory ʵ�������Բ��õ���ģʽ��
	private static SqlSessionFactory sqlSessionFactory;

	public static SqlSessionFactory getSqlSessionFactory() {
		if (sqlSessionFactory == null) {
			InputStream inputStream = null;
			try {
				// ʹ�� mybatis-config.xml �ڵ���Ϣ���� SqlSessionFactory ����
				inputStream = Resources.getResourceAsStream("quickstart/mybatis-config.xml");
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return sqlSessionFactory;
	}

	/**
	 * ÿһ���߳�Ӧ�������Լ��� SqlSession ʵ����
	 * SqlSession ����ʵ�������̰߳�ȫ�ģ����Ҳ��ܱ�����
	 */
	public static SqlSession openSession() {
		return getSqlSessionFactory().openSession();
	}
}