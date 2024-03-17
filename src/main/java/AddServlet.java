
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name ="convert", urlPatterns="/convert")
public class AddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward the request to the index.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("number_converted.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String type = request.getParameter("type");
        String numberParam = request.getParameter("number");

        if (numberParam == null || numberParam.isEmpty()) {
            request.setAttribute("error", "Number field cannot be empty");
            RequestDispatcher dispatcher = request.getRequestDispatcher("number_converted.jsp");
            dispatcher.forward(request, response);
            return;
        }

        int number = Integer.parseInt(numberParam);

        String result = "";
        switch (type) {
            case "hexa":
                result = Integer.toHexString(number);
                break;
            case "bin":
                result = Integer.toBinaryString(number);
                break;
            case "octal":
                result = Integer.toOctalString(number);
                break;
            default:
                result = "-";
                break;
        }

        // Set the converted values as request attributes
        request.setAttribute("result", result);
        request.setAttribute("number", number);
        request.setAttribute("type", type);

        // Forward the request back to the index.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("number_converted.jsp");
        dispatcher.forward(request, response);
    }

}