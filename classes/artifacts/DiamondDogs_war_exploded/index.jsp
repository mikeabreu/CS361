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
    <script src="assets/lib/jquery-1x/jquery-1.11.3.min.js" type="text/java"></script>
    <script src="assets/lib/bootstrap-3.3.5-dist/js/bootstrap.min.js" type="text/java"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

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
                    <li role="presentation" class="active">
                        <a href="/">Login</a>
                    </li>
                    <li role="presentation">
                        <a href="/register">Register</a>
                    </li>
                    <li role="presentation">
                        <a href="/account">Account</a>
                    </li>
                </ul>
            </div>
        </div>

        <!--    Login Form  -->
        <div class="row">
            <div class="col-lg-6 col-lg-offset-3">

                <!--    Login Form    -->
                <form id="loginForm" class="form-signin" action="/login" method="POST">
                    <h2 class="form-signin-heading">Please sign in</h2>
                    <label for="inputUsername" class="sr-only">Username</label>
                    <input type="text" id="inputUsername" name="inputUsername" class="form-control"
                           placeholder="Username" required autofocus>
                    <label for="inputPassword" class="sr-only">Password</label>
                    <input type="password" id="inputPassword" name="inputPassword" class="form-control"
                           placeholder="Password" required>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                    <a id="registerBtn" href="/register" class="btn btn-lg btn-success btn-block">Register</a>
                </form>


            </div>
        </div>

    </div>
</div>
</body>

</html>