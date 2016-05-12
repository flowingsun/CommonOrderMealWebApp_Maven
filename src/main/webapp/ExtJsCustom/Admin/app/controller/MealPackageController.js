Ext.define('OrderMealAdmin.controller.MealPackageController',
		{
			extend : 'Ext.app.Controller',
			init : function() {
				this.control({
					"MealPackageSearchForm button[text='查找']" : {
						click : function(btn, o) {
							var form = btn.ownerCt.getForm();
							var params = form.getFieldValues();
							console.log(params);
							var store = btn.ownerCt.ownerCt
									.child("MealPackageGrid").getStore();
							store.load({
								params : params
							});
						}
					},
					"MealPackageSearchForm button[text='重置']" : {
						click : function(btn, o) {
							var form = btn.ownerCt.getForm();
							form.reset();
							btn.ownerCt.ownerCt.child("MealPackageGrid").getStore()
									.load();
						}
					},
					"MealPackageGrid button[text='添加']" : {
						click : function(btn, o) {
							Ext.create('Ext.window.Window', {
								title : '添加菜单',
								modal : true,
								buttons : [ {
									xtype : 'button',
									text : '添加',
									handler : this.addMealPackage
								}, {
									xtype : 'button',
									text : '取消',
									handler : function(btn, o) {
										btn.ownerCt.ownerCt.close();
									}
								} ],
								buttonAlign : 'center',
								items : [ {
									xtype : 'MealPackageForm',
									border : 0
								} ]
							}).show();
						}
					},
					"MealPackageGrid button[text='修改']" : {
						click : function(btn, o) {
							var win = Ext.create('Ext.window.Window', {
								title : '修改菜单',
								modal : true,
								buttons : [ {
									xtype : 'button',
									text : '修改',
									handler : this.updateMealPackage
								}, {
									xtype : 'button',
									text : '取消',
									handler : function(btn, o) {
										btn.ownerCt.ownerCt.close();
									}
								} ],
								buttonAlign : 'center',
								items : [ {
									xtype : 'MealPackageForm',
									border : 0
								} ]
							});
							var grid = btn.ownerCt.ownerCt;
							var records = grid.getSelectionModel()
									.getSelection();
							win.child('MealPackageForm').loadRecord(records[0]);
							win.show();
						}
					},
					"MealPackageGrid button[text='查看菜式']" : {
						click : function(btn, o) {
							var win = Ext.create('Ext.window.Window', {
								title : '查看菜式',
								modal : true,
								items : [ {
									xtype : 'MealPackageForm',
									border : 0
								} ]
							});
							var grid = btn.ownerCt.ownerCt;
							var records = grid.getSelectionModel()
									.getSelection();
							win.child('MealPackageForm').loadRecord(records[0]);
							win.show();
						}
					},
					"MealPackageGrid" : {
						select : this.checkEdit,
						deselect : this.checkEdit,
						afterrender : function(panel, opts) {
							if(panel.ownerCt.ownerCt.xtype!="window"){
								panel.getStore().load();
							}
						}
					},
					"MealPackageGrid pagingtoolbar" : {
						beforechange : function(tool, page, opts) {
							var grid = tool.ownerCt;
							var form = grid.ownerCt.child('MealPackageSearchForm');
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

			views : [ 'MealPackagePanel', 'MealPackageGrid', 'MealPackageSearchForm',
					'MealPackageForm' ],
			stores : [ 'MealPackageStore' ],
			models : [ 'MealPackageModel' ],
			checkEdit : function() {
				var grid = Ext.ComponentQuery.query("MealPackageGrid")[0];
				var btnEdit = Ext.ComponentQuery
						.query("MealPackageGrid button[text='修改']")[0];
				var btnDelete = Ext.ComponentQuery
						.query("MealPackageGrid button[text='停用']")[0];
				var num = grid.getSelectionModel().getSelection().length;
				btnEdit.setDisabled(num != 1);
				btnDelete.setDisabled(num < 1);
			},
			addMealPackage : function(btn, o) {
				var form = btn.ownerCt.ownerCt.child('MealPackageForm');
				form.getForm().submit(
						{
							clientValidation : true,
							url : 'admin/MealPackageManage/addMealPackage.html',
							success : function(form, action) {
								Ext.Msg.alert("提示", action.result.msg);
								btn.ownerCt.ownerCt.close();
								Ext.ComponentQuery
										.query("MealPackageGrid pagingtoolbar")[0]
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
			updateMealPackage : function(btn, o) {
				var form = btn.ownerCt.ownerCt.child('MealPackageForm');
				var id = form.getRecord().get('MealPackageId');
				form.getForm().submit(
						{
							clientValidation : true,
							params : {
								"MealPackageId" : id
							},
							url : 'admin/MealPackageManage/updateMealPackage.html',
							success : function(form, action) {
								Ext.Msg.alert("提示", action.result.msg);
								btn.ownerCt.ownerCt.close();
								Ext.ComponentQuery
										.query("MealPackageGrid pagingtoolbar")[0]
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