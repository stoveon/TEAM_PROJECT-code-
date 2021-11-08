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
	private  FileUtils util;

	@Override
	public void insertBoard(ArticleMgrCommand artCmd, MultipartHttpServletRequest mpReq) throws Exception {
		HashMap<String, Object> hsm = new HashMap<String, Object>();
		hsm.put("boardCode", artCmd.getBoardCode());
		hsm.put("nickname", artCmd.getWriter());
		hsm.put("title", artCmd.getTitle());
		hsm.put("content", artCmd.getContent());
		hsm.put("notify", artCmd.getNotify());
		dao.insertArticle(hsm);
		if(mpReq != null) {
			List<BoardImageVo> boarImaList = util.boardFileUpload(mpReq);
			if(boarImaList.size() > 0) {
				for(BoardImageVo imageVo : boarImaList) {
					imageDao.insertArticleImage(imageVo);				
				}
			}
		}
	}

	@Override
	public void updateBoard(ArticleMgrCommand artCmd, MultipartHttpServletRequest mpReq) throws Exception {
		// 이미지 등록/삭제 관련 내용 추가 필요
		HashMap<String, Object> hsm = new HashMap<String, Object>();
		hsm.put("num", artCmd.getNum());
		hsm.put("title", artCmd.getTitle());
		hsm.put("content", artCmd.getContent());
		hsm.put("boardCode", artCmd.getBoardCode());
		dao.updateArticle(hsm);
		String notify = artCmd.getNotify();
		if (notify != null && !notify.equals("no")) {
			hsm.put("notify", notify);
			dao.changeNotify(hsm);
		}
		if(mpReq != null) {
			List<BoardImageVo> boarImaList = util.boardFileEdit(mpReq);
			if(boarImaList.size() > 0) {
				for(BoardImageVo imageVo : boarImaList) {
					imageVo.setBoardNum(artCmd.getNum());
					imageDao.insertArticleImage(imageVo);				
				}
			}
			String[] deleteFile = util.boardFileDelete(mpReq);
			if(deleteFile!= null) {
				for(String str: deleteFile) {
					imageDao.deleteNotExistImage(str);
				}
			}
		}
	}

	@Override
	public void deleteBoard(int num, String notify) throws Exception {
		dao.deleteArticle(num);
		if (notify != null && notify.equals("no")) {
			imageDao.deleteAllArticleImage(num);
			refDao.deleteAllRef(num);
		}
	}
	
	@Override
	public void deleteNotExistImage(String saveName) throws Exception {
		imageDao.deleteNotExistImage(saveName);
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
	public List<HashMap<String, Object>> selectHeartList() throws Exception {
		return dao.selectHeartList();
	}

	@Override
	public List<HashMap<String, Object>> selectHitList() throws Exception {
		return dao.selectHitList();
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
	public List<HashMap<String, Object>> boardList(String notify, PageSearchCommand searchCmd) throws Exception {
		HashMap<String, Object> hsm = new HashMap<String, Object>();
		hsm.put("boardCode", searchCmd.getBoardCode());
		hsm.put("startNum", searchCmd.getStartNum());
		hsm.put("endNum", searchCmd.getEndNum());
		hsm.put("notify", notify);

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
		hsm.put("writer", nickname);
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
		if (writer != null && nickname.equals(writer)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Integer boardListSize(String boardCode, String type, String word) throws Exception {
		HashMap<String, Object> hsm = new HashMap<String, Object>();
		hsm.put("boardCode", boardCode);
		hsm.put("word", word);
		if (type != null && !type.trim().isEmpty()) {
			hsm.put("type", type);
		}
		return dao.boardSize(hsm);

	}

	@Override
	public Integer notiListSize(String type, String word) throws Exception {
		HashMap<String, Object> hsm = new HashMap<String, Object>();
		hsm.put("type", type);
		hsm.put("word", word);
		return dao.notifySize(hsm);
	}

	@Override
	public HashMap<String, Object> isCheckWriterToUser(int boardNum, int num) throws Exception {
		HashMap<String, Object> hsm = new HashMap<String, Object>();
		hsm.put("boardNum", boardNum);
		hsm.put("num", num);
		return refDao.isCheckWriterToUser(hsm);
	}

}