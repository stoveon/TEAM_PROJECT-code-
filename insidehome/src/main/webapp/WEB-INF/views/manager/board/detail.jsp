<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/views/manager/main/mgrHeader.jsp"%>

<c:if test="${board.notify ne 'no'}">
	<c:set var="tmpName" value="공지사항"/>
</c:if>
<c:if test="${board.boardCode eq 'info'}">
	<c:set var="tmpName" value="정보게시판"/>
</c:if>
	<c:set var="tmpName" value="익명게시판"/>
<c:if test="${board.boardCode eq 'who'}">
</c:if>


<div class="body-info">
   <div class="info-detail">
      <h1 class="info-title">게시글 상세관리</h1>
   </div>
   <hr>
   <div class="info-inner">
         <table>
            <tr>
               <td width="20%" bgcolor="#E8F6EF"><b>글 제목</b></td>
               <td style="border: 1px #E8F6EF solid;">${board.title }</td>
            </tr>
            <tr>
               <td bgcolor="#E8F6EF"><b>글 내용</b></td>
               <td style="border: 1px #E8F6EF solid;">${board.content }</td>
            </tr>
            <tr>
               <td bgcolor="#E8F6EF"><b>작성자</b></td>
               <td style="border: 1px #E8F6EF solid;">${board.writer }</td>
            </tr>
            <tr>
               <td bgcolor="#E8F6EF"><b>게시판 유형</b></td>
               <td style="border: 1px #E8F6EF solid;"> ${tmpName} </td>
            </tr>
         </table>
         <c:if test="${board.notify ne 'no' }">
         	<c:set var="pageUrl" value="/manager/board/list.do?boardCode=${board.notify }"/>
         </c:if>
         <c:if test="${board.notify eq 'no' }">
         	<c:set var="pageUrl" value="/manager/board/list.do?boardCode=${board.boardCode}"/>
         </c:if>
         <div align="left">
	         <input style="margin-top: 15px; padding: 5px 30px 5px 30px; font-size: 20px" type="button"
	         		onclick="location.href='<c:url value="${pageUrl }"/>'" value="목록으로 이동">
			<form style="padding: 0; float: left; text-align: right;" action="<c:url value="/manager/board/delete.do/${board.num}"/>" method="post">
			    <input style="margin-top: 15px; padding: 5px 30px 5px 30px; font-size: 20px" type="submit" value="삭제">
			</form>
			<c:if test="${board.notify ne 'no'}">  
			    <input style="margin-top: 15px; padding: 5px 30px 5px 30px; font-size: 20px" type="button" value="수정" onclick="location.href='<c:url value="/manager/board/updateForm.do/${board.num}"/>'">
			</c:if>
         </div>
   </div>
</div>


<%@include file="/WEB-INF/views/manager/main/mgrFooter.jsp"%>