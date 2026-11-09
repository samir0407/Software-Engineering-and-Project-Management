<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
String playerName =
request.getParameter("playerName");
%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>SAMIR WHIZ</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<h1>SAMIR WHIZ</h1>

<h3>Welcome <%=playerName%></h3>

<form action="GameServlet" method="post">

<input type="hidden"
       name="playerName"
       value="<%=playerName%>">

<h3>Q1 : Is 7 Prime?</h3>

<input type="radio" name="q1" value="1" required> 1<br>
<input type="radio" name="q1" value="0"> 0<br>
<input type="radio" name="q1" value="2"> 2<br>

<br>

<h3>Q2 : 17 % 5 = ?</h3>

<input type="radio" name="q2" value="3" required> 3<br>
<input type="radio" name="q2" value="2"> 2<br>
<input type="radio" name="q2" value="4"> 4<br>

<br>

<h3>Q3 : Sin(30°) = ?</h3>

<input type="radio" name="q3" value="1.0" required> 1.0<br>
<input type="radio" name="q3" value="0.5"> 0.5<br>
<input type="radio" name="q3" value="0.8"> 0.8<br>

<br>

<h3>Q4 : Cos(60°) = ?</h3>

<input type="radio" name="q4" value="1.0" required> 1.0<br>
<input type="radio" name="q4" value="0.5"> 0.5<br>
<input type="radio" name="q4" value="0.3"> 0.3<br>

<br><br>

<button type="submit">
Submit Answers
</button>

</form>

</body>
</html>