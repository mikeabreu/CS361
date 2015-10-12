<%--
  User: Michael
  Date: 10/11/2015
  Time: 10:19 PM
--%>
<%@page import="java.util.Date"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!--    Title   -->
    <title>Diamond Dogs | Login Page</title>

    <!--    Bootstrap Styles   -->
    <link rel="stylesheet" href="assets/lib/bootstrap-3.3.5-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/lib/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css">

    <!--    Custom Styles   -->
    <link rel="stylesheet" href="assets/css/style.css">

    <!--    jQuery + Bootstrap Scripts  -->
    <script src="assets/lib/jquery-1x/jquery-1.11.3.min.js"></script>
    <script src="assets/lib/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<%
String text = "Today's date is: ";

out.println(text);

%>
<%= new Date() %>

</body>
</html>