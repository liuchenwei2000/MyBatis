/**
 * 
 */
package more.blob;

/**
 * UserPicMapper
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年2月13日
 */
public interface UserPicMapper {

	/**
	 * 新增一个UserPic
	 */
	public void insertUserPic(UserPic userPic);
	
	/**
	 * 根据id获取UserPic
	 */
	public UserPic getUserPic(int id);
}
