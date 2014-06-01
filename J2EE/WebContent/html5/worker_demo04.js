onmessage=function(event){
	var arr =new Array(1000);
	for(var i=0;i<arr.length;i++){
		arr[i] =parseInt(Math.random()*1000);
	}

	var work_01 ;
	//chrome 34.0.1847.131 下貌似不支持
	//ff29下可以
	work_01= new Worker("worker_demo04_01.js");
	work_01.postMessage(JSON.stringify(arr));
	work_01.onmessage=function(event){
		postMessage(event.data);
	}
}