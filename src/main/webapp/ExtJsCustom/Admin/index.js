Ext.onReady(function(){
	//头部标签
	var paPaNorth = Ext.create("Ext.panel.Panel",{
		id : 'paPaNorth',
		autoWidth : true,
		heigth : 150,
		frame : true,
		region : 'north',
		html : "<div><h1 style='display:inline;float:left;'>OrderMealSys</h1><span style='float:right;margin:35px 10px 0 0;font-size:15px;font-family:Microsoft Yahei;'>"
		+ "<span>您好,<span id='span_userName'></span><span>&nbsp;&nbsp;&nbsp;&nbsp;<a href='admin/logout.html'>注销</a></span></div>"
	});
	//左部树形标签
	var trPaWest = Ext.create("Ext.tree.Panel",{
		id:"trPaWest",
		width:150,
		height:'auto',
		region:'west',
		split : true,//显示分隔条  
		title:"菜单项"
	});
	//中部多标签栏
	var taPnCenter = Ext.create("Ext.tab.Panel",{
		region : 'center',
		id:"taPnCenter",
		activeTab : 0,
		items : [ {
			title : 'test1',
			authHeight : true,
			closable : true,//是否可关闭  
			html : 'c1。。。'
		}, {
			title : 'test2',
			authHeight : true,
			closable : true,//是否可关闭  
			html : 'c2。。。'
		} ]
	});
	//脚部标签
	var taPnSouth = Ext.create("Ext.tab.Panel",{
		id : 'taPnSouth',
		width : 'auto',
		heigth : '20',
		title:'状态栏',
		split : false,//显示分隔条  
		region : 'south'
	});
	//主窗体
	var coVpMain = Ext.create("Ext.container.Viewport",{
		layout : "border",
		id : "coVpMain",
		items : [ paPaNorth,trPaWest,taPnCenter,taPnSouth ]
	});
});