package cn.itcast.bbs.filter;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.bbs.domain.Address;
import cn.itcast.bbs.domain.Flow;
import cn.itcast.bbs.service.BbsService;

//过滤welcome.jsp页面
public class IpAddressFilter implements Filter {
	public void destroy() {
	}
	public void doFilter(
			ServletRequest req, 
			ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		try {
			//接口强转
			HttpServletRequest request = (HttpServletRequest) req;
			HttpServletResponse response = (HttpServletResponse) res;
			// 取得HttpSession对象
			HttpSession session = request.getSession();
			// 判段当前用户HttpSession中是否存在IP归属地信息
			Address address = (Address) session.getAttribute("address");
			// 如果没有
			if(address == null){
				// 取得IP地址
				String ip = request.getRemoteAddr();
				BbsService bbsService = new BbsService();
				// 取得对应的归属地
				address = bbsService.findAddressByIP(ip);
				// 绑定到HttpSession中
				session.setAttribute("address",address);
			}
			
			ServletContext context = session.getServletContext();
			Integer yesterdayFlow = (Integer) context.getAttribute("yesterdayFlow");
			//第一次
			if(yesterdayFlow==null){
				BbsService bbsService = new BbsService();
				//取得昨天日期
				Calendar c = Calendar.getInstance();
				c.add(Calendar.DATE,-1);
				//取得昨日流量
				Flow flow = bbsService.findFlowByDate(c.getTime());
				if(flow==null){
					context.setAttribute("yesterdayFlow",0);
				}else{
					context.setAttribute("yesterdayFlow",flow.getNum());
				}
			}
			//发行资源
			chain.doFilter(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public void init(FilterConfig filterConfig) throws ServletException {
	}
}
