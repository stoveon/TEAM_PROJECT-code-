package home.inside.goods.repository;

import java.util.HashMap;
import java.util.List;

import home.inside.goods.vo.GoodsImageVo;

public interface IGoodsImageDao {
	//상품 이미지 등록
	public void insert(GoodsImageVo goodsImageVo) throws Exception;
	//상품 이미지 삭제
	public void deleteGoodsImage(String goodsCode) throws Exception;
	//상품 상세 페이지에서 이미지 리스트로 가져오기
	public List<String> selectImage(String goodsCode) throws Exception;
	//포인트몰에서 사용할 각 상품별 사진 하나만 가져오기
	public List<GoodsImageVo> selectImage() throws Exception;
	//테이블에는 이미지 이름이 저장되어 있지만 실제 파일이 없을 경우
	public void editGoodsImage(String goodsCode) throws Exception;
	//주문에서 사용할 대표 이미지 출력
	public HashMap<String, String> orderMainImage(String goodsCode) throws Exception;
}
