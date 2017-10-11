package cn.wulin.action;

import java.util.List;

import cn.wulin.domain.Test;
import cn.wulin.service.TestService;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{

	private static final long serialVersionUID = 6266539271670635779L;
	private TestService testService;
	
	public String save() throws Exception {
		Test test = new Test();
		test.setName("haha");
		test.setAge(25);
		testService.saveEntity(test);
		return null;
	}
	
	public String list() throws Exception {
		List<Test> testList = testService.findAll();
		for (Test test : testList) {
			System.out.println(test.getId()+","+test.getName());
		}
		return null;
	}
	
	
	
	//============
	
	public TestService getTestService() {
		return testService;
	}
	public void setTestService(TestService testService) {
		this.testService = testService;
	}
	
	

}
