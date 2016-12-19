<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="css/reset.css"> <!-- CSS reset -->
    <link rel="stylesheet" href="css/style.css"> <!-- Gem style -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/bootstrap-theme.css">
    <link rel="stylesheet" href="css/bootstrap-theme.css.map">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="style.css">

    <script src="js/modernizr.js"></script> <!-- Modernizr -->
    <style>

        h3 {
            font-family: "Times New Roman";
            color: red;
            padding: 50px; /* Поля вокруг текста */
        }
    </style>
    <title>Flat Trading</title>
</head>
<body>
<header role="banner">
    <div id="cd-logo" href=""><a href="http://localhost:8080/home"><img src="img/cd-logo.svg" alt="Logo"></a>
    </div>
    <nav class="main-nav">

        <ul>
            <!-- ссылки на вызов форм -->
            <li><a class="cd-signin" href="/home">Home</a></li>
            <li><a class="cd-signup" href="/signout">Exit</a></li>
        </ul>
    </nav>
</header>


<!-- Put your page content here! -->
<div align="center">

    <h2 class="form-signin-heading">Fill in the details about your apartment</h2>
</div>
<div class="container">
    <form method="post" class="form-signin" action="/addflat" role="form">
        <fieldset >

        <input name="flatSqr" placeholder="Square" autofocus required>
        <input name="flatAmtRoom" placeholder="Amt Room" required>
        <input name="flatSqrKitchen" placeholder="Kitchen Square" required>
        <input name="flatFloor" placeholder="Floor" required>
        <input name="flatKind" placeholder="Kind" required>
        <input name="flatDistrict" placeholder="District" required>
        </fieldset>
        <div align="center">
        <h2 class="form-signin-heading">Fill in the details about requirement</h2>
        </div>
        <fieldset >
            <input name="reqSqrMin" placeholder="Min Square" required>
            <input name="reqSqrMax" placeholder="Max Suare" required>
            <input name="reqAmtRoom" placeholder="Amt Room" required>
            <input name="reqSqrKitchenMin" placeholder="Kitchen min square" required>
            <input name="reqSqrKitchenMax" placeholder="Kitchen max square" required>

            <input name="reqFloor" placeholder="Floor" required>
            <input name="reqKind" placeholder="Kind" required>
            <input name="reqDist" placeholder="District" required>

        </fieldset>


        <fieldset >
            <input type="submit" id="submit" value="Add Flat">
        </fieldset>
    </form>
</div>
<div class="text-center"><h3>
    <%if (request.getAttribute("Wrongs") != null){%>
    <%=request.getAttribute("Wrongs")%>
    <%};if (request.getAttribute("flatParam") != null){%>
    <%=request.getAttribute("flatParam")%>
    <%};if (request.getAttribute("reqParam") != null){%>
    <%=request.getAttribute("reqParam")%><%}%>
</h3>
</div>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="js/main.js"></script> <!-- Gem jQuery -->
</body>
</html>