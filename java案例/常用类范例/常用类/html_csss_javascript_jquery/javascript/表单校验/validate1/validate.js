function validate(){
	var loginUsername=document.getElementById("loginUsername");
	var text=loginUsername.value;
	if(text==null||text==""){
		return false;
	}
	return true;
	
}