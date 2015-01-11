<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../Tags.jsp"%>
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">

<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<!-- table -->
<div class="form-container">
	<table id="doctor-list" title="Doctors" class="easyui-datagrid" style="width: 550px; height: 250px"
		url="getAllDoctor.action" toolbar="#toolbar" rownumbers="true" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="id" width="50">ID</th>
				<th field="name" width="50">First Name</th>
				<th field="lastName" width="50">Last Name</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newDoctor()">New Doctor</a> <a href="#"
			class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editDoctor()">Edit Doctor</a> <a href="#"
			class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyDoctor()">Remove Doctor</a>
	</div>
</div>
<!-- edit/create dialog -->

<div id="doctor-dialog" class="easyui-dialog" style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
	buttons="#doctor-dialog-buttons">
	<div class="ftitle">Doctor Information</div>
	<form id="fm" method="post" novalidate>
		<div class="fitem">
			<label>First Name:</label> <input name="doctor.name" class="easyui-textbox" required="true">
		</div>
		<div class="fitem">
			<label>Last Name:</label> <input name="doctor.lastName" class="easyui-textbox" required="true">
		</div>

	</form>
</div>
<div id="doctor-dialog-buttons">
	<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveDoctor()" style="width: 90px">Save</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
		onclick="javascript:$('#doctor-dialog').dialog('close')" style="width: 90px">Cancel</a>
</div>

<script>
	function newDoctor() {
		$('#doctor-dialog').dialog('open').dialog('setTitle', 'New Doctor');
		$('#fm').form('clear');
		url = 'createDoctor.action';
	}

	function editDoctor() {
		var row = $('#doctor-list').datagrid('getSelected');
		if (row) {
			$('#doctor-dialog').dialog('open')
					.dialog('setTitle', 'Edit Doctor');
			$('#fm').form('load', row);
			url = 'modifyDoctor.action?id=' + row.id;
		}
	}

	function saveDoctor() {

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
					$('#doctor-dialog').dialog('close'); // close the dialog
					$('#doctor-list').datagrid('reload'); // reload the Doctor data
				}
			},
			error : function(e) {
				console.log(e);
			}
		});
	}

	function destroyDoctor() {
		var row = $('#doctor-list').datagrid('getSelected');
		if (row) {
			$.messager.confirm('Confirm',
					'Are you sure you want to destroy this Doctor?',
					function(r) {
						if (r) {
							$.ajax({
								url : 'deleteDoctor.action',
								dataType : 'json',
								data : {
									id : row.id
								},
								success : function(data) {
									console.log(data);
									$('#doctor-list').datagrid('reload'); // reload the Doctor data
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
