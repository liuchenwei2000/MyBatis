/**
 * 
 */
package mapper;

/**
 * ӳ���� Mapper �ӿ�
 * <p>
 * MyBatis ͨ��ʹ��ӳ���� Mapper �ӿ��ṩ�˸��õĵ���ӳ�����ķ�����
 * һ��ͨ��ӳ���������ļ�������SQL��䣬�Ϳ��Դ���һ����ȫ��Ӧ��ӳ�����ӿڣ��ӿ����������ļ�����ͬ���ӿ����ڰ�Ҳ�������ļ����ڰ�һ�¡�
 * �� StudentMapper.xml ���ڵİ����� mapper ����Ӧ�Ľӿ������� mapper.StudentMapper.java��
 * ���� StudentMapper.xml �ļ��У���  namespace Ӧ�ø� StudentMapper �ӿڵ���ȫ�޶�������һ�¡�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��2��9��
 */
public interface StudentMapper {

	/**
	 * ӳ�����ӿ��еķ���ǩ��Ҳ��ӳ���������ļ�����ȫ��Ӧ��
	 * ������Ϊ�����ļ��� id ֵ��������������Ϊ parameterType ��Ӧֵ����������ֵ����Ϊ returnType ��Ӧֵ��
	 */
	public Student findStudentById(Integer id);
	
	public int insertStudent(Student student);
	
	public int updateStudent(Student student);
	
	public int deleteStudent(Integer id);
}
