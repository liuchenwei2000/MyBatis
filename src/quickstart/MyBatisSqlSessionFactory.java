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
 * SqlSessionFactory工厂
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年2月9日
 */
public class MyBatisSqlSessionFactory {
	
	// 每个数据库环境应该有且只有一个 SqlSessionFactory 实例，所以采用单例模式。
	private static SqlSessionFactory sqlSessionFactory;

	public static SqlSessionFactory getSqlSessionFactory() {
		if (sqlSessionFactory == null) {
			InputStream inputStream = null;
			try {
				// 使用 mybatis-config.xml 内的信息创建 SqlSessionFactory 对象
				inputStream = Resources.getResourceAsStream("quickstart/mybatis-config.xml");
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return sqlSessionFactory;
	}

	/**
	 * 每一个线程应该有它自己的 SqlSession 实例。
	 * SqlSession 对象实例不是线程安全的，并且不能被共享。
	 */
	public static SqlSession openSession() {
		return getSqlSessionFactory().openSession();
	}
}
