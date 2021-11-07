package home.inside.common.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface IPointService {
	// 포인트 변동내역 입력
	public void insertPoint(String nickname, String changeWhy, int changePoint) throws Exception;

	// 오늘 출석여부 확인
	public int selectCheck(String nickname) throws Exception;

	// 최근 30일 포인트 변동내역 확인
	public List<HashMap<String, Object>> selectList(String nickname) throws Exception;

	// 회원 탈퇴 시 내용 삭제
	public void deletePoint(String nickname) throws Exception;
	
}
