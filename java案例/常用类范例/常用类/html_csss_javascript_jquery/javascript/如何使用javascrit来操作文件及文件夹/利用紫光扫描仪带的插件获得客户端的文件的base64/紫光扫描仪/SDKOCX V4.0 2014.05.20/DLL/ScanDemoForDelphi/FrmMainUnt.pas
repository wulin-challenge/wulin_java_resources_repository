unit FrmMainUnt;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls;

type
  TForm1 = class(TForm)
    btn1: TButton;
    btn2: TButton;
    lbl1: TLabel;
    lbl2: TLabel;
    btnSetScannerDPI: TButton;
    edtDPI: TEdit;
    procedure btn1Click(Sender: TObject);
    procedure btn2Click(Sender: TObject);
    procedure btnSetScannerDPIClick(Sender: TObject);
  private
    FPath, FFileName: PAnsiChar;
  public
    { Public declarations }
  end;

var
  Form1: TForm1;

implementation

{$R *.dfm}

function SelectScanner(ASourceName: PAnsiChar): LONG; pascal; external 'UnisSDK.dll';//cdecl
function EnConnect(AValue: LONG): LONG; pascal; external 'UnisSDK.dll';
function EnDisConnect: LONG; pascal; external 'UnisSDK.dll';
function SetScannerDPI(AScanDPI: LONG): LONG; pascal; external 'UnisSDK.dll';
function Scan(APath, AFileName: PAnsiChar;//TArray<Byte>;
  AImageIndex, AFileType, AParam1, AParam2, AParam3: LONG): LONG; pascal;stdcall; external 'UnisSDK.dll';

procedure TForm1.btn1Click(Sender: TObject);
var
  vResult: Integer;
begin
  vResult := SelectScanner('');
  if vResult = 1 then
    ShowMessage('成功')
  else
    ShowMessage('错误返回值: ' + vResult.ToString());
end;

procedure TForm1.btn2Click(Sender: TObject);
var
  vResult: Integer;
begin
  //vResult := Scan(StrToBytes('C:\'), StrToBytes('image'), 0, 2, 70, 0, 0);

  FPath := 'c:\';
  FFileName := 'aaa';
  vResult := Scan(FPath, FFileName, 0, 2, 70, 0, 0);
  EnDisConnect;

  if vResult >= 1 then
    ShowMessage('成功')
  else begin
    ShowMessage('错误返回值: ' + vResult.ToString());
  end;
end;

procedure TForm1.btnSetScannerDPIClick(Sender: TObject);

var
  vResult: Integer;
begin
  vResult := EnConnect(1);
  if vResult >= 1 then
    ShowMessage('成功')
  else begin
    ShowMessage('错误返回值: ' + vResult.ToString());
  end;
  ShowMessage(SetScannerDPI(StrToInt(edtDPI.Text)).ToString)
end;

end.
