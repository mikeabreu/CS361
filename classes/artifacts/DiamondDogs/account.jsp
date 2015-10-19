<%@page import="diamonddogs.AccountController" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    AccountController ac = AccountController.getInstance();
    ac.sync(request, response);
    ac.check_auth(response);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!--    Title   -->
    <title>Diamond Dogs | Account Information</title>

    <!--    Bootstrap Styles   -->
    <link rel="stylesheet"
          href="assets/lib/bootstrap-3.3.5-dist/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="assets/lib/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css">

    <!--    Custom Styles   -->
    <link rel="stylesheet" href="assets/css/style.css">

    <!--    jQuery + Bootstrap Scripts  -->
    <script src="assets/lib/jquery-1x/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="assets/lib/bootstrap-3.3.5-dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="assets/lib/js-cookie-master/src/js.cookie.js" type="text/javascript"></script>
    <script src="assets/js/styles.js" type="text/javascript"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<% if (ac.isAuthenticated()) { %>
<div id="wrapper">
    <div class="container">
        <!--    Banner   -->
        <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                <div class="dd-banner"></div>
            </div>

            <div class="col-lg-4 col-md-4 col-sm-6 hidden-xs">
                <div class="dd-banner"></div>
            </div>

            <div class="col-lg-4 col-md-4 hidden-sm hidden-xs">
                <div class="dd-banner"></div>
            </div>
        </div>

        <!-- Navigation -->
        <div class="row">
            <div class="col-lg-12">
                <ul role="navigation" class="dd-nav nav nav-pills nav-justified">
                    <li role="presentation"><a href="/">Login</a></li>
                    <li role="presentation"><a href="/register">Register</a>
                    </li>
                    <li role="presentation" class="active"><a
                            href="/account">Account</a></li>
                </ul>
            </div>
        </div>

        <!-- Greeting -->
        <div class="row">
            <div class="col-lg-12">
                <h1>
                    Hello, <span id="user-name"><%= ac.display_username() %></span>!
                </h1>
            </div>
        </div>

        <!-- Account Information -->
        <div class="row">
            <div class="col-lg-12">

                <div class="table-responsive">
                    <table class="acc-info-table table table-hover table-condensed">
                        <thead>

                        <!-- Table Header -->
                        <tr>
                            <th colspan="2">Account Information</th>
                        </tr>

                        </thead>
                        <tbody>

                        <!-- Display Email Address -->
                        <tr>
                            <td><p>Email Address:</p></td>
                            <td id="user-email"><p><%= ac.display_email() %>
                            </p></td>
                        </tr>

                        <!-- Display Credit Card -->
                        <tr>
                            <td><p>Credit Card:</p></td>
                            <td id="user-cc"><p><%= ac.display_cc() %>
                            </p></td>
                        </tr>

                        <!-- Display Account Number -->
                        <tr>
                            <td><p>Account Number:</p></td>
                            <td id="user-account"><p><%= ac.display_account() %>
                            </p></td>
                        </tr>

                        <!-- Display Balance -->
                        <tr>
                            <td><p>Balance:</p></td>
                            <td id="user-balance"><%= ac.display_balance() %>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
    </div>
</div>
<% } else { %>
<div class="text-center">
    <h2>Sorry, you're not allowed access to this page.</h2>
    <a class="btn btn-lg btn-primary" href="/">Return to Homepage</a>
</div>
<% } %>
</body>
</html>