package home.inside.goods.repository;

import java.util.List;

import home.inside.goods.vo.GoodsImageVo;

public interface IGoodsImageDao {
	public void insert(GoodsImageVo goodsImageVo) throws Exception;
	public void deleteGoodsImage(String goodsCode) throws Exception;
	public List<String> selectImage(String goodsCode) throws Exception;
	public List<String> selectImage() throws Exception;
}
