package cn.itcast.web.decorator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

//对HttpServletRequest对象包装/装饰
public class MyRequest extends HttpServletRequestWrapper{
	private HttpServletRequest request;
	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	//重写父类的方法
	public String getParameter(String name) {//表单项的名字
		String value = null;
		//取得客户端的请求方式[GET/POST]
		String method = request.getMethod();
		if("GET".equals(method)){
			try {
				value = request.getParameter(name);//乱码
				byte[] buf = value.getBytes("ISO8859-1");
				value = new String(buf,"UTF-8");//正码
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("POST".equals(method)){
			try {
				request.setCharacterEncoding("UTF-8");
				value = request.getParameter(name);//正码
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		value = filter(value);
		return value;
	}
	//转义方法
	public String filter(String message) {
        if (message == null)
            return (null);
        char content[] = new char[message.length()];
        message.getChars(0, message.length(), content, 0);
        StringBuffer result = new StringBuffer(content.length + 50);
        for (int i = 0; i < content.length; i++) {
            switch (content[i]) {
            case '<':
                result.append("&lt;");
                break;
            case '>':
                result.append("&gt;");
                break;
            case '&':
                result.append("&amp;");
                break;
            case '"':
                result.append("&quot;");
                break;
            default:
                result.append(content[i]);
            }
        }
        return (result.toString());
    }
}





