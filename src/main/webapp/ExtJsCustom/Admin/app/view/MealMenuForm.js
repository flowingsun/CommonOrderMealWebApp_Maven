Ext.define('OrderMealAdmin.view.MealMenuForm', {
	extend : 'Ext.form.Panel',
	alias : 'widget.MealMenuForm',
	border : 0,
	bodyPadding : '5',
	height : 250,
	bodyStyle : "background:#DFE9F6",
	width : 480,
	frame : true,
	items : [ {
		xtype : 'fieldset',
		title : '菜单信息',
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
			msgTarget : 'side',
			blankText : '该字段不能为空'
		},
		items : [ {
			xtype : 'textfield',
			fieldLabel : '菜单名称',
			name : 'menuName'
		}, {
			xtype : 'combobox',
			name : 'menuType',
			fieldLabel : '菜单类型',
			editable : false,
			store : Ext.create('Ext.data.Store', {
				fields : [ 'str', 'value' ],
				data : [ {
					str : '供应中',
					value : 1
				}, {
					str : '已停用',
					value : 0
				} ]
			}),
			valueField : 'value',
			displayField : 'str'
		}, {
			colspan : 2,
			width : 420,
			xtype : 'textareafield',
			allowBlank : true,
			editable : false,
			name : 'description',
			fieldLabel : '描述'
		} ]
	} ]
});