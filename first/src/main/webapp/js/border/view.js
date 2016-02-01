/**
 * 설명	: 게시판 리스트 스크립트
 * 작성자	: 강정권
 * 작설일자	: 2016-01-21
 */


// 파일 다운로드 함수
$.download = function(url, data, method){
	// url과 data를 입력받음
	if( url && data ){ 
		// data 는  string 또는 array/object 를 파라미터로 받는다.
		data = typeof data == 'string' ? data : jQuery.param(data);
		// 파라미터를 form의  input으로 만든다.
		var inputs = '';
		$.each(data.split('&'), function(){ 
			var pair = this.split('=');
			inputs+='<input type="hidden" name="'+ pair[0] +'" value="'+ pair[1] +'" />'; 
		});
		// request를 보낸다.
		$('<form action="'+ url +'" method="'+ (method||'post') +'">'+inputs+'</form>').appendTo('body').submit().remove();
	};
};

//작성페이지
$(".update").on("click",function(){
	var url = "/borderWrite.do";
	$("#form").attr("action",url);
	$("#form").submit();
});


// 추천수 수정, 추천수 다운
$(".hitUp, .hitDown").on("click",function(){
	var url = "/GoodCntAction.do";
	var no = $("#borderNo").val();
	var actionType = $(this).attr("contextmenu");
	var data = {};
	var result = {no : no, actionType : actionType};
	
	// 아작스 결과
	data = $.util.ajaxData(url, result);
	
	// 결과 출력
	if(data.code == "SUCC"){
		$(".goodCnt").text(data.goodCnt);
	}else{
		alert(data.msg);
	}
});


// 파일다운로드
$(".fileDown").on("click",function(){
	var url = "/fileDown.do";
	var no = $(this).attr("dir");
	var result = {no : no};
	$.download(url, result, 'post');
});


// 비공개 처리
$(".secret").on("click",function(){
	var url = "/borderSecret.do";
	var no = $("#borderNo").val();
	var result = {no : no};
	
	data = $.util.ajaxData(url, result);
	
	// 결과 출력
	if(data.code == "SUCC"){
		alert(data.msg);
		$("#form").attr("action","/borderList.do");
		$("#form").submit();
	}else{
		alert(data.msg);
	}
});