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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.istack.internal.logging.Logger;

import home.inside.common.service.IPointService;
import home.inside.goods.service.IGoodsUserService;
import home.inside.goods.vo.GoodsSalesVo;
import home.inside.goods.vo.GoodsVo;
import home.inside.member.service.IMemberInfoService;
import home.inside.member.vo.MemberInfoDto;
import home.inside.member.vo.MemberSubVo;

//세션이름: loginInside
//pointVo에 담아서 보내면 됨.
@Controller
public class GoodsController {
	@Autowired
	private IGoodsUserService goodsUserService;
	@Autowired
	private IMemberInfoService infoSer;
	@Autowired
	private IPointService poSer;

	private Logger log = Logger.getLogger(GoodsController.class);

	@RequestMapping(value = "/goods/list.do")
	public String selectGoodsList(@RequestParam(name = "type", defaultValue = "dateDesc") String type, Model model,
			HttpSession session) throws Exception {
		List<HashMap<String, Object>> goodsList = goodsUserService.selectAll(type);
		model.addAttribute("type", type);
		model.addAttribute("goodsList", goodsList);
		return "user/goods/list";
	}

	@RequestMapping(value = "/goods/detail.do/{goodsCode}")
	public String selectGoodsDetail(@PathVariable String goodsCode, Model model) throws Exception {
		Map<String, Object> hm = goodsUserService.selectOne(goodsCode);
		GoodsVo goods = (GoodsVo) hm.get("goods");
		List<String> goodsImages = (List<String>) hm.get("goodsImages");
		model.addAttribute("goods", goods);
		model.addAttribute("goodsImages", goodsImages);
		return "user/goods/detail";
	}

	// 회원정보 확인 및 포인트관련 추가
	@RequestMapping(value = "/user/goods/order.do/{goodsCode}", method = RequestMethod.GET)
	public String orderGoodsForm(@PathVariable String goodsCode, Model model, HttpSession session, RedirectAttributes rttr ) throws Exception {
		String nickname = (String) session.getAttribute("loginInside");

		HashMap<String, Object> orderInfo = goodsUserService.orderGoodsInfo(goodsCode);
		HashMap<String, String> goodsImage = (HashMap<String, String>) orderInfo.get("goodsImage");
		GoodsVo goods = (GoodsVo) orderInfo.get("goods");
		MemberInfoDto userInfo = infoSer.selectInfo(nickname);
		String tmp = String.valueOf(infoSer.selectMyCount(nickname).get("POINT"));
		if(Integer.parseInt(tmp) < goods.getPrice()) {
			rttr.addFlashAttribute("orderRequest", "fail");
			return "redirect:/goods/list.do";
		}else {
			model.addAttribute("point", Integer.parseInt(tmp));
			model.addAttribute("userInfo", userInfo);
			model.addAttribute("goods", goods);
			model.addAttribute("goodsImage", goodsImage);
			model.addAttribute("resultPoint", Integer.parseInt(tmp)-goods.getPrice());
			return "user/goods/orderForm";
		}
	}

	// 상품 주문 시 포인트 변동 추가
	@RequestMapping(value = "/goods/order.do", method = RequestMethod.POST)
	public String orderGoodsSubmit(@RequestParam(value = "goodsCode") String goodsCode, @RequestParam(value = "goodsName")String goodsName,
			@RequestParam(value = "nickname") String nickname, @RequestParam(value = "price") int price)
			throws Exception {
		GoodsSalesVo goodsSalesVo = new GoodsSalesVo(goodsCode, nickname, price);
		goodsUserService.insertGoodsSales(goodsSalesVo);
		poSer.insertPoint(nickname, goodsName, (-1)*price);
		infoSer.updateMyCount(nickname, (-1)*price);
		return "redirect:/goods/list.do";
	}

	@RequestMapping(value = "/goods/orderPopup/order.do")
	public String orderPopup() throws Exception {
		return "user/goods/orderPopup";
	}

}
