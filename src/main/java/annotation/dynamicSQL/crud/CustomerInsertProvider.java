/**
 * 
 */
package annotation.dynamicSQL.crud;

import org.apache.ibatis.jdbc.SQL;

import annotation.dynamicSQL.Customer;

/**
 * INSERT 语句提供类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年3月16日
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
