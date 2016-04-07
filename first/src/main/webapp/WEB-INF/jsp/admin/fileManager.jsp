<%
/**
 * 
 * @author	강정권
 * @date	2015-10-20
 * @tip		파일관리 화면
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2015-10-20
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
			
			
			<form id="form" name="form" method="post" action="/fileManager.do">
				<input type="hidden" id="pageNo" name="pageNo" value="${pageNo}">
				<input type="hidden" id="no" name="no">
			
				<!-- content -->
				<div class="col-sm-12 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					<div class="row placeholders">
						<div class="col-xs-12 col-sm-10 placeholder">
							<h3>파일관리</h3>
							
							<table class="table table-bordered">
								<tr>
									<td>
										<div class="row">
											<div class="col-sm-8">
												<div class="input-group">
													<div class="input-group-btn hidden-xs">
														<select class="form-control" id="search" name="search">
															<option value="">상세검색</option>
														</select>
													</div>
													<div class="input-group-btn">
														<input type="text" class="form-control" id="searchString" name="searchString" value="${searchString}" data-toggle="tooltip" title="상세검색">
													</div>
													<div class="input-group-btn hidden-xs">
														<input type="text" class="form-control text-center" id="pageSize" name="pageSize" value="${pageSize}" maxlength="3" data-toggle="tooltip" title="rowcnt">
													</div>
													<div class="input-group-btn">
														<span class="search btn btn-default">
															<i class="fa fa-search"></i> 검색
														</span>
													</div>
												</div>
											</div>
											
											<div class="hidden-xs col-sm-4">
												<span class="btn-group">
													<span class="bachDown btn btn-default">
														<i class="fa fa-search"></i> 일괄다운로드
													</span>
													<span class="bachDelete btn btn-default">
														<i class="fa fa-search"></i> 일괄삭제
													</span>
												</span>
											</div>
										</div>
									</td>
								</tr>
								
								<tr>
									<td>
										<div class="row text-center">
											<div class="hidden-xs col-sm-1"><input type="checkbox" id="checkAll" name="checkAll" value="Y"></div>
											<div class="col-xs-12 col-sm-4">원본파일명</div>
											<div class="hidden-xs col-sm-4">파일명</div>
											<div class="hidden-xs col-sm-3">처리</div>
										</div>
									</td>
								</tr>
								
								<c:forEach items="${fileList}" var="list" varStatus="cnt">
								<tr>
									<td>
										<div class="row text-center">
											<div class="hidden-xs col-sm-1"><input type="checkbox" class="check" name="check" value="${list.no}"></div>
											<div class="col-xs-12 col-sm-4">${list.oName}</div>
											<div class="hidden-xs col-sm-4">${list.fileName}</div>
											<div class="hidden-xs col-sm-3">
												<span class="fileDown btn btn-default" contextmenu="${list.no}">
													<i class="fa fa-download"></i> 다운
												</span>
												<span class="delete btn btn-default" dir="${list.oName}" contextmenu="${list.no}">
													<i class="fa fa-times"></i> 삭제 
												</span>
											</div>
										</div>
									</td>
								</tr>
								</c:forEach>
								<c:if test="${fn:length(fileList) == 0}">
								<tr>
									<td>
										<div class="row">
											<div class="text-center">데이터가 없습니다.</div>
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
<script type='text/javascript' src='js/manager/fileManager.js'></script>
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