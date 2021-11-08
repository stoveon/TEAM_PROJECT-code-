package home.inside.board.repository;

import java.util.HashMap;
import java.util.List;

import home.inside.board.vo.BoardRefVo;

public interface IBoardRefDao {
	// 댓글 등록 > num, boardNum, writer(nickname), content
	public void insertRef(HashMap<String, Object> hsm) throws Exception;
	// 댓글 수정 > content, num
	public void updateRef(HashMap<String, Object> hsm) throws Exception;
	// 댓글 삭제
	public void deleteRef(int num) throws Exception;
	
	
	// 댓글 전체삭제
	public void deleteAllRef(int boardNum) throws Exception;
	// 댓글 목록 조회
	public List<BoardRefVo> selectListRef(int boardNum) throws Exception;		
	// 댓글작성자와 사용자가 일치하는지 확인
	public HashMap<String, Object> isCheckWriterToUser(HashMap<String, Object> hsm) throws Exception;
}
