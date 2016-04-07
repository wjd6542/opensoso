<%
/**
 * 
 * @author	강정권
 * @date	2016-03-02
 * @tip		최 상단 화면
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
<c:set var="userNo" value="${user.no}"/>
<c:set var="name" value="${user.name}"/>
<c:set var="id" value="${user.id}"/>
<c:set var="authority" value="${user.authority}"/>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	
	<!-- 아이콘 -->
	<link rel="stylesheet" href="css/font-awesome.min.css">
	
	<!-- css -->
	<link rel="stylesheet" href="css/bootstrap/bootstrap.css">
	<link rel="stylesheet" href="css/bootstrap/bootstrap-toggle.css">
	<link rel="stylesheet" href="css/bootstrap/bootstrap-datepicker.css">
	
	<link rel="stylesheet" href="css/jquery/dataTables.css">
	<link rel="stylesheet" href="css/jquery/dashboard.css">
	<link rel="stylesheet" href="css/jquery/alertify.core.css">
	<link rel="stylesheet" href="css/jquery/alertify.default.css">
	<link rel="stylesheet" href="css/summernote.css">
	
	<link rel="stylesheet" href="css/screen.css">
	<link rel="stylesheet" href="css/common.css">
	
	<!-- 스크립트파일 -->
	<script type='text/javascript' src='js/jquery/jquery.js'></script>
	<script type='text/javascript' src='js/jquery/fileDownload.js'></script>
	<script type='text/javascript' src='js/jquery/cookie.js'></script>
	<script type='text/javascript' src='js/jquery/dataTables.min.js'></script>
	<script type='text/javascript' src='js/jquery/loadingoverlay.js'></script>
	<script type='text/javascript' src='js/jquery/summernote.js'></script>
	<script type='text/javascript' src='js/jquery/summernote_kr.js'></script>
	<script type='text/javascript' src='js/jquery/alertify.min.js'></script>
	
	<script type='text/javascript' src='js/bootstrap/bootstrap.js'></script>
	<script type='text/javascript' src='js/bootstrap/bootstrap_toggle.js'></script>
	<script type='text/javascript' src='js/bootstrap/bootstrap_datepicker.js'></script>
	<script type="text/javascript" src="js/util/functions.js"></script>
	<script type="text/javascript" src="js/holder.js"></script>
</head>

<body>
	<input type="hidden" id="userAuthority" value="${authority}">
	
	<!-- top str -->
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
					<c:choose>
						<c:when test="${name == null || name eq ''}">
							<li><a href="/login.do" data-transition="fade">로그인</a></li>
						</c:when>
						<c:when test="${authority != 'master'}">
							<li><a href="#"><i class="fa fa-user"></i> ${name}</a></li>
							<li><a href="/logOut.do" data-transition="fade">로그아웃</a></li>
							<li><a href="/myPage.do" data-transition="fade">MyPage</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="#"><i class="fa fa-user"></i> ${name}</a></li>
							<li><a href="/logOut.do" data-transition="fade">로그아웃</a></li>
						</c:otherwise>
					</c:choose>
					
					<!-- 게시판 -->
					<li class="dropdown">
						<a href="#" id="Menu" data-toggle="dropdown"> 게시판 <i class="caret"></i></a>
						<ul class="dropdown-menu" role="menu" aria-labelledby="Menu">
							<li class="sidemenu notice" id="notice">
								<a href="/borderList.do?borderType=B01" data-transition="slidefade"><i class="fa fa-lg fa-eye"></i> 공지게시판</a>
							</li>
							<li class="sidemenu reple" id="reple">
								<a href="/borderList.do?borderType=B02" data-transition="slide"><i class="fa fa-lg fa-comments-o"></i> Q＆A 게시판</a>
							</li>
							<li class="sidemenu sos" id="sos">
								<a href="/borderList.do?borderType=B03" data-transition="pop"><i class="fa fa-lg fa-refresh"></i> 소스공유</a>
							</li>
							<li class="sidemenu com" id="com">
								<a href="/borderList.do?borderType=B04" data-transition="pop"><i class="fa fa-lg fa-paper-plane"></i> 커뮤니티</a>
							</li>
						</ul>
					</li>
					
					<c:if test="${authority == 'master'}">
					<li class="dropdown">
						<a href="#" id="Menus" data-toggle="dropdown"> 관리자 <i class="caret"></i></a>
						<ul class="dropdown-menu" role="menu" aria-labelledby="Menus">
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
					</li>
					</c:if>
					<li class="hidden-xs dropdown">
						<a href="/myConf.do" id="set"><i class="fa fa-cog"></i> 설정</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- top end -->
	
	
</body>
<!-- 스크립트 -->
<script type="text/javascript" src="js/important/top.js"></script>