package jaiorongjinVSD.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.env.IModule.IService;

import jiaorongjinVSD.entity.User;
import jiaorongjinVSD.service.IUserService;
import jiaorongjinVSD.service.Impl.UserServiceImpl;

/**
 * Servlet implementation class PagedServlet
 */
@WebServlet("/PagedServlet")
public class PagedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("html;charset=utf-8");
		//获得页面上传的pageNow,并转换成成int类型
		Integer pageNow=0;
		pageNow = Integer.parseInt(request.getParameter("pageNow"));
		int pageSize=5;
		int setCurrentPage=0;
		IUserService us = new UserServiceImpl();
		//得到总页数
		int countPage = us.getCountPage(pageSize);
		if(pageNow>0 & pageNow<countPage) {
			setCurrentPage = us.setCurrentPage(pageNow);	
		}else {
			pageNow=0;
			setCurrentPage = us.setCurrentPage(pageNow);
		}
		//得到单页页面要显示的数据
	    List<User> list=us.getPageRow(pageSize,setCurrentPage);
	    System.out.println(list);
	    //得到总页数，放入request
	    request.setAttribute("countPage", countPage);
	    //得到单页页面要显示的数据，放入request
	    request.setAttribute("List",list);
	    //得到当前页，放入request
	    request.setAttribute("currentPaged",setCurrentPage );
	    //跳转
	    request.getRequestDispatcher("Page.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
