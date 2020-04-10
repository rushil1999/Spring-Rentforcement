<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Spring MVC - JSON Request Sample</title>
<script src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
</head>
<body>
	<h2>Enter Employee Details</h2>
	<table>
		<tr>
			<td>User Name</td>
			<td><input type="text" id="username"></td>
		</tr>
		<tr>
			<td>First Name</td>
			<td><input type="text" id="firstname"></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><input type="text" id="lastname"></td>
		</tr>
		<tr>
			<td>Email Address</td>
			<td><input type="text" id="emailaddr"></td>
		</tr>
		<tr>
			<td>Phone Number</td>
			<td><input type="text" id="phone"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="text" id="password"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" id="submit" value="Submit" /></td>
		</tr>
	</table>
	
	<hr/>
	<div id="displayDiv" style="display:none"><h3>JSON Data returned from Server after processing</h3>
		<div id="processedData"></div>
	</div>
	<script>
	jQuery(document).ready(function($) {
 
		$("#submit").click(function(){
			var user = {};
			user["userid"] = 5;
			user["username"] = $("#username").val();
			user["fname"] = $("#firstname").val();
			user["lname"] = $("#lastname").val();
			user["emailaddr"] = $("#emailaddr").val();
			user["phone"] = $("#phone").val();
			user["password"] = $("#password").val();
			
			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "addUser",
				data : JSON.stringify(user),
				dataType : 'json',				
				success : function(data) {
					$('#processedData').html(JSON.stringify(data));
					$('#displayDiv').show();
				}
			});
		});
 
	});
</script>	
 
</body>
</html>