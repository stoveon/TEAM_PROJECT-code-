package home.inside.member.repository;

import java.util.HashMap;

import home.inside.member.vo.MemberSubVo;

public interface IMemberSubDao {
		// 회원가입
		public void insertSubInfo(HashMap<String, Object> hsm) throws Exception;
		// 회원정보 수정
		public void updateSubInfo(HashMap<String, Object> hsm) throws Exception;
		// 회원탈퇴
		public void deleteSubInfo(String nickname) throws Exception;
		
		//--------------------------------------------------------------------------
		// 마이페이지 접속 시 경고횟수, 잔여포인트 조회
		public HashMap<String, Object> selectPointAndWarn(String nickname) throws Exception; 
		
		// 경고, 포인트 변동 시 회원테이블 업데이트
		public void updatePointOrWarn(HashMap<String, Object> hsm) throws Exception;
		
}
