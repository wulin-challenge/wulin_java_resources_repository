Ext.define('meeting.view.MailInfoEdit',{
    extend: 'Ext.panel.Panel',
   	border:false,
   	width: 700,
	minHeight:360,
	bodyStyle:'background:#FFF',
	modal:true,
	maximizable:true,
	initComponent: function() {
		var me = this;
		var parent = this.parent;
		
		var ccinfo = null;
		var required = '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>';
		if(!Ext.isEmpty(me.record))me.ccid = me.record.data.ccid;
		var rules = [{field:'cdqxx.zfzt.code',data:'6',op:'ne'},{field:'cdqxx.zfzt.code',data:'9',op:'ne'}];
		
		var ccip = Ext.create('criminal.view.util.CurrentInfoPanel',{
			ccid: me.ccid ,
			extraParams:{filters:Ext.JSON.encode({rules:rules})},
			selected:function(c,r,o){
				me.ccid  = r.get('id');
				ccinfo = r;
				lxrStore.reload();
				Ext.ux.Ajax.request({
				    url: me.list.store.getLastByCcid,
				    params: {'ccid': r.get('id')},
				    success: function(response){
				    	var proxy = Ext.create('Ext.data.proxy.Proxy',{model:'meeting.model.MailInfo'});
						var zfsfzmsRecord = proxy.reader.read(response).records[0];
						form.loadRecord(zfsfzmsRecord);
						if(zfsfzmsRecord.data.id){
							form.getForm().findField('id').setValue(record.get('id'));
						}
				    }
				});
				
			}
		});
		
		if(me.operationType == 'update'){
			if(!Ext.isEmpty(me.ccid)){
				ccip.reload(me.ccid);
				ccinfo = ccip.record;
			}
		}
		
		var lxrStore = Ext.create('criminal.store.SocietyRelationship',{
			autoLoad: false,listeners: {'beforeload':function(store,operation){
				var extraParams={},rules=[];
				if(Ext.isEmpty(ccinfo)){
					Ext.ux.Msg.error('请先选择罪犯信息！');
					return false;
				}
				rules.push({field:'baseInfo.id',data:ccinfo.data.zfid,op:'eq'});
				extraParams.filters = Ext.JSON.encode({rules:rules});
				store.proxy.extraParams = extraParams;
			}},
			pageSize:100
		});
		
		var ynStore = Ext.create('Ext.data.Store',{
			fields: ['key','value'],
		    data: [{'key':'1','value':'是'},{'key':'0','value':'否'}]
		});
		var className= "com.bjhy.platform.meeting.domain.MailInfo";
		var xjlxField = Ext.create('permission.view.SystemDicComboBox',{
			name:'xjlx.dicId',
			fieldLabel: '信件类型',
			className:className, allowBlank: false, beforeLabelTextTpl: required,
			flex:1,
			fieldName:"xjlx"
		});
		var sxField = Ext.create('Ext.ux.form.field.ComboBox',{
    		name: 'sfzc',
    		xtype: 'combo',
    		fieldLabel: '是否正常',
    		emptyText: '请选择...',
    		store: ynStore,
    		displayField: 'value',
    		valueField: 'key', allowBlank: false, beforeLabelTextTpl: required,
    		editable: false
    	});
		var form = Ext.create('Ext.ux.form.Panel',{
			border: false,
			items: [{
				border: false,
				title: '信件信息',
				xtype: 'fieldset',
				style: {'border-top':'1px solid #c5c5c5 !important'},
				fieldDefaults: {
					flex: 1,
					labelWidth: 85,
					labelAlign: 'right',
					margin: '0 20 5 0',
					xtype:'textfield'
				},
				layout: 'column',
				items: [{
							border: false,columnWidth : 1,
					    	layout: {type:'hbox',align:'middle'},
					    	items: [xjlxField]
						},{
							border: false,columnWidth : 1,
					    	layout: {type:'hbox',align:'middle'},
					    	items: [{
//					    		xtype:'textfield', fieldLabel: '来/寄信人', name:'jxr', allowBlank: false, beforeLabelTextTpl: required, maxLength: 100
					    		xtype: 'fieldcontainer',fieldLabel: '来/寄信人',layout: {type:'hbox',align:'middle'},beforeLabelTextTpl: required,
					    		items: [Ext.create('Ext.ux.form.field.ComboBox',{
						    		name: 'jxr',xtype: 'combo',store: lxrStore,emptyText: '请选择...',
						    		editable: true,allowBlank: false,beforeLabelTextTpl: required,maxLength: 30,
						    		displayField: 'xm',valueField: 'xm',listeners: {'select':function(combo,records){
						    			form.getForm().findField('gx').setValue(records[0].get('cw'));
//						    			form.getForm().findField('dbrsheng').setValue(records[0].get('jtsss'));
//						    			form.getForm().findField('dbrshi').setValue(records[0].get('jtssshi'));
//						    			form.getForm().findField('dbrxian').setValue(records[0].get('jtssxian'));
						    			form.getForm().findField('dz').setValue(records[0].get('jtdz'));
//						    			form.getForm().findField('dbrsfzh').setValue(records[0].get('zjhm'));
//						    			form.getForm().findField('dbrzy').setValue(records[0].get('zy'));
//						    			form.getForm().findField('dbrtel').setValue(records[0].get('lxdh'));
						    		}}
						    	})]
					    	},{
					    			xtype:'textfield', name:'gx', fieldLabel: '与罪犯关系', maxLength: 100
							}]
						},{
							border: false,columnWidth : 1,
					    	layout: {type:'hbox',align:'middle'},
					    	items: [{
					    		xtype:'textarea', fieldLabel: '对方地址', name:'dz', maxLength: 1000, height:40
							}]
						},{
							border: false,columnWidth : 1,
					    	layout: {type:'hbox',align:'middle'},
					    	items: [{
					    		xtype:'textfield', fieldLabel: '审查警官', name:'scgj',  allowBlank: false, beforeLabelTextTpl: required, maxLength: 100
							},sxField
							]
						},{
							border: false,columnWidth : 1,
							layout: {type:'hbox',align:'middle'},
							items: [{
								xtype:'textarea', fieldLabel: '处理情况', name:'clqk',  allowBlank: false, beforeLabelTextTpl: required, maxLength: 1000, height:40
							}]
						},{
							border: false,columnWidth : 1,
					    	layout: {type:'hbox',align:'middle'},
					    	items: [{
								xtype:'textarea', fieldLabel: '备注', name:'bz', maxLength: 1000, height:40
							}]
						},{
							name: 'id',xtype: 'hidden'
						},{
							name: 'currentInfo.id',xtype: 'hidden'
						},{
							border: false,columnWidth : 1,
					    	layout: {type:'hbox',align:'middle',pack:'center'},
					    	items: [Ext.create('Ext.toolbar.Toolbar',{
								border:0,items:[{ 
													text: '保存',iconCls: 'icon-save_1',handler: function(b){
														
														if(me.operationType == 'create'){
															var isAdd = isAlreadyAdd(form);
															if(isAdd){
																form.getRecord().set('id','');
																form.getForm().findField('id').setValue("");
																form.getRecord().raw.id = '';
															}
														}
														
														if(!form.getForm().isValid()){
															Ext.ux.Msg.error("信息未填写完全");
															return;
														}
														if(Ext.isEmpty(me.ccid)){
															Ext.ux.Msg.error("未选择罪犯信息，不能提交！");
															return;
														}
														//设置当前信息ID
														form.getForm().findField('currentInfo.id').setValue(me.ccid );
														form.submit({
															method: 'POST',
														    url: me.list.store.saveOrUpdate,
														    success: function(batch,action){
														    	//显示成功信息
													    		var result = Ext.JSON.decode(action.response.responseText);
													    		Ext.ux.Msg.show(result.statusText);
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
														}else{
															form.loadRecord(me.record);
															me.ccid  = me.record.data.ccid;
														}
													}
												}]
					    	})]
				}]
			}]
		});
		
		var isAlreadyAdd = function(form1){
			var isAdd = false;
			if(form1 != null){
				var ccid = form1.getRecord().get('ccid');
				Ext.Ajax.request({
					waitMsg:"请稍后...",
					url:me.list.store.isAlreadyAdd,
					params:{ccid:ccid},
					method:"get",
					async:false,
					timeout:4000,
					success:function(response,options){
						var obj = Ext.decode(response.responseText);
						isAdd = obj[0].isAlreadyAdd;
					}
				});
				return isAdd;
			}
		}
		
		me.items = [ccip, form];
		if(me.record!=null){
			form.loadRecord(me.record);
		}
		
		me.focusFirstField = function(){
			var textfields = Ext.ComponentQuery.query("textfield",form);
			textfields[0].focus();
		};
		
		me.callParent(arguments);
	}
});