Ext.define('criminal.view.util.CurrentInfoPanel',{
	extend: 'Ext.panel.Panel',
	requires: ['criminal.model.SelectCriminal'],
	border: false,
	modal: true,
	bodyStyle: 'background:#FFF',
	initComponent: function(){
		var me = this;
		var isSearch = Ext.isEmpty(me.isSearch)?true:me.isSearch;
		var criminalPhoto = Ext.create('criminal.view.util.Image',{record:{}});
		var items = [{
			border: false,columnWidth: 1,
	    	layout: {type:'hbox',align:'middle'},
	    	items: [{
	    		border: false,flex: 7,
		    	layout: {type:'column'},
		    	items: [{
					border: false,columnWidth: 1,
			    	layout: {type:'hbox',align:'middle'},
			    	items: [{
			    		name: 'xm',xtype: 'displayfield',fieldLabel: '罪犯姓名'
			    	},{
			    		name: 'zfbh',xtype: 'displayfield',fieldLabel: '罪犯编号'
			    	},{
			    		name: 'gyjq',xtype: 'displayfield',fieldLabel: '关押监区'
			    	},{
			    		name: 'rjsj',xtype: 'displayfield',fieldLabel: '入监时间'
			    	}]
				},{
					border: false,columnWidth: 1,
			    	layout: {type:'hbox',align:'middle'},
			    	items: [{
			    		name: 'dqxq',xtype: 'displayfield',fieldLabel: '当前刑期'
			    	},{
			    		name: 'xqqr',xtype: 'displayfield',fieldLabel: '刑期起日'
			    	},{
			    		name: 'dqxqzr',xtype: 'displayfield',fieldLabel: '刑期止日'
			    	},{
			    		name: 'zfzt',xtype: 'displayfield',fieldLabel: '罪犯状态'
			    	}]
				},{
					border: false,columnWidth: 1,
			    	layout: {type:'hbox',align:'middle'},
			    	items: [{
			    		name: 'pjjg',xtype: 'displayfield',fieldLabel: '判决机关'
			    	},{
			    		name: 'gyjy.jymc',xtype: 'displayfield',fieldLabel: '现押监狱'
			    	},{
			    		name: 'qd',xtype: 'displayfield',fieldLabel: '监区'
			    	},{
			    		name: 'qd',xtype: 'displayfield',fieldLabel: '区队'
			    	}]
				},{
					border: false,columnWidth: 1,
			    	layout: {type:'hbox',align:'middle'},
			    	items: [{
			    		name: 'dqxz',xtype: 'displayfield',fieldLabel: '当前刑种'
			    	},{
			    		name: 'fylx',xtype: 'displayfield',fieldLabel: '分押类型'
			    	},{
			    		name: 'zgmj',xtype: 'displayfield',fieldLabel: '主管民警'
			    	},{
			    		name: 'csrq',xtype: 'displayfield',fieldLabel: '出生日期'
			    	}]
				},{
					border: false,columnWidth: 1,
			    	layout: {type:'hbox',align:'middle'},
			    	items: [{
			    		name: 'cydj',xtype: 'displayfield',fieldLabel: '处遇等级'
			    	},{
			    		name: 'sfzh',xtype: 'displayfield',fieldLabel: '身份证号'
			    	},{
			    		name: 'jjjl',xtype: 'displayfield',fieldLabel: '军警经历'
			    	},{
			    		name: 'zzmm',xtype: 'displayfield',fieldLabel: '政治面貌'
			    	}]
				}]
	    	},{
	    		border:false,flex:1,layout:{type:'column'},bodyPadding:0,items:[criminalPhoto]
	    	}]
		},{
			border: false,columnWidth: 1,
	    	layout: {type:'hbox',align:'middle'},
	    	items: [{
	    		name: 'zjxy',xtype: 'displayfield',fieldLabel: '宗教信仰',flex: 2
	    	},{
	    		name: 'jtdzxxdz',xtype: 'displayfield',fieldLabel: '家庭住址',flex: 4
	    	},{
	    		name: 'zzm',xtype: 'displayfield',fieldLabel: '主罪名',flex: 3.2
	    	},{
	    		name: 'id',xtype: 'hidden'
	    	},{
	    		name: 'baseInfo.id',xtype: 'hidden'
	    	}]
		}];
		
		if(isSearch){
			var selCri = Ext.create('Ext.form.FieldContainer',{
				columnWidth:1,
				items:[Ext.create('criminal.view.util.SelectCriminal',{
					gwidth:me.gwidth,gheight:me.gheight,gcolumns:me.gcolumns,
					extraParams:me.extraParams,width:230,fieldLabel:me.fieldLabel||'选择罪犯',readOnly:me.readOnly,
					url:me.url,selected:function(item,record,index){
						if(record.data){
							if(Ext.isEmpty(record.data['dqxq']))record.data['dqxq']=record.data['dqxz'];
							form.loadRecord(record);
							criminalPhoto.refresh(record);
							if(Ext.typeOf(me.selected)==='function')me.selected(item,record);
						}
					}
				})]
			});
			items.unshift({border:false,columnWidth:1,layout:{type:'hbox',align:'middle'},items:[selCri]});
		}
		
		var form = Ext.create('Ext.ux.form.Panel',{
			border:false,items:items,layout:'column',
			fieldDefaults:{flex:1,labelWidth:me.labelWidth||70,labelAlign:'right',margin:'0 0 5 0'}
		});
		if(!Ext.isEmpty(me.ccid)){
			Ext.ux.Ajax.request({
				method: 'POST',
				params: {id:me.ccid},
				url: contextPath+'/criminal/currentInfo/findById',
				success: function(response){
					var proxy = Ext.create('Ext.data.proxy.Proxy',{model:'criminal.model.SelectCriminal'});
					me.record = proxy.reader.read(response).records[0];
					if(Ext.isEmpty(me.record.data['dqxq']))me.record.data['dqxq']=me.record.data['dqxz'];
					form.loadRecord(me.record);
					criminalPhoto.refresh(me.record);
					if(!Ext.isEmpty(selCri))selCri.down('gridcombobox').setValue(me.record,isSearch);
					//if(Ext.typeOf(me.selected)==='function')me.selected(null,me.record,null);
				}
			});
		}
		
		//重置当前表单和下拉框
		me.reset = function(){
			if(Ext.isEmpty(me.record)){
				form.getForm().reset();
				criminalPhoto.refresh({});
			}else{
				form.loadRecord(me.record);
				criminalPhoto.refresh(me.record);
				if(!Ext.isEmpty(selCri))selCri.down('gridcombobox').setValue(me.record);
			}
		};
		me.getComboStore = function(){return isSearch?selCri.store:null;};
		me.reload=function(ccid){
			if(!Ext.isEmpty(ccid)){
				Ext.ux.Ajax.request({
					method: 'POST',
					params: {id:ccid},
					async:false,
					url: contextPath+'/criminal/currentInfo/findById',
					success: function(response){
						var proxy = Ext.create('Ext.data.proxy.Proxy',{model:'criminal.model.SelectCriminal'});
						me.record = proxy.reader.read(response).records[0];
						if(Ext.isEmpty(me.record.data['dqxq']))me.record.data['dqxq']=me.record.data['dqxz'];
						form.loadRecord(me.record);
						criminalPhoto.refresh(me.record);
						if(!Ext.isEmpty(selCri))selCri.down('gridcombobox').setValue(me.record,isSearch);
						//if(Ext.typeOf(me.selected)==='function')me.selected(null,me.record,null);
					}
				});
			}
		}
		me.items = [form];
		me.callParent(arguments);
	}
});