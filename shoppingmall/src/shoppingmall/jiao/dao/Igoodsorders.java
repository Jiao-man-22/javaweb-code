package shoppingmall.jiao.dao;

import java.util.List;

import shoppingmall.jiao.entity.GoodsBean;

public interface Igoodsorders {
	//物品的增删该
	public boolean addGoods(String goodsName,int goodsNum);
	public boolean deleteGoods(int goodsId);
	public boolean updateGoods(int goodsId,String goodsIntro,int goodsNum);
	//查找
	public GoodsBean queryGoodsbyId(int goodId);
	//查找所有goods
	public List<GoodsBean> queryAllGoods();
	
	
	

}
