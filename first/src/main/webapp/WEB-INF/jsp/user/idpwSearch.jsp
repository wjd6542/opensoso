<%
/**
 * 
 * @author	강정권
 * @date	2016-03-02
 * @tip		아이디 비밃번로 찾기 화면
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

<script type="text/javascript">
	$(document).ready(function ()
	{
		
		$.util.radioShow("label.btn","typeId","typePw");
		
	});
</script>

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
										<div class="btn-group" data-toggle="buttons">
											<label class="btn btn-default active">
												<input type="radio" id="type" name="type" value="typeId"> 
												<i class="fa fa-key"></i> 아이디 찾기
											</label>
											<label class="btn btn-default">
												<input type="radio" id="type" name="type" value="typePw"> 
												<i class="fa fa-lock"></i> 비밀번호 찾기
											</label>
										</div>
									</div>
									
									
									<!-- 아이디 -->
									<div class="typeId">
										<div class="modal-body text-left">
											<input class="form-control input-sm" id="name" placeholder="이름">
											<div class="padding-top-10"></div>
											<input class="form-control input-sm" id="emailId" placeholder="이메일">
										</div>
										<div class="modal-footer">
											<div class="search btn btn-sm btn-default" contextmenu="id">ID 찾기</div>
										</div>
									</div>
									<!-- 비밀번호 -->
									<div class="typePw">
										<div class="modal-body text-left">
											<input class="form-control input-sm" id="id" placeholder="아이디">
											<div class="padding-top-10"></div>
											<input class="form-control input-sm" id="emailPw" placeholder="이메일">
										</div>
										<div class="modal-footer">
											<div class="search btn btn-sm btn-default" contextmenu="pw">PW 찾기</div>
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
<script type="text/javascript" src="js/user/idpwSearch.js"></script>