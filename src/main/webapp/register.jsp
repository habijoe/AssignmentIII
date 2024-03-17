<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>University Admission Form</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <div class="card">
                <%@ include file = "Header.jsp"%>
            
        <h2>University Admission Form</h2>
        <form action="register" method="post" enctype="multipart/form-data">
            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" name="firstName" required><br><br>

            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" name="lastName" required><br><br>
            
            <label for="age">Age:</label>
            <input type="number" id="age" name="age" required><br><br>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required><br><br>

            <label for="file1">Upload your photo here</label>
            <input type="file" id="file1" name="file1" required><br><br>

            <label for="file2">Upload your Diploma here</label>
            <input type="file" id="file2" name="file2" required><br><br>
            
            <label for="gender">Gender:</label>
            <select id="gender" name="gender" required>
                <option value="male">Male</option>
                <option value="female">Female</option>
                <option value="other">Other</option>
            </select><br><br>
            
            <label for="nationality">Nationality:</label>
            <input type="text" id="nationality" name="nationality" required><br><br>

            <label for="phoneNumber">Phone Number:</label>
            <input type="text" id="phoneNumber" name="phone" required><br><br>

            <label for="course">Select Course:</label>
            <select id="course" name="course" required>
                <option value="Computer Science">Computer Science</option>
                <option value="Electrical Engineering">Electrical Engineering</option>
                <option value="Civil Engineering">Civil Engineering</option>
                <option value="Mechanical Engineering">Mechanical Engineering</option>
                <option value="English Literature">English Literature</option>
                <option value="History">History</option>
                <!-- Add more options as needed -->
            </select><br><br>
            
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>
