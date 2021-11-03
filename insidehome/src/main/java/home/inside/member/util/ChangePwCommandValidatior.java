package home.inside.member.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ChangePwCommandValidatior implements Validator{
	private static final String passwordRegExp = "((?=.*[a-z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).{8,})";
	private Pattern pwPattern;

	public ChangePwCommandValidatior() {
		pwPattern = Pattern.compile(passwordRegExp);
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(ChangePwCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ChangePwCommand cmd = (ChangePwCommand) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
		if(cmd.getNewPassword() == null || cmd.getNewPassword().trim().isEmpty()) {
			errors.rejectValue("newPassword", "required");
		} else {
			Matcher matcher = pwPattern.matcher(cmd.getNewPassword());
			if (!matcher.matches()) {
				errors.rejectValue("newPassword", "bad");
			} else {
				if (!cmd.isEqualsToCheck()) {
					errors.rejectValue("newPassword", "notmatch");
				}
			}
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPasswordCheck", "required");
	}

}
