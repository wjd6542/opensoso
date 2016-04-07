/**
 * 섬명 : 프로젝트 적용되는 js 파일 전체를 관리한다.
 * @author rocky
 */
requirejs.config({
	
	/**
	 * 섬명 : 적용 라이브러리 기본경로를 설정한다.
	 */
	baseUrl: 'js',
	
	
	/**
	 * 설명 : js 라이브버리 경로 설정 js 확장자는 붙이지 않는다.
	 */
	paths:{
		//뒤에 js 확장자는 생략한다.
		'jquery': './jquery/jquery',
		'alert': './jquery/alertify.min',
		'cookie': './jquery/cookie',
		'dataTables' : './jquery/dataTables.min',
		'fileDownload' : './jquery/fileDownload',
		'form' : './jquery/form',
		'loadingoverlay' : './jquery/loadingoverlay',
		'summernote' : './jquery/summernote',
		'summernote_kr' : './jquery/summernote_kr',
		
		'bootstrap' : './js/bootstrap/bootstrap',
		'bootstrap_toggle' : './js/bootstrap/bootstrap_toggle',
		'bootstrap_datepicker' : './js/bootstrap/bootstrap_datepicker',
		'functions' : './js/util/functions',
		'holder' : './js/holder',
	},

	
	/**
	 * 설명 : shim: AMD 형식을 지원하지 않는 라이브러리의 경우 아래와 같이 shim을 사용해서 모듈로 불러올 수 있다.
	 * 로드전 의존관계 설정진행
	 */
	shim:{
		'summernote_kr':{
			deps: ['jquery','summernote'],
		},
		'bootstrap_datepicker':{
			deps: ['jquery','bootstrap'],
		}
	},
	
	
	/**
	 * 설명 :모듈의 로딩 시간을 지정한다. 이 시간을 초과하면 Timeout Error 가 throw 된다
	 */
	waitSeconds: 15
});

//requireJS를 활용하여 모듈 로드
requirejs( [
	//디펜던시가 걸려있으므로, 이 디펜던시들이 먼저 로드된 뒤에 아래 콜백이 수행된다.
	"jquery","alert","cookie","dataTables","fileDownload","form","loadingoverlay","summernote","summernote_kr"
	],function ($, alert, cookie, dataTables, fileDownload, form, loadingoverlay, summernote, summernote_kr) {
		
	}
);