jbMap = window.jbMap || {};
function jbViaJs(locationId) {
    var _f = undefined;
    var _fconv = 'jbMap[\"' + locationId + '\"]';
    try {
        _f = eval(_fconv);
        if (_f != undefined) {
            _f()
        }
    } catch(e) {}
}
function jbLoader(closetag) {
    var jbTest = null,
    jbTestPos = document.getElementsByTagName("span");
    for (var i = 0; i < jbTestPos.length; i++) {
        if (jbTestPos[i].className == "jbTestPos") {
            jbTest = jbTestPos[i];
            break
        }
    }
    if (jbTest == null) return;
    if (!closetag) {
        document.write("<span id=jbTestPos_" + jbTest.id + " style=display:none>");
        jbViaJs(jbTest.id);
        return
    }
    document.write("</span>");
    var real = document.getElementById("jbTestPos_" + jbTest.id);
    for (var i = 0; i < real.childNodes.length; i++) {
        var node = real.childNodes[i];
        if (node.tagName == "SCRIPT" && /closetag/.test(node.className)) continue;
        jbTest.parentNode.insertBefore(node, jbTest);
        i--
    }
    jbTest.parentNode.removeChild(jbTest);
    real.parentNode.removeChild(real)
}


var logo_m='<a href="http://www.zzidc.com/main/huodong/shuangjie201609/pand_2389.html" target="_blank"><img src="http://files.jb51.net/image/zzidc370.gif" width=370 height=60 /></a>';
var logo_r='<a href="http://www.ku86.com" target="_blank"><img src="http://files.jb51.net/image/kuyun_370.gif" width=370 height=60 /></a>';

var aliyun1000='<div class="mainlr"><a href="http://click.aliyun.com/m/5831/" target="_blank"><img src="http://files.jb51.net/image/aliyun_1000_60.png" alt="cdnoss" width="1000" height="60"></a></div><div class="blank5"></div>';

var idctu=''; 

idctu+='<scr'+'ipt async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></scr'+'ipt><ins class="adsbygoogle" style="display:inline-block;width:300px;height:250px" data-ad-client="ca-pub-3965739745535757"data-ad-slot="3695488827"></ins><scr'+'ipt>(adsbygoogle = window.adsbygoogle || []).push({});</scr'+'ipt><div class="blank10"></div>';
idctu+='<A href="http://click.aliyun.com/m/5739/" target=_blank><IMG alt="" src="http://files.jb51.net/image/aliyun-300-100.jpg" width="300" height="100"></A>';

var aliwenzi='<li><a href="http://click.aliyun.com/m/4235/" target="_blank"><span style="color:red;">DDoS高防IP，300G无限防</span></a></li>';
var ali237='<li><A href="http://click.aliyun.com/m/5680/" target=_blank><IMG alt="" src="http://files.jb51.net/image/aliyun-237-60.jpg" width="237" height="60"></A></li>';

var tonglan1="";
tonglan1+='<div id="txtlink"><ul>';
tonglan1+='<li><a href="http://www.jsll.me" target="_blank"><span style="color:red;">低价出售流量10000IP只需8元</span></a></li>';
tonglan1+=aliwenzi;
tonglan1+='<li><a href="http://www.99-idc.com" target="_blank"><span style="color:red;">16核独服350/固态盘独服288/创梦网络</span></a></li>';
tonglan1+='<li><a href="http://www.zoneidc.com/chaozhi/" target="_blank"><span style="color:red;">美国云20元/香港云29元/韩国云55元</span></a></li>';

tonglan1+='<li><a href="http://js.50bang.org/?formType=7858" target="_blank"><span style="color:blue;">装软件赚钱，每台电脑秒赚6.3元</span></a></li>';
tonglan1+='<li><a href="http://www.mx111.com/KtServer.asp" target="_blank"><span style="color:blue;">美国服务器，368元/月起，高速，稳定</span></a></li>';
tonglan1+='<li><a href="http://www.vzidc.com/" target="_blank"><span style="color:blue;">微子网络 湛江双线高防 抗15G 700元起</span></a></li>';
tonglan1+='<li><a href="http://idc.jb51.net/" target="_blank"><span style="color:red;">脚本之家 百兆服务器租用、托管</span></a></li>';

