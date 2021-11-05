package home.inside.board.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import home.inside.board.repository.IBoardDao;
import home.inside.board.repository.IBoardImageDao;
import home.inside.board.repository.IBoardRefDao;
import home.inside.board.util.ArticleMgrCommand;
import home.inside.board.util.PageSearchCommand;
import home.inside.board.vo.BoardImageVo;
import home.inside.board.vo.BoardRefVo;
import home.inside.board.vo.BoardVo;
import home.inside.common.util.FileUtils;

@Service
public class BoardServiceImpl implements IBoardService {
	@Autowired
	private IBoardDao dao;
	@Autowired
	private IBoardImageDao imageDao;
	@Autowired
	private IBoardRefDao refDao;
	@Autowired
	private FileUtils util;

	@Override
	public void insertBoard(ArticleMgrCommand artCmd, MultipartHttpServletRequest mpReq) throws Exception {
		HashMap<String, Object> hsmima = util.boardFileUpload(mpReq);
		HashMap<String, Object> hsm = new HashMap<String, Object>();
		hsm.put("boardCode", artCmd.getBoardCode());
		hsm.put("nickname", artCmd.getWriter());
		hsm.put("title", artCmd.getTitle());
		hsm.put("content", artCmd.getContent());
		hsm.put("notify", artCmd.getNotify());
		dao.insertArticle(hsm);
	}

	@Override
	public void updateBoard(ArticleMgrCommand artCmd, MultipartHttpServletRequest mpReq) throws Exception {
		// 이미지 등록/삭제 관련 내용 추가 필요
		HashMap<String, Object> hsm = new HashMap<String, Object>();
		hsm.put("num", artCmd.getNum());
		hsm.put("title", artCmd.getTitle());
		hsm.put("content", artCmd.getContent());
		hsm.put("boardCode", artCmd.getBoardCode());
		hsm.put("num", artCmd.getNum());
		dao.updateArticle(hsm);
		String notify = artCmd.getNotify();
		if (notify != null && !notify.equals("no")) {
			hsm.put("notify", notify);
			dao.changeNotify(hsm);
		}
	}

	@Override
	public void deleteBoard(int num) throws Exception {
		dao.deleteArticle(num);
		imageDao.deleteAllArticleImage(num);
		refDao.deleteAllRef(num);
	}

	@Override
	public BoardVo readBoard(int num) throws Exception {
		return dao.readArticle(num);
	}

	@Override
	public List<BoardImageVo> selectListImage(int boardNum) throws Exception {
		return imageDao.selectListArticleImage(boardNum);
	}

	@Override
	public List<BoardRefVo> selectListRef(int boardNum) throws Exception {
		return refDao.selectListRef(boardNum);
	}

	@Override
	public List<HashMap<String, Object>> selectSubList(String type) throws Exception {
		return dao.selectSubList(type);
	}

	@Override
	public void updateHit(int num) throws Exception {
		dao.updateHit(num);
	}

	@Override
	public void updateHeart(int num) throws Exception {
		dao.updateHeart(num);
	}

	@Override
	public List<HashMap<String, Object>> boardList(PageSearchCommand searchCmd) throws Exception {
		HashMap<String, Object> hsm = new HashMap<String, Object>();
		hsm.put("boardCode", searchCmd.getBoardCode());
		hsm.put("startNum", searchCmd.getStartNum());
		hsm.put("endNum", searchCmd.getEndNum());
		String word = searchCmd.getWord();
		if (word == null || word.trim().isEmpty()) {
			return dao.selectListBoard(hsm);
		} else {
			hsm.put("type", searchCmd.getType());
			hsm.put("word", searchCmd.getWord());
			return dao.findListBoard(hsm);
		}
	}

	@Override
	public List<HashMap<String, Object>> boardNotifyList(String boardCode) throws Exception {
		return dao.selectListNotify(boardCode);
	}

	@Override
	public void insertRef(int boardNum, String nickname, String content) throws Exception {
		HashMap<String, Object> hsm = new HashMap<String, Object>();
		hsm.put("boardNum", boardNum);
		hsm.put("nickname", nickname);
		hsm.put("content", content);
		refDao.insertRef(hsm);
	}

	@Override
	public void updateRef(int num, String content) throws Exception {
		HashMap<String, Object> hsm = new HashMap<String, Object>();
		hsm.put("num", num);
		hsm.put("content", content);
		refDao.updateRef(hsm);
	}

	@Override
	public void deleteRef(int num) throws Exception {
		refDao.deleteRef(num);
	}

	@Override
	public List<HashMap<String, Object>> selectMyArticleList(String nickname) throws Exception {
		return dao.selectBoardWhenMember(nickname);
	}

	@Override
	public boolean userIsEqualsToWriter(int num, String nickname) throws Exception {
		String writer = dao.articleWriterCheck(num);
		if(writer!=null && nickname.equals(writer)) {
			return true;
		} else {
			return false;
		}
	}
}
