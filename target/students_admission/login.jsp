<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="login_style.css">
</head>
<body>
    <div class="container">
        <%@ include file = "Header.jsp"%>
        <div class="card">
            <h2>Login Form</h2>
            <form method="post" action="login">
                <label for="email">Email:</label><br>
                <input type="text" id="email" name="email"><br>
                <label for="password">Password:</label><br>
                <input type="password" id="password" name="password"><br><br>
                <input type="submit" value="Login">
            </form>
            <% if(request.getAttribute("error") != null) { %>
                <div class="error">
                    <%= request.getAttribute("error") %>
                </div>
            <% } %>
            <div>
                Don't have an account? <a href="signup_page.jsp">Sign up</a>
            </div>
        </div>
    </div>
</body>
</html>
