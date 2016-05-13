Ext.define('OrderMealAdmin.view.User.UserGrid', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.UserGrid',
	store : 'UserStore',
//	height : 540,
//	width : 500,
	height : '100%',
	width : '100%',
	selType : 'checkboxmodel',
	multiSelect : true,
	columnLines : true,// 表格的竖线
	initComppnent : function() {
		this.callParent(arguments);
	},
	border : 0,
	columns : [ {
		text : 'id',
		dataIndex : 'userID',
		width : 30,
		locked : true
	}, {
		text : '姓名',
		dataIndex : 'userName',
		width : 100,
		locked : true
	}, {
		text : '性别',
		dataIndex : 'sex',
		width : 100
	}, {
		text : '职位',
		dataIndex : 'postion',
		width : 100
	}, {
		text : '电话',
		dataIndex : 'telePhone',
		width : 100
	}, {
		text : '邮箱',
		dataIndex : 'email',
		width : 200
	},
	// {text:'生日',dataIndex:'birthday',renderer:Ext.util.Format.dateRenderer('Y-n-j'),width:100},
	{
		text : '用户所在位置',
		dataIndex : 'userLocation',
		width : 100
	}, {
		text : '登陆账号',
		dataIndex : 'loginname',
		width : 100
	}, {
		text : '是否激活',
		dataIndex : 'userState',
		width : 100,
		xtype : 'booleancolumn',
		trueText : "<font color='green'>已激活</font>",
		falseText : "<font color='red'>未激活</font>"
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
		store : 'UserStore',
		displayInfo : true,
		dock : 'bottom'
	} ]
});