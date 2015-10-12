package com.epam;

import com.google.common.base.Joiner;

import java.util.*;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by Kostiantyn_Slyshkov on 10/12/2015.
 */
public class EmailNotification {
	private static String denis = "denis_pimonov@epam.com";
	private static String taras = "taras_katrichenko@epam.com";
	private static String alex = "oleksii_moroz@epam.com";
	private static String from = "konstantin.slyshkov@gmail.com";
	private static String kot = "kostiantyn_slyshkov@epam.com";
	private static String host = "owabud.epam.com";



	public static void sendMessage(Map<String, String> feeds) {
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		Session session = Session.getDefaultInstance(properties);

		String notification = Joiner.on("\n").withKeyValueSeparator("_______ ").join(feeds);
		System.out.println(notification);
		MimeMessage message = new MimeMessage(session);
		try {
			message.saveChanges();
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(denis));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(taras));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(alex));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(kot));
			message.setSubject("Endaily feed notification");
			message.setText(notification);
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
