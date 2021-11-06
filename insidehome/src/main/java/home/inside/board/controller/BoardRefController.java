package home.inside.board.controller;

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
		if(nickname != null) {
			System.out.println(boardNum+ nickname+ content);
			ser.insertRef(boardNum, nickname, content);
		}
		return "redirect:/user/board/read.do";
	}

	// 댓글수정 요청
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String updateRefSubmit(int boardNum, int num, String content) throws Exception {
		
		return "redirect:/user/board/read.do";
	}

	// 댓글삭제 요청
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String deleteRefSubmit(int num) throws Exception {
		ser.deleteRef(num);
		return "redirect:/user/board/read.do";
	}

}
