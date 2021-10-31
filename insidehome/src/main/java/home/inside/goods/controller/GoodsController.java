package home.inside.goods.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.istack.internal.logging.Logger;

import home.inside.goods.service.IGoodsManagerService;
import home.inside.goods.service.IGoodsUserService;
import home.inside.goods.vo.GoodsSalesVo;
import home.inside.goods.vo.GoodsVo;

//세션이름: loginInside
//pointVo에 담아서 보내면 됨.
@Controller
@RequestMapping(value = "/goods/")
public class GoodsController {
	@Autowired
	private IGoodsUserService goodsUserService;
	@Autowired
	private IGoodsManagerService goodsManagerService;
	//@Autowired
	//private IPointService pointService;
	
	private Logger log = Logger.getLogger(GoodsController.class);
	
	@RequestMapping(value="list.do")
	public String selectGoodsList(@RequestParam(name="type", defaultValue = "dateDesc") String type, Model model, HttpSession session) throws Exception {
		List<HashMap<String, Object>> goodsList = goodsUserService.selectAll(type);
		model.addAttribute("type", type);
		model.addAttribute("goodsList", goodsList);
		return "user/goods/list";
	}
	
	@RequestMapping(value="detail.do/{goodsCode}")
	public String selectGoodsDetail(@PathVariable String goodsCode, Model model) throws Exception {
		Map<String, Object> hm = goodsUserService.selectOne(goodsCode);
		GoodsVo goods = (GoodsVo) hm.get("goods");
		List<String> goodsImages = (List<String>) hm.get("goodsImages");
		model.addAttribute("goods", goods);
		model.addAttribute("goodsImages", goodsImages);
		return "user/goods/detail";
	}
	
	@RequestMapping(value="order.do/{goodsCode}", method=RequestMethod.GET)
	public String orderGoodsForm(@PathVariable String goodsCode, Model model, HttpSession session) throws Exception {
//		if(!(session.getId().equals("loginInside"))) {
//			return "redirect:inside/main.do";
//		}
//		String memberNickname = (String) session.getAttribute("loginInside");
//		model.addAttribute("memberNickname", memberNickname);
		HashMap<String, Object> orderInfo = goodsUserService.orderGoodsInfo(goodsCode);
		GoodsVo goods = (GoodsVo) orderInfo.get("goods");
		HashMap<String, String> goodsImage = (HashMap<String, String>) orderInfo.get("goodsImage");
		model.addAttribute("goods", goods);
		model.addAttribute("goodsImage", goodsImage);
		return "user/goods/orderForm";
	}
	
	@RequestMapping(value="order.do", method = RequestMethod.POST)
	public String orderGoodsSubmit(@RequestParam(value = "goodsCode") String goodsCode,@RequestParam(value = "nickname") String nickname,@RequestParam(value = "price") int price) throws Exception {
		GoodsSalesVo goodsSalesVo = new GoodsSalesVo(goodsCode, nickname, price);
		goodsUserService.insertGoodsSales(goodsSalesVo);
		return "redirect:/goods/list.do";
	}
	
}
