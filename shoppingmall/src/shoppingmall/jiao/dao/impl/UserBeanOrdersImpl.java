package shoppingmall.jiao.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import shoppingmall.jiao.DBUtils.ConnDB;
import shoppingmall.jiao.dao.IUserBeanOrders;
import shoppingmall.jiao.entity.UserBean;

public class UserBeanOrdersImpl implements IUserBeanOrders {
	ConnDB connBD = new ConnDB();
	Connection conn = null;
	PreparedStatement pmst = null;
	boolean flag = false;
	public UserBean ub = null;
	private ResultSet rs = null;

	@Override
	public boolean addUser(String name, String password, int grade) {
		// TODO Auto-generated method stub
		String sql = "insert into users (username,passwd,grade) values(?,?,?) ";
		conn = connBD.getConn();
		try {
			pmst = conn.prepareStatement(sql);
			pmst.setObject(1, name);
			pmst.setObject(2, password);
			pmst.setObject(3, grade);
			flag = pmst.execute();
			System.out.println("����ɹ�");
			return flag;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(flag);
		return flag;

	}

	@Override
	public boolean deleteUser(String name) {
		// TODO Auto-generated method stub
		String sql = "delete from users where username=?";
		conn = connBD.getConn();
		try {
			pmst = conn.prepareStatement(sql);
			pmst.setObject(1, name);
			flag = pmst.execute();
			System.out.println("ɾ���ɹ�");
			return flag;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}
	//���²�����where clause Ϊ�� ����Ҫ�������ݿⰲȫ�ȼ�
	@Override
	public boolean updateUser(String newname, String password, int grade,String oldername ) {
		// TODO Auto-generated method stub
		String sql = "update users set username=?, passwd=?, grade=? where username=?";
		conn = connBD.getConn();
		try {
			pmst = conn.prepareStatement(sql);
			pmst.setObject(1, newname);
			pmst.setObject(2, password);
			pmst.setObject(3, grade);
			pmst.setObject(4, oldername);
			flag = pmst.execute();
			System.out.print("���³ɹ�");
			return flag;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}
	
	@Override
	public UserBean queryUserByName(String name) {
		String sql = "select *from users where username=?";
		conn = connBD.getConn();
		try {
			pmst = conn.prepareStatement(sql);
			pmst.setObject(1, name);
			rs = pmst.executeQuery();
			UserBean ub = new UserBean();
			while(rs.next()) {
				ub.setUserid(rs.getInt("userId"));
				ub.setUsername(rs.getString("username"));
				ub.setPasswd(rs.getString("passwd"));
				ub.setGrade(rs.getInt("grade"));
				ub.setAddress(rs.getString("address"));
				ub.setPostcode(rs.getString("postcode"));
				ub.setEmail(rs.getString("email"));
				ub.setPhone(rs.getString("phone"));
				System.out.println("��ѯ�����ɹ�");
				return ub;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return ub;
	}

	@Override
	public List<UserBean> queryUser() {
		// TODO Auto-generated method stub
		String sql = "select *from users";
		conn = connBD.getConn();
		List<UserBean> array = new ArrayList<UserBean>();
		try {
			pmst = conn.prepareStatement(sql);
			rs = pmst.executeQuery();
			ub = new UserBean();

			while (rs.next()) {
				ub.setUserid(rs.getInt("userId"));
				ub.setUsername(rs.getString("username"));
				ub.setPasswd(rs.getString("passwd"));
				ub.setGrade(rs.getInt("grade"));
				ub.setAddress(rs.getString("address"));
				ub.setPostcode(rs.getString("postcode"));
				ub.setEmail(rs.getString("email"));
				ub.setPhone(rs.getString("phone"));
				array.add(ub);
				System.out.println("��ѯ�����û��ɹ�");
				System.out.print(array);
				return array;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return array;
	}
	 

	@Test
	public void testadd() {
		//this.addUser("rong", "123", 1);
		//this.deleteUser("jiao");
		//this.queryUserByName("rong");
		//this.queryUser();
		//���²������� ���ݿⰲȫ�ȼ�
		//this.updateUser("rong", "123456", 1,"jiao");
	}
  

}
