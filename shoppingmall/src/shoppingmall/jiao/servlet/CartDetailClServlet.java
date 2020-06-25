package shoppingmall.jiao.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shoppingmall.jiao.DBUtils.ShoppingCart;
import shoppingmall.jiao.entity.GoodsBean;

/**
 * Servlet implementation class CartDetailClServlet
 */
@WebServlet("/CartDetailClServlet")
public class CartDetailClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartDetailClServlet() {
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
		//�ж�
		GoodsBean goods =(GoodsBean)request.getSession().getAttribute("GoodsBean");
		//��ȡ���ﳵ
		ShoppingCart cart =(ShoppingCart) request.getSession().getAttribute("MyCart");
		if(cart!=null) {
			//����id��ӻ��ﵽmap����
			long goodsId=goods.getGoodsId();
			cart.addGoods(goodsId, goods);
		}
		//ȡ��map��GoodsBean�����ٷ���list���ϱ���
		ArrayList<GoodsBean> list = cart.showCart();
		if(list!=null) {
			float totalPrice = cart.gettotalPrice(list);
			request.setAttribute("list", list);
			request.setAttribute("totalPrice", totalPrice);
			request.getRequestDispatcher("shoppingCart.jsp").forward(request, response);	
		}else {
			System.out.println("��ʾ���ﳵΪ��"+list);
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
