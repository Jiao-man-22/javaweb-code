package shoppingmall.jiao.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoppingmall.jiao.DBUtils.ShoppingCart;
import shoppingmall.jiao.dao.impl.GoodsBeanOrderImpl;
import shoppingmall.jiao.entity.GoodsBean;
import shoppingmall.jiao.services.IGoodsBeanService;
import shoppingmall.jiao.services.impl.IGoodsServiceImpl;

/**
 * Servlet implementation class ShoppongCartPageOrder
 */
@WebServlet("/ShoppingCartPageOrder")
public class ShoppingCartPageOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCartPageOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("html;charset=utf-8");
		String goodsId = request.getParameter("goodsId");
		String goodsNum = request.getParameter("goodsNum");
		String goodsName = request.getParameter("goodsName");
		String goodsPrice = request.getParameter("goodsPrice");
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("MyCart");
		if(cart!=null & goodsNum!=null &goodsId!=null) {
			GoodsBean gb=new GoodsBean();
			int intNum=Integer.parseInt(goodsNum);
			gb.setGoodsNum(intNum);
			long longId=Long.parseLong(goodsId);
			gb.setGoodsId(longId);
			gb.setGoodsName(goodsName);
			float f_price=Float.parseFloat(goodsPrice);
			gb.setGoodsPrice(f_price);
			System.out.println("来自servlet层：数量："+gb.getGoodsNum());
			cart.updateGoodsNum(longId,gb);	
			System.out.println(cart.showCart());
			//重新计算价格
			ArrayList<GoodsBean> list = cart.showCart();
			float f = cart.gettotalPrice(list);
			request.setAttribute("totalPrice", f);
			System.out.println("数量更新完成");
			
		}
		//再次显示购物车
		ArrayList list = cart.showCart();
		if(list!=null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("shoppingCart.jsp").forward(request, response);
			
		}
		
		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
