<%
/**
 * 
 * @author	������
 * @date	2015-10-20
 * @tip		���ٰ��� ������
 * <pre>
 * -------- �����̷� ----------
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

<script type="text/javascript">
	$(document).ready(function ()
	{
		
		$.util.radioShow("label.btn","typeId","typePw");
		
		// ���̵� ��й�ȣ ã��
		$(".idpwSearch").on("click",function(){
			$(location).attr('href',"/idpwSearch.do");
		});

	});
</script>

<body>
	<div class="container-fluid">
		<div class="row">
			<!-- ����޴� -->
			<jsp:include page="/include/sideMemu.jsp"/>
			
			<!-- content -->
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row placeholders">
					<div class="col-xs-12 col-sm-8 placeholder">
						<div class="panel panel-default">
							<div class="panel-heading">
								<div class="panel-title" data-toggle="tooltip">
									<i class="fa fa-user fa-lg"></i> ���ٰ���
								</div>
							</div>
							<table class="table">
							<tr>
								<td>
									<div class="row">
										<div class="col-sm-2 hidden-xs">��ȣ</div>
										<div class="col-xs-6 col-sm-2">�̸�</div>
										<div class="col-sm-2 hidden-xs">�������</div>
										<div class="col-sm-2 hidden-xs">����</div>
										<div class="col-xs-6 col-sm-2">IP</div>
										<div class="col-sm-2 hidden-xs">����</div>
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
										<div class="text-center">��ϱ��� �����ϴ�.</div>
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