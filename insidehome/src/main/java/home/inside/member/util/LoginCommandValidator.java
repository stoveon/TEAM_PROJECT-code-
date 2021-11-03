package home.inside.member.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class LoginCommandValidator implements Validator{
	private static final String emailRegExp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[_A-Za-z0-9-]+(\\.[_A-Za-z0-9]+)*(\\.[_A-Za-z]{2,})$";
	private Pattern emailPattern;
	
	public LoginCommandValidator() {
		emailPattern = Pattern.compile(emailRegExp);
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(LoginCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		LoginCommand cmd = (LoginCommand) target;
		if(cmd.getEmail() == null || cmd.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "notInput");
		} else {
			Matcher matcher = emailPattern.matcher(cmd.getEmail());
			if(!matcher.matches()) {
				errors.rejectValue("email", "bad");
			} else {
				if(cmd.getPassword() == null || cmd.getPassword().trim().isEmpty()) {
					errors.rejectValue("password", "notInput");
				}
			}
		}
	}
}
