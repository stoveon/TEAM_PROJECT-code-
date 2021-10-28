package home.inside.goods.repository;

import java.util.HashMap;
import java.util.List;

import home.inside.goods.vo.GoodsSalesVo;

public interface IGoodsSalesDao {
	public void insertGoodsSales(GoodsSalesVo goodsSalesVo) throws Exception;
	public void deleteGoodsSales(String nickname) throws Exception;
	public int salesCount(String nickname) throws Exception;
	public List<HashMap<String, Object>> orderList() throws Exception;
	public void updateSaleState(HashMap<String, String> hm) throws Exception;
}
