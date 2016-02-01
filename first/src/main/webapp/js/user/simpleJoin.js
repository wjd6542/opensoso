/**
 * 설명	: 유저 메니서 스크립트
 * 작성자	: 강정권
 * 작설일자	: 2016-01-21
 */


$(document).ajaxStart(function(){
	$.LoadingOverlay("show", {
		image		: "",
		target		: "aModal",
		fontawesome	: "fa fa-spinner fa-spin"
	});
});


$(document).ajaxStop(function(){
	$.LoadingOverlay("hide", {
		image		: "",
		target		: "aModal",
		fontawesome : "fa fa-spinner fa-spin"
	});
});


$(".join").on("click", function(){
	var url = "/userInsert.do";
	var idArr = new Array("name","id","password","email","emails");
	
	// 유효성 검사
	if($.util.nullCheck("name","이름 값은 필수값입니다.","")) return false;
	if($.util.nullCheck("id","아이디값은 필수값입니다.","")) return false;
	if($.util.nullCheck("password","비밀번호 값은 필수값입니다.","")) return false;
	if($.util.nullCheck("pwCheck","비밀번호 확인 값은 필수값입니다.","")) return false;
	
	// json 형식 설정
	var result = $.util.jsonObjectMk(idArr,"form");
	
	// 아작스 리컨
	data = $.util.ajaxData(url, result);
	
	// 결과 확인
	if(data.code == "SUCC"){
		alert(data.msg);
	}else{
		alert(data.msg);
	}
});
