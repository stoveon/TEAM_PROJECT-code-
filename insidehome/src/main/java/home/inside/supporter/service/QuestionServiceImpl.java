package home.inside.supporter.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.inside.supporter.repository.IQuestionDao;
import home.inside.supporter.vo.QuestionVo;

@Service
public class QuestionServiceImpl implements IQuestionService {
	@Autowired
	private IQuestionDao dao;

	@Override
	public void insertQuestion(String askType, String nickname, String title, String content) throws Exception {
		HashMap<String, Object> hsm = new HashMap<String, Object>();
		hsm.put("askType", askType);
		hsm.put("nickname", nickname);
		hsm.put("title", title);
		hsm.put("content", content);
		dao.insertQuestion(hsm);
	}

	@Override
	public void updateQuestion(String askType, String title, String content, int num) throws Exception {
		HashMap<String, Object> hsm = new HashMap<String, Object>();
		hsm.put("askType", askType);
		hsm.put("title", title);
		hsm.put("content", content);
		hsm.put("num", num);
		dao.updateQuestion(hsm);
	}

	@Override
	public void deleteQuestion(int num) throws Exception {
		dao.deleteQuestion(num);
	}

	@Override
	public HashMap<String, Object> selectQuestion(int num) throws Exception {
		return dao.selectQuestion(num);
	}
	
	@Override
	public List<HashMap<String, Object>> questionList() throws Exception {
		return dao.selectQuestionList();
	}
	
	@Override
	public void updateAsk(String answer, int num) throws Exception {
		HashMap<String, Object> hsm = new HashMap<String, Object>();
		hsm.put("answer", answer);
		hsm.put("num", num);
		dao.updateAsk(hsm);
	}
	
	@Override
	public QuestionVo selectAskDetail(int num) throws Exception {
		return dao.selectAskDetail(num);
	}

	@Override
	public List<QuestionVo> selectMyAsk(String nickname) throws Exception {
		return dao.selectMyAsk(nickname);
	}



	@Override
	public List<QuestionVo> selectAskList() throws Exception {
		return dao.selectAskList();
	}

}
