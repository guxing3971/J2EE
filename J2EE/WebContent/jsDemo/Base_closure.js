/*
 * JS闭包
 * 	•闭包就是函数的局部变量集合，只是这些局部变量在函数返回会继续存在
 *	•闭包就是函数的“堆栈”在函数返回后并不释放
 *	•当在一个函数内定义另外一个函数就会产生闭包。
 */
 //=====================闭包=====================
 function foo(){
 	//local variable
 	var a=2;

 	//method
 	function closure(x){
 		//访问外部变量
 		alert(a * x+(++a));
 	}
 	closure(10);
 }
//在foo函数内部，closure函数访问foo的局部变量a
foo(2);		//alert(23)
//然而，上述的代码不算一个真正意义上的闭包，
//当retrun的是内部函数function时，才会产生真正意义上的闭包。
//内部的函数会close-over外部function的变量直到内部函数结束。

//===============================================
function foo1(){
	var a =2;

	return function(x){
		//返回一个内部函数，产生真正意义的闭包
		alert(x * 2 +(a++));
	};
}

var bar = foo1();//bar就是一个闭包

//注意：因为产生闭包变量a一直没有释放，所以会一直之下a++
bar(10);	//22
bar(10);	//23
//=============================================

//通过内部循环，获取它们的索引，但是结果却不是想
//要的。由此可见，闭包知识对外部变量的一个引用，而非拷贝
//当这个值被改变后，其闭包中的值也会改变
var result =[];
function foo2(){
	for(var i=0;i<3;i++){
		result[i]=function(){
				alert(i);
			};
	}
}
foo2();
result[0]();//alert(3);
result[1]();//alert(3);
result[2]();//alert(3);

//想通过内部循环，获取它们的索引可以按如下方式
var result1 = [];
function foo3(){
	for(var i=0;i<3;i++){
		//调用立即执行的匿名函数
		result1[i]=(function(x){
			return function(){alert(x);};
			})(i);
	}
}
foo3();
result1[0]();
result1[1]();
result1[2]();
