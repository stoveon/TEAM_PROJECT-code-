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
	
	@RequestMapping(value="/inside/main.do", method = RequestMethod.GET)
	public String main(GoodsSalesVo goodsSalesVo, Model model) throws Exception {
		
		return "user/main/list";
	}
	
	@RequestMapping(value="/inside/main.do", method = RequestMethod.POST)
	public String main2(GoodsSalesVo goodsSalesVo, Model model) throws Exception {
		
		return "redirect:user/main/list";
	}
	
	@RequestMapping(value="/goods/list.do")
	public String selectGoodsList(@RequestParam(name="type", defaultValue = "dateDesc") String type, Model model, HttpSession session) throws Exception {
		List<HashMap<String, Object>> goodsList = goodsService.selectAll(type);
		model.addAttribute("type", type);
		model.addAttribute("goodsList", goodsList);
		return "user/goods/list";
	}
	
	@RequestMapping(value="/goods/detail.do/{goodsCode}")
	public String selectGoodsDetail(@PathVariable String goodsCode, Model model) throws Exception {
		String type = "user";
		Map<String, Object> hm = goodsService.selectOne(type, goodsCode);
		GoodsVo goods = (GoodsVo) hm.get("goods");
		List<String> goodsImages = (List<String>) hm.get("goodsImages");
		
		model.addAttribute("goods", goods);
		model.addAttribute("goodsImages", goodsImages);
		return "user/goods/detail";
	}
	
	@RequestMapping(value="/goods/orderForm.do", method=RequestMethod.GET)
	public String orderGoodsForm(String goodsCode, Model model, HttpSession session) throws Exception {
		if(!(session.getId().equals("loginInside"))) {
			return "redirect:inside/main.do";
		}
		String memberNickname = (String) session.getAttribute("loginInside");
		model.addAttribute("memberNickname", memberNickname);
		return "user/goods/orderForm";
	}
	
	@RequestMapping(value="/goods/orderForm.do", method = RequestMethod.POST)
	public String orderGoodsSubmit(GoodsSalesVo goodsSalesVo) throws Exception {
		return "redirect:/goods/list";
	}
	
	//이미지 출력
	@GetMapping("/display")
	public ResponseEntity<byte[]> getImage(@RequestParam(value = "goodsCode") String goodsCode, @RequestParam(value = "saveName") String saveName){
		String path = "C:\\TeamProject\\UploadFile\\GOODS\\";
		if(saveName != null) {
			path += goodsCode + "\\" + saveName;
		}else if(saveName == null){
			path += "noimage.gif";
		}
		System.out.println("display: "+path);
		
		File file = new File(path);
		if(!file.exists()) {
			try {
				goodsService.deleteNotExistImage(goodsCode);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ResponseEntity<byte[]> result = null;
		
		try {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	
}
