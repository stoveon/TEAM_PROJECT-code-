package home.inside.member.repository;

import java.util.HashMap;

import home.inside.member.vo.MemberAddrVo;

public interface IMemberAddrDao {
	// 회원가입
	public void insertAddrInfo(MemberAddrVo addrVo) throws Exception;
	// 회원정보 수정
	public void updateAddrInfo(HashMap<String, Object> hsm) throws Exception;
	// 회원탈퇴
	public void deleteAddrInfo(String nickname) throws Exception;

}
