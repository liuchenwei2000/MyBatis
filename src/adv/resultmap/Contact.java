/**
 * 
 */
package resultmap;

/**
 * ��ϵ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��2��12��
 */
public class Contact {
	
	private Integer id;
	private String name;
	private String email;
	// ÿһ�� Contact ����һ�������� Address���� contacts����һ�� address �����
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
