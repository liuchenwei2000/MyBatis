/**
 * 
 */
package annotation.crud;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import annotation.Author;

/**
 * 基于注解的 Author SQL 语句映射
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年3月12日
 */
public interface AuthorMapper {

	/**
	 * 使用 @Insert 注解来定义一个 INSERT 映射语句，该方法将返回 INSERT 语句执行后影响的行数。
	 */
	@Insert("insert into authors(id, name, email) values(#{id},#{name},#{email})")
	public int insertAuthor(Author author);
	
	/**
	 * 自动生成主键可以使用 @Options 注解的 userGeneratedKeys  和 keyProperty 属性让
	 * 数据库产生 auto_increment 列的值，然后将生成的值设置到输入参数对象的属性中。
	 */
	@Insert("insert into authors(name, email) values(#{name},#{email})")
	// 这里 id 列值将会通过 MySQL 数据库自动生成，并且生成的值将会被设置到 author 对象的 id 属性中。
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public int insertAuthor2(Author author);
	
	/**
	 * 有一些数据库如 Oracle，并不支持 AUTO_INCREMENT 列属性，它使用序列（SEQUENCE）来产生主键的值。 
	 * 可以使用 @SelectKey 注解来为任意 SQL 语句来指定其主键值。
	 */
	@Insert("insert into authors(id, name, email) values(#{id}, #{name},#{email})")
	// 使用 @SelectKey 来生成主键值，并且存储到了 author 对象的 id 属性上。由于设置了before=true，该语句将会在 INSERT 语句之前执行。
	@SelectKey(statement = "SELECT (max(id) + 1) FROM authors", keyProperty = "id", resultType = int.class, before = true)
	public int insertAuthor3(Author author);
	
	
	/**
	 * 使用 @Update 注解来定义一个 UPDATE 映射语句，该方法将返回 UPDATE 语句执行后影响的行数。
	 */
	@Update("update authors set name=#{name}, email=#{email} where id=#{id}")
	public int updateAuthor(Author author);
	
	
	/**
	 * 使用 @Delete 注解来定义一个 DELETE 映射语句，该方法将返回 DELETE 语句执行后影响的行数。
	 */
	@Update("delete from authors where id=#{id}")
	public int deleteAuthor(Author author);
	
	
	/**
	 * 使用 @Select 注解来定义一个 SELECT 映射语句，该方法将返回 SELECT 语句执行后查询到的 Author 对象。
	 * 如果返回了多行结果，将抛出 TooManyResultsException 异常。
	 */
	@Select("select * from authors where id=#{id}")
	public Author findAuthorById(int id);
	
	/**
	 * 方法列表有多个参数时，使用 @Param 注解来定义各自的标识
	 */
	@Select("select * from authors where name=#{name} and email=#{email}")
	public Author findAuthorBy(@Param("name") String name, @Param("email") String email);
}
