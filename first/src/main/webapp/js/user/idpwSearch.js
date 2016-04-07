/**
 * 설명	: 아이디 비밀번호 찾기 스크립트
 * 작성자	: 강정권
 * 작설일자	: 2016-01-21
 */


// 토글 출력 함수
$.util.radioShow("label.btn","typeId","typePw");

// 아아디 찾기 ,pw 찾기
$(".search").on("click", function(){
	var url = "/idpwSearchAction.do";
	var type = $(this).attr("contextmenu");
	var idArr = new Array("name","email","type");
	var pwArr = new Array("id","email","type");
	var result = {};
	var ajax = false;
	
	// 구분값 삽입
	$("#type").val(type);
	
	// 유효성 검사
	if(type == "id")
	{
		if($.util.nullCheck("name","이름 값은 필수 입니다.")) return false;
		if($.util.nullCheck("emailId","이메일 은 필수 입니다.")) return false;
		// 이메일 유효성 검사
		if($.util.emailCheck("emailId","이메일형식에 맞지않습니다.")) return false;
		$("#email").val($("#emailId").val());
		// json object 생성
		result = $.util.jsonObjectMk(idArr);
	}
	else
	{
		if($.util.nullCheck("id","ID 값은 필수 입니다.")) return false;
		if($.util.nullCheck("emailPw","이메일 은 필수 입니다.")) return false;
		// 이메일 유효성 검사
		if($.util.emailCheck("emailPw","이메일형식에 맞지않습니다.")) return false;
		$("#email").val($("#emailPw").val());
		// json object 생성
		result = $.util.jsonObjectMk(pwArr);
	}
	
	// ajax 통신 후 collback
	$.util.ajaxAlert(url, result);
});


//아작스 시작시 실행
$(document).ajaxStart(function(){
	$.LoadingOverlay("show", {
		image		: "",
		target		: "",
		fontawesome	: "fa fa-spinner fa-spin"
	});
});

//아작스 종료 시 실행
$(document).ajaxStop(function(){
	$.LoadingOverlay("hide", {
		image		: "",
		target		: "",
		fontawesome : "fa fa-spinner fa-spin"
	});
});