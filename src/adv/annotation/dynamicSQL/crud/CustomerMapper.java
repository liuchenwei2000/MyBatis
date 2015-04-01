/**
 * 
 */
package annotation.dynamicSQL.crud;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import annotation.dynamicSQL.Customer;
import annotation.dynamicSQL.Customer.Gender;

/**
 * CustomerMapper
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年3月13日
 */
public interface CustomerMapper {

	// 使用 @SelectProvider 注解来创建一个简单的 SELECT 映射语句的例子
	// type 属性和 method 属性指定了一个类及其内部的方法，用来提供需要执行的 SQL 语句。
	@SelectProvider(type = CustomerSelectProvider.class, method = "findCustomerByGender")
	public Customer findByGender(Gender gender);// 一个参数
	
	@SelectProvider(type = CustomerSelectProvider.class, method = "findAll")
	public Customer findAllCustomers();// 无参数
	
	@SelectProvider(type = CustomerSelectProvider.class, method = "findByCondition")
	public Customer findByCondition(String name, Gender gender);// 多个参数
	
	// 使用 @InsertProvider 注解创建动态的 INSERT 语句
	@InsertProvider(type = CustomerInsertProvider.class, method = "insertCustomer")
	public int addCustomer(Customer customer);
	
	// 使用 @UpdateProvider 注解创建动态的 UPDATE 语句
	@UpdateProvider(type = CustomerUpdateProvider.class, method = "updateCustomer")
	public int editCustomer(Customer customer);
	
	// 使用 @DeleteProvider 注解创建动态的 DELETE 语句
	@DeleteProvider(type = CustomerDeleteProvider.class, method = "deleteCustomer")
	public int deleteCustomer(Customer customer);
}
