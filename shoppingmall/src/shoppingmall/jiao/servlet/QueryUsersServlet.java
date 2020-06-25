package shoppingmall.jiao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoppingmall.jiao.DBUtils.Paged;
import shoppingmall.jiao.entity.UserBean;
import shoppingmall.jiao.services.UserBeanService;
import shoppingmall.jiao.services.impl.UserBeanServiceImpl;

/**
 * Servlet implementation class QueryUsersServlet
 */
@WebServlet("/QueryUsersServlet")
public class QueryUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryUsersServlet() {
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
		UserBeanService ubs = new UserBeanServiceImpl();
		UserBean ub = null;
		if (request.getParameter("UserBeanName") != null) {
			String userbeanname = request.getParameter("UserBeanName");
			ub = new UserBean();
			ub.setUsername(userbeanname);
			UserBean ub_2 = ubs.queryUserByName(ub);
			if (ub != null) {
				request.setAttribute("userbean", ub_2);
				request.getRequestDispatcher("AdminPage.jsp").forward(request, response);
			}
		}
		if (request.getParameter("UserBeanName")!=null&&request.getParameter("event")!=null) {
			String name = request.getParameter("UserBeanName");
			System.out.println(name);
			ub = new UserBean();
			ub.setUsername(name);
			boolean flag = ubs.deleteUser(ub);
			System.out.println(flag);
		}
		if(request.getParameter("i")!=null) {
			String i = request.getParameter("i");
			int int_i=Integer.parseInt(i);
			Paged page=new Paged();
			int totallPages = page.getTotallPages(5);
			List<UserBean> userList = page.getPagedData(int_i, 5);
			request.setAttribute("totallPages", totallPages);
			request.setAttribute("userlist", userList);
			request.getRequestDispatcher("AdminPage.jsp").forward(request, response);
		}
		if(request.getParameter("testName")!=null&&request.getParameter("testIndex")!=null) {
			
			
			
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
