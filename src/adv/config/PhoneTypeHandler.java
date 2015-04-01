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
 * PhoneNumber���ʹ�����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��2��10��
 */
// MyBatis �ṩ�˳����� BaseTypeHandler<T> �����Լ̳д��ഴ���Զ������ʹ�������
public class PhoneTypeHandler extends BaseTypeHandler<PhoneNumber> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			PhoneNumber parameter, JdbcType jdbcType) throws SQLException {
		// ʹ�� ps.setString()�� rs.getString()��������Ϊ phone ���� VARCHAR ���͡�
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
