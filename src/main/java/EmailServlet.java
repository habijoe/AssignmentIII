import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
@WebServlet(name ="EmailServlet", urlPatterns = "/email")
public class EmailServlet extends HttpServlet{
  public void sentEmail(String email) {
        // Email configuration
        String host = "smtp.gmail.com"; // E.g., smtp.gmail.com
        String port = "587"; // E.g., 587 for TLS, 465 for SSL
        final String senderEmail = "habinezajoshua246@mail.com";
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
            message.setSubject("Login notification");

            String emailContent = "You have successfully logged in. if you don't recognize this action report .\n\n"
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
