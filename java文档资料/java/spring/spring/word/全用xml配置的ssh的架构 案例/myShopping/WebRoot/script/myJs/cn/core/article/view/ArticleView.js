Ext.define("cn.article.view.ArticleView",{
	extend:"Ext.panel.Panel",
	alias:"widget.articleView",
	title:"hahagg",
	defaults:{
		bodyStyle:"padding:1px"
	},
	items:[{
		xtype:"articleGridView"
	}],
	initComponent:function(){
		var self = this;
		self.callParent(arguments);
	}
});