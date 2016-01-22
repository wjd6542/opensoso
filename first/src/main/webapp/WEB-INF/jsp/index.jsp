<%
/**
 * 
 * @author	강정권
 * @date	2015-10-17
 * @tip		메인화면
 * <pre>
 * -------- 수정이력 ----------
 * 수정자	:	강정권
 * 수정일자	:	2015-10-17
 * 수정내용	:	페이지수정
 * ----------------------------
 * </pre>
 */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="/include/top.jsp"/>
<script type="text/javascript">
	$(document).ready(function ()
	{
		var rollingTime = 2500;		// 롤링시간
		var effectTime = 1500;		// 실행시간
		var $rollingImg = $(".mains > div");
		$rollingImg.not(":first").hide();
		setInterval(rolling, rollingTime);
		
		// 롤링 함수
		function rolling(){
			$visbleImg = $rollingImg.filter(":visible");
			$visbleImg.fadeOut(effectTime);
			$nextImg = $visbleImg.next();
			if($nextImg.length === 0)
			{
				$nextImg = $rollingImg.filter(":first");
			}
			$visbleImg.hide();
			$nextImg.fadeIn(effectTime);
		}
	});
</script>

<body>
	<div class="container-fluid">
		<div class="row">
			<!-- 서브메뉴 -->
			<jsp:include page="/include/sideMemu.jsp"/>
			
			<!-- content -->
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row placeholders">
					<!-- 메인이미지 시작 -->
					<div class="panel">
						<div class="mains">
							<div class="col-md-12"><img src="/img/1.jpg" width="100%"></div>
							<div class="col-md-12"><img src="/img/2.jpg" width="100%"></div>
							<div class="col-md-12"><img src="/img/3.jpg" width="100%"></div>
							<div class="col-md-12"><img src="/img/4.jpg" width="100%"></div>
							<div class="col-md-12"><img src="/img/5.jpg" width="100%"></div>
						</div>
					</div>
					<!-- 메인이미지 종료 -->
					
					<div class="col-xs-12 col-sm-6 placeholder">
						<h4 class="sub-header bold">공지게시판</h4>
						<div class="table-responsive">
							<table class="table table-striped">
							<tr>
								<th>작성일</th>
								<th>내용</th>
							</tr>
								
							<c:forEach items="${bulletinList}" var="bulletinList">
							<tr>
								<td>${bulletinList.date}</td>
								<td>${bulletinList.content}</td>
							</tr>
							</c:forEach>
							<c:if test="${fn:length(bulletinList) == 0}">
							<tr>
								<td colspan="2" class="text-center">등록글이 없습니다.</td>
							</tr>
							</c:if>
							</table>
						</div>
					</div>
					<div class="col-xs-12 col-sm-6 placeholder">
						<h4 class="sub-header bold">Q＆A 게시판</h4>
						<div class="table-responsive">
							<table class="table table-striped">
							<tr>
								<th>작성일</th>
								<th>내용</th>
							</tr>
							<c:forEach items="${questionList}" var="questionList">
							<tr>
								<td>${questionList.date}</td>
								<td>${questionList.content}</td>
							</tr>
							</c:forEach>
							<c:if test="${fn:length(bulletinList) == 0}">
							<tr>
								<td colspan="2" class="text-center">등록글이 없습니다.</td>
							</tr>
							</c:if>
							</table>
						</div>
					</div>
					<div class="col-xs-12 col-sm-6 placeholder">
						<h4 class="sub-header bold">소스공유</h4>
						<div class="table-responsive">
							<table class="table table-striped">
							<tr>
								<th>작성일</th>
								<th>내용</th>
							</tr>
							<c:forEach items="${sauceList}" var="sauceList">
							<tr>
								<td>${sauceList.date}</td>
								<td>${sauceList.content}</td>
							</tr>
							</c:forEach>
							<c:if test="${fn:length(bulletinList) == 0}">
							<tr>
								<td colspan="2" class="text-center">등록글이 없습니다.</td>
							</tr>
							</c:if>
							</table>
						</div>
					</div>
					<div class="col-xs-12 col-sm-6 placeholder">
						<h4 class="sub-header bold">커뮤니티</h4>
						<div class="table-responsive">
							<table class="table table-striped">
							<tr>
								<th>작성일</th>
								<th>내용</th>
							</tr>
							<c:forEach items="${communityList}" var="communityList">
							<tr>
								<td>${communityList.date}</td>
								<td>${communityList.content}</td>
							</tr>
							</c:forEach>
							<c:if test="${fn:length(bulletinList) == 0}">
							<tr>
								<td colspan="2" class="text-center">등록글이 없습니다.</td>
							</tr>
							</c:if>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>