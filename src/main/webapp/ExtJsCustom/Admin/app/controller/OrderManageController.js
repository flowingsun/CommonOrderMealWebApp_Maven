Ext.define('OrderMealAdmin.controller.OrderManageController',
		{
			extend : 'Ext.app.Controller',
			init : function() {
				this.control({
					"OrderManageSearchForm button[text='查找']" : {
						click : function(btn, o) {
							var form = btn.ownerCt.getForm();
							var params = form.getFieldValues();
							console.log(params);
							var store = btn.ownerCt.ownerCt
									.child("OrderManageGrid").getStore();
							store.load({
								params : params
							});
						}
					},
					"OrderManageSearchForm button[text='重置']" : {
						click : function(btn, o) {
							var form = btn.ownerCt.getForm();
							form.reset();
							btn.ownerCt.ownerCt.child("OrderManageGrid").getStore()
									.load();
						}
					},
					"OrderManageGrid button[text='添加']" : {
						click : function(btn, o) {
							Ext.create('Ext.window.Window', {
								title : '添加菜单',
								modal : true,
								buttons : [ {
									xtype : 'button',
									text : '添加',
									handler : this.addOrderManage
								}, {
									xtype : 'button',
									text : '取消',
									handler : function(btn, o) {
										btn.ownerCt.ownerCt.close();
									}
								} ],
								buttonAlign : 'center',
								items : [ {
									xtype : 'OrderManageForm',
									border : 0
								} ]
							}).show();
						}
					},
					"OrderManageGrid button[text='修改']" : {
						click : function(btn, o) {
							var win = Ext.create('Ext.window.Window', {
								title : '修改菜单',
								modal : true,
								buttons : [ {
									xtype : 'button',
									text : '修改',
									handler : this.updateOrderManage
								}, {
									xtype : 'button',
									text : '取消',
									handler : function(btn, o) {
										btn.ownerCt.ownerCt.close();
									}
								} ],
								buttonAlign : 'center',
								items : [ {
									xtype : 'OrderManageForm',
									border : 0
								} ]
							});
							var grid = btn.ownerCt.ownerCt;
							var records = grid.getSelectionModel()
									.getSelection();
							win.child('OrderManageForm').loadRecord(records[0]);
							win.show();
						}
					},
					"OrderManageGrid button[text='查看菜式']" : {
						click : function(btn, o) {
							var win = Ext.create('Ext.window.Window', {
								title : '查看菜式',
								modal : true,
								items : [ {
									xtype : 'OrderManageForm',
									border : 0
								} ]
							});
							var grid = btn.ownerCt.ownerCt;
							var records = grid.getSelectionModel()
									.getSelection();
							win.child('OrderManageForm').loadRecord(records[0]);
							win.show();
						}
					},
					"OrderManageGrid" : {
						select : this.checkEdit,
						deselect : this.checkEdit,
						afterrender : function(panel, opts) {
							if(panel.ownerCt.ownerCt.xtype!="window"){
								panel.getStore().load();
							}
						}
					},
					"OrderManageGrid pagingtoolbar" : {
						beforechange : function(tool, page, opts) {
							var grid = tool.ownerCt;
							var form = grid.ownerCt.child('OrderManageSearchForm');
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

			views : [ 'OrderManage.OrderManagePanel'
			          ,'OrderManage.OrderManageGrid'
			          ,'OrderManage.OrderManageSearchForm'
			          ,'OrderManage.OrderManageForm' ],
			stores : [ 'OrderManageStore' ],
			models : [ 'OrderManageModel' ],
			checkEdit : function() {
				var grid = Ext.ComponentQuery.query("OrderManageGrid")[0];
				var btnEdit = Ext.ComponentQuery
						.query("OrderManageGrid button[text='修改']")[0];
				var btnDelete = Ext.ComponentQuery
						.query("OrderManageGrid button[text='停用']")[0];
				var num = grid.getSelectionModel().getSelection().length;
				btnEdit.setDisabled(num != 1);
				btnDelete.setDisabled(num < 1);
			},
			addOrderManage : function(btn, o) {
				var form = btn.ownerCt.ownerCt.child('OrderManageForm');
				form.getForm().submit(
						{
							clientValidation : true,
							url : 'admin/OrderManageManage/addOrderManage.html',
							success : function(form, action) {
								Ext.Msg.alert("提示", action.result.msg);
								btn.ownerCt.ownerCt.close();
								Ext.ComponentQuery
										.query("OrderManageGrid pagingtoolbar")[0]
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
			updateOrderManage : function(btn, o) {
				var form = btn.ownerCt.ownerCt.child('OrderManageForm');
				var id = form.getRecord().get('OrderManageId');
				form.getForm().submit(
						{
							clientValidation : true,
							params : {
								"OrderManageId" : id
							},
							url : 'admin/OrderManageManage/updateOrderManage.html',
							success : function(form, action) {
								Ext.Msg.alert("提示", action.result.msg);
								btn.ownerCt.ownerCt.close();
								Ext.ComponentQuery
										.query("OrderManageGrid pagingtoolbar")[0]
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