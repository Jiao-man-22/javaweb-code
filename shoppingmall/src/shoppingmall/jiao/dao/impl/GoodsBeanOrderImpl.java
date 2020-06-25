package shoppingmall.jiao.dao.impl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


import shoppingmall.jiao.DBUtils.ConnDB;
import shoppingmall.jiao.dao.Igoodsorders;
import shoppingmall.jiao.entity.GoodsBean;

public class GoodsBeanOrderImpl implements Igoodsorders {
	ConnDB connBD = new ConnDB();
	Connection conn = null;
	PreparedStatement pmst = null;
	boolean flag = false;
	public GoodsBean gb = null;
	private ResultSet rs = null;
	private PreparedStatement psmt;
	
	@Override
	public boolean addGoods(String goodsName, int goodsNum) {
		String sql = "insert into goods (goodsName,goodsNum) values(?,?) ";
		conn = connBD.getConn();
		try {
			pmst = conn.prepareStatement(sql);
			pmst.setObject(1, goodsName);
			pmst.setObject(2, goodsNum);
			flag = pmst.execute();
			System.out.println("插入成功");
	
			return flag;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;

	}

	@Override
	public boolean deleteGoods(int goodsId) {
		String sql = "delete from Goods where goodsId=?";
		conn = connBD.getConn();
		try {
			pmst = conn.prepareStatement(sql);
			pmst.setObject(1, goodsId);
			flag = pmst.execute();
			
			return flag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public boolean updateGoods(int goodsId, String goodsIntro, int goodNum) {
		String sql = "update Goods set goodNum=?, goodsIntro=? where GoodsId=?";
		conn = connBD.getConn();
		try {
			pmst = conn.prepareStatement(sql);
			pmst.setObject(1, goodNum);
			pmst.setObject(2, goodsIntro);
			pmst.setObject(3, goodsId);
			flag = pmst.execute();
			return flag;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public GoodsBean queryGoodsbyId(int goodsId) {
		String sql = "select *from Goods where goodsId=?";
		conn = new ConnDB().getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, goodsId);
			rs = psmt.executeQuery();
			while (rs.next()) {
				GoodsBean gb = new GoodsBean();
				gb.setGoodsId(rs.getInt(1));
				gb.setGoodsName(rs.getString(2));
				gb.setGoodsIntro(rs.getString(3));
				gb.setGoodsPrice(rs.getFloat(4));
				gb.setGoodsNum(rs.getInt(5));
				gb.setPublisher(rs.getString(6));
				gb.setPhoto(rs.getString(7));
				gb.setType(rs.getString(8));
				
				return gb;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
		return gb;

	}

	@Override
	public List<GoodsBean> queryAllGoods() {
		String sql = "select *from goods";
		conn = connBD.getConn();
		List<GoodsBean> array = new ArrayList<GoodsBean>();
		try {
			pmst = conn.prepareStatement(sql);
			rs = pmst.executeQuery();
			while (rs.next()) {
				GoodsBean gb = new GoodsBean();
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
	//购物车
	
	//关闭流
	public void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = null;
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			psmt = null;
		}
	}
	//

	@Test
	public void add() {
		// this.addGoods("监狱风云",1);
		//System.out.println(this.queryGoodsbyId(4));
		//System.out.println(this.queryAllGoods());
		
	}

}
