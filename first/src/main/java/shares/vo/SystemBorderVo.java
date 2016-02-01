package shares.vo;


/**
 * @author	rockys
 * @tip		설명 : 시스템  결과 value Object 이다
 * 			1. 생성규칙 : 반드시 접근제어자는 private 이다
 * 			2. 화면단 제어 확장을 위해 CommonVo 를 반드시 상속 받는다
 * 			3. CommonVo 는  파일, 페이징 기본 param, 화면단 처리 data 를 가지고 있음
 * 			4. vo 는 반드시 DB 스키마, view input in,name 과 일치 한다
 * 			5. 컬럼 추가시 반드시 주석 작성한다
 */
public class SystemBorderVo extends CommonVo{
	private	String no = "";				// 시스템코드 번호
	private String title = "";			// 게시판 명
	private String type = "";			// 게시판 구분
	private String authority = "";		// 게시판 권한
	private String rippleUser = "";		// 리플 사용유무
	private String fileUser = "";		// 파일 사용유무
	private String sort = "";			// 정렬순서
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getRippleUser() {
		return rippleUser;
	}
	public void setRippleUser(String rippleUser) {
		this.rippleUser = rippleUser;
	}
	public String getFileUser() {
		return fileUser;
	}
	public void setFileUser(String fileUser) {
		this.fileUser = fileUser;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	
}
