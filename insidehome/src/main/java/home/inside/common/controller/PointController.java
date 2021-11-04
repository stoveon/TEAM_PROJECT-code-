package home.inside.common.controller;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import home.inside.common.service.IPointService;
import home.inside.common.vo.PointVo;

@Controller
public class PointController {
	@Autowired
	private IPointService pointSer;
	
	//출석페이지 요청
	@RequestMapping(value = "/inside/checkForm.do")
	public String checkList(Model model, HttpSession session) throws Exception {
		String nickname = (String) session.getAttribute("loginInside");
		if(nickname!=null) {
			model.addAttribute("checkList", pointSer.selectMonth(nickname));
		}else {
			model.addAttribute("checkList", Collections.emptyList());
		}
		return "user/main/checkIn";
	}
	
	//출석처리 요청
	@RequestMapping(value = "/user/inside/check.do")
	public String checkIn(HttpSession session, HttpServletRequest req) throws Exception {
		String nickname = (String) session.getAttribute("loginInside");
		if(nickname!=null && pointSer.selectCheck(nickname)<=0) {
			pointSer.insertPoint(nickname, "check", 300);
			req.setAttribute("check", "success");
		}else {
			req.setAttribute("check", "fail");
		}
		return "error/commonException";
	}

}
