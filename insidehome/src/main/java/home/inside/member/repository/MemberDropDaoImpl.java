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
	public int emailCheckDrop(String email) throws Exception {
		return sqlSessionTemplate.selectOne("emailCheckDrop", email);
	}

	@Override
	public int nicknameCheckDrop(String nickname) throws Exception {
		return sqlSessionTemplate.selectOne("nicknameCheckDrop", nickname);
	}

	@Override
	public List<HashMap<String, Object>> selectDropList() throws Exception {
		return sqlSessionTemplate.selectList("selectDropList");
	}

	@Override
	public List<HashMap<String, Object>> searchDropList(String nickname) throws Exception {
		return sqlSessionTemplate.selectList("searchDropList", nickname);
	}

}
