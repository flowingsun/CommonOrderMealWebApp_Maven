Ext.define('OrderMealAdmin.controller.MealPackageUserMarkController',
		{
			extend : 'Ext.app.Controller',
			init : function() {
				this.control({
					"MealPackageUserMarkSearchForm button[text='查找']" : {
						click : function(btn, o) {
							var form = btn.ownerCt.getForm();
							var params = form.getFieldValues();
							console.log(params);
							var store = btn.ownerCt.ownerCt
									.child("MealPackageUserMarkGrid").getStore();
							store.load({
								params : params
							});
						}
					},
					"MealPackageUserMarkSearchForm button[text='重置']" : {
						click : function(btn, o) {
							var form = btn.ownerCt.getForm();
							form.reset();
							btn.ownerCt.ownerCt.child("MealPackageUserMarkGrid").getStore()
									.load();
						}
					},
					"MealPackageUserMarkGrid button[text='添加']" : {
						click : function(btn, o) {
							Ext.create('Ext.window.Window', {
								title : '添加菜单',
								modal : true,
								buttons : [ {
									xtype : 'button',
									text : '添加',
									handler : this.addMealPackageUserMark
								}, {
									xtype : 'button',
									text : '取消',
									handler : function(btn, o) {
										btn.ownerCt.ownerCt.close();
									}
								} ],
								buttonAlign : 'center',
								items : [ {
									xtype : 'MealPackageUserMarkForm',
									border : 0
								} ]
							}).show();
						}
					},
					"MealPackageUserMarkGrid button[text='修改']" : {
						click : function(btn, o) {
							var win = Ext.create('Ext.window.Window', {
								title : '修改菜单',
								modal : true,
								buttons : [ {
									xtype : 'button',
									text : '修改',
									handler : this.updateMealPackageUserMark
								}, {
									xtype : 'button',
									text : '取消',
									handler : function(btn, o) {
										btn.ownerCt.ownerCt.close();
									}
								} ],
								buttonAlign : 'center',
								items : [ {
									xtype : 'MealPackageUserMarkForm',
									border : 0
								} ]
							});
							var grid = btn.ownerCt.ownerCt;
							var records = grid.getSelectionModel()
									.getSelection();
							win.child('MealPackageUserMarkForm').loadRecord(records[0]);
							win.show();
						}
					},
					"MealPackageUserMarkGrid button[text='查看菜式']" : {
						click : function(btn, o) {
							var win = Ext.create('Ext.window.Window', {
								title : '查看菜式',
								modal : true,
								items : [ {
									xtype : 'MealPackageUserMarkForm',
									border : 0
								} ]
							});
							var grid = btn.ownerCt.ownerCt;
							var records = grid.getSelectionModel()
									.getSelection();
							win.child('MealPackageUserMarkForm').loadRecord(records[0]);
							win.show();
						}
					},
					"MealPackageUserMarkGrid" : {
						select : this.checkEdit,
						deselect : this.checkEdit,
						afterrender : function(panel, opts) {
							if(panel.ownerCt.ownerCt.xtype!="window"){
								panel.getStore().load();
							}
						}
					},
					"MealPackageUserMarkGrid pagingtoolbar" : {
						beforechange : function(tool, page, opts) {
							var grid = tool.ownerCt;
							var form = grid.ownerCt.child('MealPackageUserMarkSearchForm');
							var params = form.getForm().getFieldValues();
							params.page = page;
							grid.getStore().load({
								params : params
							});
							return false;
						}
					}
				});
			},

			views : [ 'MealPackageUserMark.MealPackageUserMarkPanel'
			          ,'MealPackageUserMark.MealPackageUserMarkGrid'
			          ,'MealPackageUserMark.MealPackageUserMarkSearchForm'
			          ,'MealPackageUserMark.MealPackageUserMarkForm' ],
			stores : [ 'MealPackageUserMarkStore' ],
			models : [ 'MealPackageUserMarkModel' ],
			checkEdit : function() {
				var grid = Ext.ComponentQuery.query("MealPackageUserMarkGrid")[0];
				var btnEdit = Ext.ComponentQuery
						.query("MealPackageUserMarkGrid button[text='修改']")[0];
				var btnDelete = Ext.ComponentQuery
						.query("MealPackageUserMarkGrid button[text='停用']")[0];
				var num = grid.getSelectionModel().getSelection().length;
				btnEdit.setDisabled(num != 1);
				btnDelete.setDisabled(num < 1);
			},
			addMealPackageUserMark : function(btn, o) {
				var form = btn.ownerCt.ownerCt.child('MealPackageUserMarkForm');
				form.getForm().submit(
						{
							clientValidation : true,
							url : 'admin/MealPackageUserMarkManage/addMealPackageUserMark.html',
							success : function(form, action) {
								Ext.Msg.alert("提示", action.result.msg);
								btn.ownerCt.ownerCt.close();
								Ext.ComponentQuery
										.query("MealPackageUserMarkGrid pagingtoolbar")[0]
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
			updateMealPackageUserMark : function(btn, o) {
				var form = btn.ownerCt.ownerCt.child('MealPackageUserMarkForm');
				var id = form.getRecord().get('MealPackageUserMarkId');
				form.getForm().submit(
						{
							clientValidation : true,
							params : {
								"MealPackageUserMarkId" : id
							},
							url : 'admin/MealPackageUserMarkManage/updateMealPackageUserMark.html',
							success : function(form, action) {
								Ext.Msg.alert("提示", action.result.msg);
								btn.ownerCt.ownerCt.close();
								Ext.ComponentQuery
										.query("MealPackageUserMarkGrid pagingtoolbar")[0]
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