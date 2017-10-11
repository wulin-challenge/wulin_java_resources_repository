 //通过dom动态生成element元素，并动态加载
 var objQQForm;
 function init()
 {
    //创建dom元素
    objQQForm = document.createElement("div");
    //设置元素属性
    objQQForm.style.width="100px";
    objQQForm.style.height="100px";
    objQQForm.style.bgcolor="Orange";
    objQQForm.style.position="absolute";
    objQQForm.style.left = 1150;
    objQQForm.style.top = 470;
    //由于需要在所有层至上，设置zindex属性
    objQQForm.style.zIndex=1002;
    //设置dom元素内容
    objQQForm.innerHTML = "<a href='http://wpa.qq.com/msgrd?V=1&Uin=524270754&Site=学云网&Menu=yes'><img style='border:0px;' src='images/services.jpg'/></a>";
    //动态加载
    document.body.appendChild(objQQForm);

}
function showQQ()
{
    //通过onscoll事件调用该方法，保证其顶坐标
   objQQForm.style.top = document.documentElement.scrollTop +470;
}

//调用初始化方法
init();