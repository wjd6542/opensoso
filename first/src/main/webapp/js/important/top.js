/**
 * 설명	: 주요 스크립트 파일
 * 작성자	: 강정권
 * 작설일자	: 2016-03-05
 */

// 기본 실행 파일들
$(document).ready(function ()
{
	// 달력
	$('.date').datepicker({
		language : 'ko',
		format: 'yyyy-mm-dd',
		todayHighlight: true
	});
	
	// 사이듬뉴 색상 설정
	$.util.setColor(".sidemenu","memuid","Y");
	// 툴팁
	$('[data-toggle="tooltip"]').tooltip();
	// 사이드 메뉴 위치 설정
	$.util.confSideLocationSet("sideLocationCk", "sidebar");
	// 사이드 메뉴  출력여부
	$.util.confSideShowSet("sideShowCk", "sidebar");
	// 쪽지 출력여부
	$.util.confoteUesSet("noteCk", "notebtn");
});