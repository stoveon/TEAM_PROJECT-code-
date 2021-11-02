package home.inside.goods.service;

import java.util.HashMap;
import java.util.List;

public interface IGoodsService {
	//닉네임별 주문갯수 출력
	public int nicknameOrderCount(String nickname) throws Exception;
	//닉네임별 주문갯수 출력
	public List<HashMap<String,String>> nicknameOrderList(String nickname) throws Exception;
	//회원탈퇴시 관련 내용 삭제
	public void deleteGoodsSales(String nickname) throws Exception;
}
