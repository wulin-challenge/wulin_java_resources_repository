
//var szDefaultDevice = "NewImage DocCam"; // 540
var szDefaultDevice = "[1a3c:010d]"; // 525

//初始化装置的函数
function initialize() {
	var nDeviceCount = VideoInputCtl.GetDeviceCount();//获取装置的数量
	for (var i = 0; i < nDeviceCount; i++) {
		var szDeviceName = VideoInputCtl.GetDeviceName(i);//获取装置的名称
	}
	if (nDeviceCount > 0 && szDefaultDevice.length > 0)
		opendevice();//调用打开装置的函数
}

//打开装置函数
function opendevice() {
	var nDeviceIndex = 0;//装置的编号

	if (!VideoInputCtl.IsDeviceOpened(nDeviceIndex))//判断装置是否已经打开
		VideoInputCtl.OpenDevice(nDeviceIndex); //打开装置,注意:这个 "OpenDevice(index)"与openDevice();是有区别的,前者是c#编写的底层函数

	var nFormatCount = VideoInputCtl.GetDeviceFormatCount(nDeviceIndex);//传回指定装置的分辨率的数量
	for (var i = 0; i < nFormatCount; i++) {
		var szFormatName = VideoInputCtl.GetDeviceFormatName(nDeviceIndex, i);//传回指定装置分辨率的名称。第一个参数:装置的编号。第二个参数:分辨率的编号。
	}

	VideoInputCtl.StartPlayDevice(nDeviceIndex);//开始播放指定的装置。参数:要播放的装置的编号。注意:其他正在播放的装置会被停止。

}

//拍照(抓取图形)函数
function grabimage() {
	var nDeviceIndex = VideoInputCtl.GetDeviceIndex();//传回目前正在播放的装置的编号,注意:装置编号总是大於或等於0。如果没有任何装置正在播放，传回0。

	VideoInputCtl.GrabToFile("D:\第一个文件.jpg"); //设置文件路径及其文件名及其文件格式 <==> 拍照并存档。

	//BarcodeText.value = ""; //是某个html元素的Id
	if (VideoInputCtl.GetDeviceBarcode(nDeviceIndex)) { //传回指定装置是否进行一维条码辨识。参数:装置的编号。
		var nCount = VideoInputCtl.GetBarcodeCount();//传回上次拍照时的一维条码数量。
		var szType, szText;
		for (var i = 0; i < nCount; i++) {
			szType = VideoInputCtl.GetBarcodeTypeName(i); //传回上次拍照时的一维条码类型。参数:一维条码的编号。返回:一维条码的类型。
			szText = VideoInputCtl.GetBarcodeContent(i); //传回上次拍照时的一维条码内容。参数:一维条码的编号。返回:一维条码的内容。
			//BarcodeText.value += szType + ": " + szText + "\r\n";
		}
	}

	//QRcodeText.value = "";//是某个html元素的Id
	if (VideoInputCtl.GetDeviceQRcode(nDeviceIndex)) { //传回指定装置是否进行二维条码辨识。参数:装置的编号。
		var nCount = VideoInputCtl.GetQRcodeCount(); //传回上次拍照时的二维条码数量。注意:请先拍照(GrabToFile)而后取得二维条码数量、内容与类型。
		var szType, szText;
		for (var i = 0; i < nCount; i++) {
			szType = VideoInputCtl.GetQRcodeTypeName(i); //传回上次拍照时的二维条码类型。参数:二维条码的编号。返回:二维条码的类型。
			szText = VideoInputCtl.GetQRcodeContent(i); //传回上次拍照时的二维条码内容。参数:二维条码的编号。
			//QRcodeText.value += szType + ": " + szText + "\r\n";
		}
	}

//OCRText.value = "";
	if (VideoInputCtl.GetDeviceOCR(nDeviceIndex)) {//传回指定装置在拍照时是否进行文字辨识。参数:装置的编号。注意:必须安装Microsoft Office Document Imaging 12.0。
		//OCRText.value = VideoInputCtl.GetOCRResult(); //传回上一次文字辨识的结果。
	}
}

//图片旋转函数
function rotateangle(angle) {
	Rotate0.checked = false;
	Rotate90.checked = false;
	Rotate180.checked = false;
	Rotate270.checked = false;
	if (angle == 90) Rotate90.checked = true;
	else if (angle == 180) Rotate180.checked = true;
	else if (angle == 270) Rotate270.checked = true;
	else Rotate0.checked = true;

	var nDeviceIndex = VideoInputCtl.GetDeviceIndex(); //传回目前正在播放的装置的编号。
	VideoInputCtl.SetDeviceRotate(nDeviceIndex, angle);//设定指定装置的旋转角度。第一个参数:装置的编号。第二个参数:旋转角度，可以是任意角度(0~360)，设定为90的倍数时花费较少运算。
	
}

//将抓取的图片编译成base64码
function grabbase64() {
	var szBase64 = VideoInputCtl.GrabToBase64(".jpg");//拍照并传回其Base64编码字串.参数:影像格式，必须是.bmp、.jpg、.png或.tif。返回:Base64编码字串。
	Base64Text.value = szBase64;
	Base64Image.src = "data:image/tiff;base64," + szBase64;
}

//拍照,并将图片保存为pdf格式
function grabtopdf() {
	VideoInputCtl.GrabToPdf(PdfFile.value, "", "", "", "", "");
}



