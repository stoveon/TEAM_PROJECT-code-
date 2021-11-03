package home.inside.member.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FindPwCommandValidator implements Validator {
	private static final String emailRegExp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[_A-Za-z0-9-]+(\\.[_A-Za-z0-9]+)*(\\.[_A-Za-z]{2,})$";
	private static final String phoneRegExp = "^(\\(?\\+?[0-9]*\\)?)?[0-9_\\- \\(\\)]*$";

	private Pattern emailPattern;
	private Pattern phonePattern;

	public FindPwCommandValidator() {
		emailPattern = Pattern.compile(emailRegExp);
		phonePattern = Pattern.compile(phoneRegExp);
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(RegistCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		FindPwCommand cmd = (FindPwCommand) target;
		if (cmd.getEmail() == null || cmd.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "required");
		} else {
			Matcher matcher = emailPattern.matcher(cmd.getEmail());
			if (!matcher.matches()) {
				errors.rejectValue("email", "bad");
			}
		}
		if (cmd.getPhone() == null || cmd.getPhone().trim().isEmpty()) {
			errors.rejectValue("phone", "required");
		} else {
			Matcher matcher = phonePattern.matcher(cmd.getPhone());
			if (!matcher.matches()) {
				errors.rejectValue("phone", "bad");
			}
		}

	}
}
