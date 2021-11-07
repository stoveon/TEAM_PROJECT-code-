package home.inside.board.repository;

import java.util.List;

import home.inside.board.vo.BoardImageVo;

public interface IBoardImageDao {
	// 게시글 이미지 등록
	public void insertArticleImage(BoardImageVo imageVo) throws Exception;
	// 게시글 이미지 삭제
	public void deleteArticleImage(int num) throws Exception;

	
	// 게시글 이미지 전체삭제(게시글삭제시 boardnum)
	public void deleteAllArticleImage(int boardNum) throws Exception;
	// 게시글 이미지 목록 조회
	public List<BoardImageVo> selectListArticleImage(int num) throws Exception;

	//이미지 파일이 없을 경우 테이블 삭제
		public void deleteNotExistImage(String saveName) throws Exception;
}
