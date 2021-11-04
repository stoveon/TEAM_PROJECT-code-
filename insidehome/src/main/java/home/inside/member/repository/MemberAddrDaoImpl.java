package home.inside.member.repository;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import home.inside.member.vo.MemberAddrVo;

@Repository
public class MemberAddrDaoImpl implements IMemberAddrDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
		
	@Override
	public void insertAddrInfo(MemberAddrVo addrVo) throws Exception {
		sqlSessionTemplate.insert("insertAddrInfo", addrVo);
	}

	@Override
	public void updateAddrInfo(HashMap<String, Object> hsm) throws Exception {
		sqlSessionTemplate.update("updateAddrInfo", hsm);
	}

	@Override
	public void deleteAddrInfo(String nickname) throws Exception {
		sqlSessionTemplate.delete("deleteAddrInfo", nickname);
	}

}