tonglan1+='<li><a href="http://www.021.net" target="_blank"><span style="color:red;">众生网络 基于云计算的互联网基础服务运营商</span></a></li>';
tonglan1+='<li><a href="http://www.tuidc.com" target="_blank"><span style="color:red;">服务器租用/托管-域名空间/认准腾佑科技</span></a></li>';
tonglan1+='<li><a href="http://www.enkj.com/special/20160315/" target="_blank"><span style="color:red;">BGP四线 亿恩1U服务器托管3999元/年</span></a></li>';
tonglan1+='<li><A href="http://www.jjidc.com/" target=_blank><span style="color:red;">九九数据 — 工信部认可正规资质IDC接入商</span></A></li>';

tonglan1+='<li><a href="http://www.33ip.com" target="_blank"><span style="color:blue;">枫信科技-江苏双线10M保证-399/元</span></a></li>';
tonglan1+='<li><a href="http://www.163cdn.com/" target="_blank"><span style="color:blue;">免备案国内虚拟主机-163cdn</span></a></li>';
tonglan1+='<li><a href="http://www.ssf.cc/" target="_blank"><span style="color:blue;">免备vps20/百独799/双线350/45互联</span></a></li>';
tonglan1+='<li><a href="http://www.xiaozhiyun.com/2016/" target="_blank"><span style="color:blue;">韩国\香港\美国站群服务器 巨牛网络</span></a></li>';

tonglan1+='<li><a href="http://www.139w.com/" target="_blank"><span style="color:red;">鼎点网络百兆独享服务器仅需999元</span></a></li>';
tonglan1+='<li><a href="http://www.360jq.com/hkshuang.htm" target="_blank"><span style="color:red;">[香港双高防]无视CC★DDOS/堪比广东！</span></a></li>';
tonglan1+='<li><a href="http://www.cyidc.cc/" target="_blank"><span style="color:red;">畅游网络 百独服务器 包跑满 998元</span></a></li>';
tonglan1+='<li><a href="http://www.wdw6.com" target="_blank"><span style="color:red;">服务器租用  199元起</span></a></li>';

tonglan1+='</ul><DIV class=clearfix></DIV></div><div class="blank6"></div>';
tonglan1+='<div class="topimg"><ul>';
tonglan1+='<li><A href="http://www.west.cn/services/CloudHost/?ads=jb512014" target=_blank><IMG alt="" src="http://files.jb51.net/image/west263_237.gif" width="237" height="60"></A></li>';
tonglan1+=ali237;
tonglan1+='<li><A href="http://www.5gdns.com/51jb.html" target=_blank><IMG alt="" src="http://files.jb51.net/image/5gdns_237.gif" width="237" height="60"></A></li>';
tonglan1+='<li><A href="http://www.7e.hk" target=_blank><IMG alt="" src="http://files.jb51.net/image/7ehk.gif" width="237" height="60"></A></li>';
tonglan1+='</ul></div><div class="blank6"></div>';
tonglan1+=aliyun1000;

var tonglan1_2="";
tonglan1_2+=aliyun1000;
tonglan1_2+='<div id="txtlink"><ul>';
tonglan1_2+='<li><a href="http://www.jsll.me" target="_blank"><span style="color:red;">低价出售流量10000IP只需8元</span></a></li>';
tonglan1_2+=aliwenzi;
tonglan1_2+='<li><a href="http://www.99-idc.com" target="_blank"><span style="color:red;">16核独服350/固态盘独服288/创梦网络</span></a></li>';
tonglan1_2+='<li><a href="http://www.zoneidc.com/chaozhi/" target="_blank"><span style="color:red;">美国云20元/香港云29元/韩国云55元</span></a></li>';

