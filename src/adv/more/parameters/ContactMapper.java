/**
 * 
 */
package more.parameters;

import resultmap.Contact;

/**
 * ContactMapper
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年2月13日
 */
public interface ContactMapper {

	/**
	 * 通过 name 和 email 查找匹配的 Contact
	 */
	public Contact findContactByCondition(String name, String email);
}
