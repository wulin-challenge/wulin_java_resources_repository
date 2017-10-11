var ConCamera = {};
var ConScan = {};
var zgArray = new Array();//base64位数组
var fileArray = new Array();//文件地址数组
var tempFile = "C:\\temp\\tmp";//本地临时文件地址
var tempFileName = "";//当前预览文件地址
var tempValue = 0;//当前预览图片编号，初始为0
var picON = false;//高拍仪状态  true 开启，false 关闭
var scanType = 1;//扫描类型 默认单面
var f10aON = false;//紫光开启状态
var f10aCount = 0;//紫光扫描个数
//初始化函数
ConScan.mdMainReady = function(event){
};

/**上传文件方法*/
function uploadToServiceNew(file,fname,fid,fno,fcount,fstat){
	justep.Request.sendBizRequest2({
		contentType: "application/json",
		dataType: "application/json",
		action: "FileUploadToolNew",
		parameters: {
			fileBase64:file,
			fileName:fname,
			fDocLink:'',
			fid:fid,
			fPageNo:fno+'',
			fPageCount:fcount,
			fStat:fstat,
			fextendedParam1:'',
			fextendedParam2:''
		},
		callback: function(result) {
			if(JSON.parse(result.state)){
				var obj = JSON.parse(result.response);
				if(obj.msgno==null){
					showPic('');//清楚图片预览
					deleteFileFolder();//删除原文件
					zgArray.length = 0;//清空base数组
					fileArray.length = 0;//清空文件数组
					tempFileName = "";//当前预览文件地址
					tempValue = 0;//当前编号，初始为0
					labelChange();//显示修改
					var str = VideoInputCtl.bStopPlay();//关闭摄像头
					picON = false;//高拍仪状态关闭
					f10aON = false;//紫光关闭
					f10aCount = 0;
					VideoInputCtl.bDeleteFileForever('C:\\temp\\f10a\\');	
					
					
					var data = {"fDocLink":result.response};
					justep.xbl("ScanReceiver").windowEnsure(data);	
				}else if(obj.msgno=="9999"){
					alert(obj.msg);
				}
			}else{
				alert("上传失败！");
				//alert('1'+result.response);//throw new Error(result.response);
			}
		}
	});
}
/**创建文件夹**/
function createFileFolder(){
	var flag = VideoInputCtl.bCreateDir(tempFile);
	return flag;
}
/**删除文件夹**/
function deleteFileFolder(){
	var flag = VideoInputCtl.bDeleteFileForever(tempFile);
	return flag;
}
/**显示图片**/
function showPic(base64){
	var pictureImgId =  document.getElementById('pictureImgId') ;//图片预览div	
	pictureImgId.src = "data:image/tiff;base64," + base64;
}
/**显示遮蔽框**/		
var alertM  = new justep.System.showMessage();
function showDiv(){
	alertM.open({"msg" : "文件正在上传中，请不要在“上传完成”弹框弹出之前点击其它按钮！",
        "title" : '提示',
        "type" : null,
        "img" : 'question'});

}
function hideDiv(){
	alertM.close();
}
/**改变预览页面label**/
function labelChange(){
	var str = '';
	var total = fileArray.length;
	if(tempValue>0){
		str += '当前第'+tempValue+'张，共'+total+'张';
	}else{
		str += '当前无预览，共'+total+'张';
	}
	$('#fileLabel').html(str);
	
		
}

/**生成唯一编码时间戳**/

function getTimeString(){
	var myDate = new Date();
	var str = myDate.getFullYear()+''
	        +(myDate.getMonth()+1)+''
	        +myDate.getDate()+''
	        +myDate.getHours()+''
	        +myDate.getMinutes()+''
	        +myDate.getSeconds()+''
	        +myDate.getMilliseconds();
	return str;
}


