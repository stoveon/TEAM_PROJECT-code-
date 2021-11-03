<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>

<script>
	var result = "<c:out value="${updateResult}"/>";
	if(result == 'fail'){
		alert('비밀번호 변경에 실패하였습니다.');
	}else if(result == 'success'){
		alert('비밀번호 변경에 성공하였습니다.');
	}
</script>


<div class="bodyinfo">
	<div class="info-detail">
		<a class="info-title" href="<c:url value="/user/mypage/info/view.do" />">내 정보 관리
			<img class="explain" title="개인정보 확인" src="<c:url value="/resources/img/icon-infoEdit.png"/>">
		</a>
		<a href="<c:url value="/user/mypage/main.do"/>">마이페이지 기본으로 이동</a>
	</div>
	<hr>
	<div class="info-detail">
		<ul class="mypage-info">
			<li class="mypage-info-title">이름</li>
			<li class="mypage-info-content">${myInfo.name}</li>
			<li class="mypage-info-title">이메일</li>
			<li class="mypage-info-content">${myInfo.email}</li>
			<li class="mypage-info-title">닉네임</li>
			<li class="mypage-info-content">${myInfo.nickname}</li>
			<li class="mypage-info-title">가입일자</li>
			<li class="mypage-info-content">${fn:substring(myInfo.regdate,0,10)} </li>
		</ul>
		<br>
		<ul class="mypage-info">
			<li class="mypage-info-title">전화번호</li>
			<li class="mypage-info-content">${myInfo.phone1} - ${fn:substring(myInfo.phone2,0,4)} - ${fn:substring(myInfo.phone2,4,8)}</li>
			<li class="mypage-info-title">주소</li>
			<li class="mypage-info-content">(${myInfo.addrNum}) ${myInfo.addr} ${myInfo.addrSub}</li>
			<li class="mypage-info-title">성별</li>
			<li class="mypage-info-content">
				<c:if test="${myInfo.gender eq 'w'}">여자</c:if>
				<c:if test="${myInfo.gender eq 'm'}">남자</c:if>
			</li>
			<li class="mypage-info-title">개인정보 유지기간</li>
			<li class="mypage-info-content">~ ${fn:substring(myInfo.storedate,0,10)}</li>
		</ul>
	</div>
	<div class="info-detail">
		<form  style="text-align: center;" action="<c:url value="/user/mypage/info/updateForm.do"/>" method="post">
			<input style="width: 20%; margin-top: 5%;" type="submit" value="개인정보 수정" />			
			<input style="width: 20%;" type="button" onclick="location.href='<c:url value="/user/mypage/changePwForm.do"/>'" value="비밀번호 변경" />			
			<input style="width: 20%;" type="button" onclick="location.href='<c:url value="/user/mypage/info/dropForm.do"/>'" value="회원탈퇴" />			
		</form>
	</div>
</div>

<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>
