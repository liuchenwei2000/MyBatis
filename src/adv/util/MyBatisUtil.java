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
 * MyBatis工具类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年2月9日
 */
public class MyBatisUtil {

	private static class SqlSessionFactoryHolder {
		
		// 全局唯一的 SqlSessionFactory
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
	 * 返回 SqlSessionFactory 实例
	 */
	public static SqlSessionFactory getSqlSessionFactory() {
		return SqlSessionFactoryHolder.sqlSessionFactory;
	}

	/**
	 * 获取一个数据库连接
	 */
	public static SqlSession openSession() {
		return getSqlSessionFactory().openSession();
	}
}