/**
 * 
 */
package annotation;

/**
 * Author
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年3月12日
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
