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
public class SystemVo extends CommonVo{
	private	String no = "";				// 시스템코드 번호
	private	String systemCode = "";		// 시스템  코드
	private String code = "";			// 코드
	private String title = "";			// 코드 설명
	private String memo = "";			// 메모
	private String sort = "";			// 정렬순서
	private String status = "";			// 상태
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getSystemCode() {
		return systemCode;
	}
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
}
