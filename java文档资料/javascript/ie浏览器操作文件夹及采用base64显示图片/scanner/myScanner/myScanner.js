
//加载要封装的dll文件
function Load()
{
   var tt = DOcxtest1.LoadDll(); //加载要封装的dll文件
   var r1 = DOcxtest1.SelectScanner(""); //选择扫描仪；本函数未执行前，程序会以系统默认扫描仪做为使用对象；
   //if (tt < 0)
  	alert(tt);
}

//执行扫描
function Scan(nScan)
{
	//创建一个文件
	createAFolder();
	//var r1 = DOcxtest1.SelectScanner("Uniscan F10A"); //选择扫描仪；本函数未执行前，程序会以系统默认扫描仪做为使用对象；
	// var r2 = DOcxtest1.SetAutoLevels(0);
	var ts = DOcxtest1.EnConnect(1); //连接到扫描仪，与disconnect 配合使用，请确保执行scan 函数前本函数已执行；
	var rt = DOcxtest1.SetScannerSource(1);  //设置扫描源；
	alert(rt); //有问题

	var r4 = DOcxtest1.SetScannerImageType(2); //设置扫描类型;
	var r5 = DOcxtest1.SetThreshold(128); //设置扫描阈值，只在黑白扫描模式(二值模式)时起作用;
	var r6 = DOcxtest1.SetScannerBright(-100); //设置扫描亮度；黑白模式时失效
	var r6 = DOcxtest1.SetScannerContrast(0); //设置扫描对比度；黑白模式时失效
	var r7 = DOcxtest1.SetScannerScanRgn(0,0,210,297);//设置扫描区域，单位：毫米；取值范围：420mm×600mm（A4 幅面为210×300）矩形范围由左上点位置和右下点位置决定;
	var r8 = DOcxtest1.SetScanInvert(0);//设置取反色；本函数未执行前，默认为不取反色；
	var r9 = DOcxtest1.SetScannerDPI(200); //设置扫描DPI;
	/*
		设置扫描部分参数
		ImageIndex：文件名索引数，（如0，则完整的文件路径为X:\XXX\XX0000.xxx，后缀根据格式确定）
		FileType：图片文件格式类型
			-0为bmp
			-1为tiff
			-2为jpeg
			-3为gif
			-4为pdf
			-5为png
		文件名将根据此设定指定三位后缀
		nParam1 设置图像压缩比(JPG和TIF,PDF有效)取值为1~100;
		nParam2 设置是否生成多页文件(适用于PDF,TIF文件格式，ADF硬件条件)，0为生成单页文件，1为生成多页文件;
		Param3 设置图像旋转角度，取值0~360，旋转为右旋。
	*/
	var r10 = DOcxtest1.SetScanner(0,5,70,1,0);//见上
	/*
		设置是否覆盖同名文件；本函数未执行前，默认为不覆盖；
		返回值：BOOL 型，1代表正常，0 代表失败；
		参数[in]：BOOL型，是否覆盖同名文件，1为覆盖，0为不覆盖；

	*/
	var r11 = DOcxtest1.SetCoverFile(0); //见上
	/*
		说明：执行扫描功能
		返回值：返回值大于0 时表示扫描成功，当返回值大于1时，返回值即为扫描页数
		返回值为0 时扫描仪操作错误
		返回值为－1 时内存错误
		返回值为－2 时磁盘错误
		返回值为－3 时获取图像失败错误
		返回值为－4 时参数设置错误
		参数[in]：
		path： 指定扫描后文件的名字和输出路径（如：C:\TEST\），请确保设定的路径可写且已经存在;
		fileName：指定扫描文件名（如aaa）,无需设置文件后缀，后缀将根据图片格式自行设置;
	*/
	var tt = DOcxtest1.StartScanner("d:\\temp\\img\\", "image");
	//alert(tt);

   //if (tt < 0)
   /*
   for(var i=0;i<tt;i++){
	alert("tt"+tt);
	var fn = DOcxtest1.GetFileName();
	alert("fn"+fn);
	var ffn = DOcxtest1.GetFullFileName();
	alert("ffn"+ffn);
	var base = DOcxtest1.FileToBase64(ffn);
	alert(base);
   }
   */
	var fso = getAllFileName(DOcxtest1);

  //var bf = DOcxtest1.Base64ToFile("D:\\img\\image0004.PNG","D:\\base.txt");
  //var bf = DOcxtest1.Base64ToFile(ffn,"D:\\base.txt");
 //alert("bf : "+bf);
  
  //var ImageNumber = DOcxtest1.GetImageNumber();
  //alert(ImageNumber);

  //DOcxtest1.RotateImage("C:\\1.bmp",90);

  var r3 = DOcxtest1.DisConnect(); //连接到扫描仪，与EnConnect 配合使用；
  DeleteFolder(fso);
}

//获得所有的文件
function getAllFileName(DOcxtest1){
	var filePath = "d:\\temp\\img";
	var fso = new ActiveXObject("Scripting.FileSystemObject");   //加载控件
	var f = fso.GetFolder(filePath);
	var underFiles = new Enumerator(f.files); //文件夹下文件
	for (;!underFiles.atEnd();underFiles.moveNext()){   
		var fn = "" + underFiles.item();   
		//alert(fn);
		var base = DOcxtest1.FileToBase64(fn);
		alert(base);
		var Base64Image1 = document.getElementById("Base64Image");
		//alert(Base64Image.src);
		alert(Base64Image1);
		Base64Image1.src = "data:image/tiff;base64," + base;
	}
	
	return fso;
}

//创建一个文件夹及
function createAFolder(){
	alert(1111111);
	var fso, fldr, s = "";  
	 // 创建FileSystemObject对象实例  
	fso = new ActiveXObject("Scripting.FileSystemObject");  
	try{
		 // 获取Drive 对象  
		fldr = fso.GetFolder("d:\\temp"); 
		
		 // 显示父目录名称  
		alert("Parent folder name is: " + fldr + "\n");  
		 // 显示所在drive名称  
		alert("Contained on drive " + fldr.Drive + "\n");  
	}catch(e){
		// 创建新文件夹  
			fso.CreateFolder("d:\\temp"); 
	}
	
	try{
		fldr = fso.GetFolder("d:\\temp\\img"); 
	}catch(e){
		fso.CreateFolder ("d:\\temp\\img");  
	}

	 // 判断是否为根目录  
	//if (fldr.IsRootFolder)  
	 //alert("This is the root folder.");  
	 //else  
	 //alert("This folder isn't a root folder.");  
	 //alert("\n\n");  
	 // 创建新文件夹  
	//fso.CreateFolder ("D:\\img");  
	 //alert("Created folder D:\\img" + "\n");  
	 // 显示文件夹基础名称，不包含路径名  
	//alert("Basename = " + fso.GetBaseName("D:\\bogus") + "\n");  
	 // 删除创建的文件夹  
	//fso.DeleteFolder ("D:\\Bogus");  
	// alert("Deleted folder D:\\Bogus" + "\n");  
}

//删除文件夹
function DeleteFolder(fso){
	//删除创建的文件夹  
	alert("删除img文件夹吗");
	fso.DeleteFolder ("d:\\temp\\img"); 
}


