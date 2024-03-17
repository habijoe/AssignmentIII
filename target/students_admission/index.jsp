<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Assignment1</title>
    <link rel="stylesheet" href="#">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
        }
        .container {
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1, h2, h3 {
            color: #333;
        }
        .navigation-links ul {
            list-style-type: none;
            padding: 0;

        }
        .navigation-links li {
            margin-bottom: 10px;
        }
        .navigation-links a {
            text-decoration: none;
            display: inline-block;
            padding: 10px 20px;
            background-color: blue;
            color: black;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        .navigation-links a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
    <%@ include file = "Header.jsp"%>
        <h1>Welcome to this site</h1>
        <div class="navigation-links">
            <h3>Use the below links to navigate to other pages:</h3>
            <ul>
                <li><a href="number_converted.jsp">Number Converter </a></li>
                <li><a href="login.jsp">Student Admission Management</a></li>
            </ul>
        </div>
    </div>
</body>
</html>
