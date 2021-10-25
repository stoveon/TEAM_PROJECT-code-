package home.inside.supporter.vo;

import java.util.Date;

public class WarningVo {
	private int num ;
	private String nickname ;
	private int boardNum ;
	private String warnType ;
	private String warnWhy ;
	private Date warntime ;
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
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getWarnType() {
		return warnType;
	}
	public void setWarnType(String warnType) {
		this.warnType = warnType;
	}
	public String getWarnWhy() {
		return warnWhy;
	}
	public void setWarnWhy(String warnWhy) {
		this.warnWhy = warnWhy;
	}
	public Date getWarntime() {
		return warntime;
	}
	public void setWarntime(Date warntime) {
		this.warntime = warntime;
	}

	
}
