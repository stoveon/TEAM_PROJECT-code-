package home.inside.member.repository;

import java.util.HashMap;
import java.util.List;

import home.inside.member.vo.MemberInfoDto;

public interface IMemberMainDao {
	// 회원가입
	public void insertMainInfo(HashMap<String, Object> hsm) throws Exception;
	// 관리자 회원 목록 조회 및 검색
	public List<HashMap<String, Object>> selectMainList() throws Exception;	
	public List<HashMap<String, Object>> searchMainList(String nickname) throws Exception;	
	// 비밀번호 수정
	public int updatePw(HashMap<String, Object> hsm) throws Exception;
	// 회원탈퇴
	public void deleteMainInfo(String nickname) throws Exception;
	
	//-----------------------------------------------------------------
	// 로그인 옵션에 의한 정보 조회
	public HashMap<String, Object> selectLoginInfo(String sessionId) throws Exception; 
	// 로그인/본인인증 성공 확인
	public String selectIsEqualsToInsert(HashMap<String, Object> hsm) throws Exception;
	// 로그인 성공 후 로그인시간 및 옵션에 의한 정보 업데이트
	public void updateLoginSuccess(HashMap<String, Object> hsm) throws Exception;
	// 회원가입 시 중복조회용
	public int emailCheck(String email) throws Exception;
	public int nicknameCheck(String nickname) throws Exception;
	//비밀번호 찾기로 임시 로그인 허용
	public HashMap<String, Object> tmpLogin(String email) throws Exception;
	//-----------------------------------------------------------------
	// 아이디 비밀번호 찾기(main, addr)
	public String emailFind(HashMap<String, Object> hsm) throws Exception;
	public String passwordFind(HashMap<String, Object> hsm) throws Exception;
	// 회원 마이페이지 개인정보 조회용 
	public MemberInfoDto selectInfo(String nickname) throws Exception;
}
