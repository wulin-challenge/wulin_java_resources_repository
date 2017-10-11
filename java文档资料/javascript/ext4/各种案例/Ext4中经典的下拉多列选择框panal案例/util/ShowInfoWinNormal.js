Ext.define('criminal.view.util.ShowInfoWinNormal',{
	extend: 'Ext.window.Window',
	title: '查看信息',
	modal: true,
	constrain: true,
	resizable: false,
	closeAction: 'hide',
	buttonAlign: 'center',
	bodyStyle: 'background:#FFF',
	bodyPadding: '2 0 0 0',
	initComponent: function(){
		var me = this;
		me.isPreview = false;
		var record = me.list.getSelectionModel().getSelection()[0];
		me.width = me.width || 900;
		if(Ext.isEmpty(me.isccinfo))me.isccinfo=true;
		var piId = me.list.getSelectionModel().getSelection()[0].data.processId;
		var crip = null;
		if(Ext.isEmpty(me.topPanel)){
			if(me.isccinfo){
				if(Ext.isEmpty(me.criminalIds)){
					crip = Ext.create('process.view.util.CriminalInfoPanel',{list:me.list,cwWidth:me.width,sysType:me.sysType});
				}else{
					crip = Ext.create('process.view.util.CriminalGridPanel',{criminalIds:me.criminalIds,isSearch:false,gridHeight:me.gridHeight,columns:me.columns,sysType:me.sysType});
				}
			}
		}else{
			crip = me.topPanel;
		}
		var pitems = [{
			xtype: 'fieldset',
            title: '业务单数据',
            padding: Ext.isEmpty(me.ywdPadding)?'0 10':me.ywdPadding,
            items: [Ext.create(me.detailsInfo,{list:me.list})]
		}];
		if(!Ext.isEmpty(crip))pitems.unshift(crip,{xtype:'component',height:8});
		pitems.unshift({xtype:'component',height:10});
		var bsitems = [Ext.create('Ext.panel.Panel',{border:false,items:pitems})];
		if(record.data.processMark){
			bsitems.push({x:(me.width-59),y:-7,width:33,height:33,style:'z-index:99',xtype:'image',border:false,src:contextPath+'/process/image/back.png'});
		}
		var panel = Ext.create('Ext.panel.Panel',{flex:1,border:false,layout:'absolute',bodyStyle:{borderColor:'#b5b8c8'},items:bsitems});
		
		var items = [{
        	title: '基本信息',
        	border: false,
        	bodyPadding: '0 10 10 10',
        	items: panel
        }];
		var tab = Ext.create('Ext.tab.Panel',{
			activeTab: 0,
			border: false,
	        width: '100%',
	    	height: '100%',
	    	bodyStyle: {borderWidth:0},
	        defaults :{
	            autoScroll: true,
	            bodyPadding: 10
	        },
	        items: items
		});
		tab.height = me.height;
		me.items = [tab];
		me.callParent(arguments);
	}
});