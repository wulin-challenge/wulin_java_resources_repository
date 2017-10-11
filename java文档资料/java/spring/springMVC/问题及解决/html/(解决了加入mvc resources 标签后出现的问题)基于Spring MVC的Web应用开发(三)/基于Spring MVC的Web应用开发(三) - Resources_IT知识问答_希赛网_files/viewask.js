$(function () {
    $("#sc").click(function () {
        var data = { title_id: $("#titleId_h").val(), t: Math.random() }
        $.ajax(
            { url: "ajax/save.aspx",
                async: true,
                data: data,
                success: function (json) {
                    json = eval('(' + json + ')');
                    art.dialog({ id: "fw34gr", width: 240, height: 50, content: json.msg, ok: true, okVal: "确定", time: 3, title: "三秒后自动关闭" });
                    if (json.state == 0) {
                        location.href = "http://www.educity.cn/usercenter/login.aspx?page=" + escape(location.href);
                    }
                }
            });
    });

    $("#jd_btn").live("click", function () {
        var content = editor.getContent();
        //content =editor.getPlainTxt()
        if (editor.getPlainTxt().replace(/[ |\t|\n]/g, "") == "") {
            art.dialog({ id: "fw34gdsr", width: 240, height: 50, content: "内容不能为空。", ok: true, okVal: "确定" });
            return;
        }

        var v_userrole = $("#hid_userrole").val();
        if (v_userrole == "0") {
            if ($("#verycode").val() == "") {
                art.dialog({ id: "fw34gdsr", width: 240, height: 50, content: "请输入验证码。", ok: true, okVal: "确定" });
                return;
            }
        }
        art.dialog({
            id: 'EF893L',
            icon: 'face-smile',
            lock: true,
            content: '正在提交回答，请耐心等待。'
        });
        $("#jd_btn").attr('disabled', "false");
        var data = { act: 1, title_id: $("#titleId_h").val(), jd_tb: content, code: $("#verycode").val(), t: Math.random(), role: v_userrole };

        $.ajax(
            { url: "ajax/JieDa.aspx",
                type: "POST",
                async: false,
                data: data,
                success: function (json) {
                    art.dialog.list['EF893L'].close();
                    json = eval('(' + json + ')');
                    //art.dialog({ id: "fw34gr", width: 240, height: 50, content: json.msg, ok: true, okVal: "确定" });
                    if (json.state == 0) {
                        location.href = "http://www.educity.cn/usercenter/login.aspx?page=" + escape(location.href);
                    }
                    else if (json.state == 1) {
                        alert(json.msg);
                        location.href = location.href;
                    }
                    else if (json.state == -1) {
                        alert(json.msg);
                        $("#jd_btn").removeAttr("disabled");
                    }
                    else if (json.state == -2) {
                        alert(json.msg);
                        location.href = "http://www.educity.cn/wenda/";
                    }
                }
            });
    });

    $("#konghuifu").live("click", function () {
        var data = { act: 2, title_id: $("#titleId_h").val(), code: $("#verycode").val(), t: Math.random() };
        $.ajax(
            { url: "ajax/JieDa.aspx",
                type: "POST",
                async: false,
                data: data,
                success: function (json) {
                    json = eval('(' + json + ')');
                    art.dialog({ id: "fw34Ygr", width: 240, height: 50, content: json.msg, ok: true, okVal: "确定", time: 3, title: "三秒后自动关闭" });
                    location.href = location.href;
                }
            });
    });

    $(".r-list .item .hf-btn").click(function () {
        var prt = $(this).parents(".item");
        var rv_list = prt.find(".rv-list")
        if (rv_list.length > 0) {
            flag = rv_list.is(":hidden");
            $(".item .rv-list").hide(500);
            if (flag) {
                rv_list.show(500)
            }
            return;
        }
        var data = { act: 1, revert_id: prt.find("[type='hidden']").val(), t: Math.random() };
        rv_list = $("<div class='rv-list'></div>");
        var hf_box = $("<div class='hf-box'></div>");
        hf_box.append("<div><input name='rv_grade' type='radio' value='很好'/>很好<input name='rv_grade' type='radio' value='好'/>好<input name='rv_grade' type='radio' value='较好' />较好<input name='rv_grade' type='radio' value='一般' />一般<input name='rv_grade' type='radio' value='较差' />较差<input name='rv_grade' type='radio' value='差' />差<input name='rv_grade' type='radio' value='很差' />很差</div>")
        hf_box.append("<div><textarea></textarea></div><div style='text-algin:right'><input type='button' value='提交评论' class='hf-sub'/></div>");
        rv_list.append(hf_box);

        $(".item .rv-list").hide(500);
        $.ajax(
            { url: "ajax/jiedapinglun.aspx",
                type: "GET",
                data: data,
                context: $(this).parent(),
                success: function (json) {
                    json = eval('(' + json + ')');
                    rv_list.append(json.html).hide();
                    this.append(rv_list);
                    rv_list.show(500);
                }
            });
    })
    $(".r-list .item .zt-btn").click(function () {
        var prt = $(this).parents(".item");
        var data = { act: 3, revert_id: prt.find("[type='hidden']").val(), t: Math.random() };
        $.ajax(
            { url: "ajax/jiedapinglun.aspx",
                type: "GET",
                data: data,
                context: $(this).parent(),
                success: function (json) {
                    json = eval('(' + json + ')');
                    if (json.state == 1) {
                        alert("评价成功！");
                        this.find(".zt-btn").html("（" + json.zt + "）");
                        this.find(".fd-btn").html("（" + json.fd + "）");
                    }
                    else {
                        alert("您已评价过，谢谢！");
                    }
                }
            });
    })
    $(".r-list .item .fd-btn").click(function () {
        var prt = $(this).parents(".item");
        var data = { act: 4, revert_id: prt.find("[type='hidden']").val(), t: Math.random() };
        $.ajax(
            { url: "ajax/jiedapinglun.aspx",
                type: "GET",
                data: data,
                context: $(this).parent(),
                success: function (json) {
                    json = eval('(' + json + ')');
                    if (json.state == 1) {
                        alert("评价成功！");
                        this.find(".zt-btn").html("（" + json.zt + "）");
                        this.find(".fd-btn").html("（" + json.fd + "）");
                    }
                    else {
                        alert("您已评价过，谢谢！");
                    }
                }
            });
    });
    //    $(".r-list .item .setbest").click(function () {
    //        var prt = $(this).parents(".item");
    //        var url = "dis_csaimoney.aspx?title_id=" + $("#titleId_h").val();
    //        art.dialog({ id: "fde43g", width: 240, height: 50, content: "您确定设置解答为最佳解答？", okVal: "确定"
    //        , cancel: true
    //        , ok: function () {
    //            var data = { revert_id: prt.find("[type='hidden']").val(), t: Math.random() };
    //            $.ajax({ url: "ajax/setbest.aspx",
    //                type: "GET",
    //                data: data,
    //                success: function (json) {
    //                    json = eval('(' + json + ')');
    //                    if (json.state == 1) {
    //                        $(".item a.setbest").remove();
    //                        art.dialog.open(url, { id: 'fd3fdf', title: '分配希赛币', width: 680, height: 400, resize: false });
    //                    }
    //                    else if (json.state == 2) {
    //                        $(".item a.setbest").remove();
    //                        art.dialog({ id: "fw34gr", width: 240, height: 50, content: json.msg, ok: true, okVal: "确定" });
    //                        location.href = location.href;
    //                    }
    //                    else {
    //                        art.dialog({ id: "fw34gr", width: 240, height: 50, content: json.msg, ok: true, okVal: "确定" });
    //                        location.href = 'http://www.educity.cn/usercenter/login.aspx?page=' + escape(location.href);
    //                    }
    //                }
    //            });
    //        }
    //        });



    //    });
    $(".r-list .item .xg-btn").click(function () {
        var prt = $(this).parents(".item");
        var url = "modify_revert.aspx?revert_id=" + prt.find("[type='hidden']").val();
        art.dialog.open(url, { id: 'OKA51e4', title: '修改解答', width: 680, height: 500, resize: false });
    })
    $(".hf-box input[type='button']").live("click", function () {
        var item = $(this).parents(".item");
        var prt = $(this).parents(".hf-box");
        var data = { revert_id: item.find("[type='hidden']").val()
        , rv_grade: prt.find("input:radio:checked").val()
        , rv_text: prt.find("textarea").val()
        , t: Math.random()
        };
        if (data.rv_grade == null) {
            alert("请选择评价等级。");
            return;
        }
        if ($.trim(data.rv_text) == "") {
            alert("请输入评价内容。")
            return;
        }

        $.ajax(
            { url: "ajax/review.aspx",
                type: "POST",
                data: data,
                success: function (json) {
                    json = eval('(' + json + ')');
                    if (json.state == 1) {
                        alert(json.msg);
                        prt.find("textarea").val("");
                        location.href = location.href;
                    }
                    else if (json.state == 0) {
                        alert(json.msg);
                    }
                    else {
                        alert(json.msg);
                        location.href = 'http://www.educity.cn/usercenter/login.aspx?page=' + escape(location.href);
                    }
                }
            });
    });


    $("#alter").click(function () {
        var url = "modify_ask.aspx?title_id=" + $("#titleId_h").val();
        art.dialog.open(url, { id: 'OKA51e4', title: '修改问题', width: 680, height: 500, resize: false });
    });
    $("#del").click(function () {
        art.dialog({ id: "fdes43g", width: 240, height: 50, content: "您确定删除该问题？", okVal: "确定"
        , cancel: true
        , ok: function () {
            var data = { title_id: $("#titleId_h").val(), t: Math.random() };
            $.ajax({ url: "ajax/deltitle.aspx",
                type: "GET",
                data: data,
                success: function (json) {
                    json = eval('(' + json + ')');
                    if (json.state == 1) {
                        art.dialog({ id: 'fd3afdf', width: 240, height: 50, content: json.msg, resize: false });
                        window.location.href = "/wenda/";
                    }
                }
            });
        }
        });
    });

})



