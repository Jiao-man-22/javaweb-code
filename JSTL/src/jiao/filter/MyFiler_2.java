package jiao.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
/**
servlet3.0������Ҳ����ע��ʵ��
*/
@WebFilter(filterName="Servlet3Filter",urlPatterns="/MyServlet")
public class MyFiler_2 implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
		System.out.append("init...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.append("��������");
		//�������
		chain.doFilter(request, response);
		System.out.append("��Ӧ����");

	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
		System.out.append("destroy");
	}

}
