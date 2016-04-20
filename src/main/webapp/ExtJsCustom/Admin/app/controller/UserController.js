Ext.define('OrderMealAdmin.controller.UserController',
		{
			extend : 'Ext.app.Controller',
			init : function() {
				this.control({
					"UserSearchForm button[text='查找']" : {
						click : function(btn, o) {
							var form = btn.ownerCt.getForm();
							var params = form.getFieldValues();
							var store = btn.ownerCt.ownerCt.child("UserGrid")
									.getStore();
							store.load({
								params : params
							});
						}
					},
					"UserSearchForm button[text='重置']" : {
						click : function(btn, o) {
							var form = btn.ownerCt.getForm();
							form.reset();
							btn.ownerCt.ownerCt.child("UserGrid").getStore()
									.load();
						}
					},
					"UserGrid button[text='添加']" : {
						click : function(btn, o) {
							Ext.create('Ext.window.Window', {
								title : '添加用户',
								modal : true,
								buttons : [ {
									xtype : 'button',
									text : '添加',
									handler : this.addUser
								}, {
									xtype : 'button',
									text : '取消',
									handler : function(btn, o) {
										btn.ownerCt.ownerCt.close();
									}
								} ],
								buttonAlign : 'center',
								items : [ {
									xtype : 'UserFormNewUser',
									border : 0
								} ]
							}).show();
						}
					},
					"UserGrid button[text='修改']" : {
						click : function(btn, o) {
							var win = Ext.create('Ext.window.Window', {
								title : '修改用户',
								modal : true,
								buttons : [ {
									xtype : 'button',
									text : '修改',
									handler : this.updateUser
								}, {
									xtype : 'button',
									text : '取消',
									handler : function(btn, o) {
										btn.ownerCt.ownerCt.close();
									}
								} ],
								buttonAlign : 'center',
								items : [ {
									xtype : 'UserForm',
									border : 0
								} ]
							});
							var grid = btn.ownerCt.ownerCt;
							var records = grid.getSelectionModel()
									.getSelection();
							win.child('UserForm').loadRecord(records[0]);// 异步的...
							win.show();
						}
					},
					"UserGrid button[text='停用']":{
						click:function(btn,o){
							var grid=btn.ownerCt.ownerCt;
							var records=grid.getSelectionModel().getSelection();
							if(records.length==0){
								Ext.MessageBox.alert("提示","请至少选择一条记录");
							}else{
								this.freezeUser(grid,records);
							}
						}
					},
					"UserGrid" : {
						select : this.checkEdit,
						deselect : this.checkEdit,
						afterrender : function(panel, opts) {
							panel.getStore().load();
						}
					},
					"UserGrid pagingtoolbar" : {
						beforechange : function(tool, page, opts) {
							var grid = tool.ownerCt;
							var form = grid.ownerCt.child('UserSearchForm');
							var params = form.getForm().getFieldValues();
							if (params.insId == null && params.name == null) {
								grid.getStore().loadPage(page);
							} else {
								if (!params.majorId) {
									params.majorId = 0;
								}
								if (!params.insId) {
									params.insId = 0;
								}
								params.page = page;
								grid.getStore().load({
									params : params
								});
							}
							return false;
						}
					}
				});
			},

			views : [ 'UserPanel', 'UserGrid', 'UserSearchForm', 'UserForm',
					'UserFormNewUser' ],
			stores : [ 'UserStore' ],
			models : [ 'UserModel' ],
			checkEdit : function() {
				var grid = Ext.ComponentQuery.query("UserGrid")[0];
				var btnEdit = Ext.ComponentQuery
						.query("UserGrid button[text='修改']")[0];
				var btnDelete = Ext.ComponentQuery
						.query("UserGrid button[text='停用']")[0];
				var num = grid.getSelectionModel().getSelection().length;
				btnEdit.setDisabled(num != 1);
				btnDelete.setDisabled(num < 1);
			},
			testsub : function() {
				alert('test');
			},
			addUser : function(btn, o) {
				var form = btn.ownerCt.ownerCt.child('UserFormNewUser');
				form.getForm().submit(
						{
							clientValidation : true,
							url : 'admin/userManage/addUser.html',
							success : function(form, action) {
								Ext.Msg.alert("提示", action.result.msg);
								btn.ownerCt.ownerCt.close();
								Ext.ComponentQuery
										.query("UserGrid pagingtoolbar")[0]
										.doRefresh();
							},
							failure : function(form, action) {
								switch (action.failureType) {
								case Ext.form.action.Action.CONNECT_FAILURE:
									Ext.Msg.alert("错误", "连接超时");
									break;
								default:
									Ext.Msg.alert("错误", action.result.msg);
								}
							}
						});
			},
			updateUser : function(btn, o) {
				var form = btn.ownerCt.ownerCt.child('UserForm');
				var id = form.getRecord().get('userID');
				form.getForm().submit(
						{
							clientValidation : true,
							params : {
								"userID" : id
							},
							url : 'admin/userManage/updateUser.html',
							success : function(form, action) {
								Ext.Msg.alert("提示", action.result.msg);
								btn.ownerCt.ownerCt.close();
								Ext.ComponentQuery
										.query("UserGrid pagingtoolbar")[0]
										.doRefresh();
							},
							failure : function(form, action) {
								switch (action.failureType) {
								case Ext.form.action.Action.CONNECT_FAILURE:
									Ext.Msg.alert("错误", "连接超时");
									break;
								default:
									Ext.Msg.alert('错误', action.result.msg);
								}
							}
						});
			},
			freezeUser:function(grid,records){
				Ext.MessageBox.confirm('提示', '确定要停用所选用户吗？',function(btn){
					if(btn=='yes'){
						var array=new Array();
						Ext.each(records,function(model){
							array.push(model.get('userID'));
							//debugger;
						});
						var str=array.join(',');
						Ext.Ajax.request({
							method:'post',
							url:'admin/userManage/freezeUsers.html',
							params:{
								userIds:str
							},
							success : function(form, action) {
								debugger;
								Ext.Msg.alert("提示", action.result.msg);
								btn.ownerCt.ownerCt.close();
								Ext.ComponentQuery
										.query("UserGrid pagingtoolbar")[0]
										.doRefresh();
							},
							failure : function(form, action) {
								switch (action.failureType) {
								case Ext.form.action.Action.CONNECT_FAILURE:
									Ext.Msg.alert("错误", "连接超时");
									break;
								default:
									Ext.Msg.alert('错误', action.result.msg);
								}
							}
						});
					}
				});
			}
		});