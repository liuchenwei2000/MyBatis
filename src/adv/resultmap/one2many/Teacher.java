/**
 * 
 */
package resultmap.one2many;

import java.util.List;

/**
 * ��ʦ
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��2��13��
 */
public class Teacher {
	
	private Integer id;
	private String name;
	private String email;
	
	// ÿһ�� Teacher �����ж�������� Course������һ��һ�Զ�Ĺ�ϵ
	private List<Course> courses;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", email=" + email
				+ "]";
	}
}
