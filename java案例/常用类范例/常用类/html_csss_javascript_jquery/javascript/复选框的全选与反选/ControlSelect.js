var flag=true;
function allSelect(){
	var tableSelect=document.getElementsByName("tableSelect");
	for(var i=0;i<tableSelect.length;i++){
		tableSelect[i].checked=flag;
	}
	if(flag){
		flag=false;
	}else{
		flag=true;
	}
}

function contrarySelect(){
	var tableSelect=document.getElementsByName("tableSelect");
	for(var i=0;i<tableSelect.length;i++){
		if(tableSelect[i].checked){
			tableSelect[i].checked=false;
		}else{
			tableSelect[i].checked=true;
		}
	}
}
