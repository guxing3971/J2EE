
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
/*
 * @function text():获取或设置元素的纯文本
 */
function text(elt,content){
	if(!elt){
		if(value === undefined){
			if(elt.textContent) return elt.textContent;
			return elt.innerText;
		}else{
			if(elt.textContent)
				elt.textContent=content;
			elt.innserText;
		}
	}
}

/*
 * @function textContent():获取元素的送子节点的纯文本内容
 */
function textContent(elt){
	var child,type,s="";
	for(child=elt.firstChild;child != null;child=child.nextSibling){
		type=child.nodeType;
		if(3=== type || 4===type){
			//如果是text节点或cdata节点则保存内容到s
			s += child.nodeValue;
		}
		if(1=== type){
			//递归获取文本
			s += textContent(child);
		}
	}
	return s;
}