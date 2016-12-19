<%@ page import="java.util.List" %>
<%@ page import="Models.Client" %>
<%@ page import="Models.Flat" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="css/reset.css"> <!-- CSS reset -->
    <link rel="stylesheet" href="css/style.css"> <!-- Gem style -->
    <script src="js/modernizr.js"></script> <!-- Modernizr -->

    <title>Flat Trading</title>
</head>
<body>
<header role="banner">
    <div id="cd-logo"><a href="#0"><img src="img/cd-logo.svg" alt="Logo"></a></div>

    <nav class="main-nav">
        <ul>
            <!-- ссылки на вызов форм -->
            <li><a class="cd-signup" href="/addflat">Add Flat</a></li>
            <li><a class="cd-signin" href="/logout">Exit</a></li>
        </ul>
    </nav>
</header>

<div class="container">
    <div class="row">


        <div class="col-md-12">
            <div class="table-responsive">


                <table id="mytable" class="table table-bordred table-striped">

                    <thead>


                    <th>Square</th>
                    <th>Number of rooms</th>
                    <th>Floor</th>

                    <th>Info</th>
                    </thead>
                    <tbody>

                    <%
                        List<Flat> list = (ArrayList<Flat>) request.getAttribute("flatList");

                        for(int i = 0; i < list.size() ; i++){%>
                    <tr>


                        <td><%=list.get(i).getSqr()%></td>
                        <td><%=list.get(i).getAmtRoom()%></td>

                        <td><%=list.get(i).getFloor()%></td>




                        <td>
                         <a href="/flat?id=<%=list.get(i).getId()%>">Info</a>
                        </td>
                    </tr>
                    <%
                        }
                    %>

                    <br/>


                    </tbody>

                </table>

            </div>

        </div>
    </div>
</div>


<!-- cd-client-modal -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="js/main.js"></script> <!-- Gem jQuery -->
</body>
</html>