package home.inside.common.util;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component
public class FileUtils {
	
	//저장경로
	private String path = "C:"+File.separator+"TeamProject"+File.separator+"UploadFile"+File.separator;
	
	public Map<String, Object> goodsFileUpload(String goodsCode, MultipartHttpServletRequest mpReq) {

		String filePath = path+"GOODS"+File.separator+goodsCode;
		
		List<MultipartFile> fileList = mpReq.getFiles("saveGoodsImage");
		List<String> saveNames = new ArrayList<String>();
		String name = "";
		File folder = new File(filePath);
		if(!(folder.exists())) {
			folder.mkdirs();
		}
		
		for(MultipartFile mf : fileList) {
			String tmpName =  goodsCode + "_" + mf.getOriginalFilename();
			try {
				File file = new File(filePath + File.separator + tmpName);
				file = rename(file);
				mf.transferTo(file);
				tmpName = file.getName();
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
			if(!(name.equals(goodsCode + "_"))) {
				saveNames.add(tmpName);
			}
		}
		
		//파일이 잘못생겼을 경우 지우기 위한 처리
		File noFile = new File(filePath + File.separator + goodsCode + "_");
		if(noFile.exists()) {
			noFile.delete();
		}
		
		Map<String, Object> hm = new HashMap<String, Object>();
		hm.put("goodsCode", goodsCode);
		hm.put("saveNames", saveNames);
		
		return hm;
	}
	
	//상품 수정에서 이미지 추가
	public List<String> goodsFileEdit(String goodsCode, MultipartHttpServletRequest mpReq) {
		
		String filePath = path + "GOODS"+File.separator+ goodsCode;
		
		File folder = new File(filePath);
		if(!(folder.exists())) {
			folder.mkdirs();
		}
		
		List<MultipartFile> fileList = mpReq.getFiles("plusGoodsImage");
		List<String> saveNames = new ArrayList<String>();
		
		for(MultipartFile mf : fileList) {
			String tmpName = goodsCode + "_" + mf.getOriginalFilename();			
			try {
				File file = new File(filePath + File.separator + tmpName);
				file = rename(file);
				mf.transferTo(file);
				tmpName = file.getName();
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(!(tmpName.equals(goodsCode + "_"))) {
				saveNames.add(tmpName);
			}
		}
		
		//파일이 잘못생겼을 경우 지우기 위한 처리
		File noFile = new File(filePath + File.separator + goodsCode + "_");
		if(noFile.exists()) {
			noFile.delete();
		}
		
		return saveNames;
	}
	
	//상품 수정에서 이미지 삭제
	public void goodsFileDelete(String goodsCode, MultipartHttpServletRequest mpReq) {
		String[] fileName = mpReq.getParameterValues("deleteGoodsImage");
		String filePath = path + "GOODS" + File.separator + goodsCode + File.separator;
		for(String str : fileName) {
			File delFile = new File(filePath + goodsCode + "_" + str);
			if(delFile.exists()) {
				delFile.delete();
			}
		}
		
	}
	
	//상품 삭제
	public void goodsDelete(String goodsCode) {
		File delFile = new File(path + "GOODS"+ File.separator + goodsCode);
		if(delFile.exists()) {
			delFile.delete();
		}
	}
	
	public Map<String, Object> boardFileUpload(int boardNum, MultipartHttpServletRequest mpReq) {
		String filaPath = path + "BOARD" + File.separator + boardNum + File.separator;
		Map<String, Object> saveFile = new HashMap<String, Object>();
		
		File folder = new File(filaPath);
		if(!folder.exists()) {
			folder.mkdirs();
		}
		
		String uuid = UUID.randomUUID().toString();
		
		List<MultipartFile> fileList = mpReq.getFiles("saveBoardImage");
		for(MultipartFile mf : fileList) {
			String originName = mf.getOriginalFilename();
			String extension = FilenameUtils.getExtension(originName);
			String tmpName =  uuid + "_" + originName;
			
			File file = new File(filaPath + File.separator + tmpName);	
			
			if(file.exists()) {
				uuid = UUID.randomUUID().toString();
				tmpName = uuid + File.separator + mf.getOriginalFilename();
			}
				
			try {
				mf.transferTo(file);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			saveFile.put("originName", originName);
			saveFile.put("saveName", tmpName);
			saveFile.put("fileType", extension);
			}

		return saveFile;
	}
	
	public void boardDelete(int boardNum) {
		File delFile = new File(path + "BOARD"+ File.separator + boardNum);
		if(delFile.exists()) {
			delFile.delete();
		}
	}

	public File rename(File f) throws IOException {
		int plusSeq = 1;
		while(!f.exists()) {
			String fileName = f.getCanonicalPath();
			int extensionIdx = fileName.lastIndexOf(".");
			String _fileName = fileName.substring(0, extensionIdx);						//확장자 제외 파일 이름
			String extension = fileName.substring(extensionIdx, fileName.length());		//확장자명
			String newName = _fileName + "(" + plusSeq++ + ")"+ extension;
			f = new File(newName);
		}
		return f;
	}	
}

