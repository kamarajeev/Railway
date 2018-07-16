<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@page import="java.util.ArrayList" %>
<%@page import="com.tcs.bean.BookBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css">
table, th, td {
    border: 1px solid black;
}
</style>
<body>
<%ArrayList<BookBean> a=new ArrayList<BookBean>(); %>
<%a=(ArrayList<BookBean>)request.getAttribute("arr"); %>
<form action="\Railway_Booking\SecondServlet" onclick="return validate()">
<table>
<tr>
<th>Traveler</th>
<th>Age</th>
<th>Gender</th>
<th>Train Name</th>
<th>Seat No</th>
<th>Cancel ticket</th>
</tr>
<%for(BookBean tl:a){ %>
<tr id="hello">
<td><%=tl.getName()%></td>
<td><%=tl.getGender() %></td>
<td><%=tl.getAge() %></td>
<td><%=tl.getTrainName() %></td>
<td><%=tl.getSeat() %></td>
<td><input type="hidden" name="train" value="<%=tl.getTrainName()%>">
<input type="hidden" name="seat" value="<%=tl.getSeat() %>">
<input type="radio" name="c" id="c" onclick="validate()"></td>
<%} %>
</table><br>

<input type="hidden" value="Cancel" name="submit" id="submit">
</form>
</body>
<script type="text/javascript">
function validate(){
	document.getElementById("submit").type='submit';
	var Row = document.getElementById("hello");
	var Cells = Row.getElementsByTagName("td");
	for(var i=0;i<12;i++){
	alert(Cells[i].innerText);
	}
}
</script>
</html>