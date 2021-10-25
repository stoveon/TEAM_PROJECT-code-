package home.inside.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// 로그인 하지 않은 상태에서 특정 페이지 요청 시 처리
public class AuthLoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		if(session!=null) {
			Object authLogin = session.getAttribute("loginInside");
			if(authLogin!=null) {
				return true;
			}
		}
		response.sendRedirect(request.getContextPath()+"/main.inside");
		return super.preHandle(request, response, handler);
	}
}
