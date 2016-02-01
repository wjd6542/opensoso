<%
/**
 * 
 * @author	강정권
 * @date	2015-10-20
 * @tip		간편 회원가입 화면
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
			
			<form id="form" name="form" method="post">
			
				<!-- content -->
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					<div class="row placeholders">
						<div class="col-xs-12 col-sm-6 placeholder">
							<h3>회원 가입</h3>
							<table class="table table-bordered">
							<tr>
								<td>
									<div class="col-xs-12 col-sm-4">
										<label class="check" for="password">이름</label>
									</div>
									<div class="col-xs-12 col-sm-8">
										<input type="text" class="form-control han" id="name" placeholder="이름">
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="col-xs-12 col-sm-4">
										<label class="check" for="password eng">아이디</label>
									</div>
									<div class="col-xs-12 col-sm-8">
										<input type="text" class="form-control" id="id" placeholder="아이디">
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="col-xs-12 col-sm-4">
										<label class="check" for="nickName">닉네임</label>
									</div>
									<div class="col-xs-12 col-sm-8">
										<input type="text" class="form-control han" id="nickName" placeholder="별명">
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="col-xs-12 col-sm-4">
										<label class="check" for="password">비일번호</label>
									</div>
									<div class="col-xs-12 col-sm-8">
										<input type="password" class="form-control" id="password" placeholder="비밀번호">
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="col-xs-12 col-sm-4">
										<label class="check" for="pwCheck">비밀번호 확인</label>
									</div>
									<div class="col-xs-12 col-sm-8">
										<input type="password" class="form-control" id="pwCheck" placeholder="비밀번호 확인">
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="col-xs-12 col-sm-4">
										<label class="check" for="password">이메일</label>
									</div>
									<div class="col-xs-12 col-sm-8">
										<input type="text" class="form-control" id="email" placeholder="이메일">
										<select class="form-control" id="emails" name="emails">
											<option value="">직접입력</option>
										</select>
									</div>
								</td>
							</tr>
							<tr>
								<td class="text-right">
									<span class="join btn btn-default">
										<i class="fa fa-check-square fa-lg"></i> 회원가입
									</span>
								</td>
							</tr>
							</table>
						</div>
						<div class="col-xs-12 col-sm-6 placeholder">
							<div class="circle">
								<span>회원가입을 환영 합니다!</span>
							</div>
						</div>
						
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript" src="js/user/simpleJoin.js"></script>
<script type="text/javascript">
$(document).ready(function ()
{
	// select box 생성
	$("#gender").append("${gender}");
	$("#emails").append("${emails}");
});
</script>