/**
 * 
 */
package quickstart;

import java.util.List;

/**
 * ʾ��
 * <p>
 * ӳ���� Mapper �ӿڣ��䶨��ķ���ǩ������ StudentMapper.xml �ж���� id ��ֵ��ͬ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��2��9��
 */
public interface StudentMapper {

	public List<Student> findAllStudents();

	public Student findStudentById(Integer id);

	public void insertStudent(Student student);
}
