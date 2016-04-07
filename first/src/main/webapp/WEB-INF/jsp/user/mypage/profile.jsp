<%
/**
 * 
 * @author	강정권
 * @date	2016-03-05
 * @tip		개인 프로필  화면
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
	
		<!-- 프로필 str -->
		<div class="col-xs-12 col-sm-8 placeholder">
			<h3>프로필</h3>
			
			<div class="panel">
				<c:choose>
					<c:when test="${user.imgName eq ''}">
						<img class="profileImg width-100" src="img/noimage.gif">
					</c:when>
					<c:otherwise>
						<img class="profileImg width-100" src="img/data/${user.imgName}">
					</c:otherwise>
				</c:choose>
				
			</div>
			<div>
				<div class='input-group'>
					<input type='file' class='form-control' id='file' name='file' multiple='multiple'>
					<span class='input-group-btn'>
						<span class='fileDelete btn btn-danger'>
							<i class='fa fa-times-circle-o'></i> 삭제
						</span>
						<span class='fileUpload btn btn-info'>
							<i class="fa fa-upload"></i> 업로드
						</span>
					</span>
				</div>
			</div>
		</div>
		<!-- 프로필 end -->
		
	</div>
</body>