/**
 * 
 */
package more.blob;

/**
 * UserPicMapper
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��2��13��
 */
public interface UserPicMapper {

	/**
	 * ����һ��UserPic
	 */
	public void insertUserPic(UserPic userPic);
	
	/**
	 * ����id��ȡUserPic
	 */
	public UserPic getUserPic(int id);
}
