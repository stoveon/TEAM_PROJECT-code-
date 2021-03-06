package home.inside.goods.repository;

import java.util.HashMap;
import java.util.List;

import home.inside.goods.vo.GoodsVo;

public interface IGoodsDao {
	//상품 등록
	public void insert(GoodsVo goodsVo) throws Exception;
	//상품 수정
	public void update(GoodsVo goodsVo) throws Exception;
	//추천상품 등록 or 해제
	public void updateHeart(HashMap<String, String> hm) throws Exception;
	//관리자 상세 페이지 출력
	public List<HashMap<String, Object>> editSelectAll() throws Exception;
	//전체 상품 정보 출력
	public List<HashMap<String, Object>> selectAll(HashMap<String, String> hm) throws Exception;
	//해당 상품 정보 출력
	public GoodsVo selectOne(String goodsCode) throws Exception;
	//재고 추가
	public void updateStock(HashMap<String, Integer> hm) throws Exception;
	//상품코드 중복 확인용
	public int insertCheck(String goodsCode) throws Exception;
	//메인에서 보여줄 최근에 등록된 상품 10개 출력
	public List<HashMap<String, String>> selectMainLatest() throws Exception;
	//메인에서 보여줄 추천상품
	public List<HashMap<String, String>> selectMainHeart() throws Exception;
	// 재고관리
	public void stockMinus(String goodsCode) throws Exception;
}
