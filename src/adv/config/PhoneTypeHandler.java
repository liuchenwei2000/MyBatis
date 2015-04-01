/**
 * 
 */
package config;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * PhoneNumber类型处理器
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年2月10日
 */
// MyBatis 提供了抽象类 BaseTypeHandler<T> ，可以继承此类创建自定义类型处理器。
public class PhoneTypeHandler extends BaseTypeHandler<PhoneNumber> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			PhoneNumber parameter, JdbcType jdbcType) throws SQLException {
		// 使用 ps.setString()和 rs.getString()方法是因为 phone 列是 VARCHAR 类型。
		ps.setString(i, parameter.getAsString());
	}

	@Override
	public PhoneNumber getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		return new PhoneNumber(rs.getString(columnName));
	}

	@Override
	public PhoneNumber getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		return new PhoneNumber(rs.getString(columnIndex));
	}

	@Override
	public PhoneNumber getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		return new PhoneNumber(cs.getString(columnIndex));
	}
}
