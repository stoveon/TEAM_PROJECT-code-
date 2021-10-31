package home.inside.goods.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.istack.internal.logging.Logger;

import home.inside.goods.service.IGoodsManagerService;
import sun.misc.ProxyGenerator;

@Controller
public class GoodsFileController {
	@Autowired
	private IGoodsManagerService goodsManagerService;

	private static Logger logger = Logger.getLogger(GoodsFileController.class);
	
	//이미지 출력
	@ResponseBody
	@GetMapping("/display")
	public ResponseEntity<byte[]> displayFile(@RequestParam(value = "goodsCode") String goodsCode, @RequestParam(value = "saveName") String saveName) throws Exception{
		logger.info("disply File .....saveName={}");
		
		String path = "C:\\TeamProject\\UploadFile\\GOODS\\" + goodsCode + "\\" + saveName;
		
		File file = new File(path);
		if(!file.exists()) {
			try {
				goodsManagerService.deleteNotExistImage(goodsCode);
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
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return result;
	}

}
