Ext.define('OrderMealAdmin.view.UserGrid',{
	extend:'Ext.grid.Panel',
	alias:'widget.UserGrid',
	store:'UserStore',
	height:	540,
	width:500,
	//selType:'checkboxmodel',
	multiSelect:true,
	columnLines:true,//表格的竖线
	initComppnent:function(){
		this.callParent(arguments);
	},
	border:0,
	columns:[
		{text:'id',dataIndex:'user.id',width:30,locked: true},
		{text:'姓名',dataIndex:'user.userName',width:80,locked: true},
		{text:'性别',dataIndex:'user.sex',width:100},
		{text:'职位',dataIndex:'user.postion',width:100},
		{text:'电话',dataIndex:'user.telephone',width:100},
		{text:'邮箱',dataIndex:'user.email',width:200},
		{text:'用户所在位置',dataIndex:'user.userLocation',width:100},
		{text:'生日',dataIndex:'user.birthday',renderer:Ext.util.Format.dateRenderer('Y-n-j'),width:150},
		{text:'是否激活',dataIndex:'user.userState',width:100,xtype:'booleancolumn',trueText:"<font color='green'>已激活</font>",falseText:"<font color='red'>未激活</font>"}
	],
	tbar:[
		{xtype:'button',text:'添加',icon:'ExtJsCustom/images/user_add.png'},
		{xtype:'button',text:'修改',icon:'ExtJsCustom/images/user_edit.png',disabled:true}
	],
	dockedItems:[
		{xtype:'pagingtoolbar',store:'UserStore',displayInfo:true,dock:'bottom'}
	]
});