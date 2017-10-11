//创建一个文件夹及
function createFolder(){
	alert(1111111);
	var fso, fldr, s = "";  
	 // 创建FileSystemObject对象实例  
	fso = new ActiveXObject("Scripting.FileSystemObject");  
	try{
		 // 获取Drive 对象  
		fldr = fso.GetFolder("d:\\img"); 
		 // 显示父目录名称  
		alert("Parent folder name is: " + fldr + "\n");  
		 // 显示所在drive名称  
		alert("Contained on drive " + fldr.Drive + "\n");  
	}catch(e){
		// 创建新文件夹  
		fso.CreateFolder ("D:\\img");  
		alert("Created folder D:\\img" + "\n");  
		// 显示文件夹基础名称，不包含路径名  
		alert("Basename = " + fso.GetBaseName("D:\\bogus") + "\n");  
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

//创建一个文件并删除
function createFile(){
	alert(222222);
	var fso, f1;  
	fso = new ActiveXObject("Scripting.FileSystemObject");  
	f1 = fso.CreateTextFile("D:\\img\\testfile.txt", true);  
	f2 = fso.GetFile("D:\\img\\testfile.txt");  
	alert(f2);
	//var v = f2.Delete(); //删除一个文件 
	//alert(v);
}

//获得所有的文件
function getAllFileName(){
	var filePath = "d:\\img\\";
	var fso = new ActiveXObject("Scripting.FileSystemObject");   //加载控件
	var f = fso.GetFolder(filePath);
	var underFiles = new Enumerator(f.files); //文件夹下文件
	for (;!underFiles.atEnd();underFiles.moveNext()){   
		var fn = "" + underFiles.item();   
		alert(fn);
	}
}





















