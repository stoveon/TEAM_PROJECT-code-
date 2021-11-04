package home.inside.member.service;

import java.util.HashMap;

public interface ILoginService {
	//로그인 옵션 확인(자동로그인)
	public HashMap<String, Object> loginOptionCheck(String email) throws Exception;
	//로그인(본인인증) 정보 확인
	public String loginOrIdentifyRequest(String email, String password) throws Exception;
	//로그인 성공시 업데이트
	public void loginSuccess(String email, String sessionId, String loginOption) throws Exception;
}
