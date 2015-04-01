/**
 * 
 */
package annotation.dynamicSQL;

/**
 * Customer
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��3��13��
 */
public class Customer {
	
	public static enum Gender {

		MALE, FEMALE
	}

	private Integer id;
	private String name;
	private int gender;

	public Customer() {
		super();
	}

	public Customer(String name, int gender) {
		super();
		this.name = name;
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

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", gender=" + gender + "]";
	}
}
