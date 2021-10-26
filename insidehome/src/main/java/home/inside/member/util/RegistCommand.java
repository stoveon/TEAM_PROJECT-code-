package home.inside.member.util;

public class RegistCommand {
	private String email;
	private String nickname;
	private String password;
	private String passwordCheck;
	private String name;
	private String phone1;
	private String phone2;
	
	public RegistCommand() {}
	
	public RegistCommand(String email, String nickname, String password, String passwordCheck, String name,
			String phone1, String phone2) {
		super();
		this.email = email;
		this.nickname = nickname;
		this.password = password;
		this.passwordCheck = passwordCheck;
		this.name = name;
		this.phone1 = phone1;
		this.phone2 = phone2;
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

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	
	public boolean passwordEqualsToCheck() {
		if(password.equals(passwordCheck)) {
			return true;
		} else {
			return false;
		}
	}
}
