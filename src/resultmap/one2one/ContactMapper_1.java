/**
 * 
 */
package resultmap.one2one;

import resultmap.Contact;

/**
 * 一对一映射的第一种配置方式Mapper
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年2月12日
 */
public interface ContactMapper_1 {

	/**
	 * 根据联系人主键获取其全部信息
	 * 
	 * @param contact_id
	 *            联系人主键
	 */
	public Contact selectContactWithAddress(int contact_id);
}
