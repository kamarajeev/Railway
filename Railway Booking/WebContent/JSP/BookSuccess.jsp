<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%int k =Integer.parseInt(request.getAttribute("a").toString()); %>
<%if (k==1){ %>
<h3>Booking Success</h3>
<%}else{ %>
<h3> sry...Seat Full</h3>
<%} %>
</body>
</html>