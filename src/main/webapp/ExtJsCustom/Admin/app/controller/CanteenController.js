Ext.define('OrderMealAdmin.controller.CanteenController',
		{
			extend : 'Ext.app.Controller',
			init : function() {
				this.control({
					"CanteenSearchForm button[text='查找']" : {
						click : function(btn, o) {
							var form = btn.ownerCt.getForm();
							var params = form.getFieldValues();
							console.log(params);
							var store = btn.ownerCt.ownerCt
									.child("CanteenGrid").getStore();
							store.load({
								params : params
							});
						}
					},
					"CanteenSearchForm button[text='重置']" : {
						click : function(btn, o) {
							var form = btn.ownerCt.getForm();
							form.reset();
							btn.ownerCt.ownerCt.child("CanteenGrid").getStore()
									.load();
						}
					},
					"CanteenGrid button[text='添加']" : {
						click : function(btn, o) {
							Ext.create('Ext.window.Window', {
								title : '添加用户',
								modal : true,
								buttons : [ {
									xtype : 'button',
									text : '添加',
									handler : this.addCanteen
								}, {
									xtype : 'button',
									text : '取消',
									handler : function(btn, o) {
										btn.ownerCt.ownerCt.close();
									}
								} ],
								buttonAlign : 'center',
								items : [ {
									xtype : 'CanteenForm',
									border : 0
								} ]
							}).show();
						}
					},
					"CanteenGrid button[text='修改']" : {
						click : function(btn, o) {
							var win = Ext.create('Ext.window.Window', {
								title : '修改餐厅',
								modal : true,
								// resizable : false,
								buttons : [ {
									xtype : 'button',
									text : '修改',
									handler : this.updateCanteen
								}, {
									xtype : 'button',
									text : '取消',
									handler : function(btn, o) {
										btn.ownerCt.ownerCt.close();
									}
								} ],
								buttonAlign : 'center',
								items : [ {
									xtype : 'CanteenForm',
									border : 0
								} ]
							});
							var grid = btn.ownerCt.ownerCt;
							var records = grid.getSelectionModel()
									.getSelection();
							win.child('CanteenForm').loadRecord(records[0]);
							win.show();
						}
					},
					"CanteenGrid button[text='查看菜单']" : {
						click : function(btn, o) {
							var win = Ext.create('Ext.window.Window', {
								title : '查看菜单',
								modal : true,
								resizable : false,
								scrollable : true,
								width : 800,
								height : 540,
								items : [ {
									xtype : 'MealMenuPanel',
									border : 0
								} ]
							});
							var grid = btn.ownerCt.ownerCt;
							var records = grid.getSelectionModel()
									.getSelection();
							// debugger;
							// console.log(records[0].raw)
							var menuGrid = win.child('MealMenuPanel').child(
									'MealMenuGrid');
							menuGrid.getStore().load({
								params : {
									'canteenId' : records[0].raw.canteenId
								}
							});
							win.show();
						}
					},
					"CanteenGrid" : {
						select : this.checkEdit,
						deselect : this.checkEdit,
						afterrender : function(panel, opts) {
							panel.getStore().load();
						}
					},
					"CanteenGrid pagingtoolbar" : {
						beforechange : function(tool, page, opts) {
							var grid = tool.ownerCt;
							var form = grid.ownerCt.child('CanteenSearchForm');
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

			views : [ 'Canteen.CanteenPanel', 'Canteen.CanteenGrid', 'Canteen.CanteenSearchForm',
					'Canteen.CanteenForm' ],
			stores : [ 'CanteenStore' ],
			models : [ 'CanteenModel' ],
			checkEdit : function() {
				var grid = Ext.ComponentQuery.query("CanteenGrid")[0];
				var btnEdit = Ext.ComponentQuery
						.query("CanteenGrid button[text='修改']")[0];
				var btnDelete = Ext.ComponentQuery
						.query("CanteenGrid button[text='停用']")[0];
				var btnShowMealMenu = Ext.ComponentQuery
						.query("CanteenGrid button[text='查看菜单']")[0];
				var num = grid.getSelectionModel().getSelection().length;
				btnEdit.setDisabled(num != 1);
				btnDelete.setDisabled(num < 1);
				btnShowMealMenu.setDisabled(num != 1)
			},
			addCanteen : function(btn, o) {
				var form = btn.ownerCt.ownerCt.child('CanteenForm');
				form.getForm().submit(
						{
							clientValidation : true,
							url : 'admin/CanteenManage/addCanteen.html',
							success : function(form, action) {
								Ext.Msg.alert("提示", action.result.msg);
								btn.ownerCt.ownerCt.close();
								Ext.ComponentQuery
										.query("CanteenGrid pagingtoolbar")[0]
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
			updateCanteen : function(btn, o) {
				var form = btn.ownerCt.ownerCt.child('CanteenForm');
				var id = form.getRecord().get('canteenId');
				form.getForm().submit(
						{
							clientValidation : true,
							params : {
								"canteenId" : id
							},
							url : 'admin/CanteenManage/updateCanteen.html',
							success : function(form, action) {
								Ext.Msg.alert("提示", action.result.msg);
								btn.ownerCt.ownerCt.close();
								Ext.ComponentQuery
										.query("CanteenGrid pagingtoolbar")[0]
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