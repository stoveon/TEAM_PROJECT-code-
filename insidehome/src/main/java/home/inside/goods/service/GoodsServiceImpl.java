package home.inside.goods.service;

import java.util.ArrayList;
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
public class GoodsServiceImpl implements IGoodsService {
	@Autowired
	private IGoodsDao goodsDao;
	@Autowired
	private IGoodsImageDao goodsImageDao;
	@Autowired
	private IGoodsSalesDao goodsSalesDao;
	
	@Override
	public void insert(GoodsVo goodsVo, List<String> iamgeNames) throws Exception {
		goodsDao.insert(goodsVo);
		
		String goodsCode = goodsVo.getGoodsCode();
		for(String str : iamgeNames) {
			GoodsImageVo tmp = new GoodsImageVo(goodsCode, str);
			goodsImageDao.insert(tmp);
		}

	}

	@Override
	public void update(GoodsVo goodsVo, List<String> iamgeNames) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateHeart(String type, String goodsCode) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteGoods(String goodsCode) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<GoodsVo> selectAll(String type) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoodsImageVo> selectAllImage(String type) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> selectOne(String goodsCode) throws Exception {
		Map<String, Object> hm = new HashMap<String, Object>();
		GoodsVo goods = goodsDao.selectOne(goodsCode);
		List<String> goodsImages = new ArrayList<String>();
		
		for(String str : goodsImageDao.selectImage(goodsCode)) {
			String[] tmp = str.split("_");
			goodsImages.add(tmp[1]);
		}
		hm.put("goods", goods);
		hm.put("goodsImages", goodsImages);
		
		return hm;
	}

	@Override
	public void insertGoodsSales(GoodsSalesVo goodsSalesVo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteGoodsSales(String nickname) throws Exception {
		// TODO Auto-generated method stub

	}

}
