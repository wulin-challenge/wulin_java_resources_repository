Ext.define("cn.app.view.CenterView",{
	extend:"Ext.tab.Panel",
	alias:"widget.centerView",
	id:"centerView",
	border:0,
	bodyStyle:"padding :0px",
	menuAlign:"center",
	items:[{
		title:"首页",
		bodyPadding :5,
		layout:"fit",
		html:"<h1><font color='blue'>欢迎你访问本系统</font></h1>"
	}],
	initComponent:function(){
		this.callParent(arguments);
	}
});