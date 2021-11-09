package home.inside.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// 현재 로그인한 계정이 관리자 계정이 맞는지 확인
// 관리자 계정이 맞을 경우, 접속을 허용하고 아닐 경우 error 표시
public class AuthManagerInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		if(session!=null) {
			Object authMgr = session.getAttribute("mgrInside");
			if(authMgr!=null) {
				return true;
				
			}
		}
		response.sendRedirect(request.getContextPath()+"/mgr/loginForm.do");
		return false;
	}
}






