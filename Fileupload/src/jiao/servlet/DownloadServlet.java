package jiao.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
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
		String fileName = request.getParameter("filename");
		//�����ļ���Ϣͷ
		response.addHeader("content-Type","application/octet-stream");
		response.addHeader("content-Disposition", "attachement;filename"+fileName);
		//���ص�ַ��Servletͨ�������ַ���ļ�ת��Ϊ������������Servlet
		//                                                 javaweb ���ҿ��ԴӸ�·������
		InputStream in = getServletContext().getResourceAsStream("/res/01.png");
		//��������ת��Ϊ����� �����û�
		ServletOutputStream out = response.getOutputStream();
		//����������������
		byte[] bs=new byte[10];
		int len=-1;
		while (  (len=in.read(bs))!=-1) {
			out.write(bs, 0, len);
		}
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
