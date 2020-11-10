package top.cla.model;


/**
 * 书本类型类
 * @author 12049
 *
 */
public class BookType {
	private int id;
	private String bookTypeName;
	private String bookTypeDesc;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getBookTypeName() {
		return bookTypeName;
	}
	
	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
	
	public String getBookTypeDesc() {
		return bookTypeDesc;
	}
	
	public void setBookTypeDesc(String bookTypeDesc) {
		this.bookTypeDesc = bookTypeDesc;
	}
	
	/**
	 * 有参构造函数
	 * @param bookTypeName
	 * @param bookTypeDesc
	 */
	public BookType(String bookTypeName, String bookTypeDesc) {
		super();
		this.bookTypeName = bookTypeName;
		this.bookTypeDesc = bookTypeDesc;
	}
	
	/**
	 * 无参构造函数
	 */
	public BookType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
