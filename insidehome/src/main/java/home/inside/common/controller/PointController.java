package home.inside.common.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import home.inside.common.service.IPointService;
import home.inside.common.vo.PointVo;

@Controller
public class PointController {
	@Autowired
	private IPointService pointService;
	
	//출석
	@RequestMapping(value = "/inside/check.do")
	public String checkIn(String nickname, Date changeDate, HttpServletRequest req) throws Exception {
		if(nickname!=null && pointService.selectCheck(nickname)<=0) {
			PointVo vo = new PointVo();
			vo.setNickname(nickname);
			vo.setChangePoint(300);
			vo.setChangeWhy("checkIn");
			pointService.insertPoint(vo);
			req.setAttribute("check", "success");
		}
		req.setAttribute("check", "fail");
		return "error/commonException";
	}
	
	
	//출석페이지
	@RequestMapping(value = "/inside/checkin.do")
	public String checkList(String nickname, Integer month, Model model) throws Exception {
		System.out.println("month: "+month);
		if(nickname!=null) {
			month=(month==null)?0:month;
			model.addAttribute("checkList", pointService.selectMonth(nickname, month));
		}
		return "user/main/checkIn";
	}
	
	
	@RequestMapping("/main.do")
	public String view() {
		return "user/main/main";
	}
	
	@RequestMapping("/user/main.do")
	public String view2() {
		return "manager/main/main";
	}

	@RequestMapping("/manager/main.do")
	public String view3() {
		return "error/commonException";
	}

}
