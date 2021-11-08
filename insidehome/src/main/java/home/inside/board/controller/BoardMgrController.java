package home.inside.board.controller;

// 윤선이 화이팅
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import home.inside.board.service.IBoardService;
import home.inside.board.util.ArticleMgrCommand;
import home.inside.board.util.PageSearchCommand;
import home.inside.board.vo.BoardVo;

@Controller
@RequestMapping("/manager/board")
public class BoardMgrController {
	@Autowired
	private IBoardService ser;

	// 공지 작성 폼 요청
	@RequestMapping(value = "/registForm.do")
	public String writeNoticeForm() throws Exception {
		return "manager/board/registForm";
	}

	// 공지 작성 요청
	@RequestMapping(value = "/regist.do", method = RequestMethod.POST)
	public String writeNoticeSubmit(ArticleMgrCommand artCmd, HttpSession session) throws Exception {
		String mgrNickname = (String) session.getAttribute("mgrInside");
		// artCmd.setWriter(mgrNickname);
		artCmd.setWriter("jin_inside");
		ser.insertBoard(artCmd, null);
		return "redirect:/manager/board/list.do";
	}

	// 공지 수정 폼 요청
	@RequestMapping(value = "/updateForm.do/{num}")
	public String updateNoticeForm(@PathVariable(value = "num") int num, Model model) throws Exception {
		model.addAttribute("reboard", ser.readBoard(num));
		return "manager/board/updateForm";
	}

	// 공지 수정 요청
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String updateNoticeSubmit(ArticleMgrCommand artCmd, Model model) throws Exception {
		// Validation추가
		/*
		 * readArticleView에서 조건 처리한거처럼 만약 readBoard(num) 이 null 이면 게시글 목록으로 redirect 그게
		 * 아니면 아래대로.....
		 */
		ser.updateBoard(artCmd, null);
		model.addAttribute("boardCode",artCmd.getBoardCode());
		model.addAttribute("notify",artCmd.getNotify());
		return "redirect:/manager/board/list.do";
	}

	// 회원 게시글 삭제요청
	@RequestMapping(value = "/delete.do/{num}", method = RequestMethod.POST)
	public String deleteArticleSubmit(@PathVariable(value = "num") int num) throws Exception {
		ser.deleteBoard(num, null);
		return "redirect:/manager/board/list.do";
	}

	// 게시글( + 공지) 상세조회 요청
	@RequestMapping(value = "/read.do/{num}")
	public String readArticleView(@PathVariable(value = "num") int num, Model model) throws Exception {
		BoardVo tmp = ser.readBoard(num);
		if (tmp == null) {
			return "redirect:/manager/board/list.do";
		}
		model.addAttribute("board", tmp);
		return "manager/board/detail";
	}

	// 게시판 목록조회 요청
	@RequestMapping(value = "/list.do")
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

		model.addAttribute("boardList", ser.boardList(notify, psCmd));
		model.addAttribute("psCmd", psCmd);
		return "/manager/board/list";
	}
}
