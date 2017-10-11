Ext.define('basebiz.view.zfxzcf.ApplyIndex',{
	extend: 'Ext.ux.panel.Panel',
	border: false,
	layout: {
		type: 'vbox',
		align: 'stretch'
	},
	initComponent: function(){
		var me = this;
		var showWin = function(title,record){
			var win = Ext.create('basebiz.view.zfxzcf.Edit',{list:list,record:record});
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
		
		var list = Ext.create('basebiz.view.zfxzcf.List');
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
			emptyText: '姓名|编号|档案号，多个逗号分隔',
		    store:list.store
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
				value: '关键字:'
			},searchCombobox,{
				text: '搜索',iconCls: 'icon-search',
				handler: function(button){
					list.store.loadPage(1);
				}
			},{
				text: '重置',iconCls: 'icon-reset',
				handler: function(button){
					searchCombobox.setValue("");
					selectCheckbox.setValue(false);
					list.collection.clear();
					list.store.loadPage(1);
					list.getSelectionModel().deselectAll();
				}
			},selectCheckbox,{
				text: '添加',iconCls: 'icon-add',
				xtype:'permbutton',ifAnyGranted:'ROLE_ZFXZCF_APPLY_CREATE',
				handler: function(b){
					showWin('添加罪犯行政处罚审批申请',null);
				}
			},{
				text: '修改',iconCls: 'icon-update',
				xtype:'permbutton',ifAnyGranted:'ROLE_ZFXZCF_APPLY_UPDATE',
				handler: function(b){
					var records = list.getSelectionModel().getSelection();
					if(records.length != 1){
						Ext.ux.Msg.error('请选择一条数据进行修改！');
						return;
					}else{
						var spzt = records[0].data.spzt;
						if(spzt!='新建'){
							Ext.ux.Msg.error(spzt+'，不能修改！');
							return;
						}
						showWin('修改罪犯行政处罚审批申请',records[0]);
					}
				}
			},{
				text: '删除',iconCls: 'icon-remove',
				xtype:'permbutton',ifAnyGranted:'ROLE_ZFXZCF_APPLY_DELETE',
				handler: function(b){
					var records = list.getSelectionModel().getSelection();
					if(records.length>0){
						var dids = [];
						for(var i=0;i<records.length;i++){
							dids.push(records[i].data.id);
							var spzt = records[i].data.spzt;
							if(spzt!='新建'){
								Ext.ux.Msg.error(spzt+'，不能删除！');
								return;
							}
						}
						Ext.MessageBox.confirm('警告','您确定要删除选中的数据？',function(bid){
							if(bid!='yes')return;
							Ext.ux.Ajax.request({
								method: 'POST',
								url: list.store.batchDelete,
								params: {ids:dids},
								success: function(response){
									list.store.reload();
									var result = Ext.JSON.decode(response.responseText);
									Ext.ux.Msg.show(result.statusText);
								}
							});
						});
					}else{
						Ext.ux.Msg.error('请至少选择一条数据进行删除操作！');
						return;
					}
				}
			},{
				text: '送审',iconCls: 'icon-examine',
				xtype:'permbutton',ifAnyGranted:'ROLE_ZFXZCF_APPLY_CREATE',
				handler: function(b){
					var records = list.getSelectionModel().getSelection();
					if(records.length != 1){
						Ext.ux.Msg.error('请选择一条数据进行送审操作！');
						return;
					}else{
						var spzt = records[0].data.spzt;
						if(spzt!='新建'){
							Ext.ux.Msg.error(spzt+'，不能送审！');
							return;
						}
						Ext.MessageBox.confirm('警告','您确定要送审选中的数据？',function(bid){
							if(bid!='yes')return;
							Ext.ux.Ajax.request({
								method: 'POST',
								url: list.store.startProcess,
								params: {id:records[0].data.id},
								success: function(response){
									list.store.reload();
									var result = Ext.JSON.decode(response.responseText);
									Ext.ux.Msg.show(result.statusText);
								}
							});
						});
					}
				}
			},{
				text: '查看',iconCls: 'icon-view',handler: function(b){
					var records = list.getSelectionModel().getSelection();
					if(records.length != 1){
						Ext.ux.Msg.error('请选择一条数据进行查看操作！');
						return;
					}
					Ext.create('process.view.util.showInfoWin',{
						list:list,
						detailsInfo:'basebiz.view.zfxzcf.DetailsInfo'
					}).show();
				}
			},{
				text: '下载附件',iconCls: 'icon-download',handler: function(b){
					var records = list.getSelectionModel().getSelection();
					if(records.length != 1){
						Ext.ux.Msg.error('请选择一条数据进行查看操作！');
						return;
					}
					var id = records[0].data.id;
					var fj = records[0].data.fj;
					if(Ext.isEmpty(fj)){
						Ext.ux.Msg.error('该条数据无附件！');
						return;
					}
					Ext.ux.FileUtil.download({
						action:list.store.downloadFj,
						params:{
							id:id
						}
					});
				}
			}]
		});
		me.items = [tbar,list];
		me.callParent(arguments);
	}
});