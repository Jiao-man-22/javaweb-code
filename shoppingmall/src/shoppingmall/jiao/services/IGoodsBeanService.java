package shoppingmall.jiao.services;

import java.util.List;

import shoppingmall.jiao.entity.GoodsBean;

public interface IGoodsBeanService {
	//��Ʒ����ɾ��
	public boolean addGoods(GoodsBean gb);
	public boolean deleteGoods(GoodsBean gb);
	public boolean updateGoods(GoodsBean gb);
	//����
	public GoodsBean queryGoodsbyId(GoodsBean gb);
	//��������goods
	public List<GoodsBean> queryAllGoods();

}
