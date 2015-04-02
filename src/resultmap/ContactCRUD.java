/**
 * 
 */
package resultmap;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;

/**
 * ʹ�ý����ӳ���ʾ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��2��11�� 
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
			// ʹ�� HashMap ��Ϊ�����
			Map<String, Object> contactMap = sqlSession.selectOne(
					"resultmap.ContactMapper.findContactById", id);// ִ��SELECT���
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
			// ʹ�� HashMap ��Ϊ��������ض������ݵ��÷�
			List<Map<String, Object>> students = sqlSession.selectList("resultmap.ContactMapper.findAllContactsMap");
			for (Map<String, Object> map : students) {
				System.out.println("id=" + map.get("ID"));// ע�� key �Ĵ�СдҪ�� Mapper �ļ��е� SQL ��������һ��
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
					"resultmap.ContactMapper.findContactWithAddressById", id);// ִ��SELECT���
			System.out.println("contact=" + contactWithAddress);
			System.out.println("address=" + contactWithAddress.getAddress());
		} finally {
			sqlSession.close();
		}
	}
}