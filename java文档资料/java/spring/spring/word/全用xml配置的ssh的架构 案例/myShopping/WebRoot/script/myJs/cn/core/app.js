Ext.onReady(function(){
	Ext.QuickTips.init();//打开ext的提示功能
	Ext.Loader.setConfig({ //启动动态加载js
		enabled : true
	});
	Ext.Loader.setPath('Ext.ux', 'script/js/extjs4/examples/ux'); 
	Ext.require([
		"Ext.ux.CheckColumn",
		"Ext.ux.form.SearchField"
	]);
	/**
	 * 开始执行应用程序
	 */
	Ext.application({
		name : "cn", //命名空间
		appFolder : "script/myJs/cn/core",
//		launch:function(){
//			var self = this;
//			Ext.create("Ext.container.Viewport",{
//				layout : "fit",
//				border:0,
//				items:[{
//					xtype : "mainViewLayout"
//				}]
//			});//create
//		},//launch
		controllers : ["cn.app.controller.MainController"],
	});
});

