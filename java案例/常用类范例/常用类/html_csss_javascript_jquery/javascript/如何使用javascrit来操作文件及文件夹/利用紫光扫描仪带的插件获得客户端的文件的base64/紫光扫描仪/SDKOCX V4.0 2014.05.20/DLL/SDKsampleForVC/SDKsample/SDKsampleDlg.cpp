
// SDKsampleDlg.cpp : 实现文件
//

#include "stdafx.h"
#include "SDKsample.h"
#include "SDKsampleDlg.h"
#include "afxdialogex.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// 用于应用程序“关于”菜单项的 CAboutDlg 对话框

class CAboutDlg : public CDialogEx
{
public:
	CAboutDlg();

// 对话框数据
	enum { IDD = IDD_ABOUTBOX };

	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV 支持

// 实现
protected:
	DECLARE_MESSAGE_MAP()
};

CAboutDlg::CAboutDlg() : CDialogEx(CAboutDlg::IDD)
{
}

void CAboutDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialogEx::DoDataExchange(pDX);
}

BEGIN_MESSAGE_MAP(CAboutDlg, CDialogEx)
END_MESSAGE_MAP()


// CSDKsampleDlg 对话框




CSDKsampleDlg::CSDKsampleDlg(CWnd* pParent /*=NULL*/)
	: CDialogEx(CSDKsampleDlg::IDD, pParent)
{
	m_hIcon = AfxGetApp()->LoadIcon(IDR_MAINFRAME);
	m_h32Dll = NULL;
	m_pSelect = NULL;
	m_pGetDSName = NULL;
	m_pScan = NULL;
	m_pEnConnect = NULL;
	m_pEnDisConnect = NULL;
	m_pSetScannerContrast = NULL;
	m_pSetScannerBright = NULL;
	m_pSetThreshold = NULL;
	m_pSetScannerImageType = NULL;
	m_pSetScannerDPI = NULL;
	m_pSetScannerScanRgn = NULL;
	m_pSetScannerSource = NULL;
	m_pGetImageNumber = NULL;
	m_pSetScanAutoCrop = NULL;
	m_Device = _T("Default scanner");
	m_contrast = 0;
	m_bright = 0;
	m_nScanType = 0;
	m_nDpi = 200;
	m_nLeft = 0;
	m_nRight = 210;
	m_nTop = 0;
	m_nBottom = 297;
	m_nImageStyle = 0;
	m_nSupportSource = 0;
	m_nThreshold = 0;
}

void CSDKsampleDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialogEx::DoDataExchange(pDX);
	DDX_Control(pDX, IDC_BUTTON_SELECT, m_btSelcct);
	DDX_Text(pDX, IDC_EDIT_DEVICE, m_Device);
	DDX_Control(pDX, IDC_BUTTON_SCAN, m_btScan);
	DDX_Text(pDX, IDC_EDIT_CONTRAST, m_contrast);
	DDV_MinMaxLong(pDX, m_contrast, -50, 100);
	DDX_Text(pDX, IDC_EDIT_BRIGHT, m_bright);
	DDV_MinMaxLong(pDX, m_bright, -150, 150);
	DDX_Radio(pDX, IDC_RADIO_BW, m_nScanType);
	DDV_MinMaxInt(pDX, m_nScanType, 0, 3);
	DDX_Text(pDX, IDC_EDIT_DPI, m_nDpi);
	DDV_MinMaxLong(pDX, m_nDpi, 0, 2400);
	DDX_Text(pDX, IDC_EDIT_LEFT, m_nLeft);
	DDV_MinMaxLong(pDX, m_nLeft, 0, 420);
	DDX_Text(pDX, IDC_EDIT_RIGHT, m_nRight);
	DDV_MinMaxLong(pDX, m_nRight, 1, 420);
	DDX_Text(pDX, IDC_EDIT_TOP, m_nTop);
	DDV_MinMaxLong(pDX, m_nTop, 0, 600);
	DDX_Text(pDX, IDC_EDIT_BOTTOM, m_nBottom);
	DDV_MinMaxLong(pDX, m_nBottom, 1, 600);
	DDX_Radio(pDX, IDC_RADIO1, m_nImageStyle);
	DDV_MinMaxInt(pDX, m_nImageStyle, 0, 8);
	DDX_Check(pDX, IDC_CHECK_MULPAGE, m_nMulPage);
	DDX_Radio(pDX, IDC_RADIO_SCANSOURCE, m_nSupportSource);
	DDV_MinMaxInt(pDX, m_nSupportSource, 0, 3);
	DDX_Control(pDX, IDC_CHECK_MULPAGE, m_btMulPage);
	DDX_Text(pDX, IDC_EDIT_THRESHOLD, m_nThreshold);
	DDV_MinMaxLong(pDX, m_nThreshold, 0, 255);
}