tonglan1_2+='<li><a href="http://js.50bang.org/?formType=7858" target="_blank"><span style="color:blue;">装软件赚钱，每台电脑秒赚6.3元</span></a></li>';
tonglan1_2+='<li><a href="http://www.mx111.com/KtServer.asp" target="_blank"><span style="color:blue;">美国服务器，368元/月起，高速，稳定</span></a></li>';
tonglan1_2+='<li><a href="http://www.vzidc.com/" target="_blank"><span style="color:blue;">微子网络 湛江双线高防 抗15G 700元起</span></a></li>';
tonglan1_2+='<li><a href="http://idc.jb51.net/" target="_blank"><span style="color:red;">脚本之家 百兆服务器租用、托管</span></a></li>';

tonglan1_2+='<li><a href="http://www.021.net" target="_blank"><span style="color:red;">众生网络 基于云计算的互联网基础服务运营商</span></a></li>';
tonglan1_2+='<li><a href="http://www.tuidc.com" target="_blank"><span style="color:red;">服务器租用/托管-域名空间/认准腾佑科技</span></a></li>';
tonglan1_2+='<li><a href="http://www.enkj.com/special/20160315/" target="_blank"><span style="color:red;">BGP四线 亿恩1U服务器托管3999元/年</span></a></li>';
tonglan1_2+='<li><A href="http://www.jjidc.com/" target=_blank><span style="color:red;">九九数据 — 工信部认可正规资质IDC接入商</span></A></li>';

tonglan1_2+='<li><a href="http://www.33ip.com" target="_blank"><span style="color:blue;">枫信科技-江苏双线10M保证-399/元</span></a></li>';
tonglan1_2+='<li><a href="http://www.163cdn.com/" target="_blank"><span style="color:blue;">免备案国内虚拟主机-163cdn</span></a></li>';
tonglan1_2+='<li><a href="http://www.ssf.cc/" target="_blank"><span style="color:blue;">免备vps20/百独799/双线350/45互联</span></a></li>';
tonglan1_2+='<li><a href="http://www.xiaozhiyun.com/2016/" target="_blank"><span style="color:blue;">韩国\香港\美国站群服务器 巨牛网络</span></a></li>';

tonglan1_2+='<li><a href="http://www.139w.com/" target="_blank"><span style="color:red;">鼎点网络百兆独享服务器仅需999元</span></a></li>';
tonglan1_2+='<li><a href="http://www.360jq.com/hkshuang.htm" target="_blank"><span style="color:red;">[香港双高防]无视CC★DDOS/堪比广东！</span></a></li>';
tonglan1_2+='<li><a href="http://www.cyidc.cc/" target="_blank"><span style="color:red;">畅游网络 百独服务器 包跑满 998元</span></a></li>';
tonglan1_2+='<li><a href="http://www.wdw6.com" target="_blank"><span style="color:red;">服务器租用  199元起</span></a></li>';

tonglan1_2+='</ul><DIV class=clearfix></DIV></div><div class="blank6"></div>';
tonglan1_2+='<div class="topimg"><ul>';
tonglan1_2+='<li><A href="http://www.7e.hk" target=_blank><div style="width:237px;height:60px;position:relative;"><IMG alt="" src="http://www.7e.hk/daimg/jb51.gif" width="237" height="60"><div style="position: absolute;z-index: 1;right: 0;bottom:0;background: url(http://img.jb51.net/skin/2016/images/gg.png) no-repeat bottom right;width: 237px;height: 60px;overflow: hidden;"></div></div></A></li>';
tonglan1_2+='<li><A href="http://idc.jb51.net" target=_blank><IMG alt="" src="http://files.jb51.net/image/idcjb51_237.gif" width="237" height="60"></A></li>';
tonglan1_2+=ali237;
tonglan1_2+='<li><A href="http://www.5gdns.com/51jb.html" target=_blank><IMG alt="" src="http://files.jb51.net/image/5gdns_237.gif" width="237" height="60"></A></li>';
tonglan1_2+='</ul></div><div class="blank6"></div>';

