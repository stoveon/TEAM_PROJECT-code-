package home.inside.common.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import home.inside.goods.service.IGoodsManagerService;
import home.inside.goods.service.IGoodsUserService;

@Controller
public class MainController {
	@Autowired
	private IGoodsUserService goodsUserService;
	@Autowired
	private IGoodsManagerService goodsManagerService;

	@RequestMapping("/mgr/error.do")
	public String mgrErrView() throws Exception {
		return "error/managerException";
	}

	@RequestMapping("/")
	public String mainView() throws Exception {
		return "redirect:/inside/main.do";
	}

	@RequestMapping("/manager")
	public String mgrMainView() throws Exception {
		return "redirect:/manager/inside/main.do";
	}

	@RequestMapping("/manager/inside/main.do")
	public String mgrMainView(Model model) throws Exception {
		List<HashMap<String, Object>> orderList = goodsManagerService.orderAll();
		model.addAttribute("orderList", orderList);
		return "manager/main/main";
	}

	@RequestMapping("/inside/main.do")
	public String userView(Model model) throws Exception {
		HashMap<String, Object> hm = goodsUserService.selectMain();
		List<HashMap<String, String>> mainHeart = (List<HashMap<String, String>>) hm.get("mainHeart");
		List<HashMap<String, String>> mainLatest = (List<HashMap<String, String>>) hm.get("mainLatest");
		model.addAttribute("mainHeart", mainHeart);
		model.addAttribute("mainLatest", mainLatest);
		return "user/main/main";
	}

	@RequestMapping(value = "/info/identify.do")
	public String identify() throws Exception {
		return "user/member/mypage/identify";
	}

	@RequestMapping(value = "/manager/main/order.do")
	public String order(@RequestParam(value = "state") String state, @RequestParam(value = "num") int num)
			throws Exception {
		goodsManagerService.updateSales(state, num);
		return "redirect:/manager/inside/main.do";
	}

	@RequestMapping("/inside/intro.do")
	public String intro() throws Exception {
		return "user/main/intro";
	}
	
	@RequestMapping(value = "/inside/map.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String map() throws Exception {
		return "user/main/insideMap";
	}
}