<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@include file="/WEB-INF/views/manager/main/mgrHeader.jsp"%>


<div class="body-info">
	<div class="info-detail">
	<h1 class="info-title">회원정보</h1>
	<c:choose>
		<c:when test="${type eq 'black' }">제적 혹은 탈퇴한 회원  : ${fn:length(memberList) }</c:when>
		<c:otherwise>일반회원 : ${fn:length(memberList) }</c:otherwise>
	</c:choose>
	</div>
	<hr>
	<div class="info-inner">
		<table>
			<caption>
				<form:form action="list.do" commandName="memberList" class="info-search">
					<input class="searchText" type="text" name="nickname" placeholder="회원 닉네임 검색" value="${nickname }">
					<input type="hidden" value="${type}" name="type">
					<input type="submit" value="검색">
				</form:form>
				<form:form action="list.do" class="info-search">
					<input type="hidden" value="normal" name="type">
					<input type="submit" value="일반회원">
				</form:form>
				<form:form action="list.do" class="info-search">
					<input type="hidden" value="black" name="type">
					<input type="submit" value="제적/탈퇴">
				</form:form>
			</caption>
			<thead>
				<tr>
					<td class="table-inner"><b>이메일</b></td>
					<td class="table-inner"><b>닉네임</b></td>
					<c:if test="${type eq 'normal' }">
						<td class="table-inner"><b>가입일자</b></td>
						<td class="table-inner"><b>최근 접속 시간</b></td>
					</c:if>
					<c:if test="${type eq 'black' }">
						<td class="table-inner"><b>경고횟수</b></td>
						<td class="table-inner"><b>탈퇴일자</b></td>
					</c:if>
				</tr>
			</thead>
			<tbody>
				<c:if test="${fn:length(memberList) == 0}">
					<tr>
						<td colspan="4">검색 결과가 존재하지 않습니다.</td>
					</tr>
				</c:if>
				<c:forEach items="${memberList}" var="info">
					<tr>
					<c:if test="${type eq 'normal' }">
						<td>${info.EMAIL}</td>
						<td>${info.NICKNAME}</td>
						<td><fmt:formatDate value="${info.REGDATE}"
								pattern="yyyy-MM-dd" /></td>
						<td>${info.LOGINTIME}</td>
					</c:if>
					<c:if test="${type eq 'black' }">
						<td>${info.EMAIL}</td>
						<td>${info.NICKNAME}</td>
						<td>${info.WARNCOUNT}</td>
						<td><fmt:formatDate value="${info.DROPDATE}"
								pattern="yyyy-MM-dd" /></td>
					</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>



<%@include file="/WEB-INF/views/manager/main/mgrFooter.jsp"%>