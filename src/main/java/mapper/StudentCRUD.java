/**
 * 
 */
package mapper;

import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;

/**
 * 调用映射的SQL语句示例
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年2月11日
 */
public class StudentCRUD {

	/**
	 * 通过字符串的形式调用映射的SQL语句，这种方式容易出错，不再推荐使用。
	 */
	public static void crudByString(Integer studId) {
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			// 字符串为 mapper文件的 namespace + SQL语句 id
			Student student = sqlSession.selectOne("mapper.StudentMapper.findStudentById", studId);// 执行SELECT语句
			int count = sqlSession.insert("mapper.StudentMapper.insertStudent", student);// 执行INSERT语句，返回影响的行数
			count = sqlSession.update("mapper.StudentMapper.updateStudent", student);// 执行UPDATE语句，返回影响的行数
			count = sqlSession.delete("mapper.StudentMapper.deleteStudent", student.getStudId());// 执行DELETE语句，返回影响的行数
			System.out.println(count);
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * 通过映射器接口可以以类型安全的形式调用调用映射语句。
	 */
	public static void crudByMapperInterface(Integer studId) {
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			Student student = studentMapper.findStudentById(studId);
			studentMapper.insertStudent(student);
			studentMapper.updateStudent(student);
			studentMapper.deleteStudent(student.getStudId());
		} finally {
			sqlSession.close();
		}
	}
}
