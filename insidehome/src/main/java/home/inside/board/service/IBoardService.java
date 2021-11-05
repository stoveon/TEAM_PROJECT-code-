package home.inside.board.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import home.inside.board.util.ArticleMgrCommand;
import home.inside.board.util.PageSearchCommand;
import home.inside.board.vo.BoardImageVo;
import home.inside.board.vo.BoardRefVo;
import home.inside.board.vo.BoardVo;

public interface IBoardService {
	// 게시글 작성 + 이미지등록(dao, image)
	public void insertBoard(ArticleMgrCommand artCmd, MultipartHttpServletRequest mpReq) throws Exception;
	// 게시글 수정 + 이미지등록/삭제 + 공지글 게시판 표시 수정 (dao, image)
	public void updateBoard(ArticleMgrCommand artCmd, MultipartHttpServletRequest mpReq) throws Exception;
	// 게시글 삭제 + 이미지전체삭제 + 댓글전체삭제 (dao, image, ref)
	public void deleteBoard(int num) throws Exception;
	
	//이미지 실제 파일은 없는데 테이블에서는 존재할 경우
	public void deleteNotExistImage(String saveName) throws Exception;
	
	
	// 게시글 상세조회(dao)
	public BoardVo readBoard(int num) throws Exception;
	// 게시글 이미지 목록 조회 (image)
	public List<BoardImageVo> selectListImage(int boardNum) throws Exception;
	// 게시글 댓글 목록 조회 (ref)
	public List<BoardRefVo> selectListRef(int boardNum) throws Exception;
	// 게시글 추천목록, 베스트목록 조회(dao)
	public List<HashMap<String, Object>> selectSubList(String type) throws Exception;
	
	// 조회수증가(dao)
	public void updateHit(int num) throws Exception;
	// 게시글 추천(dao)
	public void updateHeart(int num) throws Exception;

	
	// 게시판 목록 조회 + 게시판 목록검색 (dao)
	public List<HashMap<String, Object>> boardList(PageSearchCommand searchCmd) throws Exception;
	// 게시판 공지조회 (dao)
	public List<HashMap<String, Object>> boardNotifyList(String boardCode) throws Exception;

	

	// 댓글등록(ref)
	public void insertRef(int boardNum, String nickname, String content) throws Exception;
	// 댓글수정(ref)
	public void updateRef(int num, String content) throws Exception;
	// 댓글삭제(ref)
	public void deleteRef(int num) throws Exception;

	// 회원이 작성한 게시글 목록조회 (dao)
	public List<HashMap<String, Object>> selectMyArticleList(String nickname) throws Exception;
	// 로그인한 회원이 작성한 게시글이 맞는지 확인(dao)
	public boolean userIsEqualsToWriter(int num, String nickname) throws Exception;
	
}
