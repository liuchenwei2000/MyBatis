/**
 * 
 */
package more.enums;

/**
 * 医生
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年2月13日
 */
public class Doctor {

	private Integer id;
	private String name;
	private String email;
	private Gender gender;

	public Doctor() {
		super();
	}

	public Doctor(String name, String email, Gender gender) {
		super();
		this.name = name;
		this.email = email;
		this.gender = gender;
	}

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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", email=" + email
				+ ", gender=" + gender + "]";
	}
}
