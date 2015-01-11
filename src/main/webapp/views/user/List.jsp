<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../Tags.jsp"%>
 <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">

<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<!-- table -->
<div class="form-container">
	<table id="userList" title="Users" class="easyui-datagrid" style="width: 550px; height: 250px" url="getAllUser.action"
		toolbar="#toolbar" rownumbers="true" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="id" width="50">ID</th>
				<th field="name" width="50">First Name</th>
				<th field="lastName" width="50">Last Name</th>
				<th field="mobile" width="50">Mobile</th>
				<th field="login" width="50">Login</th>
				<th field="email" width="50">Email</th>
			</tr>
		</thead>
	</table>

<div id="toolbar">
	<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">New User</a> <a href="#"
		class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">Edit User</a> <a href="#"
		class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">Remove User</a>
</div>
</div>
<!-- edit/create dialog -->

<div id="user-dialog" class="easyui-dialog" style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
	buttons="#user-dialog-buttons">
	<div class="ftitle">User Information</div>
	<form id="fm" method="post" novalidate >
		<div class="fitem">
			<label>First Name:</label> <input name="user.name" class="easyui-textbox" required="true">
		</div>
		<div class="fitem">
			<label>Last Name:</label> <input name="user.lastName" class="easyui-textbox" required="true">
		</div>
		<div class="fitem">
			<label>Mobile:</label> <input name="user.mobile" class="easyui-textbox">
		</div>
		<div class="fitem">
			<label>Login:</label> <input name="user.login" class="easyui-textbox">
		</div>
		<div class="fitem">
			<label>Password:</label> <input name="user.password" class="easyui-textbox" required="true">
		</div>
		<div class="fitem">
			<label>Email:</label> <input name="user.email" class="easyui-textbox" validType="email">
		</div>
	</form>
</div>

<div id="user-dialog-buttons">
	<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width: 90px">Save</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#user-dialog').dialog('close')"
		style="width: 90px">Cancel</a>
</div>

<script>

	function newUser() {
		$('#user-dialog').dialog('open').dialog('setTitle', 'New User');
		$('#fm').form('clear');
		url = 'createUser.action';
	}

	
	function editUser() {
		var row = $('#userList').datagrid('getSelected');
		if (row) {
			$('#user-dialog').dialog('open').dialog('setTitle', 'Edit User');
			$('#fm').form('load', row);
			url = 'modifyUser.action?id='+row.id;
		}
	}

	function saveUser() {
		
		$('#fm').form('submit', {
			url : url,
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(result) {
				console.log(result);
				
				if (result.errorMsg) {
					$.messager.show({
						title : 'Error',
						msg : result.errorMsg
					});
				} else {
					$('#user-dialog').dialog('close'); // close the dialog
					$('#userList').datagrid('reload'); // reload the user data
				}
			},
			error : function(e){
				console.log(e);
			}
		});
	}
	
	function destroyUser() {
		var row = $('#userList').datagrid('getSelected');
		if (row) {
			$.messager.confirm('Confirm','Are you sure you want to destroy this user?', function(r) {
						if (r) {
							 $.ajax({
						            url: 'deleteUser.action',
						            dataType: 'json',
						            data: {
						            	id : row.id
						            },
						            success: function(data) {
						                console.log(data);
						                $('#userList').datagrid('reload'); // reload the user data
						            },
						            error : function(e) {
						            	 alert(JSON.stringify(e));
									}
						        });
						}
					});
		}
	}
</script>
