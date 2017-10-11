Ext.define("cn.article.controller.ArticleController",{
	extend:"Ext.app.Controller",
	init:function(){
		var self = this;
		self.control({
			
		});
	},//init
	views:[
		"cn.article.view.ArticleView",
		"cn.article.view.ArticleGridView"
	],
	stores:[
		"cn.article.store.ArticleStore"
	],
	models:[
		"cn.article.model.ArticleModel"
	]
});



