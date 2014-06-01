onmessage=function(event){
	if(event.data !=""){
		var arr = JSON.parse(event.data);
		var data ="";
		for(var i=0;i<arr.length;i++){
			if(parseInt(arr[i],10) %3 ==0){
				if(data !=""){
					data +=";"
				}
				data+=arr[i];
			}
		}
		postMessage(data);
	}
}