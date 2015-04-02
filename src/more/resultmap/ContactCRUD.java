/**
 * 
 */
package more.resultmap;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import resultmap.Contact;
import util.MyBatisUtil;

/**
 * ���н����ӳ��� Map��ʾ
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
		System.out.println("*************paginateResultSets************");
		paginateResultSets();
		System.out.println("*************selectAllContactsUseResultHandler************");
		selectAllContactsUseResultHandler();
	}
	
	/**
	 * ��ѯ������¼�� HashMap
	 */
	private static void selectAllContacts() {
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			
			/*
			 * ���һ��SQL��䷵�ض��м�¼���������� HashMap ����ʽ�洢�������
			 * ���Խ���¼��ĳ��ֵ�������� id �У���Ϊ key ֵ����¼������Ϊ value ֵ��
			 * Ȼ��ʹ�� sqlSession.selectMap()�������в�ѯ��
			 */
			Map<Integer, Contact> resultMap = 
					sqlSession.selectMap("more.resultmap.ContactMapper.findAllContacts", "id");
			
			for (Integer id : resultMap.keySet()) {
				System.out.print("id=" + id);
				System.out.println("  contact=" + resultMap.get(id));
			}
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * ��������¼�Ľ����ǿ�Ʒ�ҳ
	 */
	private static void paginateResultSets() {
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			
			ContactMapper mapper = sqlSession.getMapper(ContactMapper.class);
			
			/*
			 * ����ʹ�� RowBounds ��ҳ���ر����ݣ�RowBounds �������ʹ�� offset �� limit ������������
			 * ���� offset ��ʾ��ʼλ�ã��� limit ��ʾҪ��ȡ��¼����Ŀ��
			 */
			// ǰ5������
			int offset = 0, limit = 5;
			RowBounds rowBounds = new RowBounds(offset, limit);
			List<Contact> page1 = mapper.findAllContacts(rowBounds);
			System.out.println("page1��" + page1);
			// ��������5������
			offset = 5;
			rowBounds = new RowBounds(offset, limit);
			List<Contact> page2 = mapper.findAllContacts(rowBounds);
			System.out.println("page2��" + page2);
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * ʹ���Զ��� ResultHandler ��ѯ������¼
	 */
	private static void selectAllContactsUseResultHandler() {
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			
			/*
			 * ͨ������ĵ��÷�ʽʹ���Զ��� ResultHandler
			 */
			IdNameResultHandler handler = new IdNameResultHandler();
			sqlSession.select("more.resultmap.ContactMapper.findAllContacts", handler);
			
			Map<Integer, String> resultMap = handler.getResultMap();
			
			for (Integer id : resultMap.keySet()) {
				System.out.print("id=" + id);
				System.out.println("  name=" + resultMap.get(id));
			}
		} finally {
			sqlSession.close();
		}
	}
}