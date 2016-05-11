Ext.define('OrderMealAdmin.model.MealMenuModel',{
	extend:'Ext.data.Model',
	fields:[
		{name:'mealMenuId',mapping:'mealMenuId',type:'int'},
		{name:'menuName',mapping:'menuName',type:'string'},
		{name:'menuType',mapping:'menuType',type:'int'},
		{name:'canteenId',mapping:'canteenId',type:'int'},
		{name:'canteenName',mapping:'canteen.canteenName',type:'string'},
		{name:'description',mapping:'description',type:'string'},
		{name:'createTime',mapping:'createTime',type:'time',dataFormat:'YYYY-MM-dd HH:mm:ss'},
		{name:'editTime',mapping:'editTime',type:'time',dataFormat:'YYYY-MM-dd HH:mm:ss'},
	]
});