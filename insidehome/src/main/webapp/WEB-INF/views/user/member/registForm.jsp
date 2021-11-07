<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@include file="/WEB-INF/views/user/member/common/commHeader.jsp"%>

<div class="body-info">
	<div class="info-detail">
		<h1 class="info-title">회원가입</h1>
	</div>
	<hr>
	<div class="info-detail">
		<h2>약관동의</h2>
		<p class="info-title-sub">INSIDE.HOME의 홈페이지 이용약관, 개인정보 수집 밎 이용동의에
			동의합니다.</p>
		<div>
			<textarea class="guideContent" rows="10" readonly="readonly">* 홈페이지 이용 약관 동의
INSIDE.HOME 서비스 및 제품(이하 '서비스')을 이용해 주셔서 감사합니다. 본 약관은 다양한 홈페이지 서비스의 이용과 관련하여 서비스를 제공하는 INSIDE.HOME(이하 '인싸')과 이를 이용하는 인싸 회원(이하 '회원') 또는 비회원과의 관계를 설명하며, 아울러 여러분의 인싸 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.

홈페이지 이용 시 아이디(이메일)정보 혹은 비밀번호를 검색하고자 할 경우 회원가입 시 입력한 전화번호를 사용하여 조회할 수 있습니다. 사용 전화번호 변경 후 홈페이지에서 변경하지 않을 경우 이로인해 일어나는 불이익은 인싸에서 책임지지 않습니다.
또한 홈페이지 이용 시 욕설, 비방, 음란, 허위광고 등의 게시물은 타 회원에 의해 신고될 수 있습니다. 신고가 3회 접수될 경우, 적립된 포인트의 일부 차감이 있으며 5회 접수될 경우 회원 접속이 제한됩니다. 이로인해 일어나는 불이익은 인싸에서 책임질 수 없습니다.
인싸에서 판매되는 모든 상품은 별도의 현금/카드 결제 없이 홈페이지 활동으로 제공되는 포인트로 결제하는 상품입니다. 이로 인해 구매한 물품은 환불/취소/변경이 불가하며 구매 시 사용된 포인트는 어떠한 상황으로도 환급이 불가합니다.

