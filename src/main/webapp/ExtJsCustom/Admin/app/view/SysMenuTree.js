Ext.define("OrderMealAdmin.view.SysMenuTree",{
	extend:'Ext.tree.Panel',
	
	alias:'widget.SysMenuTree',
	rootVisible:false,
	store:'SysMenuStore',
	dockedItems:[{
		xtype:'toolbar',
		dock:'top',
		items:[
			{xtype:'button',text:'展开全部',icon:'/CommonOrderMealWepApp_Maven/ExtJsCustom/images/connect.png'}
		]
	}]
	
});