package home.inside.member.repository;

import java.util.HashMap;
import java.util.List;

import home.inside.member.vo.MemberDropVo;

public interface IMemberDropDao {
	// 회원 탈퇴 및 제적처리
	public void insertDropInfo(MemberDropVo dropVo) throws Exception;
	// 회원가입 시 이메일/닉네임 중복확인용
	public int emailCheckDrop(String email) throws Exception;
	public int nicknameCheckDrop(String nickname) throws Exception;
	// 탈퇴회원 목록 조회
	public List<HashMap<String, Object>> selectDropList() throws Exception; 
	public List<HashMap<String, Object>> searchDropList(String nickname) throws Exception; 
	
	
}
