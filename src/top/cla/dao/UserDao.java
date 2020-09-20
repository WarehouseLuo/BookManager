package top.cla.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import top.cla.model.User;

/**
 * 用户数据访问类(数据库接口)
 * @author 12049
 *
 */
public class UserDao {
	
	/**
	 * 用户登录DAO
	 * 实现用户登录接口
	 * @param con
	 * @param u
	 * @return User
	 * @throws Exception
	 */
	public User login(Connection con,User u) throws Exception {
		User resultUser = null;//要返回的用户对象
		String sql = "select * from t_user where userName=? and passward=?";//mySQL语句
		
		//为发送语句给数据库做准备
		PreparedStatement ps = con.prepareStatement(sql);
		//将要查询的用户信息拼接入mySQL语句的问号之中
		ps.setString(1, u.getUserName());
		ps.setString(2, u.getPassward());
		
		//执行MySQL语句
		ResultSet res = ps.executeQuery();
		if(res.next()) {
			resultUser = new User();
			//将数据库返回的数据写入要返回的用户对象中
			resultUser.setUserName(res.getString("userName"));
			resultUser.setPassward(res.getString("passward"));
		}
		
		return resultUser;
	}
}
