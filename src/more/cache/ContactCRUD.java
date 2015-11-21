/**
 * 
 */
package more.cache;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.ibatis.session.SqlSession;

import resultmap.Contact;
import util.MyBatisUtil;

/**
 * 一级缓存示例
 * <p>
 * MyBatis 对映射的 SELECT 语句加载的查询结果提供了内建的缓存支持。默认情况下，启用一级缓存，
 * 即如果使用同一个 SqlSession 对象调用了相同的 SELECT 语句，则第二次会直接从缓存中获取结果，而不再查询数据库。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年3月9日
 */
public class ContactCRUD {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("*************selectAllContacts************");
		selectAllContacts();
	}
	
	/**
	 * 演示一级缓存，可见两次查询的结果是一致的，即第二次直接从缓存中获取结果。
	 */
	private static void selectAllContacts() {
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			ContactMapper mapper = sqlSession.getMapper(ContactMapper.class);
			// 第一次 SELECT SQL 的查询结果
			List<Contact> result = mapper.findAllContacts();
			System.out.println("result.size() = " + result.size());
			
			// 休眠10秒，在数据库中手动删除或增加一条记录
			TimeUnit.SECONDS.sleep(10);
			
			// 第一次 SELECT SQL 的查询结果
			result = mapper.findAllContacts();
			System.out.println("result.size() = " + result.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
}
