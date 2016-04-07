/**
 * 설명	: 파일관리 스크립트
 * 작성자	: 강정권
 * 작설일자	: 2016-01-21
 */


// 페이지 이동
$.util.pageMove();


//엔터 검색
$.util.enterSet("searchString","search");


// 검색
$(".search").on("click", function(){
	var url = "/fileManager.do";
	$("#form").attr("action",url);
	$("#form").submit();
});


// 전체 선택
$("#checkAll").on("click", function(){
	var chk = $(this).is(":checked");
	if(chk)
		$(".check").prop("checked",true);
	else
		$(".check").prop("checked",false);
});


//파일다운로드
$(".fileDown").on("click",function(){
	var url = "/fileDown.do";
	var no = $(this).attr("contextmenu");
	var result = {no : no};
	$.util.fileDown(url, result, 'post');
});


// 파일 삭제
$(".delete").on("click",function(){
	var url = "/fileDelete.do";
	var name = $(this).attr("dir"); 
	var no = $(this).attr("contextmenu");
	var result = {no : no};
	if(confirm(name + "파일을 삭제하시겠습니까 ?")){
		$.util.ajaxAction(url, location.href, result);
	}
});


//일괄 다운로드
$(".bachDown").on("click",function(){
	var url = "/bachDown.do";
	var noArr = [];
	$("input[name='check']:checked").each(function(i) {
		 noArr.push($(this).val());
	});
	
	var result = {"noArr" :JSON.stringify(noArr)};
	$.util.fileDown(url, result, 'post');
});


// 일괄 파일 삭제
$(".bachDelete").on("click",function(){
	var url = "/bachDelete.do";
	var result = {no : no};
	if(confirm(name + "파일을 삭제하시겠습니까 ?")){
		$.util.ajaxAction(url, location.href, result);
	}
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