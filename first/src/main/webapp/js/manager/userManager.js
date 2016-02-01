/**
 * 설명	: 유저 메니서 스크립트
 * 작성자	: 강정권
 * 작설일자	: 2016-01-21
 */



// 페이지 이동
$.util.pageMove();

// 고객정보 수정
$(".viewInfo").on("click",function(){
	var url = "/userData.do";
	var no = $(this).attr("dir");
	var jsonObject = {no : no};
	var returnObj = {};
	var mapArr = {};
	
	returnObj = $.util.ajaxData(url, jsonObject);
	mapArr = returnObj.userVo;
	$.util.mapDataMove(mapArr);
	$.util.rowColor(this);
	
	$('#aModal').modal("show");
});

// 고객정보 수정
$(".update").on("click",function(){
	var url = "/userUpdate.do";
	var result = {};
	var userArr = new Array("no","id","name","birthday","gender","status");
	result = $.util.jsonObjectMk(userArr,"form");
	$.util.ajaxAction(url, location.href, result);
});

// 고객정보 삭제
$(".delete").on("click",function(){
	var url = "/userDelete.do";
	var result = {};
	var name = $("#name").val();
	var userArr = new Array("no");
	result = $.util.jsonObjectMk(userArr,"form");
	if(confirm(name + "님의 고객정보 를 삭제하시겠습니까 ?")){
		$.util.ajaxAction(url, location.href, result);
	}
});