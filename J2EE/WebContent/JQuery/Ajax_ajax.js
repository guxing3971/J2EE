/*
 * Jquery的所有ajax工具最后都会调用jquery.ajax这个函数。
 *	它是Jquery类库中最复杂的函数。
 *	Jquery.ajax只接受一个参数：一个选项对象，
 *	该对象的属性指定了ajax请求如何指向的细节。
 */

//===================================================
//例如下面的代码是等价的
jQuery.getScript("url",callback);
jQuery.ajax({
		type:"GET",
		url:"url",
		data:null,
		datatype:"script",
		success:callback
	});
//==================================================
//设置全局的Ajax请求配置
jQuery.ajaxSetup({
		//设置全局的ajax请求超时
		timeout:2000,	
		//设置是否启用缓存
		cache:false
	});
//==================================================
//注册自己的ajax事情处理函数
$("#id").bind({
		ajaxStart:function(){$(this).show();},
		ajaxEnd:function(){$(this).show();}
	});