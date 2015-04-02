/**
 * 
 */
package more.resultmap;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import resultmap.Contact;

/**
 * �Զ��� ResultHandler ʾ��
 * <p>
 * ��ʱ������������ض���Ŀ����Ҫ�Լ����� SQL ��ѯ��������������ʵ���Զ���� ResultHandler ���κ��Լ��ķ�ʽ����������
 * ��������ѽ����ӳ��� �� contact �� id ��Ϊ key��name ��Ϊ value �� HashMap��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��3��9��
 */
public class IdNameResultHandler implements ResultHandler {
	
	private Map<Integer,String> id_name_map;
	
	public IdNameResultHandler() {
		this.id_name_map = new HashMap<Integer, String>();
	}

	/**
	 * ʵ�ָ÷����Դ����������Բ�ѯ���ص�ÿһ�ж�����ñ��������д���
	 * 
	 * @see org.apache.ibatis.session.ResultHandler#handleResult(org.apache.ibatis.session.ResultContext)
	 */
	@Override
	public void handleResult(ResultContext context) {
		Contact contact = (Contact) context.getResultObject();
		id_name_map.put(contact.getId(), contact.getName());
	}
	
	/**
	 * ���ش����Ľ����
	 */
	public Map<Integer, String> getResultMap() {
		return id_name_map;
	}
}
