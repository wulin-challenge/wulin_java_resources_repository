package cn.wulin.action;

import java.util.List;

import cn.wulin.base.ModelDrivenBaseAction;
import cn.wulin.domain.Test;

public class TestAction extends ModelDrivenBaseAction<Test>{

	private static final long serialVersionUID = 6266539271670635779L;
	
	public String save() throws Exception {
		Test test = new Test();
		test.setName("haha");
		test.setAge(25);
		testService.saveEntity(test);
		return null;
	}
	
	public String list() throws Exception {
		
		System.out.println(model.getId()+","+model.getName());
		List<Test> testList = testService.findAll();
		for (Test test : testList) {
			System.out.println(test.getId()+","+test.getName());
		}
		return null;
	}

}
