Ext.define('meeting.view.MailInfoList',{
    extend: 'Ext.grid.Panel',
	requires: [
		'Ext.selection.CheckboxModel',
		'meeting.store.MailInfo'
	],
	flex: 1,
    viewConfig: {
	   forceFit:true
    },
    columns: [
		{xtype: 'rownumberer',width:40},
		{header: 'ID',  dataIndex: 'id',align:'center',flex: 1,hidden:true},
		{header: '罪犯姓名',  dataIndex: 'currentInfo.baseInfo.xm', align:'center', flex: 1},
		{header: '罪犯编号',dataIndex: 'currentInfo.baseInfo.zfbh', align:'center', flex: 1.5},
		{header: '所属监区',dataIndex: 'currentInfo.gyjq.jgmc', align:'center', flex: 1},
		{header: '信件类型',  dataIndex: 'xjlx.codeName',align:'center', flex: 1},
		{header: '来信/寄信人',  dataIndex: 'jxr',align:'center', flex: 1},
		{header: '关系',  dataIndex: 'gx',align:'center', flex:1},
		{header: '地址',  dataIndex: 'dz',align:'center', flex:1, sortable:false},
		{header: '审查警察',  dataIndex: 'scgj',align:'center', flex:1},
		{header: '处理情况',  dataIndex: 'clqk',align:'center', flex:1, sortable:false},
		{header: '是否正常',  dataIndex: 'sfzcmc',align:'center', flex:1, sortable:false,queryConfig:{
			queryName:'sfzc',
			inputType:Ext.create('Ext.form.field.ComboBox',{
		          editable:false,
		          queryMode: 'local',
		          displayField: 'name',
		          valueField: 'val',
		          value:"1",
		          store: Ext.create('Ext.data.Store', {
		  			fields: ["name","val"],
				    data : [
				        {name:'是',val:"1"},
				        {name:'否',val:"0"}
				    ]
				})
			})
		},queryConvert:function(data){
			return "是"==data?1:0;
		}},
		{header: '备注',  dataIndex: 'bz',align:'center', flex:1, sortable:false},
		{header: '登记警官',  dataIndex: 'djjg.xm',align:'center', flex:1},
		{header: '登记日期',  dataIndex: 'djrq',align:'center', flex:1.5,queryConfig:{
			inputType:Ext.create('Ext.ux.form.field.DateTime',{
				width:135,
				config:{ dateFmt:'yyyy-MM-dd'},
				allowBlank:false
		    })
		}}
    ],
    collapsible: false,
    autoScroll:true,
    loadMask: true,
    verticalScroller:{
        variableRowHeight: true
    },
	initComponent: function() {
		var me = this;
		me.collection=new Ext.util.MixedCollection();
		var listeners = {
				beforeload:function( store, operation, eOpts ){
					if(me.getExtraParams){
						store.proxy.extraParams = me.getExtraParams();
					}
				}
			};
		if(!me.store){
			me.store = Ext.create('meeting.store.MailInfo',{
				listeners:listeners
			});
		}
		var pageSizePager = Ext.create('Ext.ux.PageSizePager');
		me.bbar = Ext.create('Ext.ux.toolbar.Paging',{
			dock : 'bottom',
			displayInfo: true,
			list:me,
			plugins:[pageSizePager]
		});
		me.selModel = Ext.create('Ext.ux.selection.CheckboxModel',{collection:me.collection});
		me.callParent(arguments);
	}
});