package cn.wulin.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class variousAction extends ActionSupport{

	private static final long serialVersionUID = 6676787680526283664L;
	private String myList;
	private String myMap;
	public String list() throws Exception {
		List<String> myList=new ArrayList<String>();
		Map<Integer,String> myMap=new HashMap<Integer,String>();
		for(int i=0;i<10;i++){
			myList.add("haha"+i);
			myMap.put(i,"xixi"+i);
		}
		ActionContext.getContext().put("myList",myList);
		ActionContext.getContext().put("myMap",myMap);
		return "intercept";
	}
	
	public String getValue(){
		System.out.println(myList+" "+myMap);
		return null;
	}

	public String getMyList() {
		return myList;
	}

	public void setMyList(String myList) {
		this.myList = myList;
	}

	public String getMyMap() {
		return myMap;
	}

	public void setMyMap(String myMap) {
		this.myMap = myMap;
	}
	
	

}
