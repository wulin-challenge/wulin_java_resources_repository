<?xml version="1.0" encoding="utf-8"?>

<xui:window xmlns:xui="http://www.justep.com/xui" xmlns="http://www.justep.com/xui"
  xmlns:xforms="http://www.justep.com/xforms" xmlns:xhtml="http://www.w3.org/1999/xhtml"
  xmlns:ev="http://www.w3.org/2001/xml-events" component="/UI/system/components/window.xbl.xml#window" id="cameraWindowId">  
  <xforms:model id="mdMain" style="height:auto;top:98px;left:335px;"> 
  <xforms:action id="action5" ev:event="xforms-ready"><xforms:script id="xformsScript5"><![CDATA[ConScan.mdMainReady(event)]]></xforms:script></xforms:action>
  <data component="/UI/system/components/data.xbl.xml#data" data-type="xml" columns="typeName,typeValue" src="" auto-load="true" id="colors" confirm-refresh="true" store-type="simple"><rows xmlns="" id="default22">
   <row id="default23">
    <cell id="default24">黑白</cell>
    <cell id="default25">1</cell></row> 
   <row id="default26">
    <cell id="default27">彩色</cell>
    <cell id="default28">2</cell></row> </rows>
  <rule id="dataRule1" column="typeName"></rule>
  <rule id="dataRule2" column="typeValue"></rule></data>
  <data component="/UI/system/components/data.xbl.xml#data" data-type="xml" columns="typeName,typeValue" src="" auto-load="true" id="colorsSelect"><rows xmlns="" id="default33">
   <row id="default34">
    <cell id="default35">黑白</cell>
    <cell id="default36">1</cell></row> 
   <row id="default37">
    <cell id="default38">彩色</cell>
    <cell id="default39">2</cell></row> </rows></data>
  <data component="/UI/system/components/data.xbl.xml#data" data-type="xml" columns="typeName,typeValue" src="" auto-load="true" id="scanType" store-type="simple"><rows xmlns="" id="default47">
   <row id="default48">
    <cell id="default49">单面</cell>
    <cell id="default50">1</cell></row> 
   <row id="default51">
    <cell id="default52">双面</cell>
    <cell id="default53">2</cell></row> </rows>
  <rule id="dataRule3" column="typeName"></rule>
  <rule id="dataRule4" column="typeValue"></rule></data>
  <data component="/UI/system/components/data.xbl.xml#data" data-type="xml" columns="typeName,typeValue" src="" auto-load="true" id="scanTypeSelect" store-type="simple">
   <rows xmlns="" id="default54">
    <row id="default60">
     <cell id="default57">单面</cell>
     <cell id="default59">1</cell></row> 
    <row id="default55">
     <cell id="default58">双面</cell>
     <cell id="default56">2</cell></row> </rows> </data></xforms:model>  
  <xui:view id="rootView"> 
    <xui:layout style="height:100%;width:100%" id="rootLayout"> 
    <xhtml:div component="/UI/system/components/borderLayout.xbl.xml#borderLayout" id="borderLayout1" style="width:100%; height: 100%;;">
   <center id="borderLayout-center1"><xui:place control="view2" id="controlPlace11" style="position:relative;width:100%;height:96%;"></xui:place>
  </center>
  <bottom size="113px" id="borderLayout-bottom1"><xui:place control="view1" id="controlPlace6" style="position:relative;height:100%;width:103%;"></xui:place></bottom></xhtml:div>
  </xui:layout> 
  <xui:view auto-load="true" id="view1" class="xui-container">
   <layout type="absolute" style="position:relative;" id="layout1"><xui:place control="openPic" id="controlPlace3" style="position:absolute;left:6px;width:84px;top:13px;"></xui:place>
  <xui:place control="setPin1" id="controlPlace4" style="position:absolute;width:76px;left:98px;top:13px;"></xui:place>
  <xui:place control="setPin2" id="controlPlace5" style="position:absolute;width:68px;left:185px;top:13px;"></xui:place>
  <xui:place control="closePic" id="controlPlace8" style="position:absolute;left:262px;width:86px;top:13px;"></xui:place>
  <xui:place control="firstPic" id="controlPlace12" style="position:absolute;left:381px;top:13px;"></xui:place>
  <xui:place control="upPic" id="controlPlace13" style="position:absolute;left:458px;top:13px;"></xui:place>
  <xui:place control="nextPic" id="controlPlace14" style="position:absolute;left:711px;top:13px;"></xui:place>
  <xui:place control="lastPic" id="controlPlace15" style="position:absolute;width:67px;left:783px;top:13px;"></xui:place>
  <xui:place control="xuanZhuanPic" id="controlPlace16" style="position:absolute;left:381px;top:45px;"></xui:place>
  <xui:place control="deletePic" id="controlPlace17" style="position:absolute;left:783px;top:45px;"></xui:place>
  <xui:place control="uploadPic" id="controlPlace18" style="position:absolute;left:711px;top:82px;"></xui:place>
  <xui:place control="cancelP" id="controlPlace19" style="position:absolute;left:783px;top:81px;"></xui:place>
  <xhtml:input type="text" value="" id="fileName" style="position:absolute;top:81px;width:232px;left:459px;" class="xui-input"></xhtml:input>
  <xui:place control="upMove" id="controlPlace20" style="position:absolute;left:458px;top:45px;"></xui:place>
  <xui:place control="nextMove" id="controlPlace21" style="position:absolute;left:711px;top:45px;"></xui:place>
  <xui:place control="fasterSao" id="controlPlace23" style="position:absolute;width:79px;top:80px;left:91px;"></xui:place>
  <xui:place control="getPic" id="controlPlace9" style="position:absolute;top:45px;left:184.5px;"></xui:place>
  <xui:place control="picColor" id="controlPlace22" style="position:absolute;height:23px;width:84px;left:90px;top:45px;"></xui:place>
  <xui:place control="textTo" id="controlPlace10" style="position:absolute;left:540px;height:23px;top:45px;"></xui:place>
  <xhtml:label id="label1" style="position:absolute;top:84px;left:387px;" class="xui-label"><![CDATA[文件名：]]></xhtml:label>
  <xhtml:label id="label2" style="position:absolute;left:661px;top:49px;" class="xui-label"><![CDATA[张]]></xhtml:label>
  <xhtml:input type="text" value="" id="textToNum" class="xui-input" 
  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"
  style="position:absolute;position:absolute;width:29px;left:620px;height:18px;top:45px;"></xhtml:input>
  <xhtml:label id="fileLabel" style="position:absolute;left:560px;top:17px;" class="xui-label"><![CDATA[当前无预览，共0张]]></xhtml:label>
  <xhtml:label id="label5" class="xui-label" style="position:absolute;position:absolute;left:9px;top:51px;"><![CDATA[照片格式：]]></xhtml:label>
  <xui:place control="fileScan" id="controlPlace24" style="position:absolute;width:80px;top:80px;left:177px;"></xui:place>
  <xui:place control="fileScanClose" id="controlPlace25" style="position:absolute;width:80px;top:80px;left:267px;"></xui:place>
  <xui:place control="gridSelect2" id="controlPlace27" style="position:absolute;width:56px;left:13px;top:82px;"></xui:place>
  <xui:place control="SoScan" id="controlPlace2" style="position:absolute;top:45px;width:85px;left:264px;"></xui:place></layout>
  <xforms:trigger component="/UI/system/components/trigger.xbl.xml#trigger" id="openPic">
   <xforms:label id="default2"><![CDATA[开启高拍仪]]></xforms:label>
  <xforms:action id="action14" ev:event="DOMActivate"><xforms:script id="xformsScript14"><![CDATA[ConScan.openPicClick(event)]]></xforms:script></xforms:action></xforms:trigger>
  <xforms:trigger component="/UI/system/components/trigger.xbl.xml#trigger" id="setPin1">
   <xforms:label id="default3"><![CDATA[设置分辨率]]></xforms:label>
  <xforms:action id="action15" ev:event="DOMActivate"><xforms:script id="xformsScript15"><![CDATA[ConScan.setPin1Click(event)]]></xforms:script></xforms:action></xforms:trigger>
  <xforms:trigger component="/UI/system/components/trigger.xbl.xml#trigger" id="setPin2">
   <xforms:label id="default4"><![CDATA[设置属性]]></xforms:label>
  <xforms:action id="action16" ev:event="DOMActivate"><xforms:script id="xformsScript16"><![CDATA[ConScan.setPin2Click(event)]]></xforms:script></xforms:action></xforms:trigger>
  <xforms:trigger component="/UI/system/components/trigger.xbl.xml#trigger" id="closePic">
   <xforms:label id="default5"><![CDATA[关闭高拍仪]]></xforms:label>
  <xforms:action id="action17" ev:event="DOMActivate"><xforms:script id="xformsScript17"><![CDATA[ConScan.closePicClick(event)]]></xforms:script></xforms:action></xforms:trigger>
  <xforms:trigger component="/UI/system/components/trigger.xbl.xml#trigger" id="firstPic">
   <xforms:label id="default7"><![CDATA[第一张]]></xforms:label>
  <xforms:action id="action4" ev:event="DOMActivate"><xforms:script id="xformsScript4"><![CDATA[ConScan.firstPicClick(event)]]></xforms:script></xforms:action></xforms:trigger>
  <xforms:trigger component="/UI/system/components/trigger.xbl.xml#trigger" id="upPic">
   <xforms:label id="default8"><![CDATA[上一张]]></xforms:label>
  <xforms:action id="action7" ev:event="DOMActivate"><xforms:script id="xformsScript7"><![CDATA[ConScan.upPicClick(event)]]></xforms:script></xforms:action></xforms:trigger>
  <xforms:trigger component="/UI/system/components/trigger.xbl.xml#trigger" id="nextPic">
   <xforms:label id="default9"><![CDATA[下一张]]></xforms:label>
  <xforms:action id="action10" ev:event="DOMActivate"><xforms:script id="xformsScript10"><![CDATA[ConScan.nextPicClick(event)]]></xforms:script></xforms:action></xforms:trigger>
  <xforms:trigger component="/UI/system/components/trigger.xbl.xml#trigger" id="lastPic">
   <xforms:label id="default10"><![CDATA[最后一张]]></xforms:label>
  <xforms:action id="action11" ev:event="DOMActivate"><xforms:script id="xformsScript11"><![CDATA[ConScan.lastPicClick(event)]]></xforms:script></xforms:action></xforms:trigger>
  <xforms:trigger component="/UI/system/components/trigger.xbl.xml#trigger" id="xuanZhuanPic">
   <xforms:label id="default11"><![CDATA[旋转]]></xforms:label>
  <xforms:action id="action12" ev:event="DOMActivate"><xforms:script id="xformsScript12"><![CDATA[ConScan.xuanZhuanPicClick(event)]]></xforms:script></xforms:action></xforms:trigger>
  <xforms:trigger component="/UI/system/components/trigger.xbl.xml#trigger" id="deletePic">
   <xforms:label id="default12"><![CDATA[删除]]></xforms:label>
  <xforms:action id="action13" ev:event="DOMActivate"><xforms:script id="xformsScript13"><![CDATA[ConScan.deletePicClick(event)]]></xforms:script></xforms:action></xforms:trigger>
  <xforms:trigger component="/UI/system/components/trigger.xbl.xml#trigger" id="uploadPic">
   <xforms:label id="default13"><![CDATA[上传]]></xforms:label>
  <xforms:action id="action1" ev:event="DOMActivate"><xforms:script id="xformsScript1"><![CDATA[ConScan.uploadPicClick(event)]]></xforms:script></xforms:action></xforms:trigger>
  <xforms:trigger component="/UI/system/components/trigger.xbl.xml#trigger" id="cancelP">
   <xforms:label id="default14"><![CDATA[取消]]></xforms:label>
  <xforms:action id="action3" ev:event="DOMActivate"><xforms:script id="xformsScript3"><![CDATA[ConScan.cancelPClick(event)]]></xforms:script></xforms:action></xforms:trigger>
  <xforms:trigger component="/UI/system/components/trigger.xbl.xml#trigger" id="upMove">
   <xforms:label id="default1"><![CDATA[前移]]></xforms:label>
  <xforms:action id="action8" ev:event="DOMActivate"><xforms:script id="xformsScript8"><![CDATA[ConScan.upMoveClick(event)]]></xforms:script></xforms:action></xforms:trigger>
  <xforms:trigger component="/UI/system/components/trigger.xbl.xml#trigger" id="nextMove">
   <xforms:label id="default15"><![CDATA[后移]]></xforms:label>
  <xforms:action id="action9" ev:event="DOMActivate"><xforms:script id="xformsScript9"><![CDATA[ConScan.nextMoveClick(event)]]></xforms:script></xforms:action></xforms:trigger>
  <xforms:trigger component="/UI/system/components/trigger.xbl.xml#trigger" id="fasterSao" appearance="image-text">
   <xforms:label id="default16"><![CDATA[开启扫描仪]]></xforms:label>
   <xforms:action id="action2" ev:event="DOMActivate">
    <xforms:script id="xformsScript2"><![CDATA[ConScan.fasterSaoClick(event)]]></xforms:script></xforms:action> </xforms:trigger>
  <xforms:trigger component="/UI/system/components/trigger.xbl.xml#trigger" id="getPic">
   <xforms:label id="default6"><![CDATA[拍照]]></xforms:label>
  <xforms:action id="action18" ev:event="DOMActivate"><xforms:script id="xformsScript18"><![CDATA[ConScan.getPicClick(event)]]></xforms:script></xforms:action></xforms:trigger>
  <xhtml:div component="/UI/system/components/select.xbl.xml#gridSelect" row-height="20" dropdown-class="xui-grid-hide-VLine" label-separator="," value-separator="," ext-separator="," id="picColor" ref="data('colors')/typeValue" label-ref="data('colors')/typeName">
   <xforms:label id="default29" ref="typeName"></xforms:label>
   <xforms:value id="default30" ref="typeValue"></xforms:value>
   <xforms:itemset id="default31" data="colorsSelect" auto-load-data="true">
  <xforms:column ref="typeName" id="default20"></xforms:column>
  <xforms:column ref="typeValue" visible="false" id="default21"></xforms:column></xforms:itemset>
  <xforms:ext-value id="default32"></xforms:ext-value></xhtml:div>
  <xforms:trigger component="/UI/system/components/trigger.xbl.xml#trigger" id="textTo">
   <xforms:label id="default17"><![CDATA[移到]]></xforms:label>
  <xforms:action id="action19" ev:event="DOMActivate"><xforms:script id="xformsScript19"><![CDATA[ConScan.textToClick(event)]]></xforms:script></xforms:action></xforms:trigger>
  <xforms:trigger component="/UI/system/components/trigger.xbl.xml#trigger" id="fileScan">
   <xforms:label id="default18"><![CDATA[开始扫描]]></xforms:label>
  <xforms:action id="action20" ev:event="DOMActivate"><xforms:script id="xformsScript20"><![CDATA[ConCamera.fileScanClick(event)]]></xforms:script></xforms:action></xforms:trigger>
  <xforms:trigger component="/UI/system/components/trigger.xbl.xml#trigger" id="fileScanClose">
   <xforms:label id="default19"><![CDATA[关闭扫描仪]]></xforms:label>
  <xforms:action id="action6" ev:event="DOMActivate"><xforms:script id="xformsScript6"><![CDATA[ConCamera.fileScanCloseClick(event)]]></xforms:script></xforms:action></xforms:trigger>
  <xhtml:div component="/UI/system/components/select.xbl.xml#gridSelect" row-height="20" dropdown-class="xui-grid-hide-VLine" label-separator="," value-separator="," ext-separator="," id="gridSelect2" ref="data('scanType')/typeValue" label-ref="data('scanType')/typeName">
   <xforms:label ref="typeName" id="default61"></xforms:label>
   <xforms:value ref="typeValue" id="default62"></xforms:value>
   <xforms:itemset id="default63" data="scanTypeSelect" auto-load-data="true">
  
  
  <xforms:column ref="typeName" id="default70"></xforms:column>
  <xforms:column ref="typeValue" visible="false" id="default71"></xforms:column></xforms:itemset></xhtml:div>
  <xforms:trigger component="/UI/system/components/trigger.xbl.xml#trigger" id="SoScan">
   <xforms:label id="default40"><![CDATA[高清扫描]]></xforms:label>
  <xforms:action id="action21" ev:event="DOMActivate"><xforms:script id="xformsScript21"><![CDATA[ConCamera.SoScanClick(event)]]></xforms:script></xforms:action></xforms:trigger></xui:view>
  <xui:view auto-load="true" id="view2" class="xui-container">
   <layout type="flow" style="position:relative;" id="layout2">
   	<xhtml:div id="contentHolder" class="xui-container" style="height:323px;width:622px;">
		 
		
		 <xhtml:section id="sectionId" class="left" >
		 <!-- 690 380 -->
		<xhtml:div id="commonDivId" style="clear: both; width: 890px; height: 280px;">
			<xhtml:div>
				<xhtml:iframe name="FileScan3125cName" src="http://120.90.2.190:8080/test/oldTT.html" width="0" height="0"></xhtml:iframe>
			</xhtml:div>
			<xhtml:div id="scanDivId" class="commonDivClass" style="clear: both; width: 100%; height: 100%;display:none;">
				   	<xhtml:div id="objectDiv" style="display:none;">
				   		<!--紫光 -->
						<xhtml:object id="DOcxtest1" classid="clsid:677C2EAE-057E-4900-97ED-1520F080942D" >
							<xhtml:param NAME="_Version" VALUE="65536"></xhtml:param>
							<xhtml:param NAME="_ExtentX" VALUE="17463"></xhtml:param>
							<xhtml:param NAME="_ExtentY" VALUE="17727"></xhtml:param>
							<xhtml:param NAME="_StockProps" VALUE="0"></xhtml:param>
						</xhtml:object>
		    			<!-- 中晶
						<xhtml:iframe name="FileScan3125c" id="FileScan3125c" src="http://192.168.0.123:8080/test/ttttt.html" scrolling="no" frameborder="0" style="display:none">
						</xhtml:iframe> -->
					</xhtml:div>
			
		    </xhtml:div>
			<xhtml:div id="cameraDivId" style="width: 49%; height: 100%;float:left;border:1px solid green;">
				<!-- 高拍仪 -->
		   		 <xhtml:object id="VideoInputCtl" classid="CLSID:454C18E2-8B7D-43C6-8C17-B1825B49D7DE" style="width: 100%; height: 100%;">
		   		 </xhtml:object>
		    </xhtml:div>
		    <xhtml:div id="pictureDivId" style="width: 49%; height: 100%;float:right;border:1px solid red;">
		    	<xhtml:img id="pictureImgId" src="data:image" style="clear: both; width: 100%; height: 100%;"></xhtml:img>
		    </xhtml:div>

	     </xhtml:div>
	   </xhtml:section>
	    
	   
  	 </xhtml:div>
   <xui:place control="ScanReceiver" id="controlPlace1" style="position:absolute;top:248px;left:194px;"></xui:place>
  </layout>
  <xhtml:div component="/UI/system/components/windowReceiver.xbl.xml#windowReceiver" id="ScanReceiver" onReceive="ConCamera.ScanReceiverReceive"></xhtml:div>
  </xui:view>
  </xui:view>  
  <xui:resource id="resource">  

  	<xhtml:script id="htmlScript1" src="/UI/ED/doc/process/dialog/ConScan/ConScan.js"/>
    <xhtml:script src="/UI/system/components/windowDialog/FrameWindow.js"/> 
  <xhtml:script id="htmlScript2" src="ConCamera.js"></xhtml:script></xui:resource> 
</xui:window>
