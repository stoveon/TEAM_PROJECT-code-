package home.inside.goods.repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import home.inside.goods.vo.GoodsImageVo;

@Repository
public class GoodsImageDaoImpl implements IGoodsImageDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void insert(GoodsImageVo goodsImageVo) throws Exception {
		sqlSessionTemplate.insert("insertGoodsImage", goodsImageVo);
	}

	@Override
	public void deleteGoodsImage(String goodsCode) throws Exception {
		sqlSessionTemplate.delete("deleteGoodsImage", goodsCode);
	}

	@Override
	public List<String> selectImage(String goodsCode) throws Exception {
		return sqlSessionTemplate.selectList("selectGoodsImageDetail", goodsCode);
	}

	@Override
	public List<GoodsImageVo> selectImage() throws Exception {
		return sqlSessionTemplate.selectList("selectGoodsImageList");
	}

	@Override
	public void editGoodsImage(String saveName) throws Exception {
		sqlSessionTemplate.delete("editGoodsImage", saveName);
	}

	@Override
	public HashMap<String, String> orderMainImage(String goodsCode) throws Exception {
		return sqlSessionTemplate.selectOne("selectMainImage", goodsCode);
	}

}
