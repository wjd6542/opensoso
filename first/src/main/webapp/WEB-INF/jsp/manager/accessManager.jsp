<%
/**
 * 
 * @author	강정권
 * @date	2015-10-20
 * @tip		접근관리 페이지
 * <pre>
 * -------- 수정이력 ----------
 * 수정자	:	강정권
 * 수정일자	:	2015-10-20
 * 수정내용	:	페이지수정
 * ----------------------------
 * </pre>
 */
%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
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
					<div class="col-xs-12 col-sm-8 placeholder">
						<div class="panel panel-default">
							<div class="panel-heading">
								<div class="panel-title" data-toggle="tooltip">
									<i class="fa fa-user fa-lg"></i> 접근관리
								</div>
							</div>
							<table class="table">
							<tr>
								<td>
									<div class="row">
										<div class="col-sm-2 hidden-xs">번호</div>
										<div class="col-xs-6 col-sm-2">이름</div>
										<div class="col-sm-2 hidden-xs">생년월일</div>
										<div class="col-sm-2 hidden-xs">성별</div>
										<div class="col-xs-6 col-sm-2">IP</div>
										<div class="col-sm-2 hidden-xs">상태</div>
									</div>
								</td>
							</tr>
							<c:forEach items="${accessList}" var="accessList" varStatus="cnt">
							<tr onclick="showAccess('${accessList.no}');">
								<td>
									<div class="row">
										<div class="col-sm-2 hidden-xs">${cnt.count}</div>
										<div class="col-xs-6 col-sm-2">${accessList.name}</div>
										<div class="col-sm-2 hidden-xs">${accessList.birthday}</div>
										<div class="col-sm-2 hidden-xs">${accessList.sex}</div>
										<div class="col-xs-6 col-sm-2">${accessList.ip}</div>
										<div class="col-sm-2 hidden-xs">${accessList.status}</div>
									</div>
								</td>
							</tr>
							</c:forEach>
							<c:if test="${fn:length(accessList) == 0}">
							<tr>
								<td>
									<div class="row">
										<div class="text-center">등록글이 없습니다.</div>
									</div>
								</td>
							</tr>
							</c:if>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>