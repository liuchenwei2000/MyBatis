/**
 * 
 */
package annotation;

/**
 * Author
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��3��12��
 */
public class Author {

	private Integer id;
	private String name;
	private String email;

	public Author() {
		super();
	}

	public Author(String name, String email) {
		super();
		this.name = name;
		this.email = email;
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

	@Override
	public String toString() {
		return "Author [name=" + name + ", email=" + email + "]";
	}
}
