/**
 * 
 */
package annotation.resultmap;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;
import annotation.Book;

/**
 * ����ע��Ľ��ӳ��ʹ��ʾ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��3��12��
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
	 * ʹ�ñ�����Ľ��ӳ��
	 */
	private static void testFindAllBooksUsingAlias(){
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			BookMapper mapper = sqlSession.getMapper(BookMapper.class);
			List<Book> books = mapper.findAllBooksUsingAlias();
			System.out.println("books��" + books);
		} finally {
			sqlSession.close();
		}
	}
	
	/** 
	 * ʹ�� @Result ע��Ľ��ӳ��
	 */
	private static void testFindAllBooksUsingResults(){
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			BookMapper mapper = sqlSession.getMapper(BookMapper.class);
			List<Book> books = mapper.findAllBooksUsingResults();
			for (Book book : books) {
				System.out.println("book��" + book);
				System.out.println("awards��" + book.getAwards());
				System.out.println();
			}
		} finally {
			sqlSession.close();
		}
	}
	
	/** 
	 * ʹ�� @Result ע�� �� Mapper �����ļ��Ľ��ӳ��
	 */
	private static void testFindAllBooks(){
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			BookMapper mapper = sqlSession.getMapper(BookMapper.class);
			List<Book> books = mapper.findAllBooks();
			System.out.println("books��" + books);
		} finally {
			sqlSession.close();
		}
	}
}