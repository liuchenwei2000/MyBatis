/**
 * 
 */
package resultmap.one2one;

import resultmap.Address;
import resultmap.Contact;

/**
 * һ��һӳ��ĵ��������÷�ʽMapper
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��2��12��
 */
public interface ContactMapper_3 {
	
	/**
	 * ���ݵ�ַ������ȡ��ȫ����Ϣ
	 * 
	 * @param address_id
	 *            ��ַ����
	 */
	public Address findAddressByID(int address_id);

	/**
	 * ������ϵ��������ȡ��ȫ����Ϣ
	 * 
	 * @param contact_id
	 *            ��ϵ������
	 */
	public Contact findContactWithAddress(int contact_id);
}
