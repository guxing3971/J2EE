//创建一个对象，并为它设置一些属性
var obj = new Object();
//为obj对象设置属性
obj.name="my name";
obj.click = function(){
		alert("click me!");
	};

//效果同上
var obj1 = {
	name:"my name",
	click:function(){
			alert("click me!");
		}
};


//Tesing
alert(obj.name);
obj.click();

alert(obj1.name);
obj1.click();

//==============创建对象方式一：对象直接量=====================
var empty = {};		//没有任何属性的对象
var point = {x:0,y:0};	//俩个属性
var point2 ={
		x:point.x,
		y:point.y+1
	};
var book ={
		"main tile":"JavaScript",	//属性名有空格，必须用引起来
		"sub-tile":"the definitive guide",//属性名有链接字符，必须引起来
		"for":"all audiences",	//for为保留字，因此必须引起来
		author:{
				firstname:"David",
				surname:"Flanagan"
			}
	};
//==============创建对象方式一：new=====================
var o = new Object();	//创建一个空对象和{}一样
var a = new Array();	//创建一个空数组，和[]一样
var d = new Date();		//创建一个表示当前时间的date对象
var r = new RegExp("js");//创一个正则对象

//==============创建对象方式一：Object.create===========
var o1 = Object.create({x:1,y:2});	//o1继承了属性x和y
var o2 = Object.create(null);		//o2不继承任何属性和方法
var o3 = Object.create(Object.prototype);//o3和{}/new Object()一样

//==============属性的查询和设置========================


//query
var author = book.author;	//得到book的author属性
var name = author.surname;	//获得对象的author的surname属性
var name = book.author && book.author.surname;	//利用&&短路特性一次访问想要的属性
var title = book["main title"];//得到book的main title属性
//set
book["main title"] ="JavaScript/ECMAScript5";
//==============================================================
/*
 * @function inherit():	返回一个继承自原型对象p属性的新对象
 */
/*
 * @function inherit():	返回一个继承自原型对象p属性的新对象
 */
function inherit(p){
	if(p == null) return;
	if(Object.create){
		return Object.create(p);
	}else{
		var t = typeof p;
		if(t !== "object" && t!=="function") return;
		function f(){};
		f.prototype=p;
		return new f();
	}
}
//================================================================
//创建并测试原型链
var o1 = new Object();		//创建一个对象
o1.x = "o1";				//为对象o设置属性x
var o2 = inherit(o1);		//创建一个原型对象为o1的对象
o2.y ="o2";					//为o2设置属性y
var o3 = inherit(o2);		//创建一个原型对象为o2的对象

//查询
alert(o3.x);				//通过对象原型链查找属性x
alert(o3.y);				//通过对象原型链查找属性y
//赋值
o3.x = "o3";
o2.y = "in o2";
alert(o3.x);                //o3
alert(o3.y);				//in o2
alert(o2.x);				//o1
alert(o2.y);				//in o2
alert(o1.x);				//o1
o1.x = "in o1";
alert(o2.x);				//in o1
alert(o3.x);				//o3

//=================删除对象属性===========================
var obj = {
		name:"my name",
		age:"my age",
		click:function(){
			alert("click me!");
		}
	};
alert(obj.name);
alert(obj.age);
obj.click();
delete obj.name;		//删除obj的name属性，返回true
delete obj.name;		//什么都不做返回ture
delete obj.age;			//删除obj的age属性
delete obj.click;		//删除obj的click方法
delete obj.toString();	//什么也不做（toString是继承来的），返回true
delete 1;				//无意义,返回true

//delete在删除不可配置的属性，全局变量，全局函数时会返回false
delete Object.prototype;//不能删除不可配置的属性,返回false
var x =1;				//声明一个全局变量
delete this.x;			//不能删除全局变量，返回false
function f(){}			//声明一个全局函数
delete f;				//不能删除一个全局函数，返回false
//================检测属性==========================

var obj = {x:1};
//in运算符判定
//	in运算符的左侧是属性名(字符串)，右侧是对象。
//	如果对象的自有属性或继承属性中包含这个属性怎返回true
"x" in obj;		//true: x是obj的属性
"y" in obj;		//false: y不是obj的属性
"toString" in obj;	//true：obj继承了toString属性

//hasOwnPropery方法检测
//	hasOwnProperty方法来用来检测给定的属性是否是对象的自有属性，
//	对于继承的属性，该方法返回false
obj.hasOwnProperty("x");	//true:x是obj的自有属性
obj.hasOwnProperty("y");	//false:y不是obj的自有属性
obj.hasOwnProperty("toString");//false:toString是继承属性

