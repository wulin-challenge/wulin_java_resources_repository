var errorJMSMessageList;

$(function(){
	
	errorJMSMessageList = $("#commonList").jqGrid({
        url: contextPath + "/errorJMSMessage",
        datatype: "json",
        autowidth: true,
        height:300,
        mtype: "GET",
        multiselect: true,
        colNames: ["ID", "描述","业务类型","执行次数", "发生时间","最近处理时间"],
        colModel: [
            { name: "id", index:"id",hidden: true},
			{ name: "describe", index:"describe", align:"center", sortable: false,searchoptions :{sopt:['eq','cn']}},
			{ name: "type", index:"type", align:"center", sortable: false,searchoptions :{sopt:['eq','cn']}},
			{ name: "zxcs", index:"zxcs", align:"center", sortable: true,searchoptions :{sopt:['gt','lt','eq','cn']}},
            { name: "createDate",width:200, index:"createDate",align:"center", searchoptions:{dataInit:PlatformUI.defaultJqueryUIDatePick,sopt:['gt','lt','eq','ge','le']}, sortable: true ,formatter:"date",formatoptions: { srcformat: "U", newformat: "Y-m-d H:i:s"} },
            {name: "zjclsj",width:200, index:"zjclsj",align:"center", searchoptions:{dataInit:PlatformUI.defaultJqueryUIDatePick,sopt:['gt','lt','eq','ge','le']}, sortable: true ,formatter:"date",formatoptions: { srcformat: "U", newformat: "Y-m-d H:i:s" }}
            ],
        pager: "#commonPager",
        rowNum: 10,
        rowList: [10, 20, 30],
        sortname:"createDate",
		sortorder:"desc",
        viewrecords: true,
        gridview: true,
        autoencode: true,
        caption: "错误消息管理列表"
    });
    
    //绑定检索事件
	$("#commonRetrieveBtn").click(function(){
		$("#commonSearchInput").val("");
		errorJMSMessageList.jqGrid("setGridParam", {
			postData: {filters:{}}
		});
		errorJMSMessageList.jqGrid('searchGrid', {multipleSearch:true,drag:false,searchOnEnter:true,top:150,left:200});
	});
	
	//绑定刷新事件
	$("#commonRefreshBtn").click(function(){
		location.href = "";
	});
	
	
	//绑定普通页面查询框体点击事件
	$("#commonSearchBtn").click(function(){
		commonInputSearch();
	});
	
	//绑定查询框回车事件
	$("#commonSearchInput").keyup(function(event){
		if(event.keyCode == 13){  
        	commonInputSearch(); 
        }
	});
	
	//绑定处理 事件
	$("#commonDisposeBtn").click(function(){
		var ids = errorJMSMessageList.jqGrid ('getGridParam', 'selarrrow');
		if(ids.length == 0){
			toastr.warning("请至少选择一条要处理的消息!");
			return;
		}
		//批量删除ajax
		$.messager.confirm('操作','请确认处理消息',function(r){
	    	if (r){
		        ajax({
					url: contextPath + "/errorJMSMessage/dispose",
					type: "post",
					data: {ids:ids},
					afterOperation: function(){
						PlatformUI.refreshGrid(errorJMSMessageList, {sortname:"createDate",sortorder:"desc"});
					}
				});
		    }
		});
		
	});
	
	//表单保存操作
	 $("#commonSaveBtn").click(function(){
	 	if(operation == "add"){
	 		adderrorJMSMessage();
	 	}else{
	 		updateerrorJMSMessage();
	 	}
	 });
	 
	  //表单重置操作
	$("#commonResetBtn").click(function(){
		$("#commonDetailForm")[0].reset();
		PlatformUI.validateForm("commonDetailForm");
	});
	
	//编辑按钮
	$("#commonShowEditBtn").click(function(){
		changeEditForm(true);
		var ids = errorJMSMessageList.jqGrid ('getGridParam', 'selarrrow');
		if(ids.length != 1){
			toastr.warning("选择一条要编辑的数据!");
			return;
		}
		currentEditId = ids[0];
		operation = "edit";
		ajax({
			url: contextPath + "/errorJMSMessage/" + ids[0],
			afterOperation: function(data, textStatus,jqXHR){
				showCommonDetailWindow();
				PlatformUI.populateForm("commonDetailForm", data);
				//填充复杂数据
				
				//验证表单
				PlatformUI.validateForm("commonDetailForm");
			}
		});
	});
	
	//查看按钮
	$("#commonViewBtn").click(function(){
		var ids = errorJMSMessageList.jqGrid ('getGridParam', 'selarrrow');
		if(ids.length != 1){
			toastr.warning("选择一条要查看的数据!");
			return;
		}
		ajax({
			url: contextPath + "/errorJMSMessage/" + ids[0],
			afterOperation: function(data, textStatus,jqXHR){
				showCommonDetailWindow();
				PlatformUI.populateForm("commonDetailForm", data);
				changeEditForm(false);
				//填充复杂数据
				
				//验证表单
				PlatformUI.validateForm("commonDetailForm");
			}
		});
	});
	
	//批量删除事件
	$("#commonDelBtn").click(function(){
		var ids = errorJMSMessageList.jqGrid ('getGridParam', 'selarrrow');
		if(ids.length == 0){
			toastr.warning("请至少选择一条要删除的数据!");
			return;
		}
		//批量删除ajax
		$.messager.confirm('操作','请确认删除数据',function(r){
	    	if (r){
		        ajax({
					url: contextPath + "/errorJMSMessage",
					type: "post",
					data: {_method:"delete",ids:ids},
					afterOperation: function(){
						PlatformUI.refreshGrid(errorJMSMessageList, {sortname:"createDate",sortorder:"desc"});
					}
				});
		    }
		});
	});
	
});


