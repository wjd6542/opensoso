// 자바스크립트 인클루드 합수를 생성
function includeCss(fileSrc)
{
	var head = document.getElementsByTagName('head')[0];
	var style = document.createElement("link");
	style.type = "text/css";
	style.rel = "stylesheet";
	style.href = fileSrc;
	head.appendChild(style);
}



/* 부트스트랩 */
includeCss('css/bootstrap.css');						// 제이쿼리
includeCss('css/bootstrap-toggle.css');					// 제이쿼리 쿠키
includeCss('css/bootstrap-datepicker.css');				// 제이쿼리 트리뷰 

/* 제이쿼리 */
includeCss('css/dashboard.css');						// 제이쿼리 디쉬보드
includeCss('css/jquery.treeview.css');					// 제이쿼리 트리뷰
includeCss('css/table/jquery.dataTables.css');			// 제이쿼리 테이블
includeCss('css/jqtree.css');							// 제이쿼리 트리
includeCss('css/jquery.treeselect.css');							// 제이쿼리 트리

/* 사용자 생성 */
includeCss('css/screen.css');							// 부트스트랩
includeCss('css/common.css');							// 부트스트랩 달력