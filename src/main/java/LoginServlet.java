import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward the request to the login page
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("email");
        String password = request.getParameter("password");

        if (username != null && password != null && username.equals("habinezajoshua246@gmail.com")
                && password.equals("joshua@123")) {
            // Redirect to register.jsp
            HttpSession session = request.getSession();
            session.setAttribute("isLoggedIn", true);
            EmailServlet eml = new EmailServlet();
            eml.sentEmail(username);
            response.sendRedirect(request.getContextPath() + "/register");
        } else {
            // Set an error message attribute
            String error = "Wrong email or password";
            request.setAttribute("error", error);
            // Forward the request back to login.jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
