package home.inside.member.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.inside.member.repository.IMemberAddrDao;
import home.inside.member.repository.IMemberSubDao;
import home.inside.member.vo.MemberAddrVo;

@Service
public class MemberServiceImpl implements IMemberService {
	@Autowired
	private IMemberSubDao subDao;
	@Autowired
	private IMemberAddrDao addrDao;

	@Override
	public MemberAddrVo selectAddrInfo(String nickname) throws Exception {
		return addrDao.selectAddrInfo(nickname);
	}

	@Override
	public void updateMyCount(String nickname, int point) throws Exception {
		HashMap<String, Object> hsm = new HashMap<String, Object>();
		hsm.put("nickname", nickname);
		hsm.put("point", point);
		subDao.updatePointOrWarn(hsm);

	}

}
