package home.inside.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import home.inside.member.service.EmailService;
import home.inside.member.vo.EmailVo;

@Controller
public class EmailController {
	@Autowired
	private EmailService service;
	
	@RequestMapping(value="/inside/email.do", method = RequestMethod.POST)
	public String submit(EmailVo email) throws Exception {
		email.setReceiver("stopluna@naver.com");
		email.setSubject("dndpdpdpdpdpdpdpdpdpppp");
		email.setContent("insideHome 비밀번호 변경 요청");
		service.emailSend(email);
		return "/user/member/findInfoSuccess";
	}
}
