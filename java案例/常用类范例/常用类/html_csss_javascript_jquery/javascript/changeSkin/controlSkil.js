var flag=true;
function controlTable(){
	var obj =document.getElementById("firstSelect");
	var selectedValue=obj.value;
	//alert(selectedValue);
	var secondDiv =document.getElementById("secondDiv");
	secondDiv.style.visibility=selectedValue;	
}

function controlSkil(){
	var link1=document.getElementById("link1");
	var selectedValue=document.getElementById("secondSelect").value;
	link1.setAttribute("href",selectedValue);
	setCookie("href",selectedValue,7);
	flag=false;
}

function setCookie(name,value,days){
	var date=new Date();
	date.setDate(date.getDate()+days);
	document.cookie=name+ "=" +escape(value)+
	((days==null) ? "" : ";expires="+date.toGMTString());
}

function getCookie(){
	var cook=document.cookie;
	var index=cook.indexOf("=");
	var sub=cook.substr(index+1);
	var link1=document.getElementById("link1");
	link1.setAttribute("href",sub);
}