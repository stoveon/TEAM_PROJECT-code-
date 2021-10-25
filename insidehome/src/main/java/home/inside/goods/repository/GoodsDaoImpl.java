package home.inside.goods.repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import home.inside.goods.vo.GoodsVo;

@Repository
public class GoodsDaoImpl implements IGoodsDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void insert(GoodsVo goodsVo) throws Exception {
		sqlSessionTemplate.insert("insertGoods", goodsVo);
	}

	@Override
	public void update(GoodsVo goodsVo) throws Exception {
		sqlSessionTemplate.update("updateGoods", goodsVo);
	}

	@Override
	public void updateHeart(HashMap<String, String> hm) throws Exception {
		sqlSessionTemplate.update("updateGoodsHeart", hm);
	}

	@Override
	public void deleteGoods(String goodsCode) throws Exception {
		sqlSessionTemplate.delete("deleteGoods", goodsCode);
	}

	@Override
	public List<GoodsVo> selectAll(String type) throws Exception {
		
		return sqlSessionTemplate.selectList("selectGoodsAll", type);
	}

	@Override
	public GoodsVo selectOne(String goodsCode) throws Exception {
		return sqlSessionTemplate.selectOne("selectGoodsOne", goodsCode);
	}

	@Override
	public void updateStock(HashMap<String, Integer> hm) throws Exception {
		sqlSessionTemplate.update("updateGoodsStock", hm);
	}

}
