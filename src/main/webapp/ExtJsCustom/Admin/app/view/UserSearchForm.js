Ext.define("OrderMealAdmin.view.UserSearchForm", {
	extend : 'Ext.form.Panel',
	alias : 'widget.UserSearchForm',
	width : 750,
	height : 40,
	anchor : '100%',
	layout : 'hbox',
	border : 0,
	bodyStyle : "background:#DFE9F6",
	fieldDefaults : {
		labelAlign : 'right',
		labelWidth : 60,
		margin : '10 2',
	},
	items : [ {
		xtype : 'textfield',
		fieldLabel : '姓名',
		margin : '10 5 10 0',
		name : 'username'
	}, {
		xtype : 'textfield',
		fieldLabel : '用户位置',
		margin : '10 5 10 0',
		name : 'userLocation'
	}, {
		xtype : 'button',
		text : '查找',
		margin : '10 5',
		icon : 'ExtJsCustom/images/icons/find.png'
	}, {
		xtype : 'button',
		text : '重置',
		margin : '10 5',
		icon : 'ExtJsCustom/images/icons/arrow_redo.png'
	} ]
});