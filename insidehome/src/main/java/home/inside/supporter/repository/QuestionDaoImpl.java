package home.inside.supporter.repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import home.inside.supporter.vo.QuestionVo;

@Repository
public class QuestionDaoImpl implements IQuestionDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void insertQuestion(HashMap<String, Object> hsm) throws Exception {
		sqlSessionTemplate.insert("insertQuestion", hsm);
		
	}

	@Override
	public void updateQuestion(HashMap<String, Object> hsm) throws Exception {
		sqlSessionTemplate.update("updateQuestion", hsm);
	}

	@Override
	public void deleteQuestion(int num) throws Exception {
		sqlSessionTemplate.delete("deleteQuestion", num);
	}

	@Override
	public HashMap<String, Object> selectQuestion(int num) {
		List<HashMap<String, Object>> result = sqlSessionTemplate.selectList("selectQuestion", num);
		return (result==null)?null:result.get(0);
	}
	
	@Override
	public List<HashMap<String, Object>> selectQuestionList() throws Exception {
		return sqlSessionTemplate.selectList("selectQuestionList");
	}

	@Override
	public void updateAsk(HashMap<String, Object> hsm) throws Exception {
		sqlSessionTemplate.update("updateAsk", hsm);
	}

	@Override
	public QuestionVo selectAskDetail(int num) throws Exception {
		List<QuestionVo> result = sqlSessionTemplate.selectList("selectAskDetail", num);
		return (result==null)?null:result.get(0);
	}

	@Override
	public List<QuestionVo> selectMyAsk(String nickname) throws Exception {
		return sqlSessionTemplate.selectList("selectMyAsk",nickname);
	}
	
	@Override
	public List<QuestionVo> selectAskList() throws Exception {
		return sqlSessionTemplate.selectList("selectAskList");
	}


	
}
