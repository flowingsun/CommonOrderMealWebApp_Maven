Ext.define('OrderMealAdmin.view.OrderManage.OrderManagePanel',{
	extend:'Ext.form.Panel',
	alias:'widget.OrderManagePanel',
	title:'套餐管理',
	width:"100%",
	height:'100%',
	layout:'fit',
	dockedItems:[{
		xtype:'OrderManageSearchForm'
	}],
	items:[{
		xtype:'OrderManageGrid'
	}]
});