var tonglan2='<a href="http://www.v01.cn" alt="上海众生" target="_blank"><img src="http://files.jb51.net/image/zs960.gif" width="1000" height="60" border="0" /></a><div class="blank3"></div><a href="http://tuidc.com" alt="香港主机 国外主机" target="_blank"><img src="http://files.jb51.net/image/host5_960.gif" width="1000" height="60" border="0" /></a>';
var tonglan2_1='<a href="http://www.v01.cn" alt="上海众生" target="_blank"><img src="http://files.jb51.net/image/zs960.gif" width="1000" height="60" border="0" /></a>';
var tonglan2_2='<a href="http://www.zhimak.com/?ad=jb51" alt="" target="_blank"><img src="http://files.jb51.net/image/tengyou_gz.gif" width="1000" height="60" border="0" /></a>';

var tonglan3_2='<div class="topimg"><ul>';
tonglan3_2+='<li><A href="http://www.west.cn/?ads=jb512012" target=_blank><IMG alt="" src="http://files.jb51.net/image/west263_index.gif" width="237" height="60"></A></li>';
tonglan3_2+='<li><A href="http://www.jjidc.com" target=_blank><IMG alt="" src="http://files.jb51.net/image/jjidc_237.gif" width="237" height="60"></A></li>';
tonglan3_2+='<li><A href="http://www.enkj.com/encloud/" target=_blank><IMG alt="" src="http://files.jb51.net/image/enkj_237.gif" alt="云服务器" width="237" height="60"></A></li>';
tonglan3_2+='<li><A href="http://www.cyidc.cc/" target=_blank><IMG alt="" src="http://files.jb51.net/image/cyidc_237.gif" width="237" height="60"></A></li>';
tonglan3_2+='</ul></div>';

var botad='<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>';
botad+='<ins class="adsbygoogle" style="display:inline-block;width:336px;height:280px" data-ad-client="ca-pub-6384567588307613" data-ad-slot="6445926239" data-override-format="true" data-page-url="http://www.jb51.net"></ins><script>(adsbygoogle = window.adsbygoogle || []).push({});</script>';

