package jaiorongjinVSD.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jiaorongjinVSD.entity.User;
import jiaorongjinVSD.service.UserService;

/**
 * Servlet implementation class QueryUserByIdServletTest
 */
@WebServlet("/QueryUserByIdServletTest")
public class QueryUserByIdServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryUserByIdServletTest() {
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
		int id=Integer.parseInt(request.getParameter("id"));
		UserService us = new UserService();
		User user = new User();
		user=us.queryUserById(id);
		PrintWriter out = response.getWriter();
		out.println(user);
		request.setAttribute("user", user);
		//request.getRequestDispatcher("TestPage.jsp").forward(request, response);
		request.getRequestDispatcher("UserInfo.jsp").forward(request, response);
		System.out.println(user);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
