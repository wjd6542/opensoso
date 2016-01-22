<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<jsp:include page="/include/header.jsp"/>
<div class="container">
	<div class="col-xs-12 col-sm-offset-4 col-sm-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-title">에러 - 405</div>
			</div>
			<div class="panel-body">
				<div class="text-center">
					<img class="wid-100" src="/img/405.png">
					<h4>
						불법적인 접근입니다.<br>
						해당 페이지는 불법적인 접근이 금지되어 있습니다.
					</h4>
				</div>
			</div>
		</div>
		<a class="btn btn-default" href="javascript:history.back();">뒤로가기</a>
		<a class="btn btn-default" href="/index.do">메인화면으로</a>
	</div>
</div>