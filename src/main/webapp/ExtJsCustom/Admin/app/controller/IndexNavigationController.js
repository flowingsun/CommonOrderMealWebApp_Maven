Ext.define('OrderMealAdmin.controller.IndexNavigationController',
		{
			extend : 'Ext.app.Controller',
			init : function() {
				this.control({
					"IndexNavigationSearchForm button[text='查找']" : {
						click : function(btn, o) {
							var form = btn.ownerCt.getForm();
							var params = form.getFieldValues();
							console.log(params);
							var store = btn.ownerCt.ownerCt
									.child("IndexNavigationGrid").getStore();
							store.load({
								params : params
							});
						}
					},
					"IndexNavigationSearchForm button[text='重置']" : {
						click : function(btn, o) {
							var form = btn.ownerCt.getForm();
							form.reset();
							btn.ownerCt.ownerCt.child("IndexNavigationGrid").getStore()
									.load();
						}
					},
					"IndexNavigationGrid button[text='添加']" : {
						click : function(btn, o) {
							Ext.create('Ext.window.Window', {
								title : '添加菜单',
								modal : true,
								buttons : [ {
									xtype : 'button',
									text : '添加',
									handler : this.addIndexNavigation
								}, {
									xtype : 'button',
									text : '取消',
									handler : function(btn, o) {
										btn.ownerCt.ownerCt.close();
									}
								} ],
								buttonAlign : 'center',
								items : [ {
									xtype : 'IndexNavigationForm',
									border : 0
								} ]
							}).show();
						}
					},
					"IndexNavigationGrid button[text='修改']" : {
						click : function(btn, o) {
							var win = Ext.create('Ext.window.Window', {
								title : '修改菜单',
								modal : true,
								buttons : [ {
									xtype : 'button',
									text : '修改',
									handler : this.updateIndexNavigation
								}, {
									xtype : 'button',
									text : '取消',
									handler : function(btn, o) {
										btn.ownerCt.ownerCt.close();
									}
								} ],
								buttonAlign : 'center',
								items : [ {
									xtype : 'IndexNavigationForm',
									border : 0
								} ]
							});
							var grid = btn.ownerCt.ownerCt;
							var records = grid.getSelectionModel()
									.getSelection();
							win.child('IndexNavigationForm').loadRecord(records[0]);
							win.show();
						}
					},
					"IndexNavigationGrid button[text='查看菜式']" : {
						click : function(btn, o) {
							var win = Ext.create('Ext.window.Window', {
								title : '查看菜式',
								modal : true,
								items : [ {
									xtype : 'IndexNavigationForm',
									border : 0
								} ]
							});
							var grid = btn.ownerCt.ownerCt;
							var records = grid.getSelectionModel()
									.getSelection();
							win.child('IndexNavigationForm').loadRecord(records[0]);
							win.show();
						}
					},
					"IndexNavigationGrid" : {
						select : this.checkEdit,
						deselect : this.checkEdit,
						afterrender : function(panel, opts) {
							if(panel.ownerCt.ownerCt.xtype!="window"){
								panel.getStore().load();
							}
						}
					},
					"IndexNavigationGrid pagingtoolbar" : {
						beforechange : function(tool, page, opts) {
							var grid = tool.ownerCt;
							var form = grid.ownerCt.child('IndexNavigationSearchForm');
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

			views : [ 'IndexNavigation.IndexNavigationPanel'
			          ,'IndexNavigation.IndexNavigationGrid'
			          ,'IndexNavigation.IndexNavigationSearchForm'
			          ,'IndexNavigation.IndexNavigationForm' ],
			stores : [ 'IndexNavigationStore' ],
			models : [ 'IndexNavigationModel' ],
			checkEdit : function() {
				var grid = Ext.ComponentQuery.query("IndexNavigationGrid")[0];
				var btnEdit = Ext.ComponentQuery
						.query("IndexNavigationGrid button[text='修改']")[0];
				var btnDelete = Ext.ComponentQuery
						.query("IndexNavigationGrid button[text='停用']")[0];
				var num = grid.getSelectionModel().getSelection().length;
				btnEdit.setDisabled(num != 1);
				btnDelete.setDisabled(num < 1);
			},
			addIndexNavigation : function(btn, o) {
				var form = btn.ownerCt.ownerCt.child('IndexNavigationForm');
				form.getForm().submit(
						{
							clientValidation : true,
							url : 'admin/IndexNavigationManage/addIndexNavigation.html',
							success : function(form, action) {
								Ext.Msg.alert("提示", action.result.msg);
								btn.ownerCt.ownerCt.close();
								Ext.ComponentQuery
										.query("IndexNavigationGrid pagingtoolbar")[0]
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
			updateIndexNavigation : function(btn, o) {
				var form = btn.ownerCt.ownerCt.child('IndexNavigationForm');
				var id = form.getRecord().get('IndexNavigationId');
				form.getForm().submit(
						{
							clientValidation : true,
							params : {
								"IndexNavigationId" : id
							},
							url : 'admin/IndexNavigationManage/updateIndexNavigation.html',
							success : function(form, action) {
								Ext.Msg.alert("提示", action.result.msg);
								btn.ownerCt.ownerCt.close();
								Ext.ComponentQuery
										.query("IndexNavigationGrid pagingtoolbar")[0]
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