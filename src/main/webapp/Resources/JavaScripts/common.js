/**
 * 为Ajax事件绑定提示信息
 * @param {Object} hint
 */
function bindAjaxHint(hint) {
	$(document).bind('ajaxStart', function() {
		showHint('hint_waiting', 'LoadingCircle.gif', hint, true);	
	}).bind('ajaxStop', function() {
		$('#hint_waiting').css('display', 'none');
	});
}

function ajaxBtn(btn_id, hint) {
	$(document).bind('ajaxStart', function() {
		toggleBtn(btn_id, hint ? hint : "请稍候...");
	}).bind('ajaxStop', function() {
		toggleBtn(btn_id);
	});
}

function toggleBtn(btn_id, hint) {
	var $btn = $('#' + btn_id);
	if(!$btn.prop('disabled')) {
		$btn.data('prevVal', $btn.val());
		$btn.prop('disabled', true).css('color', 'grey').val(hint);		
	} else {
		$btn.prop('disabled', false).css('color', 'black').val($btn.data('prevVal'));
	}
}

/**
 * 向服务器发出一个ajax异步请求，返回json格式的数据
 * @param {Object} requestURL 请求地址
 * @param {Object} parameters 请求参数
 * @param {Object} callback 回调函数
 */
function ajaxRequest(requestURL, parameters, callback) {
	$.ajax({
		url: requestURL,
		type: 'post',
		data: parameters,
		dataType: 'json',
		success: function(data) {	
			if(typeof callback === 'function') {
				callback(data);
			} 
		}
	});
}

