Ext.define('meeting.view.MailInfoIndex',{
	extend:'Ext.ux.panel.Panel',
	requires: [
	'meeting.view.MailInfoList',
	'meeting.store.MailInfo'
	],
	border:false,
	layout: {
        type: 'vbox',
		align: 'stretch'
    },
	initComponent:function(){
		var me = this;
		
		var list = Ext.create('meeting.view.MailInfoList');
		list.getExtraParams = function(){
			var extraParams = {};
			var val = searchCombobox.getValue()==null ? "" : searchCombobox.getValue();
			var rules = [];
			if(selectCheckbox.getValue()){
				var ids = list.collection.keys.join(",");
				rules.push({field:'id',data:ids,op:'in'});
			}
			extraParams.filters = Ext.JSON.encode({rules:rules});
			extraParams.searchKey = val;
			return extraParams;
		};
		
		var searchCombobox = Ext.create('Ext.ux.form.field.SearchText',{
			emptyText: '姓名|编号,多个逗号分隔',
		    store:list.store
		});
		
		var selectCheckbox = Ext.create('Ext.form.field.Checkbox',{
			boxLabel  : '仅显示已选',
			listeners:{
				change:function(checkbox, newValue, oldValue, eOpts ){
					list.store.loadPage(1);
				}
			}
		});
		
		var showPrisonCureEdit = function(record){
			var item = record || null;
			var operationType = 'create';
			var ccid = null;
			if(record){
				operationType = 'update';
				ccid = record.data.ccid ;
			}
			var PrisonCureEditTab = Ext.create('meeting.view.MailInfoEdit',{
				list:list,
				ccid:ccid,
				record:item,
				operationType: operationType
			});
			Ext.create('Ext.ux.window.Window',{
				title:'罪犯信件信息',
				width: 900,
				minHeight:300,
				constrain:true,
				layout: 'fit',
				modal : true,
				items:[PrisonCureEditTab]
			}).show();
			PrisonCureEditTab.focusFirstField();
		}
		
		var actionBar = Ext.create('Ext.toolbar.Toolbar', {
			border:false,
			width:'100%',
			height:30,
			items: [
				{
					xtype:'displayfield',
					value:'关键字:'
				},
				searchCombobox,
				{
					text: '搜索',iconCls:'icon-search',
					handler:function(button){
						list.store.loadPage(1);
					}
				},
				{
					text: '重置',iconCls:'icon-reset',
					handler:function(button){
						searchCombobox.setValue("");
						selectCheckbox.setValue(false);
						list.collection.clear();
						list.store.loadPage(1);
					}
				},selectCheckbox,
				{text:'添加',iconCls:'icon-add',
					xtype:'permbutton',ifAnyGranted:'ROLE_MAILINFO_CREATE',
					handler : function(button){
						showPrisonCureEdit();
					}
				},
				{text:'修改',iconCls:'icon-update',
					xtype:'permbutton',ifAnyGranted:'ROLE_MAILINFO_UPDATE',
					handler:function(button){
						var records = list.getSelectionModel().getSelection();
						if(records.length!=1){
							Ext.ux.Msg.error("请选择一条数据进行修改操作");
						}else{
							showPrisonCureEdit(records[0]);
						}
					}},
				{text:'删除',iconCls:'icon-remove',
					xtype:'permbutton',ifAnyGranted:'ROLE_MAILINFO_DELETE',
					handler:function(button){
						var ids = [];
						list.collection.eachKey(function(id,record,index){
							 ids.push(id);
						 });
						if(ids.length==0){
							Ext.ux.Msg.error("请选择一条数据进行删除操作");
				    		return;
						}
						Ext.Msg.confirm("信息框", "请确认删除", function(op){
							if(op == "yes"){
								Ext.ux.Ajax.request({
								    url: list.getStore().batchDestroy,
								    params: {  ids: ids  },
								    success: function(response){
								    	var result = Ext.JSON.decode(response.responseText);
								        list.collection.clear();
								        list.store.reload();
								        Ext.ux.Msg.show(result.statusText);
								    }
								});
							}
						});
					}
				},{
					text:'下载登记模板',iconCls:'icon-download',
					handler:function(button){
						var form = document.createElement('form');
						Ext.fly(form).set({
							method:'GET',
							action:list.getStore().download
						});
						form.submit();
					}
				},{
					text: '导出Excel',iconCls: 'icon-export',handler: function(b){
						Ext.create('platform.view.ExportExcel',{filename:"罪犯信件"}).exp(list);
					}
				}
			]
		});	
		me.items = [actionBar,list];
		me.callParent(arguments);
	}	
});



