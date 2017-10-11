package cn.wulin.action;

import cn.wulin.domain.User;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 2704068177368336914L;

	public String intercept(ActionInvocation invocation) throws Exception {
		if(LoginAction.class==invocation.getAction().getClass()){
			return invocation.invoke();
		}else{
			User user=(User) invocation.getInvocationContext().getSession().get("user");
			if(user==null){
				return "input";
			}
		}
		return invocation.invoke();
	}

}
