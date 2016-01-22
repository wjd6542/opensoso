<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript">
$(document).ready(function ()
{
	// 메뉴 색상 설정
	$.util.setColor(".sidemenu","memuid","Y");
});
</script>

<div class="col-sm-2 col-md-2 sidebar">
	<h5><b>게시판</b></h5>
	<ul class="nav nav-sidebar">
		<li class="sidemenu" id=""><a href="#"><i class="fa fa-eye"></i> 공지게시판</a></li>
		<li class="sidemenu" id=""><a href="#"><i class="fa fa-comments-o"></i> Q＆A 게시판</a></li>
		<li class="sidemenu" id=""><a href="#"><i class="fa fa-refresh"></i> 소스공유</a></li>
		<li class="sidemenu" id=""><a href="#"><i class="fa fa-paper-plane"></i> 커뮤니티</a></li>
	</ul>
	
	<h5><b>관리자 메뉴</b></h5>
	<ul class="nav nav-sidebar">
		<li class="sidemenu" id="member" contextmenu="/userManager.do">
			<a href="#"><i class="fa fa-users"></i> 회원 관리</a>
		</li>
		<li class="sidemenu" id="baranch" contextmenu="/baranchManager.do">
			<a href="#"><i class="fa fa-users"></i> 부서 관리</a>
		</li>
		<li class="sidemenu" id="border" contextmenu="/borderManager.do">
			<a href="#"><i class="fa fa-users"></i> 게시판 관리</a>
		</li>
		<li class="sidemenu" id="access" contextmenu="/accessManager.do">
			<a href="#"><i class="fa fa-ban"></i> 접근관리</a>
		</li>
		<li class="dropdown sidemenu">
			<a href="#" class="sidemenu" id="Menus" data-toggle="dropdown">
				<i class="fa fa-cog fa-spin"></i> 시스템 <i class="caret"></i>
			</a>
			<ul class="dropdown-menu" role="menu" aria-labelledby="Menus">
				<li class="sidemenu" id="system" contextmenu="/tableManager.do">
					<a href="#"><i class="fa fa-users"></i> 테이블 관리</a>
				</li>
				<li class="sidemenu" id="system" contextmenu="/codeManager.do">
					<a href="#"><i class="fa fa-cog fa-spin"></i> 코드 관리</a>
				</li>
				<li class="sidemenu" id="system" contextmenu="/authorityManager.do">
					<a href="#"><i class="fa fa-exclamation-circle"></i> 권한 관리</a>
				</li>
			</ul>
		</li>
	</ul>
</div>
	