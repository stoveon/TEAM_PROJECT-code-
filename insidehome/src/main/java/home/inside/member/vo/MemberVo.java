package home.inside.member.vo;

import java.util.Date;

public class MemberVo {
	private int num;
	private String email;
	private String nickname;
	private String password;
	private String name;
	private String gender;
	private Date storedate;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getStoredate() {
		return storedate;
	}
	public void setStoredate(Date storedate) {
		this.storedate = storedate;
	}

	
}
