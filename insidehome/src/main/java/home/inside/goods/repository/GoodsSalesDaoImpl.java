package home.inside.goods.repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import home.inside.goods.vo.GoodsSalesVo;

@Repository
public class GoodsSalesDaoImpl implements IGoodsSalesDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void insertGoodsSales(GoodsSalesVo goodsSalesVo) throws Exception {
		sqlSessionTemplate.insert("insertGoodsSales", goodsSalesVo);
	}

	@Override
	public List<HashMap<String, Object>> orderList() throws Exception {
		return sqlSessionTemplate.selectList("salesOrderList");
	}

	@Override
	public void updateSaleState(HashMap<String, Object> hm) throws Exception {
		sqlSessionTemplate.update("updateOrderState", hm);
	}

	@Override
	public void deleteGoodsSales(String nickname) throws Exception {
		sqlSessionTemplate.insert("deleteGoodsSales", nickname);
	}

	@Override
	public int salesCount(String nickname) throws Exception {
		return sqlSessionTemplate.selectOne("salesCountNickname", nickname);
	}

	@Override
	public List<HashMap<String, String>> nickNameOrderList(String nickname) throws Exception {
		return sqlSessionTemplate.selectList("nickNameOrderList", nickname);
	}

	@Override
	public void autoSendupdate(String nickname) throws Exception {
		sqlSessionTemplate.update("autoSendUpdate", nickname);
	}

	@Override
	public List<String> autoSendupdateList() throws Exception {
		return sqlSessionTemplate.selectList("autoSendUPdateList");
	}
}
