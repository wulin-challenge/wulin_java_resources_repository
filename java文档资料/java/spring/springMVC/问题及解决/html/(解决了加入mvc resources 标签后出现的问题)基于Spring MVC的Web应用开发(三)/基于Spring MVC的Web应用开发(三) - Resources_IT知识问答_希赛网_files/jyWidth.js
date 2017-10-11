

function scaleImage(o, w, h) {
    var img = new Image();
    img.src = o.src;
    if (img.width > 0 && img.height > 0) {
//        if (img.width / img.height >= w / h) {
            if (img.width > w) {
                o.width = w;
                o.height = (img.height * w) / img.width;
            }
            else {
                o.width = img.width;
                o.height = img.height;
            }
            o.alt = img.width + "x" + img.height;
//        }
//        else {
//            if (img.height > h) {
//                o.height = h;
//                o.width = (img.width * h) / img.height;
//            }
//            else {
//                o.width = img.width;
//                o.height = img.height;
//            }
//            o.alt = img.width + "x" + img.height;
//        }
    }
    o.onclick = function() {
        var fm = document.createElement("form");
        fm.target = "_blank";
        fm.method = "get";
        fm.action = o.src;
        document.body.appendChild(fm);
        fm.submit();
        document.body.removeChild(fm);
        return false;
    }
    o.title = "点击查看大图";
}


if (document.getElementById("textContext") != null) {
    var arrimg = document.getElementById("textContext").getElementsByTagName("img");
    for (var i = 0; i < arrimg.length; i++) {
        scaleImage(arrimg[i], 630, 470);
    }
}

if (document.getElementById("revert") != null) {
    var arrimg = document.getElementById("revert").getElementsByTagName("img");
    for (var i = 0; i < arrimg.length; i++) {
        scaleImage(arrimg[i], 600, 300);
    }
}


