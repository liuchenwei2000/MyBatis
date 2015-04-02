/**
 * 
 */
package more.resultmap;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import resultmap.Contact;

/**
 * ContactMapper
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年3月9日
 */
public interface ContactMapper {

	public List<Contact> findAllContacts(RowBounds rowBounds);
}
