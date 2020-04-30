package jaiorongjinVSD.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jiaorongjinVSD.entity.User;
import jiaorongjinVSD.service.IUserService;
import jiaorongjinVSD.service.Impl.UserServiceImpl;

/**
 * Servlet implementation class QueryAllUserServlet
 */
@WebServlet("/QueryAllUserServlet")
public class QueryAllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAllUserServlet() {
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
		IUserService us = new UserServiceImpl();
		List<User> list = us.queryAllUsers();
		if(!list.equals(null)) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else if(request.getAttribute("to")=="to"){
			
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else{
			request.setAttribute("error", "existerror");
			request.getRequestDispatcher("QueryUserByIdServletTest").forward(request, response);
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
