/**
 * 
 */
package resultmap.one2one;

import resultmap.Contact;

/**
 * һ��һӳ��ĵ�һ�����÷�ʽMapper
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��2��12��
 */
public interface ContactMapper_1 {

	/**
	 * ������ϵ��������ȡ��ȫ����Ϣ
	 * 
	 * @param contact_id
	 *            ��ϵ������
	 */
	public Contact selectContactWithAddress(int contact_id);
}
