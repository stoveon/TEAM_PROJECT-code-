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
         <table>
            <tr>
               <td width="20%" bgcolor="#E8F6EF"><b>글 제목</b></td>
               <td><input style="width: 95%; padding : 5px 0 5px 2%;" type="text" placeholder="공지 제목 작성" name="title" required="required"></td>
            </tr>
            
            <tr>
               <td bgcolor="#E8F6EF"><b>글 내용</b></td>
               <td><textarea style="width: 92%; padding : 2% 2% 2% 2%;resize: none; background: white;class="guideContent"  placeholder="글 내용 작성" name="content" required="required"></textarea></td>
            </tr>
            
            
            <tr>
               <td bgcolor="#E8F6EF"><b>게시판 유형</b></td>
               <td align="left">
                  <label><input name="boardCode" type="radio" value="info" name="notify" checked="checked">정보게시판</label>
                  <label><input name="boardCode" type="radio" value="who" name="notify"> 익명게시판</label>
               </td>
            </tr>
            
            <tr>
               <td bgcolor="#E8F6EF"><b>상단표시여부</b></td>
               <td align="left">
                  <label><input type="radio" value="yes" name="notify"  checked="checked" > 상단공지 취소</label>
                  <label><input type="radio" value="notice" name="notify"> 상단공지</label>
               </td>
            </tr>
         </table>
         <input style="margin-top: 15px; padding: 10px 50px 10px 50px; font-size: 20px" type="submit" value="등 록">
      </form>
   </div>
</div>

<%@include file="/WEB-INF/views/manager/main/mgrFooter.jsp"%>
