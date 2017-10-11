var flag=false;
function sort(){
	var table=document.getElementById("firstTable");
	var row=table.rows;
	var cellLength=table.rows[0].cells.length;
	var tableArray=new Array();
	for(var i=1;i<row.length;i++){
		var rowArray=new Array();
		for(var j=0;j<cellLength;j++){
			rowArray[j]=row[i].cells[j].firstChild.nodeValue;
		}
		tableArray[i-1]=rowArray;
	}
	if(!flag){
		tableArray=arowsort(tableArray);
		flag=true;
	}else{
		tableArray=rowsort(tableArray);
		flag=false;
	}
	setValue(tableArray);

}

function setValue(tableArray){
	var table=document.getElementById("firstTable");
	var row=table.rows;
	var cellLength=table.rows[0].cells.length;
	for(var i=1;i<row.length;i++){
		for(var j=0;j<cellLength;j++){
			row[i].cells[j].firstChild.nodeValue=tableArray[i-1][j];
		}
		
	}
}

function rowsort(tableArray){
	
	for(var i=0;i<tableArray.length;i++){
		for(var j=i+1;j<tableArray.length;j++){
			if(tableArray[i][4]>tableArray[j][4]){
				var temp=tableArray[i];
				tableArray[i]=tableArray[j];
				tableArray[j]=temp;
			}
		}
	}
	return tableArray;
}

function arowsort(tableArray){
	
	for(var i=0;i<tableArray.length;i++){
		for(var j=i+1;j<tableArray.length;j++){
			if(tableArray[i][4]<tableArray[j][4]){
				var temp=tableArray[i];
				tableArray[i]=tableArray[j];
				tableArray[j]=temp;
			}
		}
	}
	return tableArray;
}

