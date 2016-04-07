<%
/**
 * 
 * @author	강정권
 * @date	2015-10-20
 * @tip		접근관리 페이지
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2015-10-20
 * 수정내용	:	페이지수정
 * ----------------------------
 * </pre>
 */
%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
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
			
			<form id="form" name="form" method="post" action="/accessManager.do">
				<input type="hidden" id="pageNo" name="pageNo" value="${pageNo}">
				
				<!-- content -->
				<div class="col-sm-9 col-sm-offset-3 col-md-12 col-md-offset-2 main">
					<div class="row placeholders">
						<div class="col-xs-12 col-sm-10 placeholder">
						
							<h3>접근관리</h3>
							
							<table class="table table-bordered">
								<tr>
									<td>
										<div class="row">
											<div class="col-sm-12">
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
										</div>
									</td>
								</tr>
								
								<tr>
									<td>
										<div class="row">
											<div class="col-xs-6 col-sm-4">접근경로</div>
											<div class="col-xs-6 col-sm-2">접근구분</div>
											<div class="hidden-xs col-sm-3">ip</div>
											<div class="hidden-xs col-sm-3">일자 시간</div>
										</div>
									</td>
								</tr>
								
								<c:forEach items="${accessList}" var="list" varStatus="cnt">
								<tr>
									<td>
										<div class="row">
											<div class="col-xs-6 col-sm-4">${list.path}</div>
											<div class="col-xs-6 col-sm-2">${list.type}</div>
											<div class="hidden-xs col-sm-3">${list.ip}</div>
											<div class="hidden-xs col-sm-3">${list.saveDate} ${list.saveTime}</div>
										</div>
									</td>
								</tr>
								</c:forEach>
								<c:if test="${fn:length(accessList) == 0}">
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
<script type='text/javascript' src='js/manager/accessManager.js'></script>
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