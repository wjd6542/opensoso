<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	
	<!-- 아이콘 -->
	<link rel="stylesheet" href="css/font-awesome.min.css">
	
	<!-- css -->
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/bootstrap-toggle.css">
	<link rel="stylesheet" href="css/bootstrap-datepicker.css">
	<link rel="stylesheet" href="css/dashboard.css">
	<link rel="stylesheet" href="css/dashboard.css">
	<link rel="stylesheet" href="css/jquery.treeview.css">
	<link rel="stylesheet" href="css/table/jquery.dataTables.css">
	
	
	<link rel="stylesheet" href="css/screen.css">
	<link rel="stylesheet" href="css/common.css">
	
	<!-- 스크립트파일 -->
	<script type='text/javascript' src='js/jquery/jquery.js'></script>
	<script type='text/javascript' src='js/jquery/jquery.cookie.js'></script>
	<script type='text/javascript' src='js/table/jquery.dataTables.min.js'></script>
	<script type='text/javascript' src='js/bootstrap/bootstrap.js'></script>
	<script type='text/javascript' src='js/bootstrap/bootstrap-toggle.js'></script>
	<script type='text/javascript' src='js/bootstrap/bootstrap-datepicker.js'></script>
	<script type="text/javascript" src="js/util/function.js"></script>
	<script type="text/javascript" src="js/holder.js"></script>
	
	<title>프로젝트</title>
</head>
<script type="text/javascript">
	$(document).ready(function () {
		// 툴팁
		$(function () {
			$('[data-toggle="tooltip"]').tooltip();
		});
		// 달력
		$('.date').datepicker({
			language : 'ko',
			format: 'yyyy-mm-dd',
			startDate: '-3d',
			todayHighlight: true
		});
		
		// 서브메뉴 색상 유지
		$.util.sideMemulook();
		// 서브메뉴 쿠키 생성
		$.util.toggleCookie("sidelook","sideCheck");
		
	});
</script>
<body>
	
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/index.do"><i class="fa fa-gg-circle"></i> OpenSoSo</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/login.do">로그인</a></li>
					<c:if test="${member.name != null}">
						<li><a href="#">${member.name}</a></li>
						<li><a href="/logOut.do">로그아웃</a></li>
						<li><a href="/myPage.do">MyPage</a></li>
					</c:if>
					
					<!-- 게시판 -->
					<li class="dropdown">
						<a href="#" id="Menu" data-toggle="dropdown"> 게시판 <i class="caret"></i></a>
						<ul class="dropdown-menu" role="menu" aria-labelledby="Menu">
							<li><a href="#"><i class="fa fa-eye"></i> 공지게시판</a></li>
							<li><a href="#"><i class="fa fa-gg"></i> Q＆A 게시판</a></li>
							<li><a href="#"><i class="fa fa-refresh"></i> 소스공유</a></li>
							<li><a href="#"><i class="fa fa-paper-plane"></i> 커뮤니티</a></li>
						</ul>
					</li>
					
					<!-- 관리자 메뉴 -->
					<li class="dropdown">
						<a href="#" id="Menus" data-toggle="dropdown"> 관리자 <i class="caret"></i></a>
						<ul class="dropdown-menu" role="menu" aria-labelledby="Menus">
							<li><a href="/userManager.do"><i class="fa fa-users"></i> 회원 관리</a></li>
							<li><a href="/codeManager.do"><i class="fa fa-cog fa-spin"></i> 코드 관리</a></li>
							<li><a href="/authorityManager.do"><i class="fa fa-exclamation-circle"></i> 권한 관리</a></li>
							<li><a href="/accessManager.do"><i class="fa fa-ban"></i> 접근관리</a></li>
						</ul>
					</li>
					
					<!-- 사이드메뉴 관리 -->
					<li class="hidden-xs dropdown">
						<a href="#" id="side" data-toggle="dropdown"> 서브메뉴 <i class="caret"></i></a>
						<ul class="dropdown-menu" role="side" aria-labelledby="side">
							<li class="sidelook" contextmenu="N"><a href="#"><i class="fa fa-expand"></i> 서브매뉴 보임</a></li>
							<li class="sidelook" contextmenu="Y"><a href="#"><i class="fa fa-compress"></i> 서브메뉴 숨김</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</nav>
</body>