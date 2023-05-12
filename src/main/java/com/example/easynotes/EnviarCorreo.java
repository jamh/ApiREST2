package com.example.easynotes;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviarCorreo {
	private final Properties properties = new Properties();

	private String password;

	private Session session;

	private void init() {

		properties.setProperty("mail.smtp.host", "mail.feraz.com.mx");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.port", "465");
		properties.setProperty("mail.smtp.mail.sender","avisos@feraz.com.mx");
		properties.setProperty("mail.smtp.user", "avisos@feraz.com.mx");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.ssl.enable", "true");
		properties.setProperty("mail.smtp.**ssl.required", "true");
		properties.setProperty("log4j.appender.email", "org.apache.log4j.net.SMTPAppender");
		session = Session.getDefaultInstance(properties);
	}

	public void sendEmail() {

		init();
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender")));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("Josue.rmz.18@outlook.es"));
			message.setSubject("Prueba");
			message.setText("Prueba de envio mail.jar");
			Transport t = session.getTransport("smtp");
			t.connect((String) properties.get("mail.smtp.user"), "5uMMkwzebq0m");
			t.sendMessage(message, message.getAllRecipients());
			t.close();
		} catch (MessagingException me) {
			// Aqui se deberia o mostrar un mensaje de error o en lugar
			// de no hacer nada con la excepcion, lanzarla para que el modulo
			// superior la capture y avise al usuario con un popup, por ejemplo.
			return;
		}

	}

}

