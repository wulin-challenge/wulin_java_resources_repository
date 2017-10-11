object Form1: TForm1
  Left = 0
  Top = 0
  BorderStyle = bsDialog
  Caption = #25195#25551#20202'Q300'#27979#35797
  ClientHeight = 185
  ClientWidth = 258
  Color = clBtnFace
  Font.Charset = GB2312_CHARSET
  Font.Color = clWindowText
  Font.Height = -12
  Font.Name = #23435#20307
  Font.Style = []
  OldCreateOrder = False
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 12
  object lbl1: TLabel
    Left = 8
    Top = 125
    Width = 96
    Height = 12
    Caption = #36755#20986' c:\aaa*.jpg'
  end
  object lbl2: TLabel
    Left = 8
    Top = 143
    Width = 198
    Height = 12
    Caption = #27979#35797#20195#30721#35831#21442#35265#25991#20214' FrmMainUnt.pas'
  end
  object btn1: TButton
    Left = 8
    Top = 8
    Width = 242
    Height = 25
    Caption = 'SelectScanner'
    TabOrder = 0
    OnClick = btn1Click
  end
  object btn2: TButton
    Left = 9
    Top = 70
    Width = 241
    Height = 25
    Caption = 'Scan'
    TabOrder = 1
    OnClick = btn2Click
  end
  object btnSetScannerDPI: TButton
    Left = 8
    Top = 39
    Width = 145
    Height = 25
    Caption = 'SetScannerDPI'
    TabOrder = 2
    OnClick = btnSetScannerDPIClick
  end
  object edtDPI: TEdit
    Left = 159
    Top = 41
    Width = 91
    Height = 20
    NumbersOnly = True
    TabOrder = 3
    Text = '300'
  end
end
