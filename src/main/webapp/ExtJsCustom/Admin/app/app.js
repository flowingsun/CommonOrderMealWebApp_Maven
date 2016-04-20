Ext.onReady(function(){
	Ext.QuickTips.init();
	Ext.Loader.setConfig({enabled:true});
	Ext.Loader.setPath({
		"appPath":'./ExtJsCustom/Admin/app'
	});
	Ext.apply(Ext.form.VTypes,{
	    password:function(val, field) { //val:这个文本框的值，field：这个文本框组件
	        if(field.confirmTo) { //confirmTo是自定义的配置参数，一般用来保存另外的组件的id值
	            var pwd = Ext.getCmp(field.confirmTo);  //取得confirmTo的那个id的值
	            return(val == pwd.getValue());
	        }
	        return false;
	    },
		passwordText:'两次输入的密码不一致'
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
								"<span style='display:inline;float:left;margin:2px 0 0 5px;'>" +
									"<img src='"+Golbal_BasePath+"/Resources/Image/java_coffee_cup_logo.png' style='width:36px;height:36px;' />" +
								"</span>" +
								"<span style='margin:20px 0 0 5px;float:left;font-size:16px;'>通用订餐系统后台管理平台</span>" +
								"<span style='float:right;margin:20px 0 0 0;font-size:15px;font-family:Microsoft Yahei;'>" + 
									"<span>您好," +
										"<span id='span_userName'>"+Golbal_UserName+"</span>" +
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
			'MainController','UserController','CanteenController'
		]
	});
});