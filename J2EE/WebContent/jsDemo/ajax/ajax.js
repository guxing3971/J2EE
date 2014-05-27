// 异步调用
function ajax(method, url) {

	var http;

	if (window.XMLHttpRequest) {
		http = new XMLHttpRequest();
	} else {
		http = new ActiveXObject("Microsoft.XMLHTTP");
	}
	http.open(method, url);
	http.onreadystatechange = function() {
		var text = "";
		if (http.readyState == 4 && http.status == 200) {
			var type = http.getResponseHeader("Content-Type");
			if (type.match(/^xml^/)) {
				text = http.responseXML;
			} else {
				text = http.responseText;
			}
		}
		alert(text);
	};

	http.send();

}

function synajax(method, url) {
	var http;
	if (window.XMLHttpRequest) {
		http = new XMLHttpRequest();
	} else {
		http = new ActiveXObject("Microsoft.XMLHTTP");
	}
	http.open(method, url, false);
	http.send();
	var text = "";
	if (http.status == 200) {
		if (http.getResponseHeader("Content-Type").match(/^text^/)) {
			text = http.responseText;
		} else {
			text = http.responseXML;
		}
	}
	alert(text);
}

function encodeData(data) {
	if (!data)
		return "";
	var pushData = [];
	for (var name in data) {
		if (!data.hasOwnProperty(name))
			continue;
		if (typeof(data[name]) === "function")
			continue;
		var value = data[name].toString();
		name = encodeURIComponent(name.replace("%20", "+"));
		value = encodeURIComponent(value.replace("%20", "+"));
		pushData.push(name + "=" + value);
	}
	return pushData;
}

function PostAjax(url, data) {
	var http;
	if (window.XMLHttpRequest) {
		http = new XMLHttpRequest();
	} else {
		http = new ActiveXObject("Microsoft.XMLHTTP");
	}

	var text = "";
	http.open("POST", url);
	http.onreadystatechange = function() {
		if (http.readySate == 4 && http.status == 200) {
			if (http.getHeaderReponseHeader("Content-Type").match(/^text^/)) {
				text = http.responseText;
			} else {
				text = http.responseXML;
			}
		}
	};

	http.setRequestHeader("Content-Type", "appliaction/x-www-form-urlencoded");
	http.send(encodeData(data));

	return text;
}

function getAjax(url, data) {
	var http;
	if (window.XMLHttpRequest) {
		http = new XMLHttpRequest();
	} else {
		http = new ActiveXObject("Microsoft.XMLHTTP");
	}

	var text = "";
	http.open("GET", url + "?" + encodeData(data));
	http.onreadystatechange = function() {
		if (http.readyState == 4 && http.status == 200) {
			if (http.getResponseHeader("Content-Type").match(/^text^/)) {
				text = http.responseText();
			} else {
				text = http.responseXML();
			}
		}
	};
	http.send(null);
	return text;
}

function JSONAjax(url, data) {

	var http;
	if (window.XMLHttpRequest) {
		http = new XMLHttpRequest();
	} else {
		http = new ActiveXObject("Microsoft.XMLHTTP");
	}

	var text = "";
	http.open("POST");
	http.onreadystatechange = function() {
		if (http.readyState == 4 && http.status == 200) {
			if (http.getResponseHeader("Content-Type").match(/^text^/)) {
				text = http.responseText();
			} else {
				text = http.responseXML();
			}
		}
	};
	http.setRequestHeader("Content-Type", "application/json");
	http.send(JSON.stringify(data));
	return text;
}

function fileAjax() {
	var elts = document.getElementsByTagName("input");
	for (var i = 0; i < elts.length; i++) {
		var input = elts[i];
		if (input.type !== "file")
			continue;
		if (!input.getAttribute("data-uploadto"))
			continue;

		input.addEventListener("change", function() {
					if (!file)
						return;
					var file = this.files[0];
					var xhr = new XMLHttpRequest();
					xhr.open("POST", input.getAttribute("data-uploadto"));
					xhr.send(file);
				}, false);
	}
}
