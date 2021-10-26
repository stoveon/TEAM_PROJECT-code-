package home.inside.member.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.inside.member.repository.IMemberAddrDao;
import home.inside.member.repository.IMemberDropDao;
import home.inside.member.repository.IMemberMainDao;
import home.inside.member.repository.IMemberSubDao;
import home.inside.member.util.RegistCommand;
import home.inside.member.vo.MemberAddrVo;
import home.inside.member.vo.MemberDropVo;

@Service
public class RegistDropServiceImpl implements IRegistDropService {
	@Autowired
	private IMemberMainDao mainDao;
	@Autowired
	private IMemberSubDao subDao;
	@Autowired
	private IMemberAddrDao addrDao;
	@Autowired
	private IMemberDropDao dropDao;
	
	@Override
	public void registMember(RegistCommand regCmd, String gender, Integer storedate, MemberAddrVo addrVo) throws Exception {
		HashMap<String , Object> mainInfo = new HashMap<String, Object>();
		mainInfo.put("Email", regCmd.getEmail());
		mainInfo.put("nickname", regCmd.getNickname());
		mainInfo.put("password", regCmd.getPassword());
		mainDao.insertMainInfo(mainInfo);
		
		HashMap<String, Object> subInfo = new HashMap<String, Object>();
		subInfo.put("nickname", regCmd.getNickname());
		subInfo.put("name", regCmd.getNickname());
		gender = (gender==null)?"w":gender;
		subInfo.put("gender", gender);
		storedate = (storedate==null)?100:storedate;
		subInfo.put("storedate", storedate);
		subDao.insertSubInfo(subInfo);

		addrDao.insertAddrInfo(addrVo);
	}

	@Override
	public List<String> overlapCheck(String type, String str) throws Exception {		
		HashMap<String, Object> hsm = new HashMap<String, Object>();
		hsm.put("type", type);
		hsm.put("str", str);
		List<String> result = new ArrayList<String>();
		result.add(mainDao.overlapCheck(hsm));
		result.add(dropDao.overlapCheckDrop(hsm));
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
