<!DOCTYPE html>
<html>
<head>
    <title>Number Converter</title>
    <script>
        function clearField() {
            document.getElementsByName("number")[0].value = "";
        }

        function validateForm() {
            var number = document.getElementsByName("number")[0].value;
            if (number === "") {
                alert("Number field cannot be empty");
                return false;
            }
            return true;
        }
    </script>
    <style>
        .btn {
            padding: 5px 10px;
        }

        .error {
            color: red;
            margin-top: 10px;
            font-size: 19px;
        }
        a{
            text-decoration: none;
        }
    </style>
</head>
<body>
    <%@ include file = "Header.jsp"%>
    <h2>Number Converter</h2>
    <form method="post" action="convert" onsubmit="return validateForm()">
        Enter a number: <input type="text" name="number">
        <button type="submit" name="type" value="hexa">Hexa</button>
        <button type="submit" name="type" value="bin">Binary</button>
        <button type="submit" name="type" value="octal">Octal</button>
        <button type="button" onclick="clearField()">Clear</button>
    </form>

    <% if(request.getAttribute("error") != null) { %>
        <div class="error">
            <%= request.getAttribute("error") %>
        </div>
    <% } %>

    <% if(request.getAttribute("result") != null) { %>
        <h3>Result</h3>
        <p>Number: <%= request.getAttribute("number") %></p>
        <p>Result: <%= request.getAttribute("result") %></p>
        <%
            String type = (String) request.getAttribute("type");
            if (type != null) {
                switch (type) {
                    case "bin":
                        out.println("<li style='margin-left: 5px; color: blue;'>Decimal number converted to binary</li>");
                        break;
                    case "hexa":
                        out.println("<li style='margin-left: 5px; color: blue;'>Decimal number converted to hexadecimal</li>");
                        break;
                    case "octal":
                        out.println("<li style='margin-left: 5px; color: blue;'>Decimal number converted to octal</li>");
                        break;
                    default:
                        break;
                }
            } else {
                out.println("You need to input a decimal number");
            }
        %>
    <% } %>
    </body>
    </html>
