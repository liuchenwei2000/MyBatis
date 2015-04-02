/**
 * 
 */
package config;

/**
 * ӳ���� Mapper �ӿ�
 * <p>
 * MyBatis ͨ��ʹ��ӳ���� Mapper �ӿ��ṩ�˸��õĵ���ӳ�����ķ�����
 * һ��ͨ��ӳ���������ļ�������SQL��䣬�Ϳ��Դ���һ����ȫ��Ӧ��ӳ�����ӿڣ��ӿ����������ļ�����ͬ���ӿ����ڰ�Ҳ�������ļ����ڰ�һ�¡�
 * �� ContactMapper.xml ���ڵİ����� mapper ����Ӧ�Ľӿ������� mapper.ContactMapper.java��
 * ���� ContactMapper.xml �ļ��У���  namespace Ӧ�ø� ContactMapper �ӿڵ���ȫ�޶�������һ�¡�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��2��9��
 */
public interface ContactMapper {

	/**
	 * ӳ�����ӿ��еķ���ǩ��Ҳ��ӳ���������ļ�����ȫ��Ӧ��
	 * ������Ϊ�����ļ��� id ֵ��������������Ϊ parameterType ��Ӧֵ����������ֵ����Ϊ returnType ��Ӧֵ��
	 */
	public Contact findContactById(Integer id);
	
	public int insertContact(Contact contact);
	
	public int updateContact(Contact contact);
	
	public int deleteContact(Integer id);
}
