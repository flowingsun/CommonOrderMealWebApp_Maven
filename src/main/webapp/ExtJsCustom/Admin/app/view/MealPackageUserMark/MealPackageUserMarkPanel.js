Ext.define('OrderMealAdmin.view.MealPackageUserMark.MealPackageUserMarkPanel',{
	extend:'Ext.form.Panel',
	alias:'widget.MealPackageUserMarkPanel',
	title:'套餐管理',
	width:"100%",
	height:'100%',
	layout:'fit',
	dockedItems:[{
		xtype:'MealPackageUserMarkSearchForm'
	}],
	items:[{
		xtype:'MealPackageUserMarkGrid'
	}]
});