Ext.define("cn.department.controller.DepartmentController",{
	extend:"Ext.app.Controller",
	
	init:function(){
		var self = this;
		self.control({
			"departmentGridView button[ref=deleteRows]":{
				click:function(button){
					var gridWindow = button.up("departmentGridView");
					var record = gridWindow.getSelectionModel().getSelection();
					if(record.length == 0){
						Ext.MessageBox.show({
							title:"提示",
							msg:"请至少选择一条数据",
							buttons: Ext.Msg.OK,
						});
						return;
					}else{
						Ext.Msg.confirm("删除提示","确定删除吗?",function(option){
							if(option == "no"){
								return;
							}else if(option == "yes"){
								var ids = "";
								for(var i = 0; i < record.length;i++){
									ids +=record[i].get("id");
									if(i<record.length-1){
										ids = ids + ",";
									}
								}
													
								Ext.Ajax.request({
									waitMsg:"正在登陆,请稍后...",
									url:"department_delete.action",
									params:{departmentIds:ids},
									method:"POST",
									timeout:4000,
									success:function(response,options){
										//var user = Ext.decode(response.responseText);
										var store = gridWindow.getStore();
										store.load();
									}
								});
							}
						},this);
				}
				}//click
			}
		});
	},
	views:[
		"cn.department.view.DepartmentView",
		"cn.department.view.DepartmentGridView",
		"cn.department.view.AddTreeNodeView"
	],
	stores:[
		"cn.department.store.DepartmentStore"
	],
	models:[
		"cn.department.model.DepartmentModel"
	]
});