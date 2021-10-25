package home.inside.goods.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import home.inside.goods.vo.GoodsImageVo;

@Repository
public class GoodsImageDaoImpl implements IGoodsImageDao {
	@Autowired
	private static SqlSessionTemplate sqlSessionTemplate;
	
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
	public List<String> selectImage() throws Exception {
		return sqlSessionTemplate.selectList("selectGoodsImageList");
	}

}
