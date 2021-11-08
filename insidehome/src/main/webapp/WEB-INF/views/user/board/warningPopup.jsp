<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고창</title>
<script type="text/javascript">
	var warning = document.getquerySelector("#warnSub");
	warning.addEventListener("click", postWarn);
	function postWarn(){
		if(confirm("접수하시겠습니까?") == true){
			opener.document.getElementById("warnName").value = document.getElementById("nickname").value;
			opener.document.getElementById("warnNum").value = document.getElementById("boardNum").value;
			document.warns.submit();
			window.close();
		}else{
			event.preventDefault();
			window.close();
		}
	}
</script>
</head>
<body>
<div style="text-align: center; vertical-align: middle; margin: 0; height: 500px;">
	<div class="info-detail">
		<h1 class="info-title">신고접수</h1>
	</div>
	<hr>
	<div class="info-inner">
		<form name="warns" action="<c:url value="/user/warning/insert.do"/>" method="POST">
		   <input id="nickname" type="text" name="nickname" />
           <input id="boardNum" type="text" name="boardNum" />
				<table>
					<thead>
						<tr>
							<td>신고사유</td>
							<td>
								<select id="warnType" name="warnType">
									<option value="hate">혐오</option>
									<option value="swear">욕설</option>
									<option value="abuse">학대</option>
									<option value="ad">광고</option>
									<option value="lewd">음란</option>
								</select>
							</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>신고 상세 사유</td>
							<td>
								<textarea name="warnWhy" placeholder="최소 20 ~ 최대  300자를  입력해주세요." rows="15" cols="70"></textarea>
							</td>
						</tr>
					</tbody>
				</table>
			<button id="warnSub" type="submit" >신고</button>
		</form>
	</div>
</div>
</body>
</html>