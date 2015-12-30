/**
 * 
 */
package resultmap.one2one;

import org.apache.ibatis.session.SqlSession;

import resultmap.Address;
import resultmap.Contact;
import util.MyBatisUtil;

/**
 * 使用三种不同的一对一映射配置进行查询示例
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年2月12日
 */
public class ContactCRUD {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("***************selectByMapper_1*************");
		selectByMapper_1(1);
		System.out.println("***************selectByMapper_2*************");
		selectByMapper_2(1);
		System.out.println("***************selectByMapper_3*************");
		selectByMapper_3(1);
	}
	
	private static void selectByMapper_1(int contact_id) {
		SqlSession session = MyBatisUtil.openSession();
		try {
			ContactMapper_1 mapper = session.getMapper(ContactMapper_1.class);
			Contact contact = mapper.selectContactWithAddress(contact_id);
			System.out.println("Contact=" + contact);
			System.out.println("Address=" + contact.getAddress());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	private static void selectByMapper_2(int contact_id) {
		SqlSession session = MyBatisUtil.openSession();
		try {
			ContactMapper_2 mapper = session.getMapper(ContactMapper_2.class);
			Contact contact = mapper.findContactWithAddress(contact_id);
			System.out.println("Contact=" + contact);
			System.out.println("Address=" + contact.getAddress());
			System.out.println("********findContactByID*******");
			Address address = mapper.findAddressByID(contact_id);
			System.out.println("Address=" + address);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	private static void selectByMapper_3(int contact_id) {
		SqlSession session = MyBatisUtil.openSession();
		try {
			ContactMapper_3 mapper = session.getMapper(ContactMapper_3.class);
			Contact contact = mapper.findContactWithAddress(contact_id);
			System.out.println("Contact=" + contact);
			System.out.println("Address=" + contact.getAddress());
			System.out.println("********findContactByID*******");
			Address address = mapper.findAddressByID(contact_id);
			System.out.println("Address=" + address);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
