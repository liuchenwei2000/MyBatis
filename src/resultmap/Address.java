/**
 * 
 */
package resultmap;

/**
 * 地址
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年2月12日
 */
public class Address {

	private Integer id;
	private String street;
	private String city;
	private String country;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", city=" + city
				+ ", country=" + country + "]";
	}
}
