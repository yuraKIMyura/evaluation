<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
int boardno = Integer.parseInt(request.getParameter("boardno"));
String hits = request.getParameter("hits");
boolean isRecommended = Boolean.parseBoolean(request.getParameter("isRecommended"));
response.sendRedirect("readView.do?boardno="+boardno+"&hits="+hits+"&isRecommended=" +isRecommended);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>