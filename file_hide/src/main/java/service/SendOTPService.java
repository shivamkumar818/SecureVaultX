package service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendOTPService {
    public static void sendOtp(String email, String genOTP) {
        String to = email;

        String from = "shivamm.kumar818@gmail.com";
        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "kvbrwjzrqswdcevx");
            }
        });

        session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject("File ENC OTP");

            message.setText("Your Otp for File Enc app is " + genOTP);

            System.out.println("sending...");

            Transport.send(message);
1
            System.out.println("Sent message successfully...");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}


