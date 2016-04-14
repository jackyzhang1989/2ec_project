<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Director</title>
</head>
<body>
	<h1 style="text-align: center">IMDb</h1>
	<h2 style="text-align: center">Add Director</h2>
	<br>
	<div style="margin-left: 600px;">
		<form:form modelAttribute="director"
			action="${pageContext.request.contextPath}/directors/add"
			method="post">

			<table  border="1">
				<tr>
					<td>FirstName:</td>
					<td><form:input path="firstName" /></td>
					<td><form:errors path="firstName" cssStyle="color:red" /></td>
				</tr>
				<tr>
					<td>LastName:</td>
					<td><form:input path="lastName" /></td>
					<td><form:errors path="lastName" cssStyle="color:red" /></td>
				</tr>


			</table>
			<br>
			<input type="submit" value="Add" /> &nbsp;&nbsp;
	
	</form:form>
		<br>
		<form action="${pageContext.request.contextPath}/directors"
			method="GET">
			<button>Cancel</button>
		</form>
	</div>

</body>
</html>