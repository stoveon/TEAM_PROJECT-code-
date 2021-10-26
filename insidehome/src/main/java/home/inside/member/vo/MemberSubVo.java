package home.inside.member.vo;

import java.util.Date;

public class MemberSubVo {
	private int num;
	private String nickname;
	private String name;
	private String gender;
	private int warnCount;
	private int point;
	private Date moddate;
	private Date storedate;
	
	public MemberSubVo() {}
	
	public MemberSubVo(String nickname, String name, Date storedate) {
		this.nickname = nickname;
		this.name = name;
		this.storedate = storedate;
	}

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
	public int getWarnCount() {
		return warnCount;
	}
	public void setWarnCount(int warnCount) {
		this.warnCount = warnCount;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public Date getModdate() {
		return moddate;
	}
	public void setModdate(Date moddate) {
		this.moddate = moddate;
	}
	public Date getStoredate() {
		return storedate;
	}
	public void setStoredate(Date storedate) {
		this.storedate = storedate;
	}
	@Override
	public String toString() {
		return "MemberSubVo [num=" + num + ", nickname=" + nickname + ", name=" + name + ", gender=" + gender
				+ ", warnCount=" + warnCount + ", point=" + point + ", moddate=" + moddate + ", storedate=" + storedate
				+ ", getNum()=" + getNum() + ", getNickname()=" + getNickname() + ", getName()=" + getName()
				+ ", getGender()=" + getGender() + ", getWarnCount()=" + getWarnCount() + ", getPoint()=" + getPoint()
				+ ", getModdate()=" + getModdate() + ", getStoredate()=" + getStoredate() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
