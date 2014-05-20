/*
 * JS函数重载
 * 	利用JavaScript中每个函数都一个上下文相关的变量argument，实现函数的重载
 */
function sendMessage(msg,obj){
	if(argument.length == 2){
		obj.handle(msg);
	}else{
		console.log(msg);
	}
}