/**
 * 설명	: index, login 스크립트
 * 작성자	: 강정권
 * 작설일자	: 2016-01-21
 */


// 메인이미지 롤링
$(document).ready(function ()
{
	// 롤링 소스
	var rollingTime = 2500;		// 롤링시간
	var effectTime = 1500;		// 실행시간
	var $rollingImg = $(".mains > div");
	$rollingImg.not(":first").hide();
	setInterval(rolling, rollingTime);
	
	// 롤링 함수
	function rolling(){
		$visbleImg = $rollingImg.filter(":visible");
		$visbleImg.fadeOut(effectTime);
		$nextImg = $visbleImg.next();
		if($nextImg.length === 0)
		{
			$nextImg = $rollingImg.filter(":first");
		}
		$visbleImg.hide();
		$nextImg.fadeIn(effectTime);
	}
});


//게시판 이동
$(".view").on("click", function(){
	var url = "/borderView.do";
	var borderNo = $(this).attr("dir");
	var borderType = $(this).attr("contextmenu");
	$("#borderType").val(borderType);
	$("#borderNo").val(borderNo);
	$("#form").attr("action", url);
	$("#form").submit();
});