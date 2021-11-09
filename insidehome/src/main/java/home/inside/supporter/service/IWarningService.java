package home.inside.supporter.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import home.inside.supporter.vo.WarningVo;

@Service
public interface IWarningService {
	// 신고접수
	public void warningInsert(WarningVo vo) throws Exception;
	// 신고횟수 조회
	public int warningCount(String nickname) throws Exception;
	// 신고삭제
	public void warningDelete(String nickname) throws Exception;
	//신고 목록
	public List<HashMap<String, Object>> warningSelectAll() throws Exception;
}
