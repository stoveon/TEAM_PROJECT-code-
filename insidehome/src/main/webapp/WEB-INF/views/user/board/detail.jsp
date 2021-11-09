<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>
<% pageContext.setAttribute("replaceChar", "\n");%>
<div class="body-info">
	<c:choose>
		<c:when test="${boardName eq 'info'}">
	    	<c:set var="bName" value="정보게시판"/>  
		</c:when>
		<c:when test="${boardName eq 'who'}">
	    	<c:set var="bName" value="익명게시판"/>  
		</c:when>
		<c:otherwise>
	    	<c:set var="bName" value="공지사항"/>  
		</c:otherwise>
	</c:choose>
	<hr>
	<div class="info-inner">
		<div>
			
		</div>
		<table>
			<thead>
			<tr bgcolor="#E8F6EF" >
				<td align="left" style="padding: 1% 5% 1% 5%; margin-right: 0;" bgcolor="#E8F6EF">
					 TITLE: ${board.title}
				</td>
			</tr>
			</thead>
			<tbody>
				<tr>
					<td align="right"  style="padding: 1% 5% 1% 5%;">
						<fmt:formatDate var="regdate" value="${board.regdate}" pattern="yyyy-MM-dd"/>
						<fmt:formatDate var="moddate" value="${board.moddate}" pattern="yyyy-MM-dd"/>
						작성일 <c:out value="${regdate}"/> 
						<c:if test="${board.moddate != null}" >&nbsp;|&nbsp; 수정일 <c:out value="${moddate}"/></c:if><br>
						<c:if test="${board.boardCode eq 'info' and board.notify eq 'no'}">
							[ ${board.writer} ] &nbsp;|&nbsp; 
						</c:if> 
						<c:if test="${board.notify ne 'no'}">
							[관리자] &nbsp;|&nbsp; 
						</c:if> 
						조회수 <c:out value="${board.hit}"/>
						<c:if test="${not fn:endsWith(board.writer, 'inside')}">
							 &nbsp;|&nbsp; 추천수 <c:out value="${board.heart}"/>
						</c:if>
					</td>
				</tr>
				<tr>
					<td align="right"  style="padding: 1% 5% 1% 5%;">
						<c:if test="${loginInside eq board.writer }">
							<a onclick="location.href='<c:url value="/user/board/updateForm.do/${board.num}"/>'">[수정]</a>
							<a onclick="location.href='<c:url value="/user/board/delete.do/${board.num}"/>'">[삭제]</a>
						</c:if>
						<c:if test="${board.notify eq 'no' and loginInside ne board.writer}">
							<c:if test="${not fn:endsWith(board.writer, 'inside')}">
									<form name="warnForm" style="border: 0px;">
										<input type="hidden" id="warnName" name="warnName" value="${board.writer}" />
										<input type="hidden" id="warnNum" name="warnNum" value="${board.num}" />
									</form>
								<a id="warnbtn" onclick="warnClick(${board.num});">[신고]</a>
								<a onclick="location.href='<c:url value="/user/board/updateHeart.do/${board.num}"/>'">[추천]</a>
							</c:if>
						</c:if>
						
					</td>
				</tr>
				<tr>
					<td colspan="2" align="left"  style="padding: 1% 5% 1% 5%;">${fn:replace(board.content, replaceChar, "<br/>")}</td>
				</tr>
				<tr>
					<c:if test="${fn:length(boardImages) == null}">
					<c:choose>
						<c:when test="${empty boardImages}">
							<c:set var="imagePath" value="/resources/img/noGoods.gif" />		
						</c:when>
					</c:choose>
						<td colspan="2"><img id="bnimg" src="<c:url value="${imagePath}" />"></td>
					</c:if>
					
					<c:if test="${fn:length(boardImages) > 0}">
						<c:forEach items="${boardImages}" var="imageOne" varStatus="status">
						<tr>
							<td colspan="2">
								<img style="width: 100px; height: 100px; display: inline-block; " class="byimg" src="<c:url value="/boardDis?saveName=${imageOne.saveName}" />">
							</td>
						</tr>
						</c:forEach>
					</c:if>
				</tr>
			</tbody>
		</table>
	</div>
	<div style="text-align: right;">
		<hr>
		<button style="padding: 1% 30px 1% 30px; margin-right: 5%;" onclick="location.href='<c:url value="/board/list.do?boardName=${boardName }" />'">
			목&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;록
		</button>
	</div>
