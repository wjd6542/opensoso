/**
 * 설명	: 유저 메니서 스크립트
 * 작성자	: 강정권
 * 작설일자	: 2016-01-21
 */


// 회원가입
$(".join").on("click",function(){
	// 유효성 검사
	if($.util.nullCheck("joinCk","약관동의는 필수입니다.")) return false;
	if($.util.nullCheck("ssnCk","약관동의는 필수입니다.")) return false;
	
	$(location).attr('href',"/join.do");
});


// 라디오박스 전체 체크
$(".allCheck").on("click",function(){
	// 체크가 안되어있다면.
	$("input:radio[name='joinCk'][value='Y']").attr("checked",true);
	$("input:radio[name='ssnCk'][value='Y']").attr("checked",true);
});


//라디오박스 전체 체크
$(".simpleJoin").on("click",function(){
	var url = "/simpleJoin.do";
	$(location).attr('href',url);
});