BEGIN_MESSAGE_MAP(CSDKsampleDlg, CDialogEx)
	ON_WM_SYSCOMMAND()
	ON_WM_PAINT()
	ON_WM_QUERYDRAGICON()
	ON_BN_CLICKED(IDC_BUTTON_SELECT, &CSDKsampleDlg::OnBnClickedButtonSelect)
	ON_BN_CLICKED(IDC_BUTTON_SCAN, &CSDKsampleDlg::OnBnClickedButtonScan)
	ON_BN_CLICKED(IDC_RADIO1, &CSDKsampleDlg::OnBnClickedRadio1)
	ON_BN_CLICKED(IDC_RADIO2, &CSDKsampleDlg::OnBnClickedRadio2)
	ON_BN_CLICKED(IDC_RADIO3, &CSDKsampleDlg::OnBnClickedRadio3)
	ON_BN_CLICKED(IDC_RADIO4, &CSDKsampleDlg::OnBnClickedRadio4)
	ON_BN_CLICKED(IDC_RADIO5, &CSDKsampleDlg::OnBnClickedRadio5)
	ON_BN_CLICKED(IDC_RADIO9, &CSDKsampleDlg::OnBnClickedRadio9)
END_MESSAGE_MAP()


// CSDKsampleDlg 消息处理程序

BOOL CSDKsampleDlg::OnInitDialog()
{
	CDialogEx::OnInitDialog();

	// 将“关于...”菜单项添加到系统菜单中。

	// IDM_ABOUTBOX 必须在系统命令范围内。
	ASSERT((IDM_ABOUTBOX & 0xFFF0) == IDM_ABOUTBOX);
	ASSERT(IDM_ABOUTBOX < 0xF000);

	CMenu* pSysMenu = GetSystemMenu(FALSE);
	if (pSysMenu != NULL)
	{
		BOOL bNameValid;
		CString strAboutMenu;
		bNameValid = strAboutMenu.LoadString(IDS_ABOUTBOX);
		ASSERT(bNameValid);
		if (!strAboutMenu.IsEmpty())
		{
			pSysMenu->AppendMenu(MF_SEPARATOR);
			pSysMenu->AppendMenu(MF_STRING, IDM_ABOUTBOX, strAboutMenu);
		}
	}

	// 设置此对话框的图标。当应用程序主窗口不是对话框时，框架将自动
	//  执行此操作
	SetIcon(m_hIcon, TRUE);			// 设置大图标
	SetIcon(m_hIcon, FALSE);		// 设置小图标

	// TODO: 在此添加额外的初始化代码
	m_btMulPage.EnableWindow(false);
	if (!InitDLL())
	{
		return FALSE;
	}

	return TRUE;  // 除非将焦点设置到控件，否则返回 TRUE
}

BOOL CSDKsampleDlg::InitDLL()
{
	TCHAR   sDrive[_MAX_DRIVE]; 
	TCHAR   sDir[_MAX_DIR]; 
	TCHAR   sFilename[_MAX_FNAME], Filename[_MAX_FNAME]; 
	TCHAR   sExt[_MAX_EXT]; 
	int nLen = GetModuleFileName(AfxGetInstanceHandle(), Filename, _MAX_PATH);
	if (nLen < 3)
		return false;

	_tsplitpath(Filename,   sDrive,   sDir,   sFilename,   sExt);
	CString   homeDir(CString(sDrive) + CString(sDir)); 
	nLen = homeDir.GetLength();
	if (nLen < 3)
		return false;

	if (homeDir.GetAt(nLen-1) != _T('\\')) 
		homeDir += _T('\\'); 
	CString FilePath = homeDir + "UnisSDK.dll";
 	m_h32Dll = AfxLoadLibrary(FilePath);
 	if (m_h32Dll != NULL)
	{
		m_pSelect = (SELECTSCANNER)GetProcAddress(m_h32Dll, "SelectScanner");
		m_pGetDSName = (GETDSNAME)GetProcAddress(m_h32Dll, "GetDsName");
		m_pScan = (SCAN)GetProcAddress(m_h32Dll, "Scan");
		m_pEnConnect = (ENCONNECT)GetProcAddress(m_h32Dll, "EnConnect");
		m_pEnDisConnect = (ENDISCONNECT)GetProcAddress(m_h32Dll, "EnDisConnect");
		m_pSetScannerContrast = (SETSCANNERCONTRAST)GetProcAddress(m_h32Dll, "SetScannerContrast");
		m_pSetScannerBright = (SETSCANNERBRIGHT)GetProcAddress(m_h32Dll, "SetScannerBright");
		m_pSetThreshold= (SETTHRESHOLD)GetProcAddress(m_h32Dll, "SetThreshold");
		m_pSetScannerImageType= (SETSCANNERIMAGETYPE)GetProcAddress(m_h32Dll, "SetScannerImageType");
		m_pSetScannerDPI= (SETSCANNERDPI)GetProcAddress(m_h32Dll, "SetScannerDPI");
		m_pSetScannerScanRgn = (SETSCANNERSCANRGN)GetProcAddress(m_h32Dll, "SetScannerScanRgn");
		m_pSetScannerSource = (SETSCANNERSOURCE)GetProcAddress(m_h32Dll, "SetScannerSource");
		m_pGetImageNumber = (GETIMAGENUMBER)GetProcAddress(m_h32Dll,"GetImageNumber");
		m_pSetScanAutoCrop = (SETSCANAUTOCROP)GetProcAddress(m_h32Dll,"SetScanAutoCrop");
		if ( m_pSelect == NULL || m_pScan == NULL || m_pGetDSName == NULL || m_pEnConnect == NULL ||
			m_pEnDisConnect == NULL || m_pSetScannerContrast == NULL || m_pSetScannerBright == NULL ||
			m_pSetThreshold == NULL || m_pSetScannerImageType == NULL || m_pSetScannerDPI == NULL || m_pSetScanAutoCrop == NULL
			|| m_pSetScannerScanRgn == NULL || m_pSetScannerSource == NULL || m_pGetImageNumber == NULL) 
		{
			AfxFreeLibrary(m_h32Dll);
			m_h32Dll = NULL;
			return false;
		}	
	}
	else
		return false;
	return true;
}
void CSDKsampleDlg::OnSysCommand(UINT nID, LPARAM lParam)
{
	if ((nID & 0xFFF0) == IDM_ABOUTBOX)
	{
		CAboutDlg dlgAbout;
		dlgAbout.DoModal();
	}
	else
	{
		CDialogEx::OnSysCommand(nID, lParam);
	}
}

