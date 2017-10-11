
// MFCDEMOforSDKDlg.cpp : 实现文件
//

#include "stdafx.h"
#include "MFCDEMOforSDK.h"
#include "MFCDEMOforSDKDlg.h"
#include "afxdialogex.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// CMFCDEMOforSDKDlg 对话框




CMFCDEMOforSDKDlg::CMFCDEMOforSDKDlg(CWnd* pParent /*=NULL*/)
	: CDialogEx(CMFCDEMOforSDKDlg::IDD, pParent)
	, m_mode(2)
	, m_TYPE(2)
	, m_ValueMulti(FALSE)
	, m_brightness(0)
	, m_contrast(0)
	, m_threshold(0)
	, m_compress(0)
	, m_dpi(200)
	, m_checkADF(FALSE)
	, m_checkDuplex(FALSE)
	, m_checkInvert(FALSE)
	, m_sx(0)
	, m_sy(0)
	, m_ex(210)
	, m_ey(297)
	, m_filename(_T("image"))
	, m_index(0)
	, m_path(_T("C:\\"))
	, m_sourceName(_T(""))
{
	m_hIcon = AfxGetApp()->LoadIcon(IDR_MAINFRAME);
	m_sy = 0;
}

void CMFCDEMOforSDKDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialogEx::DoDataExchange(pDX);
	DDX_Radio(pDX, IDC_BW, m_mode);
	DDX_Radio(pDX, IDC_BMP, m_TYPE);
	DDX_Control(pDX, IDC_MULTIPAGE, m_controlMulti);
	DDX_Check(pDX, IDC_MULTIPAGE, m_ValueMulti);
	DDX_Text(pDX, IDC_EDITBrightness, m_brightness);
	DDV_MinMaxLong(pDX, m_brightness, -1000, 1000);
	DDX_Control(pDX, IDC_SLIDERBrightness, m_sliderBrightness);
	DDX_Control(pDX, IDC_SLIDERContrast, m_sliderContrast);
	DDX_Control(pDX, IDC_SLIDERThreshold, m_sliderThreshold);
	DDX_Control(pDX, IDC_SLIDERCompress, m_sliderCompress);
	DDX_Text(pDX, IDC_EDITContrast, m_contrast);
	DDX_Text(pDX, IDC_EDITThreshold, m_threshold);
	DDX_Text(pDX, IDC_EDITCompress, m_compress);
	DDX_Text(pDX, IDC_EDITDPI, m_dpi);
	DDV_MinMaxInt(pDX, m_dpi, 100, 4800);
	DDX_Control(pDX, IDC_COMBODPI, m_comboDpi);
	DDX_Check(pDX, IDC_CHECKADF, m_checkADF);
	DDX_Control(pDX, IDC_CHECKDUPLEX, m_ControlDuplex);
	DDX_Check(pDX, IDC_CHECKDUPLEX, m_checkDuplex);
	DDX_Check(pDX, IDC_CHECKINVERT, m_checkInvert);
	DDX_Text(pDX, IDC_EDIT5, m_sx);
	//  DDX_Text(pDX, IDC_EDIT6, m_sy);
	DDX_Text(pDX, IDC_EDIT6, m_sy);
	DDX_Text(pDX, IDC_EDIT7, m_ex);
	DDX_Text(pDX, IDC_EDIT8, m_ey);
	DDX_Text(pDX, IDC_EDIT2, m_filename);
	DDX_Text(pDX, IDC_EDIT3, m_index);
	DDX_Text(pDX, IDC_EDIT1, m_path);
	DDX_Text(pDX, IDC_SOURCENAME, m_sourceName);
	DDX_Control(pDX, IDC_LOGO, m_controlLogo);
	DDX_Control(pDX, IDC_SDKOCX20CTRL1, m_sdkocx);
}

