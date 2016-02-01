<%
/**
 * 
 * @author	강정권
 * @date	2015-10-20
 * @tip		게시판 내용 화면
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
			<form id="form" name="form" method="post" action="">
			<input type="hidden" id="borderNo" name="borderNo" value="${border.no}">
			<input type="hidden" id="borderType" name="borderType" value="${borderType}">
			
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
											<kbd class="pointer" data-toggle="tooltip" title="신규">
												<i class="fa fa-star-half-o"></i> NEW
											</kbd>
											&nbsp;
											<kbd class="pointer" data-toggle="tooltip" title="조회수">
												<i class="fa fa-lg fa-eye"></i> ${border.hitCnt}
											</kbd>
											&nbsp;
											<kbd class="pointer" data-toggle="tooltip" title="작성일자">
												<i class="fa fa-calendar"></i> ${border.saveDate}
											</kbd>
											&nbsp;
											<kbd class="pointer" data-toggle="tooltip" title="작성시간">
												<i class="fa fa-clock-o"></i> ${border.saveTime}
											</kbd>
										</div>
									</div>
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
									<td>
										${border.memo}
									</td>
									<td class="text-center valign-bottom">
										<div class="gide">
											<div class="pointer hitUp" contextmenu="goodCntUp" data-toggle="tooltip" title="추천">
												<i class="fa fa-lg fa-thumbs-o-up"></i>
											</div>
											<div class="goodCnt" data-toggle="tooltip" title="추천수">
												<c:choose>
													<c:when test="${border.goodCnt eq ''}">
														0
													</c:when>
													<c:otherwise>
														${border.goodCnt}
													</c:otherwise>
												</c:choose>
											</div>
											<div class="pointer hitDown" contextmenu="goodCntDown" data-toggle="tooltip" title="비추천">
												<i class="fa fa-lg fa-thumbs-o-down"></i>
											</div>
										</div>
										<div class="dropdown">
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
									</td>
								</tr>
								</table>
							</div>
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
				<!-- 권한 모달영역 end -->
				
				
			</form>
		</div>
	</div>
</body>
<!-- 스크립트 -->
<script type='text/javascript' src='js/border/view.js'></script>