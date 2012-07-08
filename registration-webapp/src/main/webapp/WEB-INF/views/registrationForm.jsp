<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Registration manager</title>
	<link href="<c:url value="/resources/ext-3.3.1/resources/css/ext-all.css" />" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<c:url value="/resources/ext-3.3.1/adapter/ext/ext-base.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/ext-3.3.1/ext-all.js" />"></script>
	<style type="text/css">
		body {
		  	font: normal 12px helvetica,arial,verdana,tahoma,sans-serif;
		}
		.my-form-class {
			margin:  20px 30px;
		}
	</style>
	<script type="text/javascript">
	
	Ext.onReady(function(){
		Ext.QuickTips.init();
		 
		var formPanel = new Ext.FormPanel({
				url: '<c:url value="/registration" />',
				frame: true,
				labelWidth:80,
				width: 500,
				items: [{
						xtype: 'textfield',
						fieldLabel: 'User name',
						name: 'username',
						allowBlank: false
				},{
						xtype: 'textfield',
						fieldLabel: 'Post code',
						name: 'postCode',
						allowBlank: false
				},{
						xtype: 'textfield',
						fieldLabel: 'Email',
						name: 'email',
						allowBlank: false
				},{
					xtype: 'combo',
					fieldLabel: 'Domain',
					name: 'domain',
					store: new Ext.data.SimpleStore({
						fields: ['domain'],
						data : [['com-en'],['com-br'],['com-es']] 
					    }),
 					displayField: 'domain',
			    	typeAhead: false,
			    	mode: 'local',
			    	triggerAction: 'all',
			    	emptyText:'Choose domain...',
			    	selectOnFocus:true,
			    	value: 'com-en',
			    	allowBlank: false
				}],
				buttons: [{
						text: 'Add',
						handler: function() {
							var form = formPanel.getForm();
				            if (form.isValid()) {
				            	  form.submit({
					        			success: function(form, action) {
					        				Ext.Msg.alert('Success', 'Data stored in the <a target="_blank" href="<c:url value="/xml/result.xml" />">XML</a>.');
					        				form.reset();
					        			},
					        			failure: function(form, action) {
					        				if(action.result != undefined){
					        					var msg = '';
					        					for (var i = 0; i < action.result.msgErrors.length; i++){
					        						msg = msg + action.result.msgErrors[i] + '<br/>';
					        					}
					        					Ext.Msg.alert('Warning', msg); 
					        				}
					        			}
					        		});
				            }
						}
				}]
		});
		
		 var win = new Ext.Window({
				title:'Registration form',
		        layout:'fit',
		        width:400,
		        height:250,
		        closable: false,
		        resizable: false,
		        plain: true,
		        border: false,
		        items: [formPanel]
			});
			win.show();
		


	});

	</script>
</head>
<body>
</body>
</html>