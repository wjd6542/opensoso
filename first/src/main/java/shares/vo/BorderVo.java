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
public class BorderVo extends CommonVo{
	private	String no = "";				// 게시글 번호
	private	String sysNo = "";			// 게시판 설정 번호
	private	String userNo = "";			// 고객 번호
	private	String title = "";			// 제목
	private	String borderType = "";		// 게시글 구분
	private	String saveDate = "";		// 저장일자
	private	String saveTime = "";		// 저장시간
	private	String interest = "";		// 관심사
	private	String hitCnt = "";			// 조회수
	private	String rippleCnt = "";		// 리플수
	private	String goodCnt = "";		// 추천수
	private	String memo = "";			// 메모
	private	String status = "";			// 저장상대 Y : N
	
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
	 * @return the sysNo
	 */
	public String getSysNo() {
		return sysNo;
	}
	/**
	 * @param sysNo the sysNo to set
	 */
	public void setSysNo(String sysNo) {
		this.sysNo = sysNo;
	}
	/**
	 * @return the userNo
	 */
	public String getUserNo() {
		return userNo;
	}
	/**
	 * @param userNo the userNo to set
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the borderType
	 */
	public String getBorderType() {
		return borderType;
	}
	/**
	 * @param borderType the borderType to set
	 */
	public void setBorderType(String borderType) {
		this.borderType = borderType;
	}
	/**
	 * @return the saveDate
	 */
	public String getSaveDate() {
		return saveDate;
	}
	/**
	 * @param saveDate the saveDate to set
	 */
	public void setSaveDate(String saveDate) {
		this.saveDate = saveDate;
	}
	/**
	 * @return the saveTime
	 */
	public String getSaveTime() {
		return saveTime;
	}
	/**
	 * @param saveTime the saveTime to set
	 */
	public void setSaveTime(String saveTime) {
		this.saveTime = saveTime;
	}
	/**
	 * @return the interest
	 */
	public String getInterest() {
		return interest;
	}
	/**
	 * @param interest the interest to set
	 */
	public void setInterest(String interest) {
		this.interest = interest;
	}
	/**
	 * @return the hitCnt
	 */
	public String getHitCnt() {
		return hitCnt;
	}
	/**
	 * @param hitCnt the hitCnt to set
	 */
	public void setHitCnt(String hitCnt) {
		this.hitCnt = hitCnt;
	}
	/**
	 * @return the rippleCnt
	 */
	public String getRippleCnt() {
		return rippleCnt;
	}
	/**
	 * @param rippleCnt the rippleCnt to set
	 */
	public void setRippleCnt(String rippleCnt) {
		this.rippleCnt = rippleCnt;
	}
	/**
	 * @return the goodCnt
	 */
	public String getGoodCnt() {
		return goodCnt;
	}
	/**
	 * @param goodCnt the goodCnt to set
	 */
	public void setGoodCnt(String goodCnt) {
		this.goodCnt = goodCnt;
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
