package cn.itcast.web.decorator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

//对response对象的装饰/包装
public class MyResponse extends HttpServletResponseWrapper{
	private HttpServletResponse response;
	//缓存
	private ByteArrayOutputStream bout = new ByteArrayOutputStream();
	private PrintWriter pw;
	public MyResponse(HttpServletResponse response) {
		super(response);
		this.response = response;
	}
	//重写父类方法,目的是将字节输出到缓存中去[字节]
	public ServletOutputStream getOutputStream() throws IOException {
		return new MyServletOutputStream(bout);
	}
	//重写父类方法,目的是将字符输出到缓存中去[字符]
	public PrintWriter getWriter() throws IOException {
		pw = new PrintWriter(new OutputStreamWriter(bout,"UTF-8"));
		return pw;
	}
	//取得缓存中的数据
	public byte[] getBuffer(){
		if(pw!=null){
			pw.flush();
		}
		return bout.toByteArray();
	}
}
//带有缓存功能ServletOutputStream
class MyServletOutputStream extends ServletOutputStream{
	private ByteArrayOutputStream bout;
	public MyServletOutputStream(ByteArrayOutputStream bout) {
		this.bout = bout;
	}
	public void write(int b) throws IOException {
	}
	public void write(byte[] bytes) throws IOException {
		//将字节数组的内容写入缓存
		bout.write(bytes);
		//确保所有字节数组内容进入缓存
		bout.flush();
	}
}






