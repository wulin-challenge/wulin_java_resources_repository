Ext.define('writ.view.zfhjNotice.Index',{
	extend: 'Ext.ux.panel.Panel',
	border: false,
	layout: {
		type: 'vbox',
		align: 'stretch'
	},
	initComponent: function(){
		var me = this;
		var showWin = function(title,record){
			var win = Ext.create('writ.view.zfhjNotice.Edit',{list:list,record:record});
			Ext.create('Ext.ux.window.Window',{
				title: title,
				width: 900,
				modal: true,
				constrain: true,
				layout: 'fit',
				resizable: false,
				maximizable: true,
				closeAction: 'hide',
				items:[win]
			}).show();
		};
		
		var list = Ext.create('writ.view.zfhjNotice.List',{getExtraParams:function(){
			var extraParams = {};
			var val = searchField.getValue()==null?"":searchField.getValue();
			var rules = [];
			if(selectCheckbox.getValue()){
				var ids = list.collection.keys.join(",");
				rules.push({field:'id',data:ids,op:'in'});
			}
			extraParams.filters = Ext.JSON.encode({rules:rules});
			extraParams.searchKey = val;
			return extraParams;
		}});
		var searchField = Ext.create('Ext.ux.form.field.SearchText',{
			store:list.store,emptyText:'姓名|编号,多个逗号分隔'
		});
		var selectCheckbox = Ext.create('Ext.form.field.Checkbox',{
			boxLabel: '仅显示已选',
			listeners: {
				change: function(checkbox, newValue, oldValue, eOpts){
					list.store.loadPage(1);
				}
			}
		});
		
		var tbar = Ext.create('Ext.toolbar.Toolbar',{
			border: 0,
			items: [{
				xtype: 'displayfield',
				value: '罪犯姓名:'
			},searchField,{
				text: '搜索',iconCls: 'icon-search',
				handler: function(button){
					list.store.loadPage(1);
				}
			},{
				text: '重置',iconCls: 'icon-reset',
				handler: function(button){
					searchField.setValue(null);
					selectCheckbox.setValue(false);
					list.collection.clear();
					list.store.loadPage(1);
					list.getSelectionModel().deselectAll();
				}
			},selectCheckbox,{
				text: '添加',iconCls: 'icon-add',handler: function(b){
					showWin('添加罪犯会见通知书',null);
				}
			},{
				text: '修改',iconCls: 'icon-update',handler: function(b){
					var records = list.getSelectionModel().getSelection();
					if(records.length != 1){
						Ext.ux.Msg.error('请选择一条数据进行修改！');
						return;
					}else{
						showWin('修改罪犯会见通知书',records[0]);
					}
				}
			},{
				text: '删除',iconCls: 'icon-remove',handler: function(b){
					var records = list.getSelectionModel().getSelection();
					if(records.length>0){
						Ext.MessageBox.confirm('警告','您确定要删除选中的数据？',function(bid){
							if(bid!='yes')return;
							var dids = [];
							Ext.Array.each(records,function(record,index){
								dids.push(record.data.id);
							});
							Ext.ux.Ajax.request({
								method: 'POST',
								url: list.store.batchDelete,
								params: {ids:dids},
								success: function(response){
									list.store.reload();
								}
							});
						});
					}else{
						Ext.ux.Msg.error('请至少选择一条数据进行删除操作！');
						return;
					}
				}
			},{
				text: '导出通知书',iconCls: 'icon-export',xtype:'permbutton',ifAnyGranted:'ROLE_ZFHJNOTICE_TZS_EXPORT',handler: function(b){
					var records = list.getSelectionModel().getSelection();
					if(records.length != 1){
						Ext.ux.Msg.error('请选择一条数据进行导出！');
						return;
					}else{
						Ext.ux.FileUtil.download({action:list.store.print,params:{id:records[0].get('id')}});
					}
				}
			}]
		});
		me.items = [tbar,list];
		me.callParent(arguments);
	}
});