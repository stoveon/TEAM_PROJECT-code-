package home.inside.goods.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import home.inside.goods.vo.GoodsSalesVo;

@Repository
public class GoodsSalesDaoImpl implements IGoodsSalesDao {
	@Autowired

	private static SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void insertGoodsSales(GoodsSalesVo goodsSalesVo) throws Exception {
		sqlSessionTemplate.insert("insertGoodsSales", goodsSalesVo);
	}

	@Override
	public void deleteGoodsSales(String nickname) throws Exception {
		sqlSessionTemplate.insert("deleteGoodsSales", nickname);
	}

	@Override
	public int salesCount(String nickname) throws Exception {
		return sqlSessionTemplate.selectOne("salesCount", nickname);
	}
}
