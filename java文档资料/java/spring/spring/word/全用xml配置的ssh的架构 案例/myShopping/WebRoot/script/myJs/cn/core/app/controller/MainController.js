//主控制器
Ext.define("cn.app.controller.MainController",{
	extend : "Ext.app.Controller",
	init : function(){
		var self = this;
		/**显示登陆窗口*/
		var loginWindow = Ext.create("cn.app.view.LoginWindow")
		loginWindow.show();
		
		self.addFunItem=function(funInfo){
			if(funInfo){
				var flag = false;
				var tabs = funInfo.mainView;
				//var funPanel = tabs.down(funInfo.funViewXtype);
				var treeNode = funInfo.record.raw;
				var id = treeNode.id;
				var idx = treeNode.id+"x";
				var text = treeNode.text;
				var rootId = treeNode.rootId;
				var tab = tabs.getComponent(idx);//这里的Id最好不要是数字,否则可能出现异常
				
				if(!tab){//如果Tab不存在
					self.application.getController(funInfo.funController).init();
					var funViewXtype = funInfo.funViewXtype;
					var departmentStore = Ext.create("cn.department.store.DepartmentStore",{
						proxy:{
							type:"ajax",
							url:"department_list.action?id="+id,
							reader:{
								type:"json",
								root:"rows",
								totalProperty:"totalCount"
							},
							writer:{
								type:"json"
							}
						},
					});
					var departmentGridView = Ext.create("cn.department.view.DepartmentGridView",{
						store:departmentStore,
						bbar:[{
							xtype:"pagingtoolbar",
							store:departmentStore,
							displayInfo:true,
							displayMsg:"显示{0}-{1}条,共计{2}条",
							emptyMsg:"没有数据"
						}],
						dockedItems:[{
							dock:"top",
							xtype:"toolbar",
							items:[{
								width:300,
								fieldLabel:"部门编号",
								hasSearch:true,
								labelWidth:60,
								emptyText:"请输入部门编号",
								paramName:"departmentId",
								xtype:"searchfield",
								store:departmentStore,
								onTrigger2Click:function(){
									var me = this,
							        value = me.getValue().trim();
									if(value == ""){
										Ext.Msg.alert("输入提示","输入不能为空");
										return;
									}else{
										if(!value.match("^[0-9]+$")){
											Ext.Msg.alert("输入提示","只能输入数字");
											return;
										}
									}
							        if (value.length >0) {
							            me.store.filter({
							                id: me.paramName,
							                property: me.paramName,
							                value: value
							            });
							            
							            me.hasSearch = true;
							            me.triggerCell.item(0).setDisplayed(true);
							            me.updateLayout();
							        }
								}
							},"-",{
								xtype:"button",
								ref:"deleteRows",
								width:50,
								iconCls:"table_remove",
								text:"删除"
							}]
						}]
					});
					var departmentView = Ext.create("cn.department.view.DepartmentView",{
						items:departmentGridView
					});
					
					
					var newTab = tabs.add({
						id:idx,
						closable:true,
						title:text,
						items:departmentView
						//xtype:viewAlias
					});
					newTab.show();
				}else{
					tabs.setActiveTab(tab);
				}
			}
		};
		self.control({
			"addTreeNodeView button[ref=saveTreeNodeWindow]":{
				click:function(button){
					var nodeName = button.up("addTreeNodeView").down("form").getForm().findField("nodeName").getValue();
					var parentName = button.up("addTreeNodeView").down("form").getForm().findField("parentName").getValue();
					var typeName = button.up("addTreeNodeView").down("form").getForm().findField("typeName").getValue();
					Ext.Ajax.request({
						waitMsg:"正在登陆,请稍后...",
						url:"department_setTreeSave.action",
						params:{nodeName:nodeName,parentName:parentName,typeName:typeName},
						method:"post",
						timeout:4000,
						success:function(response,options){
							var information = Ext.decode(response.responseText);
							if(information.information == "success"){
								var tree = Ext.getCmp("westTreeView");
								//tree.getStore().load();
								var store = tree.getStore();
								store.load({node:store.getNodeById(parentName)}); 
								button.up("addTreeNodeView").close();
							}else{
								Ext.Msg.alert("提示消息",information.information);
							}
						}
					});
				}
			},
			"loginWindow button[ref=login]":{//这里其实也相当于是LoginWindow类的一部分,其实就是一部分
				click:function(button){
					var loginWindow = button.up("loginWindow");
					var username = loginWindow.down("form").getForm().findField("username").getValue();
					var password = loginWindow.down("form").getForm().findField("password").getValue();
					var remember = loginWindow.down("checkbox[name=remember]").getValue();
					var autoLogin = loginWindow.down("checkbox[name=autoLogin]").getValue();
					
					
					Ext.Ajax.request({
						waitMsg:"正在登陆,请稍后...",
						url:"user_login.action",
						params:{username:username,password:password},
						method:"POST",
						timeout:4000,
						success:function(response,options){
							var user = Ext.decode(response.responseText);
							if(user.username == username && user.password == password &&user.username != "" && user.username != ""){
								//var mainViewLayout = Ext.getCmp("mainViewLayout");
								//mainViewLayout.show();
								loginWindow.close();
								Ext.util.Cookies.set("username",username);
								Ext.util.Cookies.set("password",password);
								Ext.util.Cookies.set("remember",remember);
								Ext.util.Cookies.set("autoLogin",autoLogin);
							}else{
								Ext.Msg.alert("提示消息","用户名或密码错误!");
								Ext.util.Cookies.clear("username");
								Ext.util.Cookies.clear("password");
								Ext.util.Cookies.clear("remember");
								Ext.util.Cookies.clear("autoLogin");
							}
						}
					});
				}
			},
			"westView treepanel":{
				itemclick:function(tree,record,item,index,eOPtions){
					var rootId = record.raw.rootId;
					var id = record.raw.id;
						var mainView = tree.up("mainViewLayout").down("centerView");
					if(rootId == "1"){
						self.addFunItem({
							tree:tree,
							record:record,
							mainView:mainView,
							funViewXtype:"departmentView",
							funController:"cn.department.controller.DepartmentController",
							funViewName:"cn.department.view.DepartmentView"
						});
					}else if(rootId == "2"){
						self.articleManagerment({
							tree:tree,
							record:record,
							mainView:mainView,
							funViewXtype:"articleView",
							funController:"cn.article.controller.ArticleController",
							funViewName:"cn.article.view.ArticleView"
						});  
					}
				},
				beforeload:function(store,operation,object){
					var treeStore = Ext.getCmp(store.storeId);
					alert("1 = "+store.storeId+" 2 = "+operation+" 3 = "+object);
				},
				itemcontextmenu:function(tree,record,item,index,eOPtions){
					var nodeId = record.raw.id;
					var nodePerentId = record.data["parentId"];
					var nodeRootId = record.raw.rootId;
					var idx = record.raw.id+"xx";
					var myTreeMenu = Ext.getCmp("myTreeMemu");
					if(myTreeMenu != null){
						myTreeMenu.close();
					}
					var contextMenu = Ext.create("Ext.menu.Menu",{
						id:"myTreeMemu",
						items:[{
							text:"添加兄弟节点",
							id:idx,
							handler:function(){
								var addTreeWindow = Ext.create("cn.department.view.AddTreeNodeView",{
									title:"添加兄弟节点"
								});
								addTreeWindow.down("form").getForm().findField("parentName").setValue(nodePerentId);
								addTreeWindow.down("form").getForm().findField("typeName").setValue(nodeRootId);
								addTreeWindow.show();
							}
						},{
							text:"添加子节点",
							id:idx+"x",
							handler:function(){
								var addTreeWindow = Ext.create("cn.department.view.AddTreeNodeView",{
									title:"添加子节点"
								});
								addTreeWindow.down("form").getForm().findField("parentName").setValue(nodeId);
								addTreeWindow.down("form").getForm().findField("typeName").setValue(nodeRootId);
								addTreeWindow.show();
							}
						},{
							text:"编辑该节点",
							id:idx+"xx",
							handler:function(){
								alert(record.raw.id);
							}
						},{
							text:"删除该节点及子节点",
							id:idx+"xxx",
							handler:function(){
								alert(record.raw.id);
							}
						}]
					});
					eOPtions.preventDefault();
					contextMenu.showAt(eOPtions.getXY());
				}
			}
		});//self.control
	},//function
	views:[
		"cn.app.view.LoginWindow",
		"cn.app.view.MainViewLayout",
		"cn.app.view.WestView",
		"cn.app.view.CenterView",
		"cn.app.view.TopView"
	],
	stores : [
		"cn.app.store.UserTreeStore"
	],
	models : [],
	
	articleManagerment:function(funInfo){
		var self = this;
		if(funInfo){ //等价于funInfo != null
			var tabs = funInfo.mainView;
			var treeNode = funInfo.record.raw;
			var id = treeNode.id;
			var idx = treeNode.id+"x";
			var text = treeNode.text;
			var rootId = treeNode.rootId;
			var tab = tabs.getComponent(idx);//这里的Id最好不要是数字,否则可能出现异常
			if(!tab){// 如果tab不存在				
				self.application.getController(funInfo.funController).init();
				var funViewXtype = funInfo.funViewXtype;
				var newTab = tabs.add({
					id:idx,
					closable:true,
					title:text,
					xtype:funViewXtype
					//items:departmentView				
					});
				newTab.show();
			}else{
				tabs.setActiveTab(tab);
			}
		}
	},
});

