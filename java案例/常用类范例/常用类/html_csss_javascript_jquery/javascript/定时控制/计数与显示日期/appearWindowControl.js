var time=0;
var date=null;
var setTimeout2=null;
var setInterval23=null;
function setTimeout1(){
	var firstDiv=document.getElementById("firstDiv");
	firstDiv.firstChild.nodeValue=time;
	time++;
	setTimeout2=window.setTimeout("setTimeout1()",1000);
}

function clearTimeout1(){
	window.clearTimeout(setTimeout2);
}

function setInterval2(){
	setInterval23=window.setInterval("setInterval3()",50);
}

function setInterval3(){
	date=new Date();
	var secondDiv=document.getElementById("secondDiv");
	secondDiv.firstChild.nodeValue=date;
}

function clearInterval2(){
	window.clearInterval(setInterval23);
}
