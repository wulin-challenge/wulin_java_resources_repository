
// SDKsampleDlg.h : 头文件
//

#pragma once

typedef long (FAR PASCAL *SELECTSCANNER)(char *pSourceName); 
typedef long (FAR PASCAL *GETDSNAME)(char *pDsName);
typedef long (FAR PASCAL *SCAN)(char *iPath, char *iFileName, 
	              long ImageIndex, long FileType, long nParam1, long nParam2, float Param3);
typedef long (FAR PASCAL *ENCONNECT)(long iValue);
typedef long (FAR PASCAL *ENDISCONNECT)();
typedef long (FAR PASCAL *SETSCANNERCONTRAST)(long contrast);
typedef long (FAR PASCAL *SETSCANNERBRIGHT)(long bright);
typedef long (FAR PASCAL *SETTHRESHOLD)(long threshold);
typedef long (FAR PASCAL *SETSCANNERIMAGETYPE)(long ImageType);
typedef long (FAR PASCAL *SETSCANNERDPI)(long ScanDPI);
typedef long (FAR PASCAL *SETSCANNERSCANRGN)(LONG left,LONG top,LONG right,LONG bottom);
typedef long (FAR PASCAL *SETSCANNERSOURCE)(long Source);
typedef long (FAR PASCAL *GETIMAGENUMBER)();
typedef long (FAR PASCAL *SETSCANAUTOCROP)(long bAutoCrop);


// CSDKsampleDlg 对话框
class CSDKsampleDlg : public CDialogEx
{
// 构造
public:
	BOOL InitDLL();
	CSDKsampleDlg(CWnd* pParent = NULL);	// 标准构造函数
	HINSTANCE			m_h32Dll;
	SELECTSCANNER		m_pSelect;
	GETDSNAME			m_pGetDSName;
	SCAN				m_pScan;
	ENCONNECT			m_pEnConnect;
	ENDISCONNECT		m_pEnDisConnect;
	SETSCANNERCONTRAST  m_pSetScannerContrast;
	SETSCANNERBRIGHT    m_pSetScannerBright;
	SETTHRESHOLD        m_pSetThreshold;
	SETSCANNERIMAGETYPE m_pSetScannerImageType;
	SETSCANNERDPI       m_pSetScannerDPI;
	SETSCANNERSCANRGN   m_pSetScannerScanRgn;
	SETSCANNERSOURCE    m_pSetScannerSource;
	GETIMAGENUMBER		m_pGetImageNumber;
	SETSCANAUTOCROP		m_pSetScanAutoCrop;

// 对话框数据
	enum { IDD = IDD_SDKSAMPLE_DIALOG };

	protected:
	virtual void DoDataExchange(CDataExchange* pDX);	// DDX/DDV 支持


// 实现
protected:
	HICON m_hIcon;

	// 生成的消息映射函数
	virtual BOOL OnInitDialog();
	afx_msg void OnSysCommand(UINT nID, LPARAM lParam);
	afx_msg void OnPaint();
	afx_msg HCURSOR OnQueryDragIcon();
	DECLARE_MESSAGE_MAP()
public:
	CButton m_btSelcct;
	CString m_Device;
	afx_msg void OnBnClickedButtonSelect();
	CButton m_btScan;
	afx_msg void OnBnClickedButtonScan();
	long m_contrast;
	long m_bright;
	int m_nScanType;
	long m_nDpi;
	long m_nLeft;
	long m_nRight;
	long m_nTop;
	long m_nBottom;
	afx_msg void OnBnClickedRadioBmp();
	int m_nImageStyle;
	BOOL m_nMulPage;
	int m_nSupportSource;
	afx_msg void OnBnClickedRadio1();
	CButton m_btMulPage;
	afx_msg void OnBnClickedRadio2();
	afx_msg void OnBnClickedRadio3();
	afx_msg void OnBnClickedRadio4();
	afx_msg void OnBnClickedRadio5();
	afx_msg void OnBnClickedRadio9();
	long m_nThreshold;
};
