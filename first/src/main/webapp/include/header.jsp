<%
/**
 * 
 * @author	강정권
 * @date	2016-03-02
 * @tip		헤더 화면
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
	
	<title>프로젝트</title>
</head>