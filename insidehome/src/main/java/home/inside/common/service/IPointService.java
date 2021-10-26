package home.inside.common.service;

import java.util.List;

import home.inside.common.vo.PointVo;

public interface IPointService {
	// 포인트 변동내역 입력
	public void insertPoint(PointVo vo) throws Exception;
	
	// 오늘 출석여부 확인
	public int selectCheck(String nickname) throws Exception;
	
	// 이번달 포인트 변동내역 확인
	public List<PointVo> selectMonth(String nickname, int month) throws Exception;
	
	// 회원 탈퇴 시 내용 삭제
	public void deletePoint(String nickname) throws Exception;
}
