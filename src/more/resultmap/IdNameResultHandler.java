/**
 * 
 */
package more.resultmap;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import resultmap.Contact;

/**
 * 自定义 ResultHandler 示例
 * <p>
 * 有时候会遇到由于特定的目的需要自己处理 SQL 查询结果的情况，可以实现自定义的 ResultHandler 以任何自己的方式处理结果集。
 * 本例将会把结果集映射成 以 contact 的 id 作为 key，name 作为 value 的 HashMap。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年3月9日
 */
public class IdNameResultHandler implements ResultHandler {
	
	private Map<Integer,String> id_name_map;
	
	public IdNameResultHandler() {
		this.id_name_map = new HashMap<Integer, String>();
	}

	/**
	 * 实现该方法以处理结果集，对查询返回的每一行都会调用本方法进行处理
	 * 
	 * @see org.apache.ibatis.session.ResultHandler#handleResult(org.apache.ibatis.session.ResultContext)
	 */
	@Override
	public void handleResult(ResultContext context) {
		Contact contact = (Contact) context.getResultObject();
		id_name_map.put(contact.getId(), contact.getName());
	}
	
	/**
	 * 返回处理后的结果集
	 */
	public Map<Integer, String> getResultMap() {
		return id_name_map;
	}
}