var gg;
if (getCookie("gg")=="ok1"){
var idctu1='<A href="http://www.021.net" target=_blank><div style="width:300px;height:100px;position:relative;"><IMG alt="" src="http://files.jb51.net/image/zs_300.gif"><div style="position: absolute;z-index: 1;right: 0;bottom:0;background: url(http://img.jb51.net/skin/2016/images/gg.png) no-repeat bottom right;width: 300px;height: 100px;overflow: hidden;"></div></div></A><div class="blank10"></div>';
idctu1+='<a href="http://tuidc.com" target="_blank"><div style="width:300px;height:100px;position:relative;"><img src="http://files.jb51.net/image/tengyou300.gif" width="300" height="100"><div style="position: absolute;z-index: 1;right: 0;bottom:0;background: url(http://img.jb51.net/skin/2016/images/gg.png) no-repeat bottom right;width: 300px;height: 100px;overflow: hidden;"></div></div></a>';
var idctu2='<a href="http://www.33ip.com" target="_blank"><div style="width:300px;height:100px;position:relative;"><img src="http://files.jb51.net/image/33ip_300.gif" width="300" height="100"><div style="position: absolute;z-index: 1;right: 0;bottom:0;background: url(http://img.jb51.net/skin/2016/images/gg.png) no-repeat bottom right;width: 300px;height: 100px;overflow: hidden;"></div></div></a><div class="blank10"></div>';
idctu2+='<a href="http://www.enkj.com/encloud/" target="_blank"><div style="width:300px;height:100px;position:relative;"><img src="http://files.jb51.net/image/enkj_300.gif" alt="云服务器" width="300" height="100"><div style="position: absolute;z-index: 1;right: 0;bottom:0;background: url(http://img.jb51.net/skin/2016/images/gg.png) no-repeat bottom right;width: 300px;height: 100px;overflow: hidden;"></div></div></a>';
setCookie("gg","ok2",1);
}else{
var idctu1='<a href="http://tuidc.com" target="_blank"><div style="width:300px;height:100px;position:relative;"><img src="http://files.jb51.net/image/tengyou300.gif" width="300" height="100"><div style="position: absolute;z-index: 1;right: 0;bottom:0;background: url(http://img.jb51.net/skin/2016/images/gg.png) no-repeat bottom right;width: 300px;height: 100px;overflow: hidden;"></div></div></a>';
idctu1+='<div class="blank10"></div><a href="http://www.enkj.com/encloud/" target="_blank"><div style="width:300px;height:100px;position:relative;"><img src="http://files.jb51.net/image/enkj_300.gif" alt="云服务器" width="300" height="100"><div style="position: absolute;z-index: 1;right: 0;bottom:0;background: url(http://img.jb51.net/skin/2016/images/gg.png) no-repeat bottom right;width: 300px;height: 100px;overflow: hidden;"></div></div></a>';
var idctu2='<a href="http://www.geisnic.com/" target="_blank"><div style="width:300px;height:100px;position:relative;"><img src="http://files.jb51.net/image/gs.gif" width="300" height="100"><div style="position: absolute;z-index: 1;right: 0;bottom:0;background: url(http://img.jb51.net/skin/2016/images/gg.png) no-repeat bottom right;width: 300px;height: 100px;overflow: hidden;"></div></div></a>';
idctu2+='<div class="blank10"></div><a href="http://www.33ip.com" target="_blank"><div style="width:300px;height:100px;position:relative;"><img src="http://files.jb51.net/image/33ip_300.gif" width="300" height="100"><div style="position: absolute;z-index: 1;right: 0;bottom:0;background: url(http://img.jb51.net/skin/2016/images/gg.png) no-repeat bottom right;width: 300px;height: 100px;overflow: hidden;"></div></div></a>';
setCookie("gg","ok1",1);
}
/*******---------在线工具start----------********/
var toolsarr= new Array();
toolsarr[0]=new Array();
toolsarr[0][name]="在线XML/JSON互相转换工具";
toolsarr[0]['link']="http://tools.jb51.net/code/xmljson";

toolsarr[1]=new Array();
toolsarr[1][name]="CSS代码工具";
toolsarr[1]['link']="http://tools.jb51.net/code/css";

toolsarr[2]=new Array();
toolsarr[2][name]="JSON代码工具";
toolsarr[2]['link']="http://tools.jb51.net/code/json";

toolsarr[3]=new Array();
toolsarr[3][name]="JavaScript代码格式化工具";
toolsarr[3]['link']="http://tools.jb51.net/code/js";

toolsarr[4]=new Array();
toolsarr[4][name]="JavaScript代码在线加密工具";
toolsarr[4]['link']="http://tools.jb51.net/code/encodeTxt";

toolsarr[5]=new Array();
toolsarr[5][name]="JavaScript压缩/格式化/加密工具";
toolsarr[5]['link']="http://tools.jb51.net/code/jscompress";

toolsarr[6]=new Array();
toolsarr[6][name]="在线JSON代码检验/检验/美化/格式化";
toolsarr[6]['link']="http://tools.jb51.net/code/json";

toolsarr[7]=new Array();
toolsarr[7][name]="JavaScript正则在线测试工具";
toolsarr[7]['link']="http://tools.jb51.net/regex/javascript";

toolsarr[8]=new Array();
toolsarr[8][name]="Unix时间戳(timestamp)转换工具";
toolsarr[8]['link']="http://tools.jb51.net/code/unixtime";

toolsarr[9]=new Array();
toolsarr[9][name]="在线JS脚本校验器错误";
toolsarr[9]['link']="http://www.jb51.net/tools/js_Debug.htm";

toolsarr[10]=new Array();
toolsarr[10][name]="在线生成二维码工具(加强版)";
toolsarr[10]['link']="http://tools.jb51.net/transcoding/jb51qrcode";

toolsarr[11]=new Array();
toolsarr[11][name]="在线XML格式化/压缩工具";
toolsarr[11]['link']="http://tools.jb51.net/code/xmlformat";

