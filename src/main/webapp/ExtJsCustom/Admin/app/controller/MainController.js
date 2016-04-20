Ext.define("OrderMealAdmin.controller.MainController",{
	extend:'Ext.app.Controller',
	init:function(){
		var me=this;
		this.control({
			"SysMenuTree":{
				itemclick:function(panel,record){
					var me=this;
					var tabs = Ext.getCmp("center-panel");
					var treeNode = record.raw;
					var pageThemes = treeNode.pageThemes;
					var menuName = treeNode.menuName;
					var tab = tabs.getComponent(pageThemes);
					if(tab){
						tabs.setActiveTab(tab);//Active 
					}else if(pageThemes.trim()!=""){
						tabs.add({
							id : pageThemes,
							closable : true,
							title : menuName,
							xtype:pageThemes
						}).show();
					}
				}
			},
			"SysMenuTree button:first":{
				click:function(btn,o){
					var treePanel=btn.ownerCt.ownerCt;
					if(btn.getText()=="展开全部"){
						treePanel.expandAll();
						btn.setText('收起全部');
					}else{
						treePanel.collapseAll();
						btn.setText('展开全部');
					}
					
					
				}
			}
		});
	},
	views:['MainPanel','SysMenuTree'],
	stores:['SysMenuStore']
});