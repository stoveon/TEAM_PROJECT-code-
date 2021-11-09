package home.inside.supporter.service;

import java.util.HashMap;
import java.util.List;

import home.inside.supporter.vo.QuestionVo;

public interface IQuestionService {
	// 고객문의/QA등록 > askType, nickname, title, content
	public void insertQuestion(String askType, String nickname, String title, String content) throws Exception;

	// QA수정 > title, content
	public void updateQuestion(String askType, String title, String content, int num) throws Exception;

	// QA삭제 > num
	public void deleteQuestion(int num) throws Exception;

	// QA조회(수정 시 기본 내용 확인용)
	public HashMap<String, Object> selectQuestion(int num) throws Exception;

	// QA목록조회 > askType: qa 종류(point, member, other)
	public List<HashMap<String, Object>> questionList() throws Exception;

	// 고객문의 답변 > answer, num
	public void updateAsk(String answer, int num) throws Exception;

	// 고객문의 조회/답변확인(고객문의 답변, 고객이 개인 문의 확인 용)
	public QuestionVo selectAskDetail(int num) throws Exception;

	// 고객문의 목록조회(고객)
	public List<QuestionVo> selectMyAsk(String nickname) throws Exception;

	// 고객문의 목록조회(관리자)
	public List<QuestionVo> selectAskList() throws Exception;
}