//*********************方法区**********************


//普通框体查询
function commonInputSearch(){
	var commonSearchInputValue = $("#commonSearchInput").val();
	var rules = [];
	if(commonSearchInputValue != ""){
		rules.push({"field":"type","op":"cn","data":commonSearchInputValue});
	}else{
		return;
	}
	var filters = {"groupOp":"AND","rules":rules};
	errorJMSMessageList.jqGrid("setGridParam", {
		postData: {filters:JSON.stringify(filters)},
		page: 1
	}).trigger("reloadGrid");
}

//弹出表单框体
function showCommonDetailWindow(){
	//表单重置
	$("#commonDetailForm")[0].reset();
	$("#commonDetailForm #id").val("");
	//验证表单
	PlatformUI.validateForm("commonDetailForm");
	$('#commonDetail').show();
	$('#commonDetail').window({
		title:"错误消息管理详细信息",
	    width:750,
	    height:250,
	    modal:true
	});
	//填充复杂字段信息
}


//新增
var adderrorJMSMessage = function(){
	if(PlatformUI.formIsValid("commonDetailForm")){//验证
 		//ajax保存
 		var params = $("#commonDetailForm").serialize();
 		ajax({
 			url: contextPath + "/errorJMSMessage",
 			type: "post",
 			data: params,
			afterOperation: function(){
				PlatformUI.refreshGrid(errorJMSMessageList, {sortname:"createDate",sortorder:"desc"});
				$("#commonDetailForm")[0].reset();
				$('#commonDetail').window('close');
			}
 		});
 	}else{
 		toastr.warning("表单验证失败");
 	}
}

//更新
var updateerrorJMSMessage = function(){
	if(PlatformUI.formIsValid("commonDetailForm")){
		//ajax更新
 		var params = $("#commonDetailForm").serialize();
 		ajax({
 			url: contextPath + "/errorJMSMessage/" + currentEditId,
 			type: "post",
 			data: params + "&_method=put",
			afterOperation: function(){
				PlatformUI.refreshGrid(errorJMSMessageList, {
					sortname:"createDate",
					sortorder:"desc",
					page:errorJMSMessageList.jqGrid("getGridParam").page
				});
				$("#commonDetailForm")[0].reset();
				$('#commonDetail').window('close');
			}
 		});
	}else{
 		toastr.warning("表单验证失败");
 	}
}

//查看/编辑form切换函数
function changeEditForm(flag){
	if(flag){
		$("#commonDetailBtnKit").show();
	}else{
		$("#commonDetailBtnKit").hide();
	}
	$("#commonDetailForm input").each(function(){
		$(this).attr("readOnly", !flag);
	});
}
