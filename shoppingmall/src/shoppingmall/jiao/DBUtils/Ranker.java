package shoppingmall.jiao.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import shoppingmall.jiao.entity.RankerBean;

public class Ranker {

	public List<RankerBean> getData() {
		ConnDB conn = new ConnDB();
		Connection conn2 = conn.getConn();
		String sql = "select *from ranker order by click desc limit 0,3;";
		List<RankerBean> array = new ArrayList<RankerBean>();
		try {
			PreparedStatement pmst = conn2.prepareStatement(sql);
			ResultSet rs = pmst.executeQuery();
			while (rs.next()) {
				RankerBean rb = new RankerBean();
				rb.setId(rs.getInt(1));
				rb.setName(rs.getString(2));
				rb.setClick(rs.getInt(3));
				array.add(rb);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
		System.out.println(array);
		return array;
	}
	public void addclick(int click,int id) {
		ConnDB conn = new ConnDB();
		Connection conn2 = conn.getConn();
		String  sql="update ranker set click=? where id=?";
		try {
			PreparedStatement psmt = conn2.prepareStatement(sql);
			psmt.setInt(1, click);
			psmt.setInt(2, id);
			boolean execute = psmt.execute();
			System.out.println(execute);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void query() {
		//this.getData();
		this.addclick(7, 4);
	}
	

	public static void main(String[] args) {
		

	}

}
