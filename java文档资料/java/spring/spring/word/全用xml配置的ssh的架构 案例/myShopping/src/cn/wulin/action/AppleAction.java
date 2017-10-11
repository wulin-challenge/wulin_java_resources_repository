package cn.wulin.action;

import cn.wulin.base.ModelDrivenBaseAction;
import cn.wulin.domain.Apple;

public class AppleAction extends ModelDrivenBaseAction<Apple> {

	private static final long serialVersionUID = -5469354796962818361L;

	public String save() throws Exception {
		Apple apple = new Apple();
		apple.setText("苹果");
		apple.setLeaf(false);
		apple.setTree(treeService.findEntity(1l));
		appleService.saveEntity(apple);
		return null;
	}

}
