package home.inside.common.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import home.inside.common.service.IPointService;

@Controller
public class PointController {
	@Autowired
	private IPointService pointService;
	
	public int checkIn(String nickname, Date changeDate) throws Exception {
		return 0;
	}
}
