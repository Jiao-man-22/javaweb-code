package shoppingmall.jiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoppingmall.jiao.DBUtils.ShoppingCart;
import shoppingmall.jiao.entity.GoodsBean;
import shoppingmall.jiao.services.IGoodsBeanService;
import shoppingmall.jiao.services.impl.IGoodsServiceImpl;

/**
 * Servlet implementation class GoodsCartOrderServlet
 */
@WebServlet("/GoodsCartOrderServlet")
public class GoodsCartOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoodsCartOrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("html;charset=utf-8");
		Object name = request.getSession().getAttribute("username");
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("MyCart");
		String goodsId = request.getParameter("GoodsId");
		// 一个商品信息对象
		IGoodsBeanService ibs=new IGoodsServiceImpl();
		GoodsBean gb=new GoodsBean();
		long longid=Long.parseLong(goodsId);
		gb.setGoodsId(longid);
		GoodsBean gb_2 = ibs.queryGoodsbyId(gb);
		if (name != null & gb_2!=null) {
			if (cart != null) {
				request.setAttribute("GoodsBean", gb_2);
				request.getSession().setAttribute("MyCart",cart);
				request.getRequestDispatcher("order.jsp").forward(request, response);
			} else if (cart == null & gb_2!=null) {
				ShoppingCart cart2 = new ShoppingCart();
				cart = cart2;
				request.setAttribute("GoodsBean", gb_2);
				request.getSession().setAttribute("Mycart",cart);
				request.getRequestDispatcher("order.jsp").forward(request, response);
			}
		} else {
			System.out.println("请先登陆");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
