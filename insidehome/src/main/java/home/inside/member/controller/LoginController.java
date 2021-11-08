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
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import home.inside.member.service.EmailService;
import home.inside.member.service.ILoginService;
import home.inside.member.service.IMemberInfoService;
import home.inside.member.util.FindEmailCommand;
import home.inside.member.util.FindPwCommand;
import home.inside.member.util.FindPwCommandValidator;
import home.inside.member.util.LoginCommand;
import home.inside.member.util.LoginCommandValidator;
import home.inside.member.vo.EmailVo;

@Controller
@RequestMapping("/member")
public class LoginController {
	@Autowired
	private ILoginService logSer;
	@Autowired
	private IMemberInfoService infoSer;
	@Autowired
	private EmailService emailSer;
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;

	@RequestMapping(value = "/loginForm.do")
	public String loginForm(@ModelAttribute("cmd") LoginCommand cmd, Model model,
			@CookieValue(value = "inssahouse", required = false) Cookie rememberCookie, HttpSession session)
			throws Exception {
		if (rememberCookie != null) {
			String sessionId = rememberCookie.getValue();
			HashMap<String, Object> info = logSer.loginOptionCheck(sessionId);
			if (info != null) {
				String loginOption = (String) info.get("LOGINOPTION");
				String email = (String) info.get("EMAIL");
				String nickname = (String) info.get("NICKNAME");
				if (loginOption != null && loginOption.equals("rememberEmail")) {
					cmd.setEmail(email);
					cmd.setLoginOption(loginOption);
				} else if (loginOption != null && loginOption.equals("autoLogin")) {
					session.setAttribute("loginInside", nickname);
					logSer.loginSuccess(email, sessionId, loginOption);
					return "redirect:/inside/main.do";
				}
			}
		} else {
			cmd = new LoginCommand();
		}
		model.addAttribute("cmd", cmd);
		return "user/member/loginForm";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String loginSubmit(@ModelAttribute("cmd") LoginCommand cmd, Errors errors, HttpServletRequest req,
			HttpServletResponse resp, @CookieValue(value = "tmpPwinssa", required = false)Cookie tmpCookie) throws Exception {
		new LoginCommandValidator().validate(cmd, errors);
		if (errors.hasErrors()) {
			return "user/member/loginForm";
		}
		if(cmd.getEmail().split("@")[1].equals("inside.home")) {
			return "redirect:/mgr/loginForm.do";
		}
		boolean pwdChk;
		String nickname = null;
		HashMap<String, Object> info = infoSer.loginTmpSuccess(cmd.getEmail());
		if(tmpCookie!=null) {
			pwdChk = pwdEncoder.matches(cmd.getPassword(), tmpCookie.getValue());	
		} else {
			if(info !=null) {
				pwdChk = pwdEncoder.matches(cmd.getPassword(), (String) info.get("PASSWORD"));
			}else {
				errors.rejectValue("email", "notmatch");
				return "user/member/loginForm";
			}
		}
		if(pwdChk) {
			nickname = (String)info.get("NICKNAME");
		} else {
			errors.rejectValue("email", "notmatch");
			return "user/member/loginForm";
		}
		if(nickname!=null && pwdChk) {
			HttpSession session = req.getSession();
			session.setAttribute("loginInside", nickname);
			String sessionId = session.getId();
			if (cmd.getLoginOption() != null && !cmd.getLoginOption().equals("")) {
				Cookie rememberCookie = new Cookie("inssahouse", sessionId);
				rememberCookie.setPath("/");
				rememberCookie.setMaxAge(60 * 60 * 24 * 7);
				resp.addCookie(rememberCookie);
				logSer.loginSuccess(cmd.getEmail(), sessionId, cmd.getLoginOption());
			} else {
				logSer.loginSuccess(cmd.getEmail(), null, null);
			}
		}
		return "redirect:/inside/main.do";
	}

	@RequestMapping(value = "/logout.do")
	public String logoutSubmit(HttpSession session) throws Exception {
		session.removeAttribute("loginInside");
		session.removeAttribute("mgrInside");
		return "redirect:/inside/main.do";
	}

	@RequestMapping(value = "/searchEmailForm.do")
	public String findInfoForm(@ModelAttribute("emailCmd") FindEmailCommand emailCmd, Model model) throws Exception {
		model.addAttribute("emailCmd", new FindEmailCommand());
		return "user/member/findEmailForm";
	}

	@RequestMapping(value = "/searchEmail.do", method = RequestMethod.POST)
	public String findInfoSubmit(@ModelAttribute("emailCmd") FindEmailCommand emailCmd, Errors errors, Model model)
			throws Exception {
		if(emailCmd.getEmailAddr()==null || emailCmd.getEmailAddr().trim().isEmpty()) {
			errors.rejectValue("emailAddr", "required");
			return "user/member/findEmailForm";
		} else if(emailCmd.getPhoneNum()==null || emailCmd.getPhoneNum().trim().isEmpty()) {
			errors.rejectValue("phoneNum", "required");
			return "user/member/findEmailForm";
		} else {
			model.addAttribute("findResult", infoSer.findMemberInfo(emailCmd, null));
			model.addAttribute("type", "email");
			return "user/member/findInfoResult";
		}
	}

	@RequestMapping(value = "/searchPwForm.do")
	public String findInfoForm(@ModelAttribute("pwCmd") FindPwCommand pwCmd, Model model) throws Exception {
		model.addAttribute("pwCmd", new FindPwCommand());
		return "user/member/findPasswordForm";
	}
	
	@RequestMapping(value = "/searchPw.do", method = RequestMethod.POST)
	public String findInfoSubmit(@ModelAttribute("pwCmd") FindPwCommand cmd, Errors errors, Model model, HttpServletResponse resp)
			throws Exception {
		new FindPwCommandValidator().validate(cmd, errors);
		if (errors.hasErrors()) {
			return "user/member/findPasswordForm";
		}
		String result = infoSer.findMemberInfo(null, cmd);
		if(result!=null) {
			String tmpPw = emailSer.emailSend(result);
			tmpPw = pwdEncoder.encode(tmpPw);
			Cookie tmpCookie = new Cookie("tmpPwinssa", tmpPw);
			tmpCookie.setMaxAge(60*10);//10분간만 유지
			resp.addCookie(tmpCookie);
		}
		model.addAttribute("findResult", result);
		model.addAttribute("type", "password");

		return "user/member/findInfoResult";
	}	
}
