/**
 * 
 */
package annotation.dynamicSQL.crud;

import org.apache.ibatis.jdbc.SQL;

import annotation.dynamicSQL.Customer;

/**
 * DELETE ����ṩ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��3��16��
 */
public class CustomerDeleteProvider {
	
	public String deleteCustomer(final Customer customer) {
		return new SQL() {
			{
				DELETE_FROM("customers");
				WHERE("id={#id}");
			}
		}.toString();
	}
}
