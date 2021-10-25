package home.inside.goods.service;

import java.util.List;
import java.util.Map;

import home.inside.goods.vo.GoodsImageVo;
import home.inside.goods.vo.GoodsSalesVo;
import home.inside.goods.vo.GoodsVo;

public interface IGoodsService {
	public void insert(GoodsVo goodsVo, List<String> iamgeNames) throws Exception;
	public void update(GoodsVo goodsVo, List<String> iamgeNames, String[] deleteFile) throws Exception;
	public void updateHeart(String type, String goodsCode) throws Exception;
	public void deleteGoods(String goodsCode) throws Exception;
	public List<GoodsVo> selectAll(String type) throws Exception;
	public List<GoodsImageVo> selectAllImage(String type) throws Exception;
	public Map<String, Object> selectOne(String goodsCode) throws Exception;
	public void insertGoodsSales(GoodsSalesVo goodsSalesVo) throws Exception;
	public void deleteGoodsSales(String nickname) throws Exception;
	
}
