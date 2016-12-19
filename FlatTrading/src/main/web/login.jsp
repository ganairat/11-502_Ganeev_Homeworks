<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <link rel="stylesheet" href="css/reset.css"> <!-- CSS reset -->
    <link rel="stylesheet" href="css/style.css"> <!-- Gem style -->

    <link rel="stylesheet" href="style.css">
    <link rel="icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">
    <link rel="shortcut icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">

    <link rel="stylesheet" href="css/bootstrap-theme.min.css">

    <script src="js/modernizr.js"></script> <!-- Modernizr -->


    <title>Flat Trading</title>
</head>
<body>
<header role="banner">
    <div id="cd-logo" href=""><a href="http://localhost:8080/home"><img src="img/cd-logo.svg" alt="Logo"></a>
    </div>
    <nav class="main-nav">

        <ul>
            <!-- ссылки на вызов форм -->
            <li><a class="cd-signin" href="/login">Sign in</a></li>
            <li><a class="cd-signup" href="/signup">Sign up</a></li>
        </ul>
    </nav>
</header>


    <!-- Put your page content here! -->



<form id="login" action="/login" method="post">
    <h1>Login</h1>
    <fieldset id="inputs" >
        <input name="login" type="email" placeholder="Login" autofocus required>
        <input name="password" type="password" placeholder="Password" required>
    </fieldset>
    <fieldset >
        <input type="submit" id="submit" value="SIGN IN">
    </fieldset>
    <h2 align="center"><font size="4" color="red" >

        <%
            if(request.getAttribute("checkLoginWithPassword") != null){
        %>
        <style>

            h2 {
                font-family: "Times New Roman";
                padding: 50px; /* Поля вокруг текста */
            }
        </style>
        Check Login and Password!!!
        <% }%>
    </font></h2>
</form>



<%--<link rel="stylesheet" href="http://bootstraptema.ru/plugins/2015/b-v3-3-6/bootstrap.min.css" />
<br><br><br><br><br><br><br><br><br><br><br><br><br>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-sm-offset-3">
            <form role="form">

                <div class="form-group">
                    <label for="name">Обычный список</label>

                    <select class="form-control">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>

                </div>

            </form>
        </div>
    </div>
</div>--%>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="js/main.js"></script> <!-- Gem jQuery -->
</body>
</html>