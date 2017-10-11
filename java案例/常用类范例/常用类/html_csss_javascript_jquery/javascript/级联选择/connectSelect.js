
function province(){
	var cityTwo=allCity();
	var province=document.getElementsByName("province2");
	var city=document.getElementById("city");
	var provinceValue=province[0].value;
	var provinceName=province[0].options[province[0].selectedIndex].firstChild.nodeValue;
	deleteChildNode(province[1],cityTwo);
	autoProducePlease(province[1]);
	for(var i=0;i<cityTwo.length;i++){
		if(cityTwo[i][0]==provinceName){
			for(var j=0;j<cityTwo[i].length-1;j++){
				autoProduceCity(province[1],cityTwo[i][j+1]);
			}
		}
	}
}
function deleteChildNode(province,cityTwo){
	var childNumber=province.options.length;
	for(var i=0;i<childNumber;i++){
		province.removeChild(province.options[0]);
	}
}

function autoProducePlease(province){
	var option=document.createElement("option");
	var text=document.createTextNode("请选择");
	option.appendChild(text);
	province.appendChild(option);
}

function autoProduceCity(province,value){
	var option=document.createElement("option");
	var text=document.createTextNode(value);
	option.appendChild(text);
	province.appendChild(option);
}

function allCity(){
	var cityTwo=new Array();
	var cityBJ=new Array();
		cityBJ[0]="北京";
		cityBJ[1]="北京市东";
		cityBJ[2]="北京市南";
	var citySC=new Array();
		citySC[0]="四川";
		citySC[1]="成都";
		citySC[2]="绵阳";
		citySC[3]="泸州";
	var cityGD=new Array();
		cityGD[0]="广东";
		cityGD[1]="广州";
		cityGD[2]="深圳";
		cityGD[3]="珠海";
		cityGD[4]="汕头";
		cityGD[5]="汕尾";
		cityGD[6]="惠州";
	var cityZJ=new Array();
		cityZJ[0]="浙江";
		cityZJ[1]="杭州";
		cityZJ[2]="宁波";
		cityZJ[3]="温州";
		cityZJ[4]="大城";
		
		cityTwo[0]=cityBJ;
		cityTwo[1]=citySC;
		cityTwo[2]=cityGD;
		cityTwo[3]=cityZJ;
	return cityTwo;
}