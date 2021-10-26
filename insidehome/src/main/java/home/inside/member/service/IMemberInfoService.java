package home.inside.member.service;

import java.util.HashMap;
import java.util.List;

import home.inside.member.vo.MemberAddrVo;
import home.inside.member.vo.MemberDropVo;
import home.inside.member.vo.MemberSubVo;

public interface IMemberInfoService {
	public HashMap<String , Object> selectMyInfo(String nickname) throws Exception;
	public MemberAddrVo selectAddrInfo(String nickname) throws Exception;
	public List<HashMap<String, Object>> selectMemberList(String nickname) throws Exception;
	public List<MemberDropVo> selectDropList(String nickname) throws Exception;
	public int updatePassword(String nickname, String pw, String newPw) throws Exception;
	public HashMap<String, Object> selectMyCount(String nickname) throws Exception;
	public void updateMyInfo(MemberSubVo subVo, MemberAddrVo addrVo) throws Exception;
	public void updateMyCcount(String nickname, int point) throws Exception;
	
}
