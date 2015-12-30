/**
 * 
 */
package annotation.dynamicSQL.crud;

import org.apache.ibatis.jdbc.SQL;

import annotation.dynamicSQL.Customer;

/**
 * DELETE 语句提供类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年3月16日
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
