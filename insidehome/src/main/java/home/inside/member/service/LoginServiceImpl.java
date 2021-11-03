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
	public HashMap<String, Object> loginOptionCheck(String email) throws Exception {
		return mainDao.selectLoginInfo(email);
	}

	@Override
	public String loginOrIdentifyRequest(String email, String password) throws Exception {
		HashMap<String, Object> hsm = new HashMap<String, Object>();
		hsm.put("email", email);
		hsm.put("password", password);
		return mainDao.selectIsEqualsToInsert(hsm);
	}

	@Override
	public void loginSuccess(String email, String sessionId, String loginOption) throws Exception {
		if(sessionId!=null) {
			HashMap<String, Object> hsm = new HashMap<String, Object>();
			hsm.put("email", email);
			hsm.put("sessionId", sessionId);
			hsm.put("loginOption", loginOption);
			mainDao.updateLoginSuccess(hsm);			
		}
	}

	@Override
	public HashMap<String, Object> loginTmpSuccess(String email) throws Exception {
		return mainDao.tmpLogin(email);
	}

}
