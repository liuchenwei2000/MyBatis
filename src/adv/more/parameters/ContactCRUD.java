/**
 * 
 */
package more.parameters;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import resultmap.Contact;
import util.MyBatisUtil;

/**
 * ���ݶ��������ʾ
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
		System.out.println("*************selectContactByConditionUseMap************");
		selectContactByConditionUseMap();
		System.out.println("*************selectContactByConditionUseParam************");
		selectContactByConditionUseParam();
	}
	
	/**
	 * ͨ��ʹ�� map �ķ�ʽ����������
	 */
	private static void selectContactByConditionUseMap() {
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			
			Map<String, String> params = new HashMap<String, String>();
			params.put("Name", "����");// Map �� key ��Ҫ�� Mapper �ļ��еĲ�������һ�£� #{Name}��
			params.put("Email", "zhangsan@163.com");
			
			Contact contact = sqlSession.selectOne(
					"more.parameters.ContactMapper.findContactByConditionUseMap", params);
			System.out.println("Contact=" + contact);
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * ͨ��ʹ�� #{param} �ķ�ʽ����������
	 */
	private static void selectContactByConditionUseParam() {
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			ContactMapper mapper = sqlSession.getMapper(ContactMapper.class);
			Contact contact = mapper.findContactByCondition("����", "zhangsan@163.com");
			System.out.println("Contact=" + contact);
		} finally {
			sqlSession.close();
		}
	}
}