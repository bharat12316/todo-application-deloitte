<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>TODO APP</title>
<style>
input[type=submit] {
	border: none;
	color: black;
	padding: 10px 32px;
	text-decoration: none;
	margin: 4px 2px;
	cursor: pointer;
}

td {
	width: 70px;
	text-align: center;
	padding: 5px;
}

input[type=submit]:hover {
  background-color: #C0C0C0;
  color: black;
  
}

</style>

</head>
<body style="background-color: powderblue;">
	<font style = "text-align:center;" color="red">${errorMessage}</font>
	<div align="center">
		<h1>TODO APP</h1>
		<form method="post">
			<table style="with: 50%">
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" placeholder = "Username" required /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" placeholder= "Password" required /></td>
				</tr>
			</table>
			<br> <input type="submit" class="btn btn-primary"/>
		</form>


	</div>
</body>
</html>