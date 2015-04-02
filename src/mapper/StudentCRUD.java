/**
 * 
 */
package mapper;

import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;

/**
 * ����ӳ���SQL���ʾ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��2��11��
 */
public class StudentCRUD {

	/**
	 * ͨ���ַ�������ʽ����ӳ���SQL��䣬���ַ�ʽ���׳��������Ƽ�ʹ�á�
	 */
	public static void crudByString(Integer studId) {
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			// �ַ���Ϊ mapper�ļ��� namespace + SQL��� id
			Student student = sqlSession.selectOne("mapper.StudentMapper.findStudentById", studId);// ִ��SELECT���
			int count = sqlSession.insert("mapper.StudentMapper.insertStudent", student);// ִ��INSERT��䣬����Ӱ�������
			count = sqlSession.update("mapper.StudentMapper.updateStudent", student);// ִ��UPDATE��䣬����Ӱ�������
			count = sqlSession.delete("mapper.StudentMapper.deleteStudent", student.getStudId());// ִ��DELETE��䣬����Ӱ�������
			System.out.println(count);
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * ͨ��ӳ�����ӿڿ��������Ͱ�ȫ����ʽ���õ���ӳ����䡣
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