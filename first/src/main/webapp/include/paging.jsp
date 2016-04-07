<%
/**
 * 
 * @author	강정권
 * @date	2016-03-02
 * @tip		페이징 처리 화면
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2016-03-02
 * 수정내용	:	페이지수정
 * ----------------------------
 */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="text-center">
	<ul class="pagination">
		<li class="hidden-xs" data-toggle="tooltip" title="처음으로">
			<a class="page" dir="${paging.firstPageNo}">
				<span aria-hidden="true">&laquo;</span>
			</a>
		</li>
		<li class="disabled hidden-xs">
			<a>총 ${paging.totalCount} 건</a>
		</li>
		<li>
			<a class="page prev" dir="${paging.prevPageNo}">이전</a>
		</li>
		<c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
			<c:choose>
				<c:when test="${i eq paging.pageNo}">
					<li class="active"><a class="page" dir="${i}">${i}</a></li>
				</c:when>
				<c:otherwise>
					<li><a class="hidden-xs page" dir="${i}">${i}</a><li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<li>
			<a class="page next" dir="${paging.nextPageNo}">다음</a>
		</li>
		<li class="hidden-xs" data-toggle="tooltip" title="마지막으로">
			<a class="page" dir="${paging.finalPageNo}">
				<span aria-hidden="true">&raquo;</span>
			</a>
		</li>
	</ul>
</nav>