Ext.define("cn.department.view.DepartmentGridView",{
	extend:"Ext.grid.Panel",
	alias:"widget.departmentGridView",
	store:"cn.department.store.DepartmentStore",
	multiSelect:true,
	frame:true,
	enableKeyNav:true,//可以用键盘控制上下
	columnLines:true,//展示竖线
	disableSelection:false,//值为true表示禁止选择行
	selModel:Ext.create("Ext.selection.CheckboxModel"),
	columns:[
		{xtype:"rownumberer"},
		{text:"部门编号",dataIndex:"id",width:100},
		{text:"部门名称",dataIndex:"text",width:100,border:50},
		{text:"显示别名",dataIndex:"rootId",width:100}
	],
	bbar:[{
		xtype:"pagingtoolbar",
		store:"cn.department.store.DepartmentStore",
		displayInfo:true,
		displayMsg:"显示{0}-{1}条,共计{2}条",
		emptyMsg:"没有数据"
	}],
	
	initComponent:function(){
		this.callParent(arguments);
	}
});


