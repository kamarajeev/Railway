<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/Railway_Booking/SecondServlet" method="post" onsubmit="return validate()">
<p>Kindly fill all the details</p>
<h3>NAME <input type="text" name="name" id="a"></h3>
<h3>AGE <input type="text" name="age" id="b"></h3>
<h3>GENDER<input type="radio" value="MALE" name="gender" id="c">Male
<input type="radio" value="FEMALE"name="gender" id="d">Female</h3>
<%String a=(String)request.getAttribute("a"); %>
<input type="hidden" value="<%=a %>" name="hide">
<%String name=(String)request.getAttribute("name"); %>
<input type="hidden" value="<%=name %>" name="hid">
<input type="submit" value="Confirm" name="submit">
</form>
</body>
<script type="text/javascript">
function validate(){
	var a=document.getElementById("a").value;
	var c=document.getElementById("c").checked;
	var d=document.getElementById("d").checked;
	if(a==""|| !(c || d)){
		alert('Enter all values then click submit');
		return false;
	}
	var x = document.getElementById("b").value;
	if (isNaN(x) || x < 1 || x > 110) {
	    alert('Enter valid age');
	    return false;
	}
	
	
	}


</script>
</html>