// 如果向对话框添加最小化按钮，则需要下面的代码
//  来绘制该图标。对于使用文档/视图模型的 MFC 应用程序，
//  这将由框架自动完成。

void CSDKsampleDlg::OnPaint()
{
	if (IsIconic())
	{
		CPaintDC dc(this); // 用于绘制的设备上下文

		SendMessage(WM_ICONERASEBKGND, reinterpret_cast<WPARAM>(dc.GetSafeHdc()), 0);

		// 使图标在工作区矩形中居中
		int cxIcon = GetSystemMetrics(SM_CXICON);
		int cyIcon = GetSystemMetrics(SM_CYICON);
		CRect rect;
		GetClientRect(&rect);
		int x = (rect.Width() - cxIcon + 1) / 2;
		int y = (rect.Height() - cyIcon + 1) / 2;

		// 绘制图标
		dc.DrawIcon(x, y, m_hIcon);
	}
	else
	{
		CDialogEx::OnPaint();
	}
}

//当用户拖动最小化窗口时系统调用此函数取得光标
//显示。
HCURSOR CSDKsampleDlg::OnQueryDragIcon()
{
	return static_cast<HCURSOR>(m_hIcon);
}



void CSDKsampleDlg::OnBnClickedButtonSelect()
{
	if (m_pSelect == NULL || m_pGetDSName == NULL) 
		return;
	
	if (m_pSelect(""))
	{
		char pBuf[256];
		m_pGetDSName(pBuf);
		m_Device = pBuf;
		SetDlgItemText(IDC_EDIT_DEVICE, m_Device);
	}

	// TODO: 在此添加控件通知处理程序代码
}


void CSDKsampleDlg::OnBnClickedButtonScan()
{
	if (m_pEnConnect == NULL || m_pScan == NULL || m_pEnDisConnect == NULL) 
		return;
	if (!UpdateData(true))
		return;
	if (!m_pEnConnect(long("SDK program")))
	{
	//	AfxMessageBox("Scan Fail!");
		return;
	}
	m_pSetScannerContrast (m_contrast);
	m_pSetScannerBright (m_bright);
	m_pSetScannerImageType (m_nScanType);
	m_pSetScannerDPI(m_nDpi);
	m_pSetThreshold(m_nThreshold);
	m_pSetScannerScanRgn(m_nLeft,m_nTop,m_nRight,m_nBottom);
	long source = (long)m_nSupportSource;
	m_pSetScannerSource(source);
//	m_pSetScanAutoCrop(TRUE);

	int re = m_pScan("c:\\", "image", 0,m_nImageStyle,70,m_nMulPage, 0);

	int Page = m_pGetImageNumber();

	m_pEnDisConnect();
	if (re < 0)
	{
		MessageBox(LPCTSTR("Scan Fail!"));
	}
	// TODO: 在此添加控件通知处理程序代码
}



void CSDKsampleDlg::OnBnClickedRadio1()
{
	// TODO: 在此添加控件通知处理程序代码
	m_btMulPage.EnableWindow(false);
}


void CSDKsampleDlg::OnBnClickedRadio2()
{
	// TODO: 在此添加控件通知处理程序代码
	m_btMulPage.EnableWindow(true);
}



void CSDKsampleDlg::OnBnClickedRadio3()
{
	// TODO: 在此添加控件通知处理程序代码
	m_btMulPage.EnableWindow(false);
}


void CSDKsampleDlg::OnBnClickedRadio4()
{
	// TODO: 在此添加控件通知处理程序代码
	m_btMulPage.EnableWindow(false);
}


void CSDKsampleDlg::OnBnClickedRadio5()
{
	// TODO: 在此添加控件通知处理程序代码
	m_btMulPage.EnableWindow(true);
}


void CSDKsampleDlg::OnBnClickedRadio9()
{
	// TODO: 在此添加控件通知处理程序代码
	m_btMulPage.EnableWindow(false);
}
