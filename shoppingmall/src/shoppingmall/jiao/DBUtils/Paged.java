package shoppingmall.jiao.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import shoppingmall.jiao.entity.GoodsBean;
import shoppingmall.jiao.entity.UserBean;

public class Paged {
	public int pageSize = 0;
	public int pageNow = 0;
	public int totalPages = 0;
	ConnDB connDB = new ConnDB();
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int totallRow = 0;
	int totallPages = 0;

	// 得到单个用户页面的数据
	public List<UserBean> getPagedData(int pageNow, int pageSize) {
		String sql = "select * from users limit ?,?";
		conn = connDB.getConn();
		List<UserBean> array = new ArrayList<UserBean>();
		try {
			int indexStart = (pageNow - 1) * pageSize;
			psmt = conn.prepareStatement(sql);
			psmt.setObject(1, indexStart);
			psmt.setObject(2, pageSize);
			rs = psmt.executeQuery();
			while (rs.next()) {
				UserBean ub=new UserBean();
				ub.setUserid(rs.getInt("userId"));
				ub.setUsername(rs.getString("username"));
				ub.setPasswd(rs.getString("passwd"));
				ub.setGrade(rs.getInt("grade"));
				ub.setAddress(rs.getString("address"));
				ub.setPostcode(rs.getString("postcode"));
				ub.setEmail(rs.getString("email"));
				ub.setPhone(rs.getString("phone"));
				array.add(ub);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}

	// 获取总页数
	public int getTotallPages(int pageSize) {
		String sql = "select count(*) from users";
		conn = connDB.getConn();
		try {
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			if (rs != null) {
				while(rs.next()) {
				totallRow = rs.getInt(1);
				}
				if (totallRow % pageSize == 0) {
					totallPages = totallRow / pageSize;
					return totallPages;
				} else if (totallRow % pageSize != 0) {
					totallPages = totallRow / pageSize + 1;
					return totallPages;
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return totallPages;

	}
	//给到单个页面
	public List<GoodsBean> getGoodsPagedData(int pageNow, int pageSize) {
		String sql = "select * from Goods limit ?,?";
		conn = connDB.getConn();
		List<GoodsBean> array = new ArrayList<GoodsBean>();
		try {
			int indexStart = (pageNow - 1) * pageSize;
			psmt = conn.prepareStatement(sql);
			psmt.setObject(1, indexStart);
			psmt.setObject(2, pageSize);
			rs = psmt.executeQuery();
			while (rs.next()) {
				GoodsBean gb=new GoodsBean();
				gb.setGoodsId(rs.getInt(1));
				gb.setGoodsName(rs.getString(2));
				gb.setGoodsIntro(rs.getString(3));
				gb.setGoodsPrice(rs.getFloat(4));
				gb.setGoodsNum(rs.getInt(5));
				gb.setPublisher(rs.getString(6));
				gb.setPhoto(rs.getString(7));
				gb.setType(rs.getString(8));
				array.add(gb);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}
	//得到总页数
	public int getGoodsTotallPages(int pageSize) {
		String sql = "select count(*) from Goods";
		this.totallRow=0;
		this.totallPages=0;
		conn = connDB.getConn();
		try {
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			if (rs != null) {
				while(rs.next()) {
				totallRow = rs.getInt(1);
				}
				if (totallRow % pageSize == 0) {
					totallPages = totallRow / pageSize;
					return totallPages;
				} else if (totallRow % pageSize != 0) {
					totallPages = totallRow / pageSize + 1;
					return totallPages;
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return totallPages;

	}


	@Test
	public void getpages() {
		//this.getPagedData(1, 5);
		//System.out.println(this.getTotallPages(5));
		//System.out.println(this.getGoodsTotallPages(5));
	}

}
