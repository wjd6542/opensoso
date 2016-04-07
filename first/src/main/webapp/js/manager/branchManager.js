/**
 * 설명	: 부서관리 스크립트
 * 작성자	: 강정권
 * 작설일자	: 2016-02-23
 */

// 필수 항목 체크
$.util.mustInput();

// 권한 채크 함수
$.util.authorityCheck("m");

// 페이지 이동
$.util.pageMove();

//엔터 검색
$.util.enterSet("searchString","search");

$.util.onlyMoney();
$.util.onlyHan();
$.util.onlyNum();

// 모달 출력
$(".view").on("click", function(){
	var url = "/branchData.do";
	var no = $(this).attr("contextmenu");
	var result = {no : no};
	if(no)
	{
		data = $.util.ajaxData(url, result);
		$.util.mapDataMove(data.branchVo);
		$('#aModal').modal("show");
	}
	else
	{
		$(".form-control").val('');
		$('#aModal').modal("show");
	}
});


// 삽입
$(".action").on("click", function(){
	var url = "/branchActoin.do";
	var actionType = $(this).attr("contextmenu");
	var idArr = new Array("no","code","name","sort","memo","grupNo","actionType");
	var result = "";
	$("#actionType").val(actionType);
	if($.util.nullCheck("code","게시판 명은 필수 입니다.")) return false;
	else if($.util.nullCheck("name","게시판 명은 필수 입니다.")) return false;
	
	result = $.util.jsonObjectMk(idArr);
	
		// 아작스 처리 /요청 경로 / 자기페이지
	$.util.ajaxAction(url, location.href, result);
});

//삽입
$(".subIn").on("click", function(){
	var url = "/branchNum.do";
	var no = $(this).attr("contextmenu");
	var result = {no : no};
	data = $.util.ajaxData(url, result);
	
	alert(data.depthNo);
	$("#depthNo").val(data.depthNo);
	$("#grupNo").val(no);
	$(".form-control").val('');
	$('#aModal').modal("show");
});