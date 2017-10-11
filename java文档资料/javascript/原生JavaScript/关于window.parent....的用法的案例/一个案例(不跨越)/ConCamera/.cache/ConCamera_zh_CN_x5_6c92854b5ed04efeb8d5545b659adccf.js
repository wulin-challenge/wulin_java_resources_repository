
__initXBL__ = function(){	justep.XBLObject._registerClasses = function() {
justep.XBLObject._classes["/UI/system/components/window.xbl.xml#window"] = _xbl_JSClassDefine_window;
justep.XBLObject._classes["/UI/system/components/windowReceiver.xbl.xml#windowReceiver"] = _xbl_JSClassDefine_windowReceiver;
justep.XBLObject._classes["/UI/system/components/borderLayout.xbl.xml#borderLayout"] = _xbl_JSClassDefine_borderLayout;
justep.XBLObject._classes["/UI/system/components/trigger.xbl.xml#trigger"] = _xbl_JSClassDefine_trigger;
 };
justep.XBLObject._registerClasses();function _xbl_JSClassDefine_window(obj) {
 	if (obj) {
 		this.domNode = obj;
  	obj.xblObject = this;
 	}
}
_xbl_JSClassDefine_window.prototype = justep.Object.extend(new justep.XBLObject(), eval({}));

function _xbl_JSClassDefine_windowReceiver(obj) {
 	if (obj) {
 		this.domNode = obj;
  	obj.xblObject = this;
 	}
}
_xbl_JSClassDefine_windowReceiver.prototype = justep.Object.extend(new justep.XBLObject(), eval({
			"initXBL" : function() {
				this.domNode._xblObject.initXBL();
			},
			"initXBL2" : function() {
				this.domNode._xblObject.initXBL2();
			}
		}));

function _xbl_JSClassDefine_borderLayout(obj) {
 	if (obj) {
 		this.domNode = obj;
  	obj.xblObject = this;
 	}
}
_xbl_JSClassDefine_borderLayout.prototype = justep.Object.extend(new justep.XBLObject(), eval({

			"initXBL" : function() {
			   	if(!this.domNode.id || this.domNode.id ==""){
					this.domNode.id = (new UUID()).valueOf();
			   	}
			   	var baseCls = '.xui-borderlayout-';
			   	var id = this.domNode.id; 
			   	this.el = $("#" + id);
			   	this.rootEl = $("#" + id + " > div");
			   	this.topEl = $("#" + id + " > div > " + baseCls + "top");
			   	this.leftEl = $("#" + id + " > div > " + baseCls + "left");
			   	this.rightEl = $("#" + id + " > div > " + baseCls + "right");
			   	this.bottomEl = $("#" + id + " > div > " + baseCls + "bottom");
			   	this.centerEl = $("#" + id + " > div > " + baseCls + "center");
			   	this.topBorderEl = $("#" + id + " > div > " + baseCls + "border-top");
			   	this.leftBorderEl = $("#" + id + " > div > " + baseCls + "border-left");
			   	this.rightBorderEl = $("#" + id + " > div > " + baseCls + "border-right");
			   	this.bottomBorderEl = $("#" + id + " > div > " + baseCls + "border-bottom");
			   	this.onWindowResize();
			},
			onWindowResize: function(){
				var b = parseFloat(this.rootEl.attr('borderSize')),
					top = left = right = bottom = 0,
					w = this.el.width()-2*b, h = this.el.height()-2*b,
					bp = function(el, isHeight){
						return isHeight? (el.outerHeight()-el.height()): (el.outerWidth()-el.width());
					},
					size = function(el, isHeight){
						var value = el.attr('size');
						if(value!='auto'){
							value = parseFloat(value) - bp(el, isHeight);
						}
						return value;
					},
					area = $(" >.xui-borderlayout-area", this.rootEl);

/*				area.css({overflow:'hidden'});	
				area.css({overflow:'auto'});
*/				
				this.rootEl.height(h);
				this.rootEl.width(w);
				this.rootEl.css({top: b, left:b});					
				if(this.topEl.get(0)){
					this.topEl.css({top: top, left:left});
					this.topEl.height(size(this.topEl, true));
					this.topEl.width(w - bp(this.topEl));
					top = this.topEl.outerHeight();
					if(this.topBorderEl.get(0)){
						this.topBorderEl.css({top: top,left:left});
						top += this.topBorderEl.height();
					} 
				}
				if(this.leftEl.get(0)){
					this.leftEl.css({top: top, left:left});
					this.leftEl.width(size(this.leftEl));
					left = this.leftEl.outerWidth(); 
					if(this.leftBorderEl.get(0)){
						this.leftBorderEl.css({top: top, left: left});
						left += this.leftBorderEl.width(); 
					} 
				}
				if(this.rightEl.get(0)){
					this.rightEl.css({top: top, right:right});
					this.rightEl.width(size(this.rightEl));
					right = this.rightEl.outerWidth(); 
					if(this.rightBorderEl.get(0)){
						this.rightBorderEl.css({top: top,right: right});
						right += this.rightBorderEl.width();
					} 
				}
				if(this.bottomEl.get(0)){
					this.bottomEl.height(size(this.bottomEl, true));
					this.bottomEl.width(w - bp(this.bottomEl));
					bottom = this.bottomEl.outerHeight(); 
					if(this.bottomBorderEl.get(0)){
						this.bottomBorderEl.css({left:0, bottom: bottom});
						bottom += this.bottomBorderEl.height();  
					} 
				}
				this.centerEl.css({top: top, left: left});
				this.centerEl.width(w - left - right - bp(this.centerEl));
				h = h - top - bottom;
				this.leftEl.height(h - bp(this.leftEl, true));  
				this.centerEl.height(h - bp(this.centerEl, true));  
				this.rightEl.height(h - bp(this.rightEl, true));
				this.leftBorderEl.height(h);  
				this.rightBorderEl.height(h);
			}   	
		}));

function _xbl_JSClassDefine_trigger(obj) {
 	if (obj) {
 		this.domNode = obj;
  	obj.xblObject = this;
 	}
}
_xbl_JSClassDefine_trigger.prototype = justep.Object.extend(new justep.XBLObject(), eval({	
			"initXBL" : function() {
				this.$el = $(this.domNode);
				justep.Utils.proxable(this, this.domNode.xformsObject, xforms.XFTrigger);
			},
			"initXBL2" : function() {
				this.domNode.xformsObject.initOperation();
			}
		}));

	var ids=[{id:'cameraWindowId', name:'/UI/system/components/window.xbl.xml#window', children:[{id:'borderLayout1', name:'/UI/system/components/borderLayout.xbl.xml#borderLayout', children:[{id:'ScanReceiver', name:'/UI/system/components/windowReceiver.xbl.xml#windowReceiver'},{id:'openPic', name:'/UI/system/components/trigger.xbl.xml#trigger', children:[{id:'default2', name:'xforms:label'}]},{id:'setPin1', name:'/UI/system/components/trigger.xbl.xml#trigger', children:[{id:'default3', name:'xforms:label'}]},{id:'setPin2', name:'/UI/system/components/trigger.xbl.xml#trigger', children:[{id:'default4', name:'xforms:label'}]},{id:'closePic', name:'/UI/system/components/trigger.xbl.xml#trigger', children:[{id:'default5', name:'xforms:label'}]},{id:'firstPic', name:'/UI/system/components/trigger.xbl.xml#trigger', children:[{id:'default7', name:'xforms:label'}]},{id:'upPic', name:'/UI/system/components/trigger.xbl.xml#trigger', children:[{id:'default8', name:'xforms:label'}]},{id:'nextPic', name:'/UI/system/components/trigger.xbl.xml#trigger', children:[{id:'default9', name:'xforms:label'}]},{id:'lastPic', name:'/UI/system/components/trigger.xbl.xml#trigger', children:[{id:'default10', name:'xforms:label'}]},{id:'xuanZhuanPic', name:'/UI/system/components/trigger.xbl.xml#trigger', children:[{id:'default11', name:'xforms:label'}]},{id:'deletePic', name:'/UI/system/components/trigger.xbl.xml#trigger', children:[{id:'default12', name:'xforms:label'}]},{id:'uploadPic', name:'/UI/system/components/trigger.xbl.xml#trigger', children:[{id:'default13', name:'xforms:label'}]},{id:'cancelP', name:'/UI/system/components/trigger.xbl.xml#trigger', children:[{id:'default14', name:'xforms:label'}]},{id:'upMove', name:'/UI/system/components/trigger.xbl.xml#trigger', children:[{id:'default1', name:'xforms:label'}]},{id:'nextMove', name:'/UI/system/components/trigger.xbl.xml#trigger', children:[{id:'default15', name:'xforms:label'}]},{id:'fasterSao', name:'/UI/system/components/trigger.xbl.xml#trigger', children:[{id:'default16', name:'xforms:label'}]},{id:'getPic', name:'/UI/system/components/trigger.xbl.xml#trigger', children:[{id:'default6', name:'xforms:label'}]},{id:'picColor', name:'xforms:gridselect1', children:[{id:'default29', name:'xforms:label'},{id:'default30', name:'xforms:value'},{id:'default32', name:'xforms:ext-value'}]},{id:'textTo', name:'/UI/system/components/trigger.xbl.xml#trigger', children:[{id:'default17', name:'xforms:label'}]},{id:'fileScan', name:'/UI/system/components/trigger.xbl.xml#trigger', children:[{id:'default18', name:'xforms:label'}]},{id:'fileScanClose', name:'/UI/system/components/trigger.xbl.xml#trigger', children:[{id:'default19', name:'xforms:label'}]},{id:'gridSelect2', name:'xforms:gridselect1', children:[{id:'default61', name:'xforms:label'},{id:'default62', name:'xforms:value'}]},{id:'SoScan', name:'/UI/system/components/trigger.xbl.xml#trigger', children:[{id:'default40', name:'xforms:label'}]},{id:'openOldScan', name:'/UI/system/components/trigger.xbl.xml#trigger', children:[{id:'default41', name:'xforms:label'}]},{id:'oldScan', name:'/UI/system/components/trigger.xbl.xml#trigger', children:[{id:'default42', name:'xforms:label'}]},{id:'getOldPic', name:'/UI/system/components/trigger.xbl.xml#trigger', children:[{id:'default45', name:'xforms:label'}]}]}]}]; 
justep.XBLObject.initXBL(ids);
}; 
xforms.Core.fileName='form.js';	
xf._a(null,'openPic');xf._a('openPic','default2');xf._a(null,'setPin1');xf._a('setPin1','default3');xf._a(null,'setPin2');xf._a('setPin2','default4');xf._a(null,'closePic');xf._a('closePic','default5');xf._a(null,'firstPic');xf._a('firstPic','default7');xf._a(null,'upPic');xf._a('upPic','default8');xf._a(null,'nextPic');xf._a('nextPic','default9');xf._a(null,'lastPic');xf._a('lastPic','default10');xf._a(null,'xuanZhuanPic');xf._a('xuanZhuanPic','default11');xf._a(null,'deletePic');xf._a('deletePic','default12');xf._a(null,'uploadPic');xf._a('uploadPic','default13');xf._a(null,'cancelP');xf._a('cancelP','default14');xf._a(null,'upMove');xf._a('upMove','default1');xf._a(null,'nextMove');xf._a('nextMove','default15');xf._a(null,'fasterSao');xf._a('fasterSao','default16');xf._a(null,'getPic');xf._a('getPic','default6');xf._a(null,'picColor');xf._a('picColor','default29');xf._a('picColor','default31');xf._a(null,'textTo');xf._a('textTo','default17');xf._a(null,'fileScan');xf._a('fileScan','default18');xf._a(null,'fileScanClose');xf._a('fileScanClose','default19');xf._a(null,'gridSelect2');xf._a('gridSelect2','default61');xf._a('gridSelect2','default63');xf._a(null,'SoScan');xf._a('SoScan','default40');xf._a(null,'openOldScan');xf._a('openOldScan','default41');xf._a(null,'oldScan');xf._a('oldScan','default42');xf._a(null,'getOldPic');xf._a('getOldPic','default45');function init() {	
var begin = new Date().getTime();	
xf._b("instance('colors')/typeName",xf._g(xf._f('instance',xf._i("colors")),xf._h(false, xf._k("child",xf._j('','typeName')))));	
xf._b("instance('colors')/typeValue",xf._g(xf._f('instance',xf._i("colors")),xf._h(false, xf._k("child",xf._j('','typeValue')))));	
xf._b("instance('scanType')/typeName",xf._g(xf._f('instance',xf._i("scanType")),xf._h(false, xf._k("child",xf._j('','typeName')))));	
xf._b("instance('scanType')/typeValue",xf._g(xf._f('instance',xf._i("scanType")),xf._h(false, xf._k("child",xf._j('','typeValue')))));	
xf._b("data('colors')/typeValue",xf._g(xf._f('data',xf._i("colors")),xf._h(false, xf._k("child",xf._j('','typeValue')))));	
xf._b("data('colors')/typeName",xf._g(xf._f('data',xf._i("colors")),xf._h(false, xf._k("child",xf._j('','typeName')))));	
xf._b("typeName",xf._h(false, xf._k("child",xf._j('','typeName'))));	
xf._b("typeValue",xf._h(false, xf._k("child",xf._j('','typeValue'))));	
xf._b("__c_",xf._h(false, xf._k("child",xf._j('','__c_'))));	
xf._b("data('scanType')/typeValue",xf._g(xf._f('data',xf._i("scanType")),xf._h(false, xf._k("child",xf._j('','typeValue')))));	
xf._b("data('scanType')/typeName",xf._g(xf._f('data',xf._i("scanType")),xf._h(false, xf._k("child",xf._j('','typeName')))));	
var xf_model_mdMain = new xforms.XFModel('mdMain',null);	
var xf_action_action5=xf._n(null,null,null,null,false).add(xf._o(null,null,function(element, ctx, event){ConScan.mdMainReady(event)}));xf._p(justep('mdMain'),"xforms-ready",null,function(evt) { xforms.run(xf_action_action5,'mdMain', evt,false)});	
new xforms.XFInstance2('colors','mdMain',null,'<rows id="default22"><row id="default23"><cell id="default24">黑白</cell><cell id="default25">1</cell></row><row id="default26"><cell id="default27">彩色</cell><cell id="default28">2</cell></row></rows>',null,null,null,null,null,null,null,null,null);new SimpleStore('colors','typeName,typeValue');	
xf._c('xf-bind-0','mdMain',"instance('colors')/typeName",null,null,null,null,null,null,null);	
xf._c('xf-bind-1','mdMain',"instance('colors')/typeValue",null,null,null,null,null,null,null);	
new xforms.XFInstance2('colorsSelect','mdMain',null,'<rows id="default33"><row id="default34"><cell id="default35">黑白</cell><cell id="default36">1</cell></row><row id="default37"><cell id="default38">彩色</cell><cell id="default39">2</cell></row></rows>',null,null,null,null,null,null,null,null,null);	
new xforms.XFInstance2('scanType','mdMain',null,'<rows id="default47"><row id="default48"><cell id="default49">单面</cell><cell id="default50">1</cell></row><row id="default51"><cell id="default52">双面</cell><cell id="default53">2</cell></row></rows>',null,null,null,null,null,null,null,null,null);new SimpleStore('scanType','typeName,typeValue');	
xf._c('xf-bind-2','mdMain',"instance('scanType')/typeName",null,null,null,null,null,null,null);	
xf._c('xf-bind-3','mdMain',"instance('scanType')/typeValue",null,null,null,null,null,null,null);	
new xforms.XFInstance2('scanTypeSelect','mdMain',null,'<rows id="default54"><row id="default60"><cell id="default57">单面</cell><cell id="default59">1</cell></row><row id="default55"><cell id="default58">双面</cell><cell id="default56">2</cell></row></rows>',null,null,null,null,null,null,null,null,null);new SimpleStore('scanTypeSelect','typeName,typeValue');	
xforms.load_parts('view2');	
xforms.load_parts('view1');	
xforms.DebugConsole.writeTime(begin, 'new js objects');	
begin = new Date().getTime();	
xforms.init();	
xforms.DebugConsole.writeTime(begin, 'xforms init');};	
function load_view2(){if (justep("view2").getAttribute('loaded') && justep("view2").getAttribute('loaded') == 'true') return;justep("view2").setAttribute('loaded', 'true');	
if(typeof(load_view2_html) == 'function')load_view2_html();	
}	
function load_view2_xblinit(){if (justep("view2").getAttribute('xblloaded') && justep("view2").getAttribute('xblloaded') == 'true') return;justep("view2").setAttribute('xblloaded', 'true');	
}	
function load_view1(){if (justep("view1").getAttribute('loaded') && justep("view1").getAttribute('loaded') == 'true') return;justep("view1").setAttribute('loaded', 'true');	
if(typeof(load_view1_html) == 'function')load_view1_html();	
var xf_trigger_openPic=new xforms.XFTrigger('openPic',null,null,null,false,false,false,null,null,null);	
var xf_action_action14=xf._n(null,null,null,null,false).add(xf._o(null,null,function(element, ctx, event){ConScan.openPicClick(event)}));xf._p(justep('openPic'),"DOMActivate",null,function(evt) { xforms.run(xf_action_action14,'openPic', evt,false)});	
var xf_trigger_setPin1=new xforms.XFTrigger('setPin1',null,null,null,false,false,false,null,null,null);	
var xf_action_action15=xf._n(null,null,null,null,false).add(xf._o(null,null,function(element, ctx, event){ConScan.setPin1Click(event)}));xf._p(justep('setPin1'),"DOMActivate",null,function(evt) { xforms.run(xf_action_action15,'setPin1', evt,false)});	
var xf_trigger_setPin2=new xforms.XFTrigger('setPin2',null,null,null,false,false,false,null,null,null);	
var xf_action_action16=xf._n(null,null,null,null,false).add(xf._o(null,null,function(element, ctx, event){ConScan.setPin2Click(event)}));xf._p(justep('setPin2'),"DOMActivate",null,function(evt) { xforms.run(xf_action_action16,'setPin2', evt,false)});	
var xf_trigger_closePic=new xforms.XFTrigger('closePic',null,null,null,false,false,false,null,null,null);	
var xf_action_action17=xf._n(null,null,null,null,false).add(xf._o(null,null,function(element, ctx, event){ConScan.closePicClick(event)}));xf._p(justep('closePic'),"DOMActivate",null,function(evt) { xforms.run(xf_action_action17,'closePic', evt,false)});	
var xf_trigger_firstPic=new xforms.XFTrigger('firstPic',null,null,null,false,false,false,null,null,null);	
var xf_action_action4=xf._n(null,null,null,null,false).add(xf._o(null,null,function(element, ctx, event){ConScan.firstPicClick(event)}));xf._p(justep('firstPic'),"DOMActivate",null,function(evt) { xforms.run(xf_action_action4,'firstPic', evt,false)});	
var xf_trigger_upPic=new xforms.XFTrigger('upPic',null,null,null,false,false,false,null,null,null);	
var xf_action_action7=xf._n(null,null,null,null,false).add(xf._o(null,null,function(element, ctx, event){ConScan.upPicClick(event)}));xf._p(justep('upPic'),"DOMActivate",null,function(evt) { xforms.run(xf_action_action7,'upPic', evt,false)});	
var xf_trigger_nextPic=new xforms.XFTrigger('nextPic',null,null,null,false,false,false,null,null,null);	
var xf_action_action10=xf._n(null,null,null,null,false).add(xf._o(null,null,function(element, ctx, event){ConScan.nextPicClick(event)}));xf._p(justep('nextPic'),"DOMActivate",null,function(evt) { xforms.run(xf_action_action10,'nextPic', evt,false)});	
var xf_trigger_lastPic=new xforms.XFTrigger('lastPic',null,null,null,false,false,false,null,null,null);	
var xf_action_action11=xf._n(null,null,null,null,false).add(xf._o(null,null,function(element, ctx, event){ConScan.lastPicClick(event)}));xf._p(justep('lastPic'),"DOMActivate",null,function(evt) { xforms.run(xf_action_action11,'lastPic', evt,false)});	
var xf_trigger_xuanZhuanPic=new xforms.XFTrigger('xuanZhuanPic',null,null,null,false,false,false,null,null,null);	
var xf_action_action12=xf._n(null,null,null,null,false).add(xf._o(null,null,function(element, ctx, event){ConScan.xuanZhuanPicClick(event)}));xf._p(justep('xuanZhuanPic'),"DOMActivate",null,function(evt) { xforms.run(xf_action_action12,'xuanZhuanPic', evt,false)});	
var xf_trigger_deletePic=new xforms.XFTrigger('deletePic',null,null,null,false,false,false,null,null,null);	
var xf_action_action13=xf._n(null,null,null,null,false).add(xf._o(null,null,function(element, ctx, event){ConScan.deletePicClick(event)}));xf._p(justep('deletePic'),"DOMActivate",null,function(evt) { xforms.run(xf_action_action13,'deletePic', evt,false)});	
var xf_trigger_uploadPic=new xforms.XFTrigger('uploadPic',null,null,null,false,false,false,null,null,null);	
var xf_action_action1=xf._n(null,null,null,null,false).add(xf._o(null,null,function(element, ctx, event){ConScan.uploadPicClick(event)}));xf._p(justep('uploadPic'),"DOMActivate",null,function(evt) { xforms.run(xf_action_action1,'uploadPic', evt,false)});	
var xf_trigger_cancelP=new xforms.XFTrigger('cancelP',null,null,null,false,false,false,null,null,null);	
var xf_action_action3=xf._n(null,null,null,null,false).add(xf._o(null,null,function(element, ctx, event){ConScan.cancelPClick(event)}));xf._p(justep('cancelP'),"DOMActivate",null,function(evt) { xforms.run(xf_action_action3,'cancelP', evt,false)});	
var xf_trigger_upMove=new xforms.XFTrigger('upMove',null,null,null,false,false,false,null,null,null);	
var xf_action_action8=xf._n(null,null,null,null,false).add(xf._o(null,null,function(element, ctx, event){ConScan.upMoveClick(event)}));xf._p(justep('upMove'),"DOMActivate",null,function(evt) { xforms.run(xf_action_action8,'upMove', evt,false)});	
var xf_trigger_nextMove=new xforms.XFTrigger('nextMove',null,null,null,false,false,false,null,null,null);	
var xf_action_action9=xf._n(null,null,null,null,false).add(xf._o(null,null,function(element, ctx, event){ConScan.nextMoveClick(event)}));xf._p(justep('nextMove'),"DOMActivate",null,function(evt) { xforms.run(xf_action_action9,'nextMove', evt,false)});	
var xf_trigger_fasterSao=new xforms.XFTrigger('fasterSao',null,null,null,false,false,false,null,null,null);	
var xf_action_action2=xf._n(null,null,null,null,false).add(xf._o(null,null,function(element, ctx, event){ConScan.fasterSaoClick(event)}));xf._p(justep('fasterSao'),"DOMActivate",null,function(evt) { xforms.run(xf_action_action2,'fasterSao', evt,false)});	
var xf_trigger_getPic=new xforms.XFTrigger('getPic',null,null,null,false,false,false,null,null,null);	
var xf_action_action18=xf._n(null,null,null,null,false).add(xf._o(null,null,function(element, ctx, event){ConScan.getPicClick(event)}));xf._p(justep('getPic'),"DOMActivate",null,function(evt) { xforms.run(xf_action_action18,'getPic', evt,false)});	
new xforms.XFExtSelect({id:'picColor',type:'gridselect1',defaultLabelRef:null,allSelectedLabelRef:null,ref:xf._q("data('colors')/typeValue"),labelRef:xf._q("data('colors')/typeName"),extRef:null,valueSeparator:',',labelSeparator:',',extSeparator:',',dataId:'colorsSelect',columns:'typeName,typeValue,__c_',headerH:null,rowH:'20',dropdownClass:'xui-grid-hide-VLine',hiddenColumns:'typeValue',valueColumn:'typeValue',labelColumn:'typeName',extColumn:null,labels:',,',aligns:',,',types:'ro,ro,ro',widths:{widths:"#,#,*",total:0},height:'',dropdownWidth:'',appearance:null,delay:false,autoLoadData:true,independence:false,delayCreateGrid:false,cascade:false,dataXML:null,inputChangeable:false,disabled:false,readonly:false,smartRender:null,onAfterRowFill:null,onRowDisabled:null,onShowNodeImg:null,onRowExpand:null,onRowHasChildren:null,onKeyDown:null,onKeyUp:null,onKeyPress:null,onDropdown:null,onCloseup:null});	
var xf_trigger_textTo=new xforms.XFTrigger('textTo',null,null,null,false,false,false,null,null,null);	
var xf_action_action19=xf._n(null,null,null,null,false).add(xf._o(null,null,function(element, ctx, event){ConScan.textToClick(event)}));xf._p(justep('textTo'),"DOMActivate",null,function(evt) { xforms.run(xf_action_action19,'textTo', evt,false)});	
var xf_trigger_fileScan=new xforms.XFTrigger('fileScan',null,null,null,false,false,false,null,null,null);	
var xf_action_action20=xf._n(null,null,null,null,false).add(xf._o(null,null,function(element, ctx, event){ConCamera.fileScanClick(event)}));xf._p(justep('fileScan'),"DOMActivate",null,function(evt) { xforms.run(xf_action_action20,'fileScan', evt,false)});	
var xf_trigger_fileScanClose=new xforms.XFTrigger('fileScanClose',null,null,null,false,false,false,null,null,null);	
var xf_action_action6=xf._n(null,null,null,null,false).add(xf._o(null,null,function(element, ctx, event){ConCamera.fileScanCloseClick(event)}));xf._p(justep('fileScanClose'),"DOMActivate",null,function(evt) { xforms.run(xf_action_action6,'fileScanClose', evt,false)});	
new xforms.XFExtSelect({id:'gridSelect2',type:'gridselect1',defaultLabelRef:null,allSelectedLabelRef:null,ref:xf._q("data('scanType')/typeValue"),labelRef:xf._q("data('scanType')/typeName"),extRef:null,valueSeparator:',',labelSeparator:',',extSeparator:',',dataId:'scanTypeSelect',columns:'typeName,typeValue,__c_',headerH:null,rowH:'20',dropdownClass:'xui-grid-hide-VLine',hiddenColumns:'typeValue',valueColumn:'typeValue',labelColumn:'typeName',extColumn:null,labels:',,',aligns:',,',types:'ro,ro,ro',widths:{widths:"#,#,*",total:0},height:'',dropdownWidth:'',appearance:null,delay:false,autoLoadData:true,independence:false,delayCreateGrid:false,cascade:false,dataXML:null,inputChangeable:false,disabled:false,readonly:false,smartRender:null,onAfterRowFill:null,onRowDisabled:null,onShowNodeImg:null,onRowExpand:null,onRowHasChildren:null,onKeyDown:null,onKeyUp:null,onKeyPress:null,onDropdown:null,onCloseup:null});	
var xf_trigger_SoScan=new xforms.XFTrigger('SoScan',null,null,null,false,false,false,null,null,null);	
var xf_action_action21=xf._n(null,null,null,null,false).add(xf._o(null,null,function(element, ctx, event){ConCamera.SoScanClick(event)}));xf._p(justep('SoScan'),"DOMActivate",null,function(evt) { xforms.run(xf_action_action21,'SoScan', evt,false)});	
var xf_trigger_openOldScan=new xforms.XFTrigger('openOldScan',null,null,null,false,false,false,null,null,null);	
var xf_action_action23=xf._n(null,null,null,null,false).add(xf._o(null,null,function(element, ctx, event){ConCamera.openOldScanClick(event)}));xf._p(justep('openOldScan'),"DOMActivate",null,function(evt) { xforms.run(xf_action_action23,'openOldScan', evt,false)});	
var xf_trigger_oldScan=new xforms.XFTrigger('oldScan',null,null,null,false,false,false,null,null,null);	
var xf_action_action22=xf._n(null,null,null,null,false).add(xf._o(null,null,function(element, ctx, event){ConCamera.oldScanClick(event)}));xf._p(justep('oldScan'),"DOMActivate",null,function(evt) { xforms.run(xf_action_action22,'oldScan', evt,false)});	
var xf_trigger_getOldPic=new xforms.XFTrigger('getOldPic',null,null,null,false,false,false,null,null,null);	
var xf_action_action24=xf._n(null,null,null,null,false).add(xf._o(null,null,function(element, ctx, event){ConCamera.getOldPicClick(event)}));xf._p(justep('getOldPic'),"DOMActivate",null,function(evt) { xforms.run(xf_action_action24,'getOldPic', evt,false)});	
}	
function load_view1_xblinit(){if (justep("view1").getAttribute('xblloaded') && justep("view1").getAttribute('xblloaded') == 'true') return;justep("view1").setAttribute('xblloaded', 'true');	
}	
var __actions__ = {	
};	
