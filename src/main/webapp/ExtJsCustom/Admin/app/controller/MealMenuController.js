Ext.define('OrderMealAdmin.controller.MealMenuController',
		{
			extend : 'Ext.app.Controller',
			init : function() {
				this.control({
					"MealMenuSearchForm button[text='查找']" : {
						click : function(btn, o) {
							var form = btn.ownerCt.getForm();
							var params = form.getFieldValues();
							console.log(params);
							var store = btn.ownerCt.ownerCt
									.child("MealMenuGrid").getStore();
							store.load({
								params : params
							});
						}
					},
					"MealMenuSearchForm button[text='重置']" : {
						click : function(btn, o) {
							var form = btn.ownerCt.getForm();
							form.reset();
							btn.ownerCt.ownerCt.child("MealMenuGrid").getStore()
									.load();
						}
					},
					"MealMenuGrid button[text='添加']" : {
						click : function(btn, o) {
							Ext.create('Ext.window.Window', {
								title : '添加用户',
								modal : true,
								buttons : [ {
									xtype : 'button',
									text : '添加',
									handler : this.addMealMenu
								}, {
									xtype : 'button',
									text : '取消',
									handler : function(btn, o) {
										btn.ownerCt.ownerCt.close();
									}
								} ],
								buttonAlign : 'center',
								items : [ {
									xtype : 'MealMenuForm',
									border : 0
								} ]
							}).show();
						}
					},
					"MealMenuGrid button[text='修改']" : {
						click : function(btn, o) {
							var win = Ext.create('Ext.window.Window', {
								title : '修改用户',
								modal : true,
								buttons : [ {
									xtype : 'button',
									text : '修改',
									handler : this.updateMealMenu
								}, {
									xtype : 'button',
									text : '取消',
									handler : function(btn, o) {
										btn.ownerCt.ownerCt.close();
									}
								} ],
								buttonAlign : 'center',
								items : [ {
									xtype : 'MealMenuForm',
									border : 0
								} ]
							});
							var grid = btn.ownerCt.ownerCt;
							var records = grid.getSelectionModel()
									.getSelection();
							win.child('MealMenuForm').loadRecord(records[0]);
							win.show();
						}
					},
					"MealMenuGrid" : {
						select : this.checkEdit,
						deselect : this.checkEdit,
						afterrender : function(panel, opts) {
							panel.getStore().load();
						}
					},
					"MealMenuGrid pagingtoolbar" : {
						beforechange : function(tool, page, opts) {
							var grid = tool.ownerCt;
							var form = grid.ownerCt.child('MealMenuSearchForm');
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

			views : [ 'MealMenuPanel', 'MealMenuGrid', 'MealMenuSearchForm',
					'MealMenuForm' ],
			stores : [ 'MealMenuStore' ],
			models : [ 'MealMenuModel' ],
			checkEdit : function() {
				var grid = Ext.ComponentQuery.query("MealMenuGrid")[0];
				var btnEdit = Ext.ComponentQuery
						.query("MealMenuGrid button[text='修改']")[0];
				var btnDelete = Ext.ComponentQuery
						.query("MealMenuGrid button[text='停用']")[0];
				var num = grid.getSelectionModel().getSelection().length;
				btnEdit.setDisabled(num != 1);
				btnDelete.setDisabled(num < 1);
			},
			addMealMenu : function(btn, o) {
				var form = btn.ownerCt.ownerCt.child('MealMenuForm');
				form.getForm().submit(
						{
							clientValidation : true,
							url : 'admin/MealMenuManage/addMealMenu.html',
							success : function(form, action) {
								Ext.Msg.alert("提示", action.result.msg);
								btn.ownerCt.ownerCt.close();
								Ext.ComponentQuery
										.query("MealMenuGrid pagingtoolbar")[0]
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
			updateMealMenu : function(btn, o) {
				var form = btn.ownerCt.ownerCt.child('MealMenuForm');
				var id = form.getRecord().get('MealMenuId');
				form.getForm().submit(
						{
							clientValidation : true,
							params : {
								"MealMenuId" : id
							},
							url : 'admin/MealMenuManage/updateMealMenu.html',
							success : function(form, action) {
								Ext.Msg.alert("提示", action.result.msg);
								btn.ownerCt.ownerCt.close();
								Ext.ComponentQuery
										.query("MealMenuGrid pagingtoolbar")[0]
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