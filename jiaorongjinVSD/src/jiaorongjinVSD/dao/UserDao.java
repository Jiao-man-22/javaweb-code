package jiaorongjinVSD.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Cookie;
import jiaorongjinVSD.entity.User;

public class UserDao {
	Connection conn = null;
	PreparedStatement psmt = null;
	boolean flag = false;
	Statement stmt=null;
	ResultSet rs=null;

	//
	public User queryUser(User user) {
		String sql = "select *from userdata where uname=?";
		conn = new ConnDB().getConn();
		User u = new User();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getName());
			ResultSet rs = psmt.executeQuery();
			if (flag = rs.next()) {
				while (rs.next()) {
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("uname"));
					user.setPwd(rs.getString("upwd"));
					user.setGrade(rs.getInt("ugrade"));
					rs.close();
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
		conn = new ConnDB().getConn();
		String sql = "insert into userdata (uname,upwd,ugrade) values(?,?,?) ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getPwd());
			psmt.setInt(3, user.getGrade());
			psmt.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
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
		conn = new ConnDB().getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getPwd());
			psmt.setInt(3, user.getGrade());
			psmt.setInt(4, user.getId());
			psmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return true;

	};
 	public boolean  deleteUserById( int id) {
		conn = new ConnDB().getConn();
		String sql="delete from userdata where id="+id;
		//创建执行语句
		try {
			stmt = conn.createStatement();
			stmt.execute(sql);
			System.out.println("删除完成");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	};
	
	public List<User>queryAllUsers(){
		String sql = "select *from userdata";
		conn = new ConnDB().getConn();
		ArrayList<User> arrayList = new ArrayList<User>();
		try {
			stmt = conn.createStatement();
		    rs = stmt.executeQuery(sql);
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
