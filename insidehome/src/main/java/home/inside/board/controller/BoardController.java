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
	public String readArticleSubmit(int boardNum, String boardName, Model model) throws Exception {
		ser.updateHit(boardNum);
		model.addAttribute("board", ser.readBoard(boardNum));
		model.addAttribute("boardName", boardName);
		return "/user/board/detail";
	}

	// 게시글 목록/검색 요청
	@RequestMapping("/board/list.do")
	public String listArticleView(PageSearchCommand psCmd, String boardName, Model model) throws Exception {
		Integer pageNum = psCmd.getPageNum();
		pageNum = (pageNum == null) ? 1 : pageNum;
		int pageSize = 20;
		psCmd.setPageSize(pageSize);
		psCmd.setCurrentPage(pageNum);
		psCmd.setStartNum(pageSize * (pageNum - 1) + 1);
		psCmd.setEndNum(pageSize * pageNum);
		boardName = (boardName == null) ? "info" : boardName;
		String notify = (boardName.equals("notice")) ? "notice" : "no";
		psCmd.setBoardCode(boardName);
		int count = 0;
		if (boardName.equals("notice")) {
			count = ser.notiListSize(psCmd.getType(), psCmd.getWord());
		} else {
			count = ser.boardListSize(boardName, psCmd.getType(), psCmd.getWord());
		}
		int tmp = (count % pageSize == 0) ? 0 : 1;
		psCmd.setNumber(count / pageSize + tmp);
		count -= pageSize * (pageNum - 1);
		psCmd.setCount(count);

		if (boardName.equals("info") || boardName.equals("who")) {
			model.addAttribute("notifyList", ser.boardNotifyList(boardName));
			if (boardName.equals("info")) {
				model.addAttribute("heartList", ser.selectHeartList());
				model.addAttribute("hitList", ser.selectHitList());
			}
		}
		model.addAttribute("boardList", ser.boardList(notify, psCmd));
		model.addAttribute("boardName", boardName);
		model.addAttribute("psCmd", psCmd);
		return "/user/board/list";
	}
}
