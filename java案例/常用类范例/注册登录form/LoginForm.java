package cn.itcast.bbs.form;

import java.util.HashMap;
import java.util.Map;
import cn.itcast.bbs.domain.User;

public class LoginForm {
	private String username;
	private String password;
	private Map<String,String> errors = new HashMap<String,String>();
	public boolean validate(User user){
		boolean flag = false;
		this.username = user.getUsername();
		this.password = user.getPassword();
		if(
			this.validateUsername(username) &
			this.validatePassword(password)
		){
			flag = true;
		}
		return flag;
	}
	//验证用户名[必填+中文]
	private boolean validateUsername(String username){
		boolean flag = false;
		if(username!=null && username.trim().length()>0){
			if(username.matches("[\u4E00-\uFA29]+")){
				flag = true;
			}else{
				this.errors.put("username","<font color='red'>用户名必须是中文</font>");
			}
		}else{
			this.errors.put("username","<font color='red'>用户名必填</font>");
		}
		return flag;
	}
	//验证密码[必填+数字6位]
	private boolean validatePassword(String password){
		boolean flag = false;
		if(password!=null && password.trim().length()>0){
			if(password.matches("[0-9]{6}")){
				flag = true;
			}else{
				this.errors.put("password","<font color='red'>密码必须是6位数字</font>");
			}
		}else{
			this.errors.put("password","<font color='red'>密码必填</font>");
		}
		return flag;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
}
