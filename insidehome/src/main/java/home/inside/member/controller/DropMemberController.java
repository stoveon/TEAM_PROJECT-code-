package home.inside.member.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import home.inside.common.service.IPointService;
import home.inside.goods.service.IGoodsService;
import home.inside.member.service.ILoginService;
import home.inside.member.service.IMemberInfoService;
import home.inside.member.vo.MemberDropVo;

@Controller
@RequestMapping("/user/mypage")
public class DropMemberController {
	@Autowired
	private IMemberInfoService infoSer;
	@Autowired
	private IPointService pointSer;
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	@Autowired 
	private IGoodsService goodsSer;
	
	
	// private IBoardService boardSer;
	// private IQuestionService questionSer;
	// private IWarnService warnSer;
	// private ITalkService talkSer;

	@RequestMapping(value = "/info/dropForm.do")
	public String dropMemberForm() throws Exception {
		return "user/member/mypage/dropMemberForm";
	}

	@RequestMapping(value = "/info/drop.do", method = RequestMethod.POST)
	public String dropMemberSubmit(String email, String password,
			@RequestParam(value = "agree", defaultValue = "false") Boolean agree, HttpSession session)
			throws Exception {
		System.out.println(email + ", " + password + ", " + agree + ", " + session.getAttribute("loginInside"));
		if (email == null || password == null || agree == null) {
			return "user/member/mypage/dropMemberForm";
		}
		HashMap<String, Object> info = infoSer.loginTmpSuccess(email);
		String searchNickname = (String) info.get("NICKNAME");
		String nickname = (String) session.getAttribute("loginInside");
		if (searchNickname == null || searchNickname.equals("")) {
			return "redirect:/user/mypage/info/dropForm.do";
		} else {
			if (searchNickname.equals(nickname) && pwdEncoder.matches(password, (String) info.get("PASSWORD"))) {
				Integer warn = Integer.parseInt(String.valueOf(info.get("WARNCOUNT")));
				MemberDropVo dropVo = new MemberDropVo(email, nickname, warn);
				infoSer.dropMember(dropVo);
				pointSer.deletePoint(nickname);
				goodsSer.deleteGoodsSales(nickname);
				return "redirect:/member/logout.do";
			}
			return "redirect:/user/mypage/info/dropForm.do";
		}
	}

}
