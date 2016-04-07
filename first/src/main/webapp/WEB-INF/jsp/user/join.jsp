<%
/**
 * 
 * @author	강정권
 * @date	2016-03-02
 * @tip		회원가입 화면
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
<!-- 상단 -->
<jsp:include page="/include/top.jsp"/>


<body>
	<div class="container-fluid">
		<div class="row">
			<!-- 사이드 메뉴 -->
			<div class="leftSideMemu">
				<jsp:include page="/include/sideMemu.jsp"/>
			</div>
			
			
			<form id="form" name="form"  method="post">
			<input type="hidden" id="lat" name="lat">
			<input type="hidden" id="lng" name="lng">
				<!-- content -->
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					<div class="row placeholders">
						<div class="col-xs-12 col-sm-6 placeholder">
							<div class="panel panel-default">
								<div class="panel-heading">
									<div class="panel-title">
										<i class="fa fa-user fa-lg"></i> 회원가입
									</div>
								</div>
								<table class="table">
								<tr>
									<td class="row">
										<div class="col-xs-12 col-sm-4">
											<label class="check"for="id">아이디</label>
										</div>
										<div class="col-xs-12 col-sm-5">
											<input type="text" class="form-control input-sm" id="id" required="required">
										</div>
										<div class="hidden-xs col-sm-1">
											<span class="idCheck btn btn-default">
												중복검사
											</span>
										</div>
									</td>
								</tr>
								<tr>
									<td class="row">
										<div class="col-xs-12 col-sm-4">
											<label class="check"for="password">비밀번호</label>
										</div>
										<div class="col-xs-12 col-sm-8">
											<input type="password" class="form-control input-sm" id="password">
										</div>
									</td>
								</tr>
								<tr>
									<td class="row">
										<div class="col-xs-12 col-sm-4">
											<label class="check"for="pwCheck">비밀번호확인</label>
										</div>
										<div class="col-xs-12 col-sm-8">
											<input type="password" class="form-control input-sm" id="pwCheck">
										</div>
									</td>
								</tr>
								<tr>
									<td class="row">
										<div class="col-xs-12 col-sm-4">
											<label class="check"for="name">이름</label>
										</div>
										<div class="col-xs-12 col-sm-8">
											<input type="text" class="form-control input-sm" id="name">
										</div>
									</td>
								</tr>
								<tr>
									<td class="row">
										<div class="col-xs-12 col-sm-4">
											<label class="check"for="birthday">생년월일</label>
										</div>
										<div class="col-xs-12 col-sm-8">
											<input type="text" class="form-control date input-sm" id="birthday">
										</div>
									</td>
								</tr>
								<tr>
									<td class="row">
										<div class="col-xs-12 col-sm-4">
											<label class="check"for="phon">전화번호</label>
										</div>
										<div class="col-xs-12 col-sm-8">
											<input type="text" class="form-control input-sm" id="phon">
										</div>
									</td>
								</tr>
								<tr>
									<td class="row">
										<div class="col-xs-12 col-sm-4">
											<label class="check"for="gender">성별</label>
										</div>
										<div class="col-xs-12 col-sm-8">
											<select class="form-control input-sm" id="gender">
												<option value="">선택</option>
											</select>
										</div>
									</td>
								</tr>
								<tr>
									<td class="row">
										<div class="col-xs-12 col-sm-4">
											<label class=""for="hobby">취미</label>
										</div>
										<div class="col-xs-12 col-sm-8">
											<input type="email" class="form-control input-sm" id="hobby">
										</div>
									</td>
								</tr>
								<tr>
									<td class="row">
										<div class="col-xs-12 col-sm-4">
											<label class=""for="forte">특기</label>
										</div>
										<div class="col-xs-12 col-sm-8">
											<input type="email" class="form-control input-sm" id="forte">
										</div>
									</td>
								</tr>
								<tr>
									<td class="row">
										<div class="col-xs-12 col-sm-4">
											<label class="" for="email">Email</label>
										</div>
										<div class="col-xs-12 col-sm-8">
											<input type="email" class="form-control input-sm" id="email">
										</div>
									</td>
								</tr>
								<tr>
									<td class="row">
										<div class="col-xs-12 col-sm-4">
											<label class="" for="email">우편번호</label>
										</div>
										<div class="col-xs-7 col-sm-4">
											<input type="text" class="form-control input-sm" id="zipcode" readonly="readonly">
										</div>
										<div class="col-xs-5 col-sm-4">
											<span class="btn btn-default" onclick="$.zipcode.zipcodeSerch('zipcode','addr11','addr12','lat','lng');">
												우편검색
											</span>
										</div>
									</td>
								</tr>
								<tr>
									<td class="row">
										<div class="col-xs-12 col-sm-4">
											<label class="" for="email">주소</label>
											<span class="markerCheck hidden-xs btn btn-default">주소보기</span>
										</div>
										<div class="col-xs-12 col-sm-8">
											<input type="text" class="form-control input-sm" id="addr11">
											<div class="padding-top-10"></div>
											<input type="text" class="form-control input-sm" id="addr12">
										</div>
									</td>
								</tr>
								</table>
								<div class="panel-footer">
									<div class="joinbtn btn btn-default">
										<i class="fa fa-check-square fa-lg"></i> 회원가입
									</div>
								</div>
							</div>
						</div>
						
						<div class="hidden-xs col-sm-6 placeholder">
							<div class="panel panel-default">
								<div class="panel-heading">
									지도확인
								</div>
								<!-- 지도영역 크기지정 -->
								<div id="map" style="width:100%;height:400px;"></div>
								<div class="panel-footer">
									<div class="row">
										<div class="col-xs-12 col-sm-4">
											<input type="checkbox" class="option" id="chkTerrain"/> 지형정보 
										</div>
										<div class="col-xs-12 col-sm-4">
											<input type="checkbox" class="option" id="chkTraffic"/> 교통정보
										</div>
										<div class="col-xs-12 col-sm-4">
											<input type="checkbox" class="option" id="chkBicycle"/> 자전거도로 정보
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
			
			
		</div>
	</div>
</body>
<!-- 스크립트 -->
<script type="text/javascript" src="js/util/map.js"></script>
<script type="text/javascript" src="js/util/zipcode.js"></script>
<!-- 구글 지도 API -->
<script type="text/javascript" src="https://maps.google.com/maps/api/js?v=3.exp&region=KR"></script>
 <!-- 다음 우편검색 API -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<!-- 다음 지도 API / gocode 라이브러리 -->
<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=22aeffa0733ea85f70488205a8c703e4&libraries=services"></script>
<script type="text/javascript" src="js/user/join.js"></script>
<script type="text/javascript">
$(document).ready(function ()
{
	// select box 생성
	$("#gender").append("${gender}");
	$("#emails").append("${emails}");
});
</script>