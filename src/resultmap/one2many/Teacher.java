/**
 * 
 */
package resultmap.one2many;

import java.util.List;

/**
 * 教师
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年2月13日
 */
public class Teacher {
	
	private Integer id;
	private String name;
	private String email;
	
	// 每一个 Teacher 可以有多个关联的 Course，这是一种一对多的关系
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
