/**
 * 
 */
package resultmap;

/**
 * 联系人
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年2月12日
 */
public class Contact {
	
	private Integer id;
	private String name;
	private String email;
	// 每一个 Contact 都有一个关联的 Address，即 contacts表有一个 address 的外键
	private Address address;

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", email=" + email
				+ "]";
	}
}
