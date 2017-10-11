Ext.define('writ.view.zfhjNotice.Edit',{
	extend: 'Ext.panel.Panel',
	border: false,
	initComponent: function(){
		var me = this;
		if(!Ext.isEmpty(me.record))var ccid = me.record.data.ccid;
		var ccip = Ext.create('criminal.view.util.CurrentInfoPanel',{
			ccid: ccid,
			selected:function(combo,record){
				form.getForm().findField('cdqxx.id').setValue(record.get('id'));
			}
		});
		
		var isLoad = Ext.isEmpty(me.record) ? false : true;
		var hjryGrid = Ext.create('writ.view.zfhjNoticeHjry.List',{isLoad:isLoad,getParams:function(){
			var extraParams = {},rules = [];
			rules.push({field:'notice.id',data:(Ext.isEmpty(me.record)?'':me.record.data.id),op:'eq'});
			extraParams.filters = Ext.JSON.encode({rules:rules});
			return extraParams;
		}});
		
		var required = '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>';
		var form = Ext.create('Ext.ux.form.Panel',{
			border: false,
			items: [{
				border: false,
				title: '罪犯会见通知书信息',
				margin: '10 5 0 10',
				xtype: 'fieldset',
				style: {'border-top':'1px solid #c5c5c5 !important'},
				fieldDefaults: {
					flex: 1,
					labelWidth: 70,
					labelAlign: 'right',
					margin: '0 0 5 0'
				},
				layout: 'column',
				items: [{
					border: false,columnWidth: 1,
			    	layout: {type:'hbox',align:'middle'},
			    	items: [{
			    		name: 'zi',xtype: 'textfield',fieldLabel: '字',allowBlank: false,beforeLabelTextTpl: required
			    	},{
			    		name: 'jyjc',xtype: 'numberfield',fieldLabel: '年',allowBlank: false,allowDecimals: false,minValue: 0,beforeLabelTextTpl: required
			    	},{
			    		name: 'hao',xtype: 'numberfield',fieldLabel: '号',allowBlank: false,allowDecimals: false,minValue: 0,beforeLabelTextTpl: required
			    	},{
			    		xtype: 'displayfield'
			    	}]
				},{
					border: false,columnWidth: 1,
			    	layout: {type:'hbox',align:'middle'},
			    	items: [{
			    		name: 'hjrqk',xtype: 'textfield',fieldLabel: '会见人情况',flex: 2,allowBlank: false,beforeLabelTextTpl: required
			    	},{
			    		name: 'hjsj',xtype: 'datefield',fieldLabel: '会见时间',format: 'Y-m-d',editable: false,
			    		allowBlank: false,beforeLabelTextTpl: required
			    	},{
			    		name: 'pzr',xtype: 'textfield',fieldLabel: '批准人',allowBlank: false,beforeLabelTextTpl: required
			    	}]
				},{
					border: false,columnWidth: 1,
			    	layout: {type:'hbox',align:'middle'},
			    	items: [{
			    		name: 'qfr',xtype: 'textfield',fieldLabel: '签发人',allowBlank: false,beforeLabelTextTpl: required
			    	},{
			    		name: 'tfrq',xtype: 'datefield',fieldLabel: '填发日期',format: 'Y-m-d',editable: false,
			    		allowBlank: false,beforeLabelTextTpl: required
			    	},{
			    		xtype: 'fieldcontainer',flex: 2,layout: {type:'hbox',align:'middle'},
			    		items: [{
			    			xtype: 'button',text: '添加会见人',margin:'0 10',iconCls: 'icon-add',handler: function(b){
				                
				            	hjryGrid.rowEdit.cancelEdit();
				                var record = Ext.create('writ.model.ZfhjNoticeHjry',{});
				                hjryGrid.store.insert(0,record);
//				                hjryGrid.rowEdit.startEdit(0,0);
				                hjryGrid.plugins[0].startEdit(0,0);
				                var updateBtn = hjryGrid.plugins[0].getEditor().query('button')[0];
				                updateBtn.enable();
				                
				    		}
			    		},{
			    			xtype: 'button',text: '删除会见人',iconCls: 'icon-remove',handler: function(b){
			    				var records = hjryGrid.getSelectionModel().getSelection();
			    				if(!Ext.isEmpty(records))hjryGrid.store.remove(records);
				    		}
			    		}]
			    	}]
				},{
					name: 'id',xtype: 'hidden'
				},{
					name: 'cdqxx.id',xtype: 'hidden'
				}]
			}]
		});
		var year = new Date().getFullYear();
		form.getForm().findField('jyjc').setValue(year);
		var gridPanel = Ext.create('Ext.panel.Panel',{
			border: false,
			items: [{
				xtype:'fieldset',border:false,padding:0,margin:0,items:[hjryGrid],
				layout:{type:'vbox',align:'stretch'},title:'会见人员列表',
				style:{'border-top':'1px solid #c5c5c5 !important'}
			}]
		});
		
		var buttons = [{
			text: '保存',iconCls: 'icon-save_1',handler: function(b){
				if(!form.getForm().isValid()){
					Ext.ux.Msg.error('表单信息验证失败！');
					return;
				}
				if(Ext.isEmpty(form.getForm().findField('cdqxx.id').getValue())){
					Ext.ux.Msg.error('未选择罪犯信息，不能提交！');
					return;
				}
				var hjrys = [];
				hjryGrid.store.each(function(record){
					if(!Ext.isEmpty(record.get('name'))){
						hjrys.push({name:record.get('name'),sfzh:record.get('sfzh'),xb:record.get('xb'),age:record.get('age'),yzfgx:record.get('yzfgx')});
					}
				},this);
				if(hjryGrid.store.getCount()<1 || hjrys.length==0){
					Ext.ux.Msg.error('未添加会见人信息，不能提交！');
					return;
				}
				form.submit({
					method: 'POST',
				    url: me.list.store.saveOrUpdate,
				    params: {'hjrStr':Ext.JSON.encode(hjrys)},
				    success: function(form,action){
				    	Ext.ux.Msg.show(action.result.statusText);
				       	me.list.store.reload();
				       	me.up('window').close();
				    }
				});
			}
		},{
			text: '重置',iconCls: 'icon-reset',handler: function(b){
				ccip.reset();
				if(Ext.isEmpty(me.record)){
					form.getForm().reset();
					hjryGrid.store.removeAll();
				}else{
					form.loadRecord(me.record);
					hjryGrid.store.reload();
				}
			}
		}];
		
		var bbar = Ext.create('Ext.toolbar.Toolbar',{
			border:0,items:buttons,height: 33,
			layout:{type:'hbox',align:'middle',pack:'center'},
		});
		//把record对象中的值设置到表单中
		if(!Ext.isEmpty(me.record)){
			form.loadRecord(me.record);
		}
		me.items = [ccip,form,gridPanel,bbar];
		me.callParent(arguments);
	}
});