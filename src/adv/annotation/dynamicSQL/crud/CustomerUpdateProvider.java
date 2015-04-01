/**
 * 
 */
package annotation.dynamicSQL.crud;

import org.apache.ibatis.jdbc.SQL;

import annotation.dynamicSQL.Customer;

/**
 * UPDATE ����ṩ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��3��16��
 */
public class CustomerUpdateProvider {
	
	public String updateCustomer(final Customer customer) {
		return new SQL() {
			{
				UPDATE("customers");
				if (customer.getName() != null) {
					SET("name=#{name}");
				}
				SET("gender=#{gender}");
				WHERE("id=#{id}");
			}
		}.toString();
	}
}
