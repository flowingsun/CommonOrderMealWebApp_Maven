Ext.define('OrderMealAdmin.model.UserModel',{
	extend:'Ext.data.Model',
	fields:[
		{name:'userID',mapping:'userID',type:'int'},
		{name:'userName',mapping:'userName',type:'string'},
		{name:'loginname',mapping:'loginname',type:'string'},
		{name:'postion',mapping:'postion',type:'string'},
		{name:'telePhone',mapping:'telePhone',type:'string'},
		{name:'email',mapping:'email',type:'string'},
		{name:'sex',mapping:'sex',type:'string'},
		{name:'userLocation',mapping:'userLocation',type:'string'},
		{name:'birthday',mapping:'birthday',type:'date',dataFormat:'YYYY-MM-dd'},
		{name:'userState',mapping:'userState',type:'int'}
	]
});