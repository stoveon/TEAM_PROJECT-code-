package home.inside.supporter.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import home.inside.board.service.IBoardService;
import home.inside.common.service.IPointService;
import home.inside.member.service.IMemberInfoService;
import home.inside.supporter.service.IWarningService;
import home.inside.supporter.vo.WarningVo;

@Controller
public class WarningController {

	@Autowired
	IWarningService service;
	@Autowired
	IPointService pointService;
	@Autowired
	IMemberInfoService imemberInfoService;
	@Autowired
	IBoardService boardService;

	// 신고 접수작성
	@RequestMapping(value = "/user/warning/insertForm.do", method=RequestMethod.GET)
	public String insertwarningForm(int num, Model model) throws Exception {
		model.addAttribute("boardNum", num);
		return "user/supporter/warningPopup";
	}

	// 신고 접수요청
	@RequestMapping(value = "/user/warning/insert.do", method=RequestMethod.POST)
	public String insertwarningSubmit(WarningVo vo) throws Exception {
		String nickname = boardService.readBoard(vo.getBoardNum()).getWriter();
		vo.setNickname(nickname);
		System.out.println(vo.toString());
		service.warningInsert(vo);
		return "redirect:/inside/main.do";

	}

	@RequestMapping(value = "/manager/warning/list.do")
	public String warnList(Model model) throws Exception {
		List<HashMap<String, Object>> list = service.warningSelectAll();
		model.addAttribute("warnList", list);
		return "manager/supporter/warnList";
	}
}
