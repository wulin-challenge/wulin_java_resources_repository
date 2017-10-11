var time=10;
function propocol(){
	var threeDiv=document.getElementById("threeDiv");
	threeDiv.firstChild.nodeValue=time;
	if(time>0){
		window.setTimeout("propocol()",1000);//这条语句他不锁定线程,仅仅起到定时作用,也就是每隔1000秒启动一个线程执行该propocol()函数
		time--;
	}else{
	setDisabled();
	}
}

function setDisabled(){
	document.getElementsByName("input1")[1].disabled=false;
}