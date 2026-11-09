<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="dao.ScoreDAO"%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Leaderboard</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<h1>SAMIR WHIZ LEADERBOARD</h1>

<table>

<tr>

    <th>Rank</th>

    <th>Player Name</th>

    <th>Score</th>

    <th>Difficulty</th>

    <th>Date Time</th>

</tr>

<%

int rank = 1;

ScoreDAO dao = new ScoreDAO();

ResultSet rs = dao.getTopScores();

while(rs.next()){

%>

<tr>

    <td>
        <%= rank++ %>
    </td>

    <td>
        <%= rs.getString("player_name") %>
    </td>

    <td>
        <%= rs.getInt("score") %>
    </td>

    <td>
        <%= rs.getString("difficulty") %>
    </td>

    <td>
        <%= rs.getTimestamp("played_at") %>
    </td>

</tr>

<%
}
%>

</table>

<br><br>

<a href="index.jsp">
    Play Again
</a>

</body>
</html>