/**上传**/
ConScan.uploadPicClick = function(event){
	var fileName = $('#fileName').val();//文件名
	if(fileName == ''){
		alert('请输入文件名！');
		return;
	}else{
		var total = zgArray.length;
		if(total>0){
//			for(var j=0;j<fileArray.length;j++){//循环生成base数组
//				try {
//					DOcxtest1.LoadDll(); //加载要封装的dll文件
//					var base = DOcxtest1.FileToBase64(fileArray[j]);	
//					zgArray.push(base);				
//				} catch (e) {
//					alert('紫光扫描仪驱动未安装');
//				}
//			}
			//上传文件
			var Zg_fid = getTimeString();
			var Zg_fname = fileName;
			var fstat = 'middle';//默认中间页 
			var Zg_count = zgArray.length;
			
			if(Zg_count==1){
				fstat = 'end';
				uploadToServiceNew(zgArray[0],Zg_fname,Zg_fid,1,Zg_count,fstat);
			}else{
				for(var i =1;i<=Zg_count;i++){
					if(i==1){//第一张
						fstat = 'begin';
					}else if(i==Zg_count){//最后一张
						fstat = 'end';
					}else{
						fstat = 'middle';
					}
					uploadToServiceNew(zgArray[i-1],Zg_fname,Zg_fid,i,Zg_count,fstat);
				}
			}			
		}else{
			alert('无照片！');
		}

	}
	
};
/**取消**/
ConScan.cancelPClick = function(event){	
	justep.xbl("ScanReceiver").windowCancel();//关闭窗口
	showPic('');//清楚图片预览
	deleteFileFolder();//删除原文件
	zgArray.length = 0;//清空base数组
	fileArray.length = 0;//清空文件数组
	tempFileName = "";//当前预览文件地址
	tempValue = 0;//当前编号，初始为0
	labelChange();//显示修改
	var str = VideoInputCtl.bStopPlay();//关闭摄像头
	picON = false;//高拍仪状态关闭
	f10aON = false;//紫光关闭
	f10aCount = 0;
	VideoInputCtl.bDeleteFileForever('C:\\temp\\f10a\\');	
};
/**第一张**/
ConScan.firstPicClick = function(event){
//	var total = fileArray.length;
//	if(total>0){
//		try {
//			DOcxtest1.LoadDll(); //加载要封装的dll文件			
//			var base = DOcxtest1.FileToBase64(fileArray[0]);
//			showPic(base);
//			tempFileName = fileArray[0];//当前预览图片置换为第一张
//			tempValue = 1;//第一张
//			labelChange();
//		} catch (e) {
//			alert('紫光扫描仪驱动未安装！');
//		}
//	}else{
//		alert('无照片！');
//	}
	var total = zgArray.length;
	if(total>0){
		var base = zgArray[0];
		showPic(base);
		tempFileName = fileArray[0];//当前预览图片置换为第一张
		tempValue = 1;//第一张
		labelChange();
	}else{
		alert('无照片！');
	}

};
/**上一张**/
ConScan.upPicClick = function(event){
//	var total = fileArray.length;
//	if(total>0){
//		if(tempValue>1){
//			try {
//				DOcxtest1.LoadDll(); //加载要封装的dll文件			
//				var base = DOcxtest1.FileToBase64(fileArray[tempValue-2]);
//				showPic(base);
//				tempFileName = fileArray[tempValue-2];//当前预览图片
//				tempValue--;//
//				labelChange();
//			} catch (e) {
//				alert('紫光扫描仪驱动未安装！');
//			}			
//		}else{
//			alert('已经是第一张！');
//		}
//
//	}else{
//		alert('无照片！');
//	}

	var total = zgArray.length;
	if(total>0){
		if(tempValue>1){
				var base =zgArray[tempValue-2];
				showPic(base);
				tempFileName = fileArray[tempValue-2];//当前预览图片
				tempValue--;//
				labelChange();
		}else{
			alert('没有了！');
		}
	}else{
		alert('无照片！');
	}
};
/**前移**/
ConScan.upMoveClick = function(event){
//	var total = fileArray.length;
//	if(total>0){
//		if(tempValue==1){//第一张
//			alert('已经是第一张！');
//		}else{
//			var tmp = fileArray.splice((tempValue-1),1);//得到移除的元素					
//			fileArray.splice((tempValue-2),0,tmp);//将移除元素放到指定位置
//			tempValue--;//修改当前张数
//			tempFileName = tmp;//当前文件地址
//			labelChange();//修改显示
//		}
//	}else{
//		alert('无照片！');
//	}

	var total = zgArray.length;
	if(total>0){
		if(tempValue==1){//第一张
			alert('已经是第一张！');
		}else{
			var tmp = fileArray.splice((tempValue-1),1);//得到移除的元素					
			fileArray.splice((tempValue-2),0,tmp);//将移除元素放到指定位置
			
			var baseTmp =  ''+zgArray.splice((tempValue-1), 1);
			zgArray.splice((tempValue-2),0,baseTmp);//将移除元素放到指定位置
			
			tempValue--;//修改当前张数
			tempFileName = tmp;//当前文件地址
			labelChange();//修改显示
		}
	}else{
		alert('无照片！');
	}	
};
/**后移**/
ConScan.nextMoveClick = function(event){
//	var total = fileArray.length;
//	if(total>0){
//		if(tempValue==total){//最后一张
//			alert('已经是最后一张！');
//		}else{
//			var tmp = fileArray.splice((tempValue-1),1);//得到移除的元素					
//			fileArray.splice(tempValue,0,tmp);//将移除元素放到指定位置
//			tempValue++;//修改当前张数
//			tempFileName = tmp;//当前文件地址
//			labelChange();//修改显示
//		}
//	}else{
//		alert('无照片！');
//	}

	var total = zgArray.length;
	if(total>0){
		if(tempValue==total){//最后一张
			alert('已经是最后一张！');
		}else{
			var tmp = fileArray.splice((tempValue-1),1);//得到移除的元素					
			fileArray.splice(tempValue,0,tmp);//将移除元素放到指定位置
			
			var baseTmp = ''+zgArray.splice((tempValue-1), 1);
			zgArray.splice(tempValue,0,baseTmp);//将移除元素放到指定位置
						
			tempValue++;//修改当前张数
			tempFileName = tmp;//当前文件地址
			labelChange();//修改显示
		}
	}else{
		alert('无照片！');
	}	
};
/**移到**/
ConScan.textToClick = function(event){
//	var total = fileArray.length;
//	if(total>0){
//		var textToNum = $('#textToNum').val();//移到多少张
//		if(textToNum!=''){
//			var num = parseInt(textToNum);
//			if(textToNum>0){
//				if(textToNum>total){//超出张数
//					alert('超出最大张数！');
//				}else if(textToNum==tempValue){//等于当前张数
//					alert('当前张数等于输入张数！');
//				}else{
//					var tmp = fileArray.splice((tempValue-1),1);//得到移除的元素					
//					fileArray.splice((textToNum-1),0,tmp);//将移除元素放到指定位置
//					tempValue = textToNum;//修改当前张数
//					tempFileName = tmp;//当前文件地址
//					labelChange();//修改显示
//				}
//			}else{
//				alert('请输入移动到的张数！');
//			}
//		}else{
//			alert('请输入移动到的张数！');
//		}		
//	}else{
//		alert('无照片！');
//	}

	
	var total = zgArray.length;
	if(total>0){
		var textToNum = $('#textToNum').val();//移到多少张
		if(textToNum!=''){
			var num = parseInt(textToNum);
			if(textToNum>0){
				if(textToNum>total){//超出张数
					alert('超出最大张数！');
				}else if(textToNum==tempValue){//等于当前张数
					alert('当前张数等于输入张数！');
				}else{
					var tmp = fileArray.splice((tempValue-1),1);//得到移除的元素					
					fileArray.splice((textToNum-1),0,tmp);//将移除元素放到指定位置
					
					var baseTmp =  ''+zgArray.splice((tempValue-1), 1);
					zgArray.splice((textToNum-1),0,baseTmp);//将移除元素放到指定位置
					
					tempValue = textToNum;//修改当前张数
					tempFileName = tmp;//当前文件地址
					labelChange();//修改显示
				}
			}else{
				alert('请输入移动到的张数！');
			}
		}else{
			alert('请输入移动到的张数！');
		}		
	}else{
		alert('无照片！');
	}

};
/**下一张**/
ConScan.nextPicClick = function(event){
//	var total = fileArray.length;
//	if(total>0){
//		if(tempValue<total){
//			try {
//				DOcxtest1.LoadDll(); //加载要封装的dll文件			
//				var base = DOcxtest1.FileToBase64(fileArray[tempValue]);
//				showPic(base);
//				tempFileName = fileArray[tempValue];//当前预览图片
//				tempValue++;//第一张
//				labelChange();
//			} catch (e) {
//				alert('紫光扫描仪驱动未安装！');
//			}			
//		}else{
//			alert('已经是第一张！');
//		}
//
//	}else{
//		alert('无照片！');
//	}	
	
	var total = zgArray.length;
	if(total>0){
		if(tempValue<total){
				var base = zgArray[tempValue];
				showPic(base);
				tempFileName = fileArray[tempValue];//当前预览图片
				tempValue++;
				labelChange();
		}else{
			alert('没有了！');
		}

	}else{
		alert('无照片！');
	}	
};
/**最后一张**/
ConScan.lastPicClick = function(event){
//	var total = fileArray.length;
//	if(total>0){
//		try {
//			DOcxtest1.LoadDll(); //加载要封装的dll文件			
//			var base = DOcxtest1.FileToBase64(fileArray[total-1]);
//			showPic(base);
//			tempFileName = fileArray[total-1];//当前预览图片置换为第一张
//			tempValue = total;//第一张
//			labelChange();
//		} catch (e) {
//			alert('紫光扫描仪驱动未安装！');
//		}
//	}else{
//		alert('无照片！');
//	}
	var total = zgArray.length;
	if(total>0){
			var base = zgArray[total-1];
			showPic(base);
			tempFileName = fileArray[total-1];//当前预览图片置换为第一张
			tempValue = total;//第一张
			labelChange();
	}else{
		alert('无照片！');
	}
};
/**旋转**/
ConScan.xuanZhuanPicClick = function(event){
	if(tempFileName!=''){
		try {
			var flag = VideoInputCtl.bRotateJpgImage(tempFileName,90);	
			try {
				DOcxtest1.LoadDll(); //加载要封装的dll文件			
				var base = DOcxtest1.FileToBase64(tempFileName);
				showPic(base);//显示图片	
				zgArray.splice((tempValue-1),1,base );	//替换当前项			
			} catch (e) {
				alert('紫光扫描仪驱动未安装！');
			}		
		} catch (e) {
			alert('高拍仪驱动未安装！');
		}
	}else{
		alert('无预览照片！');
	}
};
/**删除**/
ConScan.deletePicClick = function(event){
//	var total = fileArray.length;//总文件数
//	if(tempFileName !='' && total>0){
//		if(total==1){//只有一张照片
//			fileArray.length = 0;//清空文件数组
//			tempValue = 0;//当前为第0张
//			tempFileName = '';//清空数组
//			showPic('');
//			labelChange();
//		}else{//有多张
//			if(tempValue==1){//当前第一张
//				fileArray.splice(0,1);//将数组第一个替换	
//				tempFileName = fileArray[0];
//			}else{//当前非第一张  删除后显示前一张图片
//				fileArray.splice((tempValue-1),1);//将数组当前预览
//				tempValue--;		//当前张数-1	
//				tempFileName = fileArray[(tempValue-1)];
//				
//			}
//			try {
//				DOcxtest1.LoadDll(); //加载要封装的dll文件			
//				var base = DOcxtest1.FileToBase64(tempFileName);
//				showPic(base);//显示图片	
//				labelChange();
//			} catch (e) {
//				alert('紫光扫描仪驱动未安装！');
//			}	
//		}
//
//	}else{
//		alert('无照片！');
//	}
	
	var total = zgArray.length;//总文件数
	if(tempFileName !='' && total>0){
		if(total==1){//只有一张照片
			fileArray.length = 0;//清空文件数组
			zgArray.length = 0;
			tempValue = 0;//当前为第0张
			tempFileName = '';//清空数组
			showPic('');
			labelChange();
		}else{//有多张
			if(tempValue==1){//当前第一张
				fileArray.splice(0,1);//将数组第一个替换	
				zgArray.splice(0,1);
				tempFileName = fileArray[0];
			}else{//当前非第一张  删除后显示前一张图片
				fileArray.splice((tempValue-1),1);//将数组当前预览
				zgArray.splice((tempValue-1),1);
				tempValue--;		//当前张数-1	
				tempFileName = fileArray[(tempValue-1)];
				
			}
			var base = zgArray[tempValue-1];
			showPic(base);//显示图片	
			labelChange();
		}

	}else{
		alert('无照片！');
	}
};
/**开启高拍仪**/
ConScan.openPicClick = function(event){
	try {
		createFileFolder();//创建文件夹
		var str = VideoInputCtl.bStopPlay();
		var str1 = VideoInputCtl.bStartPlay();
		if(!str1){
			alert('高拍仪开启失败!');
		}else{
		    VideoInputCtl.bSetMode(3);//设置模式
//	      0—支持鼠标框选模式（默认模式） 
//	      1—定义固定大小拍照模式 
//	      2—定义固定大小身份证拍照模式 
//	      3—自动寻边 
//	      4—自动寻边身份证拍照模式
		    VideoInputCtl.vSetFocus(20,1);//设置焦点 
			VideoInputCtl.vSetSkewFlag(1);//设置自动校正
			VideoInputCtl.vSetDelHBFlag(1);//设置黑边去除
			picON = true;
		}
	} catch (e) {
		alert('高拍仪驱动未安装！');
	}
	
};
/**设置分辨率**/
ConScan.setPin1Click = function(event){
	try {
		if(picON){
			VideoInputCtl.vSetCapturePin();//设置高拍仪 pin参数
			picON = false;
		}else{
			alert('请开启高拍仪！');
		}
	} catch (e) {
		alert('高拍仪驱动未安装！');
	}
};
/**设置属性**/
ConScan.setPin2Click = function(event){
	try {
		if(picON){
			VideoInputCtl.displayVideoPara();
		}else{
			alert('请开启高拍仪！');
		}
		
	} catch (e) {
		alert('高拍仪驱动未安装！');
	}
};

