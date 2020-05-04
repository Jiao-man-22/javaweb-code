package jiao.jstl.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JstlServlet
 */
@WebServlet("/JstlServlet")
public class JstlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JstlServlet() {
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
		String[]  stringarray= {"焦荣进","男","23"};
		request.setAttribute("stringarray",stringarray );
		request.setAttribute("StringVar", "字符串");
		request.setAttribute("intattribute", 1);
		String s1="你";
		String s2="是";
		String s3="s";
		String s4="b";
		List<String> array=new ArrayList<String>();
		array.add(s1);
		array.add(s2);
		array.add(s3);
		array.add(s4);
		request.setAttribute("listint",array);
		request.getRequestDispatcher("JSTL.jsp").forward(request, response);
		//重定向会丢失数据 		
		//response.sendRedirect("JSTL.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
