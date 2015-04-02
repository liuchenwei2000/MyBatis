/**
 * 
 */
package annotation.dynamicSQL.crud;

import org.apache.ibatis.jdbc.SQL;

import annotation.dynamicSQL.Customer;

/**
 * INSERT ����ṩ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��3��16��
 */
public class CustomerInsertProvider {
	
	public String insertCustomer(final Customer customer) {
		return new SQL() {
			{
				INSERT_INTO("customers");
				if (customer.getName() != null) {
					VALUES("name", customer.getName());
				}
				VALUES("gender", String.valueOf(customer.getGender()));
			}
		}.toString();
	}
}
