$(document).ready(function () {
    if (document.getElementById("HidXGtjzj").value == "1") {
        ajaxClickXG("tjzj", document.getElementById("Hidtypeid").value, document.getElementById("Hidgradeid").value, document.getElementById("Hidclassid").value);
    }
    if (document.getElementById("HidXGzxwt").value == "1") {
        ajaxClickXG("zxwt", document.getElementById("Hidtypeid").value, document.getElementById("Hidgradeid").value, document.getElementById("Hidclassid").value);
    }
//    if (document.getElementById("HidXGzxjd").value == "1") {
//        ajaxClickXG("zxjd", document.getElementById("Hidtypeid").value, document.getElementById("Hidgradeid").value, document.getElementById("Hidclassid").value);
    //    }
    if (document.getElementById("HidXGzxsp").value == "1") {
        ajaxClickXG("zxsp", document.getElementById("Hidtypeid").value, document.getElementById("Hidgradeid").value, document.getElementById("Hidclassid").value);
    }
    if (document.getElementById("HidXGtjjc").value == "1") {
        ajaxClickXG("tjjc", document.getElementById("Hidtypeid").value, document.getElementById("Hidgradeid").value, document.getElementById("Hidclassid").value);
    }
});
function ajaxClickXG(type, typeid, gradeid, classid) {
    $.ajax({
        type: "get",
        url: "ajax/CreateXiangguan.aspx?type=" + type + "&typeid=" + typeid + "&gradeid=" + gradeid + "&classid=" + classid + "&t=" + Math.random(),
        success: function (data, textStatus) {
        }
    });
}