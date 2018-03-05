$(function(){
	$("#indicatorButton").click(function(e){
		//渲染Ztree的具体位置
		var dialogIndicator = $(".dialogDemo").dialogIndicator();
		
		var i = 0;
		var interval = setInterval(function(){
			dialogIndicator.setRadialIndicatorValue(i);
			if(i>=100){
				window.clearInterval(interval);
				dialogIndicator.destroyDialog();
			}
			i += 5;
		},1000);
		
		
	});
	
	$("#indicatorButton2").click(function(e){
		//渲染Ztree的具体位置
		var dialogIndicator = $(".dialogDemo2").dialogIndicator();
		
		dialogIndicator.progressInterval();
		
		var interval = setInterval(function(){
			var progressNumber = dialogIndicator.getProgressNumber();
			if(progressNumber == 10){
				dialogIndicator.setProgressNumber(100);
			}
		},100);
		
		
		
		
	});
});



