<%
/**
 * 
 * @author	강정권
 * @date	2016-03-05
 * @tip		활동정보  화면
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2016-03-05
 * 수정내용	:	페이지수정
 * ----------------------------
 */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="user" class="shares.vo.UserVo" scope="session" />
<c:set var="userNo" value="${user.no}"/>
<c:set var="userName" value="${user.name}"/>
<c:set var="userId" value="${user.id}"/>

<body>
	<div class="col-xs-12 col-sm-12 tab-body">
		
		<!-- 쪽지 str -->
		<div class="col-xs-12 col-sm-12 placeholder">
			<h3>쪽지</h3>
			<c:forEach items="${noteList}" var="list">
			
			<c:if test="${list.saveStatus =='R'}">
				<c:set value="bs-callout-success" var="color"/>
			</c:if>
			<c:if test="${list.saveStatus =='N'}">
				<c:set value="bs-callout-warning" var="color"/>
			</c:if>
			
			<c:choose>
				<c:when test="${userId == list.fromId}">
					<c:set value="Y" var="readSet"/>
				</c:when>
				<c:otherwise>
					<c:set value="N" var="readSet"/>
				</c:otherwise>
			</c:choose>
			
			
			
			<div class="row">
				<div class="bs-callout ${color}">
					<div class="row">
						<div class="col-xs-12 col-sm-3">${list.toName}(${list.toId})</div>
						<div class="col-xs-12 col-sm-3">${list.title}</div>
						<div class="col-xs-12 col-sm-3">${list.sendDate} ${list.sendTime}</div>
						<div class="col-xs-12 col-sm-3">
							<span class="readView btn btn-default" contextmenu="${list.no}" role="${readSet}">
								<i class="fa fa-check"></i> 확인
							</span>
						</div>
					</div>
				</div>
			</div>
			</c:forEach>
			<c:if test="${fn:length(noteList) == 0}">
			<div>
				<div class="text-center">데이터가 없습니다.</div>
			</div>
			</c:if>
			
			
			<!-- 확인모달 str -->
			<div class="modal fade" id="noteModal">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span></button>
							<h4 class="modal-title" id="exampleModalLabel">쪽지 정보</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12 col-sm-3">
									<label class="" for="toId">보낸사람 ID</label>
								</div>
								<div class="col-xs-12 col-sm-9">
									<input type="text" class="form-control" id="toId" name="toId">
								</div>
							</div>
							<div class="padding-top-10"></div>
							<div class="row">
								<div class="col-xs-12 col-sm-3">
									<label class="" for="toName">보낸사람</label>
								</div>
								<div class="col-xs-12 col-sm-9">
									<input type="text" class="form-control" id="toName" name="toName">
								</div>
							</div>
							<div class="padding-top-10"></div>
							<div class="row">
								<div class="col-xs-12 col-sm-3">
									<label class="" for="title">제목</label>
								</div>
								<div class="col-xs-12 col-sm-9">
									<input type="text" class="form-control" id="title" name="title">
								</div>
							</div>
							<div class="padding-top-10"></div>
							<div class="row">
								<div class="col-xs-12 col-sm-3">
									<label class="" for="title">내용</label>
								</div>
								<div class="col-xs-12 col-sm-9">
									<textarea class="form-control" id="memo" name="memo" rows="3"></textarea>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<span class="noteDelete btn btn-danger">
								<i class="fa fa-times-circle-o"></i> 삭제
							</span>
						</div>
					</div>
				</div>
			</div>
			<!-- 확인모달 end -->
			
			
		</div>
		<!-- 쪽지  end -->
	
	</div>
</body>