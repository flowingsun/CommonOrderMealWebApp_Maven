Ext.define('OrderMealAdmin.view.CanteenForm', {
	extend : 'Ext.form.Panel',
	alias : 'widget.CanteenForm',
	border : 0,
	bodyPadding : '5',
	height : 250,
	bodyStyle : "background:#DFE9F6",
	width : 480,
	frame : true,
	items : [ {
		xtype : 'fieldset',
		title : '用户信息',
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
			fieldLabel : '餐厅名称',
			name : 'canteenName'
		}, {
			xtype : 'combobox',
			name : 'canteenStatus',
			fieldLabel : '餐厅状态',
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