<c:if test="${board.notify eq 'no'}">
	<form style="text-align: right;" name="ref-Form" method="post" action="<c:url value="/user/ref/regist.do" />">
		<textarea style="resize: none; margin: 0 5% 0 0;" 
			class="guideContent" name="content" cols="100" rows="3" placeholder="댓글 입력" required="required"></textarea>
		<button style="padding: 1% 30px 1% 30px; margin-right: 5%;"  id="refbtn">등록</button>
		<input type="hidden" name="boardNum" value="${board.num}"/>
	</form>
	
		<c:if test="${boardRefs ne null}">
			<div>
				<div style="margin: 0 5% 0 5%;  border-top: solid 1px #D5D5D5; padding-top: 2%;">
					Comments&nbsp;&nbsp;${fn:length(boardRefs)}
				</div>
				<c:forEach var="oneRef" items="${boardRefs}">
					<div style="margin: 0 5% 0 2%; padding-left: ${2*oneRef.depth}%;">
					<form action="<c:url value="/user/ref/update.do" />" method="post">
						<input type="hidden" name="num" value="${oneRef.num}" />
						<input type="hidden" name="boardNum" value="${board.num}" />
						<table>
							<caption>
								<c:if test="${userName eq oneRef.writer}">
									<input class="ref-save-btn" id="sabtn${oneRef.num}" type="submit" value="저장" disabled/>
									<button id="edbtn${oneRef.num}" type="button" onclick="return btnActive(${oneRef.num})">수정</button>
								</c:if>
								<c:if test="${userName eq oneRef.writer  or userName eq board.writer }">
									<button type="button" onclick="return redelCHK()" value="${oneRef.num+='&boardNum='+=board.num}">삭제</button>
								</c:if>
							</caption>
							<thead style="background: #E8F6EF; font-size: 15px; font-family: '24normal';" >
								<tr>
									<td align="left" style="padding-left: 2%;">작성자: ${oneRef.writer}</td>
									<td align="right" style="padding-right: 2%;">
										<fmt:formatDate var="regdate" value="${oneRef.regdate}" pattern="yyyy-MM-dd"/>
											등록일&nbsp;${regdate}
										<c:if test="${oneRef.moddate != null}">
											<fmt:formatDate var="moddate" value="${oneRef.moddate}" pattern="yyyy-MM-dd"/>
											&nbsp;|&nbsp;수정일&nbsp;${moddate}
										</c:if>
									</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td colspan="2">
										<textarea class="refContent" id="refcon${oneRef.num}" name="content" cols="100" rows="3" disabled>${oneRef.content}</textarea>
									</td>
								</tr>
							</tbody>
						</table>
					</form>
					<form action="<c:url value="/user/ref/register.do" />" id="insert" method="post">
						<input type="hidden" name="boardNum" value="${oneRef.boardNum }" />
						<input type="hidden" name="nickname" value="${oneRef.writer }" />
						<input type="hidden" name="refNum" value="${oneRef.refNum}" />
						<div id="add_reply${oneRef.num}"></div>
					</form>
					</div>
				</c:forEach>
			</div>
		</c:if>
	</c:if>
</div>
<script type="text/javascript" src="<c:url value="/resources/js/boardscript.js" />"></script>
<script type="text/javascript">

	var warn = document.querySelector('#warnbtn');
	warn.addEventListener("click", warnClick);
	
	var heart = document.querySelector('#heartbtn');
	heart.addEventListener("click", heartClick);
	
	var bedit = document.querySelector('#boardedit');
	bedit.addEventListener("click", editCHK);
	
	var bdel = document.querySelector('#boarddel');
	bdel.addEventListener("click", delCHK);

	
var result = "<c:out value="${heartNo}"/>";
if(result == 'fail'){
	alert('추천하실 수 없습니다.');
}


/* function editRef(){
	edit.disabled = false;
} */
/* let edit = document.getElementById("refbtn");
ref = edit.addEventListener("click", function(){
	const reply = () => {
		let renum = event.target.value;
		var name = 'add_reply'+renum;
		alert(name);
	    const box = document.getElementById("reply");
	    box.innerHTML = "<textarea rows='3' style='width: 90%; resize: none;' name='content'></textarea> <input type='submit' value='저장'>";
	}
}
	 */
/* const btn = (obj) => {
	   document.getElementById('insert').submit();
	}
	 */
</script>
<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>