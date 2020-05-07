package jiao.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUpLoadServlet
 */
@WebServlet("/FileUpLoadServlet")
public class FileUpLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public FileUpLoadServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// ������ʾʱ��������
		response.setContentType("html/text;charset=utf-8");
		// �ϴ�����������
		// ���ж��Ƿ�ʱ��ý���ļ�
		boolean ismultipart = ServletFileUpload.isMultipartContent(request);
		if (!(ismultipart)) {
			PrintWriter out = response.getWriter();
			out.print("���������multipart=form-data");
			out.flush();
			return;
		}
		// �����ϴ�����
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
	
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		// ͨ��parseRequest����request�еĲ���,����name�ֶ��е�ֵ �ұ�����list
		try {
			List<FileItem> parseRequest = servletFileUpload.parseRequest(request);
			// ����������,�ֶ�
			Iterator<FileItem> iterator = parseRequest.iterator();
			while (iterator.hasNext()) {
				// ȡ��iterator�е�ֵ�����Ҷ�������next������,��Ҫ��Ϊ������type�����ͣ�������������name����ֵ
				FileItem next = iterator.next();
				// �õ���ͨname���Ե�ֵ
				String fieldName = next.getFieldName();
				// �ж�ǰ̨���Ĳ���Ϊ��ͨ���ͻ����ļ�����
				if (next.isFormField()) {
					// ����name���Խ����ж�Ϊ�ĸ�ֵ
					if (fieldName.equals("commomfile")) {
						// ͨ��getString�õ�name�ֶε�ֵ
						String string = next.getString();
						System.out.println(string + "��ͨ�ֶλ�ȡ�ɹ�");
					} else {
					}
				} else {
					// ������ļ��ֶ�
					// ��ȡ�ļ����ݣ������ϴ�
					// �����ļ�·������ָ���ϴ����ĸ���λ�ã�������·����
					// ��̬��ȡ������ļ���tomcat�У���Ŀ�޸ĺ�ÿ�������������������µ�Ŀ¼�������Լ�������Ŀ¼�ᶪʧ���ϴ����ļ��Ὣ��ʧ
					// String realPath =
					// request.getSession().getServletContext().getRealPath("upload");
					// getName()�ǻ�ȡ �ļ���
					String name = next.getName();
					System.out.println(name);
					// ������Ҫ���ַ�����ȡ ��Ϊ��ͬ����������ܷ����ļ���·�����ļ���
					// �����ַ���������ֵ��û���򷵻�-1
					int index = name.lastIndexOf("\\");
					if (index != -1) {
						// �����ַ�����������������ַ���
						name = name.substring(index + 1);
						System.out.println(name);
						// ����д��·�� ���ϴ�λ�÷ų�tomcatĿ¼
						String realPath = "F:\\upload";
						// �����ļ�����,���ļ��ϴ�������
						File file = new File(realPath, name);
						//������ʱ�ļ���С
						// �����ڴ��ٽ�ֵ�����ĵط���������ʱ�ļ��е�λ��kb
						diskFileItemFactory.setSizeThreshold(41960);
						//������ʱ�ļ�Ŀ¼
						diskFileItemFactory.setRepository(new File("F:\\tempupload"));
						//���õ����ļ���С
						servletFileUpload.setFileSizeMax(80000);
						try {
							next.write(file);
							System.out.println("�ϴ��ɹ�");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}

			}

		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