BEGIN_MESSAGE_MAP(CMFCDEMOforSDKDlg, CDialogEx)
	ON_WM_PAINT()
	ON_WM_QUERYDRAGICON()
	ON_BN_CLICKED(IDC_BROWSE, &CMFCDEMOforSDKDlg::OnBnClickedBrowse)
	ON_BN_CLICKED(IDC_BMP, &CMFCDEMOforSDKDlg::OnBnClickedBmp)
	ON_BN_CLICKED(IDC_TIF, &CMFCDEMOforSDKDlg::OnBnClickedTif)
	ON_BN_CLICKED(IDC_PDF, &CMFCDEMOforSDKDlg::OnBnClickedPdf)
	ON_BN_CLICKED(IDC_PNG, &CMFCDEMOforSDKDlg::OnBnClickedPng)
	ON_BN_CLICKED(IDC_GIF, &CMFCDEMOforSDKDlg::OnBnClickedGif)
	ON_BN_CLICKED(IDC_JPG, &CMFCDEMOforSDKDlg::OnBnClickedJpg)
	ON_BN_CLICKED(IDC_BW, &CMFCDEMOforSDKDlg::OnBnClickedBw)
	ON_BN_CLICKED(IDC_GL, &CMFCDEMOforSDKDlg::OnBnClickedGl)
	ON_BN_CLICKED(IDC_COLOR, &CMFCDEMOforSDKDlg::OnBnClickedColor)
	ON_BN_CLICKED(IDC_SHOWUI, &CMFCDEMOforSDKDlg::OnBnClickedShowui)
	ON_BN_CLICKED(IDC_SELECT, &CMFCDEMOforSDKDlg::OnBnClickedSelect)
	ON_WM_HSCROLL()
	ON_CBN_SELCHANGE(IDC_COMBODPI, &CMFCDEMOforSDKDlg::OnCbnSelchangeCombodpi)
	ON_BN_CLICKED(IDC_CHECKADF, &CMFCDEMOforSDKDlg::OnBnClickedCheckadf)
	ON_BN_CLICKED(IDC_BUTTONSCAN, &CMFCDEMOforSDKDlg::OnBnClickedButtonscan)
END_MESSAGE_MAP()


// CMFCDEMOforSDKDlg 消息处理程序

BOOL CMFCDEMOforSDKDlg::OnInitDialog()
{
	CDialogEx::OnInitDialog();

	// 设置此对话框的图标。当应用程序主窗口不是对话框时，框架将自动
	//  执行此操作
	SetIcon(m_hIcon, TRUE);			// 设置大图标
	SetIcon(m_hIcon, FALSE);		// 设置小图标

	ShowWindow(SW_SHOW);

	// TODO: 在此添加额外的初始化代码

	this->m_mode=0;
	this->m_controlMulti.EnableWindow(false);
	this->m_sliderBrightness.SetRange(-1000,1000);//设置滑动范围
	this->m_sliderContrast.SetRange(-1000,1000);//设置滑动范围
	m_sliderContrast.SetPos(0);
	this->m_sliderThreshold.SetRange(1,255);//设置滑动范围
	m_sliderThreshold.SetPos(128);
	this->m_sliderCompress.SetRange(1,100);//设置滑动范围
	m_sliderCompress.SetPos(75);
	 m_sliderBrightness.SetTicFreq(100);//每10个单位画一刻度
	  m_sliderContrast.SetTicFreq(100);
	CString temp;
	temp="100";
	m_comboDpi.AddString(temp);
	temp="150";
	m_comboDpi.AddString(temp);
	temp="200";
	m_comboDpi.AddString(temp);
	temp="300";
	m_comboDpi.AddString(temp);
	temp="600";
	m_comboDpi.AddString(temp);
	temp="1200";
	m_comboDpi.AddString(temp);
	temp="2400";
	m_comboDpi.AddString(temp);
	m_comboDpi.SetCurSel(0);
	m_brightness=m_sliderBrightness.GetPos();
	m_contrast=m_sliderContrast.GetPos();
	m_threshold=m_sliderThreshold.GetPos();
	m_compress=m_sliderCompress.GetPos();
	CString s;
	m_comboDpi.GetWindowTextA(s);
	m_dpi=_ttoi(s);
	m_ControlDuplex.EnableWindow(false);
	//m_controlLogo.ShowWindow(true);
	UpdateData(false);
	return TRUE;  // 除非将焦点设置到控件，否则返回 TRUE
}

