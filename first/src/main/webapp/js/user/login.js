/**
 * 설명	: 유저 메니서 스크립트
 * 작성자	: 강정권
 * 작설일자	: 2016-01-21
 */


// 설명 : 필수 할목 설정
$(document).ready(function ()
{
	// 아이디 비밀번호 찾기
	$.util.urlMove(".idpwSearch","/idpwSearch.do");
	
	// 동의 페이지
	$.util.urlMove(".consent","/consent.do");
	
	// 엔터 로그인
	$.util.enterSet("password","login");
	
	
	// 쿠키 확인후 쿠키 삽입
	var userId = $.cookie("userId");
	if(userId != '')
	{
		$("#id").val(userId);
	}
	
	// 자동 포커스 설정
	var $id = $("#id");
	var $pw = $("#password");
	if($id.val() == "")
	{
		$id.focus();
	}
	else if ($pw.val() == "")
	{
		$pw.focus();
	}
	
});


//로그인 클릭
$(".login").on("click",function()
{
	var url = "/loginAction.do";
	var id = $("#id").val();
	var idArr = new Array("id","password");
	var result = {};
	// 유효성 검사
	if($.util.nullCheck("id","아이디 값은 필수 입니다.")) return false;
	if($.util.nullCheck("password","비밀번호 값은 필수 입니다.")) return false;
	
	// 아이디 쿠키 생성여부
	 $.util.cookieMk("userId", id);
	
	// jsonObject 생성
	result = $.util.jsonObjectMk(idArr);
	
	//Json 데이터 전송
	data = $.util.ajaxData(url, result);
	
	if(data.code == "SUCC")
	{
		location.href = "/index.do";
	}
	else
	{
		alertify.alert(data.msg);
		$("#password").focus();
	}
});