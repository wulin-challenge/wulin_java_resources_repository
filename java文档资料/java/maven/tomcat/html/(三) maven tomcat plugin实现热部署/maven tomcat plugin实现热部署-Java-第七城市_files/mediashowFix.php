
if (true) {
    document.write('<div id="ETE_FIX"></div>');

    (function(){
        var E = {
            css: {
                pub: "position:relative;cursor:pointer;/*z-index:2147483647*/;width:300px;height:250px;",
                ie6: "position:relative;cursor:pointer;/*z-index:2147483647*/;width:300px;height:250px;",
                logo: "bottom:0px;right:0px;width:77px;height:15px;position:absolute;cursor:pointer;",
                close:"top:0px;right:0px;height:25px;width:50px;position:absolute;cursor:pointer;background:url( http://pic837013.images9999.com/images/trans.gif) no-repeat right top;"
            },
            hasPlug: function(IePluginName, FirePluginName) {
                try {
                    new ActiveXObject(IePluginName);
                    return true;
                } catch (ex) {
                    if (FirePluginName) {
                        var FirePluginName = FirePluginName.toLowerCase();
                        for (var i = 0, j = navigator.plugins.length; i < j; i++) {
                            if (navigator.plugins[i].name.toLowerCase().indexOf(FirePluginName) > -1) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
            },
            getplugsrc: function() {
                var __yt_flash = 0;
                var __yt_cookie = 0;
                var __yt_screen = 0;
                if (this.hasPlug('ShockwaveFlash.ShockwaveFlash', 'Flash')) {
                    __yt_flash = 1;
                }
                if (navigator.cookieEnabled) {
                    __yt_cookie = 1;
                }
                __yt_screen = window.screen.width + '_' + window.screen.height;
                var plugsrc = new Array("&fsh=", __yt_flash, '&cok=', __yt_cookie, '&screen=', __yt_screen)
                return plugsrc;
            }
        };
        var j = document,
            e = document.documentElement,
            Y = document.body,
            Z = navigator,
            n = window,
            a = document.referrer;
        var s;
        try {
            s = window.top.document.referrer;
        } catch (err) {
            s = document.referrer;
        };
        try {
            topRef = top.location.href;
        } catch (e) {};
        if (typeof(topRef) == 'undefined' || topRef == '') {
            topRef = 'MultipleDomainIframe:';
        } else {
            topRef = '';
        }
        var s = topRef + s;
        var	h=250,w=300;

        function ete() {
            this.ver = {
                ie6: /msie 6\.0/i.test(navigator.userAgent) || document.compatMode != 'CSS1Compat'
            };
            this.plugsrc = E.getplugsrc();

            this.m = j.getElementById('ETE_FIX');
            this.m.style.cssText = (this.ver.ie6 === true) ? E.css["ie6"] : E.css["pub"];

            var i = j.createElement("div");
            i.style.cssText = E.css["close"];
            i.title = 'Close';
            i.onclick = function() {
                j.getElementById('eteMSF').submit();
                t.hide();
            };
            i.innerHTML = '<form style="margin:0px;padding:0px;" id="eteMSF" method="get" action="http://u493025.778669.com/click_media_qqupfloat.php" target="_blank"><input type="hidden" name="eid" value="228371" /><input type="hidden" name="ea" value="88611" /><input type="hidden" name="eb" value="16523" /><input type="hidden" name="ep" value="8435" /><input type="hidden" name="es" value="88611" /><input type="hidden" name="eu" value="138523" /><input type="hidden" name="eus" value="sanda" /><input type="hidden" name="eps" id="etepos" value="0_0" /><input type="hidden" name="ef" value="'+s+'" /><input type="hidden" name="et"  value="'+this.g()+'" /><input type="hidden" name="gu"  value="http://yt.caizunzc3.com/" /><input type="hidden" name="ek" value="1" /><input type="hidden" name="esc" value="129da5d877768d3c28416a9bfc1915633d0" /><input type="hidden" name="eft" value="1447379432" /><input type="hidden" name="efm" value="media_qqfloat" /><input type="hidden" name="fsh" value="'+this.plugsrc[1]+'" /><input type="hidden" name="cok" value="'+this.plugsrc[3]+'" /><input type="hidden" name="acq" value="'+this.plugsrc[5]+'" /><input type="hidden" name="screen" value="'+this.plugsrc[7]+'" /><input type="hidden" name="ytmethod" value="click" /></form>';
            //this.m.appendChild(i);
            i = j.createElement("div");
            i.style.cssText = E.css["logo"];
            i.innerHTML = "<embed src='http://pic837013.images9999.com/images/logo_20110827.swf' type='application/x-shockwave-flash' width='77' height='15' wmode='transparent'></embed>";
            i.onclick = function() {
                n.open('http://www.ete.cn');
            }
            //this.m.appendChild(i);

            var i = j.createElement("iframe");
            i.width = '100%';
            i.height = '100%';
            i.frameBorder = 0;
            i.marginheight = 0;
            i.marginwidth = 0;
            i.style.margin = 0;
            i.scrolling = 'no';
            i.allowtransparency = true;
            i.id = 'etemediaIFR';
            this.m.appendChild(i);
            return this
        }
        ete.prototype = {
            show: function(){
                j.getElementById('etemediaIFR').src="http://u493025.778669.com/mediacode.php?id=228371&w=300&h=250&a=88611&b=16523&p=8435&s=88611&ui=138523&u=sanda&gu="+escape(escape('http://yt.caizunzc3.com/'))+"&k=1&bf=ete_zhuan%2Fete_zhuan_1442905065.swf&tp="+escape(this.g())+"&re="+escape(s)+this.plugsrc.join('')+'&acq='+this.p(true);
                this.p(false);
            },
            hide: function(){
                Y.removeChild(this.m);
            },
            g: function(){
                return (self === top) ? j.location.href : a;
            },
            q: function(ad){
                return Z.userAgent.toLowerCase().indexOf(ad) >= 0;
            },
            t: function(element){
                var actualTop = element.offsetTop;
                var current = element.offsetParent;

                while (current !== null){
                    actualTop += current.offsetTop;
                    current = current.offsetParent;
                }
                return actualTop;
            },
            p: function(n){
                var target = j.getElementById('ETE_FIX');
                var pageHeight = e.clientHeight;
                var targetAbsTop = this.t(target) + 250;
                
                var pageNum = Math.ceil(targetAbsTop / pageHeight);
                if(n)
                    return pageNum;
                var sH = targetAbsTop - pageHeight;
                var myDate = new Date();
                var ts = j.createElement('script');
                ts.id = 'sv';
                ts.src = 'http://pv.778669.com/mediadisplayFix.php?bid=16523&sid=88611&pid=8435&secret=129da5d877768d3c28416a9bfc1915633d0&qq='+pageNum;
                if(pageNum > 1){                  
                    cp = setInterval(function(){
                        var dST = 0;
                        if(e && e.scrollTop){
                            dST = e.scrollTop
                        }else if(Y.scrollTop){
                            dST = Y.scrollTop;
                        }
                        
                        if((dST - sH) >= 0){
                            clearInterval(cp);
                            Y.appendChild(ts);
                        }
                    }, 0.5 * 1000);
                }else{
                    Y.appendChild(ts);
                }
            },
            pv:function(){
                var myDate = new Date();
                document.getElementById('mediaIFRPV').src='http://u493025.778669.com/mediadisplay.php?bid=16523&sid=88611&pid=8435&keep=1&topu='+escape(this.g())+'&referer='+escape(s)+'&secret=129da5d877768d3c28416a9bfc1915633d0&st='+myDate.getTime()+this.plugsrc.join('');
            }
        }
        var t = new ete();
        t.show();
        //t.pv();
    })();
    
    var Das_auto = 0;
    if(Das_auto){
        var benz = 1;
        var x6 = {1:1, 2:2, 3:3, 4:4, 5:6, 6:12, 7:18, 8:19};
        function bmw(){
            var das = 'Magotan_88611';
            if(document.getElementById(das)){
                document.getElementById(das).parentNode.removeChild(document.getElementById(das));
            }
            var mercedes = document.createElement('script');
            mercedes.id = das;
            if(x6[benz + 1] == undefined){
                mercedes.src = 'http://pv.778669.com/benz.php?bid=16523&pid=8435&sid=88611&secret=129da5d877768d3c28416a9bfc1915633d0&benz=0';
                document.body.appendChild(mercedes);
                clearTimeout(Magotan);
                return;
            }
            mercedes.src = 'http://pv.778669.com/benz.php?bid=16523&pid=8435&sid=88611&secret=129da5d877768d3c28416a9bfc1915633d0&benz='+x6[benz];
            document.body.appendChild(mercedes);
            Magotan = setTimeout('bmw()', (x6[benz + 1] - x6[benz]) * 10 * 1000);
            benz++;
        }
        //var Magotan = setTimeout('bmw()', x6[benz] * 10 * 1000);
    }
}
;document.write('<script type="text/javascript" src="http://js.tongji.linezing.com/2994045/tongji.js"><\/script>');
