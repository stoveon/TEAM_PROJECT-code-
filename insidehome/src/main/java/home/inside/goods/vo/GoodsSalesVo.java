package home.inside.goods.vo;

import java.util.Date;

public class GoodsSalesVo {
	private int num;
	private String goodsCode;
	private String nickname;
	private int sales;
	private Date orderdate;
	private String sendSate;
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
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public String getSendSate() {
		return sendSate;
	}
	public void setSendSate(String sendSate) {
		this.sendSate = sendSate;
	}
	
}
