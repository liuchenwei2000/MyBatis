/**
 * 
 */
package annotation.dynamicSQL.crud;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import annotation.dynamicSQL.Customer.Gender;

/**
 * SELECT 语句提供类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年3月13日
 */
public class CustomerSelectProvider {
	
	/**
	 * 动态 SQL provider 方法可以接收的参数有：
	 * 1，和映射器 Mapper 接口的方法同类型的参数;
	 * 2，无参数;
	 * 3，java.util.Map。
	 */

	public String findCustomerByGender(Gender gender) {// 和映射器 Mapper 接口的方法同类型的参数
		// 传统SQL拼接 模拟动态 SELECT SQL 的生成
		return "select id, name, gender from customers where gender="
				+ (gender == Gender.MALE ? 0 : 1);
	}
	
	public String findAll() {// 无参数
		// SQL工具类 模拟动态 SELECT SQL 的生成
		return new SQL() {
			{
				SELECT("id, name, gender");
				FROM("customers");
			}

		}.toString();
	}
	
	/**
	 * 如果映射器 Mapper 接口有多个输入参数，可以使用参数类型为 java.util.Map 的方法作为 SQL provider 方法。
	 * 然后映射器 Mapper 接口方法所有的输入参数将会被放到 map 中，以 param1, param2 等等作为 key，将输入参数按序作为 value。
	 */
	public String findByCondition(Map<String, Object> map) {// java.util.Map
		final String name = (String) map.get("param1");
		final Gender gender = (Gender) map.get("param2");
		// SQL工具类 模拟动态 SELECT SQL 的生成
		return new SQL() {
			{
				SELECT("id, name, gender");
				FROM("customers");
				WHERE("name='" + name + "' and gender=" + (gender == Gender.MALE ? 0 : 1));
			}

		}.toString();
	}
}
