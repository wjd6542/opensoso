<%
/**
 * 
 * @author	강정권
 * @date	2016-03-02
 * @tip		mypage 화면 데이터를 전부 화면단에서 분활함 스크립트 또한 mypage 화면에서 제어
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
<c:set var="userNo" value="${user.no}"/>

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
			<div class="col-sm-9 col-sm-offset-3 col-md-8 col-md-offset-2 main">
				<div class="row placeholders">
					<form id="form" name="form"  method="post">
						<input type="hidden" id="no" name="no" value="${userNo}">
						<input type="hidden" id="borderType" name="borderType">
						<input type="hidden" id="borderNo" name="borderNo">
						
						
						<!-- Tab tablist str -->
						 <ul class="nav nav-tabs nav-justified" role="tablist">
							<li role="presentation" class="active">
								<a href="#home" aria-controls="home" role="tab" data-toggle="tab">
									<i class="fa fa-user"></i> 프로필
								</a>
							</li>
							<li role="presentation">
								<a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">
									<i class="fa fa-child"></i> 개인정보
								</a>
							</li>
							<li role="presentation">
								<a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">
									<i class="fa fa-bookmark"></i> 활동정보
								</a>
							</li>
							<li role="presentation">
								<a href="#note" aria-controls="note" role="tab" data-toggle="tab">
									<i class="fa fa-envelope"></i> 쪽지
								</a>
							</li>
						</ul>
						<!-- Tab tablist str -->
						
						
						<!-- Tab content str -->
						<div class="tab-content">
							<div role="tabpanel" class="tab-pane active" id="home">
								<!-- 프로필 페이지 -->
								<jsp:include page="../user/mypage/profile.jsp">
									<jsp:param name="user" value="${user}" />
								</jsp:include>
							</div>
							<div role="tabpanel" class="tab-pane" id="profile">
								<!-- 개인정보 페이지 -->
								<jsp:include page="../user/mypage/info.jsp">
									<jsp:param name="user" value="${user}" />
								</jsp:include>
							</div>
							<div role="tabpanel" class="tab-pane" id="messages">
								<!-- 활동정보 페이지 -->
								<jsp:include page="../user/mypage/activity.jsp">
									<jsp:param name="borderList" value="${borderList}" />
								</jsp:include>
							</div>
							<div role="tabpanel" class="tab-pane" id="note">
								<!-- 활동정보 페이지 -->
								<jsp:include page="../user/mypage/note.jsp">
									<jsp:param name="noteList" value="${noteList}" />
								</jsp:include>
							</div>
						</div>
						<!-- Tab content end -->
						
						
					</form>
				</div>
			</div>
			
		</div>
	</div>
</body>
<!-- 스크립트 -->
<script type='text/javascript' src="js/user/myPage.js"></script>