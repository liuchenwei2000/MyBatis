/**
 * 
 */
package config;

/**
 * 联系人
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年2月10日
 */
public class Contact {

	private Integer id;
	private String name;
	private String email;
	private PhoneNumber phone;

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

	public PhoneNumber getPhone() {
		return phone;
	}

	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}
}
