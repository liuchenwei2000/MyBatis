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
 * @author ����ΰ
 * 
 * �������ڣ�2015��3��13��
 */
public interface CustomerMapper {

	// ʹ�� @SelectProvider ע��������һ���򵥵� SELECT ӳ����������
	// type ���Ժ� method ����ָ����һ���༰���ڲ��ķ����������ṩ��Ҫִ�е� SQL ��䡣
	@SelectProvider(type = CustomerSelectProvider.class, method = "findCustomerByGender")
	public Customer findByGender(Gender gender);// һ������
	
	@SelectProvider(type = CustomerSelectProvider.class, method = "findAll")
	public Customer findAllCustomers();// �޲���
	
	@SelectProvider(type = CustomerSelectProvider.class, method = "findByCondition")
	public Customer findByCondition(String name, Gender gender);// �������
	
	// ʹ�� @InsertProvider ע�ⴴ����̬�� INSERT ���
	@InsertProvider(type = CustomerInsertProvider.class, method = "insertCustomer")
	public int addCustomer(Customer customer);
	
	// ʹ�� @UpdateProvider ע�ⴴ����̬�� UPDATE ���
	@UpdateProvider(type = CustomerUpdateProvider.class, method = "updateCustomer")
	public int editCustomer(Customer customer);
	
	// ʹ�� @DeleteProvider ע�ⴴ����̬�� DELETE ���
	@DeleteProvider(type = CustomerDeleteProvider.class, method = "deleteCustomer")
	public int deleteCustomer(Customer customer);
}
