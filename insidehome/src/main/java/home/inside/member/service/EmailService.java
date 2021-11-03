package home.inside.member.service;

import java.util.UUID;

import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
	@Autowired
	private JavaMailSender mailSender;

	public String emailSend(String receiver) throws Exception {
		MimeMessage msg = mailSender.createMimeMessage();
		msg.setSubject("insideHome 개인정보 찾기 관련 메일 발송");
		String tmpPassword = UUID.randomUUID().toString().substring(0, 8)+"@#";
		String content = "<div align='center'><h1>임시비밀번호 안내</h1>"
						+ "<div>" + receiver + "님의 임시 비밀번호는 " + tmpPassword + " 입니다.<br>임시 비밀번호는 약 10분간만 유지되니, 로그인 후 반드시 변경하시기 바랍니다.</div>"
						+ "<div><a href='http://localhost:8080/insidehome/'' style=' border: 1px solid white; border-radius: 3px; color: white; background: #B8DFD8; font-size: auto; width: auto; padding: 10px 5px 10px 5px; '><b>홈페이지로 이동</b></a></div></div>";
		msg.setContent(content, "text/html;charset=euc-kr");
		msg.setRecipient(RecipientType.TO, new InternetAddress(receiver));
		mailSender.send(msg);
		return tmpPassword;
	}
}
