<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<title>INSIDE.HOME</title>
<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<style type="text/css">
	table, td, tr{border: 0px solid;}
	td{padding: 5px 0 5px 0;}
	td.info{text-align: right; font: 15px bold; font-family: '24bold'; padding-right: 5%;}
	input[type="text"]{width: 100%;}
	input[type="button"]{width: 48%; font-size: 20px;}
	input:hover[type="button"]{width: 48%; font-size: 20px;}
</style>
</head>
<body  onload='resizeWindow(this)'>
	<div style="padding: 5%;">
		<div class="info-detail">
			<h1 class="info-title">본인인증</h1>
			<p class="info-title-sub">요청하신 페이지는 본인 인증 후 접근할 수 있습니다.</p>
			<hr>
			<form action="#" method="post">
				<table>
					<tr>
						<td class="info">이메일 주소 입력</td>
						<td><input type="text" placeholder="현재 로그인 한 사용자의 이메일 입력"></td>
					</tr>
					<tr>
						<td class="info">비밀번호 입력</td>
						<td><input type="text" placeholder="비밀번호 입력" /></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="button" value="본인인증" onclick="pageMove();"> 
							<input type="button" value="취소" onclick="self.close();">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>