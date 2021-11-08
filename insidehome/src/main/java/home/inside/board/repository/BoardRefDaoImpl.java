package home.inside.board.repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import home.inside.board.vo.BoardRefVo;

@Repository
public class BoardRefDaoImpl implements IBoardRefDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void insertRef(HashMap<String, Object> hsm) throws Exception {
		sqlSessionTemplate.insert("insertRef", hsm);
	}

	@Override
	public void updateRef(HashMap<String, Object> hsm) throws Exception {
		sqlSessionTemplate.update("updateRef", hsm);
	}

	@Override
	public void deleteRef(int num) throws Exception {
		sqlSessionTemplate.delete("deleteRef", num);
	}

	@Override
	public void deleteAllRef(int boardNum) throws Exception {
		sqlSessionTemplate.delete("deleteAllRef", boardNum);

	}

	@Override
	public List<BoardRefVo> selectListRef(int boardNum) throws Exception {
		return sqlSessionTemplate.selectList("selectListRef", boardNum);
	}

	@Override
	public HashMap<String, Object> isCheckWriterToUser(HashMap<String, Object> hsm) throws Exception {
		return sqlSessionTemplate.selectOne("isCheckWriterToUser", hsm);
	}

}
