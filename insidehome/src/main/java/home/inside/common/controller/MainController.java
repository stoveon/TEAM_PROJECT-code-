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
   
   @RequestMapping("inside/main.do/{goodsCode}")
   public String userView(@PathVariable(value = "goodsCode") String goodsCode) throws Exception{
	   
      return "user/main/main";
   }
   
	@RequestMapping(value="manager/main/order.do")
	public String order(@RequestParam(value = "state") String state, @RequestParam(value = "goodsCode") String goodsCode, RedirectAttributes rttr) throws Exception {
		goodsManagerService.updateSales(state, goodsCode);
		rttr.addFlashAttribute("sendChange", "success");
		return "redirect:/manager/main.do";
	}
}