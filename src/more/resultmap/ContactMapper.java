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
 * @author ����ΰ
 * 
 * �������ڣ�2015��3��9��
 */
public interface ContactMapper {

	public List<Contact> findAllContacts(RowBounds rowBounds);
}
