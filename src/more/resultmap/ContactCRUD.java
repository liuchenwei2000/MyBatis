/**
 * 
 */
package more.resultmap;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import resultmap.Contact;
import util.MyBatisUtil;

/**
 * 多行结果集映射成 Map演示
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年3月9日 
 */
public class ContactCRUD {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("*************selectAllContacts************");
		selectAllContacts();
		System.out.println("*************paginateResultSets************");
		paginateResultSets();
		System.out.println("*************selectAllContactsUseResultHandler************");
		selectAllContactsUseResultHandler();
	}
	
	/**
	 * 查询多条记录到 HashMap
	 */
	private static void selectAllContacts() {
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			
			/*
			 * 如果一个SQL语句返回多行记录，而又想以 HashMap 的形式存储结果集，
			 * 可以将记录的某列值（本例是 id 列）作为 key 值，记录自身作为 value 值。
			 * 然后使用 sqlSession.selectMap()方法进行查询：
			 */
			Map<Integer, Contact> resultMap = 
					sqlSession.selectMap("more.resultmap.ContactMapper.findAllContacts", "id");
			
			for (Integer id : resultMap.keySet()) {
				System.out.print("id=" + id);
				System.out.println("  contact=" + resultMap.get(id));
			}
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * 将多条记录的结果集强制分页
	 */
	private static void paginateResultSets() {
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			
			ContactMapper mapper = sqlSession.getMapper(ContactMapper.class);
			
			/*
			 * 可以使用 RowBounds 逐页加载表数据，RowBounds 对象可以使用 offset 和 limit 参数来构建。
			 * 参数 offset 表示开始位置，而 limit 表示要获取记录的数目。
			 */
			// 前5条数据
			int offset = 0, limit = 5;
			RowBounds rowBounds = new RowBounds(offset, limit);
			List<Contact> page1 = mapper.findAllContacts(rowBounds);
			System.out.println("page1：" + page1);
			// 接下来的5条数据
			offset = 5;
			rowBounds = new RowBounds(offset, limit);
			List<Contact> page2 = mapper.findAllContacts(rowBounds);
			System.out.println("page2：" + page2);
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * 使用自定义 ResultHandler 查询多条记录
	 */
	private static void selectAllContactsUseResultHandler() {
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			
			/*
			 * 通过下面的调用方式使用自定义 ResultHandler
			 */
			IdNameResultHandler handler = new IdNameResultHandler();
			sqlSession.select("more.resultmap.ContactMapper.findAllContacts", handler);
			
			Map<Integer, String> resultMap = handler.getResultMap();
			
			for (Integer id : resultMap.keySet()) {
				System.out.print("id=" + id);
				System.out.println("  name=" + resultMap.get(id));
			}
		} finally {
			sqlSession.close();
		}
	}
}