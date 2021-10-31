package home.inside.common.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import home.inside.goods.service.IGoodsManagerService;
import home.inside.goods.service.IGoodsUserService;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	private IGoodsUserService goodsUserService;
	@Autowired
	private IGoodsManagerService goodsManagerService;
	
   @RequestMapping("mgr/error.do")
   public String mgrErrView() throws Exception{
      return "error/managerException";
   }
   
   @RequestMapping("manager/inside/main.do")
   public String mgrMainView(Model model) throws Exception{
		List<HashMap<String, Object>> orderList = goodsManagerService.orderAll();
		model.addAttribute("orderList", orderList);
      return "manager/main/main";
   }
   
   @RequestMapping("inside/main.do")
   public String userView(Model model) throws Exception{
	   HashMap<String, Object> hm = goodsUserService.selectMain();
	   List<HashMap<String, String>> mainHeart = (List<HashMap<String, String>>) hm.get("mainHeart");
	   List<HashMap<String, String>> mainLatest = (List<HashMap<String, String>>) hm.get("mainLatest");
	   model.addAttribute("mainHeart", mainHeart);
	   model.addAttribute("mainLatest", mainLatest);
      return "user/main/main";
   }
   
	@RequestMapping(value="manager/main/order.do")
	public String order(String state, @RequestParam(value = "goodsCode") String goodsCode) throws Exception {
		System.out.println(state);
		goodsManagerService.updateSales(state, goodsCode);
		return "redirect:/manager/inside/main.do";
	}
}