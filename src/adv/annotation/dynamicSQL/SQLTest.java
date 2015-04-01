/**
 * 
 */
package annotation.dynamicSQL;

import org.apache.ibatis.jdbc.SQL;

/**
 * SQL ƴ�ӹ�����ʾ��
 * <p>
 * ʹ���ַ���ƴ�ӵķ������� SQL ���ǳ����������׳������ MyBaits �ṩ��
 * SQL �����಻��ʹ���ַ���ƴ�ӵķ�ʽ���Ӷ��򻯹��춯̬ SQL ��䡣
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��3��13��
 */
public class SQLTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// SQL ��������ú��ʵĿո�ǰ׺�ͺ�׺������ SQL ��䡣
		SQL sql1 = new SQL() {
			{
				SELECT("id, name as title, isbn");
				FROM("books");
				WHERE("id=1");
			}
		};
		System.out.println("��sql1��\n" + sql1.toString());
		
		// һ�������ӵ� SQL ��乹�����
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
		System.out.println("��sql2��\n" + sql2.toString());
		
		// INSERT ���ʾ��
		SQL sql3 = new SQL() {
			{
				INSERT_INTO("books");
				VALUES("name", "Tom");
				VALUES("isbn", "127787681");
			}
		};
		System.out.println("��sql3��\n" + sql3.toString());
		
		// UPDATE ���ʾ��
		SQL sql4 = new SQL() {
			{
				UPDATE("books");
				SET("name='hello'");
				WHERE("id=1");
			}
		};
		System.out.println("��sql4��\n" + sql4.toString());

		// DELETE ���ʾ��
		SQL sql5 = new SQL() {
			{
				DELETE_FROM("books");
				WHERE("id=1");
			}
		};
		System.out.println("��sql5��\n" + sql5.toString());
	}
}
