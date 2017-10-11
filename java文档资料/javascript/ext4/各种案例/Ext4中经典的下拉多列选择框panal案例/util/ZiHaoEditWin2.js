Ext.define('criminal.view.util.ZiHaoEditWin2',{
	extend: 'Ext.window.Window',
	title: '字号编辑',
	closeAction: 'hide',
	buttonAlign: 'center',
	modal: true,
	resizable: false,
	bodyStyle: 'background:#FFF',
	bodyPadding: 10,
	initComponent: function(){
		var me = this;
		var required = '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>';
		me.record = me.list.getSelectionModel().getSelection()[0];
//		var id = me.list.getSelectionModel().getSelection()[0].data.id;
//		var nodeStore = Ext.create('Ext.data.Store',{fields:['id','name'],data:me.data});
		var form = Ext.create('Ext.ux.form.Panel',{
			flex: 1,
			border: false,
			width: 400,
			height: 150,
			fieldDefaults: {
				labelWidth: 60,
				width:300,
				labelAlign: 'right'
			},
		    buttonAlign: 'center',
			items: [{
	    		name: 'zi',xtype: 'textfield',fieldLabel: '字',allowBlank: false,beforeLabelTextTpl: required
	    	},{
	    		name: 'jyjc',xtype: 'numberfield',fieldLabel: '年',allowBlank: false,allowDecimals: false,minValue: 0,beforeLabelTextTpl: required
	    	},{
	    		name: 'hao',xtype: 'numberfield',fieldLabel: '号',allowBlank: false,allowDecimals: false,minValue: 0,beforeLabelTextTpl: required
	    	},{
				xtype:'hidden',name:'id'
			},{
				border: false,columnWidth: 1,
		    	layout: {type:'hbox',align:'middle'},
		    	items: [{
	    			name: 'fjfile',fieldLabel: '附件',xtype: 'filefield',buttonText: '选择文件',flex: 0,
	    			hidden: true, 
	    			hideLabel:true ,
					validator: function(obj){
						var reg=new RegExp(/^.*\.(doc|docx|pdf|jpg|png|gif|xlsx|xls)$/ig);
						return reg.test(obj) || obj==""?true:'文件格式不对，只支持doc,docx,xlsx,xls,pdf,jpg,png,gif';
					}
		    	}]
			
			}],
			buttons: [{
				text: '保	存',handler: function(b){
					if(!form.isValid()){
						Ext.ux.Msg.error('表单信息验证失败！');
						return;
					}
					form.submit({
						method: 'POST',
						url: me.list.store.updateZiHao,
						success: function(form,action){
							Ext.ux.Msg.show(action.result.statusText);
							me.list.store.reload();
							me.close();
						}
					});
				}
			},{
				text: '重	置',iconCls: 'icon-reset',handler: function(b){
					form.loadRecord(me.record);
				}
			}]
		});
		
		//把record对象中的值设置到表单中
		if(!Ext.isEmpty(me.record)){
			form.loadRecord(me.record);
		}
		
		me.items = [form];
		me.callParent(arguments);
	}
});