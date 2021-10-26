package home.inside.member.service;

import java.util.HashMap;

public interface ILoginService {
	public HashMap<String, Object> loginOptionCheck(String sessionId) throws Exception;
	public String loginOrIdentifyRequest(String email, String password) throws Exception;
	public void loginSuccess(String nickname, String sessionId) throws Exception;
}
