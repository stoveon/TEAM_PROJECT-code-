package home.inside.goods.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import home.inside.goods.vo.GoodsImageVo;
import home.inside.goods.vo.GoodsSalesVo;
import home.inside.goods.vo.GoodsVo;

public interface IGoodsService {
	public void insert(GoodsVo goodsVo, MultipartHttpServletRequest mpReq) throws Exception;
	public void update(GoodsVo goodsVo, MultipartHttpServletRequest mpReq) throws Exception;
	public void updateHeart(String type, String[] selectGoods) throws Exception;
	public void deleteGoods(String[] selectGoods) throws Exception;
	public List<HashMap<String, Object>> selectAll() throws Exception;
	public List<HashMap<String, Object>> selectAll(String type) throws Exception;
	public List<GoodsImageVo> selectAllImage() throws Exception;
	public Map<String, Object> selectOne(String type, String goodsCode) throws Exception;
	public void insertGoodsSales(GoodsSalesVo goodsSalesVo) throws Exception;
	public void deleteGoodsSales(String nickname) throws Exception;
	public void deleteNotExistImage(String goodsCode) throws Exception;
	public List<HashMap<String, Object>> orderAll() throws Exception;
	public void updateSales(String state, String goodsCode) throws Exception;
}
