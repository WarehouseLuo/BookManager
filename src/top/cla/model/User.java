package top.cla.model;

/**
 * �û���
 * @author 12049
 *
 */
public class User {
	private int id;//�û�id
	private String userName;//�û���
	private String passward;//�û�����
	
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
	 * �вι��캯��
	 * @param userName
	 * @param passward
	 */
	public User(String userName, String passward) {
		super();
		this.userName = userName;
		this.passward = passward;
	}
	
	/**
	 * �޲ι��캯��
	 */
	public User() {
		super();
	}
}
