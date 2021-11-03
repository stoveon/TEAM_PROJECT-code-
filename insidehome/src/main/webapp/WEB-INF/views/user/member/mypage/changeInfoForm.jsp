<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>

<div class="bodyinfo">
	<div class="info-detail">
		<a class="info-title" href="<c:url value="/user/mypage/info/view.do" />">내 정보 관리
			<img class="explain" title="개인정보 확인" src="<c:url value="/resources/img/icon-infoEdit.png"/>">
		</a>
		<a href="<c:url value="/user/mypage/main.do"/>">마이페이지 기본으로 이동</a>
	</div>
	<hr>
	<div class="info-detail">
		<form:form action="update.do" commandName="myInfo">
			<ul class="mypage-info">
				<li class="mypage-info-title">이름</li>
				<li class="mypage-info-content"><form:input path="name" placeholder="${myInfo.name}" readonly="readonly"/></li>
				<li class="mypage-info-title">이메일</li>
				<li class="mypage-info-content"><form:input path="email" placeholder="${myInfo.email}" readonly="readonly"/></li>
				<li class="mypage-info-title">닉네임</li>
				<li class="mypage-info-content"><form:input path="nickname" placeholder="${myInfo.nickname}" readonly="readonly"/></li>
				<li class="mypage-info-title">가입일자</li>
				<li class="mypage-info-content"><form:input path="name" placeholder="${fn:substring(myInfo.regdate,0,10)}" readonly="readonly"/></li>
			</ul>
			<br>
			<ul class="mypage-info">
				<li class="mypage-info-title">전화번호</li>
				<li class="mypage-info-content">
					<c:set var="num1" value="${phone1}"/>
					<form:select path="phone1" class="reg-info-phone1">
						<form:option value="010" label="010" />
						<form:option value="011" label="011" />
						<form:option value="016" label="016" />
						<form:option value="017" label="017" />
						<form:option value="018" label="018" />
						<form:option value="019" label="019" />
					</form:select>
					<form:input path="phone2" class="reg-info-phone2" placeholder="${myInfo.phone2}"/>
					<br>
					<form:errors path="phone2" />
				</li>
				<li class="mypage-info-title">주소</li>
				<li class="mypage-info-content">
					<span id="guide" style="color: #999; display: none"></span>
					<form:input path="addrNum" placeholder="${myInfo.addrNum}"/>
					<form:input path="addr" class="reg-info-label" placeholder="${myInfo.addr}"/>
					<input id="find-addr" type="button" onclick="find_addr();" value="우편번호 찾기"><br>
					<form:input path="addrSub" class="reg-info-label" placeholder="${myInfo.addrSub}"/>
				</li>
				<li class="mypage-info-title">성별</li>
				<li class="mypage-info-content">
					<c:set var="gen" value="${gender}"/>
					<label><form:radiobutton path="gender" value="w"/> 여자</label> &nbsp;
					<label><form:radiobutton path="gender" value="m"/> 남자</label> &nbsp;	
				</li>
				<li class="mypage-info-title">개인정보 유지기간</li>
				<li class="mypage-info-content">
					<label><form:radiobutton path="storedate" value="12"/> 1년</label> &nbsp;&nbsp;&nbsp;
					<label><form:radiobutton path="storedate" value="24"/> 2년</label> &nbsp;
					<label><form:radiobutton path="storedate" value="240" checked="checked"/> 탈퇴시까지</label> &nbsp;
				</li>
			</ul>
			<div style="text-align: center; padding-right: 10%;" >
				<input type="submit" value="     수정완료     " />			
				<input type="button" onclick="location.href='<c:url value="/user/mypage/main.do"/>'" value="     수정취소     " />			
			</div>
		</form:form>
		<hr>
	</div>
</div>


<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>