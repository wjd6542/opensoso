<%
/**
 * 
 * @author	강정권
 * @date	2016-03-02
 * @tip		비밃번호 변경화면
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
				<div class="row placeholders">
					<form id="form" name="form"  method="post">
					<input type="hidden" id="type" name="type">
					<input type="hidden" id="email" name="email">
					
						<div class="col-xs-12 col-sm-6 placeholder">
						
						
							<!--login modal str -->
							<div class="modal-dialog padding-top-30">
								<div class="modal-content">
									<div class="modal-header">
										<h3>비밀번호 변경</h3>
									</div>
									
									<div class="typeId">
										<div class="modal-body text-left">
											<input class="form-control input-sm" id="citation" maxlength="13" placeholder="인증번호">
											<div class="padding-top-10"></div>
											<input type="password" class="form-control input-sm" id="password" placeholder="비밀번호">
											<div class="padding-top-10"></div>
											<input type="password" class="form-control input-sm" id="pwCheck" placeholder="비밃번호 확인">
										</div>
										<div class="modal-footer">
											<div class="pwChang btn btn-sm btn-default" contextmenu="id">비밀번호 변경</div>
										</div>
									</div>
					
								</div>
							</div>
							<!--login modal end -->
							
						</div>
					
					</form>
				</div>
			</div>
			
		</div>
	</div>
</body>
<!-- 스크립트 -->
<script type="text/javascript" src="js/user/pwChangView.js"></script>