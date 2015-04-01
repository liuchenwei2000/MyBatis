/**
 * 
 */
package resultmap.one2many;

/**
 * 一对多映射的第一种配置方式Mapper
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年2月13日
 */
public interface TeacherMapper_1 {
	
	/**
	 * 根据教师主键获取其全部信息
	 */
	public Teacher findTeacherById(int teacher_id);
}
