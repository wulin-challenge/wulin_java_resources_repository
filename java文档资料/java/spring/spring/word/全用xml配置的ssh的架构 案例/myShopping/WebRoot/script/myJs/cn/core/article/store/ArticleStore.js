Ext.define("cn.article.store.ArticleStore",{
	extend:"Ext.data.Store",
	model:"cn.article.model.ArticleModel",
	alias:"widget.articleStore",
	pageSize:10,  //每页显示5条记录
	//autoSync:true,  //与服务器同步
	proxy:{
		type:"ajax",
		url:"article_list.action",
		reader:{
			type:"json",
			root:"rows",
			totalProperty:"totalCount"
		},
		writer:{
			type:"json"
		}
	},
	sorters:[{
		property:"id",
		direction:"DESC"
	}],
	autoLoad:true
});