/**拍照**/
ConScan.getPicClick = function(event){
	if(picON){
		var type = justep.xbl('picColor').getValue();	
		try {
			var name = getTimeString();//文件名称
			var jpg = false;
			if(type=='1'){//黑白
				jpg = VideoInputCtl.bSaveTifJPG(tempFile+'\\',name);
			}else{//彩色
				jpg = VideoInputCtl.bSaveJPG(tempFile+'\\',name);
			}
			if(jpg){
				tempFileName = tempFile+'\\'+name+'.jpg';//当前文件名称
				try {
					DOcxtest1.LoadDll(); //加载要封装的dll文件
					var base = DOcxtest1.FileToBase64(tempFileName);
					showPic(base);//显示图片
					fileArray.push(tempFileName);//储存进文件名数组
					zgArray.push(base);//储存进base数组
					tempValue = fileArray.length;//当前变为最后一张
					labelChange();
				} catch (e) {
					alert('读取文件错误,驱动未安装!');
				}
				alert('拍照成功！');		
			}else{
				alert('拍照失败！');
			}
		} catch (e) {
			alert('高拍仪驱动未安装！');
		}
	}else{
		alert('请开启高拍仪！');
	}

};
/**关闭高拍仪**/
ConScan.closePicClick = function(event){
	if(picON){
		try {
			var str = VideoInputCtl.bStopPlay();
			if(!str){
				alert('高拍仪关闭失败!');
			}else{
				picON = false;
			}
		} catch (e) {
			alert('高拍仪驱动未安装！');
		}
	}else{
		alert('高拍仪关闭成功！');
	}
};

