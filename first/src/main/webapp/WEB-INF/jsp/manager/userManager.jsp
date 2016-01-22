<%
/**
 * 
 * @author	강정권
 * @date	2015-10-20
 * @tip		회원관리 화면
 * <pre>
 * -------- 수정이력 ----------
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
			<form id="form" name="form" method="post" action="/userManager.do">
			<input type="hidden" id="pageNo" name="pageNo">
				<!-- content -->
				<div class="col-sm-12 col-sm-offset-3 col-md-12 col-md-offset-2 main">
					<div class="row placeholders">
						<div class="col-xs-12 col-sm-10 placeholder">
							<div class="row">
								<div class="hidden-xs col-sm-10">
									<div class="input-group">
										<div class="input-group-btn">
											<select class="form-control" id="search" name="search">
												<option  value="">상세검색</option>
											</select>
										</div>
										<div class="input-group-btn">
											<input type="text" class="form-control" id="searchString" name="searchString" value="${searchString}" data-toggle="tooltip" title="상세검색">
										</div>
										<div class="input-group-btn">
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
								
							<div class="padding-top-10"></div>
							
							<div class="panel panel-default">
								<div class="panel-heading">
									<i class="fa fa-user fa-lg"></i> 회원관리
								</div>
								<table class="table table-hover">
								<tr>
									<td>
										<div class="row text-center">
											<div class="hidden-xs col-sm-1">번호</div>
											<div class="col-xs-6 col-sm-2">아이디</div>
											<div class="col-xs-6 col-sm-3">이름</div>
											<div class="hidden-xs col-sm-2">생년월일</div>
											<div class="hidden-xs col-sm-2">성별</div>
											<div class="hidden-xs col-sm-2">상태</div>
										</div>
									</td>
								</tr>
								<c:forEach items="${userList}" var="userList" varStatus="cnt">
								<tr>
									<td class="pointer viewInfo" dir="${cnt.count}" data-toggle="tooltip" title="${userList.name} 님 고객 정보">
										<div class="row text-center">
											<div class="hidden-xs col-sm-1">${cnt.count}</div>
											<div class="col-xs-6 col-sm-2">${userList.id}</div>
											<div class="col-xs-6 col-sm-3">${userList.name}</div>
											<div class="hidden-xs col-sm-2">${userList.birthday}</div>
											<div class="hidden-xs col-sm-2">${userList.gender}</div>
											<div class="hidden-xs col-sm-2">${userList.status}</div>
											
											<input type="hidden" id="id_${cnt.count}" value="${userList.id}">
											<input type="hidden" id="name_${cnt.count}" value="${userList.name}">
											<input type="hidden" id="birthday_${cnt.count}" value="${userList.birthday}">
											<input type="hidden" id="gender_${cnt.count}" value="${userList.gender}">
											<input type="hidden" id="status_${cnt.count}" value="${userList.status}">
										</div>
									</td>
								</tr>
								</c:forEach>
								<c:if test="${fn:length(userList) == 0}">
								<tr>
									<td>
										<div class="row">
											<div class="text-center">데이터가 없습니다.</div>
										</div>
									</td>
								</tr>
								</c:if>
								</table>
							</div>
							
							<!-- 페이징 처리 -->
							<jsp:include page="/include/paging.jsp" flush="true" />
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	
	
	<!-- 권한 모달영역 str -->
	<div class="modal fade" id="aModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="exampleModalLabel">회원 상세 정보</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-xs-12 col-sm-3">
							<label class="check" for="id">아이디</label>
						</div>
						<div class="col-xs-12 col-sm-9">
							<input type="text" class="form-control" id="id" name="id">
						</div>
					</div>
					<div class="padding-top-10"></div>
					<div class="row">
						<div class="col-xs-12 col-sm-3">
							<label class="check" for="name">이름</label>
						</div>
						<div class="col-xs-12 col-sm-9">
							<input type="text" class="form-control" id="name" name="name">
						</div>
					</div>
					<div class="padding-top-10"></div>
					<div class="row">
						<div class="col-xs-12 col-sm-3">
							<label class="check" for="birthday">생년월일</label>
						</div>
						<div class="col-xs-12 col-sm-9">
							<input type="text" class="form-control" id="birthday" name="birthday">
						</div>
					</div>
					<div class="padding-top-10"></div>
					<div class="row">
						<div class="col-xs-12 col-sm-3">
							<label for="orders" for="gender">성별</label>
						</div>
						<div class="col-xs-12 col-sm-9">
							<input type="text" class="form-control" id="gender" name="gender">
						</div>
					</div>
					<div class="padding-top-10"></div>
					<div class="row">
						<div class="col-xs-12 col-sm-3">
							<label for="status">상태</label>
						</div>
						<div class="col-xs-12 col-sm-9">
							<input type="text" class="form-control" id="status" name="status">
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<span class="btn btn-danger" data-dismiss="modal">
						<i class="fa fa-times-circle-o"></i> 닫기
					</span>
					<span class="action btn btn-primary" contextmenu="Insert">
						<i class="fa fa-check-circle-o"></i> 등록
					</span>
					<span class="action btn btn-primary" contextmenu="Update">
						<i class="fa fa-check-circle-o"></i> 수정
					</span>
				</div>
			</div>
		</div>
	</div>
	<!-- 권한 모달영역 end -->
	
</body>
<!-- 스크립트 -->
<script type='text/javascript' src='js/manager/userManager.js'></script>
<script type="text/javascript">
$(document).ready(function ()
{
	// select box 생성
	$("#gender").append("${gender}");
	$("#emails").append("${emails}");
	$("#search").append("${search}");
	
	
	// 검색
	$(".search").on("click", function(){
		$("#form").submit();
	});
});
</script>