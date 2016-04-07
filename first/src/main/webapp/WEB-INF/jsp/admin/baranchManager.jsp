<%
/**
 * 
 * @author	강정권
 * @date	2015-03-03
 * @tip		부서관리 화면
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2015-03-03
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
			
			<form method="post" id="form" action="/baranchManager.do">
				<input type="hidden" name="no" id="no" value="">
				<input type="hidden" name="actionType" id="actionType" value="">
				<input type="hidden" name="grupNo" id="grupNo" value="0">
				<input type="hidden" name="depthNo" id="depthNo" value="1">
				
				
				<div class="col-sm-5 col-sm-offset-3 col-md-5 col-md-offset-2 main">
					<div class="row placeholders">
						<!-- 회원가입 보고서 -->
						<h3>부서관리</h3>
						<table class="table table-bordered">
							<tr>
								<td class="text-right">
									<button type="button" class="view btn btn-sm btn-default">
										<i class="fa fa-check-circle-o"></i> 대분류 삽입
									</button>
								</td>
							</tr>
							<c:forEach items="${branchList}" var="list" varStatus="cnt">
							<tr>
								<td>
									<div class="col-xs-12 col-sm-12">
										<kbd class="view pointer" contextmenu="${list.no}">${list.name}</kbd>
										
										<span class="subIn btn btn-default" contextmenu="${list.no}">
											<i class="fa fa-plus-circle"></i> 
										</span>
									</div>
								</td>
							</tr>
							</c:forEach>
							<c:if test="${fn:length(branchList) == 0}">
							<tr>
								<td class="text-center">데이터가 없습니다.</td>
							</tr>
							</c:if>
								
						</table>
							
					</div>
				</div>
				
				
				
				<!-- 권한 모달영역 str -->
				<div class="modal fade" id="aModal">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span></button>
								<h4 class="modal-title" id="exampleModalLabel">부서 정보</h4>
							</div>
							<div class="modal-body">
								<div class="row">
									<div class="col-xs-12 col-sm-3">
										<label class="check" for="code">부서코드</label>
									</div>
									<div class="col-xs-12 col-sm-9">
										<input type="text" class="form-control" id="code" name="code">
									</div>
								</div>
								<div class="padding-top-10"></div>
								<div class="row">
									<div class="col-xs-12 col-sm-3">
										<label class="check" for="name">부서명</label>
									</div>
									<div class="col-xs-12 col-sm-9">
										<input type="text" class="form-control onlyMoney" id="name" name="name">
									</div>
								</div>
								<div class="padding-top-10"></div>
								<div class="row">
									<div class="col-xs-12 col-sm-3">
										<label class="check" for="sort">정렬순서</label>
									</div>
									<div class="col-xs-12 col-sm-9">
										<input type="text" class="form-control onlyNum" id="sort" name="sort">
									</div>
								</div>
								<div class="padding-top-10"></div>
								<div class="row">
									<div class="col-xs-12 col-sm-3">
										<label class="" for="memo">메모</label>
									</div>
									<div class="col-xs-12 col-sm-9">
										<textarea class="form-control onlyHan" id="memo" rows="3"></textarea>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<span class="delete btn btn-danger">
									<i class="fa fa-times-circle-o"></i> 삭제
								</span>
								<span class="action btn btn-primary" contextmenu="insert">
									<i class="fa fa-check-circle-o"></i> 삽입
								</span>
								<span class="action btn btn-primary" contextmenu="update">
									<i class="fa fa-check-circle-o"></i> 수정
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
<script type='text/javascript' src='js/manager/branchManager.js'></script>