/**开启扫描仪**/
ConScan.fasterSaoClick = function(event){
	createFileFolder();//创建临时文件夹
	window.frames["FileScan3125cName"].Open();
	//justep.xbl('FileScan3125c').refresh();
};
/**关闭扫描仪**/
ConCamera.fileScanCloseClick = function(event){
	window.frames["FileScan3125cName"].ScanClose();
};
/**开始扫描**/
ConCamera.fileScanClick = function(event){
	var type = justep.xbl('gridSelect2').getValue();
	scanType = type;
	window.frames["FileScan3125cName"].Scan();
};
/**高清扫描**/
ConCamera.SoScanClick = function(event){
	var type = justep.xbl('gridSelect2').getValue();
	scanType = type;
	window.frames["FileScan3125cName"].SoScan();	
};

/**
	name:windowReceiver#onReceive
	@event 
description: <b>[回调型事件]</b> window接收调用者传入的数据
	@param event 
	<br/><b>格式说明：</b>
	<xmp>
	{
		"source" : 组件的js对象,
		"data" : 传入的数据
	}
	</xmp>
	@example
	//接受传入的rowid，组成filter刷新data
	1、data组件上定义filter1 = DEMO_TABLE1 = :rowid
	2、接管onReceive
	windowReceiverReceive = function(event){
		if(event.data && event.data.rowid){
			var data = justep.xbl('mainData');
			//给变参:rowid赋值
			data.filters.setStringVar('rowid', event.data.rowid);
			data.refreshData();
		}
	}

	检测驱动程序
*/
ConCamera.ScanReceiverReceive = function(event){
	if(CameraCheck()){
	}else{
		ScanCheck();
	}
};
/***高拍仪驱动检测**/
function CameraCheck(){
	try {
		var str = VideoInputCtl.bStopPlay();
		return true;
	} catch (e) {
		alert('高拍仪驱动未安装.');
		return false;
	}
}

