package cn.wulin.action;

import cn.wulin.action.util.ActionUtil;
import cn.wulin.base.ModelDrivenBaseAction;
import cn.wulin.domain.Tree;

public class TreeAction extends ModelDrivenBaseAction<Tree>{
	private static final long serialVersionUID = -6698972047886049611L;
	
	public String getTree() throws Exception {
		
		Tree tree = treeService.findEntity(ActionUtil.getId(model.getId()));
		if(tree != null && tree.getService().equals("departmentService")){
			//departmentService.findChildren(id)
		}
		return null;
	}
	
	public String save() throws Exception {
		Tree tree = new Tree();
		tree.setText("苹果");
		tree.setLeaf(false);
		tree.setService("appleService");
		treeService.saveEntity(tree);
		return null;
	}
}
