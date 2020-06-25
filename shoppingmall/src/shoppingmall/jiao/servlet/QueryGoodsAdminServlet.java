package shoppingmall.jiao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoppingmall.jiao.dao.impl.GoodsBeanOrderImpl;
import shoppingmall.jiao.entity.GoodsBean;
import shoppingmall.jiao.services.IGoodsBeanService;
import shoppingmall.jiao.services.impl.IGoodsServiceImpl;

/**
 * Servlet implementation class QueryGoodsAdminServlet
 */
@WebServlet("/QueryGoodsAdminServlet")
public class QueryGoodsAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryGoodsAdminServlet() {
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
		IGoodsBeanService igbs=new IGoodsServiceImpl();
		List<GoodsBean> allGoods = igbs.queryAllGoods();
		if (allGoods!=null) {
			System.out.println(allGoods);
			request.setAttribute("listGoods", allGoods);
			request.getRequestDispatcher("GoodsAdmin.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
