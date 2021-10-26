package home.inside.goods.controller;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import home.inside.goods.service.IGoodsService;
import home.inside.goods.vo.GoodsSalesVo;
import home.inside.goods.vo.GoodsVo;

//세션이름: loginInside
//pointVo에 담아서 보내면 됨.
@Controller
public class GoodsController {
	@Autowired
	private IGoodsService goodsService;
	//@Autowired
	//private IPointService pointService;

	@RequestMapping(value="/manager/goods/insertGoods.do", method = RequestMethod.GET)
	public String insertGoodsForm() throws Exception {
		System.out.println("insertGoodsForm.Get이당");
		return "manager/goods/insertForm";
	}
	
	@RequestMapping(value="/manager/goods/insertGoods.do", method = RequestMethod.POST)
	public String insertGoodsSubmit(Model model, GoodsVo goodsVo, MultipartHttpServletRequest mpReq) throws Exception {
		if(goodsVo.getGoodsName() == null || goodsVo.getContent() == null) {
			model.addAttribute("goodsVo", goodsVo);
			return "manager/goods/insertForm";
		}
		goodsService.insert(goodsVo, mpReq);
		
		return "manager/goods/list";
	}
	
	
	@RequestMapping(value="/manager/goods/updateGoods.do", method = RequestMethod.GET)
	public String updateGoodsForm(String goodsCodes, Model model) throws Exception {
		String type = "manager";
		Map<String, Object> hm = goodsService.selectOne(type, goodsCodes);
		GoodsVo goods = (GoodsVo) hm.get("goods");
		List<String> goodsImages = (List<String>) hm.get("goodsImages");
		model.addAttribute("goods", goods);	
		model.addAttribute("goodsImages", goodsImages);	
		return "manager/goods/updateForm";
	}
	
	@RequestMapping(value="/manager/goods/updateGoods.do", method = RequestMethod.POST)
	public String updateGoodsSubmit(GoodsVo goodsVo, MultipartHttpServletRequest mpReq) throws Exception {

		goodsService.update(goodsVo, mpReq);
		
		return "manager/goods/list";
	}
	
	//관리자
	//type = 삭제, 추천, 리스트인지에 따라 페이지 변경
	@RequestMapping(value="/manager/goods/list.do")
	public String editGoodsList(Model model) throws Exception {
		List<HashMap<String, Object>> goodsList = goodsService.selectAll();
		model.addAttribute("goodsList", goodsList);
		return "manager/goods/list";
	}
	
	//가격/등록일 내림차순/오름차순
	@RequestMapping(value="/goods/list.do")
	public String selectGoodsList(@RequestParam(name="type", defaultValue = "dateDesc") String type, Model model, HttpSession session) throws Exception {
		
		return "user/goods/list";
	}
	
	@RequestMapping(value="/goods/detail.do")
	public String selectGoodsDetail(String goodsCode, Model model) throws Exception {
		String type = "user";
		Map<String, Object> hm = goodsService.selectOne(type, goodsCode);
		GoodsVo goods = (GoodsVo) hm.get("goods");
		List<String> goodsImages = (List<String>) hm.get("goodsImages");

		URL fileUrl = new URL(goodsCode);
		
		model.addAttribute("goods", goods);
		model.addAttribute("goodsImages", goodsImages);
		return "user/goods/detail";
	}
	
	@RequestMapping(value="/goods/orderForm.do", method=RequestMethod.GET)
	public String orderGoodsForm(String goodsCode, Model model, HttpSession session) throws Exception {

		return "user/goods/orderForm";
	}
	
	@RequestMapping(value="/goods/orderForm.do", method = RequestMethod.POST)
	public String orderGoodsSubmit(GoodsSalesVo goodsSalesVo) throws Exception {
		return "";
	}
	
	@RequestMapping(value="/manager/goods/deleteGoods.do")
	public String deleteGoods(String[] selectGoods) throws Exception {
		goodsService.deleteGoods(selectGoods);
		return "manager/goods/list";
	}
	
	@RequestMapping(value="/manager/goods/heartUpdate.do")
	public String heartUpdate(String type, String[] selectGoods) throws Exception {
		goodsService.updateHeart(type, selectGoods);
		return "manager/goods/list";
	}

	
}
