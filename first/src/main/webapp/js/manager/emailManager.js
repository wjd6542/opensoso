/**
 * 설명	: 유저 메니서 스크립트
 * 작성자	: 강정권
 * 작설일자	: 2016-01-21
 */


// 권한 채크 함수
$.util.authorityCheck("m");


// 페이지 이동
$.util.pageMove();


//엔터 검색
$.util.enterSet("searchString","search");


// 고객정보 수정
$(".viewInfo").on("click",function(){
	var url = "/emailData.do";
	var no = $(this).attr("dir");
	var jsonObject = {no : no};
	var data = {};
	var mapArr = {};
	
	data = $.util.ajaxData(url, jsonObject);
	mapArr = data.emailVo;
	$.util.mapDataMove(mapArr);
	$.util.rowColor(this);
	
	$('#aModal').modal("show");
});


// 고객정보 삭제
$(".delete").on("click",function(){
	var url = "/emailDelete.do";
	var result = {};
	var idArr = new Array("no");
	result = $.util.jsonObjectMk(idArr,"form");
	alertify.confirm("메일정보 를 삭제하시겠습니까 ?", function(e){
		if(e) $.util.ajaxAction(url, location.href, result);
	});
});