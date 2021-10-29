package home.inside.goods.repository;

import java.util.HashMap;
import java.util.List;

import home.inside.goods.vo.GoodsSalesVo;

public interface IGoodsSalesDao {
	//상품 주문 등록
	public void insertGoodsSales(GoodsSalesVo goodsSalesVo) throws Exception;
	//상품 주문 정보 출력
	public List<HashMap<String, Object>> orderList() throws Exception;
	//배송 상태 수정(배송, 배송취소, 배송 완료)
	public void updateSaleState(HashMap<String, String> hm) throws Exception;
	//상품 주문 삭제(회원탈퇴시)
	public void deleteGoodsSales(String nickname) throws Exception;
	//회원별 주문 수량 가져오기
	public int salesCount(String nickname) throws Exception;
}
