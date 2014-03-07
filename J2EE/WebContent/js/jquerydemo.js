//获取第一个form元素的action属性
$("form").attr("action");

//设置src属性
$("#icon").attr("src","icon.gif");

//一次性设置4个属性
$("#banner").attr(					
	{
		src:"banner.gif",
		alt:"Advertisement",
		width:720,
		height:64
	}
);
//让所有链接在新窗口打开
$("a").attr("target","_blank");

//站内链接本窗口打开,站外链接新窗口打开
$("a").attr("target",function(){	
	if(this.host == location.host)
		return "_self";
	else
		return "_blank";
});

//获取第一个h1的字体重量
$("h1").css("font-weight");
//获取第一个h1的字体重量
$("h1").css("fontWeight");
//错误:不可获取复合样式
$("h1").css("font");
//将样式设置到所有h1元素上
$("h1").css("font-variant","smallcaps");

$("h1").addClass("hilite");		//给所有h1元素添加一个类
$("h1+p").addClass("hilite first"); //给h1后面的p元素添加2个类
$("p").removeClass("hilite");	//从所有p元素中删除一个类
$("p").removeClass("hilite first");//一次删除多个类


//getValue from form-element
//获取元素的值
$("#username").val();
//获取被选中的单选按钮的值
$("input:radio[name=ship]:checked").val();

//获取页面标题
$("head title").text();
//获取第一个h1元素的html内容
$("h1").html();
//计算一个新值
$("h1").text(function(n,current){
	return "$"+n+"."+current;
});

//获取元素的当前位置
var position = $("#people").offset();
position.top += 100;
//重新设置元素的位置
$("people").offset(position);


var Ele_body = $("body");
var content_width = Ele_body.width();
var padding_width = Ele_body.innerWidth();
var dadding_witdh = Ele_body.outerWidth();
console.log(content_width +"="+padding_width +"="+dadding_witdh );


var w= $(window);
var page_size = w.height();
var scroll_pos = w.scrollTop();
w.scrollTop(scroll_pos + page_size);


$("div").data("x",1);
var x=$("div").data("x");
$("div").removeData();


window.onload=function(){
	//给文档结尾添加一个带有linklist id的新div
	$("document.body").append("<div id='linklist'><h1>all link</h1></div>");
	//将文档中的所有链接复制并插入该新div中
	$("a").clone().appendTo("#linklist");
	//每个标签都显示一个换行
	$("#linklist > a").after("<br/>"); 
};


window.onload=function(){
	//用<i>元素包装所有h1元素
	//产生 <i><h1>..</h1></i>
	$("h1").wrap(document.createElement("i"));
	//包装所有h1元素的内容,适用字符串参数更简单
	//产生<h1><i>....</i></h1>
	$("h1").wrapInner("<i/>");
	//将第一个段落包装在一个锚点和div里
	$("body>p:first").wrap("<a name='lead'><div class='first'></div></a>");
	//将所有其他段落包装在另一个div里
	$("body>p:not(:first)").warpAll("<div class='rest'></div>");
};