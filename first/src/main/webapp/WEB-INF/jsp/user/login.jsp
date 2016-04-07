<%
/**
 * 
 * @author	강정권
 * @date	2015-10-17
 * @tip		로그인화면
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2016-06-05
 * 수정내용	:	로그인 화면 수정
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
			
			
			<!-- content str -->
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row placeholders">
					<form id="form" name="form"  method="post">
						
						<div class="col-xs-12 col-sm-offset-1 col-sm-6 placeholder">
						
							<!--login modal str -->
							<div class="modal-dialog padding-top-30">
								<div class="modal-content">
									<div class="modal-header">
										<h1 class="text-center">Login</h1>
									</div>
									<div class="modal-body">
										<div class="form-group">
											<input type="text" class="form-control input-lg" id="id" value="${memberId}" placeholder="아이디">
										</div>
										<div class="form-group">
											<input type="password" class="form-control input-lg" id="password" placeholder="비밀번호">
										</div>
										<div class="form-group">
											<div class="login btn btn-lg btn-block btn-default">
												<i class="fa fa-check-square fa-lg"></i> 로그인
											</div>
										</div>
									</div>
									<div class="modal-footer">
										<div class="padding-5">
											<div class="idpwSearch input-sm btn btn-sm btn-default">
												<i class="fa fa-unlock fa-lg"></i> ID/PW 찾기
											</div>
											<div class="consent input-sm btn btn-sm btn-default">
												<i class="fa fa-user fa-lg"></i> 회원가입
											</div>
										</div>
									</div>
								</div>
							</div>
							<!--login modal end -->
							
							
						</div>
					</form>
				</div>
			</div>
			<!-- content end -->
			
		</div>
	</div>
</body>
<!-- 스크립트 -->
<script type='text/javascript' src='js/user/login.js'></script>