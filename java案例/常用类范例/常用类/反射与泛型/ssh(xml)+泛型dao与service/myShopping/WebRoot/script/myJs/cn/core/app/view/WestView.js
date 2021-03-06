Ext.define("cn.app.view.WestView",{
	extend:"Ext.panel.Panel",
	alias:"widget.westView",
	collapsible:true,
	split:true,
	defaults:{
		bodyStyle:"padding:2px"
	},
	border:1,
	margins:"2 2 0 0",
	width:225,
	minSize:100,
	maxSize:250,
	title:"功能模块导航",
	layout:"fit",
	layoutConfig:{
		titleCollapse:false,
		animate:true,
		activeOnTop:true
	},
	items:[{
		xtype:"treepanel",
		id:"westTreeView",
		rootVisible:false,
		displayField:"text",
		border:0,
		store:"cn.app.store.UserTreeStore",
	}],
	initComponent:function(){
		this.callParent(arguments);
	}
});