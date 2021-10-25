package home.inside.common.vo;

import java.util.Date;

public class PointVo {
	private int num;
	private String nickname;
	private Date changedate;
	private int changePoint;
	private String changeWhy;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getChangedate() {
		return changedate;
	}
	public void setChangedate(Date changedate) {
		this.changedate = changedate;
	}
	public int getChangePoint() {
		return changePoint;
	}
	public void setChangePoint(int changePoint) {
		this.changePoint = changePoint;
	}
	public String getChangeWhy() {
		return changeWhy;
	}
	public void setChangeWhy(String changeWhy) {
		this.changeWhy = changeWhy;
	}

	
}
