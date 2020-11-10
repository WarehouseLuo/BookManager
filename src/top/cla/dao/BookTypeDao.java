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
	 * 添加图书类别方法
	 * @param con
	 * @param bt
	 * @return int
	 * @throws Exception
	 */
	public int addBookType(Connection con,BookType bt) throws Exception {
		int resultId;
		//MySQL语句
		String selectSql = "select * from t_booktype order by id desc limit 1";
		String insertSql = "insert into t_booktype(id,bookTypeName,bookTypeDesc) values (?,?,?)";
		
		//先查询最后一条记录的ID值
		PreparedStatement prePs = con.prepareStatement(selectSql);
		ResultSet result = prePs.executeQuery();
		if(result.next()) {
			resultId = result.getInt("id");
			resultId++;//转变为新图书类别的id
		}else {
			resultId = 1;
		}
		
		//准备将MySQL语句发送给数据库系统
		PreparedStatement ps = con.prepareStatement(insertSql);
		ps.setInt(1, resultId);
		ps.setString(2, bt.getBookTypeName());
		ps.setString(3, bt.getBookTypeDesc());
		
		//执行mysql语句，并返回
		return ps.executeUpdate();
	}
	
	/**
	 *  查询图书类别方法
	 * @param con
	 * @param bt
	 * @return ResultSet
	 * @throws Exception 
	 */
	public ResultSet selectBookType(Connection con,BookType bt) throws Exception {
		StringBuffer sql = new StringBuffer("select * from t_booktype");//先定义基础mySQL语句
		
		//如果有图书类型名，则按照图书类型名模糊查询，否则直接查询全部
		if(!StringUtil.strIsEmpty(bt.getBookTypeName())) {
			sql.append(" where bookTypeName like '%"+ bt.getBookTypeName() +"%'");//再拼接后面带参数的mySQL语句
		}
		
		PreparedStatement ps = con.prepareStatement(sql.toString());//将语句装入准备对象
		ResultSet result = ps.executeQuery();//执行查询mysql语句
		
		return result;
	}
	
	/**
	 * 删除指定id图书类别方法
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean deleteBookType(Connection con,int id) throws Exception {
		String sql = "delete from t_booktype where id=?";//定义mysql语句
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		int result = ps.executeUpdate();
		//判断是否删除成功
		if(result > 0) {
			return true;//操作大于等于一条记录，删除成功
		}else {
			return false;//操作为零条记录或其他，删除失败
		}
	}
	
	/**
	 * 修改指定id图书类别方法
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
		//判断是否删除成功
		if(result > 0) {
			return true;//操作大于等于一条记录，删除成功
		}else {
			return false;//操作为零条记录或其他，删除失败
		}
	}
}