<%
/**
 * 
 * @author	강정권
 * @date	2016-03-02
 * @tip		유저 설정 화면
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
<c:set var="noteStatus" value="${user.noteStatus}"/>
<!-- 상단 -->
<jsp:include page="/include/top.jsp"/>


<body>
	<div class="container-fluid">
		<div class="row">
			<!-- 사이드 메뉴 -->
			<div class="leftSideMemu">
				<jsp:include page="/include/sideMemu.jsp"/>
			</div>
			
			<form id="form" name="form" method="post">
				<input type="hidden" id="noteStatus" name="noteStatus" value="${noteStatus}">
			
				<!-- content -->
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					<div class="row placeholders">
						<div class="col-xs-12 col-sm-6 placeholder">
							<h3>개인설정</h3>
							
							<div>
								<div class="row">
									<div class="col-xs-12 col-sm-6">
										<div class="padding-top-20"></div>
										<span class="gbox">
											<b>사이드메뉴 위치</b>
											<input type="checkbox" class="confs" id="sideLocationCk" checked data-toggle="toggle"
											 data-on="왼쪽" data-off="오른쪽" data-size="mini">
										</span>
										
										<c:if test="${user.no != ''}">	
										<div class="padding-top-20"></div>
										<span class="gbox pointer">
											<b>쪽지 여부</b>
											<input type="checkbox" class="noteCk" id="noteCk" checked data-toggle="toggle"
											 data-on="받음" data-off="안받음" data-size="mini" value="${userNo}">
										</span>
										</c:if>
									</div>
									
									<div class="col-xs-12 col-sm-6">
										<div class="padding-top-20"></div>
										<span class="gbox">
											<b>사이드메뉴 출력</b>
											<input type="checkbox" class="confs" id="sideShowCk" checked data-toggle="toggle" 
											data-on="보임" data-off="숨김" data-size="mini">
										</span>
									</div>
								</div>
								
								
							</div>
						</div>
						
					</div>
				</div>
			</form>
			
		</div>
	</div>
</body>
<script type="text/javascript" src="js/user/myConf.js"></script>