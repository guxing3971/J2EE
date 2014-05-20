/*
 * JS检查变量的类型
 * 	JavaScript是一门动态语言，所以 检查变量类型显的尤为重要。
 *  有俩种普遍使用的方式用来检查变量的类型
 *  ·使用typeof运算符
 *  ·使用constructor属性
 */

//使用constructor属性获取变量的类型，并返回一个描述符
function getTypeDesc(obj){
	if(!obj){
		//当obj不为null或undefined
		return obj.constructor.name;//非IE
	}
}