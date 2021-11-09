<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고창</title>
<script type="text/javascript">
	function postWarn(){
		if(confirm("접수하시겠습니까?") == true){
		}else{
			event.preventDefault();
			window.close();
		}
	}
</script>
<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"/>
</head>
<body>
<div style="text-align: center; vertical-align: middle; margin: 0; ">
	<div>
		<h1 class="info-title" style="height: 200px;">신고접수</h1>
	</div>
	<hr>
	<div class="info-inner" style="text-align: center;">
		<form style="text-align: center;" name="warns" action="<c:url value="/user/warning/insert.do"/>" method="POST">
           <input id="boardNum" type="hidden" name="boardNum" value="${boardNum}"/>
				<table style="padding: 0;">
					<caption>
						
					</caption>
					<thead>
						<tr>
							<td>신고 상세 사유</td>
							<td align="right" style="padding-right: 20px;">
								<select style="padding: 5px 30px 5px 30px;" id="warnType" name="warnType">
									<option value="hate">혐오</option>
									<option value="swear">욕설</option>
									<option value="lewd">음란</option>
									<option value="ad">광고</option>
								</select>
							</td>	
						</tr>
					</thead>
					<tbody>
						<tr >
							<td colspan="2" align="center">
								<textarea style="resize: none; width: 100%;" name="warnWhy" required="required" placeholder="최소 20 ~ 최대  300자를  입력해주세요." rows="15" cols="70"></textarea>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<button style="width: 20%" id="warnSub" type="submit" onclick="postWarn();" >신고</button>
								<button style="width: 20%" type="button" onclick="window.close();" >취소</button>
							</td>
						</tr>
					</tbody>
				</table>
		</form>
	</div>
</div>
</body>
</html>