/**
 * 설명 : 자바스크립트 추가 함수
 * @param filename
 */
function includeJs(filename)
{
	var head = document.getElementsByTagName('head')[0];
	script = document.createElement('script');
	script.src = filename;
	script.type = 'text/javascript';
	head.appendChild(script);
}

includeJs('js/jquery.js');								// 제이쿼리
includeJs('js/jquery.cookie.js');						// 제이쿼리 쿠키
//includeJs('js/jquery.treeview.js');						// 제이쿼리 트리뷰 
//includeJs('js/tree.jquery.js');							// 제이쿼리 트리
//includeJs('js/table/jquery.dataTables.min.js');			// 제이쿼리 테이블 설정 함수
//includeJs('js/jquery.treeselect.js');					// 제이쿼리 트리
//includeJs('js/jquery.treeselect.min.js');				// 제이쿼리 트리


includeJs('js/bootstrap.js');							// 부트스트랩
includeJs('js/bootstrap-toggle.js');					// 부트스트랩 토글
includeJs('js/bootstrap-datepicker.js');				// 부트스트랩 달력


includeJs('js/holder.js');								// 사이드메뉴 js
includeJs('js/util/function.js');						// 사용자 정의 함수
//includeJs('js/util/zipcode.js');						// 우편번호 검색 함수
//includeJs('js/util/map.js');							// 지도 함수