toolsarr[12]=new Array();
toolsarr[12][name]="php代码在线格式化美化工具";
toolsarr[12]['link']="http://tools.jb51.net/code/phpformat";

toolsarr[13]=new Array();
toolsarr[13][name]="sql代码在线格式化美化工具";
toolsarr[13]['link']="http://tools.jb51.net/code/sqlcodeformat";

toolsarr[14]=new Array();
toolsarr[14][name]="RGB颜色查询对照表_配色工具";
toolsarr[14]['link']="http://tools.jb51.net/color/jPicker";

toolsarr[15]=new Array();
toolsarr[15][name]="在线图片格式转换(jpg/bmp/gif/png)工具";
toolsarr[15]['link']="http://tools.jb51.net/aideddesign/picext";

toolsarr[16]=new Array();
toolsarr[16][name]="歇后语在线查询";
toolsarr[16]['link']="http://tools.jb51.net/bianmin/xiehouyu";

toolsarr=getArrayItems(toolsarr,11);

var bctools='<li><a href="'+toolsarr[0]['link']+'" target="_blank"><font color="red">'+toolsarr[0][name]+'</font></a></li>';
bctools+='<li><a href="'+toolsarr[1]['link']+'" target="_blank"><font color="red">'+toolsarr[1][name]+'</font></a></li>';
bctools+='<li><a href="'+toolsarr[2]['link']+'" target="_blank">'+toolsarr[2][name]+'</a></li>';
bctools+='<li><a href="'+toolsarr[3]['link']+'" target="_blank"><font color="red">'+toolsarr[3][name]+'</font></a></li>';
bctools+='<li><a href="'+toolsarr[4]['link']+'" target="_blank">'+toolsarr[4][name]+'</a></li>';
bctools+='<li><a href="'+toolsarr[5]['link']+'" target="_blank">'+toolsarr[5][name]+'</a></li>';
bctools+='<li><a href="'+toolsarr[6]['link']+'" target="_blank">'+toolsarr[6][name]+'</a></li>';
bctools+='<li><a href="'+toolsarr[7]['link']+'" target="_blank">'+toolsarr[7][name]+'</a></li>';
bctools+='<li><a href="'+toolsarr[8]['link']+'" target="_blank">'+toolsarr[8][name]+'</a></li>';
bctools+='<li><a href="'+toolsarr[9]['link']+'" target="_blank">'+toolsarr[9][name]+'</a></li>';
/*******---------在线工具end----------********/


var tonglanbd='<scr'+'ipt type="text/javascript">var cpro_id = "u336546";</script><script src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></scr'+'ipt>';

var art_up = '<script type="text/javascript">var cpro_id="u2261530";(window["cproStyleApi"] = window["cproStyleApi"] || {})[cpro_id]={at:"3",rsi0:"680",rsi1:"200",pat:"6",tn:"baiduCustNativeAD",rss1:"#FFFFFF",conBW:"1",adp:"1",ptt:"0",titFF:"%E5%BE%AE%E8%BD%AF%E9%9B%85%E9%BB%91",titFS:"14",rss2:"#000000",titSU:"0",ptbg:"90",piw:"0",pih:"0",ptp:"0"}</script><script src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></script>';

var art_down = '<script type="text/javascript">var cpro_id="u776243";(window["cproStyleApi"] = window["cproStyleApi"] || {})[cpro_id]={at:"3",rsi0:"650",rsi1:"250",pat:"1",tn:"baiduCustNativeAD",rss1:"#FFFFFF",conBW:"0",adp:"1",ptt:"0",titFF:"%E5%BE%AE%E8%BD%AF%E9%9B%85%E9%BB%91",titFS:"14",rss2:"#000000",titSU:"0",tft:"0",tlt:"1",ptbg:"90",piw:"0",pih:"0",ptp:"0"}</script><script src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></script>';

