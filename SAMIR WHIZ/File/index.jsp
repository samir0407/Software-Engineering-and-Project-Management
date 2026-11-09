<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>SAMIR WHIZ</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

    <h1>SAMIR WHIZ</h1>

    <form action="game.jsp" method="post">

        <h3>Enter Player Name</h3>

        <input type="text"
               name="playerName"
               required>

        <br><br>

        <button type="submit">
            Start Game
        </button>

    </form>

</body>
</html>