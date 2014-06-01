onmessage=function(event){
	console.log("Thread is running");
	var data="";
	var arr = event.data.split(";");
	for(var i=0;i<arr.length;i++){
		if(parseInt(arr[i],10) %3 ==0){
			if(data!=""){
				data+=";";
			}
			data +=arr[i];
		}
	}
	console.log(data);
	postMessage(data);
}