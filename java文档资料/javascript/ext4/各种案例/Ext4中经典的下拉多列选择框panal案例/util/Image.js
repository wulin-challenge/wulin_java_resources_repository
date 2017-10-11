Ext.define('criminal.view.util.Image',{
	extend: 'Ext.panel.Panel',
	flex: 1,
	border: false,
	margin: '0 5 5 0',
	initComponent: function(){
		var me = this;
		me.width = me.width||100;
		me.height = me.height||100;
		var urlFormat = contextPath+'/criminal/currentInfo/getPhoto?zfbh={0}&fileName={1}&time={2}';
		var zfPhoto = Ext.create('Ext.Img',{
			width: me.width,height: me.height,
			src: Ext.String.format(urlFormat,me.record.zfbh,me.record.photo,new Date().getTime())
		});
		me.refresh = function(record){
			if(Ext.isEmpty(record.data)){
				zfPhoto.setSrc(Ext.String.format(urlFormat,'','',new Date().getTime()));
			}else{
				zfPhoto.setSrc(Ext.String.format(urlFormat,record.data.zfbh,record.data.photo,new Date().getTime()));
			}
		};
		me.items = [zfPhoto];
		me.callParent(arguments);
	}
});