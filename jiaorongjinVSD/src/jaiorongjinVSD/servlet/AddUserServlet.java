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
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
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
		int grade =Integer.parseInt(request.getParameter("ugrade"));
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
		user.setGrade(grade);
		UserService us=new UserService();
		boolean addUser = us.addUser(user);
		//新增成功
		if(addUser) {
		response.sendRedirect("QueryAllUserServlet");
		}
		//新增失败
		if(!addUser) {
			request.setAttribute("error", "adderror");
			request.getRequestDispatcher("QueryAllUserServlet").forward(request, response);	
		}
		PrintWriter out = response.getWriter();
		out.write("注册完成");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
