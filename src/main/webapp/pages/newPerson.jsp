<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Basic interface</title>
	</head>
	<body>
		<form method="POST" action="../person">
			<div>
				<h1>Create Person</h1>
				<input type="text" name="id" placeholder="ID (Number)"/>
				<input type="text" name="firstname" placeholder="First name"/>
				<input type="text" name="lastname" placeholder="Last name"/>
				<input type="text" name="email" placeholder="E-mail"/>
				<input type="text" name="password" placeholder="Password"/>
				<input type="text" name="phone" placeholder="Phone number"/>
				<input type="text" name="fax" placeholder="Fax"/>
				<input type="text" name="home_page" placeholder="Home page"/>
				<input type="text" name="cv" placeholder="CV"/>
				<input type="text" name="note" placeholder="Note"/>
				<input type="text" name="role" placeholder="Role"/>
				<input type="text" name="address" placeholder="Address"/>
				<input type="text" name="mobile" placeholder="Mobile"/>
				<input type="text" name="temporary" placeholder="Temporary ?"/>
				<input type="text" name="id_master" placeholder="Master (ID)"/>
				<input type="text" name="year_master" placeholder="Master (Year)"/>
				<input type="submit" value="Submit"></input>
			</div>
		</form>
	</body>
</html>