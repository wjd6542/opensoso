/**
 * 설명	: 유저 메니서 스크립트
 * 작성자	: 강정권
 * 작설일자	: 2016-01-21
 */


// 권한 채크 함수
$.util.authorityCheck("m");


// 필수 항목 체크
$.util.mustInput();


//엔터 검색
$.util.enterSet("searchString","search");


// 게시판 삽입 설정
$(".insertData").on("click", function()
{
	$("form")[0].reset();
	$(".update").hide();
	$(".delete").hide();
	$(".insert").show();
	$("#aModal").modal("show");
});


// 게시판 설정 삽입
$(".insert").on("click", function()
{
	var url = "/insertBorder.do";
	var idArr = new Array("title","type","authority","rippleUser","fileUser","sort");
	var result = $.util.jsonObjectMk(idArr,"form");
	if($.util.nullCheck("title","게시판 명은 필수 입니다.")) return false;
	else if($.util.nullCheck("type","구분 은 필수 입니다.")) return false;
	else if($.util.nullCheck("authority","권한 은 필수 입니다.")) return false;
	
	// 아작스 처리 /요청 경로 / 자기페이지
	$.util.ajaxAction(url, location.href, result);
});


// 게시판 설정 삽입
$(".update").on("click", function()
{
	var url = "/updateBorder.do";
	var idArr = new Array("no","title","type","authority","rippleUser","fileUser","sort");
	var result = $.util.jsonObjectMk(idArr,"form");
	if($.util.nullCheck("title","게시판 명은 필수 입니다.")) return false;
	else if($.util.nullCheck("type","구분 은 필수 입니다.")) return false;
	else if($.util.nullCheck("authority","권한 은 필수 입니다.")) return false;
	
	// 아작스 처리 /요청 경로 / 자기페이지
	$.util.ajaxAction(url, location.href, result);
});


// 게시판 설정 삽입
$(".delete").on("click", function()
{
	var url = "/deleteBorder.do";
	var idArr = new Array("no");
	var result = $.util.jsonObjectMk(idArr,"form");
	
	if(confirm("삭제하시겠습니까 ?"))
	{
		// 아작스 처리 /요청 경로 / 자기페이지
		$.util.ajaxAction(url, location.href, result);
	}
});


// 게시판 수정 데이터 삽입
$(".viewInfo").on("click", function(){
	var url = "/borderData.do";
	var no = $(this).attr("dir");
	var jsonObject = {no : no};
	var returnObj = {};
	var mapArr = {};
	
	returnObj = $.util.ajaxData(url, jsonObject);
	mapArr = returnObj.borderVo;
	$.util.mapDataMove(mapArr);
	$.util.rowColor(this);
	
	$(".update").show();
	$(".delete").show();
	$(".insert").hide();
	$('#aModal').modal("show");
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