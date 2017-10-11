package cn.scxh.ittx.ui.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.scxh.ittx.domain.User;
import cn.scxh.ittx.exception.QueryObjectException;
import cn.scxh.ittx.service.impl.UserServiceImpl;
import cn.scxh.ittx.service.intf.UserService;

public class FormLoginValidate {
	Map<String,String> validateError=new HashMap<String,String>();
	
	public Map<String,String> userLoginValidate(User user){
		if(userNameValidate(user)&passwordValidate(user)){
			return null;
		}
		return validateError;
	}
	//用户名验证
	public boolean userNameValidate(User user){
		boolean flag=false;
		if(user.getName()!=null&&!user.getName().equals("")){
			UserService userService=new UserServiceImpl();
				try {
					List<User> userList=userService.variousConditionQueryUsers(user);
					if(userList.isEmpty()){
						validateError.put("userNameError","亲 ! 你的用户名或密码不正确" );
					}else{
						flag=true;
					}
					
				} catch (QueryObjectException e) {
					validateError.put("userNameError","亲 ! 你的用户名不正确" );
				}
			
		}else{
			validateError.put("userNameError","亲 ! 用户名不能为空" );
		}
		return flag;
	}
	
	//密码验证
	public boolean passwordValidate(User user){
		boolean flag=false;
		if(user.getPassword()!=null&&!user.getPassword().equals("")){
			UserService userService=new UserServiceImpl();
				try {
					List<User> userList=userService.variousConditionQueryUsers(user);
					if(!userList.isEmpty()){
						if(!userList.get(0).getPassword().equals(user.getPassword())){
							System.out.println(userList.get(0).getPassword());
							validateError.put("passwordError","亲 ! 你的用户名或密码不正确" );
						}
					}
					flag=true;
				} catch (QueryObjectException e) {
					validateError.put("passwordError","亲 ! 你的用户名或密码不正确" );
				}
		}else{
			validateError.put("passwordError","亲 ! 用密码不能为空" );
		}
		return flag;
	}
}






