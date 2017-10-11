function addTextNode(){
	var firstTextValue=document.getElementById("firstText").value;
	var firstDiv=document.getElementById("firstDiv");
	var div=document.createElement("div");
	var textNode=document.createTextNode(firstTextValue);
	firstDiv.appendChild(div);
	div.appendChild(textNode);
}