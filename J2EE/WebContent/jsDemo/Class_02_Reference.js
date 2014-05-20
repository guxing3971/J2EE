/*
 * Js的引用
 * 	JavaScript的一个重要的概念是引用。引用就是指向对象实际位置的指针。
 * 	这是一项极其强大的功能。前提是，实际的对象决不是一个引用：字符串总是
 * 	一个字符串，数组总是一个数组，然而，多个变量可以引用相同的对象。
 * 	JavaScript就是以这种引用机制为基础，通过维护一系列的指向其他对象的引用，
 * 	为编程提供了更大的弹性。
 */

//=====================多个对象引用同一个对象====================
var obj = new Object();
//创建一个对象引用链
var obj1 = obj;
var obj2 = obj1;
//修改obj
obj.oneProperty ="this's property!";
//则是对象引用链上的对象是否具有该属性
obj1.oneProperty;
obj2.oneProperty;
alert(obj.oneProperty === obj1.oneProperty); //true
alert(obj1.oneProperty === obj2.oneProperty);//true
alert(obj.oneProperty === obj2.oneProperty);//true
//============================================================

//===================引用只引用对象，而不引用引用===================
var arry = new Array("one","tow","three");
//创建一个引用链
var arry1 = arry;
var arry2 = arry1;
//修改引用链中的引用，使其指向一个新的对象
arry1 = new Array("one");
alert(arry === arry1);	//false
alert(arry === arry2);	//ture(说明JavaScript的引用只作于对象，而不是引用关系)
//============================================================

var item = "test";
var item1 = item;
//item === item1 -> ture;
item += "ing";//new String
alert(item === item1); //false

