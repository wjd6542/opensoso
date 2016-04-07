<%
/**
 * 
 * @author	강정권
 * @date	2016-03-02
 * @tip		서브 메뉴 화면
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2016-03-02
 * 수정내용	:	페이지수정
 * ----------------------------
 */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="user" class="shares.vo.UserVo" scope="session" />
<c:set var="authority" value="${user.authority}"/>

<div class="hidden-xs col-sm-2 sidebar">
	<h4><b>게시판</b></h4>
	<ul class="nav nav-sidebar">
		<li class="sidemenu notice" id="notice">
			<a href="/borderList.do?borderType=B01"><i class="fa fa-lg fa-eye"></i> 공지게시판</a>
		</li>
		<li class="sidemenu reple" id="reple">
			<a href="/borderList.do?borderType=B02"><i class="fa fa-lg fa-comments-o"></i> Q＆A 게시판</a>
		</li>
		<li class="sidemenu sos" id="sos">
			<a href="/borderList.do?borderType=B03"><i class="fa fa-lg fa-refresh"></i> 소스공유</a>
		</li>
		<li class="sidemenu com" id="com">
			<a href="/borderList.do?borderType=B04"><i class="fa fa-lg fa-paper-plane"></i> 커뮤니티</a>
		</li>
		<li class="sidemenu lecture" id="lecture">
			<a href="/borderList.do?borderType=B05"><i class="fa fa-desktop"></i> 강의</a>
		</li>
	</ul>
	
	
	<c:if test="${authority == 'master'}">
	<h4><b>관리자 메뉴</b></h4>
	<ul class="nav nav-sidebar">
		<li class="sidemenu member" id="member" contextmenu="/userManager.do">
			<a href="#"><i class="fa fa-lg fa-users"></i> 회원 관리</a>
		</li>
		<li class="sidemenu baranch" id="baranch" contextmenu="/baranchManager.do">
			<a href="#"><i class="fa fa-lg fa-cubes"></i> 부서 관리</a>
		</li>
		<li class="sidemenu borders" id="borders" contextmenu="/borderManager.do">
			<a href="#"><i class="fa fa-lg fa-object-ungroup"></i> 게시판 관리</a>
		</li>
		<li class="sidemenu file" id="file" contextmenu="/fileManager.do">
			<a href="#"><i class="fa fa-lg fa-file"></i> 파일 관리</a>
		</li>
		<li class="sidemenu emails" id="emails" contextmenu="/emailManager.do">
			<a href="#"><i class="fa fa-lg fa-envelope"></i> 이메일 관리</a>
		</li>
		<li>
			<div style="border:0.5px solid #eee"></div>
		</li>
		<li class="sidemenu access" id="access" contextmenu="/accessManager.do">
			<a href="#"><i class="fa fa-lg fa-ban"></i> 접근관리</a>
		</li>
		<li class="sidemenu systemTable" id="systemTable" contextmenu="/tableManager.do">
			<a href="#"><i class="fa fa-lg fa-database"></i> 테이블 관리</a>
		</li>
		<li class="sidemenu systemCode" id="systemCode" contextmenu="/codeManager.do">
			<a href="#"><i class="fa fa-lg fa-cog fa-spin"></i> 코드 관리</a>
		</li>
		<li class="sidemenu systemProm" id="systemProm" contextmenu="/authorityManager.do">
			<a href="#"><i class  ="fa fa-lg fa-exclamation-circle"></i> 권한 관리</a>
		</li>
	</ul>
	</c:if>
</div>
	