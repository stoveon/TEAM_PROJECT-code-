<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>

<div class="body-info">
	<div class="info-detail">
		<a class="info-title" href="<c:url value="/user/mypage/info/view.do" />">내 정보 관리
			<img class="explain" title="개인정보 확인" src="<c:url value="/resources/img/icon-infoEdit.png"/>">
		</a>
		<a href="<c:url value="/user/mypage/main.do"/>">마이페이지 기본으로 이동</a>
	</div>
	<hr>
	<div class="info-detail">
		<form:form action="update.do" commandName="myInfo">
			<table class="regist-info">
					<tbody>
						<tr class="reg-need">
							<td class="reg-need-label">이름</td>
							<td class="reg-need">
								<form:input path="name" value="${myInfo.name}" readonly="true" class="reg-info-label" />
							</td>
						</tr>
						<tr class="reg-need">
							<td class="reg-need-label">이메일</td>
							<td class="reg-need">
								<form:input path="email" value="${myInfo.email}" readonly="true" class="reg-info-label" />
							</td>
						</tr>
						<tr class="reg-need">
							<td class="reg-need-label">닉네임</td>
							<td class="reg-need">
								<form:input path="nickname" value="${myInfo.nickname}" readonly="true" class="reg-info-label" />
							</td>
						</tr>
						<tr class="reg-need">
							<td class="reg-need-label">가입일자</td>
							<td class="reg-need">
								<form:input path="regdate" value="${fn:substring(myInfo.regdate,0,10)}" readonly="true" class="reg-info-label" />
							</td>
						</tr>
					</tbody>
				</table>
				<hr>		
				<table class="regist-info">
					<tbody>
						<tr class="reg-need">
							<td class="reg-need-label">주소</td>
							<td class="reg-need">
								<span id="guide" style="color: #999; display: none"></span> 
								<form:input path="addrNum" placeholder="${myInfo.addrNum}" readonly="true" /> 
								<form:input path="addr" class="reg-info-label" placeholder="${myInfo.addr}" readonly="true" /> 
								<input id="find-addr" type="button" onclick="find_addr();" value="우편번호"><br>
							</td>
						</tr>
						<tr class="reg-need">
							<td class="reg-need-label"></td>
							<td class="reg-need">
								<form:input path="addrSub" class="reg-info-label" placeholder="${myInfo.addrSub}" />
							</td>
						</tr>
						<tr class="reg-need">
							<td class="reg-need-label">개인정보 유지기간</td>
							<td class="reg-need">
								<label><form:radiobutton path="storedate" value="12" /> 1년</label> &nbsp;&nbsp;&nbsp; 
								<label><form:radiobutton path="storedate" value="24" /> 2년</label> &nbsp; 
								<label><form:radiobutton path="storedate" value="240" checked="checked" /> 탈퇴시까지</label> &nbsp;
							</td>
						</tr>
						<tr class="reg-need">
							<td class="reg-need-label">성별</td>
							<td class="reg-need">
								<c:if test="${myInfo.gender eq 'w' }">
									<label><form:radiobutton path="gender" value="w" checked="checked" /> 여자</label> &nbsp; 
									<label><form:radiobutton path="gender" value="m" /> 남자</label> &nbsp;
								</c:if>
								<c:if test="${myInfo.gender eq 'm' }">
									<label><form:radiobutton path="gender" value="w" /> 여자</label> &nbsp; 
									<label><form:radiobutton path="gender" value="m" checked="checked" /> 남자</label> &nbsp;
								</c:if>
							</td>
						</tr>
						<tr class="reg-need">
							<td class="reg-need-label">* 전화번호</td>
							<td class="reg-need">
								<form:select path="${phone1}">
									<form:option value="010" label="010" />
									<form:option value="011" label="011" />
									<form:option value="016" label="016" />
									<form:option value="017" label="017" />
									<form:option value="018" label="018" />
									<form:option value="019" label="019" />
								</form:select> 
								<form:input path="phone2" class="reg-info-phone2" placeholder="${myInfo.phone2}" />
								<form:errors path="phone2" />
							</td>
						</tr>
					</tbody>
				</table>
			<div style="text-align: center; padding-right: 10%;" >
				<input type="submit" value="     수정완료     " />			
				<input type="button" onclick="location.href='<c:url value="/user/mypage/main.do"/>'" value="     수정취소     " />			
			</div>
		</form:form>
		<hr>
	</div>
</div>


<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>