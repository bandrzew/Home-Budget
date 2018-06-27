<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>purchase form</title>
</head>
<body>
	<form:form method="post" modelAttribute="purchase">
		<div>
			month
			<form:select path="month" items="${months}" />
		</div>
		<div>
			name
			<form:input path="name" />
			<form:errors path="name" />
		</div>
		<div>
			price
			<form:input type="number" path="price" />
			<form:errors path="price" />
		</div>
		<div>
			description
			<form:textarea path="description" />
			<form:errors path="description" />
		</div>
		<div>
			<input type="submit" />
		</div>
	</form:form>

</body>
</html>