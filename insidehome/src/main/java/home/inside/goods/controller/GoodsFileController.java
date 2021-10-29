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

import home.inside.goods.service.IGoodsManagerService;

@Controller
public class GoodsFileController {
	@Autowired
	private IGoodsManagerService goodsManagerService;
	
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
		}
		
		return result;
	}

}
