/**
 * 
 */
package more.enums;

import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;

/**
 * 持久化 enum 类型的字段 
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年2月12日
 */
public class DoctorCRUD {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SqlSession session = MyBatisUtil.openSession();
		try {
			DoctorMapper mapper = session.getMapper(DoctorMapper.class);
			mapper.insertDoctor(new Doctor("Tom Green", "tom@gmail.com", Gender.FEMALE));
			session.commit();
			System.out.println("Doctor has been inserted.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
