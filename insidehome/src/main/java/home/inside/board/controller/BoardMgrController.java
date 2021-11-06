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
@RequestMapping("/manager/board")
public class BoardMgrController {
	@Autowired
	private IBoardService ser;

	// 공지 작성 폼 요청
	@RequestMapping(value = "/registForm.do")
	public String writeNoticeForm(ArticleMgrCommand artCmd, Model model) throws Exception {
		//		artCmd.setNotify("yes");
		// notify컬럼 사용예시
		/* boardCode 는 info, who만 사용
		 * notify로 공지인지 아닌지 확인
		 * 회원이 작성한 글 > notify=no
		 * 관리자 작성 글 > notify=yes
		 * 			> 글 수정 시 notify를 yes/notice 선택
		 * 
		 * ex) 
		 * 공지게시판 > notify가 no가 아닌 모든 글
		 * 정보게시판 > boardCode가 info면서 (notify가 notice인 공지글 + notify가 no인 회원글)
		 * 익명게시판 > boardCode가 who면서 (notify가 notice인 공지글 + notify가 no인 회원글)
		 */
		return "manager/board/registForm";
	}

	// 공지 작성 요청
	@RequestMapping(value = "regist.do", method = RequestMethod.POST)
	public String writeNoticeSubmit(ArticleMgrCommand artCmd, MultipartHttpServletRequest mpReq) throws Exception {
		return "redirect:/manager/board/list.do";
	}

	// 공지 수정 폼 요청
	@RequestMapping(value = "/updateForm.do")
	public String updateNoticeForm(int num, Model model, HttpSession session) throws Exception {
		return "manager/board/updateForm";
	}

	// 공지 수정 요청
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public String updateNoticeSubmit(ArticleMgrCommand artCmd, HttpSession session) throws Exception {
		return "redirect:/manager/board/read.do";
	}
	
	// 회원 게시글 삭제요청
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String deleteArticleSubmit(int boardNum) throws Exception {
		return "redirect:manager/board/list.do";
	}

	// 게시글( + 공지) 상세조회 요청
	@RequestMapping(value = "/read.do")
	public String readArticleView(int boardNum, Model model) throws Exception {
		return "manager/board/detail";
	}

	// 게시판 목록조회 요청
	@RequestMapping(value = "/list.do")
	public String listArticleView(String notify, PageSearchCommand psCmd, Model model) throws Exception {
		// 이거빼고해요
		return "manager/board/list";
	}
}
