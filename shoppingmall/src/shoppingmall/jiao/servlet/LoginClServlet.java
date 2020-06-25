package shoppingmall.jiao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoppingmall.jiao.DBUtils.Paged;
import shoppingmall.jiao.DBUtils.ShoppingCart;
import shoppingmall.jiao.entity.UserBean;
import shoppingmall.jiao.services.UserBeanService;
import shoppingmall.jiao.services.impl.UserBeanServiceImpl;

/**
 * Servlet implementation class LoginClServlet
 */
@WebServlet("/LoginClServlet")
public class LoginClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginClServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("html;charset=utf-8");
		String name = request.getParameter("uname");
		String pwd = request.getParameter("upwd");
		UserBeanService ubs = new UserBeanServiceImpl();
		UserBean ub = new UserBean();
		ub.setUsername(name);
		ub.setPasswd(pwd);
		boolean c = ubs.isAdmin(ub);
		if(c) {
		List<UserBean> userList = ubs.adminLogin(ub, 1, 5);
		System.out.println(userList);
		if (userList != null) {
			request.setAttribute("userlist", userList);
			Paged page=new Paged();
			int totallPages = page.getTotallPages(5);
			request.setAttribute("totallPages", totallPages);
			request.getRequestDispatcher("AdminPage.jsp").forward(request, response);
		}
		}else{
			//判断为普通用户登陆
			boolean b = ubs.checkUser(ub);
			if(b) {
				//创建一个购物车
				ShoppingCart cart=new ShoppingCart();
				request.getSession().setAttribute("username",ub.getUsername() );
				request.getSession().setAttribute("MyCart", cart);
				request.getRequestDispatcher("QueryAllGoodsServlet").forward(request, response);
			}
			
		}
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
