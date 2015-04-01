/**
 * 
 */
package annotation;

import java.util.List;

import org.apache.ibatis.annotations.Select;

/**
 * 基于注解的 Award SQL 语句映射
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年3月12日
 */
public interface AwardMapper {

	/**
	 * 根据 Book id 查询其所有的 Award
	 */
	@Select("select * from awards where book_id=#{book_id}")
	public List<Award> findAwardsByBookId(int book_id);
}
