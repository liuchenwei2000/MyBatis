/**
 * 
 */
package more.parameters;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import resultmap.Contact;
import util.MyBatisUtil;

/**
 * 传递多个参数演示
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年2月11日
 */
public class ContactCRUD {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("*************selectContactByConditionUseMap************");
		selectContactByConditionUseMap();
		System.out.println("*************selectContactByConditionUseParam************");
		selectContactByConditionUseParam();
	}
	
	/**
	 * 通过使用 map 的方式传入多个参数
	 */
	private static void selectContactByConditionUseMap() {
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			
			Map<String, String> params = new HashMap<String, String>();
			params.put("Name", "张三");// Map 的 key 需要和 Mapper 文件中的参数保持一致（ #{Name}）
			params.put("Email", "zhangsan@163.com");
			
			Contact contact = sqlSession.selectOne(
					"more.parameters.ContactMapper.findContactByConditionUseMap", params);
			System.out.println("Contact=" + contact);
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * 通过使用 #{param} 的方式传入多个参数
	 */
	private static void selectContactByConditionUseParam() {
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			ContactMapper mapper = sqlSession.getMapper(ContactMapper.class);
			Contact contact = mapper.findContactByCondition("张三", "zhangsan@163.com");
			System.out.println("Contact=" + contact);
		} finally {
			sqlSession.close();
		}
	}
}