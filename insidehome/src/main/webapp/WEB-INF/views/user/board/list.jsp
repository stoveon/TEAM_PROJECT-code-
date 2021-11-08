<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>

<div class="body-info">
	<div class="info-detail">
		<c:choose>
			<c:when test="${psCmd.boardCode eq 'info'}">
		    	<c:set var="boardName" value="정보게시판"/>  
			</c:when>
			<c:when test="${psCmd.boardCode eq 'who'}">
		    	<c:set var="boardName" value="익명게시판"/>  
			</c:when>
			<c:otherwise>
		    	<c:set var="boardName" value="공지사항"/>  
			</c:otherwise>
		</c:choose>
			<h1 class="info-title">${boardName }</h1>	
   </div>
	<div class="info-inner">
   <hr>
		<c:if test="${psCmd.boardCode eq 'info' }">
			<ul style="width: 43%; float: left; line-height: 200%; padding-left: 0; margin-left:5%;" >
				<li style="border-bottom: 1px #D5D5D5 solid; background: #E8F6EF; "><b>이번주 인기글</b></li>
				<c:if test="${fn:length(heartList)==0}">
					<li>이번주 인기글이 존재하지 않습니다.</li>
				</c:if>
				<c:set var="heartNum" value="1"/>
				<c:forEach items="${heartList }" var="heart"> 
 					<li style="border-bottom: 1px #D5D5D5 solid; text-align: left; padding-left: 5%;" >
 						<a href="<c:url value="/user/board/read.do?boardNum=${heart.NUM}"/>">[<c:out value="${heartNum}"/>] ${heart.TITLE}</a>
 						<c:set var="heartNum" value="${heartNum+1 }"/>
					</li>
				</c:forEach>
			</ul>
			<ul style=" width: 43%; float: left; line-height: 200%;">
				<li style="border-bottom: 1px #D5D5D5 solid; background: #E8F6EF;"><b>BEST</b></li>
				<c:if test="${fn:length(hitList)==0}">
					<li>이번주 BEST글이 존재하지 않습니다.</li>
				</c:if>
				<c:set var="hitNum" value="1"/>
				<c:forEach items="${hitList }" var="hit"> 
 					<li style="border-bottom: 1px #D5D5D5 solid; text-align: left; padding-left: 5%; ">
 						<a href="<c:url value="/user/board/read.do?boardNum=${hit.NUM}"/>">[<c:out value="${hitNum}"/>] ${hit.TITLE}</a>
 						<c:set var="hitNum" value="${hitNum+1 }"/>
 					</li>
				</c:forEach>
			</ul>
		</c:if>
		<table>
			<caption style="padding-top: 15px;">
				<form action="list.do">
					<select name="type">
						<option value="title" <c:if test="${psCmd.type eq 'title'}">selected</c:if>>제목</option>
						<option value="content"  <c:if test="${psCmd.type eq 'content'}">selected</c:if>>내용</option>
						<option value="double" <c:if test="${psCmd.type eq 'double'}">selected</c:if>>제목+내용</option>
					</select>
					<input class="searchText2" type="text" name="word" value="${psCmd.word }" placeholder="검색할 내용 입력">
					<input style="width: auto; padding: 5px 2% 5px 2%;" type="submit" value="검색">
					<c:if test="${loginInside!=null and psCmd.boardCode ne 'notice' }">
						<input style="width: auto; padding: 5px 2% 5px 2%;" type="button" onclick="location.href='<c:url value="/user/board/registForm.do?boardCode=${psCmd.boardCode} "/>'" value="글작성">
					</c:if>
					<input type="hidden" name="boardCode" value="${psCmd.boardCode}">
				</form>
				<c:if test="${fn:length(boardList)==0 and psCmd.word!=null}">
					<br> 검색 결과가 존재하지 않습니다.
				</c:if>
			</caption>
			<thead>
				<tr>
					<td>글번호</td>
					<td>제목</td>
					<c:if test="${psCmd.boardCode ne 'who' }">
						<td>작성자</td>
					</c:if>
					<td>등록일자</td>
					<td>조회수 </td>
				</tr>
			</thead>
			<tbody>
				<c:if test="${ psCmd.boardCode ne 'notice' }">
					<c:forEach items="${notifyList}" var="noti">
						<tr>
							<td align="center"><b>[공지]</b></td>
							<td  width="50%;" align="left" style="padding-left: 40px;">
								<a href="<c:url value="/board/read/notice.do?boardNum=${noti.NUM}"/>">
									<b>${noti.TITLE}</b>
								</a>
							</td>
							<c:if test="${psCmd.boardCode ne 'who' }">
								<td align="center"><b>관리자</b></td>
							</c:if>
							<td align="center"><b><fmt:formatDate value="${noti.REGDATE}" pattern="yyyy-MM-dd" /></b></td>
							<td align="center"><b>${noti.HIT}</b></td>
						</tr>
					</c:forEach>
				</c:if>
				<c:set var="boardNbr" value="${psCmd.count }"/>
				<c:forEach items="${boardList}" var="article">
					<tr>
						<td align="center">${boardNbr}</td>
						<td  align="left" style="padding-left: 40px;">
							<c:if test="${boardCheck !=null }">
								<c:set var="tmpCode" value="&boardCheck=${boardCheck}"></c:set>
							</c:if>
							<c:if test="${boardName ne '공지사항' }">
								<a href="<c:url value="/user/board/read.do?boardNum=${article.NUM}"/>">
									${article.TITLE} 
									[좋아요 ${article.HEART}]
									<c:if test="${article.CNT ne null}">
										<b>(${article.CNT })</b>
									</c:if>
								</a>
							</c:if>
							<c:if test="${boardName eq '공지사항' }">
								<a href="<c:url value="/board/read/notice.do?boardNum=${article.NUM}${tmpCode}"/>">
									${article.TITLE} 
									[좋아요 ${article.HEART}]
									<c:if test="${article.CNT ne null}">
										<b>(${article.CNT })</b>
									</c:if>
								</a>
							</c:if>
						
						</td>
						<c:if test="${psCmd.boardCode ne 'who' }">
							<td align="center">${article.WRITER}</td>
						</c:if>
						<td align="center"><fmt:formatDate value="${article.REGDATE}" pattern="yyyy-MM-dd" /></td>
						<td align="center">${article.HIT} </td>
					</tr>
					<c:set var="boardNbr" value="${boardNbr-1 }"/>
				</c:forEach>
			</tbody>
		</table>		
	</div>
	
	<br>
	
			<fmt:parseNumber var="pageCount" value="${psCmd.number}" integerOnly="true"/>
			<c:set var="pageBlock" value="${5 }"/>
			
			<fmt:parseNumber var="result" value="${(psCmd.currentPage-1)/pageBlock }" integerOnly="true"/>
			<c:set var="startPage" value="${result*pageBlock + 1 }"></c:set>
			<c:set var="endPage" value="${startPage + pageBlock -1 }"></c:set>
			
			<c:if test="${endPage>pageCount }">
				<c:set var="endPage" value="${pageCount }"/>
			</c:if>
			<c:choose>
				<c:when test="${psCmd.word!=null}">
					<c:set var="options" value="boardCode=${psCmd.boardCode}&type=${psCmd.type}&word=${psCmd.word}&"></c:set>
				</c:when>
				<c:otherwise>
					<c:set var="options" value="boardCode=${psCmd.boardCode}&"></c:set>
				</c:otherwise>
			</c:choose>
			
			<div align="center">
			<c:if test="${startPage>pageBlock }">
				<input type="button" onclick="location.href='list.do?${options}pageNum=${startPage-pageBlock}'" value="◀">
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}" >
				<a href="list.do?${options}pageNum=${i }">[${i }]</a>
			</c:forEach>
			<c:if test="${endPage<pageCount }">
				<input type="button" onclick="location.href='list.do?${options}pageNum=${startPage+pageBlock}'" value="▶">
			</c:if>
			</div>
</div>

<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>