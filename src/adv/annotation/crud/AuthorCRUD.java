/**
 * 
 */
package annotation.crud;

import org.apache.ibatis.session.SqlSession;

import annotation.Author;
import util.MyBatisUtil;

/**
 * 基于注解的SQL使用示例
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年3月12日
 */
public class AuthorCRUD {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("*********************testInsertAuthor************************");
		testInsertAuthor();
		System.out.println("*********************testInsertAuthor2************************");
		testInsertAuthor2();
		System.out.println("*********************testInsertAuthor3************************");
		testInsertAuthor3();
		System.out.println("*********************testUpdateAuthor************************");
		testUpdateAuthor();
		System.out.println("*********************testDeleteAuthor************************");
		testDeleteAuthor();
		System.out.println("*********************testSelectAuthor************************");
		testSelectAuthor();
	}
	
	/**
	 * 最基本的 INSERT 语句
	 */
	private static void testInsertAuthor(){
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			AuthorMapper mapper = sqlSession.getMapper(AuthorMapper.class);
			Author author = new Author("Bruce Eckel", "be@mindview.com");
			mapper.insertAuthor(author);
			sqlSession.commit();
			System.out.println("author id：" + author.getId());
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * 自动生成主键的 INSERT 语句
	 */
	private static void testInsertAuthor2(){
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			AuthorMapper mapper = sqlSession.getMapper(AuthorMapper.class);
			Author author = new Author("Josh Bloch", "jb@sun.com");
			mapper.insertAuthor2(author);
			sqlSession.commit();
			System.out.println("author id：" + author.getId());
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * 指定主键的 INSERT 语句
	 */
	private static void testInsertAuthor3(){
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			AuthorMapper mapper = sqlSession.getMapper(AuthorMapper.class);
			Author author = new Author("Martin Folwer", "mf@work.com");
			mapper.insertAuthor3(author);
			sqlSession.commit();
			System.out.println("author id：" + author.getId());
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * 基本的 UPDATE 语句
	 */
	private static void testUpdateAuthor(){
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			AuthorMapper mapper = sqlSession.getMapper(AuthorMapper.class);
			Author author = new Author("a", "aa@aaa.com");
			mapper.insertAuthor2(author);
			sqlSession.commit();
			System.out.println("author id：" + author.getId());
			
			author.setName("new name");
			author.setEmail("new_email@mail.com");
			mapper.updateAuthor(author);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * 基本的 DELETE 语句
	 */
	private static void testDeleteAuthor(){
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			AuthorMapper mapper = sqlSession.getMapper(AuthorMapper.class);
			Author author = new Author("b", "bb@bbb.com");
			mapper.insertAuthor2(author);
			sqlSession.commit();
			System.out.println("author id：" + author.getId());
			
			mapper.deleteAuthor(author);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * 基本的 DELETE 语句
	 */
	private static void testSelectAuthor(){
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			AuthorMapper mapper = sqlSession.getMapper(AuthorMapper.class);
			System.out.println("author id=15 is：" + mapper.findAuthorById(15));
		} finally {
			sqlSession.close();
		}
	}
}