package jaiorongjinVSD.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jiaorongjinVSD.entity.User;
import jiaorongjinVSD.service.IUserService;
import jiaorongjinVSD.service.Impl.UserServiceImpl;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
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
		String name = request.getParameter("uname");
		String pwd = request.getParameter("upwd");
		int  grade = Integer.parseInt(request.getParameter("ugrade"));
		int id=Integer.parseInt(request.getParameter("id"));
		User user=new User();
		user.setId(id);
		user.setName(name);
		user.setPwd(pwd);
		user.setGrade(grade);
		IUserService us = new UserServiceImpl();
		us.updateUserById(id, user);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
