function searchKeydown(e) {
    e = e || window.event;
    if (e.keyCode == 13) {
        return searchNewClick();
    }
}
function searchNewClick() {
    var typeval = document.getElementById("Select1").value;
    var keyword = document.getElementById("top_keyword").value;
    if (keyword.replace(/^\s*/, "").replace(/\s*$/, "").length < 1 || document.getElementById("top_keyword").value == "用户输入关键词") {
        alert("搜索关键词不能为空！");
        document.getElementById("top_keyword").focus();
        return false;
    }
    keyword = keyword;
    var input = document.createElement("input");
    input.type = "text";
    var fm = document.createElement("form");
    if (window.location.search.substr(1) != '')
        fm.target = "_parent";
    else
        fm.target = "_blank";
    fm.method = "get";
    var urlStr = "";
    input.name = "words";
    urlStr = "http://www.educity.cn/incsearch/search.aspx"; //"http://www.educity.cn/insearch/search.aspx";
    var type = document.createElement("input");
    type.type = "text";
    type.value = typeval;
    type.name = "type";
    fm.appendChild(type);
    input.value = escape(keyword);
    fm.action = urlStr;
    fm.appendChild(input);
    document.body.appendChild(fm);
    fm.submit();
    document.body.removeChild(fm);
    return false;
}