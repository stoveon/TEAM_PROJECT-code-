package home.inside.member.repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import home.inside.member.vo.MemberDropVo;

@Repository
public class MemberDropDaoImpl implements IMemberDropDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void insertDropInfo(MemberDropVo dropVo) throws Exception {
		sqlSessionTemplate.insert("insertDropInfo", dropVo);
	}

	@Override
	public String overlapCheckDrop(HashMap<String, Object> hsm) throws Exception {
		List<String> result = sqlSessionTemplate.selectList("overlapCheckDrop", hsm);
		return result.isEmpty()?null: result.get(0);
	}

	@Override
	public List<MemberDropVo> selectDropList(String nickname) throws Exception {
		return sqlSessionTemplate.selectList("selectDropList", nickname);
	}

}
