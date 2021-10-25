package home.inside.goods.repository;

import home.inside.goods.vo.GoodsSalesVo;

public interface IGoodsSalesDao {
	public void insertGoodsSales(GoodsSalesVo goodsSalesVo) throws Exception;
	public void deleteGoodsSales(String nickname) throws Exception;
	public int salesCount(String nickname) throws Exception;
}
