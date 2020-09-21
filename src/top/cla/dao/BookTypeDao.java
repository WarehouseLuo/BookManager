package top.cla.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import top.cla.model.BookType;
import top.cla.util.StringUtil;

@SuppressWarnings("unused")
public class BookTypeDao {
	
	/**
	 * ���ͼ����𷽷�
	 * @param con
	 * @param bt
	 * @return int
	 * @throws Exception
	 */
	public int addBookType(Connection con,BookType bt) throws Exception {
		int resultId;
		//MySQL���
		String selectSql = "select * from t_booktype order by id desc limit 1";
		String insertSql = "insert into t_booktype(id,bookTypeName,bookTypeDesc) values (?,?,?)";
		
		//�Ȳ�ѯ���һ����¼��IDֵ
		PreparedStatement prePs = con.prepareStatement(selectSql);
		ResultSet result = prePs.executeQuery();
		if(result.next()) {
			resultId = result.getInt("id");
			resultId++;//ת��Ϊ��ͼ������id
		}else {
			resultId = 1;
		}
		
		//׼����MySQL��䷢�͸����ݿ�ϵͳ
		PreparedStatement ps = con.prepareStatement(insertSql);
		ps.setInt(1, resultId);
		ps.setString(2, bt.getBookTypeName());
		ps.setString(3, bt.getBookTypeDesc());
		
		//ִ��mysql��䣬������
		return ps.executeUpdate();
	}
	
	/**
	 *  ��ѯͼ����𷽷�
	 * @param con
	 * @param bt
	 * @return ResultSet
	 * @throws Exception 
	 */
	public ResultSet selectBookType(Connection con,BookType bt) throws Exception {
		StringBuffer sql = new StringBuffer("select * from t_booktype");//�ȶ������mySQL���
		
		//�����ͼ��������������ͼ��������ģ����ѯ������ֱ�Ӳ�ѯȫ��
		if(!StringUtil.strIsEmpty(bt.getBookTypeName())) {
			sql.append(" where bookTypeName like '%"+ bt.getBookTypeName() +"%'");//��ƴ�Ӻ����������mySQL���
		}
		
		PreparedStatement ps = con.prepareStatement(sql.toString());//�����װ��׼������
		ResultSet result = ps.executeQuery();//ִ�в�ѯmysql���
		
		return result;
	}
	
	/**
	 * ɾ��ָ��idͼ����𷽷�
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean deleteBookType(Connection con,int id) throws Exception {
		String sql = "delete from t_booktype where id=?";//����mysql���
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		int result = ps.executeUpdate();
		//�ж��Ƿ�ɾ���ɹ�
		if(result > 0) {
			return true;//�������ڵ���һ����¼��ɾ���ɹ�
		}else {
			return false;//����Ϊ������¼��������ɾ��ʧ��
		}
	}
	
	/**
	 * �޸�ָ��idͼ����𷽷�
	 * @param con
	 * @param id
	 * @param bt
	 * @return
	 * @throws Exception
	 */
	public boolean updateBookType(Connection con,int id,BookType bt) throws Exception {
		String sql = "update t_booktype set id=?,bookTypeName=?,bookTypeDesc=? where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, bt.getId());
		ps.setString(2,bt.getBookTypeName());
		ps.setString(3, bt.getBookTypeDesc());
		ps.setInt(4, id);
		int result = ps.executeUpdate();
		//�ж��Ƿ�ɾ���ɹ�
		if(result > 0) {
			return true;//�������ڵ���һ����¼��ɾ���ɹ�
		}else {
			return false;//����Ϊ������¼��������ɾ��ʧ��
		}
	}
}