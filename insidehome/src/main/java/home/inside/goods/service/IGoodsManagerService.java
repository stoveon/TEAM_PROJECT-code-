package home.inside.goods.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import home.inside.goods.vo.GoodsVo;

public interface IGoodsManagerService {
	//상품 등록
	public void insert(GoodsVo goodsVo, MultipartHttpServletRequest mpReq) throws Exception;
	//상품 수정
	public void update(GoodsVo goodsVo, MultipartHttpServletRequest mpReq) throws Exception;
	//추천상품 등록 or 해제
	public void updateHeart(String type, List<String> selectGoods) throws Exception;
	//상품 삭제
	public void deleteGoods(String[] selectGoods) throws Exception;
	//상품관리 페이지 목록 출력
	public List<HashMap<String, Object>> selectAll() throws Exception;
	//관리자 상품 상세페이지
	public Map<String, Object> selectOne(String goodsCode) throws Exception;
	//테이블에는 상품 이미지가 있지만 실제 파일이 없을 경우 삭제
	public void deleteNotExistImage(String goodsCode) throws Exception;
	//발송상태 변경
	public void updateSales(String state, int num) throws Exception;
	//관리자 메인 페이지(주문관리)에서 사용할 메서드
	public List<HashMap<String, Object>> orderAll() throws Exception;
	//배송상태 자동 업데이트 처리
	public void autoSendUpdate() throws Exception;
}
