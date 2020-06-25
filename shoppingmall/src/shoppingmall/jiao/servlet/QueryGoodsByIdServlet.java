package shoppingmall.jiao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoppingmall.jiao.DBUtils.ShoppingCart;
import shoppingmall.jiao.entity.GoodsBean;
import shoppingmall.jiao.services.IGoodsBeanService;
import shoppingmall.jiao.services.impl.IGoodsServiceImpl;

/**
 * Servlet implementation class QueryGoodsById
 */
@WebServlet("/QueryGoodsById")
public class QueryGoodsByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryGoodsByIdServlet() {
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
		int goodsId =Integer.parseInt(request.getParameter("GoodsId"));
		IGoodsBeanService is = new IGoodsServiceImpl();
		GoodsBean gb = new GoodsBean();
		gb.setGoodsId(goodsId);
		GoodsBean gb_2 = is.queryGoodsbyId(gb);
		if(gb_2!=null) {
			request.setAttribute("goodsbean", gb_2);
			request.getRequestDispatcher("ShowGoods.jsp").forward(request, response);
			
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
