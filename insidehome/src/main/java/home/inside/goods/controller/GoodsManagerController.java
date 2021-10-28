package home.inside.goods.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import home.inside.goods.service.IGoodsService;
import home.inside.goods.vo.GoodsSalesVo;
import home.inside.goods.vo.GoodsVo;

//세션이름: loginInside
//pointVo에 담아서 보내면 됨.
@Controller
@RequestMapping(value="/manager/")
public class GoodsManagerController {
	@Autowired
	private IGoodsService goodsService;
	//@Autowired
	//private IPointService pointService;

	@RequestMapping(value="goods/insertGoods.do", method = RequestMethod.GET)
	public String insertGoodsForm() throws Exception {
		return "manager/goods/insertForm";
	}
	
	@RequestMapping(value="goods/insertGoods.do", method = RequestMethod.POST)
	public String insertGoodsSubmit(Model model, GoodsVo goodsVo, MultipartHttpServletRequest mpReq) throws Exception {
		if(goodsVo.getGoodsName() == null || goodsVo.getContent() == null) {
			model.addAttribute("goodsVo", goodsVo);
			return "manager/goods/insertForm";
		}
		goodsService.insert(goodsVo, mpReq);
		return "redirect:/manager/goods/list.do";
	}
	
	
	@RequestMapping(value="goods/updateGoods.do/{goodsCode}", method = RequestMethod.GET)
	public String updateGoodsForm(@PathVariable String goodsCode, Model model) throws Exception {
		String type = "manager";
		Map<String, Object> hm = goodsService.selectOne(type, goodsCode);
		GoodsVo goods = (GoodsVo) hm.get("goods");
		List<String> goodsImages = (List<String>) hm.get("goodsImages");
		model.addAttribute("goods", goods);	
		model.addAttribute("goodsImages", goodsImages);	
		return "manager/goods/updateForm";
	}
	
	@RequestMapping(value="goods/updateGoods.do/{goodsCode}", method = RequestMethod.POST)
	public String updateGoodsSubmit(GoodsVo goodsVo, MultipartHttpServletRequest mpReq) throws Exception {
		goodsService.update(goodsVo, mpReq);
		return "redirect:/manager/goods/list.do";
	}
	
	//상품관리 페이지
	@RequestMapping(value="goods/list.do")
	public String editGoodsList(Model model) throws Exception {
		List<HashMap<String, Object>> goodsList = goodsService.selectAll();
		model.addAttribute("goodsList", goodsList);
		return "manager/goods/list";
	}
	

	@RequestMapping(value="goods/deleteGoods.do")
	public String deleteGoods(@RequestParam(value = "selectGoods") String[] selectGoods) throws Exception {
		goodsService.deleteGoods(selectGoods);
		return "redirect:/manager/goods/list.do";
	}
	
	@RequestMapping(value="goods/heartUpdate.do")
	public String heartUpdate(@RequestParam(value = "type") String type, @RequestParam(value = "selectGoods") String[] selectGoods) throws Exception {
		goodsService.updateHeart(type, selectGoods);
		return "redirect:/manager/goods/list.do";
	}
	
	@RequestMapping(value="main.do")
	public String main(Model model) throws Exception {
		List<HashMap<String, Object>> orderList = goodsService.orderAll();
		model.addAttribute("orderList", orderList);
		return "manager/main/list";
	}
	
	@RequestMapping(value="goods/order.do")
	public String order(@RequestParam(value = "state") String state, @RequestParam(value = "goodsCode") String goodsCode, RedirectAttributes rttr) throws Exception {
		System.out.println(state + " . " + goodsCode);
		goodsService.updateSales(state, goodsCode);
		rttr.addFlashAttribute("sendChange", "success");
		return "redirect:/manager/main.do";
	}
	
}
