package home.inside.goods.vo;

public class GoodsImageVo {
	private int num ;
	private String goodsCode ;
	private String saveName ;
	
	public GoodsImageVo(String goodsCode, String saveName) {
		this.goodsCode = goodsCode;
		this.saveName = saveName;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getSaveName() {
		return saveName;
	}
	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	
}
