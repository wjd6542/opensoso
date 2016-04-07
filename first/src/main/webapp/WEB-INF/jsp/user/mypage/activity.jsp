<%
/**
 * 
 * @author	강정권
 * @date	2016-03-05
 * @tip		활동정보  화면
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2016-03-05
 * 수정내용	:	페이지수정
 * ----------------------------
 */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="user" class="shares.vo.UserVo" scope="session" />
<c:set var="userNo" value="${user.no}"/>


<body>
	<div class="col-xs-12 col-sm-12 tab-body">
		
		<!-- acrivity str -->
		<div class="col-xs-12 col-sm-12 placeholder">
			<h3>활동정보</h3>
			<div class="listData">
				<table class="table table-bordered table-hover">
				<c:forEach items="${borderList}" var="list">
				<tr class="move pointer" contextmenu="${list.borderType}" dir="${list.no}">
					<td>
						<div class="col-xs-12 col-sm-3">
							<c:choose>
								<c:when test="${list.borderType == 'B02'}">Q&A</c:when>
								<c:when test="${list.borderType == 'B03'}">소스공유</c:when>
								<c:otherwise>
									커뮤니티
								</c:otherwise>
							</c:choose>
						</div>
						<div class="col-xs-12 col-sm-7">
							${list.title}
						</div>
						<div class="hidden-xs col-sm-2">
							${list.saveDate}
						</div>
					</td>
				</tr>
				</c:forEach>
				<c:if test="${fn:length(borderList) == 0}">
				<tr>
					<td class="text-center">데이터가 없습니다.</td>
				</tr>
				</c:if>
				</table>
			</div>
		</div>
		<!-- acrivity end -->
	
	</div>
</body>