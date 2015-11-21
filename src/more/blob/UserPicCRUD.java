/**
 * 
 */
package more.blob;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;

/**
 * 持久化 Blob/Clob 类型的字段
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年2月12日
 */
public class UserPicCRUD {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			insertUserPic();
			getUserPic();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 如何将数据插入到 CLOB/BLOB 类型的列上
	 */
	private static void insertUserPic() throws IOException {
		// 读取二进制文件形成 byte[]
		InputStream is = null;
		byte[] pic = null;
		try {
			is = new FileInputStream(new File("files/cross.png"));
			pic = new byte[is.available()];
			is.read(pic);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				is.close();
			}
		}
		
		String bio = "this is a very very big text";
		UserPic userPic = new UserPic("Tom", pic, bio);
		
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			UserPicMapper mapper = sqlSession.getMapper(UserPicMapper.class);
			mapper.insertUserPic(userPic);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * 将 CLOB 类型数据读取到 String 类型，BLOB 类型数据读取成 byte[]属性。
	 */
	private static void getUserPic() throws IOException {
		UserPic userPic = null;
		SqlSession sqlSession = MyBatisUtil.openSession();
		try {
			UserPicMapper mapper = sqlSession.getMapper(UserPicMapper.class);
			userPic = mapper.getUserPic(1);
		} finally {
			sqlSession.close();
		}
		
		System.out.println("CLOB From DB=" + userPic.getBio());
		OutputStream os = null;
		byte[] pic = userPic.getPic();
		try {
			os = new FileOutputStream(new File("files/UserImage_FromDB.png"));
			os.write(pic);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				os.close();
			}
		}
	}
}
