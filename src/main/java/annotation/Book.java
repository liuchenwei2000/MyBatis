/**
 * 
 */
package annotation;

import java.util.List;

/**
 * Book
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年3月12日
 */
public class Book {

	private Integer id;
	private String title;
	private String isbn;

	private Author author;
	
	private List<Award> awards;
	
	public Book() {
		super();
	}
	
	public Book(String title, String isbn, Author author) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.author = author;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public List<Award> getAwards() {
		return awards;
	}

	public void setAwards(List<Award> awards) {
		this.awards = awards;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", isbn=" + isbn + ", author="
				+ (author == null ? null : author.getName()) + "]";
	}
}
