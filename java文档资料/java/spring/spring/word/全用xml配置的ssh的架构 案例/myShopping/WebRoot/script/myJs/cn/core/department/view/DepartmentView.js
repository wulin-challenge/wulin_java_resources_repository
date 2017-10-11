Ext.define("cn.department.view.DepartmentView", {
	extend : "Ext.panel.Panel",
	alias : "widget.departmentView",
	//title : "部门管理",
	//closable : true,
	defaults : {
		bodyStyle : "padding:1px"
	},
	items:[{
		xtype:"departmentGridView"
	}],
	initComponent : function() {
		this.callParent(arguments);
	}
});
