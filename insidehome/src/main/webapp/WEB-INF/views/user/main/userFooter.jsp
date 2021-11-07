<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<footer class="foot-outer">
	<div class="logo-area2">
		<h3><a href="<c:url value="/inside/main.do"/>">
				<h2>INSIDE.HOME</h2>
		</a></h3>
	</div>
	<div class="foot-area">
		<ul class="foot-list">
			<li class="foot-info-label"><a class="foot-info-label" href="<c:url value="/inside/intro.do"/>">소개</a></li>
			<li class="foot-info-label"><a class="foot-info-label" href="<c:url value="#"/>">고객센터</a></li>
			<li class="foot-info-label"><a class="foot-info-label" href="<c:url value="/inside/map.do"/>">찾아오는 길</a></li>
		</ul>
		<ul class="foot-list">						
			<li class="foot-label">주소: 서울특별시 종로구 묘동 돈화문로 26 4F</li>
			<li class="foot-label">고객센터: 평일 13:00~18:00까지(공휴일 제외)</li>
			<li class="foot-label">대표번호: 02.1234.5678</li>			
		</ul>
	</div>
</footer>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="<c:url value="/resources/js/addrscript.js" />"></script>

</body>
</html>