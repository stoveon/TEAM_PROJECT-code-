package home.inside.goods.repository;

import java.util.HashMap;
import java.util.List;

import home.inside.goods.vo.GoodsVo;

public interface IGoodsDao {
	public void insert(GoodsVo goodsVo) throws Exception;
	public void update(GoodsVo goodsVo) throws Exception;
	public void updateHeart(HashMap<String, String> hm) throws Exception;
	public void deleteGoods(String goodsCode) throws Exception;
	public List<HashMap<String, Object>> editSelectAll() throws Exception;
	public List<HashMap<String, Object>> selectAll(HashMap<String, String> hm) throws Exception;
	public GoodsVo selectOne(String goodsCode) throws Exception;
	public void updateStock(HashMap<String, Integer> hm) throws Exception;
	public int insertCheck(String goodsCode) throws Exception;
}
