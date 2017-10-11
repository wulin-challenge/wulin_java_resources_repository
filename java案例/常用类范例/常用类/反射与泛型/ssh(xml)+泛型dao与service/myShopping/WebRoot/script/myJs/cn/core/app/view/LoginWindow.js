Ext.define("cn.app.view.LoginWindow",{
	extend:"Ext.window.Window",
	title:"登陆系统",
	iconCls:"table_login",
	width:400,
	height:230,
	alias:"widget.loginWindow",
	modal:true,
	closable:true,
	closeAction:"destroy",
	listeners:{
		//当该登陆窗口一显示,就会被监听到,即运行这个方法,并且第一个参数是该窗体的对象
		show:function(loginWindow){
			var remember = Ext.util.Cookies.get("remember");
			if(autoLogin == "true"){
				autoLogin = Boolean(autoLogin);
			}else{
				autoLogin = false;
			}
			if(remember == "true"){
				remember = Boolean(remember);
			}else{
				remember = false;
			}
			
			if(remember){
					var autoLogin = Ext.util.Cookies.get("autoLogin");
					var username = Ext.util.Cookies.get("username");
					var password = Ext.util.Cookies.get("password");
					
					//设置表单的值
					loginWindow.down("form").getForm().findField("username").setValue(username);
					loginWindow.down("form").getForm().findField("password").setValue(password);
					loginWindow.down("checkbox[name=remember]").setValue(remember);
					if(autoLogin){
						loginWindow.down("checkbox[name=autoLogin]").setValue(autoLogin);
						Ext.Ajax.request({
								waitMsg:"正在登陆,请稍后...",
								url:"user_login.action",
								params:{username:username,password:password},
								method:"POST",
								timeout:4000,
								success:function(response,options){
									var user = Ext.decode(response.responseText);
									if(user.username == username && user.password == password &&user.username != "" && user.username != ""){
										
										loginWindow.close();
										Ext.util.Cookies.clear("username");
										Ext.util.Cookies.clear("password");
										Ext.util.Cookies.clear("remember");
										Ext.util.Cookies.clear("autoLogin");
										
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
				}//第二个if
			}
		}
	},
	items:[{//用于占位作用,与所设置的heigth无关,主要是用于做登陆提示信息而留的
		ref:"logininfo",
		xtype:"displayfield",
		value:"",
		heigth:0,
		margin:"10 0 0 0"
	},{
		layout:"column",
		bodyStyle:"background:transparent",
		border:0,
		items:[{
			columnWidth:.7,  //注意 7前面有一个小点,表示0.7,因为参数columnWidth只能为百分比, 其值必须为0到1之间的小数(例如 .25).
			xtype:"form",
			ref:"loginform",
			border:1,
			//bodyStyle: 'background:red',
			defaults:{
				labelSeparator:":",
				labelWidth:40,
				width:200,
				labelAlign:"right",
				msgTarget:"side"
			},
			defaultType : 'textfield',
			bodyStyle: 'background:transparent',//设置为透明,不不妨碍更换主题了
			border:0,
			items:[{
				fieldLabel : "用户名",
				fieldCls : 'username',
				emptyText:"请输入用户名",
				name : 'username',
				margin : "10 10 10 50"
			}, {
				name : 'password',
				fieldLabel : '密&nbsp;&nbsp;&nbsp;码',
				fieldCls : 'password',
				emptyText:"请输入密码",
				inputType : 'password',
				margin : "20 10 10 50"
			}, {
				xtype:"checkbox",
				name : 'remember',
				boxLabel : '记住密码',
				boxLabelAlign : 'after',
				margin : "10 0 0 75"
			},{
				xtype:"checkbox",
				name : 'autoLogin',
				boxLabel : '自动登陆',
				boxLabelAlign : 'after',
				margin : "-18 0 0 165",
			}]//items
		},{
			layout:'fit',
			bodyStyle: 'background:transparent',//设置为透明,不不妨碍更换主题了
			border:0,
			columnWidth:.28,// //注意 7前面有一个小点,表示0.28,因为参数columnWidth只能为百分比, 其值必须为0到1之间的小数(例如 .25).
			items:[{
				xtype : "displayfield",
				hideLabel : true,
				margin : "0 0 0 0",
				value : "<img height=100 src='style/css/imgs/logo/logo.gif' />"
			}]
		}]//items
	}],
	buttons:[{
		xtype:"button",
		text:"登陆",
		ref:"login",
		width:50
	},{
		xtype:"button",
		text:"退出",
		width:50,
		handler:function(button){
			var loginWindow = button.up("loginWindow");
			Ext.Msg.confirm("提示","是否要退出系统",function(value){
				if(value == 'yes'){
					if(document.all){//IE
						window.open('', '_parent', '');
						window.close();
					}else{//FF
						window.open('', '_self', '');
						button.up("loginWindow").down("displayfield").setValue("<font color=red>提示：检测到当前是Firefox浏览器！请在址栏上输入about:config然后回车;搜索dom.allow_scripts_to_close_windows双击修改值为true再试此功能，这样才能关闭窗口</font>");
						window.close();
					}
				}
			},this);
		}
	}]
	
});