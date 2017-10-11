var time=null;
var srcPath=null;
function replace(){
	mySrc();
	setNumber();
}

function mySrc(){
	srcPath=["./image/dress1.png","./image/dress2.png","./image/dress3.png","./image/dress4.png","./image/dress5.png","./image/dress6.png","./image/dress7.png","./image/dress8.png","./image/dress9.png","./image/dress10.png"];
	time=srcPath.length-1;
}

function setNumber(){
	var firstImg=document.getElementById("firstImg");
	firstImg.src=srcPath[time];
	window.setTimeout("setNumber()",1000);
	if(time<=0){
		time=srcPath.length-1;
	}else{
	time--;
	}
}