// 如果向对话框添加最小化按钮，则需要下面的代码
//  来绘制该图标。对于使用文档/视图模型的 MFC 应用程序，
//  这将由框架自动完成。

void CMFCDEMOforSDKDlg::OnPaint()
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
HCURSOR CMFCDEMOforSDKDlg::OnQueryDragIcon()
{
	return static_cast<HCURSOR>(m_hIcon);
}



//void CMFCDEMOforSDKDlg::OnBnHotItemChangeBmp(NMHDR *pNMHDR, LRESULT *pResult)
//{
//	// 此功能要求 Internet Explorer 6 或更高版本。
//	// 符号 _WIN32_IE 必须是 >= 0x0600。
//	LPNMBCHOTITEM pHotItem = reinterpret_cast<LPNMBCHOTITEM>(pNMHDR);
//	// TODO: 在此添加控件通知处理程序代码
//	*pResult = 0;
//	MessageBox(L"lalalal");
//}


void CMFCDEMOforSDKDlg::OnBnClickedBrowse()
{
	CFolderPickerDialog *filedlg=new CFolderPickerDialog();
	// TODO: 在此添加控件通知处理程序代码
	if(filedlg->DoModal()==IDOK)
	{
		m_path=filedlg->GetFolderPath();
		//MessageBox(m_path);
		UpdateData(false);
	}
}


void CMFCDEMOforSDKDlg::OnBnClickedBmp()
{
	// TODO: 在此添加控件通知处理程序代码
	this->m_ValueMulti=false;

	this->m_controlMulti.EnableWindow(false);
	this->m_TYPE=0;
	UpdateData(false);
}


void CMFCDEMOforSDKDlg::OnBnClickedTif()
{
	// TODO: 在此添加控件通知处理程序代码
	this->m_controlMulti.EnableWindow(true);
	this->m_TYPE=1;
}


void CMFCDEMOforSDKDlg::OnBnClickedPdf()
{
	// TODO: 在此添加控件通知处理程序代码
	this->m_controlMulti.EnableWindow(true);
	this->m_TYPE=4;
}


void CMFCDEMOforSDKDlg::OnBnClickedPng()
{
	// TODO: 在此添加控件通知处理程序代码
	this->m_ValueMulti=false;
	
	this->m_controlMulti.EnableWindow(false);
	this->m_TYPE=5;
	UpdateData(false);
}


void CMFCDEMOforSDKDlg::OnBnClickedGif()
{
	// TODO: 在此添加控件通知处理程序代码
	this->m_ValueMulti=false;
	
	this->m_controlMulti.EnableWindow(false);
	this->m_TYPE=3;
	UpdateData(false);
}


void CMFCDEMOforSDKDlg::OnBnClickedJpg()
{
	// TODO: 在此添加控件通知处理程序代码
	this->m_ValueMulti=false;

	this->m_controlMulti.EnableWindow(false);
	this->m_TYPE=2;
	UpdateData(false);
}


void CMFCDEMOforSDKDlg::OnBnClickedBw()
{
	// TODO: 在此添加控件通知处理程序代码
	this->m_mode=0;
}


void CMFCDEMOforSDKDlg::OnBnClickedGl()
{
	// TODO: 在此添加控件通知处理程序代码
		this->m_mode=1;
}


void CMFCDEMOforSDKDlg::OnBnClickedColor()
{
	// TODO: 在此添加控件通知处理程序代码
		this->m_mode=2;
}