//js获取项目根路径，如： http://localhost:8083/uimcardprj
function getRootPath(){
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath = window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht = curWwwPath.substring(0,pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName = pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return (localhostPaht+projectName);
}

/**
 * 向用户显示一个居中的提示信息
 * @param {String} divId 容器div的id值
 * @param {String} imgName 图片的名字
 * @param {String} content 提示内容
 */
function showHint(divId, imgName, content, isAjax) {
	var $div = $('#' + divId);
	if(!$div.length) {
		var	$img = $('<img></img>').attr('src', getRootPath() + '/Resources/Image/' + imgName).width(16);
	        $div = $('<div></div>').attr({'id': divId, 'class': 'hint'}).append($img).append(content)
	        	.appendTo(document.body).css('position', 'absolute');       
	    center($div);
    } else {
    	//替换显示的内容
    	$div.html($div.html().replace(/>(.*)/.exec($div.html())[1], content)).css('display', 'block');
    }
	if(!isAjax) {
		setTimeout(function(){$div.css('display', 'none')}, 1500);
	}
}

/**
 * 显示错误信息
 * @param {String} divId 错误信息的div容器的id值
 * @param {Object} parent div容器的父容器
 * @param {Object} msg 错误信息
 */
function showErrorMsg(divId, parent, msg) {
	var $div = $('#' + divId);
	if(!$div.length) {
		var	$img = $('<img></img>').attr('src', getRootPath() + '/images/error-orange.png').width(16);
	        $div = $('<div></div>').attr({'id': divId, 'class': 'error_msg'}).append($img).append(msg)
	        	.appendTo(parent).css('display', 'block');
	} else {
		//替换显示的内容
    	$div.html($div.html().replace(/>(.*)/.exec($div.html())[1], msg)).css('display', 'block');
	}
}

/**
 * 让指定的元素在页面中居中显示
 * @param {Object} obj
 */
function center(obj) { 
	var screenWidth = $(window).width(), screenHeight = $(window).height(); //当前浏览器窗口的 宽高 
	var scrolltop = $(document).scrollTop();//获取当前窗口距离页面顶部高度 
	var objLeft = (screenWidth - obj.width())/2 ; 
	var objTop = (screenHeight - obj.height())/2 + scrolltop; 
	obj.css({left: objLeft + 'px', top: objTop + 'px','display': 'block'}); 
}

/**
 * 删除请求字符串中与key匹配的查询参数
 * @param {String} params 请求字符串
 * @param {String} key 要删除的参数中的关键字
 * @return {String} 删除关键字后的请求字符串
 */
function delParam(params, key) {		
	return params.replace(RegExp('&?' + key + '=' + '[^&]*').exec(params)[0], '');
} 

/**
 * 在屏幕中央显示一个特定消息的模态对话框
 * @param {String} title 对话框的标题
 * @param {String} content 对话框的内容
 */
function showMsgDialog(title, content) {
	var $dialog = $('#msg-dialog');
	if(!$dialog.length) {
		$dialog = $('<div class="dialog msg-dialog" id="msg-dialog"></div>').attr('title', title)
			.append($('<p></p>').append('<span class="ui-icon ui-icon-alert"></span>').append(content)).appendTo(document.body)
			.dialog({autoOpen: false, resizable: false, modal: true, height: 140, buttons : {
				"关闭": function() {$(this).dialog('close');} 
			}});
	}
	$dialog.dialog('open');
}

/**
 * 判断一个字符串是否为空
 * @param {Object} str
 */
function isEmpty(str) {
	if(/^\s*$|^$/.test(str)) {
		return true;
	}
	return false;
}

function isTooLong(value) {
	return value.length > 255;
}

function isIp(value) {
	return /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/.test(value);  
}

function trim(value) {
	return value ? value.replace(/(^\s*)|(\s*$)/g, "") : '';
}

function Pager(container_id, search_params) {
	var container = $('#' + container_id); 
	
	this.btn_first = $('div:contains("首页")', container);
	this.btn_prev = $('div:contains("上一页")', container);
	this.btn_next = $('div:contains("下一页")', container);
	this.btn_last = $('div:contains("尾页")', container);
	this.btn_reach = $('input[value=跳转]', container);	
	this.txt_input = this.btn_reach.parent().prev().find('input');
	this.url = location.href.replace(/\?.*/, '');	
	
	var lastTd = $('td:last', container);
	this.pager = {'currentPage': parseInt(lastTd.find('font:eq(0)').text()), 
		'pages': parseInt(lastTd.find('font:eq(1)').text()), 
		'records': parseInt(lastTd.find('font:eq(3)').text()),
		'rows': parseInt(lastTd.find('font:eq(2)').text()),
		'filters': search_params ? search_params : '',
		'reset': 'false'};
	
	disableBtn(this.btn_first);
	disableBtn(this.btn_last);
	disableBtn(this.btn_next);
	disableBtn(this.btn_prev);
	
	var that = this;
	if(this.pager.pages > 0) {
		enableBtn(this.btn_first);
		enableBtn(this.btn_last);
		this.btn_first.bind('click', function() {
			that.pager.currentPage = 1;
			that.submit();
		});				
		
		this.btn_last.bind('click', function() {
			that.pager.currentPage = that.pager.pages;
			that.submit();
		});
	}
	
	this.btn_reach.bind('click', function() {
		var page = parseInt(that.txt_input.val());
		if(!isNaN(page) && page > 0 && page <= that.pager.pages) {
			that.pager.currentPage = page;
			that.submit();
		}
	})
	
	this.txt_input.bind('keydown', function(e) {
		if(e.which == 13) {
			that.btn_reach.trigger('click');
		}
	})
	
	if(this.pager.currentPage < this.pager.pages) {
		enableBtn(this.btn_next);
		this.btn_next.bind('click', function() {
			that.pager.currentPage ++;
			that.submit();
		})
	}
	if(this.pager.currentPage > 1) {
		enableBtn(this.btn_prev);
		this.btn_prev.bind('click', function() {
			that.pager.currentPage --;
			that.submit();
		})
	}	
	if(this.pager.filters.length > 0) {
		var params = this.pager.filters.split('&');	
		for(var i=0, length=params.length; i<length; i++) {
			$('#search_' + params[i].split('=')[0].replace('\.', '_')).val(params[i].split('=')[1]);
		}
	}
	
	function enableBtn(btn) {
		btn.css({'cursor': 'pointer', 'color': 'black'});
	}
	
	function disableBtn(btn) {
		btn.css({'cursor': 'default', 'color': 'gray'});
	}	
	
	if(typeof this.submit !== 'function') {
		this.search = function(search_params) {		
			this.pager.currentPage = 1;
			this.pager.filters = search_params;
			this.pager.reset = 'true';
			this.submit();		
		}
		
		this.submit = function() {
			var $form = $('<form/>', {'action': this.url, 'method': 'post'}).css({'display': 'none'});
			for(var prop in this.pager) {
				$form.append($('<input/>', {'name': 'pager.' + prop, 'value': this.pager[prop]}));
			}
			$form.appendTo(document.body).submit();		
		}
	}
}