//propertyIsEnumerable检测
//	propertyIsEnumerable只有检测到自有属性，并且这个自有属性是可枚举的菜返回true
obj.propertyIsEnumerable("x");//true:x是obj的可枚举的自有属性
obj.propertyIsEnumerable("y");//false:y不是obj的属性
obj.propertyIsEnumerable("toString");//false不是obj的自有属性
Object.prototype.hasOwnProperty("toString");//true
Object.prototype.propertyIsEnumerable("toString");//不可枚举

//使用属性访问方式判定
//	当访问一个对象不存在的属性是会返回undefined
obj.x !== undefined;	//true：obj有x这个属性
obj.y !== undefined;	//false:obj没有y这个属性
obj.toString !== undefined; //true:obj继承了toString方法
//注意以下情况

var obj = {x:undefined};
obj.x !== undefined; //false。

//===================枚举属性==============================
var obj = {
		x:"my name",
		y:"you name",
		click:function(){
			alert(x+" lov "+ y);
		}
	};
//使用for/in循环枚举可以枚举的属性（包括继承和自有的）
for(var p in obj){
	/*
	if(!obj.hasOwnProperty(p)){
		//跳过继承的属性
		continue;
	}
	if(typeof obj[p] =="function"){
		//跳过函数
		continue;
	}
	*/
	console.log("obj["+p+"]->"+obj[p]);
}

/*
 * 把p中可枚举属性复制到o中，并返回o
 * 如果o和p中含有相同属性，则覆盖o中的属性
 * 这个函数并不除了getter和setter以及复制属性
 * 
 */
 
 function extend(o,p){
 	for(prop in p){
 		o[prop] = p[prop];
 	}
 	return o;
 }

/*
 * 将p中的可枚举的属性复制到o中，并返回o
 * 如果o和p中有同名的属性，o中属性不受影响
 * 这个函数并不除了getter和setter以及复制属性 
 */
 function merge(o,p){
 	for(prop in p){
 		if(o.hasOwnProperty[prop]) continue;
 		o[prop] = p[prop];
 	}
 }

/*
 * 如果o中的属性在p中没有同名属性，则从o中删除这个属性
 * 返回o
 */
 function restrict(o,p){
 	for(prop in o){
 		if(!(prop in p)) delete o[prop];
 	}
 	return o;
 }
 /*
  * 如果o中的属性在p中存在同名属性，则从o中删除这个属性
  * 返回o
  */
  function substract(o,p){
  	for(prop in p){
  		delete o[prop];
  	}
  	return o;
  }
/*
 * 返回一个数组，这个数组包含的是o中可枚举的自由属性的名字
 */
function keys(o){
	if(typeof o !== "object") returnl
	var result = [];
	for(var prop in o){
		if(o.hasOwnProperty(prop))
			result.push(prop);
	}
	return result;
}


/*
 * ECMAScript5中的Object.keys()
 * 
 */
var obj1 = {
	x:"my name",
	y:"you name",
	method:function(){
		console.log(x+" love "+y);
	}
};
//利用Object.keys()变量obj的属性
for( p in Object.keys(obj)){
	console.log("obj->"+p);
}
//利用Object.getOwnPropertyNames()
var prop = Object.getOwnPropertyNames(obj);
console.log(prop.length);
prop.map(function(x){console.log(x);});

/*
 * JavaScript为对象定义getter/setter属性
 */
var  p ={
	//x和y是普通的可读写的数据属性
	x:1.0,
	y:1.0,
	
	//属性r是可读写的存取器属性。它有getter和setter
	get r(){
		//此处的this指向对象本身
		return  Math.sqrt(this.x * this.x + this.y * this.y);
	},
	set r(newvalue){
		var oldvalue = Math.sqrt(this.x * this.x + this.y * this.y);
		var ratio = newvalue/oldvalue;
		this.x *= ratio;
		this.y *= ratio;
	},
	
	//theta是只读属性，它只有getter方法
	get theta(){
		return Math.sqrt(this.x * this.y);
	}
};

//Testing
console.log(p.x+"\t"+p.y);
console.log(p.r);
p.r=20;
console.log(p.x+"\t"+p.y);

//Demo
/*
 * 利用getter属性获取一个随机数
 */
