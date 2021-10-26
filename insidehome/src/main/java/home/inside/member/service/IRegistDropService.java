package home.inside.member.service;

import java.util.HashMap;
import java.util.List;

import home.inside.member.util.RegistCommand;
import home.inside.member.vo.MemberAddrVo;
import home.inside.member.vo.MemberDropVo;

public interface IRegistDropService {
	public void registMember(RegistCommand regCmd, String gender, Integer storedate, MemberAddrVo addrVo) throws Exception;
	public List<String> overlapCheck(String type, String str) throws Exception;
	public void dropMember(MemberDropVo dropVo) throws Exception;
}
