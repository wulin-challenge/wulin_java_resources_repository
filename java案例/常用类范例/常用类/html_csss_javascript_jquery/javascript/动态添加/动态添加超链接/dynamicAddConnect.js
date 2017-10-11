function addConnection(){
	var firstDiv=document.getElementById("firstDiv");
	var a=document.createElement("a");
	var textNode=document.createTextNode("请点击");
	firstDiv.appendChild(a);
	a.appendChild(textNode);
	a.href="dynamic.html";
}