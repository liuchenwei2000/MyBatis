/**
 * 
 */
package more.blob;

/**
 * �û�ͼƬ
 * <p>
 * MyBatis �ṩ���ڽ��Ķ� CLOB/BLOB �����е�ӳ�䴦��֧�֡�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��2��13��
 */
public class UserPic {

	private int id;
	private String name;
	
	//  Ĭ������£� MyBatis �� CLOB ����ӳ�䵽 java.lang.String �����ϣ����� BLOB ����ӳ�䵽 byte[] �����ϡ�
	private byte[] pic;// BLOB �ֶ�
	private String bio;// CLOB �ֶ�
	
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
