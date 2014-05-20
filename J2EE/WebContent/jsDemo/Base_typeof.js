/*
 * JS中的typeof关键字
 * 	typeof关键字是用来检查变量的类型，下面是其返回值
 * 	1. 'undefined' --- 这个值未定义；
	2. 'boolean'    --- 这个值是布尔值；
	3. 'string'        --- 这个值是字符串；
	4. 'number'     --- 这个值是数值；
	5. 'object'       --- 这个值是对象或null；
	6. 'function'    --- 这个值是函数。
 */
function Test_typeof(obj){
	var result="";
	if('undefined' == typeof(obj)){
		result ="这个值未定义";
	}
	if('boolean' == typeof(obj)){
		result ="这个值是布尔值";
	}
	if('string' == typeof(obj)){
		result ="这个值是字符串";
	}
	if('number' ==typeof(obj)){
		result ="这个值是数字";
	}
	if('object' == typeof(obj)){
		result ="这个值是对象或null";
	}
	if('function' == typeof(obj)){
		result ="这个值是函数";
	}
	return result;
}

alert(Test_typeof());//undefined
alert(Test_typeof(true));
alert(Test_typeof("strs"));
alert(Test_typeof(111));
alert(Test_typeof(new Array()));
alert(Test_typeof(null));
alert(Test_typeof(function(){}));

