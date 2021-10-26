package home.inside.member.vo;

public class MemberAddrVo {
	private int num;
	private String nickname;
	private String phone1;
	private String phone2;
	private String addrNum;
	private String addr;
	private String addrSub;
	
	public MemberAddrVo() {}
	
	public MemberAddrVo(String nickname, String phone1, String phone2) {
		this.nickname = nickname;
		this.phone1 = phone1;
		this.phone2 = phone2;
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
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getAddrNum() {
		return addrNum;
	}
	public void setAddrNum(String addrNum) {
		this.addrNum = addrNum;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAddrSub() {
		return addrSub;
	}
	public void setAddrSub(String addrSub) {
		this.addrSub = addrSub;
	}
	@Override
	public String toString() {
		return "MemberAddrVo [num=" + num + ", nickname=" + nickname + ", phone1=" + phone1 + ", phone2=" + phone2
				+ ", addrNum=" + addrNum + ", addr=" + addr + ", addrSub=" + addrSub + "]";
	}
	
	
}
