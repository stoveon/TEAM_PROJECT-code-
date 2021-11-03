package home.inside.member.util;

public class ChangePwCommand {
	private String email;
	private String password;
	private String newPassword;
	private String newPasswordCheck;
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
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getNewPasswordCheck() {
		return newPasswordCheck;
	}
	public void setNewPasswordCheck(String newPasswordCheck) {
		this.newPasswordCheck = newPasswordCheck;
	}
	
	public boolean isEqualsToCheck() {
		if(newPassword.equals(newPasswordCheck)) {
			return true;
		} else {
			return false;
		}
	}
}
