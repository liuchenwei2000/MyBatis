/**
 * 
 */
package quickstart;

import java.util.Date;
import java.util.List;

/**
 * 测试类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年2月9日
 */
public class StudentDAOTest {

	private static StudentDAO studentDAO = new StudentDAO();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("******testFindAllStudents******");
		testFindAllStudents();
		System.out.println("******testFindStudentById******");
		testFindStudentById();
		System.out.println("******testCreateStudent******");
		testCreateStudent();
	}

	private static void testFindAllStudents() {
		List<Student> students = studentDAO.findAllStudents();
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private static void testFindStudentById() {
		Student student = studentDAO.findStudentById(1);
		System.out.println(student);
	}

	private static void testCreateStudent() {
		Student student = new Student();
		int id = (int) (Math.random()*100);
		student.setStudId(id);
		student.setName("student_" + id);
		student.setEmail("student_" + id + "gmail.com");
		student.setDob(new Date());
		studentDAO.createStudent(student);
		Student newStudent = studentDAO.findStudentById(id);
		System.out.println(newStudent);
	}
}
