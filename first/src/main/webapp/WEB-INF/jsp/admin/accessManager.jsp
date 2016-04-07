<%
/**
 * 
 * @author	������
 * @date	2015-10-20
 * @tip		���ٰ��� ������
 * <pre>
 * -------- �����̷� --------------
 * ������	:	������
 * ��������	:	2015-10-20
 * ��������	:	����������
 * ----------------------------
 * </pre>
 */
%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- ��� -->
<jsp:include page="/include/top.jsp"/>

<body>
	<div class="container-fluid">
		<div class="row">
			<!-- ���̵� �޴� -->
			<div class="leftSideMemu">
				<jsp:include page="/include/sideMemu.jsp"/>
			</div>
			
			<form id="form" name="form" method="post" action="/accessManager.do">
				<input type="hidden" id="pageNo" name="pageNo" value="${pageNo}">
				
				<!-- content -->
				<div class="col-sm-9 col-sm-offset-3 col-md-12 col-md-offset-2 main">
					<div class="row placeholders">
						<div class="col-xs-12 col-sm-10 placeholder">
						
							<h3>���ٰ���</h3>
							
							<table class="table table-bordered">
								<tr>
									<td>
										<div class="row">
											<div class="col-sm-12">
												<div class="input-group">
													<div class="input-group-btn hidden-xs">
														<select class="form-control" id="search" name="search">
															<option value="">�󼼰˻�</option>
														</select>
													</div>
													<div class="input-group-btn">
														<input type="text" class="form-control" id="searchString" name="searchString" value="${searchString}" data-toggle="tooltip" title="�󼼰˻�">
													</div>
													<div class="input-group-btn hidden-xs">
														<input type="text" class="form-control text-center" id="pageSize" name="pageSize" value="${pageSize}" maxlength="3" data-toggle="tooltip" title="rowcnt">
													</div>
													<div class="input-group-btn">
														<span class="search btn btn-default">
															<i class="fa fa-search"></i> �˻�
														</span>
													</div>
												</div>
											</div>
										</div>
									</td>
								</tr>
								
								<tr>
									<td>
										<div class="row">
											<div class="col-xs-6 col-sm-4">���ٰ��</div>
											<div class="col-xs-6 col-sm-2">���ٱ���</div>
											<div class="hidden-xs col-sm-3">ip</div>
											<div class="hidden-xs col-sm-3">���� �ð�</div>
										</div>
									</td>
								</tr>
								
								<c:forEach items="${accessList}" var="list" varStatus="cnt">
								<tr>
									<td>
										<div class="row">
											<div class="col-xs-6 col-sm-4">${list.path}</div>
											<div class="col-xs-6 col-sm-2">${list.type}</div>
											<div class="hidden-xs col-sm-3">${list.ip}</div>
											<div class="hidden-xs col-sm-3">${list.saveDate} ${list.saveTime}</div>
										</div>
									</td>
								</tr>
								</c:forEach>
								<c:if test="${fn:length(accessList) == 0}">
								<tr>
									<td>
										<div class="row">
											<div class="text-center">��ϱ��� �����ϴ�.</div>
										</div>
									</td>
								</tr>
								</c:if>
								
							</table>
							
							<!-- ����¡ ó�� -->
							<jsp:include page="/include/paging.jsp" flush="true" />
						</div>
					</div>
				</div>
			
			</form>
			
		</div>
	</div>
</body>
<!-- ��ũ��Ʈ -->
<script type='text/javascript' src='js/manager/accessManager.js'></script>
<script type="text/javascript">
$(document).ready(function ()
{
	// select box ����
	$("#search").append("${search}");
	
	// �˻�
	$(".search").on("click", function(){
		$("#form").attr("action", location.href);
		$("#form").submit();
	});
});
</script>