var art_down2 = '<script type="text/javascript">var cpro_id="u2261530";(window["cproStyleApi"] = window["cproStyleApi"] || {})[cpro_id]={at:"3",rsi0:"680",rsi1:"200",pat:"6",tn:"baiduCustNativeAD",rss1:"#FFFFFF",conBW:"1",adp:"1",ptt:"0",titFF:"%E5%BE%AE%E8%BD%AF%E9%9B%85%E9%BB%91",titFS:"14",rss2:"#000000",titSU:"0",ptbg:"90",piw:"0",pih:"0",ptp:"0"}</script><script src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></script>';

var side_up = '<scri'+'pt async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></scri'+'pt><ins class="adsbygoogle" style="display:inline-block;width:300px;height:250px" data-ad-client="ca-pub-1247620132145618" data-ad-slot="2253650178" data-override-format="true" data-page-url="http://www.jb51.net"></ins><scri'+'pt>(adsbygoogle = window.adsbygoogle || []).push({});</s'+'cript>';

var r_2 = '<script type="text/javascript">var cpro_id="u1397867";(window["cproStyleApi"] = window["cproStyleApi"] || {})[cpro_id]={at:"3",rsi0:"300",rsi1:"380",pat:"6",tn:"baiduCustNativeAD",rss1:"#FFFFFF",conBW:"1",adp:"1",ptt:"0",titFF:"%E5%BE%AE%E8%BD%AF%E9%9B%85%E9%BB%91",titFS:"14",rss2:"#000000",titSU:"0",ptbg:"90",piw:"0",pih:"0",ptp:"0"}</script><script src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></script>';

var fudong = '<scri'+'pt type="text/javascript">var cpro_id="u1397867";(window["cproStyleApi"] = window["cproStyleApi"] || {})[cpro_id]={at:"3",rsi0:"300",rsi1:"380",pat:"6",tn:"baiduCustNativeAD",rss1:"#FFFFFF",conBW:"1",adp:"1",ptt:"0",titFF:"%E5%BE%AE%E8%BD%AF%E9%9B%85%E9%BB%91",titFS:"14",rss2:"#000000",titSU:"0",ptbg:"90",piw:"0",pih:"0",ptp:"0"}</sc'+'ript>';
fudong += '<scrip'+'t src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></scr'+'ipt>';

var gg_l = '<scri'+'pt async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></scri'+'pt>';
gg_l += '<ins class="adsbygoogle" style="display:inline-block;width:300px;height:250px" data-ad-client="ca-pub-6384567588307613" data-ad-slot="6438537127" data-override-format="true" data-page-url="http://www.jb51.net"></ins>';
gg_l += '<scri'+'pt>(adsbygoogle = window.adsbygoogle || []).push({});</s'+'cript>';

var gg_r = '<script type="text/javascript">var cpro_id = "u811641";</script>';
gg_r += '<scri'+'pt src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></sc'+'ript>';

//var r1gg='<scri'+'pt async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></scri'+'pt>';
//r1gg+='<ins class="adsbygoogle" style="display:inline-block;width:300px;height:250px" data-ad-client="ca-pub-6384567588307613" data-ad-slot="2817964327"></ins><scri'+'pt>(adsbygoogle = window.adsbygoogle || []).push({});</s'+'cript>';

var r1gg = '<scri'+'pt async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></scri'+'pt><ins class="adsbygoogle" style="display:inline-block;width:300px;height:250px" data-ad-client="ca-pub-1247620132145618" data-ad-slot="2253650178" data-override-format="true" data-page-url="http://www.jb51.net"></ins><scri'+'pt>(adsbygoogle = window.adsbygoogle || []).push({});</s'+'cript>';

var bd200 = '<scri'+'pt type="text/javascript">var cpro_id="u2261513";(window["cproStyleApi"] = window["cproStyleApi"] || {})[cpro_id]={at:"3",rsi0:"300",rsi1:"300",pat:"6",tn:"baiduCustNativeAD",rss1:"#FFFFFF",conBW:"1",adp:"1",ptt:"0",titFF:"%E5%BE%AE%E8%BD%AF%E9%9B%85%E9%BB%91",titFS:"14",rss2:"#000000",titSU:"0",ptbg:"90",piw:"0",pih:"0",ptp:"0"}</sc'+'ript>';
bd200 += '<scrip'+'t src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></scr'+'ipt>';

