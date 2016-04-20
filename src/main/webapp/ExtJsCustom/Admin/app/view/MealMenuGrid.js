Ext.define('OrderMealAdmin.view.MealMenuGrid', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.MealMenuGrid',
	store : 'MealMenuStore',
	height : 540,
	width : 500,
	selType : 'checkboxmodel',
	multiSelect : true,
	columnLines : true,// 表格的竖线
	initComppnent : function() {
		this.callParent(arguments);
	},
	border : 0,
	columns : [ {
		text : 'id',
		dataIndex : 'mealMenuId',
		width : 100,
		locked : true
	}, {
		text : '菜单名称',
		dataIndex : 'mealMenuName',
		width : 140,
		locked : true
	}, {
		text : '创建日期',
		dataIndex : 'createTime',
		width : 150
	}, {
		text : '编辑日期',
		dataIndex : 'editTime',
		width : 150
	}, {
		text : '菜单状态',
		dataIndex : 'mealMenuStatus',
		width : 150,
		xtype : 'booleancolumn',
		trueText : "<font color='green'>供应中</font>",
		falseText : "<font color='red'>已停用</font>"
	}, {
		text : '菜单描述',
		dataIndex : 'description',
		width : 300
	} ],
	tbar : [ {
		xtype : 'button',
		text : '添加',
		icon : 'ExtJsCustom/images/user_add.png'
	}, {
		xtype : 'button',
		text : '修改',
		icon : 'ExtJsCustom/images/user_edit.png',
		disabled : true
	}, {
		xtype : 'button',
		text : '停用',
		icon : 'ExtJsCustom/images/delete.gif',
		disabled : true
	} ],
	dockedItems : [ {
		xtype : 'pagingtoolbar',
		store : 'MealMenuStore',
		displayInfo : true,
		dock : 'bottom'
	} ]
});