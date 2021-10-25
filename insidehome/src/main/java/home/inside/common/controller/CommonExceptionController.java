package home.inside.common.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;

//공통 에러 처리

@ControllerAdvice("insidehome")
public class CommonExceptionController {

		public String handleException() {
			return "error/commonException";
		}
}
