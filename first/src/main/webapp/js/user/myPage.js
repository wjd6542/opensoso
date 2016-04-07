/**
 * 설명	: 유저 메니서 스크립트
 * 작성자	: 강정권
 * 작설일자	: 2016-01-21
 */


// 권한 채크 함수
$.util.authorityCheck("u");


// 필수 항목 채크
$.util.mustInput();


// 이미지 미리보기
$("#file").on('change', function(){
	// readURL(this);
	$.util.imgRead(this, "file", "profileImg");
});


// 미리보기 이미지 삭제
$(".fileDelete").on('click', function(){
	$(".profileImg").attr("src", "img/noimage.gif");
	$("#file").val('');
});


// 비밓번호, 개인정보 수정 모달 출력
$(".modeldata").on("click", function(){
	var div = $(this).attr("contextmenu");
	$("#" + div).modal("show");
});


// 작성 페이지 이동
$(".move").on("click", function(){
	var url = "/borderView.do";
	var borderNo = $(this).attr("dir");
	var borderType = $(this).attr("contextmenu");
	$("#borderNo").val(borderNo);
	$("#borderType").val(borderType);
	$("#form").attr("action", url);
	$("#form").submit();
});


// 탈퇴처리
$(".leave").on("click", function(){
	var url = "/leave.do";
	var no = $("#no").val();
	var result = {no : no};
	
	//메시지 알림
	alertify.confirm("탈퇴하시겠습니까?", function (e) {
		if (e) {
			// ajax 실행
			$.util.ajaxAction(url, location.href, result);
		} else {
			alertify.success("미탈퇴");
		}
	});
});


// 개인사진 이미지 업로드
$(".fileUpload").on("click", function(){
	var url = "/profileUpload.do";
	var result = {};
	var data = {};
	// 유효성검사
	if($.util.nullCheck("file","이미지 파일을 선택해 주세요.")) return false;
	// from 데이터  추출
	result = new FormData($("#form")[0]);
	// ajax collback 추출
	data = $.util.ajaxFrom(url, result);
	
	
	if(data.code == "SUCC")
	{
		alertify.success(data.msg);
		location.reload();
	}
	else
	{
		alertify.success(data.msg);
	}
	
});


// 비밀번호 변경
$(".pwChang").on("click", function(){
	var url = "/passwordChang.do";
	var iaArr = new Array("no","password");
	var result = {};
	
	// 유효성검사
	if($.util.nullCheck("prepw","기존 비밀번호는 필수값 입니다.")) return false;
	if($.util.nullCheck("password","수정 비밀번호는 필수값 입니다.")) return false;
	if($.util.nullCheck("pwcheck","비밀번호 확인은 필수값 입니다.")) return false;
	
	// 비밀번호 유효성검사
	// if($.util.pwCheck("prepw","비밀번호를 확인하세요.(영문,숫자를 혼합하여 8~20자 이내)")) return false;
	if($.util.pwCheck("password","비밀번호를 확인하세요.(영문,숫자를 혼합하여 8~20자 이내)")) return false;
	if($.util.pwCheck("pwcheck","비밀번호를 확인하세요.(영문,숫자를 혼합하여 8~20자 이내)")) return false;
	
	// 비밀번호 일치 검사
	if($.util.pwSameCheck("password","pwcheck","비밀번호가 일치하지않습니다.")) return false;
	
	// json object 생성
	result = $.util.jsonObjectMk(iaArr);
	
	// ajax 실행
	$.util.ajaxAction(url, location.href, result);
	
});


// 개인정보 수정
$(".infoChang").on("click", function(){
	var url = "/userUpdate.do";
	var iaArr = new Array("no","name","nickName","email","hobby","forte");
	var result = {};
	
	// 유효성 검사
	if($.util.nullCheck("name","기존 비밀번호는 필수값 입니다.")) return false;
	if($.util.nullCheck("nickName","수정 비밀번호는 필수값 입니다.")) return false;
	if($.util.nullCheck("email","Email 은 필수값입니다.")) return false;
	if($.util.emailCheck("email","Email 형식에 맞지 않습니다.")) return false;
	
	// json object 생성
	result = $.util.jsonObjectMk(iaArr);
	
	// ajax 실행
	$.util.ajaxAction(url, location.href, result);
});


// 쪽지 읽기 처리
$(".readView").on("click", function(){
	var url = "/readNote.do";
	var no = $(this).attr("contextmenu");
	var check = $(this).attr("role");
	var result = {no : no, check : check};
	data = $.util.ajaxData(url, result);
	if(data.code == "SUCC")
	{
		mapArr = data.noteVo;
		$.util.mapDataMove(mapArr);
		$("#noteModal").modal("show");
	}
	else
	{
		alertify.alert(data.msg);
	}
});


// 쪽지 삭제 처리
$(".noteDelete").on("click", function(){
	var url = "/deleteNote.do";
	var no = $("#no").val();
	
});


//아작스 시작
$(document).ajaxStart(function(){
	$.LoadingOverlay("show", {
		image		: "",
		target		: "aModal",
		fontawesome	: "fa fa-spinner fa-spin"
	});
});


//아작스 종료
$(document).ajaxStop(function(){
	$.LoadingOverlay("hide", {
		image		: "",
		target		: "aModal",
		fontawesome : "fa fa-spinner fa-spin"
	});
});