function gets_value(str,type) {
document.getElementById("WUCTop1_stype").innerHTML = str;
sh();
document.getElementById("Select1").value = type;
}
function sh() {
document.getElementById('WUCTop1_hh').style.display = document.getElementById('WUCTop1_hh').style.display ? "" : "none"
}

function msh() {
document.getElementById('menuss').style.display = document.getElementById('menuss').style.display == "none" ? "inline" : "none"
}

$('.usermenu').mouseleave(function() {
  $(this).find('.menulist').hide();
});

$('.search').mouseleave(function() {
  $(this).find('.classlistt').hide();
});