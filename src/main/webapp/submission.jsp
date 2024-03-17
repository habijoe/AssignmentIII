<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirmation</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <div class="confirmation">
        <%@ include file = "Header.jsp"%>
        <h2>Thank You for Your Submission!</h2>
        <p>Here are the details you entered:</p>
        
        <ul>
            <li><strong>First Name:</strong> <%= request.getParameter("firstName") %></li>
            <li><strong>Last Name:</strong> <%= request.getParameter("lastName") %></li>
            <li><strong>Age:</strong> <%= request.getParameter("age") %></li>
            <li><strong>Gender:</strong> <%= request.getParameter("gender") %></li>
            <li><strong>Nationality:</strong> <%= request.getParameter("nationality") %></li>
            <li><strong>Phone Number:</strong> <%= request.getParameter("phone") %></li>
            <li><strong>Course:</strong> <%= request.getParameter("course") %></li>
        </ul>
        <p>We'll review your application and get back to you.</p>

    </div>
</body>
</html>
