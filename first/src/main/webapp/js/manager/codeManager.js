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
	// 필수 항목 체크
	$.util.mustInput();
	
	// 테이블 생성
	$(".dataTable").DataTable();
	
	// 가이드 쿠키 설정
	$.util.toggleCookie("guide","guideCheck");
	
	// 가이드 출력 여부
	var cookieVal = $.cookie("guideCheck");
	if(cookieVal == "Y")
	{
		$(".tip").show();
	}
	else
	{
		$(".tip").hide();
	}
	
	
	// 검색
	$(".codeSearch").on("click",function(){
		var no = $(this).attr("dir");
		$("#form2 #systemCode").val(no);
		$("#form2").attr("action","/codeManager.do");
		$("#form2").submit();
	});
	
	// 모달 화면 데이터 삽입
	$(".dataShow").on("click",function(){
		var div = $(this).attr("contextmenu");
		var idx = $(this).attr("dir");
		var codeArr = new Array("code","title","memo");
		var valueArr = new Array("code","title","sort","memo");
		
		if(div == "pcode"){
			$.util.formValueChang(codeArr, "form1", idx);
			$('#codeModal').modal("show");
		}else{
			$.util.formValueChang(valueArr, "form2", idx);
			$('#valueModal').modal("show");
		}
	});
	
	
	// acioin 타입 구분한다
	$(".insert, .update").on("click",function(){
		// 처리 구분
		var actionType = $(this).attr("contextmenu");
		// 환경설정 코드 아이디 배열
		var codeArray = new Array("no","code","title","memo","actionType");
		// 환결설정 결과 아이디 배열
		var valueArray = new Array("no","systemCode","code","title","memo","actionType");
		var result = {};
		
		// 구분에 따른 유효성검사를 실시
		if(actionType == "codeInsert")
		{
			if($.util.nullCheck("form1 #code","코드값은 필수 입니다.")) return false;
			if($.util.nullCheck("form1 #title","코드명은 필수 입니다.")) return false;
			$("#form1 #actionType").val(actionType);
			result = $.util.jsonObjectMk(codeArray,"form1");
			
		}
		else if(actionType == "codeUpdate")
		{
			if($.util.nullCheck("form1 #code","코드값은 필수 입니다.")) return false;
			if($.util.nullCheck("form1 #title","코드명은 필수 입니다.")) return false;
			$("#form1 #actionType").val(actionType);
			result = $.util.jsonObjectMk(codeArray,"form1");
		}
		else if(actionType == "valueInsert")
		{
			if($.util.nullCheck("form2 #code","코드값은 필수 입니다.")) return false;
			if($.util.nullCheck("form2 #title","코드명은 필수 입니다.")) return false;
			$("#form2 #actionType").val(actionType);
			result = $.util.jsonObjectMk(valueArray,"form2");
		}
		else if(actionType == "valueUpdate")
		{
			if($.util.nullCheck("form2 #code","코드값은 필수 입니다.")) return false;
			if($.util.nullCheck("form2 #title","코드명은 필수 입니다.")) return false;
			$("#form2 #actionType").val(actionType);
			result = $.util.jsonObjectMk(valueArray,"form2");
		}
		// 아작스 처리 /요청 경로 / 자기페이지
		$.util.ajaxAction("/systemAction.do", "/codeManager.do", result);
	});
	
	
	// 중복확인
	$(".check").on("click",function(){
		var value = "";
		var result = {};
		// 환경설정 코드 아이디 배열
		var idArray = new Array("code","actionType");
		// 환결설정 결과 아이디 배열
		var actionType = $(this).attr("contextmenu");
		
		if(actionType == "code")
		{
			if($.util.nullCheck("form1 #code","코드값은 필수 입니다.")) return false;
			$("#form1 #actionType").val(actionType);
			result = $.util.jsonObjectMk(idArray,"form1");
		}
		else
		{
			if($.util.nullCheck("form2 #code","코드값은 필수 입니다.")) return false;
			$("#form2 #actionType").val(actionType);
			result = $.util.jsonObjectMk(idArray,"form2");
		}
		// 아작스 처리 /요청 경로 / 자기페이지
		$.util.ajaxAction("/overlapCheck.do", location.href, result);
	});
	
	
	// 글 삭제
	$(".del").on("click",function(){
		var actionType = $(this).attr("contextmenu");
		var no = $(this).attr("dir");
		var idArray = new Array("no","actionType");
		var formDiv = "";
		var result = {};
		if(actionType == "codeDelete")
		{
			formDiv = "form1";
			$("#form1 #actionType").val(actionType);
			$("#form1 #no").val(no);
		}
		else
		{
			formDiv = "form2";
			$("#form2 #actionType").val(actionType);
			$("#form2 #no").val(no);
		}
		
		if(confirm("삭제하시겠습니까 ?")){
			// 아작스 처리 /요청 경로 / 자기페이지
			result = $.util.jsonObjectMk(idArray, formDiv);
			$.util.ajaxAction("/deleteCode.do", "/codeManager.do", result);
		}
		else
		{
			return false;
		}
	});
});
