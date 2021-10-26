package home.inside.member.service;

import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import home.inside.member.vo.EmailVo;

@Component
public class EmailService {
	@Autowired
	private JavaMailSender mailSender;
	
	public void emailSend(EmailVo email) throws Exception{
		MimeMessage msg = mailSender.createMimeMessage();
		msg.setSubject(email.getContent());
		msg.setText(email.getContent());
		msg.setRecipient(RecipientType.TO, new InternetAddress(email.getReceiver()));
		mailSender.send(msg);
	}
}
