package home.inside.member.repository;

import home.inside.member.vo.MemberAddrVo;

public interface IMemberAddrDao {
	// 회원가입
	public void insertAddrInfo(MemberAddrVo addrVo) throws Exception;
	// 회원정보 조회
	public MemberAddrVo selectAddrInfo(String nickname) throws Exception;
	// 회원정보 수정
	public void updateAddrInfo(MemberAddrVo addrVo) throws Exception;
	// 회원탈퇴
	public void deleteAddrInfo(String nickname) throws Exception;

}
