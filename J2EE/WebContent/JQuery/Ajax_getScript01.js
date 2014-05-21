//在加载该JS的页面输出一个div
function insertDiv(){
	var text ="这是引用的JS创建的DIV";
	var style ="border:1px solid;background:#bbb;"+
				"width:300px;height:30px;text-aglin:cneter";
	var div = document.createElement("div");
	div.setAttribute("style",style);
	if(div.textContent){
		div.textContent=text;
	}else{
		div.innerText=text;
	}
	document.documentElement.appendChild(div);
}
setInterval(insertDiv,3000);