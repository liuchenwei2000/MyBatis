/**
 * 
 */
package annotation.dynamicSQL.crud;

import org.apache.ibatis.jdbc.SQL;

import annotation.dynamicSQL.Customer;

/**
 * UPDATE 语句提供类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年3月16日
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
