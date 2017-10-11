Ext.define("cn.article.model.ArticleModel",{
	extend:"Ext.data.Model",
	fields:[
		{name:"id",type:"int",srotable:true},
		{name:"title",type:"string",srotable:true},
		{name:"author",type:"string",srotable:true},
		{name:"clickNumber",type:"int",srotable:true},
		{name:"publishTime",type:"date",srotable:true,dataFormat:"Y-m-d"},
		{name:"auditing",type:"bool"},
		{name:"publishPlace",type:"string",srotable:true}
	]
});

