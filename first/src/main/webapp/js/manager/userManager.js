/**
 * 설명	: 유저 메니서 스크립트
 * 작성자	: 강정권
 * 작설일자	: 2016-01-21
 */


/**
 * 설명 : 필수 할목 설정
 */
$(document).ready(function ()
{
	// 페이지 이동
	$.util.pageMove();
	
	// 모달 데이터 이동
	$(".viewInfo").on("click",function(){
		var idx = $(this).attr("dir");
		var authorityArr = new Array("id","name","birthday","gender","status");
		$.util.valueChang(authorityArr,idx);
		$('#aModal').modal("show");
		
		// 테이블 row 색상 변경 info
		$.util.rowColor(this);
	});
});
