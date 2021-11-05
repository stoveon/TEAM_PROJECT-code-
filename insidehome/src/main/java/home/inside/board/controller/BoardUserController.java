package home.inside.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import home.inside.board.service.IBoardService;
import home.inside.board.util.ArticleMgrCommand;
import home.inside.board.vo.BoardImageVo;
import home.inside.board.vo.BoardVo;
import home.inside.member.service.IMemberInfoService;

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
		model.addAttribute("artCmd", artCmd);
		return "user/board/registForm";
	}

	// 회원 글 작성 요청
	@RequestMapping(value = "/regist.do", method = RequestMethod.POST)
	public String registArticleSubmit(ArticleMgrCommand artCmd, MultipartHttpServletRequest mpReq) throws Exception {
		ser.insertBoard(artCmd, mpReq);
		return "redirect:/board/list.do";
	}

	// 회원 글 수정 폼 요청
	@RequestMapping(value = "/updateForm.do/{num}")
	public String updateArticleForm(@PathVariable(value="num")int num, Model model, HttpSession session) throws Exception {
		/* 세션에서 닉네임 가져와 게시글작성자와 현재 로그인한 사용자가 일치하는지 확인
		 * 일치하지 않으면 list 로 redirect
		 * 일치하면 게시글 정보 담아서 글수정페이지로*/
		BoardVo board = ser.readBoard(num);
//		String nickname = (String) session.getAttribute("loginInside");
//		if(!(nickname.equals(board.getWriter()))) {
//			return "redirect:/board/list.do";			
//		}
		List<BoardImageVo> boardImages = ser.selectListImage(num);
		for(BoardImageVo v : boardImages) {
			System.out.println(v.toString());
		}
		model.addAttribute("board", board);
		model.addAttribute("boardImages", boardImages);
		return "user/board/updateForm";
	}

	// 회원 글 수정 요청
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String updateArticleSubmit(ArticleMgrCommand artCmd, MultipartHttpServletRequest mpReq) throws Exception {
		/* artCmd에 null 이 있으면 안됨 
		 * null 이 있으면 수정 거절하고 글 수정폼으로 리턴
		 * artCmd 에 null이 없으면 글 수정 요청 후 상세페이지 redirect */
		if(artCmd.getBoardCode() == null || artCmd.getNum() == 0 || artCmd.getWriter() == null) {
			return "redirect:/user/board/read.do";			
		}
		System.out.println("up post");
		ser.updateBoard(artCmd, mpReq);
		return "redirect:/user/board/read.do";
	}

	// 회원 글 삭제요청
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String deleteArticleSubmit(int boardNum, HttpSession session) throws Exception {
		/* 현재 로그인한 사용자와 글작성자가 일치하는지 확인 */
		String nickname = (String) session.getAttribute("loginInside");
		BoardVo board = ser.readBoard(boardNum);
		if(nickname.equals(board.getWriter())) {
			ser.deleteBoard(boardNum);
		}
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
	public String updateHitSubmit(int boardNum, HttpSession session , RedirectAttributes rttr) throws Exception { 
		BoardVo board = ser.readBoard(boardNum);
		return "redirect:/user/board/read.do";
	}
}
