package home.inside.common.controller;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import home.inside.common.service.IPointService;
import home.inside.member.service.IMemberInfoService;

@Controller
public class PointController {
	@Autowired
	private IPointService pointSer;
	@Autowired
	private IMemberInfoService infoSer;
	
	//출석처리 요청
	@RequestMapping(value = "/user/inside/check.do")
	public String checkIn(HttpSession session, HttpServletRequest req) throws Exception {
		String nickname = (String) session.getAttribute("loginInside");
		if(nickname!=null && pointSer.selectCheck(nickname)<=0) {
			pointSer.insertPoint(nickname, "check", 300);
			infoSer.updateMyCount(nickname, 300);
		}
		return "redirect:/user/mypage/main.do";
	}

}
