package home.inside.member.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import home.inside.common.service.IPointService;
import home.inside.goods.service.IGoodsService;
import home.inside.member.service.ILoginService;
import home.inside.member.service.IMemberInfoService;
import home.inside.member.util.ChangePwCommand;
import home.inside.member.util.ChangePwCommandValidatior;
import home.inside.member.util.RegistCommand;
import home.inside.member.vo.MemberInfoDto;

@Controller
@RequestMapping("/user/mypage")
public class MemberInfoController {
	@Autowired
	private IMemberInfoService infoSer;
	@Autowired
	private IPointService pointSer;
	// private IBoardDetailService boardSer;
	@Autowired
	private IGoodsService goodsSer;
	// private IQuestionService qaSer;
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;

	@RequestMapping(value = "/main.do")
	public String mypage(String viewPage, String str, Model model, HttpSession session) throws Exception {
		viewPage = (viewPage == null) ? "board" : viewPage;
		String nickname = (String) session.getAttribute("loginInside");
		model.addAttribute("infoCount", infoSer.selectMyCount(nickname));
		model.addAttribute("orderCount", goodsSer.nicknameOrderCount(nickname));
		model.addAttribute("qaCount", 3);
		model.addAttribute("viewPage", viewPage);
		if (viewPage.equals("board")) {
			model.addAttribute("articleList", new ArrayList<HashMap<String, Object>>());
			// boardSer.searchNickname(nickname, str)
		}
		if (viewPage.equals("point")) {
			model.addAttribute("pointList", pointSer.selectList(nickname));
		}
		if (viewPage.equals("order")) {
			model.addAttribute("orderList", goodsSer.nicknameOrderList(nickname));
		}
		return "user/member/mypage/mypageMain";
	}

	@RequestMapping(value = "/info/view.do")
	public String myInfo(Model model, HttpSession session) throws Exception {
		String nickname = (String) session.getAttribute("loginInside");
		model.addAttribute("myInfo", infoSer.selectInfo(nickname));
		return "user/member/mypage/memberInfo";
	}

	@RequestMapping(value = "/info/updateForm.do", method = RequestMethod.POST)
	public String infoUpdateForm(@ModelAttribute("myInfo") MemberInfoDto myInfo, Model model, HttpSession session)
			throws Exception {
		String nickname = (String) session.getAttribute("loginInside");
		model.addAttribute("myInfo", infoSer.selectInfo(nickname));
		return "user/member/mypage/changeInfoForm";
	}

	@RequestMapping(value = "/info/update.do", method = RequestMethod.POST)
	public String infoUpdateSubmit(@ModelAttribute("myInfo") MemberInfoDto myInfo, Errors errors) throws Exception {
		if (myInfo.getPhone2() == null || myInfo.getPhone2().trim().isEmpty()) {
			errors.rejectValue("phone2", "required");
			return "user/member/mypage/changeInfoForm";
		}
		infoSer.updateMyInfo(myInfo);
		return "redirect:/user/mypage/info/view.do";
	}

	@RequestMapping(value = "/changePwForm.do")
	public String changePwForm(ChangePwCommand editCmd, Model model) throws Exception {
		model.addAttribute("editCmd", new ChangePwCommand());
		return "user/member/mypage/changePwForm";
	}

	@RequestMapping(value = "/changePw.do", method = RequestMethod.POST)
	public String changePwSubmit(@ModelAttribute("editCmd") ChangePwCommand editCmd, Errors errors,
			RedirectAttributes rttr) throws Exception {
		new ChangePwCommandValidatior().validate(editCmd, errors);
		if (errors.hasErrors()) {
			return "user/member/mypage/changePwForm";
		}
		HashMap<String, Object> info = infoSer.loginTmpSuccess(editCmd.getEmail());
		String nickname = (String) info.get("NICKNAME");
		if (nickname == null || nickname.equals("")) {
			rttr.addFlashAttribute("updateResult", "fail");
		} else {
			String newPw = pwdEncoder.encode(editCmd.getNewPassword());
			if (!pwdEncoder.matches(editCmd.getPassword(), (String) info.get("PASSWORD"))) {
				rttr.addFlashAttribute("updateResult", "fail");
			} else {
				infoSer.updatePassword(nickname, newPw);
				rttr.addFlashAttribute("updateResult", "success");
			}
		}
		return "redirect:/user/mypage/info/view.do";
	}

}
