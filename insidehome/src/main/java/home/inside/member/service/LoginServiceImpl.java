package home.inside.member.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.inside.member.repository.IMemberMainDao;

@Service
public class LoginServiceImpl implements ILoginService {
	@Autowired
	private IMemberMainDao mainDao;
	
	@Override
	public HashMap<String, Object> loginOptionCheck(String sessionId) throws Exception {
		return mainDao.selectLoginInfo(sessionId);
	}

	@Override
	public String loginOrIdentifyRequest(String email, String password) throws Exception {
		HashMap<String, Object> hsm = new HashMap<String, Object>();
		hsm.put("email", email);
		hsm.put("password", password);
		return mainDao.selectIsEqualsToInsert(hsm);
	}

	@Override
	public void loginSuccess(String nickname, String sessionId) throws Exception {
		if(sessionId!=null) {
			HashMap<String, Object> hsm = new HashMap<String, Object>();
			hsm.put("nickname", nickname);
			hsm.put("sessionId", sessionId);
			mainDao.updateLoginSuccess(hsm);			
		}
	}

}
