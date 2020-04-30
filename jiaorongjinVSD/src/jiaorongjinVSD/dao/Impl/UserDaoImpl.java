package jiaorongjinVSD.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Cookie;

import DBUtil.DBUtil;
import jiaorongjinVSD.dao.ConnDB;
import jiaorongjinVSD.dao.IUserDao;
import jiaorongjinVSD.entity.User;

public class UserDaoImpl implements IUserDao {
	Connection conn = null;
	PreparedStatement psmt = null;
	boolean flag = false;
	Statement stmt=null;
	ResultSet rs=null;

	//
	public User queryUser(User user) {
		String sql = "select *from userdata where uname=?";
		try {
			Object[] ob= {user.getName()};
			rs=DBUtil.queryExecute(sql, ob);
			if (flag = rs.next()) {
				while (rs.next()) {
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("uname"));
					user.setPwd(rs.getString("upwd"));
					user.setGrade(rs.getInt("ugrade"));
					
				}
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public boolean addUser(User user) {
		String sql = "insert into userdata (uname,upwd,ugrade) values(?,?,?) ";
		try {
			//数组不能和对象搞混
			Object[] ob= {user.getName(),user.getPwd(),user.getGrade()};
			flag=DBUtil.executeUpdate(sql,ob);
			System.out.println(flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public User queryUser(int id) {
		String sql = "select *from userdata where id=?";
		conn = new ConnDB().getConn();
		User user = new User();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();
			System.out.println("进入dao层，执行原子方法");
			while (rs.next()) {
				user.setName(rs.getString("uname"));
				user.setPwd(rs.getString("upwd"));
				user.setGrade(rs.getInt("ugrade"));
				user.setId(rs.getInt("id"));
				System.out.println("数据库返回数据");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
		return user;

	}

	public boolean updateUserById(int id, User user) {
		String sql = "update userdata set uname=?, upwd=?, ugrade=? where id=?";
		
		try {
			Object[] ob= {user.getName(),user.getPwd(),user.getGrade(),user.getId()};
			DBUtil.executeUpdate(sql,ob);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return true;

	};
 	public boolean  deleteUserById( int id) {
	
		String sql="delete from userdata where id=?";
		//创建执行语句
		try {
			Object[] ob= {id};
			DBUtil.executeUpdate(sql, ob);
			System.out.println("删除完成");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	};
	
	public List<User> queryAllUsers(){
		String sql = "select *from userdata";
		ArrayList  <User>arrayList = new ArrayList<User> ();
		try {
			rs=DBUtil.queryExecute(sql);
			while (rs.next()) {
				User u = new User();
				u.setName(rs.getString("uname"));
				u.setPwd(rs.getString("upwd"));
				u.setGrade(rs.getInt("ugrade"));
				u.setId(rs.getInt("id"));
				arrayList.add(u);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arrayList;
		
	}
}
