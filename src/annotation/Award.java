/**
 * 
 */
package annotation;

/**
 * Award
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年3月12日
 */
public class Award {

	private Integer id;
	private Integer book;
	private String desp;
	
	public Award() {
		super();
	}

	public Award(Integer book, String desp) {
		super();
		this.book = book;
		this.desp = desp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBook() {
		return book;
	}

	public void setBook(Integer book) {
		this.book = book;
	}

	public String getDesp() {
		return desp;
	}

	public void setDesp(String desp) {
		this.desp = desp;
	}

	@Override
	public String toString() {
		return "Award [desp=" + desp + "]";
	}
}
