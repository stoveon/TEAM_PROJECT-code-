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
import home.inside.board.vo.BoardVo;

@Controller
@RequestMapping("/user/board")
public class BoardUserController {
	@Autowired
	private IBoardService ser;

	// 회원 글 작성 폼 요청
	@RequestMapping(value = "/registForm.do")
	public String registArticleForm(ArticleMgrCommand artCmd, Model model, HttpSession session) throws Exception {
		String nickname = (String) session.getAttribute("loginInside");
		artCmd.setWriter(nickname);
		artCmd.setNotify("no");
		return "user/board/registForm";
	}

	// 회원 글 작성 요청
	@RequestMapping(value = "/regist.do", method = RequestMethod.POST)
	public String registArticleSubmit(ArticleMgrCommand artCmd, MultipartHttpServletRequest mpReq) throws Exception {
		/* artCmd 에 num을 제외하고는 null 이면 안됨
		 * null 이면 작성거절하고 글작성폼으로 리턴
		 * artCmd에 num을 제외하고 null이 없으면 글 작성요청 후 목록 redirect */
		ser.insertBoard(artCmd, mpReq);
		return "redirect:/board/list.do";
	}

	// 회원 글 수정 폼 요청
	@RequestMapping(value = "/updateForm.do")
	public String updateArticleForm(int num, Model model, HttpSession session) throws Exception {
		/* 세션에서 닉네임 가져와 게시글작성자와 현재 로그인한 사용자가 일치하는지 확인
		 * 일치하지 않으면 list 로 redirect
		 * 일치하면 게시글 정보 담아서 글수정페이지로*/
		BoardVo board = ser.readBoard(num);
		model.addAttribute("board", board);
		return "redirect:/board/list.do";
	}

	// 회원 글 수정 요청
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String updateArticleSubmit(ArticleMgrCommand artCmd, HttpSession session) throws Exception {
		/* artCmd에 null 이 있으면 안됨 
		 * null 이 있으면 수정 거절하고 글 수정폼으로 리턴
		 * artCmd 에 null이 없으면 글 수정 요청 후 상세페이지 redirect */
		return "redirect:/user/board/read.do";
	}

	// 회원 글 삭제요청
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String deleteArticleSubmit(int boardNum) throws Exception {
		/* 현재 로그인한 사용자와 글작성자가 일치하는지 확인 */
		return "redirect:/board/list.do";
	}

	// 게시글 상세페이지 요청
	@RequestMapping(value = "/read.do")
	public String readArticleSubmit(int boardNum, Model model) throws Exception {
		/* 게시글 내용
		 * 게시글 이미지목록
		 * 게시글 댓글목록  첨부*/
		return "user/board/detail";
	}

	// 게시글 추천요청
	@RequestMapping(value = "/updateHit.do", method = RequestMethod.POST)
	public String updateHitSubmit(int boardNum) throws Exception { 
		return "redirect:/user/board/read.do";
	}
}
