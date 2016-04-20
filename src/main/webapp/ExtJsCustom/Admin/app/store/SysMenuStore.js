Ext.define("OrderMealAdmin.store.SysMenuStore",{
	extend:'Ext.data.TreeStore',
	storeId: 'SysMenuStore',
	defaultRootId:'root',
	proxy:{
		type:'ajax',
		url:'/CommonOrderMealWepApp_Maven/admin/GetAllSysMenu.html',
		reader:{
			type:'json'
		},
		autoLoad:true
	}
	
});