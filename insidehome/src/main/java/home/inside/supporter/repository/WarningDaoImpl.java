package home.inside.supporter.repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import home.inside.supporter.vo.WarningVo;

@Repository
public class WarningDaoImpl implements IWarningDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void warningInsert(WarningVo vo) throws Exception {
		sqlSessionTemplate.insert("warningInsert", vo) ;
	}
	@Override
	public int warningCount(String nickname) throws Exception {
		return sqlSessionTemplate.selectOne("warningCount", nickname);
		
	}
	@Override
	public void warningDelete(String nickname) throws Exception {
		sqlSessionTemplate.delete("warningDelete", nickname);
	}
	@Override
	public List<HashMap<String, Object>> warningSelectAll() throws Exception {
		return sqlSessionTemplate.selectList("warningSelectAll");
	}
}
