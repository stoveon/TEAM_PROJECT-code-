package home.inside.board.controller;

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

import home.inside.board.service.IBoardService;

@Controller
public class BoardFileController {
	@Autowired
	private IBoardService ser;

	private static Logger logger = Logger.getLogger(BoardFileController.class);
	
	//이미지 출력
	@ResponseBody
	@GetMapping("/boardDis")
	public ResponseEntity<byte[]> displayFile(@RequestParam(value = "saveName") String saveName) throws Exception{
		String path = "C:"+File.separator+"TeamProject"+File.separator+"UploadFile"+File.separator+"BOARD"+File.separator+saveName;
		System.out.println(saveName);
		File file = new File(path);
		if(!file.exists()) {
			try {
				ser.deleteNotExistImage(saveName);
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
