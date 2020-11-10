package top.cla.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
  *  封装连接数据库类
 */
public class DbUtil {
	private String dbUrl = "jdbc:mysql://localhost:3306/db_book";
	private String dbUserName = "root";
	private String dbPassward = "root";
	private String jdbcName = "com.mysql.jdbc.Driver";
	
	/**
	  *  连接数据库方法
	 * @throws Exception 
	 * @return Connection
	 */
	public Connection getCon() throws Exception {
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassward);
		return con;
	}
	
	/**
	 * 断开连接数据库方法
	 */
	public void closeCon(Connection con) throws Exception {
		if(con != null) {
			con.close();
		}
	}
	
//	public static void main(String[] args) {
//		String sql = "select * from t_booktype order by id desc limit 1";
//		DbUtil db = new DbUtil();
//		try {
//			Connection con = db.getCon();
//			PreparedStatement ps = con.prepareStatement(sql);
//			ResultSet result = ps.executeQuery();
//			while(result.next()) {
//				System.out.println(result.getInt("id"));
//			}
//			System.out.println("数据库连接成功！");
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//			System.out.println("数据库连接失败！");
//		}
//	}
}
