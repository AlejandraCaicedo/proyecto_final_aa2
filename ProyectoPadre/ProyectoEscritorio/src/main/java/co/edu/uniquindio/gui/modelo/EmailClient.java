package co.edu.uniquindio.gui.modelo;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import co.edu.uniquindio.uniMarket.entidades.Admin;
import co.edu.uniquindio.uniMarket.entidades.User;
import co.edu.uniquindio.uniMarket.excepciones.NotFoundAdminException;

import java.util.Properties;

public class EmailClient {
	private static final String senderEmail = "pruebaemailproyectoanalisis@gmail.com";// change with your sender email
	private static final String senderPassword = "181102002";// change with your sender password
	private static EntityManager entityManager;

	private static void sendAsHtml(String to, String title, String html) throws MessagingException {
		System.out.println("Sending email to " + to);

		Session session = createSession();

		// create message using session
		MimeMessage message = new MimeMessage(session);
		prepareEmailMessage(message, to, title, html);

		// sending message
		Transport.send(message);
		System.out.println("Done");
	}

	private static void prepareEmailMessage(MimeMessage message, String to, String title, String html)
			throws MessagingException {
		message.setContent(html, "text/html; charset=utf-8");
		message.setFrom(new InternetAddress(senderEmail));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		message.setSubject(title);
	}

	private static Session createSession() {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");// Outgoing server requires authentication
		props.put("mail.smtp.starttls.enable", "true");// TLS must be activated
		props.put("mail.smtp.host", "smtp.gmail.com"); // Outgoing server (SMTP) - change it to your SMTP server
		props.put("mail.smtp.port", "587");// Outgoing port

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, senderPassword);
			}
		});
		return session;
	}

	public static void toRecoverPasswordUser(String email) throws MessagingException {

		TypedQuery<User> lista = entityManager.createNamedQuery(User.FIND_BY_EMAIL, User.class);
		lista.setParameter("email", email);
		if (!lista.getResultList().isEmpty()) {
			User user = lista.getResultList().get(0);
			EmailClient.sendAsHtml(user.getEmail(), "Recover Password",
					"<h2>Forgotten Password</h2><p>You have solicited the recover of you password, if you didn't just ignore this message</p><p>Your password is: "
							+ user.getPassword() + "</p>");
		}

	}

	public static void toRecoverPasswordAdmin(String email) throws MessagingException, NotFoundAdminException {

		TypedQuery<Admin> lista = entityManager.createNamedQuery(Admin.FIND_BY_EMAIL, Admin.class);
		lista.setParameter("email", email);
		if (!lista.getResultList().isEmpty()) {

			Admin admin = lista.getResultList().get(0);
			EmailClient.sendAsHtml(admin.getEmail(), "Recover Password",
					"<h2>Forgotten Password</h2><p>You have solicited the recover of you password, if you didn't just ignore this message</p><p>Your password is: "
							+ admin.getPassword() + "</p>");
		} else {
			throw new NotFoundAdminException("El email no corresponde a un Admin registrado");
		}
	}

	public static void main(String[] args) throws MessagingException {
		String contra = "12345";
		EmailClient.sendAsHtml("macaicedoc@uqvirtual.edu.co", "Test email",
				"<h2>Forgotten Password</h2><p>You have solicited the recover of you password, if you didn't just ignore this message</p><p>Your password is: "
						+ "181102002" + "</p>");
	}
}