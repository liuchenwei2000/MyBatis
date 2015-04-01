/**
 * 
 */
package resultmap.one2many;

import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;

/**
 * ʹ�����ֲ�ͬ��һ�Զ�ӳ�����ý��в�ѯʾ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��2��12��
 */
public class TeacherCRUD {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("***************selectByMapper_1*************");
		selectByMapper_1(1);
		System.out.println("***************selectByMapper_2*************");
		selectByMapper_2(1);
	}
	
	private static void selectByMapper_1(int teacher_id) {
		SqlSession session = MyBatisUtil.openSession();
		try {
			TeacherMapper_1 mapper = session.getMapper(TeacherMapper_1.class);
			Teacher teacher = mapper.findTeacherById(teacher_id);
			System.out.println("Teacher=" + teacher);
			System.out.println("Courses=" + teacher.getCourses());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	private static void selectByMapper_2(int teacher_id) {
		SqlSession session = MyBatisUtil.openSession();
		try {
			TeacherMapper_2 mapper = session.getMapper(TeacherMapper_2.class);
			Teacher teacher = mapper.findTeacherById(teacher_id);
			System.out.println("Teacher=" + teacher);
			System.out.println("Courses=" + teacher.getCourses());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
