package top.cla.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import top.cla.model.User;

/**
 * �û����ݷ�����(���ݿ�ӿ�)
 * @author 12049
 *
 */
public class UserDao {
	
	/**
	 * �û���¼DAO
	 * ʵ���û���¼�ӿ�
	 * @param con
	 * @param u
	 * @return User
	 * @throws Exception
	 */
	public User login(Connection con,User u) throws Exception {
		User resultUser = null;//Ҫ���ص��û�����
		String sql = "select * from t_user where userName=? and passward=?";//mySQL���
		
		//Ϊ�����������ݿ���׼��
		PreparedStatement ps = con.prepareStatement(sql);
		//��Ҫ��ѯ���û���Ϣƴ����mySQL�����ʺ�֮��
		ps.setString(1, u.getUserName());
		ps.setString(2, u.getPassward());
		
		//ִ��MySQL���
		ResultSet res = ps.executeQuery();
		if(res.next()) {
			resultUser = new User();
			//�����ݿⷵ�ص�����д��Ҫ���ص��û�������
			resultUser.setUserName(res.getString("userName"));
			resultUser.setPassward(res.getString("passward"));
		}
		
		return resultUser;
	}
}
