/**
 * 설명	: 게시판 리스트 스크립트
 * 작성자	: 강정권
 * 작설일자	: 2016-01-21
 */


$(document).ready(function ()
{
	// 페이지 이동
	$.util.pageMove();
	
	// 정렬 변경
	$.util.orderSet();
	
	// 정렬 색상 설정
	$.util.orderColorSet("order");
	
	// 엔터 검색
	$.util.enterSet("searchString","search");
	
	// 권한처리 화면 출력
	$.util.borderAuthorityCheck("borderAuthority","userAuthority", "userbtn");
	
});



// 작성페이지
$(".insert").on("click",function(){
	var url = "/borderWrite.do";
	$("#form").attr("action",url);
	$("#form").submit();
});


//작성페이지
$(".view").on("click",function(){
	var url = "/borderView.do";
	var borderNo = $(this).attr("dir");
	$("#borderNo").val(borderNo);
	$("#form").attr("action",url);
	$("#form").submit();
});