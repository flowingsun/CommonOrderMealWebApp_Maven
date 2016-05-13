Ext.define('OrderMealAdmin.controller.OrderSummaryController',
		{
			extend : 'Ext.app.Controller',
			init : function() {
				this.control({
					"OrderSummarySearchForm button[text='查找']" : {
						click : function(btn, o) {
							var form = btn.ownerCt.getForm();
							var params = form.getFieldValues();
							console.log(params);
							var store = btn.ownerCt.ownerCt
									.child("OrderSummaryGrid").getStore();
							store.load({
								params : params
							});
						}
					},
					"OrderSummarySearchForm button[text='重置']" : {
						click : function(btn, o) {
							var form = btn.ownerCt.getForm();
							form.reset();
							btn.ownerCt.ownerCt.child("OrderSummaryGrid").getStore()
									.load();
						}
					},
					"OrderSummaryGrid button[text='添加']" : {
						click : function(btn, o) {
							Ext.create('Ext.window.Window', {
								title : '添加菜单',
								modal : true,
								buttons : [ {
									xtype : 'button',
									text : '添加',
									handler : this.addOrderSummary
								}, {
									xtype : 'button',
									text : '取消',
									handler : function(btn, o) {
										btn.ownerCt.ownerCt.close();
									}
								} ],
								buttonAlign : 'center',
								items : [ {
									xtype : 'OrderSummaryForm',
									border : 0
								} ]
							}).show();
						}
					},
					"OrderSummaryGrid button[text='修改']" : {
						click : function(btn, o) {
							var win = Ext.create('Ext.window.Window', {
								title : '修改菜单',
								modal : true,
								buttons : [ {
									xtype : 'button',
									text : '修改',
									handler : this.updateOrderSummary
								}, {
									xtype : 'button',
									text : '取消',
									handler : function(btn, o) {
										btn.ownerCt.ownerCt.close();
									}
								} ],
								buttonAlign : 'center',
								items : [ {
									xtype : 'OrderSummaryForm',
									border : 0
								} ]
							});
							var grid = btn.ownerCt.ownerCt;
							var records = grid.getSelectionModel()
									.getSelection();
							win.child('OrderSummaryForm').loadRecord(records[0]);
							win.show();
						}
					},
					"OrderSummaryGrid button[text='查看菜式']" : {
						click : function(btn, o) {
							var win = Ext.create('Ext.window.Window', {
								title : '查看菜式',
								modal : true,
								items : [ {
									xtype : 'OrderSummaryForm',
									border : 0
								} ]
							});
							var grid = btn.ownerCt.ownerCt;
							var records = grid.getSelectionModel()
									.getSelection();
							win.child('OrderSummaryForm').loadRecord(records[0]);
							win.show();
						}
					},
					"OrderSummaryGrid" : {
						select : this.checkEdit,
						deselect : this.checkEdit,
						afterrender : function(panel, opts) {
							if(panel.ownerCt.ownerCt.xtype!="window"){
								panel.getStore().load();
							}
						}
					},
					"OrderSummaryGrid pagingtoolbar" : {
						beforechange : function(tool, page, opts) {
							var grid = tool.ownerCt;
							var form = grid.ownerCt.child('OrderSummarySearchForm');
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

			views : [ 'OrderSummary.OrderSummaryPanel'
			          ,'OrderSummary.OrderSummaryGrid'
			          ,'OrderSummary.OrderSummarySearchForm'
			          ,'OrderSummary.OrderSummaryForm' ],
			stores : [ 'OrderSummaryStore' ],
			models : [ 'OrderSummaryModel' ],
			checkEdit : function() {
				var grid = Ext.ComponentQuery.query("OrderSummaryGrid")[0];
				var btnEdit = Ext.ComponentQuery
						.query("OrderSummaryGrid button[text='修改']")[0];
				var btnDelete = Ext.ComponentQuery
						.query("OrderSummaryGrid button[text='停用']")[0];
				var num = grid.getSelectionModel().getSelection().length;
				btnEdit.setDisabled(num != 1);
				btnDelete.setDisabled(num < 1);
			},
			addOrderSummary : function(btn, o) {
				var form = btn.ownerCt.ownerCt.child('OrderSummaryForm');
				form.getForm().submit(
						{
							clientValidation : true,
							url : 'admin/OrderSummaryManage/addOrderSummary.html',
							success : function(form, action) {
								Ext.Msg.alert("提示", action.result.msg);
								btn.ownerCt.ownerCt.close();
								Ext.ComponentQuery
										.query("OrderSummaryGrid pagingtoolbar")[0]
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
			updateOrderSummary : function(btn, o) {
				var form = btn.ownerCt.ownerCt.child('OrderSummaryForm');
				var id = form.getRecord().get('OrderSummaryId');
				form.getForm().submit(
						{
							clientValidation : true,
							params : {
								"OrderSummaryId" : id
							},
							url : 'admin/OrderSummaryManage/updateOrderSummary.html',
							success : function(form, action) {
								Ext.Msg.alert("提示", action.result.msg);
								btn.ownerCt.ownerCt.close();
								Ext.ComponentQuery
										.query("OrderSummaryGrid pagingtoolbar")[0]
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