<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String email = request.getParameter("email");
String remember = request.getParameter("remember");

if(remember != null && remember.equals("on")){
	Cookie cookie = new Cookie("userCookie", email);
	cookie.setMaxAge(30);
	response.addCookie(cookie);
}else{
	Cookie cookie = new Cookie("userCookie", email);
	cookie.setMaxAge(0);
	response.addCookie(cookie);
}

%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>form</title>
</head>
<body>

    
</body>
</html>