<%
/**
 * 
 * @author	강정권
 * @date	2016-03-05
 * @tip		개인정보   화면
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
		
		<!-- 개인정보 str -->
		<div class="col-xs-12 col-sm-8 placeholder">
			
			<div class="pull-left">
				<h3>개인정보</h3>
			</div>
			<div class="pull-right padding-top-15">
				<div class="dropdown">
						<button id="dLabel" class="btn btn-block btn-default" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							<i class="fa fa-cog"></i> 설정
							<span class="caret"></span>
						</button>
						<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
							<li class="modeldata" contextmenu="pwModal">
								<a href="#">비밀번호 수정</a>
							</li>
							<li class="modeldata" contextmenu="infoModal">
								<a href="#">정보 수정</a>
							</li>
							<li class="leave">
								<a href="#">탈퇴</a>
							</li>
						</ul>
					</div>
			</div>
			
			<table class="table table-bordered">
			<tr>
				<td>
					<div class="row">
						<div class="col-xs-12 col-sm-4">
							아이디
						</div>
						<div class="col-xs-12 col-sm-8">
							${user.id}
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="row">
						<div class="col-xs-12 col-sm-4">
							이름
						</div>
						<div class="col-xs-12 col-sm-8">
							${user.name}
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="row">
						<div class="col-xs-12 col-sm-4">
							닉네임
						</div>
						<div class="col-xs-12 col-sm-8">
							${user.nickName}
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="row">
						<div class="col-xs-12 col-sm-4">
							이메일
						</div>
						<div class="col-xs-12 col-sm-8">
							${user.email}
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="row">
						<div class="col-xs-12 col-sm-4">
							성별
						</div>
						<div class="col-xs-12 col-sm-8">
							${user.gender}
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="row">
						<div class="col-xs-12 col-sm-4">
							취미
						</div>
						<div class="col-xs-12 col-sm-8">
							${user.hobby}
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="row">
						<div class="col-xs-12 col-sm-4">
							특기
						</div>
						<div class="col-xs-12 col-sm-8">
							${user.forte}
						</div>
					</div>
				</td>
			</tr>
			</table>
		</div>
		<!-- 개인정보 end -->
		
		
		
		
		<!-- 비밀번호 변경 모달 str -->
		<div class="modal fade" id="pwModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title">비밀번호 변경</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-xs-12 col-sm-3">
								<label class="check" for="prepw">기존비밀번호</label>
							</div>
							<div class="col-xs-12 col-sm-9">
								<input type="password" class="form-control" id="prepw" name="prepw">
							</div>
						</div>
						<div class="padding-top-10"></div>
						<div class="row">
							<div class="col-xs-12 col-sm-3">
								<label class="check" for="password">수정비밀번호</label>
							</div>
							<div class="col-xs-12 col-sm-9">
								<input type="password" class="form-control" id="password" name="password">
							</div>
						</div>
						<div class="padding-top-10"></div>
						<div class="row">
							<div class="col-xs-12 col-sm-3">
								<label class="check" for="pwcheck">수정비밀번호 확인</label>
							</div>
							<div class="col-xs-12 col-sm-9">
								<input type="password" class="form-control" id="pwcheck" name="pwcheck">
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<span class="pwChang btn btn-primary">
							<i class="fa fa-check-circle-o"></i> 비밀번호 수정
						</span>
					</div>
				</div>
			</div>
		</div>
		<!-- 비밀번호 변경 모달 end -->
		
		
		<!-- 정보 수정 모달 str -->
		<div class="modal fade" id="infoModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title">정보 변경</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-xs-12 col-sm-3">
								<label class="check" for="id">아아디</label>
							</div>
							<div class="col-xs-12 col-sm-9">
								<input type="text" class="form-control" id="id" name="id" value="${user.id}" readonly="readonly">
							</div>
						</div>
						<div class="padding-top-10"></div>
						<div class="row">
							<div class="col-xs-12 col-sm-3">
								<label class="check" for="name">이름</label>
							</div>
							<div class="col-xs-12 col-sm-9">
								<input type="text" class="form-control" id="name" name="name" value="${user.name}">
							</div>
						</div>
						<div class="padding-top-10"></div>
						<div class="row">
							<div class="col-xs-12 col-sm-3">
								<label class="check" for="nickName">닉네임</label>
							</div>
							<div class="col-xs-12 col-sm-9">
								<input type="text" class="form-control" id="nickName" name="nickName" value="${user.nickName}">
							</div>
						</div>
						<div class="padding-top-10"></div>
						<div class="row">
							<div class="col-xs-12 col-sm-3">
								<label class="check" for="email">Email</label>
							</div>
							<div class="col-xs-12 col-sm-9">
								<input type="text" class="form-control" id="email" name="email" value="${user.email}">
							</div>
						</div>
						<div class="padding-top-10"></div>
						<div class="row">
							<div class="col-xs-12 col-sm-3">
								<label class="" for="hobby">취미</label>
							</div>
							<div class="col-xs-12 col-sm-9">
								<input type="text" class="form-control" id="hobby" name="hobby" value="${user.hobby}">
							</div>
						</div>
						<div class="padding-top-10"></div>
						<div class="row">
							<div class="col-xs-12 col-sm-3">
								<label class="" for="forte">특기</label>
							</div>
							<div class="col-xs-12 col-sm-9">
								<input type="text" class="form-control" id="forte" name="forte" value="${user.forte}">
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<span class="infoChang btn btn-primary" contextmenu="Update">
							<i class="fa fa-check-circle-o"></i> 수정
						</span>
					</div>
				</div>
			</div>
		</div>
		<!-- 정보 수정 모달  end -->
	
	</div>
</body>