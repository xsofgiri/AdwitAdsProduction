package com.production.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;
import javax.mail.search.FlagTerm;

public class CheckingMails {

	private static final String DOWNLOAD_DIRECTORY = "/Users/giri/Downloads/";
	

	public static void checkPOP3(String host, String storeType, String user, String password) {
		try {

			// create properties field
			Properties properties = new Properties();

			properties.put("mail.pop3.host", host);
			properties.put("mail.pop3.port", "995");
			properties.put("mail.pop3.starttls.enable", "true");
			properties.put("mail.pop3.ssl.trust", host);
			
			Session emailSession = Session.getDefaultInstance(properties);

			// create the POP3 store object and connect with the pop server
			Store store = emailSession.getStore("pop3s");

			store.connect(host, user, password);

			// create the folder object and open it
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			// retrieve the messages from the folder in an array and print it
//		      Message[] messages = emailFolder.getMessages();

			// Fetch unseen messages from inbox folder
			Message[] messages = emailFolder.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));

			System.out.println("messages.length---" + messages.length);

			for (int i = 0, n = messages.length; i < n; i++) {
				Message message = messages[i];
				System.out.println("---------------------------------");
				System.out.println("Email Number " + (i + 1));
				System.out.println("Subject: " + message.getSubject());
				System.out.println("From: " + message.getFrom()[0]);
				System.out.println("Text: " + message.getContent().toString());
				
				if(hasAttachments(message))
					downloadAttachments(message);
			}

			// close the store and folder objects
			emailFolder.close(false);
			store.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void checkIMAP(String host, String storeType, String user, String password) {
		try {

			// create properties field
			Properties properties = new Properties();

			properties.put("mail.imap.host", host);
			properties.put("mail.imap.port", "993");
			properties.put("mail.imap.starttls.enable", "true");
			properties.put("mail.imap.ssl.trust", host);
			
			Session emailSession = Session.getDefaultInstance(properties);

			// create the POP3 store object and connect with the pop server
			Store store = emailSession.getStore("imaps");

			store.connect(host, user, password);

			// create the folder object and open it
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_WRITE);

			// retrieve the messages from the folder in an array and print it
//		      Message[] messages = emailFolder.getMessages();

			// Fetch unseen messages from inbox folder
			Message[] messages = emailFolder.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));

			System.out.println("messages.length---" + messages.length);

			for (int i = 0, n = messages.length; i < n; i++) {
				Message message = messages[i];
				System.out.println("---------------------------------");
				System.out.println("Email Number " + (i + 1));
				System.out.println("Subject: " + message.getSubject());
				System.out.println("From: " + message.getFrom()[0]);
				System.out.println("Text: " + message.getContent().toString());
				
				message.setFlag(Flags.Flag.SEEN , true);//marking a mail as read.
				if(hasAttachments(message))
					downloadAttachments(message);
			}

			// close the store and folder objects
			emailFolder.close(false);
			store.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static boolean hasAttachments(Message msg) throws MessagingException {
		try {
			if (msg.isMimeType("multipart/mixed")) {
				Multipart mp = (Multipart) msg.getContent();
				if (mp.getCount() > 1)
					return true;
			}
			return false;
		}catch(Exception e) {
			return false;
		}
		
	}

	public static List<String> downloadAttachments(Message message) throws IOException, MessagingException {
		List<String> downloadedAttachments = new ArrayList<String>();
		Multipart multiPart = (Multipart) message.getContent();
		int numberOfParts = multiPart.getCount();
		for (int partCount = 0; partCount < numberOfParts; partCount++) {
			MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
			if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
				String file = part.getFileName();
				
				part.saveFile(DOWNLOAD_DIRECTORY + File.separator + part.getFileName());
				downloadedAttachments.add(file);
			}
		}
		return downloadedAttachments;
	}

	public static void main(String[] args) {

		String host = "pop.gmail.com";// change accordingly
		String mailStoreType = "pop3";
		String username = "giri@adwitglobal.com";// change accordingly
		String password = "giri@adwit";// change accordingly
 
//		checkPOP3(host, mailStoreType, username, password);
		
		host = "imap.gmail.com";
		mailStoreType = "imap";
		checkIMAP(host, mailStoreType, username, password);
		
		
		

	}

}
