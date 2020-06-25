package shoppingmall.jiao.DBUtils;

import java.util.ArrayList;
/**
 *����map���� 
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
	
	
//����һ��map���ϴ����Ʒid�� ����Ʒ����
HashMap<String, GoodsBean> hm = new HashMap<String, GoodsBean>();
//���goods����
//��ù��ﳵ�ܼ�
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
			System.out.println("listΪnull"+list);
			return tatolPrice;
		}
		System.out.println("list��Ϊnull"+list);
		return tatolPrice;
	};
	
//����id�Ի�����в���
	//����id��ø���Ʒ ������
	public GoodsBean getGoodsNum(GoodsBean gb) {
		
		return hm.get(gb.getGoodsId()+"");
	}
	//��ӻ�������
	public void  addGoods(long  goodsId,GoodsBean gb) {
		String GoodsId=goodsId+"";
		hm.put(GoodsId,gb );
	}
	//ɾ����������
	public void deleteGoods(long goodsId) {
		String GoodsId=goodsId+"";
		hm.remove(GoodsId);
	}
	//�޸���Ʒ����
	public void updateGoodsNum(long goodsId, GoodsBean gb) {
		String GoodsId=goodsId+"";
		System.out.println("���Թ��ﳵ�����ࣺ"+gb.getGoodsNum());
	    hm.put(GoodsId, gb);
	}
	//��չ��ﳵ
	public void clearCart() {
		
		hm.clear();
	}
	//��ʾ���ﳵ
	public ArrayList<GoodsBean> showCart() {
		ArrayList<GoodsBean> array=new ArrayList<GoodsBean>();
		for(String key:hm.keySet()) {
		//��ȡ���Ķ���
		GoodsBean value=hm.get(key);
		
		array.add(value);
		}
		return array;
	}

	
	
	
	

}
