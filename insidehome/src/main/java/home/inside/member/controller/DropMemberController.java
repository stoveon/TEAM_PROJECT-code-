package home.inside.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import home.inside.common.service.IPointService;
import home.inside.member.service.IMemberInfoService;

@Controller
@RequestMapping("/user/mypage")
public class DropMemberController {
	@Autowired
	private IMemberInfoService infoSer;
	@Autowired
	private IPointService pointSer;
	// prvate IBoardService boardSer;
	// prvate IQuestionService questionSer;
	// prvate IWarnService warnSer;
	// prvate IGoodsService goodsSer;
	// prvate ITalkService talkSer;

	@RequestMapping(value = "/info/dropForm.do")
	public String dropMemberForm() throws Exception {
		return "user/member/mypage/dropMemberForm";
	}

	@RequestMapping(value = "/info/drop.do", method = RequestMethod.POST)
	public String dropMemberSubmit() throws Exception {
		return "user/main/main";
	}

}
