package home.inside.goods.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import home.inside.goods.vo.GoodsImageVo;
import home.inside.goods.vo.GoodsSalesVo;

public interface IGoodsUserService {
	//포인트몰 목록(type: 최신순, 가격 asc or desc)
	public List<HashMap<String, Object>> selectAll(String type) throws Exception;
	//포인트몰 상세페이지 상품 정보
	public HashMap<String, Object> selectOne(String goodsCode) throws Exception;
	//포인트몰 상세페이지에서 해당 상품 이미지 전부 불러옴
	public List<GoodsImageVo> selectAllImage() throws Exception;
	//주문 등록
	public void insertGoodsSales(GoodsSalesVo goodsSalesVo) throws Exception;
	//주문할 상품 정보 가져오기
	public HashMap<String, Object> orderGoodsInfo(String goodsCode) throws Exception;
	//메인에서 보여줄 상품 정보
	public HashMap<String, Object> selectMain() throws Exception;
}