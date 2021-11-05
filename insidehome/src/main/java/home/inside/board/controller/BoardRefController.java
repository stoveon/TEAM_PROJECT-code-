package home.inside.board.controller;
// 아마도 지은이 (JSP)
// 윤선이 코드 살릴 수 있으면 살리고 웬만하면 새로짜


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import home.inside.board.service.IBoardService;
import home.inside.board.util.ArticleMgrCommand;
import home.inside.board.util.PageSearchCommand;

@Controller
@RequestMapping("/user/ref")
public class BoardRefController {
	@Autowired
	private IBoardService ser;

	// 댓글등록 요청
	@RequestMapping(value = "/regist.do", method = RequestMethod.POST)
	public String insertRefSubmit(int boardNum, int num, String content, HttpSession session) throws Exception {
		String nickname = (String) session.getAttribute("loginInside");
		return "redirect:/user/board/read.do";
	}

	// 댓글수정 요청
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String updateRefSubmit(int boardNum, int num, String content) throws Exception {
		return "redirect:/user/board/read.do";
	}

	// 댓글삭제 요청
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String deleteRefSubmit(int boardNum, int num) throws Exception {
		return "redirect:/user/board/read.do";
	}

}
