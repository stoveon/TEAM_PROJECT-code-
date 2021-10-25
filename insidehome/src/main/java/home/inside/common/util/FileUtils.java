package home.inside.common.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class FileUtils {
	
	//저장경로
	private String path = "C:\\TeamProject\\UploadFile\\";
	
	private RandomString rs = new RandomString(8);
	
	public Map<String, Object> goodsFileUpload(MultipartHttpServletRequest mpReq) {
		String goodsCode = rs.nextString();
		String filePath = path + "GOODS\\" + goodsCode;
		
		List<MultipartFile> fileList = mpReq.getFiles("saveGoodsImages");
		List<String> saveNames = new ArrayList<String>();
		
		File folder = new File(filePath);
		if(!(folder.exists())) {
			folder.mkdirs();
		}
		
		for(MultipartFile mf : fileList) {
			String tmpName =  goodsCode + "_" + mf.getOriginalFilename();
			
			try {
				mf.transferTo(new File(filePath + "\\" + tmpName));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
			saveNames.add(tmpName);
		}
		
		Map<String, Object> hm = new HashMap<String, Object>();
		hm.put("goodsCode", goodsCode);
		hm.put("saveNames", saveNames);
		
		return hm;
	}
	
	//상품 이미지 수정
	public List<String> goodsFileEdit(String goodsCode, MultipartHttpServletRequest mpReq) {
		
		String filePath = path + "GOODS\\" + goodsCode;
		List<MultipartFile> fileList = mpReq.getFiles("plusGoodsImages");
		List<String> saveNames = new ArrayList<String>();
		
		for(MultipartFile mf : fileList) {
			String tmpName = goodsCode + "_" + mf.getOriginalFilename();
			
			try {
				mf.transferTo(new File(filePath + "\\" + tmpName));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			saveNames.add(tmpName);
		}
		
		return saveNames;
	}
}
