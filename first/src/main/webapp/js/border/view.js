/**
 * 설명	: 게시판 리스트 스크립트
 * 작성자	: 강정권
 * 작설일자	: 2016-01-21
 */


//작성페이지
$(".update").on("click",function()
{
	var url = "/borderWrite.do";
	$("#form").attr("action",url);
	$("#form").submit();
});


// 추천수 수정, 추천수 다운
$(".hitUp, .hitDown").on("click",function()
{
	var url = "/GoodCntAction.do";
	var no = $("#borderNo").val();
	var actionType = $(this).attr("contextmenu");
	var data = {};
	var result = {no : no, actionType : actionType};
	
	// 아작스 결과
	data = $.util.ajaxData(url, result);
	
	// 결과 출력
	if(data.code == "SUCC")
	{
		$(".goodCnt").text(data.goodCnt);
	}
	else
	{
		alertify.alert(data.msg);
	}
});


// 파일다운로드
$(".fileDown").on("click",function()
{
	var url = "/fileDown.do";
	var no = $(this).attr("dir");
	var result = {no : no};
	$.util.fileDown(url, result, 'post');
});


// 비공개 처리
$(".secret").on("click",function()
{
	var url = "/borderSecret.do";
	var no = $("#borderNo").val();
	var result = {no : no};
	var data = {};
	data = $.util.ajaxData(url, result);
	
	// 결과 출력
	if(data.code == "SUCC")
	{
		alertify.alert(data.msg, function(e)
		{
			$("#form").attr("action","/borderList.do");
			$("#form").submit();
		});
	}
	else
	{
		alertify.alert(data.msg);
	}
});


// 쪽지 발송
$(".send").on("click",function()
{
	var url = "/sendNote.do";
	var idArr = new Array("fromId","toId","toName","title","memo");
	var result = {};
	var data = {};
	
	// 유효성 검사
	if($.util.nullCheck("title","제목 필수 입니다.")) return false;
	if($.util.nullCheck("memo","내용 은 필수 입니다.")) return false;
	
	// json 생성
	result = $.util.jsonObjectMk(idArr);
	
	// 아작스 실행
	data = $.util.ajaxData(url, result);
	
	if(data.code == "SUCC")
	{
		alertify.alert(data.msg,function(e){
			$("#noteModal").modal("hide");
		});
	}
	else
	{
		alertify.alert(data.msg);
	}
});