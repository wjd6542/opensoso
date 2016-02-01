<%
/**
 * 
 * @author	강정권
 * @date	2015-10-20
 * @tip		게시판 관리 화면
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
			<!-- 서브메뉴 -->
			<jsp:include page="/include/sideMemu.jsp"/>
			<form method="post" id="form" action="">
			<input type="hidden" id="eventType" name="eventType">
			<input type="hidden" id="pageNo" name="pageNo">
			<input type="hidden" id="no" name="no" value="">
			
				<!-- content -->
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					<div class="row placeholders">
						<div class="col-xs-12 col-sm-10 placeholder">
						
							<div class="panel panel-default">
								<div class="panel-heading">
									<div class="panel-title">
										<div class="row">
											<div class="col-xs-6 col-sm-4">
												<i class="fa fa-cogs"></i> 게시판 관리
											</div>
											<div class="text-right col-xs-6 col-sm-8">
												<button type="button" class="insertData btn btn-sm btn-default">
													<i class="fa fa-check-circle-o"></i> 삽입
												</button>
											</div>
										</div>
									</div>
								</div>
								<div class="max-hight-300">
									<table class="table">
									<tr>
										<td class="text-center">
											<div class="col-xs-6 col-sm-3">
												구분
											</div>
											<div class="col-xs-6 col-sm-3">
												권한
											</div>
											<div class="hidden-xs col-sm-3">
												댓글사용
											</div>
											<div class="hidden-xs col-sm-3">
												파일사용
											</div>
										</td>
									</tr>
									<c:forEach items="${borderList}" var="borderList" varStatus="cnt">
									<tr>
										<td class="text-center pointer viewInfo" dir="${borderList.no}" data-toggle="tooltip" title="${borderList.type} 정보">
											<div class="col-xs-6 col-sm-3">
												${borderList.type}
											</div>
											<div class="col-xs-6 col-sm-3">
												${borderList.authority}
											</div>
											<div class="hidden-xs col-sm-3">
												${borderList.rippleUser}
											</div>
											<div class="hidden-xs col-sm-3">
												${borderList.fileUser}
											</div>
										</td>
									</tr>
									</c:forEach>
									<c:if test="${fn:length(borderList) == 0}">
									<tr>
										<td class="text-center">데이터가 없습니다.</td>
									</tr>
									</c:if>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<!-- 소분류 코드 모달영역 -->
				<div class="modal fade" id="aModal">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span></button>
								<h4 class="modal-title" id="exampleModalLabel">권한 설정</h4>
							</div>
							<div class="modal-body">
								<div class="row">
									<div class="col-xs-12 col-sm-3">
										<label class="check" for="title">게시판명</label>
									</div>
									<div class="col-xs-12 col-sm-9">
										<input type="text" class="form-control" id="title" name="title">
									</div>
								</div>
								<div class="padding-top-10"></div>
								<div class="row">
									<div class="col-xs-12 col-sm-3">
										<label class="check" for="type">구분</label>
									</div>
									<div class="col-xs-12 col-sm-9">
										<select class="form-control" id="type" name="type">
											<option value="">게시판구분</option>
										</select>
									</div>
								</div>
								<div class="padding-top-10"></div>
								<div class="row">
									<div class="col-xs-12 col-sm-3">
										<label class="check" for="authority">권한</label>
									</div>
									<div class="col-xs-12 col-sm-9">
										<select class="form-control" id="authority" name="authority">
											<option value="">권한설정</option>
										</select>
									</div>
								</div>
								<div class="padding-top-10"></div>
								<div class="row">
									<div class="col-xs-12 col-sm-3">
										<label class="" for="authority">댓글사용</label>
									</div>
									<div class="col-xs-12 col-sm-9">
										<select class="form-control" id="rippleUser" name="rippleUser">
											<option value="">댓글설정</option>
										</select>
									</div>
								</div>
								<div class="padding-top-10"></div>
								<div class="row">
									<div class="col-xs-12 col-sm-3">
										<label class="" for="fileUser">파일사용</label>
									</div>
									<div class="col-xs-12 col-sm-9">
										<select class="form-control" id="fileUser" name="fileUser">
											<option value="">파일설정</option>
										</select>
									</div>
								</div>
								<div class="padding-top-10"></div>
								<div class="row">
									<div class="col-xs-12 col-sm-3">
										<label for="orders">정렬순서</label>
									</div>
									<div class="col-xs-12 col-sm-9">
										<input type="number" class="form-control" id="sort" name="sort">
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<span class="insert btn btn-primary" contextmenu="insert">
									<i class="fa fa-check-circle-o"></i> 등록
								</span>
								<span class="update btn btn-primary" contextmenu="update">
									<i class="fa fa-check-circle-o"></i> 수정
								</span>
								<span class="delete btn btn-danger" contextmenu="delete">
									<i class="fa fa-times-circle-o"></i> 삭제
								</span>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
<!-- 스크립트 -->
<script type='text/javascript' src='js/manager/borderManager.js'></script>
<script type="text/javascript">
$(document).ready(function ()
{
	// select box 그리기
	$("#type").append("${type}");
	$("#fileUser").append("${fileUser}");
	$("#rippleUser").append("${rippleUser}");
	$("#authority").append("${authority}");
});
</script>