package home.inside.member.util;

public class RegistCommand {
	private String email;
	private String nickname;
	private String password;
	private String passwordCheck;
	private String name;
	private String phone1;
	private String phone2;
	private String gender;
	private Integer storedate;
	private String addrNum;
	private String addr;
	private String addrSub;
	private String agree;

	public RegistCommand() {
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

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getStoredate() {
		return storedate;
	}

	public void setStoredate(Integer storedate) {
		this.storedate = storedate;
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
	
	public String getAgree() {
		return agree;
	}
	
	public void setAgree(String agree) {
		this.agree = agree;
	}

	public boolean passwordEqualsToCheck() {
		if (password.equals(passwordCheck)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "RegistCommand [email=" + email + ", nickname=" + nickname + ", password=" + password
				+ ", passwordCheck=" + passwordCheck + ", name=" + name + ", phone1=" + phone1 + ", phone2=" + phone2
				+ ", gender=" + gender + ", storedate=" + storedate + ", addrNum=" + addrNum + ", addr=" + addr
				+ ", addrSub=" + addrSub + ", agree=" + agree + "]";
	}
	
	
}
