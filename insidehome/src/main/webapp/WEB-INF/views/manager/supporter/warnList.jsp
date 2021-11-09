<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="/WEB-INF/views/manager/main/mgrHeader.jsp"%>
<div id="top-btn"></div>
<div class="body-info">
      <div class="info-detail">
         <h1 class="info-title">신고 접수 목록</h1>(신고수: ${fn:length(warnList)})
      </div>
      <hr>
      <div class="info-inner">
      <table>
         <caption>
			<input style="width: 10%;" type="button" onclick="location.href='<c:url value="/manager/qa/insertForm.do"/>'" value="QA등록">
			<input style="width: 10%;" type="button" onclick="location.href='<c:url value="/manager/ask/list.do"/>'" value="고객문의 관리">
			<input style="width: 10%;" type="button" onclick="location.href='<c:url value="/manager/warning/list.do"/>'" value="신고관리">
		</caption>
		<thead>
            <tr>
               <th>No.</th><th>닉네임</th><th>게시글 제목</th><th>신고유형</th><th>신고날짜</th>
            </tr>
         </thead>
         <tbody>
            <c:forEach items="${warnList}" var="warnOne" varStatus="status">
               <tr style="text-align: center;">
              	 <td><c:out value="${status.count}"/></td>
              	 <td><c:out value="${warnOne.NICKNAME}"/></td>
                 <td>
                 	<a href="<c:url value="/user/board/read.do?boardNum=${warnOne.BOARDNUM}" />">
                 		<c:out value="${warnOne.TITLE}"/>
                 	</a>
                 </td>
                  	<c:if test="${warnOne.WARNTYPE eq 'hate'}">
						<c:set var="warnType" value="혐오"></c:set>
					</c:if>
					<c:if test="${warnOne.WARNTYPE eq 'swear'}">
						<c:set var="warnType" value="욕설"></c:set>
					</c:if>
					<c:if test="${warnOne.WARNTYPE eq 'lewd'}">
						<c:set var="warnType" value="음란"></c:set>
					</c:if>
					<c:if test="${warnOne.WARNTYPE eq 'ad'}">
						<c:set var="warnType" value="광고"></c:set>
					</c:if>
                  <td><c:out value="${warnType}"/></td>
                  <td>
                  	<fmt:formatDate var="time" value="${warnOne.WARNTIME}" pattern="yyyy-MM-dd HH:mm:ss"/>
                  	<c:out value="${time}"/>
                  </td>
               </tr>
            </c:forEach>
         </tbody>
      </table>
      </div>
   <div style="position: fixed; bottom: 15%; right: 5%;">
		<a href="#top-btn">
			<img src="https://img.icons8.com/ultraviolet/50/000000/circled-chevron-up.png"/>
		</a>
	</div>
</div>
<%@include file="/WEB-INF/views/manager/main/mgrFooter.jsp"%>