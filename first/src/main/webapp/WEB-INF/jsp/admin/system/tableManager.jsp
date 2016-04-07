<%
/**
 * 
 * @author	강정권
 * @date	2015-11-29
 * @tip		테이블 데이터 확인 화면
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2015-11-29
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
			<!-- 사이드 메뉴 -->
			<div class="leftSideMemu">
				<jsp:include page="/include/sideMemu.jsp"/>
			</div>
			
			
			<!-- content -->
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row placeholders">
					
					<form method="post" id="form" action="">
						<input type="hidden" id="codeNo" name="codeNo" value="${codeNo}">
						<input type="hidden" id="actionType" name="actionType" value="code">
						
						<!-- 컴럼검색 -->
						<div class="col-xs-12 col-sm-12 placeholder">
							<div class="panel panel-default">
								<div class="panel-heading">
									<div class="panel-title">
										<i class="fa fa-cogs"></i> 테이블 관리
									</div>
								</div>
								<table class="display wid-100 dataTable">
									<thead>
										<tr>
											<th class="text-center hidden-xs">테이블이름</th>
											<th class="text-center hidden-xs">테이블설명</th>
											<th class="text-center">컬럼명</th>
											<th class="text-center">컬럼 설명</th>
											<th class="text-center">컬럼 타입</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${tableList}" var="tableList" varStatus="pcnt">
									<tr>
										<td class="hidden-xs text-center">
											${tableList.table_name}
										</td>
										<td class="hidden-xs">
											${tableList.table_comment}
										</td>
										<td>
											${tableList.column_name}
										</td>
										<td>
											${tableList.column_comment}
										</td>
										<td>
											${tableList.column_type}
										</td>
									</tr>
									</c:forEach>
									<c:if test="${fn:length(tableList) == 0}">
									<tr>
										<td class="text-center">데이터가 없습니다.</td>
									</tr>
									</c:if>
									</tbody>
								</table>
							</div>
						</div>
					</form>
				</div>
			</div>
			
		</div>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function ()
	{
		$(".dataTable").DataTable();
	});
</script>