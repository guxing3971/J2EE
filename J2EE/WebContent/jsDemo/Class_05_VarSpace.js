/*
 * JS作用域
 * 作用域是JavaScript中一个比较难处理的特性，
 * 所有面向对象的编程语言都有某种形式的作用域，
 * 这要看是什么上下文约束着作用域。在JavaScript里，
 * 作用域由函数约束，而不是语句块约束。
 */

//定义一个全局的变量
var global = "global variable";
//在语句块中进行修改
if(1){
	alert(global);
	var global="in if";
	alert(global);
}
alert(global);
//在函数中修改
function test(){
	alert(global);
	var global ="in function";
	alert(global);
}
alert(global);
/*
 * 在浏览器中全局变量会，被当作window对象的属性，这是个有意思的实现
 */
//隐身声明全局变量
function test1(){
	foo="this's global variable";
}
test1();
alert(window.foo);

