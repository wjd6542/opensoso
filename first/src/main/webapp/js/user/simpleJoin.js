/**
 * 설명	: 유저 메니서 스크립트
 * 작성자	: 강정권
 * 작설일자	: 2016-01-21
 */


// 필수 채크 함수
$.util.mustInput();

// 중복확인
$(".overlap").on("click", function(){
	var url = "/userIdCheck.do";
	var id = $("#id").val();
	var result = {id : id};
	var data = {};
	data = $.util.ajaxData(url, result);
	
	if($.util.nullCheck("id","아이디는 필수값입니다.")) return false;
	
	if(data.code == "SUCC")
	{
		alertify.alert(data.msg, function(e){
			$("#overlapCk").val("Y");
		});
	}
	else
	{
		alertify.alert(data.msg, function(e){
			$("#overlapCk").val("N");
		});
	}
});


// 회원가입
$(".join").on("click", function(){
	var url = "/userInsert.do";
	var returlUrl = "/index.do";
	var idArr = new Array("name","id","nickName","password","email");
	
	// 유효성 검사
	if($.util.nullCheck("id","아이디는 필수값입니다.")) return false;
	if($.util.nullCheck("overlapCk","중복검사를 해주세요.")) return false;
	if($.util.valueSameCheck("overlapCk","Y", "중복검사를 다시해 주세요.")) return false;
	if($.util.nullCheck("name","이름 은 필수값입니다.")) return false;
	if($.util.nullCheck("nickName","닉네임 은 필수값입니다.")) return false;
	if($.util.nullCheck("password","비밀번호 는 필수값입니다.")) return false;
	if($.util.nullCheck("pwCheck","비밀번호 확인 은 필수값입니다.")) return false;
	if($.util.pwCheck("password","비밀번호를 확인하세요.<br>(영문,숫자를 혼합하여 8~20자 이내)")) return false;
	if($.util.pwCheck("pwCheck","비밀번호를 확인하세요.<br>(영문,숫자를 혼합하여 8~20자 이내)")) return false;
	if($.util.nullCheck("email","Email 은 필수값입니다.")) return false;
	if($.util.emailCheck("email","Email 형식에 맞지 않습니다.")) return false;
	if($.util.pwSameCheck("password","pwCheck","비밀번호가 일치하지않습니다.")) return false;
	
	// json 형식 설정
	var result = $.util.jsonObjectMk(idArr,"form");
	
	// 아작스 리컨
	data = $.util.ajaxData(url, result);
	
	// 결과 확인
	if(data.code == "SUCC"){
		alertify.alert(data.msg, function(e){
			$(location).attr('href', returlUrl);
		});
		
	}else{
		alertify.alert(data.msg);
	}
});


// 아작스 시작
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