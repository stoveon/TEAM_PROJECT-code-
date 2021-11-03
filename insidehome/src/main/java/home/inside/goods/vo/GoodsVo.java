package home.inside.goods.vo;

import java.util.Date;

public class GoodsVo {
	private int num;
	private String goodsCode;
	private String goodsName;
	private String content;
	private Integer price;
	private Date regdate;
	private String heart;
	private int stock;

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

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getHeart() {
		return heart;
	}

	public void setHeart(String heart) {
		this.heart = heart;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "GoodsVo [num=" + num + ", goodsCode=" + goodsCode + ", goodsName=" + goodsName + ", content=" + content
				+ ", price=" + price + ", regdate=" + regdate + ", heart=" + heart + ", stock=" + stock + "]";
	}
}
