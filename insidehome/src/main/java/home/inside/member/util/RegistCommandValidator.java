package home.inside.member.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import home.inside.member.service.IRegistService;

public class RegistCommandValidator implements Validator {
	private static final String emailRegExp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[_A-Za-z0-9-]+(\\.[_A-Za-z0-9]+)*(\\.[_A-Za-z]{2,})$";
	private static final String passwordRegExp = "((?=.*[a-z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).{8,})";
	private static final String phoneRegExp = "^(\\(?\\+?[0-9]*\\)?)?[0-9_\\- \\(\\)]*$";
	private Pattern emailPattern;
	private Pattern pwPattern;
	private Pattern phonePattern;

	public RegistCommandValidator() {
		emailPattern = Pattern.compile(emailRegExp);
		pwPattern = Pattern.compile(passwordRegExp);
		phonePattern = Pattern.compile(phoneRegExp);
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(RegistCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegistCommand regCmd = (RegistCommand) target;
		if (regCmd.getAgree() == null || regCmd.getAgree().trim().isEmpty()) {
			errors.rejectValue("agree", "bad");
		}
		if (regCmd.getEmail() == null || regCmd.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "required");
		} else {
			Matcher matcher = emailPattern.matcher(regCmd.getEmail());
			if (!matcher.matches()) {
				errors.rejectValue("email", "bad");
			}
		}
		if (regCmd.getNickname() == null || regCmd.getNickname().trim().isEmpty()) {
			errors.rejectValue("nickname", "required");
		} else {
			if (regCmd.getNickname().length() < 2) {
				errors.rejectValue("nickname", "bad");
			}
		}
		if (regCmd.getPassword() == null || regCmd.getPassword().trim().isEmpty()) {
			errors.rejectValue("password", "required");
		} else {
			Matcher matcher = pwPattern.matcher(regCmd.getPassword());
			if (!matcher.matches()) {
				errors.rejectValue("password", "bad");
			} else {
				if (!regCmd.passwordEqualsToCheck()) {
					errors.rejectValue("password", "notmatch");
				}
			}
		}
		ValidationUtils.rejectIfEmpty(errors, "name", "required");
		ValidationUtils.rejectIfEmpty(errors, "phone1", "required");
		if(regCmd.getPhone2()==null || regCmd.getPhone2().trim().isEmpty()) {
			errors.rejectValue("phone2", "required");
		} else {
			Matcher matcher = phonePattern.matcher(regCmd.getPhone2());
			if (!matcher.matches() || regCmd.getPhone2().length() < 7) {
				errors.rejectValue("phone2", "bad");
			}
		}
	}
}
