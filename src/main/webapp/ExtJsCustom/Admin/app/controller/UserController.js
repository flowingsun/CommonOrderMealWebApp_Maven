Ext.define('OrderMealAdmin.controller.UserController',{
	extend:'Ext.app.Controller',
	init:function(){
		this.control({
			"UserSearchForm button[text='查找']":{
				click:function(btn,o){
					var form=btn.ownerCt.getForm();
					var params=form.getFieldValues();
					var store=btn.ownerCt.ownerCt.child("UserGrid").getStore();
					store.load({params:params});
				}
			},
			"UserSearchForm button[text='重置']":{
				click:function(btn,o){
					var form=btn.ownerCt.getForm();
					form.reset();
					btn.ownerCt.ownerCt.child("UserGrid").getStore().load();
				}
			},
			"UserGrid button[text='添加']":{
				click:function(btn,o){
					Ext.create('Ext.window.Window',{
						title:'添加用户',
						modal:true,
						buttons:[
							{xtype:'button',text:'添加',handler:this.addTeacher},
							{xtype:'button',text:'取消',handler:function(btn,o){
								btn.ownerCt.ownerCt.close();
							}}
						],
						buttonAlign:'center',
						items:[
							{xtype:'UserForm',border:0}
						]
					}).show();
				}
			},
			"UserGrid button[text='修改']":{
				click:function(btn,o){
					var win=Ext.create('Ext.window.Window',{
						title:'修改用户',
						modal:true,
						buttons:[
							{xtype:'button',text:'修改',handler:this.updateUser},
							{xtype:'button',text:'取消',handler:function(btn,o){
								btn.ownerCt.ownerCt.close();
							}}
						],
						buttonAlign:'center',
						items:[
							{xtype:'UserForm',border:0}
						]
					});
					var grid=btn.ownerCt.ownerCt;
					var records=grid.getSelectionModel().getSelection();
					win.child('UserForm').loadRecord(records[0]);//异步的...
					win.show();
				}
			},
			"UserGrid":{
				select:this.checkEdit,
				deselect:this.checkEdit,
				afterrender:function(panel,opts){
					panel.getStore().load();
				}
			},
			"UserGrid pagingtoolbar":{
				beforechange:function(tool,page,opts){
					var grid=tool.ownerCt;
					var form=grid.ownerCt.child('UserSearchForm');
					var params=form.getForm().getFieldValues();
					if(params.insId==null&&params.name==null){
						grid.getStore().loadPage(page);
					}else{
							if(!params.majorId){
							params.majorId=0;
						}
							if(!params.insId){
							params.insId=0;
						}
							params.page=page;
							grid.getStore().load({params:params});
					}
					return false;
				}
			}
		});
	},
	
	views:['UserPanel','UserGrid','UserSearchForm','UserForm'],
	stores:['UserStore'],
	models:['UserModel'],
	checkEdit:function(){
		var grid=Ext.ComponentQuery.query("UserGrid")[0];
		var btn=Ext.ComponentQuery.query("UserGrid button[text='修改']")[0];
		var num=grid.getSelectionModel().getSelection().length; 
		btn.setDisabled(num!=1);
	},
	addUser:function(btn,o){
		var form=btn.ownerCt.ownerCt.child('UserForm');
		form.getForm().submit({
			clientValidation:true,
			url:'admin/userManage/addUser.html',
			success: function(form, action) {
       			Ext.example.msg("提示",action.result.msg);
       			btn.ownerCt.ownerCt.close();
       			Ext.ComponentQuery.query("UserGrid pagingtoolbar")[0].doRefresh();
   			 },
   			failure: function(form, action) {
		        switch (action.failureType) {
		            case Ext.form.action.Action.CONNECT_FAILURE:
		               Ext.example.msg("错误","连接超时");
		                break;
		            case Ext.form.action.Action.SERVER_INVALID:
		               Ext.example.msg("错误","发生位置的错误");
		       }
		    }
		});
	},
	updateUser:function(btn,o){
		var form=btn.ownerCt.ownerCt.child('UserForm');
		var id=form.getRecord().get('user.id');
		form.getForm().submit({
			clientValidation:true,
			params:{
				"user.id":id
			},
			url:'admin/userManage/updateUser.html',
			success: function(form, action) {
				Ext.example.msg("提示",action.result.msg);
       			btn.ownerCt.ownerCt.close();
       			Ext.ComponentQuery.query("UserGrid pagingtoolbar")[0].doRefresh();
   			 },
   			failure: function(form, action) {
		        switch (action.failureType) {
		            case Ext.form.action.Action.CONNECT_FAILURE:
		                Ext.example.msg("错误","连接超时");
		                break;
		            case Ext.form.action.Action.SERVER_INVALID:
		               Ext.Msg.alert('错误', "发生未知的错误");
		       }
		    }
		});
	}
});