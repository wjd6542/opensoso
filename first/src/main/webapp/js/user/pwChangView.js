/**
 * 설명	: 유저 메니서 스크립트
 * 작성자	: 강정권
 * 작설일자	: 2016-01-21
 */


// 필수 항목 채크
$.util.mustInput();


// 비밀번호 변경
$(".pwChang").on("click", function(){
	var url = "/passwordChang.do";
	var returnUrl = "/login.do";
	var iaArr = new Array("citation","password");
	var result = {};
	
	// 유효성검사
	if($.util.nullCheck("citation","인증번호 는 필수값 입니다.")) return false;
	if($.util.nullCheck("password","수정 비밀번호는 필수값 입니다.")) return false;
	if($.util.nullCheck("pwCheck","비밀번호 확인은 필수값 입니다.")) return false;
	
	// 비밀번호 유효성검사
	if($.util.pwCheck("password","비밀번호를 확인하세요.(영문,숫자를 혼합하여 8~20자 이내)")) return false;
	if($.util.pwCheck("pwCheck","비밀번호를 확인하세요.(영문,숫자를 혼합하여 8~20자 이내)")) return false;
	
	// 비밀번호 일치 검사
	if($.util.pwSameCheck("password","pwCheck","비밀번호가 일치하지않습니다.")) return false;
	
	// json object 생성
	result = $.util.jsonObjectMk(iaArr);
	
	// ajax 실행
	$.util.ajaxAction(url, returnUrl, result);
	
});


//아작스 시작
$(document).ajaxStart(function(){
	$.LoadingOverlay("show", {
		image		: "",
		target		: "aModal",
		fontawesome	: "fa fa-spinner fa-spin"
	});
});


//아작스 종료
$(document).ajaxStop(function(){
	$.LoadingOverlay("hide", {
		image		: "",
		target		: "aModal",
		fontawesome : "fa fa-spinner fa-spin"
	});
});