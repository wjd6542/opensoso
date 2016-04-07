package shares.vo;


/**
 * @author	rockys
 * @tip		설명 : 부서관리 value Object 이다
 * 			1. 생성규칙 : 반드시 접근제어자는 private 이다
 * 			2. 화면단 제어 확장을 위해 CommonVo 를 반드시 상속 받는다
 * 			3. CommonVo 는  파일, 페이징 기본 param, 화면단 처리 data 를 가지고 있음
 * 			4. vo 는 반드시 DB 스키마, view input id,name 과 일치 한다
 * 			5. 컬럼 추가시 반드시 주석 작성한다
 */
public class BranchVo extends CommonVo{
	private	String no = "";				// 게시글 번호
	private	String name = "";			// 부서명
	private	String code = "";			// 부서코드
	private	String sort = "";			// 정렬순서
	private	String grupNo = "";			// 그룹 번호
	private	String depthNo = "";		// 깊이
	private	String memo = "";			// 메모
	private	String status = "";			// 상태
	
	/**
	 * @return the no
	 */
	public String getNo() {
		return no;
	}
	/**
	 * @param no the no to set
	 */
	public void setNo(String no) {
		this.no = no;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the sort
	 */
	public String getSort() {
		return sort;
	}
	/**
	 * @param sort the sort to set
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}
	/**
	 * @return the grupNo
	 */
	public String getGrupNo() {
		return grupNo;
	}
	/**
	 * @param grupNo the grupNo to set
	 */
	public void setGrupNo(String grupNo) {
		this.grupNo = grupNo;
	}
	/**
	 * @return the depthNo
	 */
	public String getDepthNo() {
		return depthNo;
	}
	/**
	 * @param depthNo the depthNo to set
	 */
	public void setDepthNo(String depthNo) {
		this.depthNo = depthNo;
	}
	/**
	 * @return the memo
	 */
	public String getMemo() {
		return memo;
	}
	/**
	 * @param memo the memo to set
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
