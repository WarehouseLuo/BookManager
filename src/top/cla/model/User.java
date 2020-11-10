package top.cla.model;

/**
 * 用户类
 * @author 12049
 *
 */
public class User {
	private int id;//用户id
	private String userName;//用户名
	private String passward;//用户密码
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassward() {
		return passward;
	}
	
	public void setPassward(String passward) {
		this.passward = passward;
	}
	
	/**
	 * 有参构造函数
	 * @param userName
	 * @param passward
	 */
	public User(String userName, String passward) {
		super();
		this.userName = userName;
		this.passward = passward;
	}
	
	/**
	 * 无参构造函数
	 */
	public User() {
		super();
	}
}
