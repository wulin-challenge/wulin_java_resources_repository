var operation=null;
var number1=null;
var number2=null;
var flag1=false;
var flag2=false;
var flag3=false;

function counter1(i){
		
		
		if(i.toString().match("[0-9]+")&&number1==null&&!flag1){
			count(i);
			number1=countInt();
			flag1=true;
		}else if(i.toString().match("[0-9]+")&&number1!=null&&flag1&&!flag2){
			var countstr=countStr()+i.toString();
			count(countstr);
			number1=countInt();
		}
		if(i.toString().match("[0-9]+")&&number1!=null&&number2==null&&flag2&&!flag3){
			count("");
			count(i);
			number2=countInt();
			flag3=true;
		}else if(i.toString().match("[0-9]+")&&number2!=null&&number1!=null&&flag3){
			var countstr=countStr()+i.toString();
			count(countstr);
			number2=countInt();
		}
		if(i=="+"){
			if(operation==null){
				operation=i;
				flag2=true;
			}else{
			computer(operation);
			number2=null;
			operation=i;
			flag3=false;
			}
		}else if(i=="-"){
			if(operation==null){
				operation=i;
				flag2=true;
			}else{
			computer(operation);
			number2=null;
			operation=i;
			flag3=false;
			}
		}else if(i=="*"){
			if(operation==null){
				operation=i;
				flag2=true;
			}else{
			computer(operation);
			number2=null;
			flag3=false;
			operation=i;
			}
		}else if(i=="/"){
			if(operation==null){
				operation=i;
				flag2=true;
			}else{
			computer(operation);
			number2=null;
			flag3=false;
			operation=i;
			}
		}else if(i=="="){
			if(operation==null){
				alert("第一次必须输入数字");
			}else{
			computer(operation);
			number2=null;
			flag3=false;
			operation=null;
			}
		}else if(i=="清空"){
			count("");
			operation=null;
			number1=null;
			number2=null;
			flag1=false;
			flag2=false;
			flag3=false;
		}
		
}



function countStr(){
	return document.getElementById("counter").value;
}

function countInt(){
	return parseInt(document.getElementById("counter").value);
}

function count(v){
	document.getElementById("counter").value=v;
}

function computer(o){
	if(o=="+"){
		count(number1+number2);
		number1=number1+number2;
	}else if(o=="-"){
		count(number1-number2);
		number1=number1-number2;
	}else if(o=="*"){
		count(number1*number2);
		number1=number1*number2;
	}else if(o=="/"){
		count(number1/number2);
		number1=number1/number2;
	}
}