$(function() {
	$(document).tooltip({
		items : "img,[title]",
		position: { my: "center", at: "right+30" },
		content : function() {
			var element = $(this);
			if (element.is("[title]")) {
				return element.attr("title");
			}
			if (element.is("img")) {
				return element.attr("alt");
			}
		}
	});
	/*
	 * @param tag:目标ID,message:消息,modal:是否遮蔽页面
	 * @author flowingsun 
	 * @description 提示消息弹出层
	 */
	function ShowMessage(tagid, message, modal) {
		$("#" + tagid).text(message);
		$("#" + tagid).dialog({
			resizable : false,
			modal : modal,
			buttons : {
				"确认" : function() {
					$(this).dialog("close");
				}
			}
		});
	}
});
