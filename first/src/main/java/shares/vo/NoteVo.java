package shares.vo;

/**
 * @author	rockys
 * @tip		설명 : 파일 value Object 이다 
 * 			1. 생성규칙 : 반드시 접근제어자는 private 이다
 * 			2. 화면단 제어 확장을 위해 CommonVo 를 반드시 상속 받는다
 * 			3. CommonVo 는  파일, 페이징 기본 param, 화면단 처리 data 를 가지고 있음
 *			4. vo 는 반드시 DB 스키마, view input in,name 과 일치 한다
 *			5. 컬럼 추가시 반드시 주석 작성한다
 */
public class NoteVo extends CommonVo {
	private String no = "";				// 번호
	private String userNo = "";			// 고객번호
	private String toId = "";			// 보내는 사랑 id
	private String toName = "";			// 보내는 사랑
	private String fromId = "";			// 받는 사랑 id
	private String title = "";			// 제목
	private String memo = "";			// 내용
	private String sendDate = "";		// 보낸 날짜
	private String sendTime = "";		// 보낸 시간
	private String readDate = "";		// 읽은 날짜
	private String readTime = "";		// 읽은 시간
	private String saveDate = "";		// 저장일자
	private String saveTime = "";		// 저장시간
	private String saveStatus = "";		// 일기상태 R : N
	private String status = "";			// 저장상태 Y : N
	
	
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
	 * @return the toId
	 */
	public String getToId() {
		return toId;
	}
	/**
	 * @param toId the toId to set
	 */
	public void setToId(String toId) {
		this.toId = toId;
	}
	/**
	 * @return the toName
	 */
	public String getToName() {
		return toName;
	}
	/**
	 * @param toName the toName to set
	 */
	public void setToName(String toName) {
		this.toName = toName;
	}
	/**
	 * @return the fromId
	 */
	public String getFromId() {
		return fromId;
	}
	/**
	 * @param fromId the fromId to set
	 */
	public void setFromId(String fromId) {
		this.fromId = fromId;
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
	 * @return the sendDate
	 */
	public String getSendDate() {
		return sendDate;
	}
	/**
	 * @param sendDate the sendDate to set
	 */
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	/**
	 * @return the sendTime
	 */
	public String getSendTime() {
		return sendTime;
	}
	/**
	 * @param sendTime the sendTime to set
	 */
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	/**
	 * @return the readDate
	 */
	public String getReadDate() {
		return readDate;
	}
	/**
	 * @param readDate the readDate to set
	 */
	public void setReadDate(String readDate) {
		this.readDate = readDate;
	}
	/**
	 * @return the readTime
	 */
	public String getReadTime() {
		return readTime;
	}
	/**
	 * @param readTime the readTime to set
	 */
	public void setReadTime(String readTime) {
		this.readTime = readTime;
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
	 * @return the saveStatus
	 */
	public String getSaveStatus() {
		return saveStatus;
	}
	/**
	 * @param saveStatus the saveStatus to set
	 */
	public void setSaveStatus(String saveStatus) {
		this.saveStatus = saveStatus;
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
