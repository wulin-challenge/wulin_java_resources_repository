Ext.define('writ.view.zfhjNotice.List',{
	extend: 'Ext.grid.Panel',
	forceFit: true,
	collapsible: false,
    autoScroll: true,
    loadMask: true,
    flex: 1,
    verticalScroller: {
        variableRowHeight: true
    },
    columns: [{
    	xtype: 'rownumberer',align: 'center',width: 30
    },{
    	header: '姓名',dataIndex: 'cdqxx.baseInfo.xm',width: 100
    },{
    	header: '罪犯编号',dataIndex: 'cdqxx.baseInfo.zfbh',width: 100
    },{
    	header: '会见人情况',dataIndex: 'hjrqk',width: 90
    },{
    	header: '会见时间',dataIndex: 'hjsj',width: 100,align: 'center',queryConfig: {
			inputType:Ext.create('Ext.ux.form.field.DateTime',{width:135,allowBlank:false,config:{dateFmt:'yyyy-MM-dd'}})
		}
    },{
    	header: '批准人',dataIndex: 'pzr',width: 90
    },{
    	header: '签发人',dataIndex: 'qfr',width: 90
    },{
    	header: '填发日期',dataIndex: 'tfrq',width: 120,align: 'center',queryConfig: {
			inputType:Ext.create('Ext.ux.form.field.DateTime',{width:135,allowBlank:false,config:{dateFmt:'yyyy-MM-dd'}})
		}
    }],
	initComponent: function(){
		var me = this;
		var beforeload = function(s,o,e){
			if(me.getExtraParams)s.proxy.extraParams = me.getExtraParams();
		};
		var loadfun = function(th,records,success){
			if(success){
				var ids = [],selrecs = [];
				Ext.Array.each(me.getSelectionModel().getSelection(),function(record){
					ids.push(record.getId());
				});
				Ext.Array.each(records,function(record){
					if(Ext.Array.contains(ids,record.getId()))selrecs.push(record);
				});
				me.selModel.select(selrecs);
			}
		};
		if(me.store){
			me.store.addListener({'beforeload':beforeload,'load':loadfun});
		}else{
			me.store = Ext.create('writ.store.ZfhjNotice',{listeners:{beforeload:beforeload,load:loadfun}});
		}
		var pageSizePager = Ext.create('Ext.ux.PageSizePager');
		me.bbar = Ext.create('Ext.ux.toolbar.Paging',{
			dock: 'bottom',
			displayInfo: true,
			list: me,
			plugins:[pageSizePager]
		});
		me.collection = new Ext.util.MixedCollection();
		me.selModel = Ext.create('Ext.ux.selection.CheckboxModel',{collection:me.collection});
		me.callParent(arguments);
	}
});