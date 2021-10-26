package home.inside.member.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.inside.member.repository.IMemberAddrDao;
import home.inside.member.repository.IMemberDropDao;
import home.inside.member.repository.IMemberMainDao;
import home.inside.member.repository.IMemberSubDao;
import home.inside.member.vo.MemberAddrVo;
import home.inside.member.vo.MemberDropVo;
import home.inside.member.vo.MemberSubVo;

@Service
public class MemberInfoServiceImpl implements IMemberInfoService {
	@Autowired
	private IMemberMainDao mainDao;
	@Autowired
	private IMemberSubDao subDao;
	@Autowired
	private IMemberAddrDao addrDao;
	@Autowired
	private IMemberDropDao dropDao;

	@Override
	public HashMap<String, Object> selectMyInfo(String nickname) throws Exception {
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("main", mainDao.selectMainInfo(nickname));
		result.put("sub", subDao.selectSubInfo(nickname));
		result.put("addr", addrDao.selectAddrInfo(nickname));
		return result;
	}
	
	@Override
	public MemberAddrVo selectAddrInfo(String nickname) throws Exception {
		return addrDao.selectAddrInfo(nickname);
	}
	@Override
	public List<HashMap<String, Object>> selectMemberList(String nickname) throws Exception {
		return mainDao.selectMainList(nickname);
	}

	@Override
	public List<MemberDropVo> selectDropList(String nickname) throws Exception {
		return dropDao.selectDropList(nickname);
	}

	@Override
	public int updatePassword(String nickname, String pw, String newPw) throws Exception {
		HashMap<String, Object> hsm = new HashMap<String, Object>();
		hsm.put("nickname", nickname);
		hsm.put("password", pw);
		hsm.put("newPassword", newPw);
		return mainDao.updatePw(hsm);
	}

	@Override
	public HashMap<String, Object> selectMyCount(String nickname) throws Exception {
		return subDao.selectPointAndWarn(nickname);
	}

	@Override
	public void updateMyInfo(MemberSubVo subVo, MemberAddrVo addrVo) throws Exception {
		subDao.updateSubInfo(subVo);
		addrDao.updateAddrInfo(addrVo);			
	}

	@Override
	public void updateMyCcount(String nickname, int point) throws Exception {
		HashMap<String, Object> hsm = new HashMap<String, Object>();
		hsm.put("nickname", nickname);
		hsm.put("point", point);
		subDao.updatePointOrWarn(hsm);

	}

}
