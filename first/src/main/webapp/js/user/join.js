/**
 * 설명	: 유저 메니서 스크립트
 * 작성자	: 강정권
 * 작설일자	: 2016-01-21
 */


/**
 * 설명 : 필수 할목 설정
 */
$(document).ready(function ()
{
	// 필수채크
	$.util.mustInput();
	
	/*
	// 구글 지도 생성 map객체생성 ID, 위도ID, 경도ID
	var map = $.daum.gmakeMap("map","lat","lng");
	google.maps.event.addDomListener(window, 'load', map);
	// 마커 생성
	$(".markerCheck").on("click", function(){
		$.util.nullCheck("zipcode","주소검색을 먼제 해주세요.");
		$.daum.gmapMarker(map,"lat","lng","addr11");
	});
	*/ 
	
	
	// 지도생성
	var map = $.daum.makeMap("map","lat","lng");
	
	// 지도 옵션 클릭시
	$(".option").on("click", function(){
		$.daum.mapOption(map);
	});
	
	
	// 마커생성
	$(".markerCheck").on("click", function(){
		$.util.nullCheck("zipcode","주소검색을 먼저 해주세요.");
		$.daum.mapMarker(map,"lat","lng","addr11");
	});
	
});

// 아이디 중복 확인
$(".idCheck").on("click",function(){
	var url = "/userIdCheck.do";
	var id = $("#id").val();
	var result = {id : id};
	
	// 유효성 검사
	if($.util.nullCheck("id","아이디값은 필수값입니다.")) return false;
	
	// ajax 실행
	$.util.ajaxAlert(url, result);
});



//회원가입
$(".joinbtn").on("click",function(){
	var url = "/userInsert.do";
	var idArr = new Array("id","password","name","birthday","phon","gender","hobby","forte","email","zipcode","addr11","addr12");
	var rerult = {};
	
	// 유효성 검사
	if($.util.nullCheck("id","아이디값은 필수값입니다.")) return false;
	if($.util.nullCheck("password","비밀번호 값은 필수값입니다.")) return false;
	if($.util.nullCheck("pwCheck","비밀번호 확인 값은 필수값입니다.")) return false;
	if($.util.nullCheck("name","이름 값은 필수값입니다.")) return false;
	if($.util.nullCheck("birthday","생년월일 값은 필수값입니다.")) return false;
	if($.util.nullCheck("phon","휴대전화 값은 필수값입니다.")) return false;
	if($.util.nullCheck("gender","성별 값은 필수값입니다.")) return false;
	if($.util.nullCheck("email","Email 값은 필수값입니다.")) return false;
	if($.util.pwCheck("password","","비밀번호를 확인하세요.₩n(영문,숫자를 혼합하여 8~20자 이내)")) return false;
	if($.util.pwCheck("pwCheck","","비밀번호를 확인하세요.₩n(영문,숫자를 혼합하여 8~20자 이내)")) return false;
	if($.util.pwSameCheck("password","pwCheck","비밀번호가 일치하지않습니다.")) return false;
	if($.util.emailCheck("email","Email 형식에 맞지 않습니다.")) return false;
	
	// jsonObject 생성
	rerult = $.util.jsonObjectMk(idArr);
	
	// ajax 처리
	$.util.ajaxAction(url, "/index.do", result);
});