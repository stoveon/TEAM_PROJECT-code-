package home.inside.member.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.inside.member.repository.IMemberAddrDao;
import home.inside.member.repository.IMemberDropDao;
import home.inside.member.repository.IMemberMainDao;
import home.inside.member.repository.IMemberSubDao;
import home.inside.member.util.FindEmailCommand;
import home.inside.member.util.FindPwCommand;
import home.inside.member.vo.MemberAddrVo;
import home.inside.member.vo.MemberDropVo;
import home.inside.member.vo.MemberInfoDto;
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
	public MemberInfoDto selectInfo(String nickname) throws Exception {
		return mainDao.selectInfo(nickname);
	}

	@Override
	public Object selectMemberList(String type) throws Exception {
		if (type != null && type.equals("black")) {
			return dropDao.selectDropList();
		} else {
			return mainDao.selectMainList();
		}
	}

	@Override
	public Object searchMemberList(String nickname, String type) throws Exception {
		if (type != null && type.equals("black")) {
			return dropDao.searchDropList(nickname);
		} else {
			return mainDao.searchMainList(nickname);
		}
	}

	@Override
	public int updatePassword(String nickname, String newPw) throws Exception {
		HashMap<String, Object> hsm = new HashMap<String, Object>();
		hsm.put("nickname", nickname);
		hsm.put("newPassword", newPw);
		return mainDao.updatePw(hsm);
	}

	@Override
	public HashMap<String, Object> selectMyCount(String nickname) throws Exception {
		return subDao.selectPointAndWarn(nickname);
	}

	@Override
	public void updateMyInfo(MemberInfoDto dto) throws Exception {
		HashMap<String, Object> hsmSub = new HashMap<String, Object>();
		hsmSub.put("gender", dto.getGender());
		hsmSub.put("storedate", dto.getStoredate());
		hsmSub.put("nickname", dto.getNickname());
		subDao.updateSubInfo(hsmSub);
		
		HashMap<String, Object> hsmAddr = new HashMap<String, Object>();
		hsmAddr.put("phone1", dto.getPhone1());
		hsmAddr.put("phone2", dto.getPhone2());
		hsmAddr.put("addr", dto.getAddr());
		hsmAddr.put("addrNum", dto.getAddrNum());
		hsmAddr.put("addrSub", dto.getAddrSub());
		hsmAddr.put("nickname", dto.getNickname());
		addrDao.updateAddrInfo(hsmAddr);
	}

	@Override
	public String findMemberInfo(FindEmailCommand emailCmd, FindPwCommand pwCmd) throws Exception {
		HashMap<String, Object> hsm = new HashMap<String, Object>();
		String result = null;
		if (emailCmd != null) {
			hsm.put("email", emailCmd.getEmailAddr());
			String phone = emailCmd.getPhoneNum();
			hsm.put("phone1", phone.substring(0, 3));
			hsm.put("phone2", phone.substring(3));
			result = mainDao.emailFind(hsm);
		} else if (pwCmd != null) {
			hsm.put("email", pwCmd.getEmail());
			String phone = pwCmd.getPhone();
			hsm.put("phone1", phone.substring(0, 3));
			hsm.put("phone2", phone.substring(3));
			result = mainDao.passwordFind(hsm);
		}
		return result;
	}

	@Override
	public void dropMember(MemberDropVo dropVo) throws Exception {
		dropDao.insertDropInfo(dropVo);
		String nickname = dropVo.getNickname();
		mainDao.deleteMainInfo(nickname);
		subDao.deleteSubInfo(nickname);
		addrDao.deleteAddrInfo(nickname);
	}
}
