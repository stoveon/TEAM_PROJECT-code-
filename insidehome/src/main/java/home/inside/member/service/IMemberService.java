package home.inside.member.service;

import home.inside.member.vo.MemberAddrVo;

public interface IMemberService {
	//상품몰 배송정보 조회
	public MemberAddrVo selectAddrInfo(String nickname) throws Exception;
	//포인트, 경고횟수 수정
	public void updateMyCount(String nickname, int point) throws Exception;
}
