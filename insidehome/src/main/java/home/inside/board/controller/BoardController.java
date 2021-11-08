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
		ser.updateHit(boardNum);
		model.addAttribute("board", ser.readBoard(boardNum));
		model.addAttribute("boardCheck", "notice");
		return "/user/board/detail";
	}

	// 게시글 목록/검색 요청
	@RequestMapping("/board/list.do")
	public String listArticleView(PageSearchCommand psCmd, Model model) throws Exception {
		Integer pageNum = psCmd.getPageNum();
		pageNum = (pageNum == null) ? 1 : pageNum;
		int pageSize = 20;
		psCmd.setPageSize(pageSize);
		psCmd.setCurrentPage(pageNum);
		psCmd.setStartNum(pageSize * (pageNum - 1) + 1);
		psCmd.setEndNum(pageSize * pageNum);
		String boardCode = (psCmd.getBoardCode() == null) ? "info" : psCmd.getBoardCode();
		String notify = (boardCode.equals("notice")) ? "notice" : "no";

		int count = 0;
		if (boardCode.equals("notice")) {
			count = ser.notiListSize(psCmd.getType(), psCmd.getWord());
		} else {
			count = ser.boardListSize(boardCode, psCmd.getType(), psCmd.getWord());
		}
		int tmp = (count % pageSize == 0) ? 0 : 1;
		psCmd.setNumber(count / pageSize + tmp);
		count -= pageSize * (pageNum - 1);
		psCmd.setCount(count);

		if (boardCode.equals("info") || boardCode.equals("who")) {
			model.addAttribute("notifyList", ser.boardNotifyList(boardCode));
			if (boardCode.equals("info")) {
				model.addAttribute("heartList", ser.selectHeartList());
				model.addAttribute("hitList", ser.selectHitList());
			}
		} else if(boardCode.equals("notice")) {
			model.addAttribute("boardCheck", "notify");
		}
		model.addAttribute("boardList", ser.boardList(notify, psCmd));
		model.addAttribute("psCmd", psCmd);
		return "/user/board/list";
	}
}
