/**
 * 
 */
package annotation.resultmap;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;
import annotation.Book;

/**
 * 基于注解的结果映射使用示例
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年3月12日
 */
public class BookCRUD {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("*********************testFindAllBooksUsingAlias************************");
		testFindAllBooksUsingAlias();
		System.out.println("*********************testFindAllBooksUsingResults************************");
		testFindAllBooksUsingResults();
		System.out.println("*********************testFindAllBooks************************");
		testFindAllBooks();
	}
	
	/**
	 * 使用表别名的结果映射
	 */
	private static void testFindAllBooksUsingAlias(){
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			BookMapper mapper = sqlSession.getMapper(BookMapper.class);
			List<Book> books = mapper.findAllBooksUsingAlias();
			System.out.println("books：" + books);
		} finally {
			sqlSession.close();
		}
	}
	
	/** 
	 * 使用 @Result 注解的结果映射
	 */
	private static void testFindAllBooksUsingResults(){
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			BookMapper mapper = sqlSession.getMapper(BookMapper.class);
			List<Book> books = mapper.findAllBooksUsingResults();
			for (Book book : books) {
				System.out.println("book：" + book);
				System.out.println("awards：" + book.getAwards());
				System.out.println();
			}
		} finally {
			sqlSession.close();
		}
	}
	
	/** 
	 * 使用 @Result 注解 和 Mapper 配置文件的结果映射
	 */
	private static void testFindAllBooks(){
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			BookMapper mapper = sqlSession.getMapper(BookMapper.class);
			List<Book> books = mapper.findAllBooks();
			System.out.println("books：" + books);
		} finally {
			sqlSession.close();
		}
	}
}
