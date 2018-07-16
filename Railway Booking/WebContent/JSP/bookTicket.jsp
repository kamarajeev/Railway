<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<form action="/Railway_Booking/RailwayServlet" method="post" onsubmit="return onvalidation()">
<h3>From
<select name="from" id="a">
<option value="Tirunelveli">TIRUNELVELI</option>
<option value="Kanyakumari">KANYAKUMARI</option>
<option value="Nagercoil">CHENNAI</option>
<option value="Tenkasi">TENKASI</option>
</select></h3>
<h3>To
<select name="to" id="b">
<option value="Tirunelveli">TIRUNELVELI</option>
<option value="Kanyakumari">KANYAKUMARI</option>
<option value="Nagercoil">CHENNAI</option>
<option value="Tenkasi">TENKASI</option>
</select></h3>
<%String name=(String)request.getAttribute("name"); %>
<input type="hidden" value="<%=name %>" name="hid">
<input type="submit" value="submit" name="submit" id="submit">
</form>
<script type="text/javascript">
function onvalidation(){      
          var e = document.getElementById("a");
          var strUser = e.options[e.selectedIndex].value;
          var f = document.getElementById("b");
          var strUser1 = f.options[f.selectedIndex].value;
          if(strUser==strUser1)
          {
              alert("No train available");
              return false;
          }
      
}
</script>


</body>

</html>