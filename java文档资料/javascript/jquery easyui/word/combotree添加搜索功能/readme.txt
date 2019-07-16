combotree-query.js 是经过自己修改的,添加了 customFilters 属性,以实现是否搜索可自定义

用法案例:

//根据父级码值加载码表形成comboTree
	this.loadSystemCodeToComboTreeByParentCode = function(inputId,inputNameId,parentCode, options){
		var defaultOptions = {
			url: contextPath + "/code/children/code2",
		    method:"get",
		    queryParams:{code: parentCode},
		    editable: true,
		    customFilters:{
		    	isFilter: true,
		    	filterFields:["text","chineseChar"]
		    },
		    loadFilter: function(data){
		    	return me.formatEasyUITreeData(data);//格式化数据
		    },
		    onChange: function (newValue,oldValue) {
		    	changeCombox(inputId,inputNameId,newValue,oldValue);
			}
		};
		
		var allOptions = $.extend(true, defaultOptions, options);
		var combotree =  $("#" + inputId).combotree(allOptions);
		return combotree;
	}