void CMFCDEMOforSDKDlg::OnBnClickedShowui()
{
	// TODO: 在此添加控件通知处理程序代码
		this->m_mode=3;
}


void CMFCDEMOforSDKDlg::OnBnClickedSelect()
{
	if(!m_sdkocx.LoadDll())
	{
		MessageBox("dll加载错误");
		return;
	}
	//CString blank="";
	//char kk[256];
	//strcpy(kk,blank);
	//signed char* param=(signed char*)kk;
	if ((m_sdkocx.SelectScanner("")>0))
	{
		char pBuf[256];
		m_sdkocx.GetDsName(pBuf);
		m_sourceName = pBuf;
		UpdateData(false);
	}
	// TODO: 在此添加控件通知处理程序代码
}


void CMFCDEMOforSDKDlg::OnHScroll(UINT nSBCode, UINT nPos, CScrollBar* pScrollBar)
{
	// TODO: 在此添加消息处理程序代码和/或调用默认值
	m_brightness=m_sliderBrightness.GetPos();
	m_contrast=m_sliderContrast.GetPos();
	m_threshold=m_sliderThreshold.GetPos();
	m_compress=m_sliderCompress.GetPos();
	UpdateData(false);
	CDialogEx::OnHScroll(nSBCode, nPos, pScrollBar);
}


void CMFCDEMOforSDKDlg::OnCbnSelchangeCombodpi()
{
	// TODO: 在此添加控件通知处理程序代码
	CString s;
	m_comboDpi.GetWindowTextA(s);
	m_dpi=_ttoi(s);
	UpdateData(false);
}


void CMFCDEMOforSDKDlg::OnBnClickedCheckadf()
{
	// TODO: 在此添加控件通知处理程序代码
	UpdateData(true);
	if(m_checkADF==true)
	{
		m_ControlDuplex.EnableWindow(true);
	}
	else
	{
		this->m_checkDuplex=false;
		m_ControlDuplex.EnableWindow(false);		
	}
	UpdateData(false);
}


void CMFCDEMOforSDKDlg::OnBnClickedButtonscan()
{
	//HWND hWnd = AfxGetMainWnd()->m_hWnd;
	UpdateData(true);
	if (m_sdkocx.EnConnect((long)(AfxGetMainWnd()->m_hWnd))<=0)
	{
		MessageBox("Scan Fail1!");
        return;
    } 
	if (this->m_checkADF == true)
	{
		int t;
		if (this->m_checkDuplex == true)
		{
			t=m_sdkocx.SetScannerSource(2);
		}
		else
			t=m_sdkocx.SetScannerSource(1);
	}
	int re[9];
	re[0]=m_sdkocx.SetScannerImageType(this->m_mode);
	re[1]=m_sdkocx.SetThreshold(this->m_threshold);
	//re[1]=1;
	re[2]=m_sdkocx.SetScannerBright(this->m_brightness);
	re[3]=m_sdkocx.SetScannerContrast(this->m_contrast);
	re[4]=m_sdkocx.SetScannerDPI(this->m_dpi);
	re[5]=1;
	//re[5]=m_sdkocx.SetScannerScanRgn(m_sx,m_sy,m_ex,m_ey);
	re[6]=m_sdkocx.SetScanInvert(this->m_checkInvert);
	for(int i=0;i<7;i++)
	{
		if(re[i]<=0)
		{
			MessageBox("参数设置错误");
			return;
		}
	}
	if(m_sdkocx.SetScanner(m_index,m_TYPE,m_compress,m_ValueMulti,0))
	{
		//char *p;
		//char *n;
		//strcpy(p,this->m_path);
		//strcpy(n,this->m_filename);
		if(m_sdkocx.StartScanner(m_path,m_filename)<=0)
		{
			MessageBox("扫描失败");
		}
	}
	m_sdkocx.DisConnect();
	// TODO: 在此添加控件通知处理程序代码
}
