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
 * �����ӳ��ʾ��
 * <p>
 * ���Խ���ѯ���ͨ������������ @Results ע���� JavaBean ����ӳ��������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��3��12��
 */
public interface BookMapper {
	
	/**
	 * ʹ�ñ������н����ӳ��
	 */
	@Select("select id, name as title, isbn from books")
	public List<Book> findAllBooksUsingAlias();

	/**
	 * ʹ�� @Results ע����н����ӳ��
	 */
	@Select("select * from books")
	@Results({
			@Result(id = true, column = "id", property = "id"),
			@Result(column = "name", property = "title"),
			@Result(column = "isbn", property = "isbn"),
			// @One ע�����ʹ��Ƕ�� select ������һ��һ�������ݡ�select ����ָ��һ����ȫ�޶����ķ������÷����᷵��һ�� Author ����
			// ʹ�� column=��author_id������ Books ������ author_id ��ֵ������Ϊ�������� findAddressById()������ 
			// ���@One select ��ѯ�����˶��н��������׳� TooManyResultsException ��
			@Result(column = "author_id", property = "author", one = @One(select = "annotation.crud.AuthorMapper.findAuthorById")),
			// @Many ע���������ʹ��Ƕ�� select ������һ�Զ�������ݡ�select ������ָ��һ����ȫ�޶����Ƶķ������÷���������һ�� List<Award>��
			// ʹ�� column=��id������ Books ���е� id ��ֵ������Ϊ�������� findAwardsByBookId()������
			@Result(column = "id", property = "awards", many = @Many(select = "annotation.AwardMapper.findAwardsByBookId")) })
	public List<Book> findAllBooksUsingResults();
	
	/**
	 * @Results ע���ӳ���� XML �����ļ�Ԫ�� <resultMap> ���Ӧ����������Ϊ @Results ע�⸳��һ�� ID��
	 * ���������� <resultMap> Ԫ�������ܹ������ã�����ζ�ż�ʹ @Results ע����ȫ��ͬ��Ҳ��Ҫ�ظ� @Results ��������
	 * ���Դ���һ�� Mapper XML�����ļ��� �������� <resultMap> Ԫ�أ���ʹ�� @ResultMap ע�����ô� <resultMap> ��
	 */
	@Select("SELECT * FROM STUDENTS WHERE ID=#{id}")
	@ResultMap("annotation.resultmap.ResultMapper.BookResult")
	public Book findBookById(int id);

	@Select("SELECT * FROM BOOKS")
	@ResultMap("annotation.resultmap.ResultMapper.BookResult")
	public List<Book> findAllBooks();
}
