package home.inside.board.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import home.inside.board.vo.BoardImageVo;

@Repository
public class BoardImageDaoImpl implements IBoardImageDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void insertArticleImage(BoardImageVo imageVo) throws Exception {
		sqlSessionTemplate.insert("insertArticleImage", imageVo);
	}

	@Override
	public void deleteArticleImage(int num) throws Exception {
		sqlSessionTemplate.delete("deleteArticleImage", num);
	}

	@Override
	public void deleteAllArticleImage(int boardNum) throws Exception {
		sqlSessionTemplate.delete("deleteAllArticleImage", boardNum);
	}

	@Override
	public List<BoardImageVo> selectListArticleImage(int num) throws Exception {
		return sqlSessionTemplate.selectList("selectListArticleImage", num);
	}

	@Override
	public void deleteNotExistImage(String saveName) throws Exception {
		sqlSessionTemplate.delete("deleteNotExistImage", saveName);
	}

}
