
/*
 *通过JS动态创建一个DIV，并设置一些内容，然后插入到文档的最后面
 */

function insertDiv(){
	var div = document.createElement("div");
	div.setAttribute("style","border:1px solid #F00; width:200px; height:30px;text-align:center");
	if(div.textContent){
		div.textContent ="这事JS创建的DIV";
	}else{
		div.innerText ="这事JS创建的DIV";
	}
	document.documentElement.appendChild(div);
}
insert();
=======
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

