package home.inside.goods.vo;

import java.util.Date;

public class GoodsSalesVo {
	private int num;
	private String goodsCode;
	private String nickname;
	private int price;
	private Date orderdate;
	private String sendState;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public String getSendState() {
		return sendState;
	}
	public void setSendState(String sendState) {
		this.sendState = sendState;
	}
	public GoodsSalesVo(String goodsCode, String nickname, int price) {
		this.goodsCode = goodsCode;
		this.nickname = nickname;
		this.price = price;
	}
	
}
