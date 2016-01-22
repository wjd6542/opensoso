<%
/**
 * 
 * @author	강정권
 * @date	2015-10-17
 * @tip		로그인화면
 * <pre>
 * -------- 수정이력 ----------
 * 수정자	:	강정권
 * 수정일자	:	2015-10-17
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

<script type="text/javascript">
	$(document).ready(function ()
	{
		// 아이디 비밀번호 찾기
		$.util.urlMove(".idpwSearch","/idpwSearch.do");
		
		// 동의 페이지
		$.util.urlMove(".consent","/consent.do");
		
		// 로그인 클릭
		$(".login").on("click",function()
		{
			// 유효성 검사
			if($.util.nullCheck("id","아이디 값은 필수 입니다.","Y")) return false;
			if($.util.nullCheck("password","비밀번호 값은 필수 입니다.","Y")) return false;
			// id 배열
			var idArr = new Array("id","password","idCheck");
			// jsonObject 생성
			var jsonObject = $.util.jsonObjectMk(idArr);
			
			//Json 데이터 전송
			$.ajax(
			{
				type : "POST",
				url : "/loginAction.do",
				data : jsonObject,
				dataType: "json",
				// 성공
				success:function(data)
				{
					var code = data.code;
					var msg = data.msg;
					if(code=="SUCC")
					{
						$(location).attr('href',"/index.do");
					}
					else
					{
						alert(msg);
						$("#id").focus();
					}
				},
				// 실패
				error:function(request,status,error){
					alert("시스템 에러 입니다. 에러코드 : "+request.status);
				}
			});
		});
	});
</script>

<body>
	<div class="container-fluid">
		<div class="row">
			<!-- 서브메뉴 -->
			<jsp:include page="/include/sideMemu.jsp"/>
			
			<!-- content -->
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row placeholders">
					<div class="col-xs-12 col-sm-6 placeholder">
						<div class="panel panel-default">
							<div class="panel-heading">
								<div class="panel-title">로그인</div>
							</div>
							<div class="panel-body text-left">
								<input type="text" class="form-control input-sm" id="id" value="${memberId}" placeholder="아이디" data-toggle="tooltip" title="영문 숫자 조합만 가능합니다.">
								<div class="padding-top-10"></div>
								<input type="password" class="form-control input-sm" id="password" value="" placeholder="비밀번호" data-toggle="tooltip" title="비밀번호 를 입력하세요.">
								<div class="checkbox">
									<label>
										<input type="checkbox" id="idCheck" value="Y" 
										data-toggle="toggle" data-size="small" <c:if test="${idCheck != null}">checked</c:if>> 아이디저장
									</label>
								</div>
							</div>
							<div class="panel-footer">
								<div class="row">
									<div class="col-xs-12 col-sm-4">
										<div class="login form-control input-sm btn btn-sm btn-default">
											<i class="fa fa-check-square fa-lg"></i> 로그인
										</div>
									</div>
									<div class="col-xs-12 col-sm-4">
										<div class="idpwSearch form-control input-sm btn btn-sm btn-default">
											<i class="fa fa-unlock fa-lg"></i> ID/PW 찾기
										</div>
									</div>
									<div class="col-xs-12 col-sm-4">
										<div class="consent form-control input-sm btn btn-sm btn-default">
											<i class="fa fa-user fa-lg"></i> 회원가입
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>