<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Basic interface</title>
	</head>
	<body>
		<div class="sidebar">
			<ol>
				<li>List Courses</li>
				<li>List Persons</li>
			</ol>
		</div>
		<div class="content">
			<table>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Role</th>
				<c:forEach items="${items}" var="item">
                    <tr>
                    	<td>${item.id}</td>
                        <td>${item.firstname}</td>
                        <td>${item.lastname}</td>
                        <td>${item.email}</td>
                        <td>${item.role}</td>
                    </tr>
                </c:forEach>
			</table>
		</div>
	</body>
</html>