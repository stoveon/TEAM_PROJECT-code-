package home.inside.board.controller;
// 나네....
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import home.inside.board.service.IBoardService;
import home.inside.board.util.PageSearchCommand;

@Controller
public class BoardController {
	@Autowired
	private IBoardService ser;

	// 공지게시글 상세페이지 요청
	@RequestMapping("/board/read/notice.do")
	public String readArticleSubmit(int boardNum, Model model) throws Exception {
		return "user/board/detail";
	}

	// 게시글 목록/검색 요청
	@RequestMapping("/board/list.do")
	public String listArticleView(String notify, PageSearchCommand psCmd, Model model) throws Exception {
		return "user/board/list";
	}
}
