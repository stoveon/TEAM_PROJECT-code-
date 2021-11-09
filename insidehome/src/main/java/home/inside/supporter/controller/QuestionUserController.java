package home.inside.supporter.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import home.inside.supporter.service.IQuestionService;

@Controller
public class QuestionUserController {
	@Autowired
	public IQuestionService ser;

	// 사용자 QA조회
	@RequestMapping(value = "/inside/question.do")
	public String selectQaList(Model model) throws Exception {
		List<HashMap<String, Object>> tmp = ser.questionList();
		model.addAttribute("qa", tmp);
		return "user/supporter/qaList";
	}

	// 회원 문의등록 폼
	@RequestMapping(value = "/user/ask/insertForm.do")
	public String askInsertForm() throws Exception {
		return "user/supporter/askInsertForm";
	}

	// 회원 문의 등록요청
	@RequestMapping(value = "/user/ask/insert.do", method = RequestMethod.POST)
	public String askInsert(@ModelAttribute(value = "title") String title,
			@ModelAttribute(value = "content") String content, HttpSession session) throws Exception {
		String nickname = (String) session.getAttribute("mgrInside");
		ser.insertQuestion("ask", nickname, title, content);
		return "redirect:/user/ask/list.do";
	}

	// 회원 문의목록조회(본인 문의글 목록)
	@RequestMapping(value = "/user/ask/list.do")
	public String myAskList(Model model, HttpSession session) throws Exception {
		String nickname = (String) session.getAttribute("loginInside");
		model.addAttribute("qa", ser.selectMyAsk(nickname));
		return "user/supporter/askList";
	}
}
