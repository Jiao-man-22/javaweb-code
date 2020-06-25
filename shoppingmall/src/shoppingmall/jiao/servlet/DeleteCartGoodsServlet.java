package shoppingmall.jiao.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoppingmall.jiao.DBUtils.ShoppingCart;

/**
 * Servlet implementation class DeleteCartGoodsServlet
 */
@WebServlet("/DeleteCartGoodsServlet")
public class DeleteCartGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCartGoodsServlet() {
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
		String GoodsId = request.getParameter("GoodsId");
		ShoppingCart cart=(ShoppingCart) request.getSession().getAttribute("MyCart");
		long longid=Long.parseLong(GoodsId);
		cart.deleteGoods(longid);
		ArrayList list = cart.showCart();
		request.setAttribute("list",list);
		request.getRequestDispatcher("shoppingCart.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
