package home.inside.goods.service;

public interface IGoodsService {
	//마이페이지에서 주문갯수 출력
	public int salesCountNickname(String nickname) throws Exception;
	//회원탈퇴시 관련 내용 삭제
	public void deleteGoodsSales(String nickname) throws Exception;
}
