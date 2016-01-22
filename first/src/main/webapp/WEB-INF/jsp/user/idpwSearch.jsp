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
		
		$.util.radioShow("label.btn","typeId","typePw");
		
		// 아이디 비밀번호 찾기
		$(".idpwSearch").on("click",function(){
			$(location).attr('href',"/idpwSearch.do");
		});
		
		// 로그인 클릭
		$(".login").on("click",function()
		{
			// 유효성 검사
			if($.util.nullCheck("id","아이디 값은 필수 입니다.")) return false;
			if($.util.nullCheck("pw","비밀번호 값은 필수 입니다.")) return false;
			
			// id 배열
			var idArr = new Array("id","pw","idCheck");
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
						$(location).attr('href',"/main.do");
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
								<div class="panel-title">
									<div class="btn-group" data-toggle="buttons">
										<label class="btn btn-default active">
											<input type="radio" id="type" name="type" value="typeId"/> <i class="fa fa-search-minus"></i> 아이디 찾기
										</label>
										<label class="btn btn-default">
											<input type="radio" id="type" name="type" value="typePw"/> <i class="fa fa-search-plus"></i> 비밀번호 찾기
										</label>
									</div>
								</div>
							</div>
							<!-- 아이디 -->
							<div class="typeId">
								<div class="panel-body text-left">
									<input class="form-control input-sm" id="name" value="" placeholder="이름">
									<div class="padding-top-10"></div>
									<input class="form-control input-sm" id="email" value="" placeholder="이메일">
								</div>
								<div class="panel-footer">
									<div class="idSearch btn btn-sm btn-default">ID 찾기</div>
								</div>
							</div>
							<!-- 비밀번호 -->
							<div class="typePw">
								<div class="panel-body text-left">
									<input class="form-control input-sm" id="name" value="" placeholder="이름">
									<div class="padding-top-10"></div>
									<input class="form-control input-sm" id="phon" value="" placeholder="휴대폰번호">
									<div class="padding-top-10"></div>
									<input class="form-control input-sm" id="email" value="" placeholder="이메일">
								</div>
								<div class="panel-footer">
									<div class="pwSearch btn btn-sm btn-default">PW 찾기</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>