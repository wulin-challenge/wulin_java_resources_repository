Ext.define("cn.department.controller.DepartmentController",{
	extend:"Ext.app.Controller",
	
	init:function(){
		var self = this;
		self.control({
			
		});
	},
	views:[
		"cn.department.view.DepartmentView",
		"cn.department.view.DepartmentGridView",
		"cn.department.view.AddTreeNodeView"
	],
	stores:[
		"cn.department.store.DepartmentStore"
	],
	models:[
		"cn.department.model.DepartmentModel"
	]
});