Ext.define('OrderMealAdmin.model.CanteenModel',{
	extend:'Ext.data.Model',
	fields:[
		{name:'canteenId',mapping:'canteenId',type:'int'},
		{name:'canteenName',mapping:'canteenName',type:'string'},
		{name:'canteenStatus',mapping:'canteenStatus',type:'int'},
		{name:'description',mapping:'description',type:'string'},
		{name:'createTime',mapping:'createTime',type:'time',dataFormat:'YYYY-MM-dd HH:mm:ss'},
		{name:'editTime',mapping:'editTime',type:'time',dataFormat:'YYYY-MM-dd HH:mm:ss'},
	]
});