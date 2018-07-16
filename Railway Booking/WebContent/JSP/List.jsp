<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
<%@page import="com.tcs.bean.TrainBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table, th, td {
    border: 1px solid black;
}
</style>
</head>
<body>
<form action="/Railway_Booking/RailwayServlet" method="post" onsubmit="return validate()">
<%ArrayList<TrainBean> a=new ArrayList<TrainBean>(); %>
<%a=(ArrayList<TrainBean>)request.getAttribute("a"); %>
<table id="trainlist">
<tr>
<th>FROM</th>
<th>TO</th>
<th>TRAIN NAME</th>
<th>SEAT AVAILABLE</th>
<th>Select to Cancel</th>
</tr>
<%for(TrainBean tl:a){ %>
<tr>
<td><%=tl.getFrom()%></td>
<td><%=tl.getTo() %></td>
<td><%=tl.getTrainName() %></td>
<td><%=tl.getSeat() %></td>
<td><input type="radio" name="select" id="k" value="<%=tl.getTrainName()%>"id="select"></td>
<%} %>
</table>
<%String name=(String)request.getAttribute("name"); %>
<input type="hidden" value="<%=name %>" name="hid">
<input type="submit" name="submit" value="Book" id="Book">
</form>
</body>
<script type="text/javascript">
function validate(){
	var a=document.getElementById("k");
	if(a==""){
		alert("please select a train");
		return false;
	}
}


</script>
</html>