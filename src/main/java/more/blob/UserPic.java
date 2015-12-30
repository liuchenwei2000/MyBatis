/**
 * 
 */
package more.blob;

/**
 * 用户图片
 * <p>
 * MyBatis 提供了内建的对 CLOB/BLOB 类型列的映射处理支持。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年2月13日
 */
public class UserPic {

	private int id;
	private String name;
	
	//  默认情况下， MyBatis 将 CLOB 类型映射到 java.lang.String 类型上，而把 BLOB 类型映射到 byte[] 类型上。
	private byte[] pic;// BLOB 字段
	private String bio;// CLOB 字段
	
	public UserPic() {
		super();
	}
	
	public UserPic(String name, byte[] pic, String bio) {
		super();
		this.name = name;
		this.pic = pic;
		this.bio = bio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
}