function jiesuanShow() {
    document.getElementById("buchong1").style.display = "block";
}
function checkidlist(id) {
    var list = document.getElementById("answeridlist").value.split(",");
    for (var i = 0; i < list.length; i++) {
        if (list[i] == id)
            return true;
    }
    return false;
}
function jietie_ddlchange() {
    var list = document.getElementsByName("ddlfenshu");
    var sum = 0;
    var str = "";
    for (var i = 0; i < list.length; i++) {
        str += "," + list[i].value;
        sum += parseInt(list[i].value);
    }
    document.getElementById("sumjiesuan").innerHTML = sum;
    document.getElementById("Bilvlist").value = str;

}
function Add_jiesuan(username, userid, answerid) {
    jiesuanShow();
    if (!checkidlist(answerid)) {
        // alert($("#jiesuantable").html())
        var table = document.getElementById("jiesuantable");
        var num = table.rows.length;
        var row = table.insertRow(table.rows.length);
        row.insertCell(row.cells.length).innerHTML = "付给 " + username;
        row.insertCell(row.cells.length).innerHTML = "<select name='ddlfenshu' onchange='jietie_ddlchange()'><option value='100'>100%</option><option value='90'>90%</option><option value='80'>80%</option><option value='70'>70%</option><option value='60'>60%</option><option value='50'>50%</option><option value='40'>40%</option><option value='30'>30%</option><option value='20'>20%</option><option value='10'>10%</option><option value='0' selected>0%</option></select>";
        row.insertCell(row.cells.length).innerHTML = "<a onclick='deleteRow(" + num + "," + answerid + ")' >删除</a> ";
        document.getElementById("answeridlist").value += "," + answerid;
        var sumcount = parseInt(document.getElementById("sumCount").innerHTML) + 1;

        document.getElementById("sumCount").innerHTML = sumcount;
        if (sumcount != 0)
            document.getElementById("jiesuantable_count").style.display = "block";
    }
}
function deleteRow(num, id) {
    document.getElementById("jiesuantable").deleteRow(num);
    var list = document.getElementById("answeridlist").value.split(",");
    var str = "";
    for (var i = 1; i < list.length; i++) {
        if (list[i] != id)
            str += "," + list[i];
    }
    document.getElementById("answeridlist").value = str;
    jietie_ddlchange();
    var sumcount = parseInt(document.getElementById("sumCount").innerHTML) - 1;
    document.getElementById("sumCount").innerHTML = sumcount;
    if (sumcount == 0)
        document.getElementById("jiesuantable_count").style.display = "none";
}
function jiesuan_Submit() {
    if (document.getElementById("answeridlist").value == "") {
        alert("请选择最佳答案");
        return false;
    }
    jietie_ddlchange();
    var sum = parseInt(document.getElementById("sumjiesuan").innerHTML);
    var list = document.getElementsByName("ddlfenshu");

    for (var i = 0; i < list.length; i++) {
        if (list[i].value == "0") {
            alert("请删除比率为0的答案!");
            return false;
        }
    }
    if (sum != 100) {
        alert("总比率不等于100%!");
        return false;
    }
    art.dialog({ id: "fde43g", width: 240, height: 50, content: "您确定设置解答为最佳解答？", okVal: "确定"
                , cancel: true
                , ok: function () {
                    var data = { title_id: $("#titleId_h").val(), revert_ids: $("#answeridlist").val(), bilvlists: $("#Bilvlist").val(), t: Math.random() };
                    $.ajax({ url: "ajax/setbest2.aspx", //有悬赏，可采纳多个答案，分钱
                        type: "GET",
                        data: data,
                        success: function (json) {
                            json = eval('(' + json + ')');
                            if (json.state == 1) {
                                art.dialog({ id: "fw34gr", width: 240, height: 50, content: json.msg, ok: true, okVal: "确定" });
                                location.href = location.href;
                            }
                            else {
                                art.dialog({ id: "fw34gr", width: 240, height: 50, content: json.msg, ok: true, okVal: "确定" });
                                location.href = location.href;
                            }
                        }
                    });
                }
    });
}
function CaiNa(obj) {
    var prt = $(obj).parents(".item");
    art.dialog({ id: "fde43g", width: 240, height: 50, content: "您确定设置解答为最佳解答？", okVal: "确定"
                , cancel: true
                , ok: function () {
                    var data = { revert_id: prt.find("[type='hidden']").val(), t: Math.random() };
                    $.ajax({ url: "ajax/setbest.aspx", //无悬赏只采纳一个答案
                        type: "GET",
                        data: data,
                        success: function (json) {
                            json = eval('(' + json + ')');
                            if (json.state == 2) {
                                $(".item a.setbest").remove();
                                art.dialog({ id: "fw34gr", width: 240, height: 50, content: json.msg, ok: true, okVal: "确定" });
                                location.href = location.href;
                            }
                            else {
                                art.dialog({ id: "fw34gr", width: 240, height: 50, content: json.msg, ok: true, okVal: "确定" });
                                location.href = 'http://www.educity.cn/usercenter/login.aspx?page=' + escape(location.href);
                            }
                        }
                    });
                }
    });
}

function setReply(louNum) {
    var html = "<fieldset><legend class=\"font_bold\">引用:</legend><p>";
    html = html + document.getElementById("content_" + louNum).innerHTML + "</p></fieldset>";

    document.getElementById("jd_btn").focus();
    editor.execCommand("inserthtml", html);

}