package home.inside.member.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import home.inside.member.vo.MemberAddrVo;import oracle.security.o3logon.a;

@Repository
public class MemberAddrDaoImpl implements IMemberAddrDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
		
	@Override
	public void insertAddrInfo(MemberAddrVo addrVo) throws Exception {
		sqlSessionTemplate.insert("insertAddrInfo", addrVo);
	}

	@Override
	public MemberAddrVo selectAddrInfo(String nickname) throws Exception {
		return sqlSessionTemplate.selectOne("selectAddrInfo", nickname);
	}

	@Override
	public void updateAddrInfo(MemberAddrVo addrVo) throws Exception {
		sqlSessionTemplate.update("updateAddrInfo", addrVo);
	}

	@Override
	public void deleteAddrInfo(String nickname) throws Exception {
		sqlSessionTemplate.delete("deleteAddrInfo", nickname);
	}

}
