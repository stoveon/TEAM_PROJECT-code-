package home.inside.goods.service;

import java.util.ArrayList;
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
		
		goodsDao.insert(goodsVo);

		for(String str : imageList) {
			GoodsImageVo tmp = new GoodsImageVo(goodsCode, str);
			goodsImageDao.insert(tmp);
		}

	}

	@Override
	public void update(GoodsVo goodsVo, MultipartHttpServletRequest mpReq) throws Exception {

		String[] deleteFile = mpReq.getParameterValues("deleteFile");
		util.goodsFileDelete(goodsVo.getGoodsCode(), deleteFile);
		List<String> nameList = util.goodsFileEdit(goodsVo.getGoodsCode(), mpReq);
		
		goodsDao.update(goodsVo);
		
		for(String str : nameList) {
			GoodsImageVo tmp = new GoodsImageVo(goodsVo.getGoodsCode(), str);
			goodsImageDao.insert(tmp);
		}
		
		for(String str2 : deleteFile) {
			goodsImageDao.editGoodsImage(goodsVo.getGoodsCode() + "_" + str2);
		}
		
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
		return goodsDao.editSelectAll();
	}

	//회원 리스트
	@Override
	public List<GoodsVo> selectAll(String type) throws Exception {
		return goodsDao.selectAll(type);
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
				goodsImages.add(tmp[1]);
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



}
