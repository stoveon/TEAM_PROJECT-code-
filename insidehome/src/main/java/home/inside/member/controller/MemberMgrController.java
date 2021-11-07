package home.inside.member.controller;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import home.inside.member.service.ILoginService;
import home.inside.member.service.IMemberInfoService;
import home.inside.member.util.LoginCommand;
import home.inside.member.util.LoginCommandValidator;

@Controller
public class MemberMgrController {
	@Autowired
	private IMemberInfoService infoSer;
	@Autowired
	private ILoginService logSer;
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	@RequestMapping(value = "/manager/member/list.do", method = RequestMethod.POST)
	public String memberList(String nickname, String type, Model model) throws Exception {
		if(nickname!=null) {
			model.addAttribute("memberList", infoSer.searchMemberList(nickname, type));
			model.addAttribute("nickname", nickname);
		}else {
			model.addAttribute("memberList", infoSer.selectMemberList(type));
		}
		model.addAttribute("type", type);
		return "manager/member/infoList";
	}
	
	@RequestMapping(value = "/manager/member/list.do")
	public String urlRequestMemberList(Model model) throws Exception{
		model.addAttribute("memberList", infoSer.selectMemberList("normal"));
		model.addAttribute("type", "normal");
		return "manager/member/infoList";
	}
	
	@RequestMapping(value = "/mgr/loginForm.do")
	public String mgrLoginForm(@ModelAttribute("cmd") LoginCommand cmd, Model model, HttpSession session) throws Exception {
		return "manager/main/loginForm";
	}

	@RequestMapping(value = "/manager/login.do", method = RequestMethod.POST)
	public String mgrLoginSubmit(String email, String password, HttpSession session) throws Exception {
		if(email==null || email.trim().isEmpty() || password==null || password.trim().isEmpty()) {
			return "manager/main/loginForm";
		} else if(!email.split("@")[1].equals("inside.home")) {
			return "redirect:/inside/main.do";
		}
		String nickname = null;
		HashMap<String, Object> info = infoSer.loginTmpSuccess(email);
		boolean pwdChk = pwdEncoder.matches(password, (String) info.get("PASSWORD"));
		if(!pwdChk || info==null) {
			return "manager/main/loginForm";
		} else if(pwdChk) {
			nickname = (String)info.get("NICKNAME");
			if(nickname!=null) {
				session.setAttribute("mgrInside", nickname);
				session.setAttribute("loginInside", nickname);
				logSer.loginSuccess(email, null, null);
			}
		}
		return "redirect:/manager/inside/main.do";
	}
}
