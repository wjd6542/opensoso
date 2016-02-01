<%
/**
 * 
 * @author	강정권
 * @date	2015-10-20
 * @tip		게시판 리스트 화면
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2015-10-20
 * 수정내용	:	페이지수정
 * ----------------------------
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
			<!-- 서브메뉴 -->
			<jsp:include page="/include/sideMemu.jsp"/>
			<form id="form" name="form" method="post" action="/borderList.do?borderType=${borderType}">
			<input type="hidden" id="pageNo" name="pageNo">
			<input type="hidden" id="no" name="no" value="${borderConf.no}">
			<input type="hidden" id="authority" name="authority" value="${borderConf.authority}">
			<input type="hidden" id="pageNo" name="pageNo" value="${borderConf.no}">
			<input type="hidden" id="borderType" name="borderType" value="${borderType}">
			<input type="hidden" id="borderNo" name="borderNo" value="">
			
				<!-- content -->
				<div class="col-sm-12 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					<div class="row placeholders">
						<div class="col-xs-12 col-sm-10 placeholder">
							<!-- 항목 구분 -->
							<h3>${typeTitle} 리스트</h3>
							
							<table class="table table-bordered">
							<tr>
								<td>
									<div class="col-xs-12 col-sm-10">
										<div class="row">
										<div class="input-group">
											<div class="input-group-btn">
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
									<div class="col-xs-12 col-sm-2 text-right">
										<div class="row">
											<span class="insert btn btn-primary" contextmenu="insert">
												<i class="fa fa-check-circle-o"></i> 등록
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
										<kbd class="pointer" data-toggle="tooltip" title="NEW">
											<i class="fa fa-star-half-o"></i>
										</kbd>
										&nbsp;
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