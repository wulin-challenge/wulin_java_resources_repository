
$(function(){
	var name=$("#westLeft").attr("name");
	if(name="westLeft"){
		$.ajax({
			  url: "/myAO/TestServlet?judge=left",
			  cache: false,
			  success: function(html){
			    $("#firstPageWest").append(html);
			  }
			});
		}

});

$(function() {
	var p = $('#myFirstPageLayout').layout('panel', 'west').panel( {
		onCollapse : function() {
			alert('collapse');
		}
	});
});

function addPage(){
	$.ajax({
		  url: "/myAO/TestServlet?judge=secondPanel",
		  cache: false,
		  success: function(html){
		    $("#tab2").append(html);
		  }
		});
	
}

$(function(){
	$('#tt2').datagrid({
		title:'My Title',
		iconCls:'icon-save',
		width:600,
		height:350,
		nowrap: false,
		striped: true,
		fit: true,
		url:'/myAO/jsAndStyle/script/myJs/datagrid_data.json',
		sortName: 'code',
		sortOrder: 'desc',
		idField:'code',
		frozenColumns:[[
            {field:'ck',checkbox:true},
            {title:'code',field:'code',width:80,sortable:true}
		]],
		columns:[[
	        {title:'Base Information',colspan:3},
			{field:'opt',title:'Operation',width:100,align:'center', rowspan:2,
				formatter:function(value,rec){
					return '<span style="color:red">Edit Delete</span>';
				}
			}
		],[
			{field:'name',title:'Name',width:120},
			{field:'addr',title:'Address',width:120,rowspan:2,sortable:true},
			{field:'col4',title:'Col41',width:150,rowspan:2}
		]],
		pagination:true,
		rownumbers:true
	});
});