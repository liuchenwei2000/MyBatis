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
 * �־û� Blob/Clob ���͵��ֶ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��2��12��
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
	 * ��ν����ݲ��뵽 CLOB/BLOB ���͵�����
	 */
	private static void insertUserPic() throws IOException {
		// ��ȡ�������ļ��γ� byte[]
		InputStream is = null;
		byte[] pic = null;
		try {
			is = new FileInputStream(new File("files/cross.png"));
			pic = new byte[is.available()];
			is.read(pic);
			is.close();
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
	 * �� CLOB �������ݶ�ȡ�� String ���ͣ�BLOB �������ݶ�ȡ�� byte[]���ԡ�
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
