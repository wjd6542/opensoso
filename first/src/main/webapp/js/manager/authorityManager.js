/**
 * 설명	: 접근 메니저 스크립트
 * 작성자	: 강정권
 * 작설일자	: 2016-02-23
 */

// 권한 채크 함수
$.util.authorityCheck("m");

// 페이지 이동
$.util.pageMove();

//필수 항목 체크
$.util.mustInput();

//엔터 검색
$.util.enterSet("searchString","search");