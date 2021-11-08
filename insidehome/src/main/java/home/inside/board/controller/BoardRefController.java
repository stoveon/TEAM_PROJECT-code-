package home.inside.board.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import home.inside.board.service.IBoardService;

@Controller
@RequestMapping("/user/ref")
public class BoardRefController {
	@Autowired
	private IBoardService ser;

	// 댓글등록 요청
	@RequestMapping(value = "/regist.do", method = RequestMethod.POST)
	public String insertRefSubmit(int boardNum, String content, HttpSession session, RedirectAttributes rttr)
			throws Exception {
		String nickname = (String) session.getAttribute("loginInside");
		rttr.addAttribute("boardNum", boardNum);
		if (content != null && !content.trim().isEmpty()) {
			ser.insertRef(boardNum, nickname, content);
		}
		return "redirect:/user/board/read.do";
	}

	// 댓글수정 요청
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String updateRefSubmit(int num, int boardNum, String content, RedirectAttributes rttr, HttpSession session)
			throws Exception {
		String nickname = (String) session.getAttribute("loginInside");
		rttr.addAttribute("boardNum", boardNum);
		if (content != null && !content.trim().isEmpty()) {
			HashMap<String, Object> tmpInfo = ser.isCheckWriterToUser(boardNum, num);
			if (tmpInfo.get("REFWRITER").equals(nickname) || tmpInfo.get("BOARDWRITER").equals(nickname)) {
				ser.updateRef(num, content);
				rttr.addAttribute("read", "reE");
			}
		}
		return "redirect:/user/board/read.do";
	}

	// 댓글삭제 요청
	@RequestMapping(value = "/delete.do")
	public String deleteRefSubmit(int num, int boardNum, RedirectAttributes rttr, HttpSession session)
			throws Exception {
		String nickname = (String) session.getAttribute("loginInside");
		rttr.addAttribute("boardNum", boardNum);
		HashMap<String, Object> tmpInfo = ser.isCheckWriterToUser(boardNum, num);
		if (tmpInfo.get("REFWRITER").equals(nickname) || tmpInfo.get("BOARDWRITER").equals(nickname)) {
			ser.deleteRef(num);
			rttr.addAttribute("read", "reD");
		}
		return "redirect:/user/board/read.do";
	}

}
