/**
 * 
 */
package resultmap.one2one;

import resultmap.Address;
import resultmap.Contact;

/**
 * 一对一映射的第三种配置方式Mapper
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年2月12日
 */
public interface ContactMapper_3 {
	
	/**
	 * 根据地址主键获取其全部信息
	 * 
	 * @param address_id
	 *            地址主键
	 */
	public Address findAddressByID(int address_id);

	/**
	 * 根据联系人主键获取其全部信息
	 * 
	 * @param contact_id
	 *            联系人主键
	 */
	public Contact findContactWithAddress(int contact_id);
}
