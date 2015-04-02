/**
 * 
 */
package mapper;

/**
 * 映射器 Mapper 接口
 * <p>
 * MyBatis 通过使用映射器 Mapper 接口提供了更好的调用映射语句的方法。
 * 一旦通过映射器配置文件配置了SQL语句，就可以创建一个完全对应的映射器接口，接口名和配置文件名相同，接口所在包也跟配置文件所在包一致。
 * 如 StudentMapper.xml 所在的包名是 mapper ，对应的接口名就是 mapper.StudentMapper.java。
 * 而在 StudentMapper.xml 文件中，其  namespace 应该跟 StudentMapper 接口的完全限定名保持一致。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年2月9日
 */
public interface StudentMapper {

	/**
	 * 映射器接口中的方法签名也跟映射器配置文件中完全对应：
	 * 方法名为配置文件中 id 值；方法参数类型为 parameterType 对应值；方法返回值类型为 returnType 对应值。
	 */
	public Student findStudentById(Integer id);
	
	public int insertStudent(Student student);
	
	public int updateStudent(Student student);
	
	public int deleteStudent(Integer id);
}
