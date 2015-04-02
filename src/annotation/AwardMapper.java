/**
 * 
 */
package annotation;

import java.util.List;

import org.apache.ibatis.annotations.Select;

/**
 * ����ע��� Award SQL ���ӳ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��3��12��
 */
public interface AwardMapper {

	/**
	 * ���� Book id ��ѯ�����е� Award
	 */
	@Select("select * from awards where book_id=#{book_id}")
	public List<Award> findAwardsByBookId(int book_id);
}
