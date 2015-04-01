/**
 * 
 */
package annotation.dynamicSQL.crud;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import annotation.dynamicSQL.Customer.Gender;

/**
 * SELECT ����ṩ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��3��13��
 */
public class CustomerSelectProvider {
	
	/**
	 * ��̬ SQL provider �������Խ�����������һ�ֲ�����
	 * ��ӳ���� Mapper �ӿڵķ���ͬ���͵Ĳ���;
	 * �޲���;
	 * java.util.Map��
	 */

	public String findCustomerByGender(Gender gender) {// ��ӳ���� Mapper �ӿڵķ���ͬ���͵Ĳ���
		// ��ͳSQLƴ�� ģ�⶯̬ SELECT SQL ������
		return "select id, name, gender from customers where gender="
				+ (gender == Gender.MALE ? 0 : 1);
	}
	
	public String findAll() {// �޲���
		// SQL������ ģ�⶯̬ SELECT SQL ������
		return new SQL() {
			{
				SELECT("id, name, gender");
				FROM("customers");
			}

		}.toString();
	}
	
	/**
	 * ���ӳ���� Mapper �ӿ��ж���������������ʹ�ò�������Ϊ java.util.Map �ķ�����Ϊ SQL provider ������
	 * Ȼ��ӳ���� Mapper �ӿڷ������е�����������ᱻ�ŵ� map �У��� param1, param2 �ȵ���Ϊ key�����������������Ϊ value��
	 * Ҳ����ʹ��  0,1,2 ����Ϊ key ֵ��ȡ�����������
	 */
	public String findByCondition(Map<String, Object> map) {// java.util.Map
		final String name = (String) map.get("param1");
		final Gender gender = (Gender) map.get("param2");
		// SQL������ ģ�⶯̬ SELECT SQL ������
		return new SQL() {
			{
				SELECT("id, name, gender");
				FROM("customers");
				WHERE("name='" + name + "' and gender=" + (gender == Gender.MALE ? 0 : 1));
			}

		}.toString();
	}
}
