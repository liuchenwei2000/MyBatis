/**
 * 
 */
package resultmap.one2many;

/**
 * 课程
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年2月12日
 */
public class Course {

	private Integer id;
	private String name;
	private Integer teacher_id;

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

	public Integer getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(Integer teacher_id) {
		this.teacher_id = teacher_id;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
}
