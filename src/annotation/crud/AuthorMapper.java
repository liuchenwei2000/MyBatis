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
 * ����ע��� Author SQL ���ӳ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��3��12��
 */
public interface AuthorMapper {

	/**
	 * ʹ�� @Insert ע��������һ�� INSERT ӳ����䣬�÷��������� INSERT ���ִ�к�Ӱ���������
	 */
	@Insert("insert into authors(id, name, email) values(#{id},#{name},#{email})")
	public int insertAuthor(Author author);
	
	/**
	 * �Զ�������������ʹ�� @Options ע��� userGeneratedKeys  �� keyProperty ������
	 * ���ݿ���� auto_increment �е�ֵ��Ȼ�����ɵ�ֵ���õ������������������С�
	 */
	@Insert("insert into authors(name, email) values(#{name},#{email})")
	// ���� id ��ֵ����ͨ�� MySQL ���ݿ��Զ����ɣ��������ɵ�ֵ���ᱻ���õ� author ����� id �����С�
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public int insertAuthor2(Author author);
	
	/**
	 * ��һЩ���ݿ��� Oracle������֧�� AUTO_INCREMENT �����ԣ���ʹ�����У�SEQUENCE��������������ֵ�� 
	 * ����ʹ�� @SelectKey ע����Ϊ���� SQL �����ָ��������ֵ��
	 */
	@Insert("insert into authors(id, name, email) values(#{id}, #{name},#{email})")
	// ʹ�� @SelectKey ����������ֵ�����Ҵ洢���� author ����� id �����ϡ�����������before=true������佫���� INSERT ���֮ǰִ�С�
	@SelectKey(statement = "SELECT (max(id) + 1) FROM authors", keyProperty = "id", resultType = int.class, before = true)
	public int insertAuthor3(Author author);
	
	
	/**
	 * ʹ�� @Update ע��������һ�� UPDATE ӳ����䣬�÷��������� UPDATE ���ִ�к�Ӱ���������
	 */
	@Update("update authors set name=#{name}, email=#{email} where id=#{id}")
	public int updateAuthor(Author author);
	
	
	/**
	 * ʹ�� @Delete ע��������һ�� DELETE ӳ����䣬�÷��������� DELETE ���ִ�к�Ӱ���������
	 */
	@Update("delete from authors where id=#{id}")
	public int deleteAuthor(Author author);
	
	
	/**
	 * ʹ�� @Select ע��������һ�� SELECT ӳ����䣬�÷��������� SELECT ���ִ�к��ѯ���� Author ����
	 * ��������˶��н�������׳� TooManyResultsException �쳣��
	 */
	@Select("select * from authors where id=#{id}")
	public Author findAuthorById(int id);
	
	/**
	 * �����б��ж������ʱ��ʹ�� @Param ע����������Եı�ʶ
	 */
	@Select("select * from authors where name=#{name} and email=#{email}")
	public Author findAuthorBy(@Param("name") String name, @Param("email") String email);
}
