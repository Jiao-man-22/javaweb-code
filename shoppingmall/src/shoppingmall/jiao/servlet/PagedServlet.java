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
import shoppingmall.jiao.entity.UserBean;

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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("html;charset=utf-8");
		if(request.getParameter("i")!=null) {
			int pageNow =Integer.parseInt(request.getParameter("i"));
			Paged paged = new Paged();
			int totallPages = paged.getGoodsTotallPages(8);
			List<GoodsBean> list = paged.getGoodsPagedData(pageNow, 8);
			Ranker ranker = new Ranker();
			List<RankerBean> rankerData = ranker.getData();
			if(list!=null) {
				request.setAttribute("rankerlist",rankerData);
				request.setAttribute("list", list);
				request.setAttribute("totallPages", totallPages);
				request.getRequestDispatcher("GoodsMain.jsp").forward(request, response);
			}	
		}
		if(request.getParameter("rankerId")!=null&&request.getParameter("click")!=null) {
			String rankerId = request.getParameter("rankerId");
			String click = request.getParameter("click");
			int intClick=Integer.parseInt(click);
			int intClickIncreamt=intClick+1;
			int  rankerId_1=Integer.parseInt(rankerId);
			Ranker ranker=new Ranker();
			ranker.addclick(intClickIncreamt, rankerId_1);
			request.getRequestDispatcher("QueryAllGoodsServlet").forward(request, response);
			
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
