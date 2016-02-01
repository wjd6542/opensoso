/**
 * 설명	: 게시판 리스트 스크립트
 * 작성자	: 강정권
 * 작설일자	: 2016-01-21
 */


/**
 * 설명 : 노드 설정 함수
 */
$('#summernote').summernote({
	height: 400,
	minHeight: null,
	maxHeight: 400,
	focus: true,
	lang: 'ko-KR',
	toolbar: [
		['style', ['style','fontsize','color' ]],
		['style', ['bold', 'italic', 'underline', 'strikethrough', 'clear']],
		['table', ['table','link','codeview']],
		['help', ['fullscreen','undo','redo','help']],
	],
});


// 툴바 항목 삽입
function toolbar(){
	var str = "";
	str += "<div class='note-btn-group btn-group note-help'>";
		str +="<button type='button' class='codeAdd note-btn btn btn-default btn-sm' data-toggle='tooltip' title='코드추가'>";
			str += "<i class='fa fa-code'></i> 코드추가";
		str += "</button>";
	str += "</div>";
	$(".note-toolbar:last:eq(0)").append(str);
}
toolbar();


// 코드 추가 모달 호출
$(".codeAdd").on("click", function(){
	$('#aModal').modal("show");
});

// 메모 영역에 코드 추가
$(".codeAddend").on("click", function(){
	var text = $('#text').val();
	var val = $('#summernote').summernote("code");
	$('#summernote').summernote("code", val + "<p></p><pre>" + text + "</pre><p></p>");
	$('#text').val("");
	$('#aModal').modal("hide");
});


// 파일 항목 추가
$(".fileAdd").on("click", function(){
	var str = "";
	var size = $(".fileList").length;
	var $target = $(".addlist");
	if(size < 5){
		str += "<div class='fileList list-group-item'>";
			str += "<div class='row'>";
				str += "<div class='col-xs-12 col-sm-12'>";
					str += "<div class='input-group'>";
						str += "<input type='file' class='form-control' id='file' name='file' multiple='multiple'>";
						str += "<span class='input-group-btn'>";
							str += "<span class='fileDelete btn btn-danger'>";
								str += "<i class='fa fa-times-circle-o'></i> 삭제";
							str += "</span>";
						str += "</span>";
					str += "</div>";
				str += "</div>";
			str += "</div>";
		str += "</div>";
		$target.append(str);
	}else{
		alert("5개이상 업로드 할수 없습니다.");
	}
});


// 작성
$(".insert,.update,.delete").on("click",function(){
	var url = "/borderAction.do";
	var form = {};
	var actionType = $(this).attr("contextmenu");
	var borderType = $("#borderType").val();
	
	// 노트에서 생성된 코드를 momo로 이동
	$('#memo').val($('#summernote').summernote("code"));
	
	// 액션 구분
	if(actionType == "insert" || actionType == "update"){
		// 유효성 검사
		if($.util.nullCheck("title","제목 을 입력해 주세요")) return false;
		if($.util.nullCheck("memo","내용 을 입력해 주세요")) return false;
		ajax = true;
	}else{
		if(confirm("삭제하시겠습니까 ?")){
			$("#actionType").val("delete");
			ajax = true;
		}else{
			return true;
		}
	}
	
	form = new FormData($("#form")[0]);
	
	if(ajax = true){
		// 아작스 통신
		$.ajax({
			url: url,
			type: "POST",
			data: form,
			async: false,
			cache: false,
			contentType: false,
			processData: false,
			// 성공
			success:  function(data){
				if(data.code == "SUCC"){
					alert(data.msg);
					$("#form").attr("action","/borderList.do");
					$("#form").submit();
				}else{
					alert(data.msg);
				}
			},
			// 실패
			error:function(request,status,error){
				alert("시스템 에러 입니다. 에러코드 : "+request.status);
			}
		});
	}
});


// 스크롤시 리모콘 이동
$(window).scroll(function(){
	var borderWid = parseInt($(".borderArr").css("width"));
	$(".remocon").css("left", borderWid + 250 + "px");
	$(".remocon").css("width", 179 + "px");
	$(".remocon").css("position","fixed");
	var surrPosition = parseInt($(".remocon").css("top"));
	var position = $(window).scrollTop();
	$(".remocon").stop().animate({top : position + surrPosition + "px"}, 1000);
});


//파일 항목 삭제
$(document).on("click",".fileDelete",function(){
	var url = "/fileDelete.do";
	var no = $(this).attr("dir");
	var fileName = $(this).attr("contextmenu");
	var result = {no : no, fileName : fileName};
	// 로드 된게 아님
	if(no != undefined){
		$.util.ajaxAlert(url, result);
	}
	$(this).parents(".fileList").remove();
});


$(document).ajaxStart(function(){
	$.LoadingOverlay("show", {
		image		: "",
		target		: "",
		fontawesome	: "fa fa-spinner fa-spin"
	});
});

$(document).ajaxStop(function(){
	$.LoadingOverlay("hide", {
		image		: "",
		target		: "",
		fontawesome : "fa fa-spinner fa-spin"
	});
});