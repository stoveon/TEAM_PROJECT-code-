package home.inside.member.vo;

import java.util.Date;

public class MemberDropVo {
	private int num;
	private String email;
	private String nickname;
	private int warnCount;
	private Date dropdate;
	
	
	public MemberDropVo(String email, String nickname, int warnCount) {
		super();
		this.email = email;
		this.nickname = nickname;
		this.warnCount = warnCount;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public int getWarnCount() {
		return warnCount;
	}


	public void setWarnCount(int warnCount) {
		this.warnCount = warnCount;
	}


	public Date getDropdate() {
		return dropdate;
	}


	public void setDropdate(Date dropdate) {
		this.dropdate = dropdate;
	}


	@Override
	public String toString() {
		return "MemberDropVo [num=" + num + ", email=" + email + ", nickname=" + nickname + ", warnCount=" + warnCount
				+ ", dropdate=" + dropdate + "]";
	}
	
	
}
