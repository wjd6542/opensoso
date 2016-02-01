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
			<input type="hidden" id="sysNo" name="sysNo" value="${borderConf.no}">
			<input type="hidden" id="authority" name="authority" value="${borderConf.authority}">
			<input type="hidden" id="borderType" name="borderType" value="${borderType}">
			<input type="hidden" id="actionType" name=actionType value="${actionType}">
			<input type="hidden" id="borderNo" name="borderNo" value="${border.no}">
			<input type="hidden" id="memo" name="memo">
			
				<!-- content str -->
				<div class="col-sm-12 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					<div class="row placeholders">
						<div class="borderArr col-xs-12 col-sm-10 placeholder">
							<div class="panel panel-default">
								<div class="panel-heading">
									<div class="panel-title">
										게시글 작성
									</div>
								</div>
								<div class="addlist list-group">
									<div class="list-group-item">
										<input type="text" class="form-control" name="title" id="title" value="${border.title}" placeholder="제목" data-toggle="tooltip" title="게시글 제목">
									</div>
									<div class="list-group-item">
										<div class="row">
											<div class="col-xs-12 col-sm-4">
												<select class="form-control" id="interest" name="interest">
													<option value="">관심사선택</option>
												</select>
											</div>
											<div class="col-xs-12 col-sm-8 text-right">
												<div class="col-xs-12 hidden-sm">
													<div class="padding-top-10"></div>
												</div>
												<span class="btn-group">
													<span class="fileAdd btn btn-info">
														<i class="fa fa-floppy-o"></i> 파일추가
													</span>
													<span class="${actionType} btn btn-primary" contextmenu="${actionType}">
														<i class="fa fa-check-circle-o"></i> 글 ${btnNm}
													</span>
													<span class="delete btn btn-danger" contextmenu="delete">
														<i class="fa fa-check-circle-o"></i> 글 삭제
													</span>
												</span>
											</div>
											
										</div>
									</div>
									<c:forEach items="${fileList}" var="list" varStatus="cnt">
									<div class="fileList list-group-item">
										<div class="row">
											<div class="col-xs-12 col-sm-12">
												<div class="input-group">
													<input type="text" class="form-control" id="view"  name="view" value="${list.oName}">
													<span class="input-group-btn">
														<span class="fileDelete btn btn-danger" dir="${list.no}" contextmenu="${list.fileName}">
															<i class="fa fa-times-circle-o"></i> 삭제
														</span>
													</span>
												</div>
											</div>
										</div>
									</div>
									</c:forEach>
								</div>
								
								<!-- 게시글 작성영역 -->
								<div id="summernote">${border.memo}</div>
							</div>
						</div>
					</div>
				</div>
				<!-- content end -->
				
				
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
									<div class="col-xs-12 col-sm-12">
										<label for="text">코드내용</label>
									</div>
									<div class="col-xs-12 col-sm-12">
										<textarea class="form-control" id="text" rows="8"></textarea>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<span class="codeAddend btn btn-primary">
									<i class="fa fa-check-circle-o"></i> 코드 추가
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
<script type='text/javascript' src='js/jquery/form.js'></script>
<script type='text/javascript' src='js/border/write.js'></script>
<script type='text/javascript'>
$(document).ready(function ()
{
	$("#interest").append("${interest}");
});
</script>
