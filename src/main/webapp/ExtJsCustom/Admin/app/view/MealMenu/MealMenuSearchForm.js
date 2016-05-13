Ext.define("OrderMealAdmin.view.MealMenu.MealMenuSearchForm", {
	extend : 'Ext.form.Panel',
	alias : 'widget.MealMenuSearchForm',
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
		fieldLabel : '菜单名称',
		margin : '10 5 10 0',
		name : 'mealMenuName'
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