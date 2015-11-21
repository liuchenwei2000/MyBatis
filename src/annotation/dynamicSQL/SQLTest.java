/**
 * 
 */
package annotation.dynamicSQL;

import org.apache.ibatis.jdbc.SQL;

/**
 * SQL 拼接工具类示例
 * <p>
 * 使用字符串拼接的方法构建 SQL 语句非常困难且容易出错，因此 MyBaits 提供了
 * SQL 工具类不再使用字符串拼接的方式，从而简化构造动态 SQL 语句。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年3月13日
 */
public class SQLTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// SQL 工具类会用合适的空格前缀和后缀来构造 SQL 语句。
		SQL sql1 = new SQL() {
			{
				SELECT("id, name as title, isbn");
				FROM("books");
				WHERE("id=1");
			}
		};
		System.out.println("【sql1】\n" + sql1.toString());
		
		// 一个更复杂的 SQL 语句构造过程
		SQL sql2 = new SQL() {
			{
				SELECT("T0.id, T0.name, T1.id, T1.name");
				SELECT("T1.email, T1.address, T1.contact");
				FROM("books T0");
				LEFT_OUTER_JOIN("student T1 on T0.id=T1.bid");
				WHERE("T0.price > 10");
				ORDER_BY("price desc");
			}
		};
		System.out.println("【sql2】\n" + sql2.toString());
		
		// INSERT 语句示例
		SQL sql3 = new SQL() {
			{
				INSERT_INTO("books");
				VALUES("name", "Tom");
				VALUES("isbn", "127787681");
			}
		};
		System.out.println("【sql3】\n" + sql3.toString());
		
		// UPDATE 语句示例
		SQL sql4 = new SQL() {
			{
				UPDATE("books");
				SET("name='hello'");
				WHERE("id=1");
			}
		};
		System.out.println("【sql4】\n" + sql4.toString());

		// DELETE 语句示例
		SQL sql5 = new SQL() {
			{
				DELETE_FROM("books");
				WHERE("id=1");
			}
		};
		System.out.println("【sql5】\n" + sql5.toString());
	}
}
