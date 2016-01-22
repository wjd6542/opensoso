package shares.vo;


/**
 * @author	rockys
 * @tip		설명 : 권한 value Object 이다
 * 			1. 생성규칙 : 반드시 접근제어자는 private 이다
 * 			2. 화면단 제어 확장을 위해 CommonVo 를 반드시 상속 받는다
 * 			3. CommonVo 는  파일, 페이징 기본 param, 화면단 처리 data 를 가지고 있음
 * 			4. vo 는 반드시 DB 스키마, view input id, name 과 일치 한다
 * 			5. 컬럼 추가시 반드시 주석 작성한다
 */
public class AuthorityVo extends CommonVo{
	private String no = "";		// 권한 번호
	private String code = "";	// 코드
	private String type = "";	// 권한구분
	private String title = "";	// 권한제목
	private String sort = "";	// 정렬순서
	private String memo = "";	// 권한 설명
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
}
