Ext.onReady(function(){
	Ext.QuickTips.init();
	Ext.Loader.setConfig({enabled:true});
	Ext.Loader.setPath({
		"appPath":'./ExtJsCustom/Admin/app'
	});
	Ext.application({
		id:'app',
		name:'OrderMealAdmin',
		appFolder:"ExtJsCustom/Admin/app",
		launch:function(){
		var viewPort=Ext.create("Ext.container.Viewport",{
				id:'stusystem',
				layout:'fit',
				frame:true,
				paddings:'15 15 15 15',
				items:[{
					title : "<div style='display:inline;'>" +
								"<span style='display:inline;float:left;font-size:16px;margin:2px 0 0 5px;'>通用订餐系统后台管理平台</span>" +
								"<span style='float:right;margin:5px 10px 0 0;font-size:15px;font-family:Microsoft Yahei;'>" + 
									"<span>您好," +
										"<span id='span_userName'>"+Goble_UserName+"</span>" +
										"<span>&nbsp;&nbsp;&nbsp;&nbsp;<a href='admin/logout.html'>注销</a></span>" +
									"</span>" +
								"</span>" +
							"</div>",
					xtype:'mainpanel'
				}],
				renderTo:Ext.getBody()
			});
		},
		controllers:[
			'MainController','UserController'
		]
	});
});