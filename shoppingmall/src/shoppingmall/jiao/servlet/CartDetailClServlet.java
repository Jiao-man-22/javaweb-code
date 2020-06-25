package shoppingmall.jiao.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shoppingmall.jiao.DBUtils.ShoppingCart;
import shoppingmall.jiao.entity.GoodsBean;

/**
 * Servlet implementation class CartDetailClServlet
 */
@WebServlet("/CartDetailClServlet")
public class CartDetailClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartDetailClServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("html;charset=utf-8");
		//判断
		GoodsBean goods =(GoodsBean)request.getSession().getAttribute("GoodsBean");
		//获取购物车
		ShoppingCart cart =(ShoppingCart) request.getSession().getAttribute("MyCart");
		if(cart!=null) {
			//根据id添加货物到map集合
			long goodsId=goods.getGoodsId();
			cart.addGoods(goodsId, goods);
		}
		//取出map的GoodsBean对象，再放入list集合遍历
		ArrayList<GoodsBean> list = cart.showCart();
		if(list!=null) {
			float totalPrice = cart.gettotalPrice(list);
			request.setAttribute("list", list);
			request.setAttribute("totalPrice", totalPrice);
			request.getRequestDispatcher("shoppingCart.jsp").forward(request, response);	
		}else {
			System.out.println("显示购物车为："+list);
		}
			
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
