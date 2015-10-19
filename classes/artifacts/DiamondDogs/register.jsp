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
    <script src="assets/lib/jquery-1x/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="assets/lib/bootstrap-3.3.5-dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="assets/lib/js-cookie-master/src/js.cookie.js" type="text/javascript"></script>
    <script src="assets/js/styles.js" type="text/javascript"></script>

    <script>
        $(function () {
            // Password Validation
            $("#submit").click(function (event) {
                if ($("#inputPassword").val() != $("#inputPassword2").val()) {
                    $(".hidden").css({"display": "block", "margin-top": "20px"}).removeClass("hidden");
                    event.preventDefault();
                }
            });
        });
    </script>

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
                    <li role="presentation">
                        <a href="/">Login</a>
                    </li>
                    <li role="presentation" class="active">
                        <a href="/register">Register</a>
                    </li>
                    <li role="presentation">
                        <a href="/account">Account</a>
                    </li>
                </ul>
            </div>
        </div>

        <!--    Register Form  -->
        <div class="row">
            <div class="col-lg-6 col-lg-offset-3">
                <%-- Error Message --%>
                <div class="hidden alert alert-danger alert-dismissible fade in" role="alert">
                    <h4>Passwords don't match.</h4>
                </div>

                <!--    Login Form    -->
                <form id="registerForm" class="form-signin" action="/create" method="POST">
                    <h2 class="form-signin-heading">Fill in the fields below to register</h2>

                    <!-- Email -->
                    <label for="inputEmail" class="sr-only">Email Address</label>
                    <input type="text" id="inputEmail" name="inputEmail" class="form-control" placeholder="*Email Address" required>

                    <!-- Username -->
                    <label for="inputUsername" class="sr-only">Username</label>
                    <input type="text" id="inputUsername" name="inputUsername" class="form-control" placeholder="*Username" required
                           autofocus>

                    <!-- Password -->
                    <label for="inputPassword" class="sr-only">Password</label>
                    <input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="*Password" required>

                    <!-- Confirm Password -->
                    <label for="inputPassword2" class="sr-only">Confirm Password</label>
                    <input type="password" id="inputPassword2" name="inputPassword2" class="form-control" placeholder="*Confirm Password"
                           required>

                    <%--<!-- City -->--%>
                    <%--<label for="inputCity" class="sr-only">City</label>--%>
                    <%--<input type="text" id="inputCity" class="form-control" placeholder="*City" required>--%>

                    <%--<!-- State -->--%>
                    <%--<label for="inputState" class="sr-only">State</label>--%>
                    <%--<input type="text" id="inputState" class="form-control" placeholder="*State" required>--%>

                    <%--<!-- Zip Code -->--%>
                    <%--<label for="inputZip" class="sr-only">Zip Code</label>--%>
                    <%--<input type="text" id="inputZip" class="form-control" placeholder="*Zip Code" required>--%>

                    <!-- Credit Card -->
                    <%--<label for="inputCreditCard" class="sr-only">Credit Card</label>--%>
                    <%--<input type="text" id="inputCreditCard" name="inputCreditCard" class="form-control" placeholder="*Credit Card" required>--%>

                    <!-- Buttons -->
                    <button id="submit" class="btn btn-lg btn-success btn-block" type="submit">Register</button>
                    <a href="/" class="btn btn-lg btn-primary btn-block ">Back to Sign In</a>
                </form>
            </div>
        </div>
    </div>
</div>
</body>

</html>