<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>


<div class="body-info">
	<div class="info-detail">
		<h1 class="info-title">회원 고객문의 입력화면</h1>
	</div>
	<hr>
	<div class="info-inner">
		<form action="list.do">
			<div class="move">
				<ul>
					<li>
						<input type="button" value="Q&A" onclick="location.href='/user/supporter/qaList'" /> 
						<input type="button" value="고객문의" onclick="location.herf='/user/supporter/questionList'" /> 
						<input type="button" value="내 문의" onclick="location.herf='/user/supporter/questionDetail'" />
					</li>
					<li><a class="qalist" href="<c:url value="/user/supporter/qaList.do" />">Q&A</a></li>
				</ul>
			</div>
			<h2 class="title">고객문의</h2>
			<table>
				<thead>
					<tr>
						<td>문의 종류</td>
						<td>
							<select id="asktype" name="asktype">
								<option value="none">==선택==</option>
								<option value="회원정보">회원정보</option>
								<option value="게시판 이용">게시판 이용</option>
								<option value="포인트 몰">포인트 몰</option>
								<option value="기타">기타</option>
							</select>
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>제목</td>
						<td><input type="text" name="title" id="title" size="70"  maxlength="30" /></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea name="content" id="content" rows="15" cols="70"></textarea></td>
					</tr>
				</tbody>
			</table>
			<input type="submit" value="등록">
		</form>
	</div>
</div>

<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>