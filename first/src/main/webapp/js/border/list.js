/**
 * 설명	: 게시판 리스트 스크립트
 * 작성자	: 강정권
 * 작설일자	: 2016-01-21
 */



// 페이지 이동
$.util.pageMove();

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