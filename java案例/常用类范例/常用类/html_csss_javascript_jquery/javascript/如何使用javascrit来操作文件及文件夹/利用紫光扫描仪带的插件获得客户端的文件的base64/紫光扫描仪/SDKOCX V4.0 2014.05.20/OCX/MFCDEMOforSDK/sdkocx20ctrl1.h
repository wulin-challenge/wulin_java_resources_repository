#pragma once

// 计算机生成了由 Microsoft Visual C++ 创建的 IDispatch 包装类

// 注意: 不要修改此文件的内容。如果此类由
//  Microsoft Visual C++ 重新生成，您的修改将被覆盖。

/////////////////////////////////////////////////////////////////////////////
// CSdkocx20ctrl1 包装类

class CSdkocx20ctrl1 : public CWnd
{
protected:
	DECLARE_DYNCREATE(CSdkocx20ctrl1)
public:
	CLSID const& GetClsid()
	{
		static CLSID const clsid
			= { 0x677C2EAE, 0x57E, 0x4900, { 0x97, 0xED, 0x15, 0x20, 0xF0, 0x80, 0x94, 0x2D } };
		return clsid;
	}
	virtual BOOL Create(LPCTSTR lpszClassName, LPCTSTR lpszWindowName, DWORD dwStyle,
						const RECT& rect, CWnd* pParentWnd, UINT nID, 
						CCreateContext* pContext = NULL)
	{ 
		return CreateControl(GetClsid(), lpszWindowName, dwStyle, rect, pParentWnd, nID); 
	}

    BOOL Create(LPCTSTR lpszWindowName, DWORD dwStyle, const RECT& rect, CWnd* pParentWnd, 
				UINT nID, CFile* pPersist = NULL, BOOL bStorage = FALSE,
				BSTR bstrLicKey = NULL)
	{ 
		return CreateControl(GetClsid(), lpszWindowName, dwStyle, rect, pParentWnd, nID,
		pPersist, bStorage, bstrLicKey); 
	}

// 特性
public:


// 操作
public:

// _DSDKOCX20

// Functions
//

	void AboutBox()
	{
		InvokeHelper(DISPID_ABOUTBOX, DISPATCH_METHOD, VT_EMPTY, NULL, NULL);
	}
	long LoadDll()
	{
		long result;
		InvokeHelper(0x1, DISPATCH_METHOD, VT_I4, (void*)&result, NULL);
		return result;
	}
	long SelectScanner(char * pSourceName)
	{
		long result;
		static BYTE parms[] = VTS_BSTR ;
		InvokeHelper(0x2, DISPATCH_METHOD, VT_I4, (void*)&result, parms, pSourceName);
		return result;
	}
	long SetScanner(long ImageIndex, long FileType, long nParam1, long nParam2, float Param3)
	{
		long result;
		static BYTE parms[] = VTS_I4 VTS_I4 VTS_I4 VTS_I4 VTS_R4;
		InvokeHelper(0x3, DISPATCH_METHOD, VT_I4, (void*)&result, parms, ImageIndex, FileType, nParam1, nParam2, Param3);
		return result;
	}
	long StartScan(char * iPath, char * iFileName)
	{
		long result;
		static BYTE parms[] = VTS_BSTR VTS_BSTR ;
		InvokeHelper(0x4, DISPATCH_METHOD, VT_I4, (void*)&result, parms, iPath, iFileName);
		return result;
	}
	long EnConnect(long iValue)
	{
		long result;
		static BYTE parms[] = VTS_I4 ;
		InvokeHelper(0x5, DISPATCH_METHOD, VT_I4, (void*)&result, parms, iValue);
		return result;
	}
	long DisConnect()
	{
		long result;
		InvokeHelper(0x6, DISPATCH_METHOD, VT_I4, (void*)&result, NULL);
		return result;
	}
	long SetScannerSource(long Sourece)
	{
		long result;
		static BYTE parms[] = VTS_I4 ;
		InvokeHelper(0x7, DISPATCH_METHOD, VT_I4, (void*)&result, parms, Sourece);
		return result;
	}
	long SetScannerContrast(long Contrast)
	{
		long result;
		static BYTE parms[] = VTS_I4 ;
		InvokeHelper(0x8, DISPATCH_METHOD, VT_I4, (void*)&result, parms, Contrast);
		return result;
	}
	long SetScannerBright(long Bright)
	{
		long result;
		static BYTE parms[] = VTS_I4 ;
		InvokeHelper(0x9, DISPATCH_METHOD, VT_I4, (void*)&result, parms, Bright);
		return result;
	}
	long SetThreshold(long Threshold)
	{
		long result;
		static BYTE parms[] = VTS_I4 ;
		InvokeHelper(0xa, DISPATCH_METHOD, VT_I4, (void*)&result, parms, Threshold);
		return result;
	}
	long SetScannerImageType(long ScannerImageType)
	{
		long result;
		static BYTE parms[] = VTS_I4 ;
		InvokeHelper(0xb, DISPATCH_METHOD, VT_I4, (void*)&result, parms, ScannerImageType);
		return result;
	}
	long SetScannerDPI(long ScanDPI)
	{
		long result;
		static BYTE parms[] = VTS_I4 ;
		InvokeHelper(0xc, DISPATCH_METHOD, VT_I4, (void*)&result, parms, ScanDPI);
		return result;
	}
	long SetScannerScanRgn(long Left, long Top, long Right, long Bottom)
	{
		long result;
		static BYTE parms[] = VTS_I4 VTS_I4 VTS_I4 VTS_I4 ;
		InvokeHelper(0xd, DISPATCH_METHOD, VT_I4, (void*)&result, parms, Left, Top, Right, Bottom);
		return result;
	}
	long GetDsName(char * DSName)
	{
		long result;
		static BYTE parms[] = VTS_PI1 ;
		InvokeHelper(0xe, DISPATCH_METHOD, VT_I4, (void*)&result, parms, DSName);
		return result;
	}
	long SetScanInvert(long bInvert)
	{
		long result;
		static BYTE parms[] = VTS_I4 ;
		InvokeHelper(0xf, DISPATCH_METHOD, VT_I4, (void*)&result, parms, bInvert);
		return result;
	}
	long StartScanner(LPCTSTR path,LPCTSTR filename)
	{
		long result;
		static BYTE parms[] = VTS_BSTR VTS_BSTR ;
		InvokeHelper(0x10, DISPATCH_METHOD, VT_I4, (void*)&result, parms, path, filename);
		return result;
	}
// Properties
//
};
