/**
 * 설명	: 유저 메니서 스크립트
 * 작성자	: 강정권
 * 작설일자	: 2016-01-21
 */

// 설정 변경시
$(".gbox").on("click" ,function() {
	$(".confs").change(function() {
		confCookieSet(this);
	});
});


// 쪽지 설정여부
$(".gbox").on("click" ,function() {
	$(".noteCk").change(function() {
		var url = "/noteStatusSet.do";
		var val = $(this).prop('checked');
		var no = $(this).val();
		var result = {};
		var data = {};
		var noteStatus = "";
		if(val == "true")
			noteStatus = "Y";
		else
			noteStatus = "N";
		
		result = {no : no, noteStatus : noteStatus}
		data = $.util.ajaxData(url, result);
		
		if(data.code == "SUCC")
		{
			// 쿠키 생성
			confCookieSet(this);
		}
		else
		{
			alertify.alert(data.msg);
		}
		
	});
});


// 화경설정 함수
function confCookieSet(thiss)
{
	var cookieId = $(thiss).prop('id');
	var val = $(thiss).prop('checked');
	$.util.cookieMk(cookieId, val);
	alertify.alert("설정이 적용 되었습니다.", function(e){
		location.reload();
	});
}


// 환경설정 제셋팅 함수
function setconf(cookieId)
{
	var check = $.cookie(cookieId);
	if(check == "true")
		$("#"+cookieId).bootstrapToggle("on");
	else
		$("#"+cookieId).bootstrapToggle("off");
}


setconf("sideLocationCk");
setconf("sideShowCk");
setconf("noteCk");