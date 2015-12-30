/**
 * 
 */
package resultmap;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;

/**
 * 使用结果集映射的示例
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年2月11日 
 */
public class ContactCRUD {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		selectContactById(1);
		System.out.println("*************************************************");
		selectContacts();
		System.out.println("*************************************************");
		selectContactWithAddressById(1);
	}
	
	private static void selectContactById(Integer id) {
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			// 使用 HashMap 作为结果集
			Map<String, Object> contactMap = sqlSession.selectOne(
					"resultmap.ContactMapper.findContactById", id);// 执行SELECT语句
			System.out.println("id=" + contactMap.get("id"));
			System.out.println("name=" + contactMap.get("name"));
			System.out.println("email=" + contactMap.get("email"));
		} finally {
			sqlSession.close();
		}
	}
	
	private static void selectContacts() {
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			// 使用 HashMap 作为结果集返回多行数据的用法
			List<Map<String, Object>> students = sqlSession.selectList("resultmap.ContactMapper.findAllContactsMap");
			for (Map<String, Object> map : students) {
				System.out.println("id=" + map.get("ID"));// 注意 key 的大小写要和 Mapper 文件中的 SQL 列名保持一致
				System.out.println("name=" + map.get("NAME"));
				System.out.println("email=" + map.get("EMAIL"));
			}
		} finally {
			sqlSession.close();
		}
	}
	
	private static void selectContactWithAddressById(Integer id) {
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			Contact contactWithAddress = sqlSession.selectOne(
					"resultmap.ContactMapper.findContactWithAddressById", id);// 执行SELECT语句
			System.out.println("contact=" + contactWithAddress);
			System.out.println("address=" + contactWithAddress.getAddress());
		} finally {
			sqlSession.close();
		}
	}
}
