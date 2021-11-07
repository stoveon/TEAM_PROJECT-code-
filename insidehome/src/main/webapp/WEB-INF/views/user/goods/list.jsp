<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>
<script type="text/javascript">
var selectBoxChange = function(value){
   var type = value;
   window.location.href="<%=request.getContextPath()%>/goods/list.do?type="+ type;
   }
   var result = "<c:out value="${orderRequest}"/>";
   if (result == 'fail') {
      alert('구매하고자 하는 상품의 가격보다 보유 포인트가 부족합니다.');
   }
</script>
<link href="<c:url value="/resources/css/goodsMain.css" />" rel="stylesheet" />


<div class="body-info">
   <div class="info-detail">
      <div class="goods-title3">
         추천상품
         <p class="goods-title3">이런 상품은 어때요?</p>
      <select name="type" onchange="selectBoxChange(this.value);">
         <option value="dateDesc"
            <c:if test="${type eq 'dateDesc'}">selected="selected"</c:if>>최신순</option>
         <option value="priceDesc"
            <c:if test="${type eq 'priceDesc'}">selected="selected"</c:if>>높은 가격순</option>
         <option value="priceAsc"
            <c:if test="${type eq 'priceAsc'}">selected="selected"</c:if>>낮은 가격순</option>
      </select>
      </div>
   </div>
   <hr>


   <table>
      <tbody>
         <c:forEach items="${mainHeart}" var="heartOne" varStatus="status">
            <c:if test="${status.index != 0 and status.index %5 == 0}">
               <tr></tr>
            </c:if>
            <c:if test="${status.index != 0 and status.index %5 != 0}">
               <td class="goods-box">
                  <a href="<c:url value="/goods/detail.do/${heartOne.GOODSCODE}" />">
                     <div class="image-box">
                        <c:choose>
                           <c:when test="${heartOne.SAVENAME == null}">
                              <c:set var="imagePath" value="/resources/img/noGoods.gif" />
                           </c:when>
                           <c:otherwise>
                              <c:set var="imagePath"
                                 value="/display?goodsCode=${heartOne.GOODSCODE}&saveName=${heartOne.SAVENAME}" />
                           </c:otherwise>
                        </c:choose>
                        <img class="image-goods" src="<c:url value="${imagePath}" />" /><br>
                     </div>
                     <div class="goods-txt">
                        <c:choose>
                           <c:when test="${fn:length(heartOne.GOODSNAME) > 12}">
                              <c:set var="gname" value="${fn:substring(heartOne.GOODSNAME,0,12)}..."/>
                           </c:when>
                           <c:otherwise>
                              <c:set var="gname" value="${heartOne.GOODSNAME}"/>
                           </c:otherwise>
                        </c:choose>
                        <b><c:out value="${gname }"/></b><br>
                        <fmt:formatNumber var="price" value="${heartOne.PRICE}" pattern="#,###" />
                        <c:out value="${price += ' point'}"/>
                     </div>
                  </a>
               </td>
            </c:if>
         </c:forEach>
      </tbody>
   </table>

   <br>
   <div class="info-detail">
      <div class="goods-title4">
         상품목록
         <p class="goods-title4">집 밖은 위험합니다. 집에서 놀아요!</p>
      </div>
   </div>
   <hr>

   <table>
      <tbody>
            <tr>
         <c:forEach items="${goodsList}" var="goodsOne" varStatus="status">
         <c:if test="${status.index != 0 and status.index %5 == 0}">
            <tr></tr>
         </c:if>
         <c:if test="${status.index != 0 and status.index %5 != 0}">
            <td class="goods-box2">
            <a href="<c:url value="/goods/detail.do/${goodsOne.GOODSCODE}" />">
               <div class="image-box">
                  <c:choose>
                     <c:when test="${goodsOne.SAVENAME == null}">
                        <c:set var="imagePath" value="/resources/img/noGoods.gif" />
                     </c:when>
                     <c:otherwise>
                        <c:set var="imagePath"
                           value="/display?goodsCode=${goodsOne.GOODSCODE}&saveName=${goodsOne.SAVENAME}" />
                     </c:otherwise>
                  </c:choose>
                  <img class="image-goods" src="<c:url value="${imagePath}" />"
                     alt="<c:out value="${goodsOne.GOODSNAME}" />" /><br>
               </div>
               <div class="goods-txt">
                  <c:choose>
                     <c:when test="${fn:length(goodsOne.GOODSNAME) > 12}">
                        <c:set var="gname" value="${fn:substring(goodsOne.GOODSNAME,0,12)}..."/>
                     </c:when>
                     <c:otherwise>
                        <c:set var="gname" value="${goodsOne.GOODSNAME}"/>
                     </c:otherwise>
                  </c:choose>
                  <b><c:out value="${gname }"/></b><br>
                  <fmt:formatNumber var="price" value="${goodsOne.PRICE}" pattern="#,###" />
                  <c:out value="${price += ' point'}"/>
               </div>
            </a>
            </td>
         </c:if>
         </c:forEach>
         </tr>
      </tbody>
   </table>
</div>

<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>