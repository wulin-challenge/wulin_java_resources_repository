Ext.define("cn.app.store.UserTreeStore",{
	extend:"Ext.data.TreeStore",
	model:"cn.app.model.TreeModel",
	//defaultRootId:"root",
	nodeParam:"rootId",
	//autoSync:true,//与服务器同步
	proxy:{
		type:"ajax",
		//url:"user_getTree.action",
		url:"department_getTree.action",
		reader:{
			type:"json"
		},
		writer:{
			type:"json"
		}
	},
	autoLoad:true
});