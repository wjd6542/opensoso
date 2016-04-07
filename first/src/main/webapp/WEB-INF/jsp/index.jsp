<%
/**
 * 
 * @author	강정권
 * @date	2015-10-17
 * @tip		메인화면
 * <pre>
 * -------- 수정이력 --------------
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
<!-- 상단 -->
<jsp:include page="/include/top.jsp"/>

<body>
	<div class="container-fluid">
		<div class="row">
			<!-- 사이드 메뉴 -->
			<div class="leftSideMemu">
				<jsp:include page="/include/sideMemu.jsp"/>
			</div>
			
			<form id="form" name="form" method="post" action="">
			<input type="hidden" id="borderType" name="borderType" value="">
			<input type="hidden" id="borderNo" name="borderNo" value="">
			
				<!-- content -->
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					<div class="row placeholders">
						<!-- 메인이미지 시작 -->
						<div class="panel">
							<div class="mains">
								<div class="width-100"><img src="/img/1.jpg" width="100%"></div>
								<div class="width-100"><img src="/img/2.jpg" width="100%"></div>
								<div class="width-100"><img src="/img/3.jpg" width="100%"></div>
								<div class="width-100"><img src="/img/4.jpg" width="100%"></div>
								<div class="width-100"><img src="/img/5.jpg" width="100%"></div>
							</div>
						</div>
						<!-- 메인이미지 종료 -->
						
						<div class="row">
							<div class="col-xs-12 col-sm-6">
								<h4 class="sub-header bold">공지게시판</h4>
								<table class="table table-bordered">
								<c:forEach items="${borderList1}" var="list">
								<tr>
									<td>
										<div class="col-xs-12 col-sm-8 list view" dir="${list.no}" contextmenu="${list.borderType}">
											<div class="row">${list.title}</div>
										</div>
										<div  class="col-xs-12 col-sm-4 text-right">
											<div class="row">${list.saveDate}</div>
										</div>
									</td>
								</tr>
								</c:forEach>
								<c:if test="${fn:length(borderList1) == 0}">
								<tr>
									<td colspan="2" class="text-center">등록글이 없습니다.</td>
								</tr>
								</c:if>
								</table>
							</div>
							<div class="col-xs-12 col-sm-6 placeholder">
								<h4 class="sub-header bold">Q&amp;A 게시판</h4>
								<table class="table table-bordered">
								<c:forEach items="${borderList2}" var="list">
								<tr>
									<td>
										<div class="col-xs-12 col-sm-8 list view" dir="${list.no}" contextmenu="${list.borderType}">
											<div class="row">${list.title}</div>
										</div>
										<div  class="col-xs-12 col-sm-4 text-right">
											<div class="row">${list.saveDate}</div>
										</div>
									</td>
								</tr>
								</c:forEach>
								<c:if test="${fn:length(borderList2) == 0}">
								<tr>
									<td colspan="2" class="text-center">등록글이 없습니다.</td>
								</tr>
								</c:if>
								</table>
							</div>
						</div>
						
						
						<div class="row">
							<div class="col-xs-12 col-sm-6">
								<h4 class="sub-header bold">소스공유</h4>
								<table class="table table-bordered">
								<c:forEach items="${borderList3}" var="list">
								<tr>
									<td>
										<div class="col-xs-12 col-sm-8 list view" dir="${list.no}" contextmenu="${list.borderType}">
											<div class="row">${list.title}</div>
										</div>
										<div  class="col-xs-12 col-sm-4 text-right">
											<div class="row">${list.saveDate}</div>
										</div>
									</td>
								</tr>
								</c:forEach>
								<c:if test="${fn:length(borderList3) == 0}">
								<tr>
									<td colspan="2" class="text-center">등록글이 없습니다.</td>
								</tr>
								</c:if>
								</table>
							</div>
							<div class="col-xs-12 col-sm-6 placeholder">
								<h4 class="sub-header bold">커뮤니티</h4>
								<table class="table table-bordered">
								<c:forEach items="${borderList4}" var="list">
								<tr>
									<td>
										<div class="col-xs-12 col-sm-8 list view" dir="${list.no}" contextmenu="${list.borderType}">
											<div class="row">${list.title}</div>
										</div>
										<div  class="col-xs-12 col-sm-4 text-right">
											<div class="row">${list.saveDate}</div>
										</div>
									</td>
								</tr>
								</c:forEach>
								<c:if test="${fn:length(borderList4) == 0}">
								<tr>
									<td colspan="2" class="text-center">등록글이 없습니다.</td>
								</tr>
								</c:if>
								</table>
							</div>
						</div>
						
						
					</div>
				</div>
				
			</form>
			
			
		</div>
	</div>
</body>
<!-- 스크립트 -->
<script type='text/javascript' src='js/user/index.js'></script>