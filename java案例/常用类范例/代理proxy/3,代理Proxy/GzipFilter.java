package cn.itcast.java.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GzipFilter implements Filter {
	public void destroy() {
	}
	public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		MyResponse myResponse = new MyResponse(response);
		chain.doFilter(request,myResponse.getProxy());
		//取得缓存中的数据
		byte[] buf = myResponse.getBuffer();
		System.out.println("压缩前：" + buf.length);
		//以下是压缩代码
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		GZIPOutputStream gout = new GZIPOutputStream(bout);
		gout.write(buf);
		gout.flush();
		gout.close();
		//取得压缩后的数据
		buf = bout.toByteArray();
		System.out.println("压缩后：" + buf.length);
		//向浏览器发送压缩后的数据
		response.setHeader("content-encoding","gzip");
		response.setHeader("content-length",buf.length+"");
		response.getOutputStream().write(buf);
	}
	public void init(FilterConfig filterConfig) throws ServletException {
	}
}

//使用动态代理方式产生代理对象
class MyResponse{
	private HttpServletResponse response;
	//缓存
	private ByteArrayOutputStream bout = new ByteArrayOutputStream();
	public MyResponse(HttpServletResponse response){
		this.response = response;
	}
	//取得缓存中的数据
	public byte[] getBuffer(){
		return bout.toByteArray();
	}
	public HttpServletResponse getProxy(){
		return (HttpServletResponse) Proxy.newProxyInstance(
				MyResponse.class.getClassLoader(), 
				response.getClass().getInterfaces(),
				new InvocationHandler(){
					public Object invoke(
							Object proxy, 
							Method method,
							Object[] args) throws Throwable {
						if("getOutputStream".equals(method.getName())){
							return new MyServletOutputStream(bout);	
						}else{
							return method.invoke(response,args);
						}
					}
				});
	}
}
//带有缓存功能的ServletOutputStream
class MyServletOutputStream extends ServletOutputStream{
	private ByteArrayOutputStream bout;
	public MyServletOutputStream(ByteArrayOutputStream bout){
		this.bout = bout;
	}
	@Override
	public void write(int b) throws IOException {
	}
	//将字节数据写入缓存
	public void write(byte[] buf) throws IOException {
		bout.write(buf);
		bout.flush();
	}
}






