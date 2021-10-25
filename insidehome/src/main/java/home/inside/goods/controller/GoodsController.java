package home.inside.goods.controller;

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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import home.inside.common.service.IPointService;
import home.inside.common.util.FileUtils;
import home.inside.goods.service.IGoodsService;
import home.inside.goods.vo.GoodsImageVo;
import home.inside.goods.vo.GoodsSalesVo;
import home.inside.goods.vo.GoodsVo;

//세션이름: loginInside
//pointVo에 담아서 보내면 됨.
@Controller
public class GoodsController {
	@Autowired
	private IGoodsService goodsService;
	@Autowired
	private IPointService pointService;
	@Autowired
	private FileUtils util;
	
	@RequestMapping(value="manager/goods/insertGoods.do", method = RequestMethod.GET)
	public String insertGoodsForm() throws Exception {
		
		return "manager/goods/insertForm";
	}
	
	@RequestMapping(value="manager/goods/insertGoods.do", method = RequestMethod.POST)
	public String insertGoodsSubmit(GoodsVo goodsVo, MultipartHttpServletRequest mpReq) throws Exception {
		Map<String, Object> hm = util.goodsFileUpload(mpReq);
		goodsVo.setGoodsCode((String) hm.get("goodsCode"));
		List<String> imageList = (List<String>) hm.get("saveNames");
		goodsService.insert(goodsVo, imageList);
		
		return "manager/goods/list";
	}
	
	
	@RequestMapping(value="manager/goods/updateGoods.do", method = RequestMethod.GET)
	public String updateGoodsForm(String goodsCodes, Model model) throws Exception {
		Map<String, Object> hm = goodsService.selectOne(goodsCodes);
		GoodsVo goods = (GoodsVo) hm.get("goods");
		List<String> goodsImages = (List<String>) hm.get("goodsImages");
		model.addAttribute("goods", goods);	
		model.addAttribute("goodsImages", goodsImages);	
		return "manager/goods/updateForm";
	}
	
	@RequestMapping(value="manager/goods/updateGoods.do", method = RequestMethod.POST)
	public String updateGoodsSubmit(GoodsVo goodsVo, MultipartHttpServletRequest mpReq) throws Exception {
		
		return "manager/goods/list";
	}
	
	//관리자
	@RequestMapping(value="manager/goods/list.do")
	public String editGoodsList(String type, Model model, String[] goodsCodes) throws Exception {
		
		return "";
	}
	
	//가격/등록일 내림차순/오름차순
	@RequestMapping(value="")
	public String selectGoodsList(@RequestParam(name="type", defaultValue = "dateDesc") String type, Model model, HttpSession session) throws Exception {
		
		return "";
	}
	
	@RequestMapping(value="")
	public String selectGoodsDetail(String goodsCode, Model model) throws Exception {
		
		return "";
	}
	
	@RequestMapping(value="")
	public String orderGoodsForm(String goodsCode, Model model, HttpSession session) throws Exception {
		
		return "";
	}
	
	@RequestMapping(value="")
	public String orderGoodsSubmit(GoodsSalesVo goodsSalesVo) throws Exception {
		return null;
	}
}
