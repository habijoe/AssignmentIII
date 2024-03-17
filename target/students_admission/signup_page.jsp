<!DOCTYPE html>
<html>
<head>
    <title>Signup Page</title>
    <link rel="stylesheet" type="text/css" href="signup.css">
</head>
<body>
    <div class="container">
        <%@ include file = "Header.jsp"%>
        <div class="card">
            <h2>Signup Form</h2>
            <form method="post" action="signup">
                <label for="fullname">Full Name:</label><br>
                <input type="text" id="fullname" name="fullname" required><br>
                <label for="email">Email:</label><br>
                <input type="email" id="email" name="email" required><br>
                <label for="password">Password:</label><br>
                <input type="password" id="password" name="password" required><br>
                <label for="education">Education Level:</label><br>
                <select id="education" name="education">
                    <option value="High School">High School</option>
                    <option value="College">College</option>
                    <option value="Bachelor's Degree">Bachelor's Degree</option>
                    <option value="Master's Degree">Master's Degree</option>
                    <option value="PhD">PhD</option>
                    <!-- Add more options as needed -->
                </select><br>
                <label for="national_id">National ID:</label><br>
                <input type="text" id="national_id" name="national_id"><br>
                <label for="gender">Gender:</label><br>
                <select id="gender" name="gender">
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                    <option value="Other">Other</option>
                </select><br><br>
                <input type="submit" value="signup">
            </form>
            <% if(request.getAttribute("error") != null) { %>
                <div class="error">
                    <%= request.getAttribute("error") %>
                </div>
            <% } %>
            <div>
                Already have an account? <a href="login.jsp">Login</a>
            </div>
        </div>
    </div>
</body>
</html>
