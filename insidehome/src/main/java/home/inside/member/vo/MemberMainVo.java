package home.inside.member.vo;

import java.util.Date;

public class MemberMainVo {
	private int num;
	private String email;
	private String nickname;
	private String password;
	private String sessionId;
	private Date loginTime;
	private Date regdate;
	
	public MemberMainVo() {}
	
	public MemberMainVo(String email, String nickname, String password, Date regdate) {
		this.email = email;
		this.nickname = nickname;
		this.password = password;
		this.regdate = regdate;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "MemberMainVo [num=" + num + ", email=" + email + ", nickname=" + nickname + ", password=" + password
				+ ", sessionId=" + sessionId + ", loginTime=" + loginTime + ", regdate=" + regdate + "]";
	}
	
	
}
