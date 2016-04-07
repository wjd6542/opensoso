<%
/**
 * 
 * @author	강정권
 * @date	2015-10-20
 * @tip		코드관리 화면
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2015-10-27
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
			
			<!-- content -->
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<!-- Tip -->
				<div>
					<div class="dropdown">
						<a class="btn btn-default" href="#" id="side" data-toggle="dropdown"> 가이드 <i class="caret"></i></a>
						<ul class="dropdown-menu" role="side" aria-labelledby="side">
							<li class="guide" contextmenu="Y">
								<a href="#"><i class="fa fa-expand"></i> 가이드 보기</a>
							</li>
							<li class="guide" contextmenu="N">
								<a href="#"><i class="fa fa-compress"></i> 가이드 숨김</a>
							</li>
						</ul>
					</div>
					<div class="tip">
						<div class="panel panel-default">
							<div class="panel-body">
								<div class="panel-title">작성 가이드 팁</div>
								<p class="lead">
								- 환경설정 코드 삽입 가이드 -<br>
								1. 용도에 맞게 코드를 작성한다<br>
								2. Option 용은 코드앞에 O (대문자) 반드시 붙인다<br>
								3. 코드는 기본 5자리를 기본으로 한다<br>
								4. 코맨드, 주석 은 필수다
								</p>
								</div>
						</div>
					</div>
				</div>
			
				<div class="row placeholders">
					<!-- 환경설정 코드 영역 str -->
					<form method="post" id="form1" name="form1" action="">
						<input type="hidden" name="no" id="no" value="">
						<input type="hidden" name="actionType" id="actionType" value="">
						
						<div class="col-xs-12 col-sm-6 placeholder">
							<div class="panel panel-default">
								<div class="panel-heading">
									<div class="panel-title">
										<button type="button" class="btn btn-sm btn-default dropdown-toggle"  data-toggle="modal" data-target="#codeModal">
											<i class="fa fa-check-circle-o"></i> 삽입
										</button>
										<i class="fa fa-cogs"></i> 환경설정 대분류
									</div>
								</div>
								<table class="display wid-100 dataTable">
									<thead>
										<tr>
											<th class="text-center col-xs-6 col-sm-4">코드</th>
											<th class="text-center hidden-xs col-sm-4">설명</th>
											<th class="text-center col-xs-6 col-sm-4">처리</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${codeList}" var="codeList" varStatus="cnt">
									<tr>
										<td class="text-center col-xs-6 col-sm-4">
											${codeList.code}
										</td>
										<td class="hidden-xs col-sm-4">
											${codeList.title}
										</td>
										<td class="col-xs-6 col-sm-4">
											<span class="btn-group">
												<span class="codeSearch btn btn-default" dir="${codeList.code}" data-toggle="tooltip" title="검색">
													<i class="fa fa-search"></i>
												</span>
												<span class="dataShow btn btn-success" dir="${cnt.count}" contextmenu="pcode" data-toggle="tooltip" title="수정">
													<i class="fa fa-check-circle-o"></i>
												</span>
												<span class="del btn btn-danger" dir="${codeList.no}" contextmenu="codeDelete" data-toggle="tooltip" title="삭제">
													<i class="fa fa-check-circle-o"></i>
												</span>
											</span>
											<input type="hidden" id="code_${cnt.count}" value="${codeList.code}">
											<input type="hidden" id="title_${cnt.count}" value="${codeList.code}">
											<input type="hidden" id="memo_${cnt.count}" value="${codeList.memo}">
										</td>
									</tr>
									</c:forEach>
									</tbody>
								</table>
								
							</div>
						</div>
						
						
						<!-- 대분류 코드 모달영역 -->
						<div class="modal fade" id="codeModal">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="exampleModalLabel">대분류 코드</h4>
									</div>
									<div class="modal-body">
										<div class="row">
											<div class="col-xs-12 col-sm-3">
												<label class="check" for="code">코드</label>
											</div>
											<div class="col-xs-7 col-sm-6">
												<input type="text" class="form-control text-left" id="code" name="code">
											</div>
											<div class="col-xs-3 col-sm-3">
												<span class="check btn btn-default" contextmenu="code">중복확인</span>
											</div>
										</div>
										<div class="padding-top-10"></div>
										<div class="row">
											<div class="col-xs-12 col-sm-3">
												<label class="check" for="title">코드명</label>
											</div>
											<div class="col-xs-12 col-sm-9">
												<input type="text" class="form-control" id="title" name="title">
											</div>
										</div>
										<div class="padding-top-10"></div>
										<div class="row">
											<div class="col-xs-12 col-sm-3">
												<label for="memo">설명</label>
											</div>
											<div class="col-xs-12 col-sm-9">
												<textarea class="form-control" id="memo" name="memo" rows="3"></textarea>
											</div>
										</div>
									</div>
									<div class="modal-footer">
										<span class="insert btn btn-primary" contextmenu="codeInsert">
											<i class="fa fa-check-circle-o"></i> 등록
										</span>
										<span class="update btn btn-primary" contextmenu="codeUpdate">
											<i class="fa fa-check-circle-o"></i> 수정
										</span>
									</div>
								</div>
							</div>
						</div>
					</form>
					<!-- 환경설정 코드 영역 end -->
					
					<!-- 환경설정 결과 영역 str -->
					<form method="post" id="form2" name="form2" action="">
						<input type="hidden" name="no" id="no" value="">
						<input type="hidden" name="systemCode" id="systemCode" value="${systemCode}">
						<input type="hidden" name="actionType" id="actionType" value="">
						
						<div class="col-xs-12 col-sm-6 placeholder">
							<div class="panel panel-default">
								<div class="panel-heading">
									<div class="panel-title">
										<button type="button" class="btn btn-sm btn-default dropdown-toggle" contextmenu="cInsert" data-toggle="modal" data-target="#valueModal">
											<i class="fa fa-check-circle-o"></i> 삽입
										</button>
										<i class="fa fa-cogs"></i> 환경설정 소분류
									</div>
								</div>
								<table class="display wid-100 dataTable">
									<thead>
										<tr>
											<th class="text-center hidden-xs">코드</th>
											<th class="text-center hidden-xs">제목</th>
											<th class="text-center">메모</th>
											<th class="text-center">처리</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${valueList}" var="valueList" varStatus="cnt">
									<tr>
										<td class="hidden-xs text-center">
											${valueList.code}
										</td>
										<td class="hidden-xs">
											${valueList.title}
										</td>
										<td>
											${valueList.memo}
										</td>
										<td>
											<span class="btn-group">
												<span class="dataShow btn btn-success" dir="${cnt.count}" contextmenu="ccode" data-toggle="tooltip" title="수정">
													<i class="fa fa-check-circle-o"></i>
												</span>
												<span class="del btn btn-danger" dir="${valueList.no}" contextmenu="codeDelete" data-toggle="tooltip" title="삭제">
													<i class="fa fa-check-circle-o"></i>
												</span>
											</span>
											<input type="hidden" id="code_${cnt.count}" value="${valueList.code}">
											<input type="hidden" id="title_${cnt.count}" value="${valueList.title}">
											<input type="hidden" id="sort_${cnt.count}" value="${valueList.sort}">
											<input type="hidden" id="memo_${cnt.count}" value="${valueList.memo}">
										</td>
									</tr>
									</c:forEach>
									</tbody>
								</table>
								
							</div>
						</div>
						
						<!-- 소분류 코드 모달영역 -->
							<div class="modal fade" id="valueModal">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal" aria-label="Close">
											<span aria-hidden="true">&times;</span></button>
											<h4 class="modal-title" id="exampleModalLabel">소분류 코드</h4>
										</div>
										<div class="modal-body">
											<div class="row">
												<div class="col-xs-12 col-sm-3">
													<label class="check" for="code">코드</label>
												</div>
												<div class="col-xs-7 col-sm-6">
													<input type="text" class="form-control text-left" id="code" name="code">
												</div>
												<div class="col-xs-3 col-sm-3">
													<span class="check btn btn-default" contextmenu="value">중복확인</span>
												</div>
											</div>
											<div class="padding-top-10"></div>
											<div class="row">
												<div class="col-xs-12 col-sm-3">
													<label class="check" for="title">코드명</label>
												</div>
												<div class="col-xs-12 col-sm-9">
													<input type="text" class="form-control" id="title" name="title">
												</div>
											</div>
											<div class="padding-top-10"></div>
											<div class="row">
												<div class="col-xs-12 col-sm-3">
													<label for="ctitle">정렬순서</label>
												</div>
												<div class="col-xs-12 col-sm-9">
													<input type="text" class="form-control" id="sort" name="sort">
												</div>
											</div>
											<div class="padding-top-10"></div>
											<div class="row">
												<div class="col-xs-12 col-sm-3">
													<label for="memo">설명</label>
												</div>
												<div class="col-xs-12 col-sm-9">
													<textarea class="form-control" id="memo" name="memo" rows="3"></textarea>
												</div>
											</div>
										</div>
										<div class="modal-footer">
											<span class="insert btn btn-primary" contextmenu="valueInsert">
												<i class="fa fa-check-circle-o"></i> 등록
											</span>
											<span class="update btn btn-primary" contextmenu="valueUpdate">
												<i class="fa fa-check-circle-o"></i> 수정
											</span>
										</div>
									</div>
								</div>
							</div>
						
					</form>
					<!-- 환경설정 결과 영역 end -->
				</div>
			</div>
			
		</div>
	</div>
</body>
<!-- 스크립트 -->
<script type="text/javascript" src="js/manager/codeManager.js"></script>