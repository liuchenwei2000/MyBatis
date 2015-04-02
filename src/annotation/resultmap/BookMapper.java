/**
 * 
 */
package annotation.resultmap;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import annotation.Book;

/**
 * 结果集映射示例
 * <p>
 * 可以将查询结果通过别名或者是 @Results 注解与 JavaBean 属性映射起来。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年3月12日
 */
public interface BookMapper {
	
	/**
	 * 使用别名进行结果集映射
	 */
	@Select("select id, name as title, isbn from books")
	public List<Book> findAllBooksUsingAlias();

	/**
	 * 使用 @Results 注解进行结果集映射
	 */
	@Select("select * from books")
	@Results({
			@Result(id = true, column = "id", property = "id"),
			@Result(column = "name", property = "title"),
			@Result(column = "isbn", property = "isbn"),
			// @One 注解可以使用嵌套 select 语句加载一对一关联数据。select 属性指定一个完全限定名的方法，该方法会返回一个 Author 对象。
			// 使用 column=”author_id”，则 Books 表中列 author_id 的值将会作为参数传入 findAddressById()方法。 
			// 如果@One select 查询返回了多行结果，则会抛出 TooManyResultsException 。
			@Result(column = "author_id", property = "author", one = @One(select = "annotation.crud.AuthorMapper.findAuthorById")),
			// @Many 注解可以用来使用嵌套 select 语句加载一对多关联数据。select 属性来指定一个完全限定名称的方法，该方法将返回一个 List<Award>。
			// 使用 column=”id”，则 Books 表中的 id 的值将会作为参数传如 findAwardsByBookId()方法。
			@Result(column = "id", property = "awards", many = @Many(select = "annotation.AwardMapper.findAwardsByBookId")) })
	public List<Book> findAllBooksUsingResults();
	
	/**
	 * @Results 注解和映射器 XML 配置文件元素 <resultMap> 相对应，但它不能为 @Results 注解赋予一个 ID。
	 * 所以它不像 <resultMap> 元素那样能够被重用，这意味着即使 @Results 注解完全相同，也需要重复 @Results 的声明。
	 * 可以创建一个 Mapper XML配置文件， 其中配置 <resultMap> 元素，再使用 @ResultMap 注解引用此 <resultMap> 。
	 */
	@Select("SELECT * FROM STUDENTS WHERE ID=#{id}")
	@ResultMap("annotation.resultmap.ResultMapper.BookResult")
	public Book findBookById(int id);

	@Select("SELECT * FROM BOOKS")
	@ResultMap("annotation.resultmap.ResultMapper.BookResult")
	public List<Book> findAllBooks();
}
