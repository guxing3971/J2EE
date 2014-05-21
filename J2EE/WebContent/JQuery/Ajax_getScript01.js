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