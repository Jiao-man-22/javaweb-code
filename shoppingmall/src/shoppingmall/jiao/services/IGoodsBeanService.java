package shoppingmall.jiao.services;

import java.util.List;

import shoppingmall.jiao.entity.GoodsBean;

public interface IGoodsBeanService {
	//物品的增删该
	public boolean addGoods(GoodsBean gb);
	public boolean deleteGoods(GoodsBean gb);
	public boolean updateGoods(GoodsBean gb);
	//查找
	public GoodsBean queryGoodsbyId(GoodsBean gb);
	//查找所有goods
	public List<GoodsBean> queryAllGoods();

}
