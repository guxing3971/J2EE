onmessage = function(event){
	//获取前台传递的数据
	var num = event.data;
	var result=0;
	for (var i =0; i <= num; i++) {
		result += i;
	};
	//将结果返回给前台
	postMessage(result);
}