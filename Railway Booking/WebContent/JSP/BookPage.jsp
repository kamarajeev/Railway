<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%int value=(Integer)request.getAttribute("value");%>
<%String name=(String)request.getAttribute("name"); %>
<form action="/Railway_Booking/RailwayServlet" method="get">
<%if(value==1){ %>
<h1>Welcome &nbsp;<%=name%></h1>
<input type="hidden" value="<%=name %>" name="hid">
<h3><input type="submit" value="BOOK TRAIN" name="submit" ></h3>
<h3><input type="submit" value="CHECK BOOKED STATUS" name="submit"></h3>
<h3><input type="submit" value="CANCEL TICKET" name="submit"></h3>
<%}else{ %>
<h1>Password is wrong or user does not exist...</h1>
<%} %>
</form>
<script type="text/javascript">



</script>
</body>
</html>