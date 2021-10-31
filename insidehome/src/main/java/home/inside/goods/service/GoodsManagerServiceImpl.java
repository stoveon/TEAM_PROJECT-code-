package home.inside.goods.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import home.inside.common.util.FileUtils;
import home.inside.goods.repository.IGoodsDao;
import home.inside.goods.repository.IGoodsImageDao;
import home.inside.goods.repository.IGoodsSalesDao;
import home.inside.goods.vo.GoodsImageVo;
import home.inside.goods.vo.GoodsVo;

@Service
public class GoodsManagerServiceImpl implements IGoodsManagerService {
	@Autowired
	private IGoodsDao goodsDao;
	@Autowired
	private IGoodsImageDao goodsImageDao;
	@Autowired
	private IGoodsSalesDao goodsSalesDao;
	@Autowired
	private FileUtils util;
	//상품 코드 뽑기
	private RandomStrService rs = new RandomStrService(8);
		
	@Override
	public void insert(GoodsVo goodsVo, MultipartHttpServletRequest mpReq) throws Exception {
		String goodsCode = rs.nextString();		
		int check = goodsDao.insertCheck(goodsCode);
		if(check!= 0) {
			goodsCode = rs.nextString();
		}
		Map<String, Object> hm = util.goodsFileUpload(goodsCode, mpReq);
		goodsVo.setGoodsCode((String) hm.get("goodsCode"));
		List<String> imageList = (List<String>) hm.get("saveNames");
		
		goodsVo.setHeart("no");
		goodsVo.setStock(20);
		
		System.out.println("service.insert: " + goodsVo.toString());
		goodsDao.insert(goodsVo);

		for(String str : imageList) {
			GoodsImageVo tmp = new GoodsImageVo(goodsCode, str);
			goodsImageDao.insert(tmp);
		}

	}

	@Override
	public void update(GoodsVo goodsVo, MultipartHttpServletRequest mpReq) throws Exception {

		if(mpReq.getParameterValues("deleteGoodsImage") != null) {
			util.goodsFileDelete(goodsVo.getGoodsCode(), mpReq);
			String[] deleteFile = mpReq.getParameterValues("deleteGoodsImage");
			for(String str2 : deleteFile) {
				goodsImageDao.editGoodsImage(goodsVo.getGoodsCode() + "_" + str2);
				System.out.println(str2);
			}
		}
		if(mpReq.getFiles("plusGoodsImage") != null) {
			List<String> nameList = util.goodsFileEdit(goodsVo.getGoodsCode(), mpReq);
			for(String str : nameList) {
				GoodsImageVo tmp = new GoodsImageVo(goodsVo.getGoodsCode(), str);
				goodsImageDao.insert(tmp);
			}
		}
		goodsDao.update(goodsVo);
		
	}

	@Override
	public void updateHeart(String type, List<String> selectGoods) throws Exception {
		for(String str : selectGoods) {
		HashMap<String, String> hm = new HashMap<String, String>();
		if(type.equals("recommand")) {
			hm.put("heart", "yes");
			hm.put("goodsCode", str);
		}else if(type.equals("cancle")) {
			hm.put("heart", "no");
			hm.put("goodsCode", str);
		}
		goodsDao.updateHeart(hm);		
		}

	}

	@Override
	public void deleteGoods(String[] selectGoods) throws Exception {
		for(String str : selectGoods) {
			util.goodsDelete(str);
			goodsDao.deleteGoods(str);
			goodsImageDao.deleteGoodsImage(str);
		}
	}

	//관리자 조회
	@Override
	public List<HashMap<String, Object>> selectAll() throws Exception {
		List<HashMap<String, Object>> tmp = goodsDao.editSelectAll();
		for(HashMap<String, Object> hm : tmp) {
			java.util.Date date = (Date) hm.get("REGDATE");
			hm.put("REGDATE", dateType(date));
		}
		return tmp;
	}

	@Override
	public Map<String, Object> selectOne(String goodsCode) throws Exception {
		Map<String, Object> hm = new HashMap<String, Object>();
		GoodsVo goods = goodsDao.selectOne(goodsCode);
		List<String> goodsImages = new ArrayList<String>();
		List<String> imgPath = new ArrayList<String>();
		for(String str : goodsImageDao.selectImage(goodsCode)) {
			String path = "C:\\TeamProject\\UploadFile\\GOODS\\" + goods.getGoodsCode() + "\\" + str;
			imgPath.add(path);
			String[] tmp = str.split("_");
			String result = "";
			if(tmp.length > 2) {
				StringBuffer name = new StringBuffer();
				for(int i = 1; i <= tmp.length-1; i++) {
					name.append(tmp[i]);
					if(tmp.length-1 != i) {
						name.append("_");
					}
				}
				result = String.valueOf(name);	
			}else {
				result = tmp[tmp.length-1];
			}
			goodsImages.add(result);
		}
		hm.put("goods", goods);
		hm.put("goodsImages", goodsImages);
		hm.put("imgPath", imgPath);
		return hm;
	}

	@Override
	public void deleteNotExistImage(String goodsCode) throws Exception {
		goodsImageDao.deleteGoodsImage(goodsCode);
	}

	@Override
	public void updateSales(String state, String goodsCode) throws Exception {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("state", state);
		hm.put("goodsCode", goodsCode);
		goodsSalesDao.updateSaleState(hm);
	}
	
	@Override
	public List<HashMap<String, Object>> orderAll() throws Exception {
		return goodsSalesDao.orderList();
	}
	
	private static Date dateType(java.util.Date date) {
		SimpleDateFormat after = new SimpleDateFormat("yyyy-MM-dd");
		String trans = after.format(date);
		Date result = java.sql.Date.valueOf(trans);
		return result;
	}
	
}
