package shoppingmall.jiao.dao;

import java.util.List;

import shoppingmall.jiao.entity.GoodsBean;

public interface Igoodsorders {
	//��Ʒ����ɾ��
	public boolean addGoods(String goodsName,int goodsNum);
	public boolean deleteGoods(int goodsId);
	public boolean updateGoods(int goodsId,String goodsIntro,int goodsNum);
	//����
	public GoodsBean queryGoodsbyId(int goodId);
	//��������goods
	public List<GoodsBean> queryAllGoods();
	
	
	

}
