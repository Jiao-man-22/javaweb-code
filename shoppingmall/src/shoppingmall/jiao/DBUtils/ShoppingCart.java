package shoppingmall.jiao.DBUtils;

import java.util.ArrayList;
/**
 *构建map集合 
 * 
 * */

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import shoppingmall.jiao.entity.GoodsBean;




public class ShoppingCart {
	
	float tatolPrice = 0.0f;
	
	
//创建一个map集合存放商品id和 和商品数量
HashMap<String, GoodsBean> hm = new HashMap<String, GoodsBean>();
//存放goods对象
//获得购物车总价
	public float gettotalPrice(List<GoodsBean> list) {
		if(list!=null) {
			tatolPrice=0.0f;
			for(GoodsBean gb :list) {
				float goodsPrice = gb.getGoodsPrice();
				double solototalPrice=goodsPrice;
				int goodsNum = gb.getGoodsNum();
				float totalPrice=(float) (goodsNum*solototalPrice);
				tatolPrice+=totalPrice;	
			}
		}else if(list ==null) {
			System.out.println("list为null"+list);
			return tatolPrice;
		}
		System.out.println("list不为null"+list);
		return tatolPrice;
	};
	
//根据id对货物进行操作
	//根据id获得该商品 的数量
	public GoodsBean getGoodsNum(GoodsBean gb) {
		
		return hm.get(gb.getGoodsId()+"");
	}
	//添加货物数量
	public void  addGoods(long  goodsId,GoodsBean gb) {
		String GoodsId=goodsId+"";
		hm.put(GoodsId,gb );
	}
	//删除货物数量
	public void deleteGoods(long goodsId) {
		String GoodsId=goodsId+"";
		hm.remove(GoodsId);
	}
	//修改商品数量
	public void updateGoodsNum(long goodsId, GoodsBean gb) {
		String GoodsId=goodsId+"";
		System.out.println("来自购物车工具类："+gb.getGoodsNum());
	    hm.put(GoodsId, gb);
	}
	//清空购物车
	public void clearCart() {
		
		hm.clear();
	}
	//显示购物车
	public ArrayList<GoodsBean> showCart() {
		ArrayList<GoodsBean> array=new ArrayList<GoodsBean>();
		for(String key:hm.keySet()) {
		//获取他的对象
		GoodsBean value=hm.get(key);
		
		array.add(value);
		}
		return array;
	}

	
	
	
	

}
