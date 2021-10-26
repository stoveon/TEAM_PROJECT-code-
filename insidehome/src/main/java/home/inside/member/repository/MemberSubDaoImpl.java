package home.inside.member.repository;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import home.inside.member.vo.MemberSubVo;

@Repository
public class MemberSubDaoImpl implements IMemberSubDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void insertSubInfo(HashMap<String, Object> hsm) throws Exception {
		sqlSessionTemplate.insert("insertSubInfo", hsm);
	}

	@Override
	public MemberSubVo selectSubInfo(String nickname) throws Exception {
		return sqlSessionTemplate.selectOne("selectSubInfo", nickname);
	}

	@Override
	public void updateSubInfo(MemberSubVo subVo) throws Exception {
		sqlSessionTemplate.update("updateSubInfo", subVo);
	}

	@Override
	public void deleteSubInfo(String nickname) throws Exception {
		sqlSessionTemplate.delete("deleteSubInfo", nickname);
	}

	@Override
	public HashMap<String, Object> selectPointAndWarn(String nickname) throws Exception {
		return sqlSessionTemplate.selectOne("selectPointAndWarn", nickname);
	}

	@Override
	public void updatePointOrWarn(HashMap<String, Object> hsm) throws Exception {
		sqlSessionTemplate.update("updatePointOrWarn", hsm);
	}

}
