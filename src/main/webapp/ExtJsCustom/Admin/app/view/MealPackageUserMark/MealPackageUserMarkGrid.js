Ext.define('OrderMealAdmin.view.MealPackageUserMark.MealPackageUserMarkGrid', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.MealPackageUserMarkGrid',
	store : 'MealPackageUserMarkStore',
//	height : 540,
//	width : 500,
	height : '100%',
	width : '100%',
	selType : 'checkboxmodel',
	multiSelect : true,
	columnLines : true,// 表格的竖线
//	scrollable : true,
	initComppnent : function() {
		console.log(arguments);
		this.callParent(arguments);
	},
	border : 0,
	columns : [ {
		text : 'id',
		dataIndex : 'MealPackageUserMarkId',
		width : 30,
		locked : true
	}, {
		text : '套餐名称',
		dataIndex : 'menuName',
		width : 140,
		locked : true
	},{
		text : '所属餐厅',
		dataIndex : 'canteenName',
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
		text : '套餐状态',
		dataIndex : 'menuType',
		width : 150,
		xtype : 'booleancolumn',
		trueText : "<font color='green'>供应中</font>",
		falseText : "<font color='red'>已停用</font>"
	}, {
		text : '套餐描述',
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
		store : 'MealPackageUserMarkStore',
		displayInfo : true,
		dock : 'bottom'
	} ]
});