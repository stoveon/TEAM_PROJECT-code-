package home.inside.board.repository;

import java.util.HashMap;
import java.util.List;

import home.inside.board.vo.BoardVo;

public interface IBoardDao {
   // 게시글 등록 > boardCode, writer(nickname), title, content, notify
   public void insertArticle(HashMap<String, Object> hsm) throws Exception;
   // 게시글 내용 조회
   public BoardVo readArticle(int num) throws Exception;
   // 게시글 수정 > title, content, num, boardCode
   public void updateArticle(HashMap<String, Object> hsm) throws Exception;
   // 게시글 삭제
   public void deleteArticle(int num) throws Exception;

   
   // 게시글 조회수 증가
   public void updateHit(int num) throws Exception;
   // 게시글 추천수 증가
   public void updateHeart(int num) throws Exception;
   // 공지글 게시판에 표시여부 변경 > notify, num
   public void changeNotify(HashMap<String, Object> hsm) throws Exception;
   
   
   // 일반 게시글  공지 목록조회(board) 
   public List<HashMap<String, Object>> selectListNotify(String boardCode) throws Exception;
   // 일반 게시글 목록조회(board, boardref) > boardCode, startNum, endNum
   public List<HashMap<String, Object>> selectListBoard(HashMap<String, Object> hsm) throws Exception;
   // 일반 게시글 목록 검색(board, boardref) > boardCode, startNum, endNum, type, type2, word
   public List<HashMap<String, Object>> findListBoard(HashMap<String, Object> hsm) throws Exception;
   // 이달의 추천글, 베스트글 목록(5개)
   public List<HashMap<String, Object>> selectSubList(String type) throws Exception;
   
   /* // 게시글 전체삭제(회원탈퇴)
    * 1. 회원 닉네임에 해당하는 게시글 번호 가져와서 > 회원이 작성한 게시글 번호 조회 필요
    * 2. 그 번호를 for문으로 돌리면서 게시글 삭제  > for문으로 게시글삭제 진행    */
   public List<HashMap<String, Object>> selectBoardWhenMember(String nickname) throws Exception;
   
   // 글수정,삭제 요청 시 본인 게시글인지 확인 : 글번호로 닉네임 조회> num
   public String articleWriterCheck(int num) throws Exception;
   
   // 게시글 갯수 확인 > boardCode
   public Integer boardSize(String boardCode) throws Exception;
   // 공지 갯수 확인
   public Integer notifySize() throws Exception;
      
}
