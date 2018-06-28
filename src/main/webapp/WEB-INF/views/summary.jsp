<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>budget summary</title>
</head>
<body>
	<table>
		<tr>
			<td>Income:</td>
			<td>${income}</td>
		</tr>
		<tr>
			<td>Spendings:</td>
			<td>${spendings}</td>
		</tr>
		<tr>
			<td>Balance:</td>
			<td>${balance}</td>
		</tr>
	</table>
	<a id="purchaseForm" class="form"
		href="http://localhost:8080/Home-Budget/purchase/form">purchase
		form</a>
	<br>
	<a id="purchaseList" class="list"
		href="http://localhost:8080/Home-Budget/purchase/list">purchase
		list</a>
	<br>
	<a id="paycheckForm" class="form"
		href="http://localhost:8080/Home-Budget/paycheck/form">paycheck
		form</a>
	<br>
	<a id="paycheckList" class="list"
		href="http://localhost:8080/Home-Budget/paycheck/list">paycheck
		list</a>
</body>
</html>