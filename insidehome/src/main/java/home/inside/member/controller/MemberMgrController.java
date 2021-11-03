package home.inside.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import home.inside.member.service.IMemberInfoService;

@Controller
@RequestMapping("/manager/member/")
public class MemberMgrController {
	@Autowired
	private IMemberInfoService infoSer;

	@RequestMapping(value = "list.do", method = RequestMethod.POST)
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
	
	@RequestMapping(value = "list.do")
	public String urlRequestMemberList(Model model) throws Exception{
		model.addAttribute("memberList", infoSer.selectMemberList("normal"));
		model.addAttribute("type", "normal");
		return "manager/member/infoList";
	}
}
