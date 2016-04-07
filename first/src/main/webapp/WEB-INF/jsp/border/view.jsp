<%
/**
 * 
 * @author	강정권
 * @date	2016-03-02
 * @tip		게시판 내용 화면
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
<jsp:useBean id="date" class="java.util.Date" />
<c:set var="userNo" value="${user.no}"/>
<c:set var="toName" value="${user.name}"/>
<c:set var="toId" value="${user.id}"/>
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
			
			
			<form id="form" name="form" method="post" action="">
			<input type="hidden" id="borderNo" name="borderNo" value="${border.no}">
			<input type="hidden" id="borderType" name="borderType" value="${borderType}">
			<input type="hidden" id="rippleUser" name="rippleUser" value="${borderConf.rippleUser}">
			<input type="hidden" id="fileUser" name="fileUser" value="${borderConf.fileUser}">
			
			
			<input type="hidden" id="fromId" name="fromId" value="${userInfo.id}">
			<input type="hidden" id="toId" name="toId" value="${toId}">
			<input type="hidden" id="toName" name="toName" value="${toName}">
			
				<!-- content -->
				<div class="col-sm-12 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					<div class="row placeholders">
						<div class="col-xs-12 col-sm-10 placeholder">
							
							<div class="addlist list-group">
								<div class="list-group-item">
									<div class="row">
										<div class="col-xs-12 col-sm-6">
											<kbd class="pointer" data-toggle="tooltip" title="게시글번호">
												<i class="fa fa-slack"></i> ${border.no}
											</kbd>
										</div>
										<div class="col-xs-12 col-sm-6 text-right">
											<c:if test="${today == border.saveDate}">
											<kbd class="pointer hidden-xs" data-toggle="tooltip" title="신규">
												<i class="fa fa-star-half-o"></i> NEW
											</kbd>
											&nbsp;
											</c:if>
											<kbd class="pointer  hidden-xs" data-toggle="tooltip" title="조회수">
												<i class="fa fa-lg fa-eye"></i> ${border.hitCnt}
											</kbd>
											&nbsp;
											<kbd class="pointer" data-toggle="tooltip" title="작성일자">
												<i class="fa fa-calendar"></i> ${border.saveDate} ${border.saveTime}
											</kbd>
										</div>
									</div>
								</div>
								<div class="list-group-item">
									${userInfo.nickName}
								</div>
								<div class="list-group-item">
									<h4><i class="fa fa-yelp"></i> ${border.title}</h4>
								</div>
								
								<table class="table table-bordered">
								<col width="90%"><col width="10%">
								
								<!-- 파일영역 -->
								<c:forEach items="${fileList}" var="list" varStatus="cnt">
								<tr>
									<td colspan="2">
										<div class="input-group">
											<input type="text" class="form-control" id="view"  name="view" value="${list.oName}" disabled>
											<span class="input-group-btn">
												<span class="fileDown btn btn-info" dir="${list.no}" contextmenu="${list.fileName}">
													<i class="fa fa-lg fa-download"></i> 다운로드
												</span>
											</span>
										</div>
									</td>
								</tr>
								</c:forEach>
								
								<tr>
									<td class="padding-0">
										<div class="col-xs-12 col-sm-10">
											<div style="max-height: 400px; overflow: auto;">
												${border.memo}
											</div>
										</div>
										<div class="col-xs-12 col-sm-2 sideborder">
											<div class="row">
												<div class="gide">
													<div class="col-xs-4 col-sm-12 text-center">
														<div class="pointer hitUp" contextmenu="goodCntUp" data-toggle="tooltip" title="추천">
															<i class="fa fa-lg fa-thumbs-o-up"></i>
														</div>
													</div>
													<div class="col-xs-4 col-sm-12 text-center">
														<div class="goodCnt" data-toggle="tooltip" title="추천수">
															<c:choose>
																<c:when test="${border.goodCnt eq ''}"> 0 </c:when>
																<c:otherwise>
																	${border.goodCnt}
																</c:otherwise>
															</c:choose>
														</div>
													</div>
													<div class="col-xs-4 col-sm-12 text-center">
														<div class="pointer hitDown" contextmenu="goodCntDown" data-toggle="tooltip" title="비추천">
															<i class="fa fa-lg fa-thumbs-o-down"></i>
														</div>
													</div>
												</div>
											</div>
											
											<c:if test="${user.noteStatus == 'Y' and userNo != border.userNo}">
												<div class="padding-5">
													<div class="notebtn btn btn-block btn-default" data-toggle="modal" data-target="#noteModal">
														<i class="fa fa-envelope"></i> 쪽지 발송
													</div>
												</div>
											</c:if>
											
											
											<c:if test="${userNo == border.userNo}">
											<div class="dropdown padding-5">
												<button id="dLabel" class="btn btn-block btn-default" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
													<i class="fa fa-cog"></i> 설정
													<span class="caret"></span>
												</button>
												<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
													<li class="update">
														<a href="#">수정</a>
													</li>
													<li class="secret">
														<a href="#">비공개</a>
													</li>
												</ul>
											</div>
											</c:if>
											
										</div>
									</td>
								</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
				
				
				
				<!-- 코드 모달영역 str -->
				<div class="modal fade" id="aModal">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span></button>
								<h4 class="modal-title" id="exampleModalLabel">코드추가</h4>
							</div>
							<div class="modal-body">
								<div class="row">
									<div class="col-xs-12 col-sm-3">
										<label for="status">코드항목</label>
									</div>
									<div class="col-xs-12 col-sm-9">
										<input>
									</div>
								</div>
							</div>
							
						
							<div class="modal-footer">
								<span class="update btn btn-primary" contextmenu="Update">
									<i class="fa fa-check-circle-o"></i> 수정
								</span>
								<span class="delete btn btn-danger">
									<i class="fa fa-times-circle-o"></i> 닫기
								</span>
							</div>
							
						</div>
					</div>
				</div>
				<!-- 코드 모달영역 end -->
				
				
				
				<!-- 쪽지 몰달 영역 str -->
				<div class="modal fade" id="noteModal">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span></button>
								<h4 class="modal-title">쪽지 발송</h4>
							</div>
							<div class="modal-body">
								<div class="row">
									<div class="col-xs-12 col-sm-3">
										<label for="status">제목</label>
									</div>
									<div class="col-xs-12 col-sm-9">
										<input type="text" class="form-control" id="title" name="title">
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12 col-sm-3">
										<label for="status">내용</label>
									</div>
									<div class="col-xs-12 col-sm-9">
										<textarea class="form-control" id="memo" name="memo" rows="3"></textarea>
									</div>
								</div>
							</div>
						
							<div class="modal-footer">
								<span class="send btn btn-primary" contextmenu="Update">
									<i class="fa fa-check-circle-o"></i> 발송
								</span>
							</div>
							
						</div>
					</div>
				</div>
				<!-- 쪽지 몰달 영역 end -->
				
			</form>
			
		</div>
	</div>
</body>
<!-- 스크립트 -->
<script type='text/javascript' src="js/border/view.js"></script>