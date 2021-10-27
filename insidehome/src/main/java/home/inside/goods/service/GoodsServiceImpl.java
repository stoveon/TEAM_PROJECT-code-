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
import home.inside.goods.vo.GoodsSalesVo;
import home.inside.goods.vo.GoodsVo;

@Service
public class GoodsServiceImpl implements IGoodsService {
	@Autowired
	private IGoodsDao goodsDao;
	@Autowired
	private IGoodsImageDao goodsImageDao;
	@Autowired
	private IGoodsSalesDao goodsSalesDao;
	@Autowired
	private FileUtils util;
	
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
		System.out.println("updateSer: " + goodsVo.toString());
		goodsDao.update(goodsVo);
		
	}

	@Override
	public void updateHeart(String type, String[] selectGoods) throws Exception {
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

	//회원 리스트
	@Override
	public List<HashMap<String, Object>> selectAll(String type) throws Exception {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("type", type);
		return goodsDao.selectAll(hm);
	}
	
	@Override
	public List<GoodsImageVo> selectAllImage() throws Exception {
		return goodsImageDao.selectImage();
	}

	@Override
	public Map<String, Object> selectOne(String type, String goodsCode) throws Exception {
		Map<String, Object> hm = new HashMap<String, Object>();
		GoodsVo goods = goodsDao.selectOne(goodsCode);
		List<String> goodsImages = new ArrayList<String>();
		if(type.equals("manager")) {
			for(String str : goodsImageDao.selectImage(goodsCode)) {
				String[] tmp = str.split("_");
				String result = "";
				if(tmp.length > 2) {
					StringBuffer name = new StringBuffer();
					for(int i = 1; i <= tmp.length; i++) {
						name.append(tmp[i]);
						if(tmp.length != i) {
							name.append("_");
						}
					}
					result = String.valueOf(name);	
				}else {
					result = tmp[tmp.length-1];
				}
				goodsImages.add(result);
			}
		}else if(type.equals("user")) {
			goodsImages = goodsImageDao.selectImage(goodsCode);
		}
		hm.put("goods", goods);
		hm.put("goodsImages", goodsImages);
		return hm;
	}

	@Override
	public void insertGoodsSales(GoodsSalesVo goodsSalesVo) throws Exception {
		
	}

	@Override
	public void deleteGoodsSales(String nickname) throws Exception {
		
		goodsSalesDao.deleteGoodsSales(nickname);
	}
	
	private static Date dateType(java.util.Date date) {
		SimpleDateFormat after = new SimpleDateFormat("yyyy-MM-dd");
		String trans = after.format(date);
		Date result = java.sql.Date.valueOf(trans);
		return result;
	}


}
