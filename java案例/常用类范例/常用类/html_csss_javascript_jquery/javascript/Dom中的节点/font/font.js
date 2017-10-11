function controlFont(){
	var obj =document.getElementById("firstSelect");
	var selectedValue=obj.value;
	var secondDiv =document.getElementById("secondDiv");
	secondDiv.style.fontSize=selectedValue;
}