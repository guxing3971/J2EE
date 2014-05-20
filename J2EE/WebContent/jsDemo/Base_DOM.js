/***
 * DOM与JavaScript
 */

/**
 * JavaScript获取DOM元素的方式。
 * 	JavaScript可以使用如下几种方式获取DOM元素
 * 		•用指定的id属性
 *		•用指定的name属性
 *		•用指定的标签名字
 *		•用指定的css类
 *		•匹配指定的CSS选择器
 */

/*
 * 用指定的ID属性获取
 * 	document.getElementById()
 * 	因为HTML页面中没有元素都可以有id属性，并且整个页面中id属性的值必须是唯一的
 */
//获取页面中id=”one"的元素
var obj = document.getElementById("one");
//利用该方法进行扩展，一次获取多个元素
function getElementsByIdList(){
	//利用函数arguments这一特性一次获得多个元素
	var elements = {};
	for(var i =0;i<arguments;i++){
		var id=arguments[i];
		var elt = document.getElementById(id);
		if(!elt){
			//如果找到对应的值则抛出异常
			throw new Error("document not element with id:"+id);
		}
		elements[id]=elt;//完成映射
	}
	return elements;
}


/*
 * 用指定的name属性
 * Html的name属性最初打算是为表单元素分配名字，
 * 在表单数据提交到服务器时使用该属性的值。类似id属性，
 * 那么是给元素分配名字，但是区别于id，name属性的值不是必须唯一：
 * 多个元素可能有同样的名字，而其和id不一样的是name属性只能在少数html元素中有效，
 * 包括表单，表单元素,iframe和img元素。
 */
//获取页面上name=one的元素
var one = document.getElementsByName("one");
//<form name="login" action="xx.do">
var form =document.login;

/*
 * 用指定的标签名字
 * 	使用html标签名获取一组DOM对象
 */
//获取页面上所有的A标签
var Tag_a = document.getElementsByTagName("a");
//获取所有页面的图片，并打印其链接
Array.prototype.map.call(document.images,function(e){console.log(e.src);});
/*
 * 用指定的css类
 * 	Html元素的class属性值是一个以空格隔开的列表，
 * 	可以为空或包含多个标识符。它是用来描述html元素的表现形式的。
 * 	可以使用getElementsByClassName()方法，它基于class属性值中标识符来选取元素。
 */
//查找class属性中包含two的元素
var two = document.getElementsByClassName("two");
//查找id=log元素下的子元素中包class值中有error 和 fatal的元素
var elts = document.getElementById("log") 
			&& document.getElementById("log")
			.getElementsByClassName("error fatal");

/*
 * 匹配指定的CSS选择器
 * 	使用API querySelectorAll和querySelector可以以CSS选择器为参数选取文档元素
 * 	这俩个API都是定义在节点上，所以可以获取某元素的孙子元素
 */
//获取页面上class=column的元素
var column = document.querySelectorAll(".column");
//获取class=column的元素下的class="list"的孙子元素
column = document.querySelectorAll(".list");

//====================获取HTML属性==========================
/**
 * 获取标准的html属性
 * 	·表示HTML文档元素的HTMLElement对象定义了读、些属性，
 * 	它们映射了元素的HTML属性，HTMLElement定义了通用的HTTP属性，如id等，
 * 	以及事件除了程序属性，特定的Element子类型为其元素定义了特定的属性。
 * 	例如查询一张图片的URL。
 *	·HTML属性名不区分大小写，但是JavaScript属性则是大小写敏感，
 *	从HTML属性名转换成JavaScript属性名应该采用小写。但是如果属性名包含不止一个单词，
 *	则除了第一个单词以外的单词的首字母大写，例如defaultChecked/tabIndex
 *	·有些html属性名在JavaScript中是保留字，
 *	对于这些属性，一般的规则是为属性名加前缀“html”。
 *	例如html的for属性在javascript中编程htmlFor属性。
 *	·Class在javaScript是保留字，但是它比较特殊，所以javaScript中经它便成了className。
 * 	
 */
var  image = document.getElementById("myiamge");
var imgurl = image.src;	//src属性是图片的url
image.id === "myimage";
var form = document.forms[0];
form.action="http://www.example.com/submit.do";	//设置form的提交地址
form.method ="POST";
/*
 * 获取非标准的html属性
 * 	Element对象定义如下方法用来玩属性的获取设置检查已经删除
 * 		·getAttribute()
 * 		·setAttribute()
 * 		·hasAttribute()
 * 		·removeAttribute()
 */
//<a id="a" href="xxxx">xxx</a>
var a = document.getElementById("a");
//获得a标签的href属性
var a_href = a.href;
var a_href = a.getAttribute("href");
//为a设置class="link"
a.setAttribute("class", "link");
if(a.hasAttribute("onClick")){
	console.log("该标签有onclick属性");
	//删除onclick属性
	a.removeAttribute("onClick");
}




/*
 * 获取数据属性
 * Html5提供了一个解决方法，在html5文档中，任意以“data-“为前缀的小写的属性名字都是合法的。
 * 这些数据集属性将不会对元素的表现产生影响。它们定义了一个中标准的，附加额外数据的方法。
 * 还在Element对象上定义了dataset属性，该属性指代了一个对象，
 * 它的各个属性对应于去掉前缀的data-属性。带连字符的属性对应于驼峰命名的属性。
 *	例如：
 *		dataset.x应该保存data-x属性的值
 *		data-jquert-test属性就dataset.jqueryTest属性
 *	
 */
//<span class="spr" data-yin="10.0" data-yout="-10.0"></span>
var span = document.getElementsByClassName("spr");
for(var i=0;i<span.length;i++){
	var dataset = span[i].dataset;
	var yin = parseFload(dataset.yin);
	var yout = parseFload(dataset.yout);
	console.log("yin:"+yin+"yout:"+yout);
}
//===========================创建、删除、替换节点==========================
/**
 * Document类型定义了创建Element和Text对象的方法。
 * Node类型定义了在节点书中插入，删除和替换的方法。
 */

/*
 * 动态记载JS脚本，并执行 
 */
function loadsync(url){
	//创建script节点
	var script = document.createElement("script");
	//设置script节点的属性
	script.src=url;
	//将节点插入到文档树种
	var head = document.getElementByTagName("head")[0];
	head.append(script);
}



















