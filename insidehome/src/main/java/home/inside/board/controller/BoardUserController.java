package home.inside.board.controller;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import home.inside.board.service.IBoardService;
import home.inside.board.util.ArticleMgrCommand;
import home.inside.board.vo.BoardImageVo;
import home.inside.board.vo.BoardRefVo;
import home.inside.board.vo.BoardVo;
import home.inside.common.service.IPointService;
import home.inside.member.service.IMemberInfoService;

@Controller
@RequestMapping("/user/board")
public class BoardUserController {
	@Autowired
	private IBoardService ser;
	@Autowired
	private IMemberInfoService memSer;
	@Autowired
	private IPointService poSer;

	// 회원 글 작성 폼 요청
	@RequestMapping(value = "/registForm.do")
	public String registArticleForm(ArticleMgrCommand artCmd, Model model) throws Exception {
		model.addAttribute("artCmd", artCmd);
		return "user/board/registForm";
	}

	// 회원 글 작성 요청
	@RequestMapping(value = "/regist.do", method = RequestMethod.POST)
	public String registArticleSubmit(ArticleMgrCommand artCmd, MultipartHttpServletRequest mpReq, HttpSession session)
			throws Exception {
		String nickname = (String) session.getAttribute("loginInside");
		artCmd.setWriter(nickname);
		artCmd.setNotify("no");
		ser.insertBoard(artCmd, mpReq);
		poSer.insertPoint(nickname, "write", 50);
		memSer.updateMyCount(artCmd.getWriter(), 50);
		return "redirect:/board/list.do?boardCode=" + artCmd.getBoardCode();
	}

	// 회원 글 수정 폼 요청
	@RequestMapping(value = "/updateForm.do/{num}")
	public String updateArticleForm(@PathVariable(value = "num") int num, Model model, HttpSession session)
			throws Exception {
		BoardVo board = ser.readBoard(num);
		String nickname = (String) session.getAttribute("loginInside");
		if (nickname != null && !nickname.equals(board.getWriter())) {
			return "redirect:/board/list.do";
		}
		if (num == 0) {
			return "redirect:/board/list.do";
		}
		List<BoardImageVo> boardImages = ser.selectListImage(num);
		for (BoardImageVo v : boardImages) {
			System.out.println(v.toString());
		}
		board.setWriter("123456");
		model.addAttribute("board", board);
		model.addAttribute("boardImages", boardImages);
		return "user/board/updateForm";
	}

	// 회원 글 수정 요청
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String updateArticleSubmit(ArticleMgrCommand artCmd, MultipartHttpServletRequest mpReq,
			RedirectAttributes rttr) throws Exception {
		/*
		 * artCmd에 null 이 있으면 안됨 null 이 있으면 수정 거절하고 글 수정폼으로 리턴 artCmd 에 null이 없으면 글 수정
		 * 요청 후 상세페이지 redirect
		 */
		ser.updateBoard(artCmd, mpReq);
		rttr.addAttribute("boardNum", artCmd.getNum());
		return "redirect:/user/board/read.do";
	}

	// 회원 글 삭제요청
	@RequestMapping(value = "/delete.do/{num}")
	public String deleteArticleSubmit(@PathVariable(value = "num") int num, HttpSession session,
			RedirectAttributes rttr) throws Exception {
		/* 현재 로그인한 사용자와 글작성자가 일치하는지 확인 */
		String nickname = (String) session.getAttribute("loginInside");
		BoardVo board = ser.readBoard(num);
		if (nickname.equals(board.getWriter())) {
			ser.deleteBoard(num, "no");
		}
		rttr.addAttribute("boardCode", board.getBoardCode());
		return "redirect:/board/list.do";
	}

	// 게시글 상세페이지 요청
	@RequestMapping(value = "/read.do")
	public String readArticleSubmit(int boardNum, String read, Model model, HttpSession session, String boardName)
			throws Exception {
		if (read == null) {
			ser.updateHit(boardNum);
		}
		BoardVo board = ser.readBoard(boardNum);
		if (board == null) {
			return "redirect:/inside/main.do";
		}
		List<BoardImageVo> boardImages = ser.selectListImage(boardNum);
		List<BoardRefVo> boardRefs = ser.selectListRef(boardNum);
		model.addAttribute("board", board);
		model.addAttribute("boardImages", boardImages);
		if (boardRefs.size() != 0) {
			model.addAttribute("boardRefs", boardRefs);
		}
		model.addAttribute("userName", (String) session.getAttribute("loginInside"));
		model.addAttribute("boardName", boardName);
		return "user/board/detail";
	}

	// 게시글 추천요청
	@RequestMapping(value = "/updateHeart.do/{num}")
	public String updateHeartSubmit(@PathVariable(value = "num") int num, HttpSession session, RedirectAttributes rttr) throws Exception {
		rttr.addAttribute("boardNum", num);
		rttr.addAttribute("read", "noHit");
		ser.updateHeart(num);
		rttr.addFlashAttribute("boardName", "heart");
		return "redirect:/user/board/read.do";
	}
}
