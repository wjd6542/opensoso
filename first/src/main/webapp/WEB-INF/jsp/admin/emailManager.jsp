<%
/**
 * 
 * @author	강정권
 * @date	2015-10-20
 * @tip		회원관리 화면
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
			
			
			<form id="form" name="form" method="post" action="/emailManager.do">
			<input type="hidden" id="pageNo" name="pageNo" value="${pageNo}">
			<input type="hidden" id="no" name="no" value="">
			
				<!-- content -->
				<div class="col-sm-12 col-sm-offset-3 col-md-11 col-md-offset-2 main">
					<div class="row placeholders">
						<div class="col-xs-12 col-sm-10 placeholder">
						
							<h3>이메일관리</h3>
							
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
										<div class="row text-center">
											<div class="col-xs-6 col-sm-1">구분</div>
											<div class="col-xs-6 col-sm-3">받는메일</div>
											<div class="hidden-xs col-sm-5">내용</div>
											<div class="hidden-xs col-sm-2">발송일자</div>
										</div>
									</td>
								</tr>
								
								<c:forEach items="${list}" var="list" varStatus="cnt">
								<tr>
									<td class="pointer viewInfo" dir="${list.no}">
										<div class="row text-center">
											<div class="col-xs-6 col-sm-1">${list.type}</div>
											<div class="col-xs-6 col-sm-3">${list.toAddr}</div>
											<div class="hidden-xs col-sm-5">${list.memo}</div>
											<div class="hidden-xs col-sm-3">${list.saveDate} ${list.saveTime}</div>
										</div>
									</td>
								</tr>
								</c:forEach>
								<c:if test="${fn:length(list) == 0}">
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
				
				<!-- 권한 모달영역 str -->
				<div class="modal fade" id="aModal">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span></button>
								<h4 class="modal-title" id="exampleModalLabel">메일 발송 정보</h4>
							</div>
							<div class="modal-body">
								<div class="row">
									<div class="col-xs-12 col-sm-3">
										<label class="check" for="type">구분</label>
									</div>
									<div class="col-xs-12 col-sm-9">
										<input type="text" class="form-control" id="type" name="type">
									</div>
								</div>
								<div class="padding-top-10"></div>
								<div class="row">
									<div class="col-xs-12 col-sm-3">
										<label class="check" for="toAddr">받는메일</label>
									</div>
									<div class="col-xs-12 col-sm-9">
										<input type="text" class="form-control" id="toAddr" name="toAddr">
									</div>
								</div>
								<div class="padding-top-10"></div>
								<div class="row">
									<div class="col-xs-12 col-sm-3">
										<label class="check" for="memo">내용</label>
									</div>
									<div class="col-xs-12 col-sm-9">
										<textarea class="form-control" id="memo" name="memo" rows="3"></textarea>
									</div>
								</div>
								
							</div>
							<div class="modal-footer">
								<span class="delete btn btn-danger">
									<i class="fa fa-times-circle-o"></i> 삭제
								</span>
							</div>
						</div>
					</div>
				</div>
				<!-- 권한 모달영역 end -->
				
			</form>
			
		</div>
	</div>
</body>
<!-- 스크립트 -->
<script type='text/javascript' src='js/manager/emailManager.js'></script>
<script type="text/javascript">
$(document).ready(function ()
{
	// 검색
	$(".search").on("click", function(){
		$("#form").attr("action", location.href);
		$("#form").submit();
	});
});
</script>