package home.inside.board.repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import home.inside.board.vo.BoardVo;

@Repository
public class BoardDaoImpl implements IBoardDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void insertArticle(HashMap<String, Object> hsm) throws Exception {
		sqlSessionTemplate.insert("insertArticle", hsm);
	}

	@Override
	public BoardVo readArticle(int num) throws Exception {
		return sqlSessionTemplate.selectOne("readArticle", num);
	}

	@Override
	public void updateArticle(HashMap<String, Object> hsm) throws Exception {
		sqlSessionTemplate.update("updateArticle",hsm);
	}

	@Override
	public void deleteArticle(int num) throws Exception {
		sqlSessionTemplate.delete("deleteArticle", num);
	}

	@Override
	public void updateHit(int num) throws Exception {
		sqlSessionTemplate.update("updateHit",num);

	}

	@Override
	public void updateHeart(int num) throws Exception {
		sqlSessionTemplate.update("updateHeart",num);

	}
	
	@Override
	public void changeNotify(HashMap<String, Object> hsm) throws Exception {
		sqlSessionTemplate.update("changeBoardCode", hsm);
	}

	@Override
	public List<HashMap<String, Object>> selectListNotify(String boardCode) throws Exception {
		return sqlSessionTemplate.selectList("selectListNotify", boardCode);
	}

	@Override
	public List<HashMap<String, Object>> selectListBoard(HashMap<String, Object> hsm) throws Exception {
		return sqlSessionTemplate.selectList("selectListBoard", hsm);
	}

	@Override
	public List<HashMap<String, Object>> findListBoard(HashMap<String, Object> hsm) throws Exception {
		return sqlSessionTemplate.selectList("findListBoard", hsm);
	}

	@Override
	public List<HashMap<String, Object>> selectSubList(String type) throws Exception {
		return sqlSessionTemplate.selectList("selectSubList", type);
	}

	@Override
	public List<HashMap<String, Object>> selectBoardWhenMember(String nickname) throws Exception {
		return sqlSessionTemplate.selectList("selectBoardWhenMember", nickname);
	}

	@Override
	public String articleWriterCheck(int num) throws Exception {
		return sqlSessionTemplate.selectOne("articleWriterCheck", num);
	}


}
