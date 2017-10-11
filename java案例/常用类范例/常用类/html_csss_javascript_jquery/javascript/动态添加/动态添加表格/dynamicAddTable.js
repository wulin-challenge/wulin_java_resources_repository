var i=2;
function addTable(){
	var firstTable=document.getElementById("firstTable");
	var newRow=firstTable.insertRow(2);
	var cell1=newRow.insertCell(0);
	var cell2=newRow.insertCell(1);
	var cell3=newRow.insertCell(3);
	cell1.innerHTML="NEW CELL1";
	cell2.innerHTML="NEW CELL2";
	cell3.innerHTML="NEW CELL3";
	i++;
}