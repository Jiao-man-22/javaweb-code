package shoppingmall.jiao.services.impl;

import java.util.List;

import shoppingmall.jiao.dao.Igoodsorders;
import shoppingmall.jiao.dao.impl.GoodsBeanOrderImpl;
import shoppingmall.jiao.entity.GoodsBean;
import shoppingmall.jiao.services.IGoodsBeanService;

public class IGoodsServiceImpl implements IGoodsBeanService {
	Igoodsorders gboi=new GoodsBeanOrderImpl();
	

	@Override
	public boolean addGoods(GoodsBean gb) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteGoods(GoodsBean gb) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateGoods(GoodsBean gb) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public GoodsBean queryGoodsbyId(GoodsBean gb) {
		GoodsBean gb_2 = gboi.queryGoodsbyId((int)gb.getGoodsId());
		return gb_2;
	}
	//查找所有商品
	@Override
	public List<GoodsBean> queryAllGoods() {
		List<GoodsBean> allGoods = gboi.queryAllGoods();
		return allGoods;
	}

}
