<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@include file="/WEB-INF/views/manager/main/mgrHeader.jsp"%>


<div class="body-info">
   <div class="info-detail">
      <h1 class="info-title">관리자 글작성</h1>
   </div>
   <hr>
   <div class="info-inner">
      <form action="<c:url value="/manager/board/regist.do"/>" method="post">
         <table border="1">
            <tr>
               <td><b>글 제목</b></td>
               <td><input style="width: 90%" type="text" placeholder="공지 제목 작성" name="title" required="required"></td>
               <td align="right"><font color="red">관리자</font></td>
            </tr>
            
            <tr>
               <th><b>글 내용</b></th>
               <td><textarea style="resize: none;" class="guideContent"  placeholder="글 내용 작성" name="content" required="required"></textarea></td>
            </tr>
            
            
            <tr>
               <td rowspan="2"><b>게시판 유형</b></td>
               <td>
                  <label><input name="boardCode" type="radio" value="info" name="notify" checked="checked">정보게시판</label>
                  <label><input name="boardCode" type="radio" value="who" name="notify"> 익명게시판</label>
               </td>
            </tr>
            
            <tr>
               <td rowspan="2"><b>상단표시여부</b></td>
               <td>
                  <label><input type="radio" value="yes" name="notify"  checked="checked" > 상단공지 취소</label>
                  <label><input type="radio" value="notice" name="notify"> 상단공지</label>
               </td>
            </tr>
         </table>
         <input type="submit" value="등록">
      </form>
   </div>
</div>

<%@include file="/WEB-INF/views/manager/main/mgrFooter.jsp"%>