/***扫描仪驱动检测**/
function ScanCheck(){
	window.frames["FileScan3125cName"].OpenCheck();
}
/**关闭窗口**/
function closeDialog(){
	justep.xbl("ScanReceiver").windowCancel();//关闭窗口
}


/**旧式扫描仪扫描**/
ConCamera.oldScanClick = function(event){
  if(f10aON){
	  var f10a = "C:\\temp\\f10a\\";
	  VideoInputCtl.bCreateDir(f10a);//创建文件夹
	  deleteFileFolder();
	  //默认选中紫光
	  DOcxtest1.SelectScanner("Uniscan F10A");
	  //得到句柄 1 成功 0 失败
	  var ts = DOcxtest1.EnConnect(1);
	  if(ts==0){
		  alert('请开启紫光扫描仪开关!');
		  return;
	  }
	  //双面 2 单面 1 此设置无用
	  var rt = DOcxtest1.SetScannerSource(1);
	  //黑白
	  DOcxtest1.SetScannerImageType(0);
	  //dpi
	  DOcxtest1.SetScannerDPI(1000);
	  //文件名+jpg+80%压缩+单页文件+旋转0度
	  DOcxtest1.SetScanner((f10aCount+1),2,80,0,0);
	  //覆盖 1 不覆盖0
	  DOcxtest1.SetCoverFile(1);
	  //文件存放文件夹
	  var tt = DOcxtest1.StartScanner(f10a, "image");
	  var ImageNumber = DOcxtest1.GetImageNumber();
	  f10aCount += ImageNumber;//记录当前紫光扫描张数
	  alert('扫描完成：共计'+ImageNumber+'张!');
	  DOcxtest1.DisConnect();
  }else{
	  alert('请开启紫光扫描仪!');
  }
	
};
/**开启旧式扫描仪**/
ConCamera.openOldScanClick = function(event){
	try {
		 var tt = DOcxtest1.LoadDll();
		 if(tt==1){
			 alert('紫光扫描仪开启成功!');
			 f10aON = true;
		 }else{
			 f10aON = false;
			 alert('紫光扫描仪开启失败!');
		 }
	} catch (e) {
		alert('紫光扫描仪驱动未安装!');
		f10aON = false;
	}
	
};
/**获取图像**/
ConCamera.getOldPicClick = function(event){
	if(f10aON){
		var count = 0;
		var path = 'C:\\temp\\f10a\\';
		try {
			var fso = new ActiveXObject("Scripting.FileSystemObject"); 
			var fldr = fso.GetFolder(path);  
		    var ff = new Enumerator(fldr.Files);        
		    for(; !ff.atEnd(); ff.moveNext()){  
		        var fileName = path+ff.item().Name + '';  
		        var base = DOcxtest1.FileToBase64(fileName);
				count++;				
				
				showPic(base);//显示图片				
				zgArray.push(base);//base数组
				tempFileName = fileName;//当前预览
				tempValue++;//当前张数+1
				fileArray.push(fileName);//文件数组+
				labelChange();//改变预览
		    } 
		} catch (e) {
			count = 0;
		}
		if(count>0){//获取到图像则删除文件夹
			alert('获取成功,获取到'+count+'张');
			//VideoInputCtl.bDeleteFileForever(path);	
		}else{
			alert('获取图像失败!');
		}
	}else{
		alert('请开启紫光扫描仪!');
	}
 
};
