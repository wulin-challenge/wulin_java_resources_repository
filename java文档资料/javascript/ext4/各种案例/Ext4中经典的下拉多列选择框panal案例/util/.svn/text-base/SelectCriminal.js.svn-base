Ext.define('criminal.view.util.SelectCriminal',{
	extend: 'Ext.form.field.GridComboBox',
	valueField: 'id',
    displayField: 'xm',
    typeAhead: true,
    minChars: 1,
	initComponent: function(){
		var me = this;
		me.gwidth = me.gwidth||420;
		me.gheight = me.gheight||300;
		me.gcolumns = me.gcolumns||[{
			header: '姓名',dataIndex: 'xm',width: 80,sortable: false,menuDisabled:true,resizable:false
		},{
	    	header: '罪犯编号',dataIndex: 'zfbh',align: 'center',width: 90,sortable: false,menuDisabled:true,resizable:false
	    },{
	    	header: '档案号',dataIndex: 'zfdah',align: 'center',width: 90,sortable: false,menuDisabled:true,resizable:false
	    },{
	    	header: '出生日期',dataIndex: 'csrq',align: 'center',width: 80,sortable: false,menuDisabled:true,resizable:false
	    },{
	    	header: '性别',dataIndex: 'xb',align: 'center',width: 60,sortable: false,menuDisabled:true,resizable:false
	    }];
		me.store = Ext.create('criminal.store.SelectCriminal',{url:me.url,listeners:{beforeload:function(store,oper){
			if(!Ext.isEmpty(me.extraParams))
				store.proxy.extraParams = me.extraParams;
				oper.params = {query:me.rawValue};
		}}});
		me.gridCfg = {
			store: me.store,width: me.gwidth,height: me.gheight,columns: me.gcolumns,
			bbar: Ext.create('Ext.toolbar.Paging',{
				store: me.store,displayInfo: true,emptyMsg: "没有数据",displayMsg: '显示{0}-{1}条,共{2}条'
			}),
			listeners: {select:function(item,record,index){
				if(Ext.typeOf(me.selected)==='function')me.selected(item,record,index);
			}}
	    };
		me.getStore = function(){return me.store};
		me.callParent(arguments);
	}
});