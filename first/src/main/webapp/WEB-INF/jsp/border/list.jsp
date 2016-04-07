<%
/**
 * 
 * @author	강정권
 * @date	2016-03-02
 * @tip		게시판 리스트 화면
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2016-03-02
 * 수정내용	:	페이지수정
 * ----------------------------
 */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="user" class="shares.vo.UserVo" scope="session" />
<c:set var="authority" value="${user.authority}"/>
<jsp:useBean id="date" class="java.util.Date" />
<fmt:formatDate var="today"  value="${date}" pattern="yyyy-MM-dd" />
<!-- 상단 -->
<jsp:include page="/include/top.jsp"/>

<body>
	<div class="container-fluid">
		<div class="row">
			<!-- 사이드 메뉴 -->
			<div class="leftSideMemu">
				<jsp:include page="/include/sideMemu.jsp"/>
			</div>
			
			
			<form id="form" name="form" method="post" action="/borderList.do?borderType=${borderType}">
			<input type="hidden" id="pageNo" name="pageNo" value="${pageNo}">
			<input type="hidden" id="order" name="order" value="${order}">
			<input type="hidden" id="no" name="no" value="${borderConf.no}">
			<input type="hidden" id="authority" name="authority" value="${borderConf.authority}">
			<input type="hidden" id="borderType" name="borderType" value="${borderType}">
			<input type="hidden" id="borderAuthority" name="borderAuthority" value="${borderConf.authority}">
			<input type="hidden" id="borderNo" name="borderNo" value="">
			
				<!-- content -->
				<div class="col-sm-12 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					<div class="row placeholders">
						<div class="col-xs-12 col-sm-10 placeholder">
							<!-- 항목 구분 -->
							<h3>${typeTitle}</h3>
							
							<div class="padding-5">
								<a href="#" id="bno" class="order label label-info">최신순</a>
								<a href="#" id="saveDate" class="order label label-info">일자순</a>
								<a href="#" id="hitCnt" class="order label label-info">조회순</a>
								<a href="#" id="goodCnt" class="order label label-info">추천순</a>
							</div>
							
							<table class="table table-bordered">
							<tr>
								<td>
									<div class="col-xs-10 col-sm-10">
										<div class="row">
										<div class="input-group">
											<div class="input-group-btn hidden-xs">
												<select class="form-control" id="search" name="search">
													<option value="">상세검색</option>
												</select>
											</div>
											<div class="input-group-btn">
												<input type="text" class="form-control" id="searchString" name="searchString" value="${searchString}" data-toggle="tooltip" title="상세검색">
											</div>
											<div class="input-group-btn">
												<span class="search btn btn-default">
													<i class="fa fa-search"></i> 검색
												</span>
											</div>
										</div>
										</div>
									</div>
									<div class="col-xs-2 col-sm-2 text-right">
										<div class="row">
											<span class="insert userbtn hide btn btn-primary" contextmenu="insert">
												<i class="fa fa-check-circle-o"></i> <span class="hidden-xs">등록</span>
											</span>
										</div>
									</div>
								</td>
							</tr>
							<c:forEach items="${borderList}" var="list" varStatus="cnt">
							<tr class="view pointer" dir="${list.no}">
								<td>
									<div class="col-xs-12 col-sm-8 list">
										<h4><i class="fa fa-yelp"></i> ${list.title}</h4>
									</div>
									<div class="col-xs-12 col-sm-4 text-right">
										<c:if test="${today == list.saveDate}">
										<kbd class="pointer" data-toggle="tooltip" title="NEW">
											<i class="fa fa-star-half-o"></i>
										</kbd>
										&nbsp;
										</c:if>
										<kbd class="pointer" data-toggle="tooltip" title="${list.hitCnt}">
											<i class="fa fa-lg fa-eye"></i>
										</kbd>
										&nbsp;
										<kbd class="pointer" data-toggle="tooltip" title="${list.saveDate}">
											<i class="fa fa-calendar"></i>
										</kbd>
										&nbsp;
										<kbd class="pointer" data-toggle="tooltip" title="${list.saveTime}">
											<i class="fa fa-clock-o"></i>
										</kbd>
									</div>
								</td>
							</tr>
							</c:forEach>
							<c:if test="${fn:length(borderList) == 0}">
							<tr>
								<td>
									<div class="row">
										<div class="text-center">등록글이 없습니다.</div>
									</div>
								</td>
							</tr>
							</c:if>
							</table>
							
							<!-- 페이징 처리 -->
							<jsp:include page="/include/paging.jsp" flush="true" />
						</div>
					</div>
				</div>
				
			</form>
			
		</div>
	</div>
</body>
<!-- 스크립트 -->
<script type='text/javascript' src='js/border/list.js'></script>
<script type="text/javascript">
$(document).ready(function ()
{
	// select box 생성
	$("#search").append("${search}");
	
	// 검색
	$(".search").on("click", function(){
		$("#form").attr("action", location.href);
		$("#form").submit();
	});
});
</script>