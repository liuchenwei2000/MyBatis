/**
 * 
 */
package mapper;

import java.util.Date;

/**
 * POJO
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年2月9日
 */
public class Student {
	
	private Integer studId;
	private String name;
	private String email;
	private Date dob;

	public Integer getStudId() {
		return studId;
	}

	public void setStudId(Integer studId) {
		this.studId = studId;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Student [studId=" + studId + ", name=" + name + ", email="
				+ email + ", dob=" + dob + "]";
	}
}
