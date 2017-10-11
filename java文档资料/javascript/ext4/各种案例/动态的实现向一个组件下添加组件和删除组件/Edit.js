Ext.define('basebiz.view.zfxzcf.Edit',{
	extend: 'Ext.ux.panel.Panel',
	border: false,
	initComponent: function(){
		var me = this;
		var required = '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>';
		if(!Ext.isEmpty(me.record))var ccid = me.record.data.ccid;
		var ccip = Ext.create('criminal.view.util.CurrentInfoPanel',{
			ccid: ccid,
			selected:function(combo,record){
				form.getForm().findField('cdqxx.id').setValue(record.get('id'));
			}
		});
		
		var XZLB_JB = "13";
		
		var XZLB_YG = "14";
		var getExtraParams = function(){
			var extraParams = {};
			var rules = [];
			var XZLB_CF = "2";
			rules.push({field: 'xzlb', data: XZLB_CF, op: 'cn'});
			extraParams.filters = Ext.JSON.encode({rules:rules});
			return extraParams;
		};
		var store = Ext.create('basebiz.store.Xzlb',{
			params: getExtraParams()
		});
		var cflbGdCbx = new Ext.form.field.GridComboBox({
			fieldLabel : '处罚类别',
			name: 'cflb.id',
			displayField : 'xzmc',
			valueField : 'id',
			store : store,
			beforeLabelTextTpl: required,
			allowBlank: false,
			editable: false,
			gridCfg : {
				width:200,
				columns : [ {
					text : '行政名称',
					dataIndex : 'xzmc',
					flex:3
				}
//				, {
//					text : '分数',
//					dataIndex : 'code',
//					flex:2
//				}
				]
		,
				listeners: {
					select: function(item, record, index, eOpts) {
					//	form.getForm().findField('kcfs').setValue(record.data.fs);
						if(record.data.code == XZLB_JB){
							jb_div.add(jb_div_has);
							jb_div2.add(jb_div_has2);
						}else{
							jb_div.removeAll();
							jb_div2.removeAll();
						}
						if(record.data.code == XZLB_YG){
							yg_div.add(yg_div_has);
							yg_div2.add(yg_div_has2);
						}else{
							yg_div.removeAll();
							yg_div2.removeAll();
						}
						
					}
				}
			}
		});
		
		var sfsyjjStore = Ext.create('Ext.data.Store',{
			fields: ['key','value'],
		    data: [{'key':'1','value':'是'},{'key':'0','value':'否'}]
		});
		
		var jb_div = Ext.create("Ext.panel.Panel",{
			border:false,flex: 1,
			layout: {type:'hbox',align:'middle'},
			items:[]
		});
		var jb_div2 = Ext.create("Ext.panel.Panel",{
			border:false,flex: 1,maxWidth:565,
			layout: {type:'hbox',align:'middle'},
			items:[]
		});
		
		var jb_div_has = [{
			border: false,flex: 1,
	    	layout: {type:'hbox',align:'middle'},
	    	items: [{
	    		name: 'kssj',xtype: 'datetimefield',fieldLabel: '开始时间',beforeLabelTextTpl: required,allowBlank: false,config:{
					dateFmt:'yyyy-MM-dd HH:mm:ss'
				}, value: Ext.Date.format(new Date(),'Y-m-d H:i:s')
	    	},{
	    		name: 'jssj',xtype: 'datetimefield',fieldLabel: '结束时间',beforeLabelTextTpl: required,allowBlank: false,config:{
					dateFmt:'yyyy-MM-dd HH:mm:ss'
				}
	    	},{
	    		name: 'jbs',xtype: 'textfield',fieldLabel: '禁闭室', maxLength: 100
	    	}]
		}];
		var jb_div_has2={
			border: false,flex: 1,
	    	layout: {type:'hbox',align:'middle'},
	    	items: [{
	    		name: 'kcsj',xtype: 'numberfield',fieldLabel: '考察时间（月）', maxLength: 100,value:0,minValue:0,allowBlank:false
	    	},{
	    		name: 'syjj', xtype: 'combo', fieldLabel: '是否使用戒具', editable: false, value: '0',
	    		store: sfsyjjStore, displayField: 'value', valueField: 'key', emptyText: '请选择...'
	    	}]
		};
		
		var yg_div = Ext.create("Ext.panel.Panel",{
			border:false,flex: 1,
			layout: {type:'hbox',align:'middle'},
			items:[]
		});
		
		var yg_div2 = Ext.create("Ext.panel.Panel",{
			border:false,flex: 1,maxWidth:565,
			layout: {type:'hbox',align:'middle'},
			items:[]
		});
		
		var yg_div_has = {
			border: false,flex: 1,
	    	layout: {type:'hbox',align:'middle'},
	    	items: [{
	    		name: 'kssj',xtype: 'datetimefield',fieldLabel: '开始时间',beforeLabelTextTpl: required,allowBlank: false,config:{
					dateFmt:'yyyy-MM-dd HH:mm:ss'
				}, value: Ext.Date.format(new Date(),'Y-m-d H:i:s')
	    	},{
	    		name: 'jssj',xtype: 'datetimefield',fieldLabel: '结束时间',beforeLabelTextTpl: required,allowBlank: false,config:{
					dateFmt:'yyyy-MM-dd HH:mm:ss'
				}
	    	},{
	    		name: 'jbs',xtype: 'textfield',fieldLabel: '禁闭室', maxLength: 100
	    	}/*,{
	    		name: 'kcsj',xtype: 'numberfield',fieldLabel: '考察时间（月）', maxLength: 100,value:0,minValue:0,maxValue:12,allowBlank:false
	    	},{
	    		name: 'syjj', xtype: 'combo', fieldLabel: '是否使用戒具', editable: false, value: '0',
	    		store: sfsyjjStore, displayField: 'value', valueField: 'key', emptyText: '请选择...'
	    	}*/]
		};
		
		var yg_div_has2={
				border: false,flex: 1,
		    	layout: {type:'hbox',align:'middle'},
		    	items: [{
		    		name: 'kcsj',xtype: 'numberfield',fieldLabel: '考察时间（月）', maxLength: 100,value:0,minValue:0,allowBlank:false
		    	},{
		    		name: 'syjj', xtype: 'combo', fieldLabel: '是否使用戒具', editable: false, value: '0',maxLength: 100,
		    		store: sfsyjjStore, displayField: 'value', valueField: 'key', emptyText: '请选择...'
		    	}]
			};
		
		var form = Ext.create('Ext.ux.form.Panel',{
			border: false,
			items: [{
				border: false,
				title: '申请依据',
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
			    	items: [cflbGdCbx,{
			    		xtype:'displayfield',flex:2
			    	}
//			    	        ,{
//			    		name: 'kcfs',xtype: 'numberfield',fieldLabel: '扣除分数', minValue: 0, maxValue: 99, allowDecimals: false
//			    	}
			    	]
				},{
					border: false,columnWidth: 1,
			    	layout: {type:'hbox',align:'middle'},
			    	items: [{
			    		name: 'cfyy',xtype: 'textarea',fieldLabel: '申请依据',flex: 4,height: 35, maxLength: 1000
			    	}]
				},{
					border: false,columnWidth: 1,
			    	layout: {type:'hbox',align:'middle'},
			    	items: [{
		    			name: 'fjfile',fieldLabel: '附件',xtype: 'filefield',buttonText: '选择文件',flex: 4
						/*,validator: function(obj){
							var reg=new RegExp(/^.*\.(doc|docx)$/ig);
							return reg.test(obj) || obj==""?true:'文件格式不对，只支持doc,docx';
						} */ 
			    	}]
				},{
					border: false,columnWidth: 1,
			    	layout: {type:'hbox',align:'middle'},
			    	items: [jb_div]
				},{
					border: false,columnWidth: 1,
			    	layout: {type:'hbox',align:'middle'},
			    	items: [jb_div2]
				},{
					border: false,columnWidth: 1,
			    	layout: {type:'hbox',align:'middle'},
			    	items: [yg_div]
				},{
					border: false,columnWidth: 1,
			    	layout: {type:'hbox',align:'middle'},
			    	items: [yg_div2]
				},{
					border: false,columnWidth: 1,
			    	layout: {type:'hbox',align:'middle'},
			    	items: [{
						name: 'bz',xtype: 'textarea',fieldLabel: '备注', maxLength: 1000
					}]
				},{
					name: 'id',xtype: 'hidden'
				},{
					name: 'cdqxx.id',xtype: 'hidden'
				},{
					name: 'processId',xtype: 'hidden'
				}]
			}]
		});
		
		var buttons = [{
			text: '暂存',iconCls: 'icon-save',handler: function(b){
				if(!form.getForm().isValid()){
					Ext.ux.Msg.error('表单信息验证失败！');
					return;
				}
				if(Ext.isEmpty(form.getForm().findField('cdqxx.id').getValue())){
					Ext.ux.Msg.error('未选择罪犯信息，不能提交！');
					return;
				}
				form.submit({
					method: 'POST',
				    url: me.list.store.save,
				    success: function(form,action){
				    	Ext.ux.Msg.show(action.result.statusText);
				       	me.list.store.reload();
				       	me.up('window').close();
				    }
				});
			}
		},{
			text: '送审',iconCls: 'icon-examine',handler: function(b){
				if(!form.getForm().isValid()){
					Ext.ux.Msg.error('表单信息验证失败！');
					return;
				}
				if(Ext.isEmpty(form.getForm().findField('cdqxx.id').getValue())){
					Ext.ux.Msg.error('未选择罪犯信息，不能提交！');
					return;
				}
				Ext.MessageBox.confirm('警告','您确定要送审该申请数据？',function(bid){
					if(bid!='yes')return;
					form.submit({
						method: 'POST',
					    url: me.list.store.saveAndStart,
					    success: function(form,action){
					    	Ext.ux.Msg.show(action.result.statusText);
					    	me.list.store.reload();
					    	me.up('window').close();
					    }
					});
				});
			}
		},{
			text: '重置',iconCls: 'icon-reset',handler: function(b){
				ccip.reset();
				if(Ext.isEmpty(me.record)){
					jb_div.removeAll();
					jb_div2.removeAll();
					yg_div.removeAll();
					yg_div2.removeAll();
					cflbGdCbx.setValue([{"id": "", "xzmc": "" }]);
					form.getForm().reset();
				}else{
					jb_div.removeAll();
					jb_div2.removeAll();
					if(me.record.data['cflb.code'] == XZLB_JB){
						jb_div.add(jb_div_has);
						jb_div2.add(jb_div_has2);
					}
					yg_div.removeAll();
					if(me.record.data['cflb.code'] == XZLB_YG){
						yg_div.add(yg_div_has);
						yg_div2.add(yg_div_has);
					}
					form.loadRecord(me.record);
					cflbGdCbx.setValue([{"id": me.record.data['cflb.id'], "xzmc": me.record.data['cflb.xzmc'] }]);
				}
			}
		}];
		if(!Ext.isEmpty(me.ptype))buttons.shift();
		
		var bbar = Ext.create('Ext.toolbar.Toolbar',{
			border:0,items:buttons,height: 33,
			layout:{type:'hbox',align:'middle',pack:'center'},
		});
		//把record对象中的值设置到表单中
		if(!Ext.isEmpty(me.record)){
			if(me.record.data['cflb.code'] == XZLB_JB){
				jb_div.add(jb_div_has);
				jb_div2.add(jb_div_has2);
			}else{
				jb_div.removeAll();
				jb_div2.removeAll();
			}
			if(me.record.data['cflb.code'] == XZLB_YG){
				yg_div.add(yg_div_has);
			}else{
				yg_div.removeAll();
			}
//			if(!Ext.isEmpty(me.record)){
//				if(me.record.data['cflb.code'] == XZLB_YG){
//					yg_div.add(yg_div_has);
//				}else{
//					yg_div.removeAll();
//				}
			form.loadRecord(me.record);
			cflbGdCbx.setValue([{"id": me.record.data['cflb.id'], "xzmc": me.record.data['cflb.xzmc'] }]);
		}
		
		me.items = [ccip,form,bbar];
		me.callParent(arguments);
	}
});