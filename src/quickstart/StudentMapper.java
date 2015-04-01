/**
 * 
 */
package quickstart;

import java.util.List;

/**
 * 示例
 * <p>
 * 映射器 Mapper 接口，其定义的方法签名和在 StudentMapper.xml 中定义的 id 的值相同。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年2月9日
 */
public interface StudentMapper {

	public List<Student> findAllStudents();

	public Student findStudentById(Integer id);

	public void insertStudent(Student student);
}
