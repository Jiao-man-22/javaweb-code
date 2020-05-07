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
		// 数据显示时编码设置
		response.setContentType("html/text;charset=utf-8");
		// 上传及保存数据
		// 先判断是否时多媒体文件
		boolean ismultipart = ServletFileUpload.isMultipartContent(request);
		if (!(ismultipart)) {
			PrintWriter out = response.getWriter();
			out.print("表单必须包含multipart=form-data");
			out.flush();
			return;
		}
		// 配制上传参数
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
	
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		// 通过parseRequest解析request中的参数,比如name字段中的值 我保存在list
		try {
			List<FileItem> parseRequest = servletFileUpload.parseRequest(request);
			// 迭代器遍历,字段
			Iterator<FileItem> iterator = parseRequest.iterator();
			while (iterator.hasNext()) {
				// 取出iterator中的值，并且都存在于next变量中,主要是为了区别type的类型，遍历表单中所有name属性值
				FileItem next = iterator.next();
				// 得到普通name属性的值
				String fieldName = next.getFieldName();
				// 判断前台传的参数为普通类型还是文件类型
				if (next.isFormField()) {
					// 依靠name属性进行判断为哪个值
					if (fieldName.equals("commomfile")) {
						// 通过getString得到name字段的值
						String string = next.getString();
						System.out.println(string + "普通字段获取成功");
					} else {
					}
				} else {
					// 如果是文件字段
					// 获取文件内容，并且上传
					// 定义文件路径；并指定上传到哪个的位置（服务器路径）
					// 动态获取，如果文件在tomcat中，项目修改后每次启动都会重新生成新的目录，所以自己创建的目录会丢失，上传的文件会将丢失
					// String realPath =
					// request.getSession().getServletContext().getRealPath("upload");
					// getName()是获取 文件名
					String name = next.getName();
					System.out.println(name);
					// 这里需要做字符串截取 因为不同的浏览器可能返回文件或路径加文件名
					// 返回字符处的索引值，没有则返回-1
					int index = name.lastIndexOf("\\");
					if (index != -1) {
						// 返回字符串索引处后的所有字符串
						name = name.substring(index + 1);
						System.out.println(name);
						// 可以写死路径 将上传位置放出tomcat目录
						String realPath = "F:\\upload";
						// 创建文件对象,将文件上传到这里
						File file = new File(realPath, name);
						//设置临时文件大小
						// 设置内存临界值超过的地方将存在临时文件中单位是kb
						diskFileItemFactory.setSizeThreshold(41960);
						//设置临时文件目录
						diskFileItemFactory.setRepository(new File("F:\\tempupload"));
						//设置单个文件大小
						servletFileUpload.setFileSizeMax(80000);
						try {
							next.write(file);
							System.out.println("上传成功");
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
