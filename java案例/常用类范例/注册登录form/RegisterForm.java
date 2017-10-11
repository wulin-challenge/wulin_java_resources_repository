package cn.itcast.bbs.form;

import java.util.HashMap;
import java.util.Map;
import cn.itcast.bbs.domain.User;

public class RegisterForm {
	private String username;
	private String password;
	private String gender;
	private String email;
	private Map<String,String> errors = new HashMap<String,String>();
	public boolean validate(User user){
		boolean flag = false;
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.gender = user.getGender();
		this.email = user.getEmail();
		if(
			this.validateUsername(username) &
			this.validatePassword(password)&
			this.validateEmail(email)
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
	//验证箱邮[必填+格式合法邮箱]
	private boolean validateEmail(String email){
		boolean flag = false;
		if(email!=null && email.trim().length()>0){
			if(email.matches("\\w+@\\w+(\\.\\w+)+")){
				flag = true;
			}else{
				this.errors.put("email","<font color='red'>邮箱格式不合法</font>");
			}
		}else{
			this.errors.put("email","<font color='red'>邮箱必填</font>");
		}
		return flag;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getGender() {
		return gender;
	}
	public String getEmail() {
		return email;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
}
