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
 * Servlet implementation class LoginCartServlet
 */
@WebServlet("/LoginCartServlet")
public class LoginCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCartServlet() {
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
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("MyCart");
		if(cart!=null) {
			ArrayList<GoodsBean> list = cart.showCart();
			request.setAttribute("list", list);
			request.getRequestDispatcher("shoppingCart.jsp").forward(request, response);
		}else if(cart==null) {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
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
