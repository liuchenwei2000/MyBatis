/**
 * 
 */
package more.parameters;

import resultmap.Contact;

/**
 * ContactMapper
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��2��13��
 */
public interface ContactMapper {

	/**
	 * ͨ�� name �� email ����ƥ��� Contact
	 */
	public Contact findContactByCondition(String name, String email);
}