* 개인정보 수집 및 이용 동의
개인정보보호법에 따라 인싸에 회원가입 신청하시는 분께 수집하는 개인정보의 항목, 개인정보의 수집 및 이용목적, 개인정보의 보유 및 이용기간, 동의 거부권 및 동의 거부 시 불이익에 관한 사항을 안내 드리오니 자세히 읽은 후 동의하여 주시기 바랍니다.
수집하는 개인정보 : 이용자는 회원가입을 하지 않아도 게시판 목록 조회, 상품 상세조회 등 인싸 서비스를 회원과 동일하게 이용할 수 있습니다. 이용자가 회원제 서비스를 이용하기 위해 회원가입을 할 경우, 인싸는 서비스 이용을 위해 필요한 최소한의 개인정보를 수집합니다.
개인정보 유지 기간을 선택하지 않으실 경우 회원 정보는 회원 탈퇴시까지 유지됩니다. 또한 개인정보 유지 기간을 1년 혹은 2년으로 선택하실 경우 해당 기간이 지나면 필수 입력 정보를 제외한 모든 회원 정보는 삭제됩니다. 필수 입력 정보를 제외한  회원정보 삭제시에도 홈페이지 이용에 대한 제약이 있을 수 있습니다. 유지기간 종료 시 별도의 안내는 제공되지 않습니다.</textarea>
		</div>
	</div>
	<div>
		<form:form action="regist.do" commandName="regCmd">
			<p align="right">
				<label id="reg-agree"> <form:errors path="agree" /> <form:checkbox
						path="agree" value="agree" /> 홈페이지 이용 약관에 동의합니다.
				</label>
			</p>
			<hr>
			<table class="regist-info">
				<caption class="regist-info">
					<h2>필수정보 입력</h2>
					<p class="info-title-sub">회원가입 시 필수 입력사항입니다.</p>
				</caption>
				<tbody>
					<tr class="reg-need">
						<td class="reg-need-label">* 이메일</td>
						<td class="reg-need"><form:input path="emailPart1"
								class="reg-info-label" /> @ <form:select path="emailPart2">
								<form:option value="naver.com" label="  == 선택 ==  " />
								<form:option value="naver.com" label="naver.com" />
								<form:option value="daum.net" label="daum.net" />
								<form:option value="nate.com" label="nate.com" />
								<form:option value="kakao.com" label="kakao.com" />
								<form:option value="gmail.com" label="gmail.com" />
								<form:option value="test.com" label="toto.com" />
							</form:select></td>
					</tr>
					<tr class="reg-need">
						<td class="reg-need-label"></td>
						<form:errors path="emailPart1" />
						<form:errors path="emailPart2" />
						</td>
					</tr>
					<tr class="reg-need">
						<td class="reg-need-label">* 닉네임</td>
						<td class="reg-need">
							<form:input path="nickname" class="reg-info-label" placeholder="2글자 이상 입력" />
							<form:errors path="nickname" /></td>
					</tr>
					<tr class="reg-need">
						<td class="reg-need-label">* 비밀번호</td>
						<td class="reg-need"><form:password path="password"
								class="reg-info-label" placeholder="영문소문자,숫자,특수문자포함 8글자 이상" />
							<form:errors path="password" /></td>
					</tr>
					<tr class="reg-need">
						<td class="reg-need-label">* 비밀번호 확인</td>
						<td class="reg-need"><form:password path="passwordCheck"
								class="reg-info-label" />
							<form:errors path="passwordCheck" /></td>
					</tr>
					<tr class="reg-need">
						<td class="reg-need-label">* 이름</td>
						<td class="reg-need"><form:input path="name"
								class="reg-info-label" />
							<form:errors path="name" /></td>
					</tr>
					<tr class="reg-need">
						<td class="reg-need-label">* 전화번호</td>
						<td class="reg-need"><form:select path="phone1">
								<form:option value="010" label="010" />
								<form:option value="011" label="011" />
								<form:option value="016" label="016" />
								<form:option value="017" label="017" />
								<form:option value="018" label="018" />
								<form:option value="019" label="019" />
							</form:select> <form:input path="phone2" class="reg-info-phone2"
								placeholder="'-' 를 제외한 8자리 숫자입력" />
							<form:errors path="phone2" /></td>
					</tr>
				</tbody>
			</table>
			<hr>
			<table class="regist-info">
				<caption class="regist-info">
					<h2>선택정보 입력</h2>
					<p class="info-title-sub">미입력 시 홈페이지 이용에 제약이 있을 수 있습니다.</p>
				</caption>
				<tbody>
					<tr class="reg-need">
						<td class="reg-need-label">주소</td>
						<td class="reg-need"><span id="guide"
							style="color: #999; display: none"></span> <form:input
								path="addrNum" placeholder="우편번호" readonly="true" /> <form:input
								path="addr" class="reg-info-label" placeholder="주소"
								readonly="true" /> <input id="find-addr" type="button"
							onclick="find_addr();" value="우편번호"><br></td>
					</tr>
					<tr class="reg-need">
						<td class="reg-need-label"></td>
						<td class="reg-need"><form:input path="addrSub"
								class="reg-info-label" placeholder="상세주소" /></td>
					</tr>
					<tr class="reg-need">
						<td class="reg-need-label">개인정보 유지기간</td>
						<td class="reg-need"><label><form:radiobutton
									path="storedate" value="12" /> 1년</label> &nbsp;&nbsp;&nbsp; <label><form:radiobutton
									path="storedate" value="24" /> 2년</label> &nbsp; <label><form:radiobutton
									path="storedate" value="240" checked="checked" /> 탈퇴시까지</label> &nbsp;
						</td>
					</tr>
					<tr class="reg-need">
						<td class="reg-need-label">성별</td>
						<td class="reg-need"><label><form:radiobutton
									path="gender" value="w" checked="checked" /> 여자</label> &nbsp; <label><form:radiobutton
									path="gender" value="m" /> 남자</label> &nbsp;</td>
					</tr>
				</tbody>
			</table>
			<hr>
			<div align="center">
				<input id="save-info" type="submit" value="회원가입">
			</div>
		</form:form>
	</div>
</div>
<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>