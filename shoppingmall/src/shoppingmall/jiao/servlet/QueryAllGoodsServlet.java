package shoppingmall.jiao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoppingmall.jiao.DBUtils.Paged;
import shoppingmall.jiao.DBUtils.Ranker;
import shoppingmall.jiao.entity.GoodsBean;
import shoppingmall.jiao.entity.RankerBean;

/**
 * Servlet implementation class QueryAllGoodsServlet
 */
@WebServlet(value="/QueryAllGoodsServlet",
			loadOnStartup=0
		)

public class QueryAllGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAllGoodsServlet() {
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
		Paged paged = new Paged();
		List<GoodsBean> list = paged.getGoodsPagedData(1,8);
		int totallPages = paged.getGoodsTotallPages(8);
		Ranker ranker = new Ranker();
		List<RankerBean> rankerData = ranker.getData();
		if(list!=null & totallPages!=0) {
		request.setAttribute("rankerlist", rankerData);
		request.setAttribute("totallPages", totallPages);
		request.setAttribute("list",list);
		request.getRequestDispatcher("GoodsMain.jsp").forward(request, response);
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
