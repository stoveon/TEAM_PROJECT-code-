package home.inside.goods.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.inside.goods.repository.IGoodsDao;
import home.inside.goods.repository.IGoodsImageDao;
import home.inside.goods.repository.IGoodsSalesDao;
import home.inside.goods.vo.GoodsImageVo;
import home.inside.goods.vo.GoodsSalesVo;
import home.inside.goods.vo.GoodsVo;

@Service
public class GoodsUserServiceImpl implements IGoodsUserService {
	@Autowired
	private IGoodsDao goodsDao;
	@Autowired
	private IGoodsImageDao goodsImageDao;
	@Autowired
	private IGoodsSalesDao goodsSalesDao;

	//회원 리스트
	@Override
	public List<HashMap<String, Object>> selectAll(String type) throws Exception {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("type", type);
		return goodsDao.selectAll(hm);
	}
	
	@Override
	public HashMap<String, Object> orderGoodsInfo(String goodsCode) throws Exception {
		HashMap<String, Object> hm = new HashMap<String, Object>();
		GoodsVo goods = goodsDao.selectOne(goodsCode);
		HashMap<String, String> goodsImage = goodsImageDao.orderMainImage(goodsCode);
		hm.put("goods", goods);
		hm.put("goodsImage", goodsImage);
		return hm;
	}
	
	@Override
	public List<GoodsImageVo> selectAllImage() throws Exception {
		return goodsImageDao.selectImage();
	}

	@Override
	public void insertGoodsSales(GoodsSalesVo goodsSalesVo) throws Exception {
		
	}
	
}
