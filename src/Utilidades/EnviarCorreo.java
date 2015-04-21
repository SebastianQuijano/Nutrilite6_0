/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick
 */
public class EnviarCorreo {
    
    private static final String username = "erick.mca@gmail.com";
    private static final String password = "erickMANUEL7=";
    private static final String subject = "Envio de Contrasena";
    private static final String text = "Su contrasena es: ";
    private static final String host = "smtp.gmail.com";
    private static final String port = "587";
    
    public static void sendMessage(String destinatario, String passwordDestino) throws MessagingException{
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        
        props.setProperty("mail.smtp.user", username);
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);
        
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
        message.setSubject(subject);
        message.setText(text + passwordDestino);

        Transport t = session.getTransport("smtp");
        t.connect(username, password);
        t.sendMessage(message, message.getAllRecipients());
        t.close();
        
    }
    
}