var random ={
	get octet(){return Math.floor(Math.random()*256);},
	get uint16(){return Math.floor(Math.random()*65536);},
	get int16(){return Math.floor(Math.random()*65536)-32768;}
};
console.log(random.octet);
console.log(random.octet);
console.log(random.octet);
console.log(random.int16);
console.log(random.int16);
console.log(random.int16);
console.log(random.uint16);
console.log(random.uint16);
console.log(random.uint16);

/*
 * 属性包含一个名字和4个特性
 * 	数据属性的4个特性分别是它的
 * 			值（value）、
 * 			可写性（writable）、
 * 			可枚举性（enumerable）、
 * 			可配置性（configurable）
 * 	存取属性的四个特性分别是
 * 			读取（get）、
 * 			写入（set）、
 * 			可枚举（enumerable）、
 * 			可配置（configurable）
 */
var p = {
	x:1.0,
	y:1.0,
	space: function(){
		return x * y;
	}
};
//利用Object.getOwnPropertyDescriptor()方法获取对象属性描述符

//return {value:x,writable:true,enumberable:true,configurable:true} or undefined; 
var desc_p$x = Object.getOwnPropertyDescriptor(p,"x");
console.log(desc_p$x);
console.log("{value:"+desc_p$x.value,+
			",writable:"+desc_p$x.writable+
			",enumerable:"+desc_p$x.enumerable+
			",configurable:"+desc_p$x.configurable+"}");
var p1 ={
	x:100,
	get r(){
		return this.x;
	},
	set r(newvalue){
		this.x = newvalue;
	}
};
//return {get:function,set:function,enumerable:true,configurable:true} or undefined
var desc_p1$r = Object.getOwnPropertyDescriptor(p1,"r");
console.log(desc_p1$r);

//创建一个空对象
var o ={};
//添加一个不可枚举的属性x，并赋值为1
Object.defineProperty(o,"x",{value:1,writable:true,enumable:false,configurable:true});
//属性是存在，但是不可枚举
o.x;	//1
Object.keys(o);	//not have x
//对x属性做修改，让它只读
Object.defineProperty(o,"x",{writable:false});
//试图更改这个属性的值
o.x = 2;	//操作失败，但不保存，在严格模式下会抛出异常
o.x;	//1
//属性是可配置的，所以个通过如下方式做修改
Object.defineProperty(o,"x",{value:2});
o.x;	//2
//现在将x从数据属性修改为存起属性
Object.defineProperty(o,"x",{get:function(){return 0;} });
//为对象p添加多个对象
Object.defineProperties(
		o,
		{
			y:{value:2,writable:true,enumerable:true,configurable:true},
			z:{value:2,writable:true,enumerable:true,configurable:true},
			r:{
				get:function r(){return this.x * this.y *this.z;},
				enumerable:true,
				configurable:true,
			}
		}
	);
//枚举o的属性
for(var prop in o){
	console.log(prop);
}


/**
 * 给Object.prototype添加一个不可枚举的extend()犯法
 * 	这个方法继承自用的对象，将作为参数的传入的对象的属性赋值除了值之外，也赋值属性的所有特性。
 * 	除非在目标对象中存在同名的属性，参数对象的所有自有属性（包括不可枚举的属性）都复制
 */
Object.defineProperty(Object.prototype,
		"extend",
		{
			writable:true,
			enumberable:false,	//将其定义为不可枚举的
			configurable:true,
			value :function(o){
				//得到所有的自有属性，包括不可枚举属性
				var names = Object.getOwnPropertyNames(o);
				for(var i=0;i<names.length;i++){
					//如果属性已经存在，则跳过
					if(names[i] in this) continue;
					//获得o的属性描述符
					var desc = Object.getOwnPropertyDescriptor(o,names[i]);
					//用它给this创建这个属性
					Object.defineProperty(this,names[i],desc);
				}
			}
		}
		);

//检查obj是否处于obj1的原型链上
var obj = new Object();
obj.x =1;
var obj1 = Object.create(obj);
console.log(obj.isPrototypeOf(obj1));


//根据toString()方法继承自Object.prototype返回的字符串获取属性的类
function  classof(o){
	if(o === null) return "Null";
	if(o === undefined) return "Undefined";
	return Object.prototype.toString(o).slice(8, -1);
	//return o.constructor.name;
}
console.log(classof());
console.log(classof(null));
console.log(classof(1));
console.log(classof("sss"));
function test(name){
	this.name = name;
}
console.log(classof(new test()));

//===================对象序列化
var  o ={
	x:1,
	y:2,
	get r(){
		return 2;
	}
};
var str = JSON.stringify(o);
console.log(str);
var p = JSON.parse(str);
console.log(p.constructor.name);














