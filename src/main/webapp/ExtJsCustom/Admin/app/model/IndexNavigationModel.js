Ext.define('OrderMealAdmin.model.IndexNavigationModel',{
	extend:'Ext.data.Model',
	fields:[
		{name:'IndexNavigationId',mapping:'IndexNavigationId',type:'int'},
		{name:'packageName',mapping:'packageName',type:'string'},
		{name:'state',mapping:'state',type:'int'},
		{name:'mealMenuId',mapping:'mealMenuId',type:'int'},
		{name:'mealMenuName',mapping:'mealMenu.mealMenuName',type:'string'},
		{name:'description',mapping:'description',type:'string'},
		{name:'createTime',mapping:'createTime',type:'time',dataFormat:'YYYY-MM-dd HH:mm:ss'},
		{name:'editTime',mapping:'editTime',type:'time',dataFormat:'YYYY-MM-dd HH:mm:ss'},
	]
});