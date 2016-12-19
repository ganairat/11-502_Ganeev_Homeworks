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
    <link rel="icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">
    <link rel="shortcut icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">


    <script src="js/modernizr.js"></script> <!-- Modernizr -->
    <script src="js/bootstrap.min.js"></script>

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

<div class="cd-intro">

    <div class="container">
        <div class="row">
            <div class="col-sm-offset-1 col-sm-2">
            </div>
            <div class="col-sm-6">
                <form method="post" accept-charset="utf-8" class="form" role="form">
                    <title>Продажа квартир</title>
                    <fieldset id="inputs" >
                        <input type="text" name="firstName" value="" class="form-control input-lg" placeholder="Your First Name"  autofocus required/>
                        <input type="text" name="middleName" value="" class="form-control input-lg" placeholder="Your Middle Name"  />
                        <input type="text" name="lastName" value="" class="form-control input-lg" placeholder="Your Last Name"  />
                        <input type="email" name="login" value="" class="form-control input-lg" placeholder="Your Email"  />
                        <input type="text" name="phone" value="" class="form-control input-lg" placeholder="Your phone number"  />

                    </fieldset>
                    <fieldset >
                        <input type="submit" id="submit" value="SIGN IN">
                        <input type="password" name="password" value="" class="form-control input-lg" placeholder="Password"  />
                    </fieldset>

                    <button class="btn btn-lg btn-default btn-block signup-btn" type="submit" >Create my account</button>


                    <% String busyEmail= (String) request.getAttribute("busyEmailError");
                        if (busyEmail!=null) {%>
                        <%=busyEmail%>
                    <%}%>

                    <% String psError = (String)request.getAttribute("pasWrong");
                        if (psError!=null) {%>
                    <%=psError%></p>
                    <%}%>

                    <% String notFullParam = (String) request.getAttribute("notFullParam");
                        if (notFullParam!=null) {%>
                    <%=notFullParam%></p><%}%>

                    <% String fio = (String)request.getAttribute("FIOWrong");
                        if (fio!=null) {%>
                        <%=fio%></p>
                    <%}%>

                    <% String phoneWrong = (String)request.getAttribute("phoneWrong");
                        if (phoneWrong!=null) {%>
                        <%=phoneWrong%></p>
                    <%}%>

                    <% String logError = (String)request.getAttribute("logWrong");
                        if (logError!=null) {%>
                        <%=logError%></p>
                    <%}%>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="js/main.js"></script> <!-- Gem jQuery -->
</body>
</html>