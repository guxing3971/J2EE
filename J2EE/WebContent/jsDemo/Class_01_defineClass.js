/*
 * JavaScript的面向对象编程
 * 定义一个Js的class，并为其定义属性和方法
 */

//Lecture的构造器
function Lecture(names,teacher){
	//将name和teacher作为对象的本地属性保存
	this.names = names;
	this.teacher = teacher;
}

//为类Lecture添加方法
Lecture.prototype.display=function(){
	//生成一个显示该课程的信息的字符串
	return this.teacher +" is teaching "+this.names;
};

//定义类Schedule
function Schedule(Lectures){
	//Schedule类的构造
	//Lectures为lectrue的数组
	this.Lectures = Lectures;
}
//为Schedule添加方法
Schedule.prototype.display=function(){
	var str="";
	for(var i=0;i<this.Lectures.length;i++){
		str += this.Lectures[i].display() +"|";
	}
	return str;
};

//Tesing
var sch = new Schedule(
		[
		new Lecture("english","self"),
		new Lecture("c++","xigh"),
		new Lecture("java","lixh"),
		new Lecture("python","li")
		]
	);
sch.display();