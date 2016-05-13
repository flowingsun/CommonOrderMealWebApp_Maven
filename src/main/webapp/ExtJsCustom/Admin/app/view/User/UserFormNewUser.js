Ext.define('OrderMealAdmin.view.User.UserFormNewUser', {
	extend : 'Ext.form.Panel',
	alias : 'widget.UserFormNewUser',
	border : 0,
	bodyPadding : '5',
	height : 250,
	bodyStyle : "background:#DFE9F6",
	width : 480,
	frame : true,
	items : [ {
		xtype : 'fieldset',
		title : '添加用户',
		layout : {
			type : 'table',
			columns : 2
		},
		defaults : {
			labelSeparator : ':',
			margin : '10 5 5 5',
			labelWidth : 60,
			width : 200,
			allowBlank : false,
			msgTarget : 'side',
			labelAlign : 'left',
			allowBlank : false,
			blankText : '该字段不能为空'
		},
		items : [ {
			xtype : 'textfield',
			fieldLabel : '姓名',
			name : 'userName'
		}, , {
			xtype : 'textfield',
			fieldLabel : '账户名',
			name : 'loginname'
		}, {
			xtype : 'textfield',
			inputType:'password', 
			fieldLabel : '密码',
			name : 'userPassword',
			blankText : '密码不能为空',
			minLength : 6,
			minLengthText : '密码不能少于6位',
			maxLength : 10,
			maxLengthText : '密码不能超过10位',
			id : 'password',
		}, {
			xtype : 'textfield',
			inputType:'password', 
			fieldLabel : '确认密码',
			name : 'cleartextPassword',
			blankText : '确认密码不能为空',
			minLength : 6,
			minLengthText : '密码不能少于6位',
			maxLength : 10,
			maxLengthText : '密码不能超过10位',
			vtype : 'password',
			id : 'cleartextPassword',
			confirmTo : 'password'
		}, {
			xtype : 'combobox',
			name : 'sex',
			fieldLabel : '性别',
			editable : false,
			value : '男',
			store : Ext.create('Ext.data.Store', {
				fields : [ 'str', 'value' ],
				data : [ {
					str : '男',
					value : '男'
				}, {
					str : '女',
					value : '女'
				} ]
			}),
			valueField : 'value',
			displayField : 'str'
		}, {
			xtype : 'textfield',
			fieldLabel : '职位',
			name : 'postion'
		}, {
			xtype : 'textfield',
			fieldLabel : '电话号码',
			name : 'telePhone'
		}, {
			xtype : 'textfield',
			fieldLabel : '邮箱地址',
			name : 'email'
		}, {
			colspan : 2,
			xtype : 'combobox',
			name : 'userState',
			fieldLabel : '用户状态',
			editable : false,
			value : 1,
			store : Ext.create('Ext.data.Store', {
				fields : [ 'str', 'value' ],
				data : [ {
					str : '已激活',
					value : 1
				}, {
					str : '未激活',
					value : 0
				} ]
			}),
			valueField : 'value',
			displayField : 'str'
		}, {
			colspan : 2,
			width : 420,
			xtype : 'textfield',
			editable : false,
			name : 'userLocation',
			fieldLabel : '所在地点'
		} ]
	} ]
});