var dxy728 = '<a href="http://www.33ip.com" target="_blank"><img src="http://files.jb51.net/image/33ip_728.gif"></a>';
var dxy230 = '<a href="http://vzidc.taobao.com/" target="_blank"><img src="http://files.jb51.net/image/vzidc230.gif" width=260 height=90></a>';


jbMap['logo_m'] = function() {
	document.writeln(logo_m);
};

jbMap['logo_r'] = function() {
	document.writeln(logo_r);
};

jbMap['idctu'] = function() {
	document.writeln(idctu);
};

jbMap['tonglanbd'] = function() {
	document.writeln(tonglanbd);
};

jbMap['tonglan1'] = function() {
	document.writeln(tonglan1);
};

jbMap['tonglan1_2'] = function() {
	document.writeln(tonglan1_2);
};

jbMap['tonglan2'] = function() {
	document.writeln(tonglan2);
};

jbMap['tonglan2_1'] = function() {
	document.writeln(tonglan2_1);
};

jbMap['tonglan2_2'] = function() {
	document.writeln(tonglan2_2);
};

jbMap['tonglan3_2'] = function() {
	document.writeln(tonglan3_2);
};

jbMap['botad'] = function() {
	document.writeln(botad);
};

jbMap['idctu1'] = function() {
	document.writeln(idctu1);
};

jbMap['idctu2'] = function() {
	document.writeln(idctu2);
};


jbMap['art_up'] = function() {
	document.writeln(art_up);
};

jbMap['art_down'] = function() {
	document.writeln(art_down);
};

jbMap['art_down2'] = function() {
	document.writeln(art_down2);
};

jbMap['side_up'] = function() {
	document.writeln(side_up);
};

jbMap['r_2'] = function() {
	document.writeln(r_2);
};

jbMap['fudong'] = function() {
	document.writeln(fudong);
};


jbMap['gg_l'] = function() {
	document.writeln(gg_l);
};

jbMap['gg_r'] = function() {
	document.writeln(gg_r);
};

jbMap['r1gg'] = function() {
	document.writeln(r1gg);
};

jbMap['bd200'] = function() {
	document.writeln(bd200);
};


jbMap['bctools'] = function() {
	document.writeln(bctools);
};

jbMap['dxy728'] = function() {
	document.writeln(dxy728);
};

jbMap['dxy230'] = function() {
	document.writeln(dxy230);
};

//对联
if(window.location.href != 'http://www.jb51.net/index.htm' && window.location.href != 'http://www.jb51.net/index2.htm' && window.location.href != 'http://www.jb51.net/' && window.location.href != 'http://www.jb51.net/?pc'){
	
	
	var cpro_id = 'u480030';
	document.write('<scrip'+'t src="http://cpro.baidustatic.com/cpro/ui/f.js" type="text/javascript"></sc'+'ript>');
} else {
}


//替换QQ号
var articleid = $('#SOHUCS').attr('sid');
var ad_articlelist = ',,308670,308667,308664,275028,275021,275032,260403,276445,260389,302614,339523,257463,276445,302614,257477,257477,275021,275021,258045,255917,145962,251883,256430,254154,449914,300027,29433,449900,271538,335869,69356,';
if("undefined" != typeof articleid){
    if(articleid!=null && ad_articlelist.indexOf(','+articleid+',') > 0){
		$('.tjz_qq:first').replaceWith(' 推荐<span class="pd5" style="color:red;">添加微信：hhnnn6</span><img data-baiduimageplus-ignore="" style="border:0;" border="0" align="absmiddle" src="http://files.jb51.net/image/aimeng.png" width="300" height="426" />');
		 $('.tjz_qq').replaceWith(' 推荐<span class="pd5" style="color:red;">添加微信：hhnnn6</span>');
    }
}