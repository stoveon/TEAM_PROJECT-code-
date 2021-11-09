package home.inside.supporter.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import home.inside.supporter.vo.WarningVo;

@Repository
public interface IWarningDao {
	// 신고접수
	public void warningInsert(WarningVo vo) throws Exception;
	
	//신고횟수 확인
	public int warningCount(String nickname) throws Exception;
	
	// 탈퇴시 내용삭제
	public void warningDelete(String nickname) throws Exception;
	
	//신고 목록 조회
	public List<HashMap<String, Object>> warningSelectAll() throws Exception;

}
