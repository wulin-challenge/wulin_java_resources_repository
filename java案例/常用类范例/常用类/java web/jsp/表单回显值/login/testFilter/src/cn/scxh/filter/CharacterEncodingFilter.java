package cn.scxh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("*********filter destroy******************");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("11111111111111111");
		chain.doFilter(request, arg1);
		System.out.println("2222222222222222222222222222");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("*********filter init******************");
	}
	
	public CharacterEncodingFilter(){
		System.out.println("*******CharacterEncodingFilter สตภýปฏ*************88");
	}
	

}
