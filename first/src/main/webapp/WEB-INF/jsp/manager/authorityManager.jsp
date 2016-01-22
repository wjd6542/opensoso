<%
/**
 * 
 * @author	강정권
 * @date	2015-10-20
 * @tip		권한관리 화면
 * <pre>
 * -------- 수정이력 ----------
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

<script type="text/javascript">
$(document).ready(function ()
{
	// 필수 항목 체크
	$.util.mustInput();
	
	// 이동경로
	var url = "/authorityManager.do";
	
	// select box 그리기
	$("#search").append("${search}");
	
	// 삽입/수정/삭제
	$(".action").on("click",function(){
		var eventType = $(this).attr("contextmenu");
		var idx = $(this).attr("dir");
		$("#idx").val(idx);
		$("#eventType").val(eventType);
		$("#form").attr("action",url);
		$("#form").submit();
	});
	
	// 모달 데이터 이동
	$(".moveInput").on("click",function(){
		var idx = $(this).attr("dir");
		var authorityArr = new Array("idx","type","code","title","memo","orders");
		$.util.valueChang(authorityArr,idx);
		$('#aModal').modal("show");
	});
	
	// 중복체크
	$(".overlap").on("click",function(){
		var code = $("#code").val();
		if($.util.nullCheck("code","코드값은 필수입니다.","")) return false;
		
		//Json 데이터 전송
		$.ajax(
		{
			type : "POST",
			url : "/overlapCheck.do",
			data : {code : code},
			dataType: "json",
			// 성공
			success:function(data)
			{
				var code = data.code;
				var msg = data.msg;
				if(code=="SUCC")
				{
					alert(msg);
				}
				else
				{
					alert(msg);
					$("#pcode").focus();
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
			<form method="post" id="form" action="">
			<input type="hidden" id="eventType" name="eventType">
			<input type="hidden" id="idx" name="idx" value="${idx}">
			
				<!-- content -->
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					<div class="row placeholders">
						<div class="col-xs-12 col-sm-8 placeholder">
							<div class="row">
								<div class="hidden-xs col-sm-10">
									<div class="input-group">
										<div class="input-group-btn">
											<select class="form-control" id="search" name="search">
												<option  value="">검색</option>
											</select>
										</div>
										<input type="text" class="form-control" id="searchString" name="searchString" value="${searchString}">
										<div class="input-group-btn">
											<button type="button" class="btn btn-default" onclick="form.submit();">
												<i class="fa fa-search"></i> 검색
											</button>
										</div>
									</div>
								</div>
							</div>
								
							<div class="padding-top-10"></div>
						
							<div class="panel panel-default">
								<div class="panel-heading">
									<div class="panel-title">
										<div class="row">
											<div class="col-xs-6 col-sm-4">
												<i class="fa fa-cogs"></i> 권한관리
											</div>
											<div class="text-right col-xs-6 col-sm-8">
												<button type="button" class="btn btn-sm btn-default dropdown-toggle"  data-toggle="modal" data-target="#aModal">
													<i class="fa fa-check-circle-o"></i> 삽입
												</button>
											</div>
										</div>
									</div>
								</div>
								<div class="max-hight-300">
									<table class="table">
									<tr>
										<td class="text-center">
											<div class="hidden-xs col-sm-3">
												구분
											</div>
											<div class="col-xs-6 col-sm-3">
												코드
											</div>
											<div class="col-xs-6 col-sm-3">
												권한명
											</div>
											<div class="hidden-xs col-sm-3">
												처리
											</div>
										</td>
									</tr>
									<c:forEach items="${authorityList}" var="aList" varStatus="cnt">
									<tr>
										<td class="text-center">
											<div class="hidden-xs col-sm-3">
												${aList.type}
											</div>
											<div class="col-xs-6 col-sm-3">
												${aList.code}
											</div>
											<div class="col-xs-6 col-sm-3">
												${aList.title}
											</div>
											<div class="hidden-xs col-sm-3">
												<span class="moveInput btn btn-default" dir="${aList.idx}">
													수정
												</span>
												<span class="action btn btn-default" dir="${aList.idx}" contextmenu="Delete">
													삭제
												</span>
											</div>
											<input type="hidden" id="idx_${aList.idx}" value="${aList.idx}">
											<input type="hidden" id="type_${aList.idx}" value="${aList.type}">
											<input type="hidden" id="code_${aList.idx}" value="${aList.code}">
											<input type="hidden" id="title_${aList.idx}" value="${aList.title}">
											<input type="hidden" id="memo_${aList.idx}" value="${aList.memo}">
											<input type="hidden" id="orders_${aList.idx}" value="${aList.orders}">
										</td>
									</tr>
									</c:forEach>
									<c:if test="${fn:length(authorityList) == 0}">
									<tr>
										<td class="text-center">데이터가 없습니다.</td>
									</tr>
									</c:if>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<!-- 권한 모달영역 -->
				<div class="modal fade" id="aModal">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span></button>
								<h4 class="modal-title" id="exampleModalLabel">권한 설정</h4>
							</div>
							<div class="modal-body">
								<div class="row">
									<div class="col-xs-12 col-sm-3">
										<label class="check" for="code">코드</label>
									</div>
									<div class="col-xs-7 col-sm-6">
										<input type="text" class="form-control" id="code" name="code">
									</div>
									<div class="col-xs-3 col-sm-3">
										<span class="overlap btn btn-default">중복확인</span>
									</div>
								</div>
								<div class="padding-top-10"></div>
								<div class="row">
									<div class="col-xs-12 col-sm-3">
										<label class="check" for="type">구분</label>
									</div>
									<div class="col-xs-12 col-sm-9">
										<input type="text" class="form-control" id="type" name="type">
									</div>
								</div>
								<div class="padding-top-10"></div>
								<div class="row">
									<div class="col-xs-12 col-sm-3">
										<label class="check" for="title">권한명</label>
									</div>
									<div class="col-xs-12 col-sm-9">
										<input type="text" class="form-control" id="title" name="title">
									</div>
								</div>
								<div class="padding-top-10"></div>
								<div class="row">
									<div class="col-xs-12 col-sm-3">
										<label for="orders">정렬순서</label>
									</div>
									<div class="col-xs-12 col-sm-9">
										<input type="text" class="form-control" id="sort" name="sort">
									</div>
								</div>
								<div class="padding-top-10"></div>
								<div class="row">
									<div class="col-xs-12 col-sm-3">
										<label for="memo">설명</label>
									</div>
									<div class="col-xs-12 col-sm-9">
										<textarea class="form-control" id="memo" name="memo" rows="3"></textarea>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<span class="btn btn-danger" data-dismiss="modal">
									<i class="fa fa-times-circle-o"></i> 닫기
								</span>
								<span class="action btn btn-primary" contextmenu="Insert">
									<i class="fa fa-check-circle-o"></i> 등록
								</span>
								<span class="action btn btn-primary" contextmenu="Update">
									<i class="fa fa-check-circle-o"></i> 수정
								</span>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>