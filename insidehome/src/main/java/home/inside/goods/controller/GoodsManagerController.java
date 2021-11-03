package home.inside.goods.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.istack.internal.logging.Logger;

import home.inside.goods.service.IGoodsManagerService;
import home.inside.goods.vo.GoodsVo;

//세션이름: loginInside
//pointVo에 담아서 보내면 됨.
@Controller
@RequestMapping(value="/manager/goods/")
public class GoodsManagerController {
	@Autowired
	private IGoodsManagerService goodsMangerService;
	//@Autowired
	//private IPointService pointService;
	
	private Logger log = Logger.getLogger(GoodsManagerController.class);

	@RequestMapping(value="insertGoods.do", method = RequestMethod.GET)
	public String insertGoodsForm() throws Exception {
		return "manager/goods/insertForm";
	}
	
	@RequestMapping(value="insertGoods.do", method = RequestMethod.POST)
	public String insertGoodsSubmit(Model model, GoodsVo goodsVo, MultipartHttpServletRequest mpReq) throws Exception {
		goodsMangerService.insert(goodsVo, mpReq);
		return "redirect:/manager/goods/list.do";
	}
	
	
	@RequestMapping(value="updateGoods.do/{goodsCode}", method = RequestMethod.GET)
	public String updateGoodsForm(@PathVariable String goodsCode, Model model) throws Exception {
		Map<String, Object> hm = goodsMangerService.selectOne(goodsCode);
		GoodsVo goods = (GoodsVo) hm.get("goods");
		List<HashMap<String, String>> goodsImages = (List<HashMap<String, String>>)hm.get("goodsImages");
		model.addAttribute("goods", goods);	
		model.addAttribute("goodsImages", goodsImages);	
		return "manager/goods/updateForm";
	}
	
	@RequestMapping(value="updateGoods.do/{goodsCode}", method = RequestMethod.POST)
	public String updateGoodsSubmit(GoodsVo goodsVo, MultipartHttpServletRequest mpReq) throws Exception {
		goodsMangerService.update(goodsVo, mpReq);
		return "redirect:/manager/goods/list.do";
	}
	
	//상품관리 페이지
	@RequestMapping(value="list.do")
	public String editGoodsList(Model model) throws Exception {
		List<HashMap<String, Object>> goodsList = goodsMangerService.selectAll();
		model.addAttribute("goodsList", goodsList);
		return "manager/goods/list";
	}
	

	@RequestMapping(value="deleteGoods.do")
	public String deleteGoods(@RequestParam(value = "selectGoods") String[] selectGoods, RedirectAttributes rttr) throws Exception {
		for(int i=0; i<selectGoods.length; i++) {
			selectGoods[i] = selectGoods[i].split("&")[0];
		}
		goodsMangerService.deleteGoods(selectGoods);
		rttr.addFlashAttribute("deleteOk", "success");
		return "redirect:/manager/goods/list.do";
	}
	
	@RequestMapping(value="heartUpdate.do")
	public String heartUpdate(@RequestParam(value = "type") String type, @RequestParam(value = "selectGoods") String[] selectGoods, RedirectAttributes rttr) throws Exception {
		String heartFail = "fail";
		String chk = "";
		if(type.equals("recommand")) {
			chk = "yes";
		}else if(type.equals("cancle")) {
			chk ="no";
		}
		List<String> goodsCodes = new ArrayList<String>();
		for(String str : selectGoods) {
			String[] mod = str.split("&");
			goodsCodes.add(mod[0]);
			if(chk.equals(mod[1])) {
				rttr.addFlashAttribute("heartFail", heartFail);
				return "redirect:/manager/goods/list.do";
			}
		}
		goodsMangerService.updateHeart(type, goodsCodes);
		return "redirect:/manager/goods/list.do";
	}
	
	
}
