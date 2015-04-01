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
 * һ������ʾ��
 * <p>
 * MyBatis ��ӳ��� SELECT �����صĲ�ѯ����ṩ���ڽ��Ļ���֧�֡�Ĭ������£�����һ�����棬
 * �����ʹ��ͬһ�� SqlSession �����������ͬ�� SELECT ��䣬��ڶ��λ�ֱ�Ӵӻ����л�ȡ����������ٲ�ѯ���ݿ⡣
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��3��9��
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
	 * ��ʾһ�����棬�ɼ����β�ѯ�Ľ����һ�µģ����ڶ���ֱ�Ӵӻ����л�ȡ�����
	 */
	private static void selectAllContacts() {
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			ContactMapper mapper = sqlSession.getMapper(ContactMapper.class);
			// ��һ�� SELECT SQL �Ĳ�ѯ���
			List<Contact> result = mapper.findAllContacts();
			System.out.println("result.size() = " + result.size());
			
			// ����10�룬�����ݿ����ֶ�ɾ��������һ����¼
			TimeUnit.SECONDS.sleep(10);
			
			// ��һ�� SELECT SQL �Ĳ�ѯ���
			result = mapper.findAllContacts();
			System.out.println("result.size() = " + result.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
}