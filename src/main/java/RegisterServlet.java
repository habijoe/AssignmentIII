import java.io.*;
import java.nio.file.*;
import java.util.*;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(name = "register", urlPatterns = "/register")
@MultipartConfig
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");
        dispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Getting username and email from request
        String firstname = req.getParameter("firstName");
        String lastname = req.getParameter("lastName");
        int age = Integer.parseInt(req.getParameter("age"));
        String gender = req.getParameter("gender");
        String nationality = req.getParameter("nationality");
        String phone = req.getParameter("phone");
        String course = req.getParameter("course");
        String email = req.getParameter("email");

        // Getting files from request
        Part filePart1 = req.getPart("file1");
        Part filePart2 = req.getPart("file2");

        // Get the real path of the web application
        String appPath = req.getServletContext().getRealPath("/");
        String uploadPath = appPath + File.separator + "uploads"; // Directory within the web application

        // Create the directory if it doesn't exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        // Process file 1
        String fileName1 = Paths.get(filePart1.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        InputStream fileContent1 = filePart1.getInputStream();
        File file1 = new File(uploadDir, fileName1);
        try (InputStream input = fileContent1; OutputStream output = new FileOutputStream(file1)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle errors here
        }

        // Process file 2
        String fileName2 = Paths.get(filePart2.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        InputStream fileContent2 = filePart2.getInputStream();
        File file2 = new File(uploadDir, fileName2);
        try (InputStream input = fileContent2; OutputStream output = new FileOutputStream(file2)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle errors here
        }

        sentEmail(email);

        req.setAttribute("firstname", firstname);
        req.setAttribute("lastname", lastname);
        req.setAttribute("age", age);
        req.setAttribute("gender", gender);
        req.setAttribute("nationality", nationality);
        req.setAttribute("phone", phone);
        req.setAttribute("course", course);

        RequestDispatcher dispatcher = req.getRequestDispatcher("submission.jsp");
        dispatcher.forward(req, resp);
    }

    public void sentEmail(String email) {
        // Email configuration
        String host = "smtp.gmail.com"; // E.g., smtp.gmail.com
        String port = "587"; // E.g., 587 for TLS, 465 for SSL
        final String senderEmail = "habinezajoshua246@gmail.com";
        final String password = "hyxg enbk rlur akpk";

        // Set properties for SMTP
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Admission Confirmation");

            String emailContent = "Your admission has been sent successfully. Thank you for your application.\n\n"
                    + "Best regards,\n"
                    + "Adventist university of central africa";
            message.setText(emailContent);

            Transport.send(message);

            System.out.println("Email sent successfully.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}