function testeach1(){
	var mem = ['a','b','c'];
	var returnvalue = $.each(mem, function(index) {
	    alert(index);
	});	
	
	conosle.log(returnvalue);
	return returnvalue;
}
function testeach2(){
	var mem = ['a','b','c'];
	var returnvalue = $.each(mem, function(index,value) {
	    alert(index+" <=> "+value);
	});
	conosle.log(returnvalue);
	return returnvalue;
}

$("form").attr("action");				//获取第一个form元素的action属性
$("#icon").attr("src","icon.gif");		//设置src属性
$("#banner").attr(						//一次性设置4个属性
	{
		src:"banner.gif",
		alt:"Advertisement",
		width:720,
		height:64
	}
);
$("a").attr("target","_blank");			//让所有链接在新窗口打开
$("a").attr("target",function(){		//站内链接本窗口打开,站外链接新窗口打开
	if(this.host == location.host)
		return "_self";
	else
		return "_blank";
});

$("h1").css("font-weight");		//获取第一个h1的字体重量
$("h1").css("fontWeight");		//获取第一个h1的字体重量
$("h1").css("font");			//错误:不可获取复合样式
$("h1").css("font-variant","smallcaps");	//将样式设置到所有h1元素上

$("h1").addClass("hilite");		//给所有h1元素添加一个类
$("h1+p").addClass("hilite first"); //给h1后面的p元素添加2个类
$("p").removeClass("hilite");	//从所有p元素中删除一个类
$("p").removeClass("hilite first");//一次删除多个类