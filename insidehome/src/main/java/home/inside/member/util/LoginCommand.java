package home.inside.member.util;

public class LoginCommand {
	private String email;
	private String password;
	private String loginOption;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginOption() {
		return loginOption;
	}

	public void setLoginOption(String loginOption) {
		this.loginOption = loginOption;
	}

	@Override
	public String toString() {
		return "LoginCommand [email=" + email + ", password=" + password + ", loginOption=" + loginOption + "]";
	}

}
