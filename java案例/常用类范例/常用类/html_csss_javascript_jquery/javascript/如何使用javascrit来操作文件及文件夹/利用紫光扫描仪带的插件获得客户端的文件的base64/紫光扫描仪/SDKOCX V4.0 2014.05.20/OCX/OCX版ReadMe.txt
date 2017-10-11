使用前需要先注册SDKOCX2.0.ocx，方法是：“WIN+R”快捷键打开“运行”框，在“打开”栏内输入“regsvr32 ”,拖动SDKOCX2.0.ocx到“打开”框内，会自动显示文件所在路径，按“ENTER”键完成注册。

1.   LoadDll()
加载要封装的dll文件
返回值：
  1 ：成功
  0： 失败

2.long SelectScanner(CHAR* pSourceName)
说明：选择扫描仪；本函数未执行前，程序会以系统默认扫描仪做为使用对象；
返回值：BOOL 型，1 代表成功；
参数[in]：字符串型，保留定义，推荐用空字符串；

可通过传递设备型号名称，设置默认的扫描仪设备
例：SelectScanner("Uniscan B6800");
    SelectScanner("Uniscan F25A");
注：手动设置需要在EnConnect（）函数调用前，运行SelectScanner("...");，其中...为需要设置的设备型号名称。可通过MFCDEMOforSDK.exe查看需要输入的字符串，选择设备后，在对话框中显示的即为需要传入的字符串。

3.long EnConnect(LONG iValue)
说明：连接到扫描仪，与disconnect 配合使用，请确保执行scan 函数前本函数已执行；
返回值：BOOL 型，0 代表失败；1 代表成功；
参数[in]：字符串型，用于传递窗口句柄给SDK 程序使用；

4.long DisConnect()
说明：连接到扫描仪，与EnConnect 配合使用；
返回值：BOOL 型，0 代表失败；1 代表成功；

5.long SetScanner(LONG ImageIndex, LONG FileType, LONG nParam1, LONG nParam2, FLOAT Param3)
说明：设置扫描部分参数
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

6.LONG StartScanner(LPCTSTR path, LPCTSTR filename);
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

7.long SetScannerSource(LONG Sourece)
说明：设置扫描源；
返回值：BOOL 型，0 代表失败；
参数[in]：long型，默认为0，ADF扫描仪建议设置为1，双面ADF为2;

8.long SetScannerContrast(LONG Contrast)
说明：设置扫描对比度；黑白模式时失效
返回值：BOOL 型，0 代表失败;
参数[in]：long型，取值范围是-1000~1000;

9.long SetScannerBright(LONG Bright)
说明：设置扫描亮度；黑白模式时失效
返回值：BOOL 型，0 代表失败;
参数[in]：long型，取值范围是-1000~1000;

10.long SetThreshold(LONG Threshold)
说明：设置扫描阈值，只在黑白扫描模式(二值模式)时起作用;
返回值：BOOL 型，0 代表失败;
参数[in]：long型，取值范围是1~255;

11.long SetScannerImageType(LONG ScannerImageType)
说明：设置扫描类型;
返回值：BOOL 型，0 代表失败;
参数[in]：long型
-0为黑白模式
-1为灰度模式
-2为彩色模式
-3为出界面扫描

12.long SetScannerDPI(LONG ScanDPI)
说明：设置扫描DPI;
返回值：BOOL 型，0 代表失败;
参数[in]：long型，取值范围100dpi~4800dpi;

13.SetScannerScanRgn(LONG Left, LONG Top, LONG Right, LONG Bottom)
说明：设置扫描区域，单位：毫米；取值范围：420mm×600mm（A4 幅面为210×300）
矩形范围由左上点位置和右下点位置决定;
返回值：BOOL 型，0 代表失败;
参数[in]：long型
Left:左上点横坐标(扫描左边际)
Top:左上点纵坐标(扫描上边际)
Right:右下点点横坐标(扫描右边际)
Bottom:右下点纵坐标(扫描下边际)

14.long  GetDsName(CHAR* DSName)
说明：获得扫描设备(Data Source,DS)名称;
返回值：BOOL 型，0 代表失败;
参数[out]：char*型，获得的设备名称保存地址将保存在DSName中;

15.long  SetScanInvert(LONG bInvert)
说明：设置取反色；本函数未执行前，默认为不取反色；
返回值：BOOL 型，0 代表失败；
参数[in]：BOOL型，是否取反色扫描，1为进行，0为不进行；


16.LONG PostFile(LPCTSTR strURL, LPCTSTR strFileName, LPCTSTR strRecord, BSTR FAR* strResponse)

	说明：将本地文件通过Post方式上传至服务器；

	参数：	
		strURL：	上传的服务器网页地址；
		strFileName：	需要上传的本地文件名，应该为文件的名称，需要填写完整的绝对路径，比如"c:\image.jpg";
		strRecord：	封装Form里的第一个记录内容；
		strResponse：	Post的返回Response内容；
	
	返回值：BOOL型，0代表失败，1成功;

	
	Form结构：
		字段一：FileID，  内容：strRecord;
		字段二：Filedata，内容：文件名;
		字段三：二进制内容，文件的二进制流;


function PostFile()
{
  var strFileName = "c:\\image0000.pdf";
  var strURL= "http://.../xxx.jsp";
  var strRecord = "FileName";
  var strResponse;
  var re = DOcxtest1.PostFile(strURL, strFileName, strRecord, strResponse);
}

17.BSTR GetFileName(void)
说明：返回生成图像名
返回值：BSTR型，字符串类型

18.BSTR GetFullFileName(void)
说明：返回完整的图像路径及图像名
返回值：BSTR型，字符串类型	

19.BSTR FileToBase64(LPCTSTR filePath)
	用于获得对应文件的base64编码流
	参数：	 filePath 需求获得base64流的文件名，为客户端本地文件(当此扫描的文件),请填写有效路径及全文件名；
	返回值： Base64流，为空时表示转化失败；

20.long SetOCXSize(long nWidth, long nHeight)
	设定ActiveX窗体大小
	参数：	nWidth  窗体的宽
		nHeight 窗体的高

21.long SetCoverFile(long bCover)
说明：设置是否覆盖同名文件；本函数未执行前，默认为不覆盖；
返回值：BOOL 型，1代表正常，0 代表失败；
参数[in]：BOOL型，是否覆盖同名文件，1为覆盖，0为不覆盖；

22.long RotateImage(LPCTSTR strFileName,float RotateAngle)
说明：旋转图像
返回值：BOOL 型，1代表正常，0 代表失败；
参数[in]：
strFileName 需要旋转的图像的全路径；
RotateImage 旋转角度（顺时针旋转）。

23.long GetImageNumber()
说明：返回已扫描页数
返回值：long型，数值为已扫描的页数，0代表失败；
参数：无










